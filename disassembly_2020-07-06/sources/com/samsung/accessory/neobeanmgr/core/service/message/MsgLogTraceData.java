package com.samsung.accessory.neobeanmgr.core.service.message;

import android.util.Log;
import com.samsung.accessory.neobeanmgr.common.util.BufferBuilder;
import java.nio.ByteBuffer;

public class MsgLogTraceData extends Msg {
    private static final String TAG = "NeoBean_MsgLogTraceData";
    public int dataOffset;
    public int dataSize;
    public int partialDataOffset;
    public int partialDataSize;
    public byte[] rawData;

    MsgLogTraceData(byte[] bArr) {
        super(bArr);
        ByteBuffer recvDataByteBuffer = getRecvDataByteBuffer();
        this.partialDataOffset = recvDataByteBuffer.getInt();
        this.partialDataSize = recvDataByteBuffer.getShort();
        this.rawData = new byte[this.partialDataSize];
        recvDataByteBuffer.get(this.rawData);
        Log.d(TAG, "MSG_ID_LOG_TRACE_DATA: partialDataOffset:  " + this.partialDataOffset + ", partialDataSize : " + this.partialDataSize);
    }

    public MsgLogTraceData(int i, int i2) {
        super((byte) MsgID.LOG_TRACE_DATA);
        Log.d(TAG, "MSG_ID_LOG_TRACE_DATA: offset:  " + i + ", size : " + i2);
        this.dataOffset = i;
        this.dataSize = i2;
    }

    public byte[] getData() {
        BufferBuilder bufferBuilder = new BufferBuilder();
        bufferBuilder.putInt(this.dataOffset);
        bufferBuilder.putInt(this.dataSize);
        return bufferBuilder.array();
    }
}
