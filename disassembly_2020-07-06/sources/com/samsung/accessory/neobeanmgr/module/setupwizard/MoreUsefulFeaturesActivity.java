package com.samsung.accessory.neobeanmgr.module.setupwizard;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.samsung.accessory.neobeanmgr.R;
import com.samsung.accessory.neobeanmgr.common.ui.OnSingleClickListener;
import com.samsung.accessory.neobeanmgr.common.ui.PageIndicatorView;
import com.samsung.accessory.neobeanmgr.core.bigdata.SA;
import com.samsung.accessory.neobeanmgr.core.bigdata.SamsungAnalyticsUtil;
import com.samsung.accessory.neobeanmgr.module.base.PermissionCheckActivity;

public class MoreUsefulFeaturesActivity extends PermissionCheckActivity implements ViewPager.OnPageChangeListener {
    public static final boolean ENABLED = true;
    private static final String TAG = "NeoBean_MoreUsefulFeaturesActivity";
    private View mButtonGotIt;
    private View mButtonNext;
    private View mButtonPrev;
    private View mButtonSkip;
    private Handler mNextActionHandler = new Handler();
    private PageIndicatorView mPageIndicatorView;
    private boolean mStartedYouAreAllSetActivity = false;
    private ViewPager mViewPager;
    private PagerAdapter mViewPagerAdapter;

