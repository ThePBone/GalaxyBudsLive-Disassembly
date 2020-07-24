package com.github.penfeizhou.animation.webp.decode;

import android.content.Context;
import com.github.penfeizhou.animation.io.Reader;
import com.github.penfeizhou.animation.io.StreamReader;
import com.github.penfeizhou.animation.webp.io.WebPReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WebPParser {

    static class FormatException extends IOException {
        FormatException() {
            super("WebP Format error");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0020 A[SYNTHETIC, Splitter:B:15:0x0020] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002d A[SYNTHETIC, Splitter:B:24:0x002d] */
    public static boolean isAWebP(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                boolean isAWebP = isAWebP((Reader) new StreamReader(fileInputStream));
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return isAWebP;
            } catch (Exception unused) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th) {
                th = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
            }
            throw th;
        }
    }

    public static boolean isAWebP(Context context, String str) {
        InputStream inputStream = null;
        try {
            InputStream open = context.getAssets().open(str);
            boolean isAWebP = isAWebP((Reader) new StreamReader(open));
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isAWebP;
        } catch (Exception unused) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isAWebP(Context context, int i) {
        InputStream inputStream = null;
        try {
            InputStream openRawResource = context.getResources().openRawResource(i);
            boolean isAWebP = isAWebP((Reader) new StreamReader(openRawResource));
            if (openRawResource != null) {
                try {
                    openRawResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return isAWebP;
        } catch (Exception unused) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean isAWebP(Reader reader) {
        WebPReader webPReader = reader instanceof WebPReader ? (WebPReader) reader : new WebPReader(reader);
        try {
            if (!webPReader.matchFourCC("RIFF")) {
                return false;
            }
            webPReader.skip(4);
            if (!webPReader.matchFourCC("WEBP")) {
                return false;
            }
            while (webPReader.available() > 0) {
                BaseChunk parseChunk = parseChunk(webPReader);
                if (parseChunk instanceof VP8XChunk) {
                    return ((VP8XChunk) parseChunk).animation();
                }
            }
            return false;
        } catch (IOException e) {
            if (!(e instanceof FormatException)) {
                e.printStackTrace();
            }
        }
    }

    public static List<BaseChunk> parse(WebPReader webPReader) throws IOException {
        if (webPReader.matchFourCC("RIFF")) {
            webPReader.skip(4);
            if (webPReader.matchFourCC("WEBP")) {
                ArrayList arrayList = new ArrayList();
                while (webPReader.available() > 0) {
                    arrayList.add(parseChunk(webPReader));
                }
                return arrayList;
            }
            throw new FormatException();
        }
        throw new FormatException();
    }

    static BaseChunk parseChunk(WebPReader webPReader) throws IOException {
        BaseChunk baseChunk;
        int position = webPReader.position();
        int fourCC = webPReader.getFourCC();
        int uInt32 = webPReader.getUInt32();
        if (VP8XChunk.ID == fourCC) {
            baseChunk = new VP8XChunk();
        } else if (ANIMChunk.ID == fourCC) {
            baseChunk = new ANIMChunk();
        } else if (ANMFChunk.ID == fourCC) {
            baseChunk = new ANMFChunk();
        } else if (ALPHChunk.ID == fourCC) {
            baseChunk = new ALPHChunk();
        } else if (VP8Chunk.ID == fourCC) {
            baseChunk = new VP8Chunk();
        } else if (VP8LChunk.ID == fourCC) {
            baseChunk = new VP8LChunk();
        } else if (ICCPChunk.ID == fourCC) {
            baseChunk = new ICCPChunk();
        } else if (XMPChunk.ID == fourCC) {
            baseChunk = new XMPChunk();
        } else if (EXIFChunk.ID == fourCC) {
            baseChunk = new EXIFChunk();
        } else {
            baseChunk = new BaseChunk();
        }
        baseChunk.chunkFourCC = fourCC;
        baseChunk.payloadSize = uInt32;
        baseChunk.offset = position;
        baseChunk.parse(webPReader);
        return baseChunk;
    }
}
