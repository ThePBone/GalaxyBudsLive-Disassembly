package com.samsung.accessory.neobeanmgr.common.util;

import android.content.Context;
import android.util.Log;
import com.samsung.accessory.neobeanmgr.Application;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSessionFactory;
import com.samsung.android.sdk.mobileservice.profile.ProfileApi;
import java.util.HashMap;

public class SeMobileServiceUtil {
    private static final String TAG = "NeoBean_SeMobileServiceUtil";

    public static void getProfileApi(final ResponseCallback responseCallback) {
        Log.d(TAG, "getProfileApi() : " + responseCallback);
        if (responseCallback != null) {
            SeMobileServiceSessionWrapper seMobileServiceSessionWrapper = new SeMobileServiceSessionWrapper(Application.getContext(), "ProfileService", (SeMobileServiceSessionWrapper.ConnectionResultCallback) new SeMobileServiceSessionWrapper.ConnectionResultCallback() {
                public void onFailure(final SeMobileServiceSessionWrapper seMobileServiceSessionWrapper, final int i) {
                    Log.e(SeMobileServiceUtil.TAG, "getProfileApi() : onFailure(" + i + ")");
                    new Thread(new Runnable() {
                        public void run() {
                            responseCallback.onResponse(String.valueOf(i));
                            seMobileServiceSessionWrapper.disconnect();
                        }
                    }).start();
                }

                public void onSuccess(final SeMobileServiceSessionWrapper seMobileServiceSessionWrapper, HashMap<String, Integer> hashMap, boolean z) {
                    Log.d(SeMobileServiceUtil.TAG, "getProfileApi() : onSuccess() : " + hashMap + ", " + z);
                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                if (seMobileServiceSessionWrapper.getSession().isSupportedApi("ProfileApi") && seMobileServiceSessionWrapper.getSession().isServiceConnected("ProfileService")) {
                                    responseCallback.setExtraObject(new ProfileApi(seMobileServiceSessionWrapper.getSession()));
                                    responseCallback.onResponse((String) null);
                                    seMobileServiceSessionWrapper.disconnect();
                                    return;
                                }
                                throw new Exception("support == false");
                            } catch (Exception e) {
                                e.printStackTrace();
                                responseCallback.onResponse(e.toString());
                            }
                        }
                    }).start();
                }
            });
            Log.v(TAG, "getProfileApi() : session.connect()");
            seMobileServiceSessionWrapper.connect();
            Log.v(TAG, "getProfileApi() : session.connect()_end");
        }
    }

    static class SeMobileServiceSessionWrapper implements SeMobileServiceSession.ConnectionResultCallback {
        private static final String TAG = "SeMobileServiceSessionWrapper";
        private final ConnectionResultCallback mCallback;
        private final SeMobileServiceSession mSession;

        interface ConnectionResultCallback {
            void onFailure(SeMobileServiceSessionWrapper seMobileServiceSessionWrapper, int i);

            void onSuccess(SeMobileServiceSessionWrapper seMobileServiceSessionWrapper, HashMap<String, Integer> hashMap, boolean z);
        }

        SeMobileServiceSessionWrapper(Context context, String[] strArr, ConnectionResultCallback connectionResultCallback) {
            this.mCallback = connectionResultCallback;
            SeMobileServiceSessionFactory seMobileServiceSessionFactory = new SeMobileServiceSessionFactory(context, this);
            for (String addService : strArr) {
                seMobileServiceSessionFactory.addService(addService);
            }
            this.mSession = seMobileServiceSessionFactory.build();
        }

        SeMobileServiceSessionWrapper(Context context, String str, ConnectionResultCallback connectionResultCallback) {
            this(context, new String[]{str}, connectionResultCallback);
        }

        /* access modifiers changed from: package-private */
        public SeMobileServiceSession getSession() {
            return this.mSession;
        }

        /* access modifiers changed from: package-private */
        public void connect() {
            SeMobileServiceSession seMobileServiceSession = this.mSession;
            if (seMobileServiceSession != null) {
                seMobileServiceSession.connect();
            } else {
                Log.e(TAG, "connect() : mSession == null");
            }
        }

        /* access modifiers changed from: package-private */
        public void disconnect() {
            SeMobileServiceSession seMobileServiceSession = this.mSession;
            if (seMobileServiceSession != null) {
                seMobileServiceSession.disconnect();
            } else {
                Log.e(TAG, "disconnect() : mSession == null");
            }
        }

        public void onFailure(int i) {
            ConnectionResultCallback connectionResultCallback = this.mCallback;
            if (connectionResultCallback != null) {
                connectionResultCallback.onFailure(this, i);
            }
        }

        public void onSuccess(HashMap<String, Integer> hashMap, boolean z) {
            ConnectionResultCallback connectionResultCallback = this.mCallback;
            if (connectionResultCallback != null) {
                connectionResultCallback.onSuccess(this, hashMap, z);
            }
        }
    }
}
