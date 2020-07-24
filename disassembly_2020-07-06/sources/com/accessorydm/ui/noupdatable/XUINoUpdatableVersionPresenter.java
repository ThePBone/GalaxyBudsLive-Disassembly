package com.accessorydm.ui.noupdatable;

import com.accessorydm.ui.fullscreen.basefullscreen.XUIBaseFullscreenPresenter;
import com.accessorydm.ui.noupdatable.XUINoUpdatableVersionContract;
import com.samsung.android.fotaprovider.log.Log;

public class XUINoUpdatableVersionPresenter extends XUIBaseFullscreenPresenter implements XUINoUpdatableVersionContract.Presenter {
    private final XUINoUpdatableVersionModel model = new XUINoUpdatableVersionModel();
    private final XUINoUpdatableVersionContract.View view;

    /* access modifiers changed from: protected */
    public void initializeBottomContentUI() {
    }

    public void initializeListenersAfterCreatedUI() {
    }

    XUINoUpdatableVersionPresenter(XUINoUpdatableVersionContract.View view2) {
        this.view = view2;
    }

    /* access modifiers changed from: protected */
    public XUINoUpdatableVersionContract.View getView() {
        return this.view;
    }

    /* access modifiers changed from: protected */
    public XUINoUpdatableVersionModel getModel() {
        return this.model;
    }

    /* access modifiers changed from: protected */
    public void initializeTopContentUI() {
        if (this.view.getTopContentView() != null) {
            this.view.getTopContentView().setTitle(this.model.getGuideTitle());
            this.view.getTopContentView().hideText();
        }
    }

    /* access modifiers changed from: protected */
    public void initializeMiddleContentUI() {
        if (this.view.getMiddleContentView() != null) {
            this.view.getMiddleContentView().setSoftwareUpdateInformation(this.model.getFirmwareVersion(), this.model.getFirmwareSize());
            this.view.getMiddleContentView().setWhatsNewText(this.model.getWhatsNewText());
        }
    }

    public void onDestroy() {
        Log.I("");
    }
}
