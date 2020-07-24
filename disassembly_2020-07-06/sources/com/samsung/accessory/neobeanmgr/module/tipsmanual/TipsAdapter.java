package com.samsung.accessory.neobeanmgr.module.tipsmanual;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.samsung.accessory.neobeanmgr.R;
import com.samsung.accessory.neobeanmgr.common.ui.IntegratedTextFragment;
import com.samsung.accessory.neobeanmgr.common.ui.UiUtil;
import com.samsung.accessory.neobeanmgr.common.util.Util;
import java.util.ArrayList;

public class TipsAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mViewPagerFragments = new ArrayList<>();

    public TipsAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mViewPagerFragments.add(new TipsHowToWearFragment());
        this.mViewPagerFragments.add(new UseTouchpadFragment());
        if (Util.isFloatingFeatureForPowerSharing()) {
            this.mViewPagerFragments.add(new TipsChargingFragment());
        }
        this.mViewPagerFragments.add(new IntegratedTextFragment(R.layout.fragment_tips_case_battery));
        this.mViewPagerFragments.add(new TipsPairingFragment(R.layout.fragment_tips_pairing));
    }

    public Fragment getItem(int i) {
        return this.mViewPagerFragments.get(UiUtil.rtlCompatIndex(i, getCount()));
    }

    public int getCount() {
        return this.mViewPagerFragments.size();
    }
}
