package com.samsung.accessory.neobeanmgr.module.home.card;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.accessory.neobeanmgr.R;
import com.samsung.accessory.neobeanmgr.common.preference.PreferenceKey;
import com.samsung.accessory.neobeanmgr.common.preference.Preferences;
import com.samsung.accessory.neobeanmgr.common.uhm.UhmFwUtil;
import com.samsung.accessory.neobeanmgr.core.bigdata.SA;
import com.samsung.accessory.neobeanmgr.core.bigdata.SamsungAnalyticsUtil;
import com.samsung.accessory.neobeanmgr.module.home.card.Card;
import com.samsung.accessory.neobeanmgr.module.tipsmanual.TipsAndUserManualActivity;

public class CardOobeTips extends Card implements View.OnClickListener {
    private static final String TAG = "NeoBean_CardOobeTips";
    private Activity mActivity;
    private ItemViewHolder mItemViewHolder;

    public CardOobeTips(Activity activity) {
        super(102);
        this.mActivity = activity;
    }

    public void onBindItemViewHolder(Card.ItemViewHolder itemViewHolder) {
        this.mItemViewHolder = (ItemViewHolder) itemViewHolder;
        updateUI();
    }

    public void updateUI() {
        ItemViewHolder itemViewHolder = this.mItemViewHolder;
        if (itemViewHolder != null) {
            itemViewHolder.textDescription.setText(R.string.oobe_tip_card_desc);
            this.mItemViewHolder.layoutInlineCue.setContentDescription(this.mItemViewHolder.textDescription.getText());
            this.mItemViewHolder.textAction.setText(R.string.tutorial_card_start_btn_txt);
            this.mItemViewHolder.imageCancel.setOnClickListener(this);
            this.mItemViewHolder.textAction.setOnClickListener(this);
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.image_cancel) {
            Log.d(TAG, "Click OOBE Tip card cancel image.");
            SamsungAnalyticsUtil.sendEvent(SA.Event.TIPS_CLOSE, SA.Screen.HOME);
            Preferences.putBoolean(PreferenceKey.OOBE_CARD_SHOW_AGAIN, false, UhmFwUtil.getLastLaunchDeviceId());
            ((Card.CardOwnerActivity) this.mActivity).removeTipCard();
        } else if (id == R.id.text_action) {
            Log.d(TAG, "Click OOBE Tip card Let's go button.");
            SamsungAnalyticsUtil.sendEvent(SA.Event.TIPS_LETS_GO, SA.Screen.HOME);
            this.mActivity.startActivity(new Intent(this.mActivity, TipsAndUserManualActivity.class));
            Preferences.putBoolean(PreferenceKey.OOBE_CARD_SHOW_AGAIN, false, UhmFwUtil.getLastLaunchDeviceId());
            ((Card.CardOwnerActivity) this.mActivity).removeTipCard();
        }
    }

    static Card.ItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        return new ItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_inline_cue, viewGroup, false));
    }

    static class ItemViewHolder extends Card.ItemViewHolder {
        ImageView imageCancel;
        View layoutInlineCue;
        TextView textAction;
        TextView textDescription;

        ItemViewHolder(View view) {
            super(view);
            this.imageCancel = (ImageView) view.findViewById(R.id.image_cancel);
            this.textDescription = (TextView) view.findViewById(R.id.text_description);
            this.textAction = (TextView) view.findViewById(R.id.text_action);
            this.layoutInlineCue = view.findViewById(R.id.layout_inline_cue);
        }
    }
}
