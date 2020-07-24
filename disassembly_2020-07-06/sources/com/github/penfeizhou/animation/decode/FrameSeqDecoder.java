package com.github.penfeizhou.animation.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.github.penfeizhou.animation.executor.FrameDecoderExecutor;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.Writer;
import com.github.penfeizhou.animation.loader.Loader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public abstract class FrameSeqDecoder<R extends Reader, W extends Writer> {
    public static final boolean DEBUG = false;
    /* access modifiers changed from: private */
    public static final Rect RECT_EMPTY = new Rect();
    private static final String TAG = FrameSeqDecoder.class.getSimpleName();
    private Set<Bitmap> cacheBitmaps = new HashSet();
    protected Map<Bitmap, Canvas> cachedCanvas = new WeakHashMap();
    private boolean finished = false;
    protected ByteBuffer frameBuffer;
    protected int frameIndex = -1;
    protected List<Frame> frames = new ArrayList();
    protected volatile Rect fullRect;
    private Integer loopLimit = null;
    /* access modifiers changed from: private */
    public final Loader mLoader;
    /* access modifiers changed from: private */
    public R mReader = null;
    private volatile State mState = State.IDLE;
    private W mWriter = getWriter();
    /* access modifiers changed from: private */
    public AtomicBoolean paused = new AtomicBoolean(true);
    private int playCount;
    /* access modifiers changed from: private */
    public final RenderListener renderListener;
    private Runnable renderTask = new Runnable() {
        public void run() {
            if (!FrameSeqDecoder.this.paused.get()) {
                if (FrameSeqDecoder.this.canStep()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    FrameSeqDecoder.this.workerHandler.postDelayed(this, Math.max(0, FrameSeqDecoder.this.step() - (System.currentTimeMillis() - currentTimeMillis)));
                    FrameSeqDecoder.this.renderListener.onRender(FrameSeqDecoder.this.frameBuffer);
                    return;
                }
                FrameSeqDecoder.this.stop();
            }
        }
    };
    protected int sampleSize = 1;
    private final int taskId;
    /* access modifiers changed from: private */
    public final Handler workerHandler;

    public interface RenderListener {
        void onEnd();

        void onRender(ByteBuffer byteBuffer);

        void onStart();
    }

    private enum State {
        IDLE,
        RUNNING,
        INITIALIZING,
        FINISHING
    }

    private String debugInfo() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract int getLoopCount();

    /* access modifiers changed from: protected */
    public abstract R getReader(Reader reader);

    /* access modifiers changed from: protected */
    public abstract W getWriter();

    /* access modifiers changed from: protected */
    public abstract Rect read(R r) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void release();

    /* access modifiers changed from: protected */
    public abstract void renderFrame(Frame frame);

    /* access modifiers changed from: protected */
    public Bitmap obtainBitmap(int i, int i2) {
        Iterator<Bitmap> it = this.cacheBitmaps.iterator();
        Bitmap bitmap = null;
        while (it.hasNext()) {
            int i3 = i * i2 * 4;
            Bitmap next = it.next();
            if (Build.VERSION.SDK_INT >= 19) {
                if (next != null && next.getAllocationByteCount() >= i3) {
                    it.remove();
                    if (!(next.getWidth() == i && next.getHeight() == i2)) {
                        next.reconfigure(i, i2, Bitmap.Config.ARGB_8888);
                    }
                    next.eraseColor(0);
                    return next;
                }
            } else if (next != null && next.getByteCount() >= i3) {
                if (next.getWidth() == i && next.getHeight() == i2) {
                    it.remove();
                    next.eraseColor(0);
                }
                return next;
            }
            bitmap = next;
        }
        try {
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return bitmap;
        }
    }

    /* access modifiers changed from: protected */
    public void recycleBitmap(Bitmap bitmap) {
        if (bitmap != null && !this.cacheBitmaps.contains(bitmap)) {
            this.cacheBitmaps.add(bitmap);
        }
    }

    public FrameSeqDecoder(Loader loader, RenderListener renderListener2) {
        this.mLoader = loader;
        this.renderListener = renderListener2;
        this.taskId = FrameDecoderExecutor.getInstance().generateTaskId();
        this.workerHandler = new Handler(FrameDecoderExecutor.getInstance().getLooper(this.taskId));
    }

    public Rect getBounds() {
        if (this.fullRect != null) {
            return this.fullRect;
        }
        if (this.mState == State.FINISHING) {
            Log.e(TAG, "In finishing,do not interrupt");
        }
        final Thread currentThread = Thread.currentThread();
        this.workerHandler.post(new Runnable() {
            public void run() {
                try {
                    if (FrameSeqDecoder.this.fullRect == null) {
                        if (FrameSeqDecoder.this.mReader == null) {
                            Reader unused = FrameSeqDecoder.this.mReader = FrameSeqDecoder.this.getReader(FrameSeqDecoder.this.mLoader.obtain());
                        } else {
                            FrameSeqDecoder.this.mReader.reset();
                        }
                        FrameSeqDecoder.this.initCanvasBounds(FrameSeqDecoder.this.read(FrameSeqDecoder.this.mReader));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    FrameSeqDecoder.this.fullRect = FrameSeqDecoder.RECT_EMPTY;
                } catch (Throwable th) {
                    LockSupport.unpark(currentThread);
                    throw th;
                }
                LockSupport.unpark(currentThread);
            }
        });
        LockSupport.park(currentThread);
        return this.fullRect;
    }

    /* access modifiers changed from: private */
    public void initCanvasBounds(Rect rect) {
        this.fullRect = rect;
        int width = rect.width() * rect.height();
        int i = this.sampleSize;
        this.frameBuffer = ByteBuffer.allocate(((width / (i * i)) + 1) * 4);
        if (this.mWriter == null) {
            this.mWriter = getWriter();
        }
    }

    private int getFrameCount() {
        return this.frames.size();
    }

    public void start() {
        if (this.fullRect != RECT_EMPTY) {
            if (this.mState == State.RUNNING || this.mState == State.INITIALIZING) {
                String str = TAG;
                Log.i(str, debugInfo() + " Already started");
                return;
            }
            if (this.mState == State.FINISHING) {
                String str2 = TAG;
                Log.e(str2, debugInfo() + " Processing,wait for finish at " + this.mState);
            }
            this.mState = State.INITIALIZING;
            if (Looper.myLooper() == this.workerHandler.getLooper()) {
                innerStart();
            } else {
                this.workerHandler.post(new Runnable() {
                    public void run() {
                        FrameSeqDecoder.this.innerStart();
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void innerStart() {
        this.paused.compareAndSet(true, false);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.frames.size() == 0) {
                if (this.mReader == null) {
                    this.mReader = getReader(this.mLoader.obtain());
                } else {
                    this.mReader.reset();
                }
                initCanvasBounds(read(this.mReader));
            }
        } catch (Throwable th) {
            String str = TAG;
            Log.i(str, debugInfo() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
            this.mState = State.RUNNING;
            throw th;
        }
        String str2 = TAG;
        Log.i(str2, debugInfo() + " Set state to RUNNING,cost " + (System.currentTimeMillis() - currentTimeMillis));
        this.mState = State.RUNNING;
        if (getNumPlays() == 0 || !this.finished) {
            this.frameIndex = -1;
            this.renderTask.run();
            this.renderListener.onStart();
            return;
        }
        String str3 = TAG;
        Log.i(str3, debugInfo() + " No need to started");
    }

    /* access modifiers changed from: private */
    public void innerStop() {
        this.workerHandler.removeCallbacks(this.renderTask);
        this.frames.clear();
        for (Bitmap next : this.cacheBitmaps) {
            if (next != null && !next.isRecycled()) {
                next.recycle();
            }
        }
        this.cacheBitmaps.clear();
        if (this.frameBuffer != null) {
            this.frameBuffer = null;
        }
        this.cachedCanvas.clear();
        try {
            if (this.mReader != null) {
                this.mReader.close();
                this.mReader = null;
            }
            if (this.mWriter != null) {
                this.mWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        release();
        this.mState = State.IDLE;
        this.renderListener.onEnd();
    }

    public void stop() {
        if (this.fullRect != RECT_EMPTY) {
            if (this.mState == State.FINISHING || this.mState == State.IDLE) {
                String str = TAG;
                Log.i(str, debugInfo() + "No need to stop");
                return;
            }
            if (this.mState == State.INITIALIZING) {
                String str2 = TAG;
                Log.e(str2, debugInfo() + "Processing,wait for finish at " + this.mState);
            }
            this.mState = State.FINISHING;
            if (Looper.myLooper() == this.workerHandler.getLooper()) {
                innerStop();
            } else {
                this.workerHandler.post(new Runnable() {
                    public void run() {
                        FrameSeqDecoder.this.innerStop();
                    }
                });
            }
        }
    }

    public boolean isRunning() {
        return this.mState == State.RUNNING || this.mState == State.INITIALIZING;
    }

    public boolean isPaused() {
        return this.paused.get();
    }

    public void setLoopLimit(int i) {
        this.loopLimit = Integer.valueOf(i);
    }

    public void reset() {
        this.playCount = 0;
        this.frameIndex = -1;
        this.finished = false;
    }

    public void pause() {
        this.workerHandler.removeCallbacks(this.renderTask);
        this.paused.compareAndSet(false, true);
    }

    public void resume() {
        this.paused.compareAndSet(true, false);
        this.workerHandler.removeCallbacks(this.renderTask);
        this.workerHandler.post(this.renderTask);
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public void setDesiredSize(int i, int i2) {
        int desiredSample = getDesiredSample(i, i2);
        if (desiredSample != this.sampleSize) {
            this.sampleSize = desiredSample;
            final boolean isRunning = isRunning();
            this.workerHandler.removeCallbacks(this.renderTask);
            this.workerHandler.post(new Runnable() {
                public void run() {
                    FrameSeqDecoder.this.innerStop();
                    try {
                        FrameSeqDecoder.this.initCanvasBounds(FrameSeqDecoder.this.read(FrameSeqDecoder.this.getReader(FrameSeqDecoder.this.mLoader.obtain())));
                        if (isRunning) {
                            FrameSeqDecoder.this.innerStart();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public int getDesiredSample(int i, int i2) {
        int i3 = 1;
        if (i != 0 && i2 != 0) {
            int min = Math.min(getBounds().width() / i, getBounds().height() / i2);
            while (true) {
                int i4 = i3 * 2;
                if (i4 > min) {
                    break;
                }
                i3 = i4;
            }
        }
        return i3;
    }

    private int getNumPlays() {
        Integer num = this.loopLimit;
        return num != null ? num.intValue() : getLoopCount();
    }

    /* access modifiers changed from: private */
    public boolean canStep() {
        if (!isRunning() || this.frames.size() == 0) {
            return false;
        }
        if (getNumPlays() <= 0 || this.playCount < getNumPlays() - 1) {
            return true;
        }
        if (this.playCount == getNumPlays() - 1 && this.frameIndex < getFrameCount() - 1) {
            return true;
        }
        this.finished = true;
        return false;
    }

    /* access modifiers changed from: private */
    public long step() {
        this.frameIndex++;
        if (this.frameIndex >= getFrameCount()) {
            this.frameIndex = 0;
            this.playCount++;
        }
        Frame frame = getFrame(this.frameIndex);
        if (frame == null) {
            return 0;
        }
        renderFrame(frame);
        return (long) frame.frameDuration;
    }

    private Frame getFrame(int i) {
        if (i < 0 || i >= this.frames.size()) {
            return null;
        }
        return this.frames.get(i);
    }
}
