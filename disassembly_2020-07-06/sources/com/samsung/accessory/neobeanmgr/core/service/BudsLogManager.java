package com.samsung.accessory.neobeanmgr.core.service;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.samsung.accessory.neobeanmgr.Application;
import com.samsung.accessory.neobeanmgr.common.uhm.UhmFwUtil;
import com.samsung.accessory.neobeanmgr.common.util.BluetoothUtil;
import com.samsung.accessory.neobeanmgr.common.util.Util;
import com.samsung.accessory.neobeanmgr.common.util.WorkerHandler;
import com.samsung.accessory.neobeanmgr.core.service.message.MsgID;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BudsLogManager {
    private static final String DEVICE_NAME = "Galaxy Buds Live".replace("Galaxy ", "").replaceAll(" ", "_");
    private static final int LOG_A2DP_STATE = 4;
    private static final int LOG_BOND_STATE = 5;
    public static final int LOG_DEVICE_INFO = 6;
    private static final int LOG_HFP_STATE = 3;
    public static final int LOG_RECV = 1;
    public static final int LOG_SEND = 0;
    public static final int LOG_SPP_STATE = 2;
    private static final int SM_MIN_VERSION_CODE_OOS = 247900000;
    private static final int SM_MIN_VERSION_CODE_POS = 360000000;
    private static final String SM_PACKAGE_NAME = "com.samsung.android.voc";
    private static final String TAG = "NeoBean_BudsLogManager";
    private static volatile BudsLogManager instance;
    private String folderPath;
    private final BroadcastReceiver mBluetoothReceiver = new BroadcastReceiver() {
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0055, code lost:
            if (r3.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED") != false) goto L_0x0059;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
        public void onReceive(Context context, Intent intent) {
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice != null) {
                String unused = BudsLogManager.this.mDeviceAddress = bluetoothDevice.getAddress();
                char c = 0;
                int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", -1);
                String action = intent.getAction();
                int hashCode = action.hashCode();
                if (hashCode != 545516589) {
                    if (hashCode != 1244161670) {
                        if (hashCode == 2116862345 && action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                            c = 2;
                            if (c == 0) {
                                BudsLogManager.sendLog(3, BudsLogManager.this.stateToString(intExtra2, intExtra));
                                return;
                            } else if (c == 1) {
                                BudsLogManager.sendLog(4, BudsLogManager.this.stateToString(intExtra2, intExtra));
                                return;
                            } else if (c == 2) {
                                BudsLogManager.sendLog(5, BudsLogManager.this.stateToString(intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE), intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE)));
                                return;
                            } else {
                                return;
                            }
                        }
                    } else if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                        c = 1;
                        if (c == 0) {
                        }
                    }
                }
                c = 65535;
                if (c == 0) {
                }
            } else {
                Log.e(BudsLogManager.TAG, "device is null!!");
            }
        }
    };
    /* access modifiers changed from: private */
    public String mDeviceAddress = null;
    private WorkerHandler mWorkerHandler;

    private String getTagName(int i) {
        switch (i) {
            case 0:
                return "SENT :";
            case 1:
                return "RECV :";
            case 2:
                return "SPP_STATE :";
            case 3:
                return "HFP_STATE :";
            case 4:
                return "A2DP_STATE :";
            case 5:
                return "BOND_STATE :";
            case 6:
                return "DEVICE_INFO :";
            default:
                return null;
        }
    }

    private BudsLogManager() {
        Log.d(TAG, "BudsLogManager() : ");
        this.mWorkerHandler = WorkerHandler.createWorkerHandler("buds_log@" + this);
        this.mWorkerHandler.setMessageHandler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what < 2) {
                    BudsLogManager.this.updateLogBuffer(message.what, (byte[]) message.obj);
                    return true;
                }
                BudsLogManager.this.updateLog(message.what, (String) message.obj);
                return true;
            }
        });
        registerReceiver();
        makeLogDir();
    }

    public static BudsLogManager getInstance() {
        if (instance == null) {
            synchronized (BudsLogManager.class) {
                if (instance == null) {
                    instance = new BudsLogManager();
                }
            }
        }
        return instance;
    }

    public void destroy() {
        Log.d(TAG, "destroy()");
        this.mWorkerHandler.quit();
        Application.getContext().unregisterReceiver(this.mBluetoothReceiver);
    }

    private void registerReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
        intentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
        Application.getContext().registerReceiver(this.mBluetoothReceiver, intentFilter);
    }

    public static void sendLog(int i, byte[] bArr) {
        if (getInstance().mWorkerHandler != null) {
            getInstance().mWorkerHandler.obtainMessage(i, bArr).sendToTarget();
        } else {
            Log.e(TAG, "sendLog() : mWorkerHandler == null !!!");
        }
    }

    public static void sendLog(int i, String str) {
        if (getInstance().mWorkerHandler != null) {
            getInstance().mWorkerHandler.obtainMessage(i, str).sendToTarget();
        } else {
            Log.e(TAG, "sendLog() : mWorkerHandler == null !!!");
        }
    }

    private String getBTAddress() {
        String str = this.mDeviceAddress;
        if (str == null) {
            str = UhmFwUtil.getLastLaunchDeviceId();
        }
        return BluetoothUtil.autoPrivateAddress(str);
    }

    private StringBuilder toString(int i, byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr.length <= 30 || i != 0 || isAllToString(bArr)) {
            int length = bArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02X ", new Object[]{Byte.valueOf(bArr[i2])}));
            }
        } else {
            for (int i3 = 0; i3 < 20; i3++) {
                sb.append(String.format("%02X ", new Object[]{Byte.valueOf(bArr[i3])}));
            }
            sb.append(".. .. .. ");
            for (int length2 = bArr.length - 10; length2 < bArr.length; length2++) {
                sb.append(String.format("%02X ", new Object[]{Byte.valueOf(bArr[length2])}));
            }
        }
        return sb;
    }

    private boolean isAllToString(byte[] bArr) {
        byte[] bArr2 = {-3, MsgID.TOUCHPAD_OTHER_OPTION, 0, MsgID.SET_FMM_CONFIG};
        for (int i = 0; i <= bArr.length - 4; i++) {
            if (bArr[i + 0] == bArr2[0] && bArr[i + 1] == bArr2[1] && bArr[i + 3] == bArr2[3]) {
                return true;
            }
        }
        return false;
    }

    private boolean isSensitiveInfo(byte[] bArr) {
        byte[] bArr2 = {-3, 87, 0, MsgID.DEBUG_GET_ALL_DATA};
        byte[] bArr3 = {-3, 27, 0, MsgID.DEBUG_SERIAL_NUMBER};
        for (int i = 0; i <= bArr.length - 4; i++) {
            int i2 = i + 0;
            if (bArr[i2] == bArr2[0] && bArr[i + 1] == bArr2[1] && bArr[i + 3] == bArr2[3]) {
                return true;
            }
            if (bArr[i2] == bArr3[0] && bArr[i + 1] == bArr3[1] && bArr[i + 3] == bArr3[3]) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void updateLogBuffer(int i, byte[] bArr) {
        if (i != 1 || !isSensitiveInfo(bArr)) {
            writeFile(i, toString(i, bArr));
        }
    }

    /* access modifiers changed from: private */
    public void updateLog(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        writeFile(i, sb);
    }

    private void makeLogDir() {
        Log.d(TAG, "makeLogDir");
        String supportedStorageByCondtion = getSupportedStorageByCondtion();
        String str = supportedStorageByCondtion + "/log/GearLog/";
        String str2 = supportedStorageByCondtion + "/log/GearLog/Buds/";
        File file = new File(str);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                Log.d(TAG, "failed mkdirs() ");
                return;
            }
            file.setReadable(true, false);
            file.setWritable(true, false);
            file.setExecutable(true, false);
        }
        this.folderPath = str2;
        File file2 = new File(this.folderPath);
        if (file2.exists()) {
            return;
        }
        if (!file2.mkdirs()) {
            Log.d(TAG, "failed mkdirs() ");
            return;
        }
        file2.setReadable(true, false);
        file2.setWritable(true, false);
        file2.setExecutable(true, false);
    }

    private void writeFile(int i, StringBuilder sb) {
        String str = this.folderPath;
        if (str == null || !isExistedGearLogFolder(str)) {
            makeLogDir();
        }
        String str2 = new SimpleDateFormat("MM/dd HH:mm:ss.SS").format(new Date(System.currentTimeMillis())) + " " + getTagName(i) + " " + sb;
        try {
            File file = new File(this.folderPath + File.separator + DEVICE_NAME + "_dumpState_01.log");
            file.setReadable(true, false);
            file.setWritable(true, false);
            file.setExecutable(true, false);
            File file2 = new File(this.folderPath + File.separator + DEVICE_NAME + "_dumpState_02.log");
            file2.setReadable(true, false);
            file2.setWritable(true, false);
            file2.setExecutable(true, false);
            if ((file.length() + ((long) str2.length())) / 1024 <= 1024) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter.write(str2);
                bufferedWriter.newLine();
                bufferedWriter.close();
                return;
            }
            long length = 1048576 - file.length();
            if (length <= 0) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
                if (file.exists()) {
                    file.delete();
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter2.write(str2);
                bufferedWriter2.newLine();
                bufferedWriter2.close();
                return;
            }
            if (file2.exists()) {
                file2.delete();
            }
            file.renameTo(file2);
            BufferedWriter bufferedWriter3 = new BufferedWriter(new FileWriter(file2, true));
            int i2 = (int) length;
            bufferedWriter3.write(str2, 0, i2);
            bufferedWriter3.newLine();
            bufferedWriter3.close();
            if (file.exists()) {
                file.delete();
            }
            BufferedWriter bufferedWriter4 = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter4.write(str2, i2, (int) (((long) str2.length()) - length));
            bufferedWriter4.newLine();
            bufferedWriter4.close();
        } catch (IOException e) {
            Log.e(TAG, e.toString());
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public String stateToString(int i, int i2) {
        return "[" + getBTAddress() + "]" + " : " + BluetoothUtil.stateToString(i) + " -> " + BluetoothUtil.stateToString(i2);
    }

    private static int getSamsungMembersVersion() {
        PackageInfo packageInfo;
        try {
            packageInfo = Application.getContext().getPackageManager().getPackageInfo(SM_PACKAGE_NAME, 0);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "getSMPackageInfo() : error=" + e.toString());
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return -1;
    }

    public String getSupportedStorageByCondtion() {
        String replace = Arrays.toString(Application.getContext().getExternalFilesDirs((String) null)).replace("[", "").replace("]", "");
        int samsungMembersVersion = getSamsungMembersVersion();
        Log.d(TAG, "samsungMembersVersion : " + samsungMembersVersion);
        if (!Util.isSamsungDevice()) {
            return Build.VERSION.SDK_INT >= 30 ? replace : String.valueOf(Environment.getExternalStorageDirectory());
        }
        if ((Build.VERSION.SDK_INT < 28 || samsungMembersVersion < SM_MIN_VERSION_CODE_POS) && ((Build.VERSION.SDK_INT > 27 || samsungMembersVersion < SM_MIN_VERSION_CODE_OOS) && Build.VERSION.SDK_INT < 30)) {
            return String.valueOf(Environment.getExternalStorageDirectory());
        }
        return "data";
    }

    public boolean isExistedGearLogFolder(String str) {
        return new File(str).exists();
    }
}