    public void onPageScrolled(int i, float f, int i2) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Log.d(TAG, "onCreate()");
        super.onCreate((Bundle) null);
        setContentView((int) R.layout.activity_more_useful_features);
        this.mViewPager = (ViewPager) findViewById(R.id.viewpager);
        this.mPageIndicatorView = (PageIndicatorView) findViewById(R.id.page_indicator);
        showAnimationHowToWear();
        this.mButtonSkip = findViewById(R.id.button_skip);
        this.mButtonPrev = findViewById(R.id.button_prev);
        this.mButtonNext = findViewById(R.id.button_next);
        this.mButtonGotIt = findViewById(R.id.button_got_it);
        this.mViewPagerAdapter = new MoreUsefulFeaturesViewPagerAdapter(getSupportFragmentManager());
        this.mViewPager.setAdapter(this.mViewPagerAdapter);
        this.mViewPager.addOnPageChangeListener(this);
        this.mPageIndicatorView.setPageMax(this.mViewPagerAdapter.getCount());
        this.mButtonSkip.setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                MoreUsefulFeaturesActivity.this.onClickSkipButton();
            }
        });
        this.mButtonPrev.setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                MoreUsefulFeaturesActivity.this.onClickPrevButton();
            }
        });
        this.mButtonNext.setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                MoreUsefulFeaturesActivity.this.onClickNextButton();
            }
        });
        this.mButtonGotIt.setOnClickListener(new OnSingleClickListener() {
            public void onSingleClick(View view) {
                MoreUsefulFeaturesActivity.this.onClickGotItButton();
            }
        });
        setActivityAccessibility(getString(R.string.how_to_wear_your_earbuds));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        this.mNextActionHandler.removeCallbacksAndMessages((Object) null);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
        SamsungAnalyticsUtil.sendPage(SA.Screen.MORE_USEFUL_FEATURES_1_ONLY);
        updateUI();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    private void updateUI() {
        Log.d(TAG, "updateUI()");
        updateUIBottom((Integer) null);
    }

    /* access modifiers changed from: private */
    public void onClickSkipButton() {
        Log.d(TAG, "onClickSkipButton()");
        SamsungAnalyticsUtil.sendEvent(SA.Event.SKIP, SA.Screen.MORE_USEFUL_FEATURES_1);
        startYouAreAllSetActivity();
    }

    /* access modifiers changed from: private */
    public void onClickPrevButton() {
        Log.d(TAG, "onClickPrevButton()");
        int currentItem = this.mViewPager.getCurrentItem();
        if (currentItem > 0) {
            int i = currentItem - 1;
            selectPage(i, true);
            showAnimation(i);
        }
    }

    /* access modifiers changed from: private */
    public void onClickNextButton() {
        Log.d(TAG, "onClickNextButton()");
        int currentItem = this.mViewPager.getCurrentItem();
        if (currentItem < this.mViewPagerAdapter.getCount() - 1) {
            int i = currentItem + 1;
            selectPage(i, true);
            showAnimation(i);
        }
        SamsungAnalyticsUtil.sendEvent(SA.Event.NEXT, SA.Screen.MORE_USEFUL_FEATURES_1);
    }

    /* access modifiers changed from: private */
    public void onClickGotItButton() {
        Log.d(TAG, "onClickGotItButton()");
        SamsungAnalyticsUtil.sendEvent(SA.Event.GOT_IT, SA.Screen.MORE_USEFUL_FEATURES_1_ONLY);
        startYouAreAllSetActivity();
    }

    private void startYouAreAllSetActivity() {
        Log.d(TAG, "startYouAreAllSetActivity() : " + this.mStartedYouAreAllSetActivity);
        this.mNextActionHandler.removeCallbacksAndMessages((Object) null);
        if (!this.mStartedYouAreAllSetActivity) {
            this.mStartedYouAreAllSetActivity = true;
            startActivityForResult(new Intent(this, YouAreAllSetActivity.class), 0);
        }
        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.activity_fade_in, R.anim.activity_fade_out);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Log.d(TAG, "onActivityResult() : requestCode=" + i + ", resultCode=" + i2);
        if (i2 == -1) {
            setResult(-1);
            finish();
        }
    }

    public void onPageSelected(int i) {
        Log.d(TAG, "onPageSelected() : " + i);
        updateUIBottom(Integer.valueOf(i));
    }

    public void onPageScrollStateChanged(int i) {
        Log.d(TAG, "onPageScrollStateChanged() : " + i);
    }

    private void selectPage(int i, boolean z) {
        Log.d(TAG, "selectPage() : " + i);
        this.mViewPager.setCurrentItem(i, z);
        if (i == 0) {
            SamsungAnalyticsUtil.sendPage(SA.Screen.MORE_USEFUL_FEATURES_1);
            setActivityAccessibility(getString(R.string.how_to_wear_your_earbuds));
        }
    }

    private void updateUIBottom(Integer num) {
        if (num == null) {
            num = Integer.valueOf(this.mViewPager.getCurrentItem());
        }
        boolean z = true;
        int i = 0;
        boolean z2 = num.intValue() == this.mViewPagerAdapter.getCount() - 1;
        boolean z3 = num.intValue() == 0;
        if (this.mViewPagerAdapter.getCount() <= 1) {
            z = false;
        }
        this.mPageIndicatorView.setPageSelect(num.intValue());
        this.mPageIndicatorView.setVisibility(z ? 0 : 8);
        this.mButtonSkip.setVisibility((!z3 || !z) ? 8 : 0);
        this.mButtonPrev.setVisibility(z3 ? 8 : 0);
        this.mButtonNext.setVisibility(z2 ? 8 : 0);
        View view = this.mButtonGotIt;
        if (!z2) {
            i = 8;
        }
        view.setVisibility(i);
    }

    private void showAnimation(int i) {
        Log.d(TAG, "showAnimation() : " + i);
        if (i == 0) {
            showAnimationHowToWear();
        }
    }

    private void showAnimationHowToWear() {
        Log.d(TAG, "showAnimationHowToWear()");
        this.mNextActionHandler.removeCallbacksAndMessages((Object) null);
    }

    private static class OpacityLayoutTransition extends LayoutTransition {
        public OpacityLayoutTransition() {
            setDuration(2, 300);
            setInterpolator(2, new LinearInterpolator());
            setDuration(3, 300);
            setInterpolator(3, new LinearInterpolator());
        }
    }

    private void setActivityAccessibility(String str) {
        findViewById(R.id.layout_activity).setContentDescription(str);
        setTitle(str);
    }
}
