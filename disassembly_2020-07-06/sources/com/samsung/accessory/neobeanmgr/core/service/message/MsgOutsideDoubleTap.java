package com.samsung.accessory.neobeanmgr.core.service.message;

public class MsgOutsideDoubleTap extends Msg {
    public boolean onOff;
    public boolean result;

    public MsgOutsideDoubleTap(byte[] bArr) {
        super(bArr);
        this.result = bArr[getDataStartIndex()] != 1 ? false : true;
    }

    public MsgOutsideDoubleTap(boolean z) {
        super((byte) MsgID.MSG_ID_OUTSIDE_DOUBLE_TAP);
        this.onOff = z;
    }

    public byte[] getData() {
        return new byte[]{this.onOff};
    }
}
