package com.accessorydm.ui.lastupdate;

import com.accessorydm.ui.fullscreen.basefullscreen.XUIBaseFullscreenContract;
import com.accessorydm.ui.fullscreen.basefullscreen.XUIBaseFullscreenModel;
import com.accessorydm.ui.fullscreen.basefullscreen.XUIBaseFullscreenPresenter;
import com.accessorydm.ui.lastupdate.XUILastUpdateContract;
import com.samsung.android.fotaprovider.log.Log;

public class XUILastUpdatePresenter extends XUIBaseFullscreenPresenter implements XUILastUpdateContract.Presenter {
    private final XUILastUpdateModel model = new XUILastUpdateModel();
    private final XUILastUpdateContract.View view;

    /* access modifiers changed from: protected */
    public void initializeBottomContentUI() {
    }

    public void initializeListenersAfterCreatedUI() {
    }

    XUILastUpdatePresenter(XUILastUpdateContract.View view2) {
        this.view = view2;
    }

    /* access modifiers changed from: protected */
    public XUIBaseFullscreenContract.View getView() {
        return this.view;
    }

    /* access modifiers changed from: protected */
    public XUIBaseFullscreenModel getModel() {
        return this.model;
    }

    /* access modifiers changed from: protected */
    public void initializeTopContentUI() {
        if (this.view.getTopContentView() != null) {
            this.view.getTopContentView().setTitle(this.model.getGuideTitle());
            this.view.getTopContentView().setText(this.model.getGuideText());
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
