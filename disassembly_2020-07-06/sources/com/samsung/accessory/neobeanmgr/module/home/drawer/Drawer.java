package com.samsung.accessory.neobeanmgr.module.home.drawer;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.samsung.accessory.neobeanmgr.Application;
import com.samsung.accessory.neobeanmgr.R;
import com.samsung.accessory.neobeanmgr.common.preference.PreferenceKey;
import com.samsung.accessory.neobeanmgr.common.preference.Preferences;
import com.samsung.accessory.neobeanmgr.common.uhm.DeviceRegistryData;
import com.samsung.accessory.neobeanmgr.common.uhm.UhmFwUtil;
import com.samsung.accessory.neobeanmgr.common.ui.OnSingleClickListener;
import com.samsung.accessory.neobeanmgr.common.util.BluetoothUtil;
import com.samsung.accessory.neobeanmgr.common.util.Util;
import com.samsung.accessory.neobeanmgr.core.bigdata.SA;
import com.samsung.accessory.neobeanmgr.core.bigdata.SamsungAnalyticsUtil;
import com.samsung.accessory.neobeanmgr.core.service.CoreService;
import com.samsung.accessory.neobeanmgr.core.uhmdb.UhmDatabase;
import com.samsung.accessory.neobeanmgr.module.aboutgalaxywearable.AboutGalaxyWearableActivity;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Drawer {
    private static final String TAG = "NeoBean_Drawer";
    private View mBadge;
    /* access modifiers changed from: private */
    public Activity mHomeActivity;
    private View mLayoutAppNotifications;
    private View mLayoutConnect;
    private View mLayoutContactUs;
    private View mLayoutManageDevices;
    private ListView mLisView;
    /* access modifiers changed from: private */
    public DrawerListAdapter mListAdapter;
    private final AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Log.d(Drawer.TAG, "onItemClick() : position=" + i);
            DeviceRegistryData item = Drawer.this.mListAdapter.getItem(i);
            String lastLaunchDeviceId = UhmFwUtil.getLastLaunchDeviceId();
            if (Util.equalsIgnoreCase(item.deviceId, lastLaunchDeviceId)) {
                SamsungAnalyticsUtil.sendEvent(SA.Event.CURRENT_DEVICE, "250");
                ((DrawerOwnerActivity) Drawer.this.mHomeActivity).closeDrawer((Runnable) null);
                return;
            }
            SamsungAnalyticsUtil.sendEvent(SA.Event.CHANGE_DEVICE, "250");
            UhmFwUtil.handlePluginLaunch(Drawer.this.mHomeActivity, lastLaunchDeviceId, item.deviceId, item.deviceName);
        }
    };
    private ProfileImageSupport mProfileImage;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        /* JADX WARNING: Can't fix incorrect switch cases order */
        public void onReceive(Context context, Intent intent) {
            char c;
            Log.d(Drawer.TAG, "onReceive()");
            String action = intent.getAction();
            switch (action.hashCode()) {
                case -1926486170:
                    if (action.equals(UhmDatabase.ACTION_DB_UPDATED)) {
                        c = 0;
                        break;
                    }
                case -1354974214:
                    if (action.equals(CoreService.ACTION_DEVICE_DISCONNECTED)) {
                        c = 3;
                        break;
                    }
                case -415576694:
                    if (action.equals(CoreService.ACTION_DEVICE_CONNECTED)) {
                        c = 2;
                        break;
                    }
                case 1174571750:
                    if (action.equals("android.bluetooth.device.action.ALIAS_CHANGED")) {
                        c = 1;
                        break;
                    }
                default:
                    c = 65535;
                    break;
            }
            if (c == 0 || c == 1) {
                Drawer.this.updateDeviceList();
            } else if (c == 2 || c == 3) {
                Drawer.this.updateConnectMenu();
            }
        }
    };
    private TextView mTextConnect;

    public interface DrawerOwnerActivity {
        void closeDrawer(Runnable runnable);

        void closeDrawerDirectly();

        void openDrawer();

        void requestConnectToDevice();

        void startSamsungMembers();
    }

    public Drawer(Activity activity) {
        this.mHomeActivity = activity;
        this.mProfileImage = new ProfileImageSupport(this.mHomeActivity);
        this.mListAdapter = new DrawerListAdapter();
        this.mListAdapter.setOnDeviceItemClickListener(this.mOnItemClickListener);
        this.mLisView = (ListView) this.mHomeActivity.findViewById(R.id.list_devices);
        this.mLisView.setAdapter(this.mListAdapter);
        this.mLisView.addFooterView(createListFooterView());
        updateDeviceList();
        this.mHomeActivity.registerReceiver(this.mReceiver, getIntentFilter());
    }

    public void destroy() {
        this.mHomeActivity.unregisterReceiver(this.mReceiver);
    }

    private View createListFooterView() {
        int i = 0;
        View inflate = LayoutInflater.from(this.mHomeActivity).inflate(R.layout.layout_drawer_list_footer, this.mLisView, false);
        this.mTextConnect = (TextView) inflate.findViewById(R.id.text_connect);
        this.mLayoutConnect = inflate.findViewById(R.id.layout_disconnect);
        this.mLayoutManageDevices = inflate.findViewById(R.id.layout_manage_devices);
        this.mLayoutAppNotifications = inflate.findViewById(R.id.layout_app_notifications);
        this.mLayoutContactUs = inflate.findViewById(R.id.layout_contact_us);
        inflate.findViewById(R.id.layout_connect_new_device).setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                SamsungAnalyticsUtil.sendEvent(SA.Event.ADD_NEW_DEVICE, "250");
                UhmFwUtil.startNewDeviceActivity(Drawer.this.mHomeActivity, true);
            }
        });
        this.mLayoutManageDevices.setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                SamsungAnalyticsUtil.sendEvent(SA.Event.MANAGE_DEVICES, "250");
                UhmFwUtil.startManageDevices(Drawer.this.mHomeActivity, true);
            }
        });
        this.mLayoutAppNotifications.setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                SamsungAnalyticsUtil.sendEvent(SA.Event.APP_NOTIFICATION, "250");
                Intent intent = new Intent();
                if (Build.VERSION.SDK_INT >= 26) {
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("android.provider.extra.APP_PACKAGE", Drawer.this.mHomeActivity.getPackageName());
                } else {
                    intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                    intent.putExtra("app_package", Drawer.this.mHomeActivity.getPackageName());
                    intent.putExtra("app_uid", Drawer.this.mHomeActivity.getApplicationInfo().uid);
                }
                try {
                    Drawer.this.mHomeActivity.startActivity(intent);
                } catch (ActivityNotFoundException unused) {
                    Log.e(Drawer.TAG, "can not find activity, intent[" + intent + "]");
                }
            }
        });
        View view = this.mLayoutContactUs;
        if (!isSamsungMembersAvailable()) {
            i = 8;
        }
        view.setVisibility(i);
        this.mLayoutContactUs.setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                SamsungAnalyticsUtil.sendEvent(SA.Event.CONTACT_US, "250");
                ((DrawerOwnerActivity) Drawer.this.mHomeActivity).startSamsungMembers();
            }
        });
        inflate.findViewById(R.id.layout_about_galaxy_wearable_app).setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                SamsungAnalyticsUtil.sendEvent(SA.Event.ABOUT_GALAXY_WEARABLE, "250");
                Drawer.this.mHomeActivity.startActivity(new Intent(Drawer.this.mHomeActivity, AboutGalaxyWearableActivity.class));
            }
        });
        this.mBadge = inflate.findViewById(R.id.text_badge_notification);
        updateConnectMenu();
        updateGalaxyWearableBadge();
        return inflate;
    }

    /* access modifiers changed from: private */
    public void updateDeviceList() {
        Log.d(TAG, "updateDeviceList()");
        List<DeviceRegistryData> deviceList = Application.getUhmDatabase().getDeviceList();
        Iterator<DeviceRegistryData> it = deviceList.iterator();
        while (it.hasNext()) {
            DeviceRegistryData next = it.next();
            if (next.connected.intValue() == 0) {
                Log.w(TAG, "updateDeviceList() : " + next.deviceName + "(" + BluetoothUtil.privateAddress(next.deviceId) + ") == BT_UNPAIRED");
                it.remove();
            }
        }
        Collections.reverse(deviceList);
        this.mListAdapter.setData(deviceList);
        this.mListAdapter.notifyDataSetChanged();
        updateManageDevicesMenu();
    }

    /* access modifiers changed from: private */
    public void updateConnectMenu() {
        Log.d(TAG, "updateConnectMenu()");
        if (Application.getCoreService().isConnected()) {
            this.mTextConnect.setText(this.mHomeActivity.getString(R.string.disconnect));
            this.mLayoutConnect.setOnClickListener(new OnSingleClickListener() {
                public void onSingleClick(View view) {
                    SamsungAnalyticsUtil.sendEvent(SA.Event.DISCONNECT, "250");
                    Preferences.putBoolean(PreferenceKey.HOME_DISCONNECTED_BY_USER, true);
                    ((DrawerOwnerActivity) Drawer.this.mHomeActivity).closeDrawer(new Runnable() {
                        public void run() {
                            Application.getCoreService().disconnectDevice();
                        }
                    });
                }
            });
            return;
        }
        this.mTextConnect.setText(this.mHomeActivity.getString(R.string.connect));
        this.mLayoutConnect.setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                SamsungAnalyticsUtil.sendEvent(SA.Event.DISCONNECT, "250");
                ((DrawerOwnerActivity) Drawer.this.mHomeActivity).closeDrawer(new Runnable() {
                    public void run() {
                        ((DrawerOwnerActivity) Drawer.this.mHomeActivity).requestConnectToDevice();
                    }
                });
            }
        });
    }

    private void updateManageDevicesMenu() {
        Log.d(TAG, "updateConnectMenu()");
        if (!Util.isSamsungDevice() || this.mListAdapter.getCount() <= 1) {
            this.mLayoutManageDevices.setVisibility(8);
        } else {
            this.mLayoutManageDevices.setVisibility(0);
        }
    }

    public void updateGalaxyWearableBadge() {
        int i = 0;
        boolean z = Preferences.getBoolean(PreferenceKey.EXISTED_NEW_VERSION_PLUGIN, false, UhmFwUtil.getLastLaunchDeviceId());
        View view = this.mBadge;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void updateProfileImage() {
        Log.d(TAG, "updateProfileImage()");
        this.mProfileImage.updateUI();
    }

    private boolean isSamsungMembersAvailable() {
        try {
            if (this.mHomeActivity.getPackageManager().getPackageInfo("com.samsung.android.voc", 0).versionCode >= 170001000) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Exception: " + e);
            return false;
        }
    }

    private IntentFilter getIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UhmDatabase.ACTION_DB_UPDATED);
        intentFilter.addAction("android.bluetooth.device.action.ALIAS_CHANGED");
        intentFilter.addAction(CoreService.ACTION_DEVICE_CONNECTED);
        intentFilter.addAction(CoreService.ACTION_DEVICE_DISCONNECTED);
        return intentFilter;
    }
}
