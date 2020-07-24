package com.samsung.accessory.neobeanmgr.core.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.samsung.accessory.neobeanmgr.Application;
import oreocompat.OreoCompatUtil;

public class MainService extends Service {
    private static final String TAG = "NeoBean_MainService";
    private final IBinder mBinder = new Binder();

    public void onCreate() {
        Log.d(TAG, "onCreate()");
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d(TAG, "onStartCommand()");
        return 1;
    }

    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    public static void startService() {
        Context context = Application.getContext();
        OreoCompatUtil.startService(context, new Intent(context, MainService.class));
    }

    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        return this.mBinder;
    }

    public class Binder extends android.os.Binder {
        public Binder() {
        }

        public MainService getService() {
            return MainService.this;
        }
    }
}
