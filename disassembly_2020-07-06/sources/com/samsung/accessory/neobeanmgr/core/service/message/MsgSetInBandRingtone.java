package com.samsung.accessory.neobeanmgr.core.service.message;

public class MsgSetInBandRingtone extends Msg {
    public byte status;

    MsgSetInBandRingtone(byte[] bArr) {
        super(bArr);
        this.status = bArr[getDataStartIndex()];
    }
}
