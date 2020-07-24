package com.accessorydm.filetransfer.action;

import com.accessorydm.db.file.AccessoryInfoAdapter;
import com.accessorydm.db.file.XDBFumoAdp;
import com.accessorydm.ui.notification.XUINotificationManager;
import com.accessorydm.ui.notification.manager.NotificationId;
import com.samsung.accessory.fotaprovider.AccessoryController;
import com.samsung.accessory.fotaprovider.controller.ConsumerInfo;
import com.samsung.accessory.fotaprovider.controller.RequestController;
import com.samsung.accessory.fotaprovider.controller.RequestError;
import com.samsung.android.fotaprovider.log.Log;
import com.samsung.android.fotaprovider.util.FotaProviderUtil;

public final class InstallPackage extends FileTransferAction {
    /* access modifiers changed from: package-private */
    public boolean checkPrecondition() {
        XDBFumoAdp.xdbSetFUMOStatus(50);
        if (!AccessoryController.getInstance().getConnectionController().isConnected()) {
            Log.W("Device connection is not ready");
            FileTransferFailure.handleAccessoryConnectionFailure((RequestError) null);
            return false;
        } else if (!AccessoryController.getInstance().getRequestController().isInProgress()) {
            return true;
        } else {
            Log.W("Accessory is in progress");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void controlAccessory() {
        Log.I("");
        AccessoryController.getInstance().getRequestController().installPackage(new RequestController.InstallPackageRequestCallback.Result() {
            public void onSuccessAction(ConsumerInfo consumerInfo) {
                Log.I("installPackage succeeded");
                new AccessoryInfoAdapter().updateAccessoryDB(consumerInfo.getAccessoryInfo());
                InstallPackage.this.setUpdateInProgress();
                FotaProviderUtil.sendIntentUpdateInProgress();
            }

            public void onFailure(RequestError requestError) {
                Log.W("installPackage failed");
                FileTransferFailure.handleAccessoryConnectionFailure(requestError);
            }
        });
    }

    /* access modifiers changed from: private */
    public void setUpdateInProgress() {
        Log.I("");
        XUINotificationManager.getInstance().xuiRemoveNotification(NotificationId.XDM_NOTIFICATION_ID_PRIMARY);
        XDBFumoAdp.xdbSetFUMOStatus(60);
    }
}
