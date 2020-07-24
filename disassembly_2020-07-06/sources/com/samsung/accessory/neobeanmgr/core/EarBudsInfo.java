package com.samsung.accessory.neobeanmgr.core;

import android.util.Log;

public class EarBudsInfo {
    private static final String TAG = "NeoBean_EarBudsInfo";
    public String address;
    public boolean adjustSoundSync;
    public int batteryCase;
    public int batteryI;
    public int batteryL;
    public int batteryR;
    public int colorL;
    public int colorR;
    public boolean coupled;
    public String debugInfo;
    public String debugSelfTest;
    public int deviceColor;
    public String deviceSWVer;
    public int equalizerType;
    public int extendedRevision;
    public boolean extraHighAmbient;
    public int fmmRevision;
    public boolean leftCheckTheFitResult;
    public boolean leftMuteStatus;
    private int mBatteryIL;
    private int mBatteryIR;
    public boolean noiseReduction;
    public boolean outsideDoubleTap;
    public boolean passThrough;
    public int placementL;
    public int placementR;
    public boolean resetOfSetFmmConfig;
    public boolean resultOfReset;
    public boolean rightCheckTheFitResult;
    public boolean rightMuteStatus;
    public boolean seamlessConnection;
    public String serialNumber_left;
    public String serialNumber_right;
    public boolean sideToneStatus;
    public String sku_left;
    public String sku_right;
    public boolean touchpadLocked;
    public int touchpadOptionLeft;
    public int touchpadOptionRight;
    public boolean voiceWakeUp;
    public int voiceWakeUpLanguage;
    public boolean wearingL;
    public boolean wearingR;

    public void calcBatteryIntegrated() {
        int i;
        int i2;
        int i3 = -1;
        if (this.batteryL <= 0 || this.batteryR <= 0) {
            i = -1;
        } else {
            boolean z = true;
            boolean z2 = this.placementL >= 3;
            if (this.placementR < 3) {
                z = false;
            }
            i = ((z2 == z || (this.mBatteryIL == this.batteryL && this.mBatteryIR == this.batteryR)) && Math.abs(this.batteryR - this.batteryL) < 15) ? Math.min(this.batteryL, this.batteryR) : -1;
            if (i == -1) {
                i2 = -1;
            } else {
                i2 = this.batteryL;
            }
            this.mBatteryIL = i2;
            if (i != -1) {
                i3 = this.batteryR;
            }
            this.mBatteryIR = i3;
        }
        Log.d(TAG, "calcBatteryIntegrated() : " + i + " (batteryL=" + this.batteryL + ", batteryR=" + this.batteryR + " / mBatteryIL=" + this.mBatteryIL + ", mBatteryIR=" + this.mBatteryIR + ")");
        this.batteryI = i;
    }
}
