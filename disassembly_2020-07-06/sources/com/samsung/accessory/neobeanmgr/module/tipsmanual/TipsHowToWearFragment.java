package com.samsung.accessory.neobeanmgr.module.tipsmanual;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.samsung.accessory.neobeanmgr.R;
import com.samsung.accessory.neobeanmgr.common.ui.UiUtil;
import com.samsung.accessory.neobeanmgr.common.ui.VIView;
import com.samsung.accessory.neobeanmgr.module.tipsmanual.TipsAndUserManualActivity;

public class TipsHowToWearFragment extends Fragment implements TipsAndUserManualActivity.OnSelectedTipsFragment {
    private VIView mVIView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_tips_how_to_wear_earbuds, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.make_sure_you_put));
        sb.append("\n\n");
        sb.append(getString(R.string.a_correct_fit_will_give_you));
        ((TextView) view.findViewById(R.id.text_tips_wear_earbuds_desc)).setText(sb);
        this.mVIView = (VIView) view.findViewById(R.id.vi_view);
        view.setContentDescription(UiUtil.getAllTextWithChildView(getView()));
    }

    public void onSelected(boolean z) {
        VIView vIView = this.mVIView;
        if (vIView != null) {
            if (z) {
                vIView.start();
            } else {
                vIView.reset();
            }
        }
    }
}
