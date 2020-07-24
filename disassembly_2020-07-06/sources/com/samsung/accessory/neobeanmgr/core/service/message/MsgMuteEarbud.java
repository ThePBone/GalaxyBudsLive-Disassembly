package com.samsung.accessory.neobeanmgr.core.service.message;

public class MsgMuteEarbud extends Msg {
    public boolean leftStatus;
    public boolean rightStatus;

    public MsgMuteEarbud(boolean z, boolean z2) {
        super((byte) MsgID.MUTE_EARBUD);
        this.leftStatus = z;
        this.rightStatus = z2;
    }

    public byte[] getData() {
        return new byte[]{this.leftStatus, this.rightStatus};
    }
}
