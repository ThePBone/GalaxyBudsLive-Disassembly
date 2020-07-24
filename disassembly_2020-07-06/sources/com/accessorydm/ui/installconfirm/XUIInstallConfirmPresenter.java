package com.accessorydm.ui.installconfirm;

import com.accessorydm.ui.fullscreen.basefullscreen.XUIBaseFullscreenPresenter;
import com.accessorydm.ui.installconfirm.XUIInstallConfirmContract;
import com.accessorydm.ui.notification.XUINotificationManager;
import com.samsung.android.fotaprovider.log.Log;
import com.samsung.android.fotaprovider.util.galaxywearable.SALogUtil;

public class XUIInstallConfirmPresenter extends XUIBaseFullscreenPresenter implements XUIInstallConfirmContract.Presenter {
    private XUIInstallConfirmModel model;
    private XUIInstallConfirmContract.View view;

    XUIInstallConfirmPresenter(XUIInstallConfirmContract.View view2, XUIInstallConfirmModel xUIInstallConfirmModel) {
        this.view = view2;
        this.model = xUIInstallConfirmModel;
    }

    /* access modifiers changed from: protected */
    public XUIInstallConfirmContract.View getView() {
        return this.view;
    }

    /* access modifiers changed from: protected */
    public XUIInstallConfirmModel getModel() {
        return this.model;
    }

    public void onCreate() {
        Log.I("");
        super.onCreate();
    }

    public void onResume() {
        Log.I("");
        startInstallCountdownIfNeeded();
    }

    /* access modifiers changed from: protected */
    public void initializeTopContentUI() {
        if (this.view.getTopContentView() != null) {
            this.view.getTopContentView().setTitle(this.model.getGuideTitle());
            if (this.model.isNeededToHideGuideText()) {
                this.view.getTopContentView().hideText();
            } else {
                this.view.getTopContentView().setText(this.model.getGuideText());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initializeMiddleContentUI() {
        if (this.view.getMiddleContentView() != null) {
            this.view.getMiddleContentView().setSoftwareUpdateInformation(this.model.getFirmwareVersion(), this.model.getFirmwareSize());
            this.view.getMiddleContentView().setWhatsNewText(this.model.getWhatsNewText());
            this.view.getMiddleContentView().setCautionText(this.model.getCautionText());
        }
    }

    /* access modifiers changed from: protected */
    public void initializeBottomContentUI() {
        if (this.view.getBottomContentView() != null) {
            this.view.getBottomContentView().setFirstButtonText(this.model.getFirstButtonText());
            this.view.getBottomContentView().setSecondButtonText(this.model.getSecondButtonText());
        }
    }

    public void initializeListenersAfterCreatedUI() {
        this.view.xuiSetBottomButtonsClickListeners();
    }

    private void startInstallCountdownIfNeeded() {
        if (this.model.isNeededInstallCountdown()) {
            InstallCountdown.getInstance().startOrKeepGoing(this.view, this.model);
        }
    }

    public void doFirstButtonAction() {
        if (checkPreconditionBeforeButtonBehavior()) {
            scheduleInstall();
        }
    }

    public void doSecondButtonAction() {
        if (checkPreconditionBeforeButtonBehavior()) {
            disableButtonAfterClicked();
            installNow();
        }
    }

    private boolean checkPreconditionBeforeButtonBehavior() {
        if (this.model.isEnabledBottomButtons()) {
            return true;
        }
        Log.I("already clicked and disabled buttons, not allowed duplication");
        return false;
    }

    private void disableButtonAfterClicked() {
        this.model.disableBottomButtons();
        this.view.getBottomContentView().disableButtons();
    }

    private void scheduleInstall() {
        Log.I("");
        SALogUtil.loggingScheduleInstallButton();
        this.view.xuiShowScheduleInstallDialog();
    }

    private void installNow() {
        Log.I("");
        SALogUtil.loggingInstallNowButton();
        XUINotificationManager.getInstance().xuiRemoveNotification(XUINotificationManager.getInstance().xuiGetNotificationType());
        this.model.startInstall();
        this.view.finish();
    }

    public void onUserLeaveHint() {
        actionToLeaveInstallConfirm();
    }

    /* access modifiers changed from: protected */
    public void actionForUpButton() {
        Log.D("");
        SALogUtil.loggingInstallUpButton();
        actionToLeaveInstallConfirm();
    }

    /* access modifiers changed from: protected */
    public void actionForBackKey() {
        Log.D("");
        actionToLeaveInstallConfirm();
    }

    private void actionToLeaveInstallConfirm() {
        this.model.startOneDayPostpone();
        this.view.xuiOnBackPressed();
    }

    public void onDestroy() {
        Log.D("");
        this.model.enableBottomButtons();
    }
}
