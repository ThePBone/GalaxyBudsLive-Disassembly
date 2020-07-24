package com.samsung.android.fotaprovider.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.samsung.android.fotaprovider.log.Log;

public final class ResponsiveWidthLinearLayout extends LinearLayout {
    public ResponsiveWidthLinearLayout(Context context) {
        super(context);
    }

    public ResponsiveWidthLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ResponsiveWidthLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ResponsiveWidthLinearLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3 = getResources().getConfiguration().screenWidthDp;
        int i4 = getResources().getConfiguration().screenHeightDp;
        int i5 = getResources().getConfiguration().densityDpi;
        Log.D("onMeasure() : screenWidthDp=" + i3 + ", screenHeightDp=" + i4 + ", densityDpi=" + i5);
        if (i3 >= 1920) {
            i = setMaxWidth(i, i3, 50);
        } else if (i3 >= 960) {
            i = setMaxWidth(i, i3, 75);
        } else if (i3 >= 685 && i4 > 411) {
            i = setMaxWidth(i, i3, 90);
        }
        super.onMeasure(i, i2);
    }

    private int makeExactlyMeasureSpec(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                return View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            }
            if (mode != 1073741824) {
                return i;
            }
        }
        return size >= i2 ? View.MeasureSpec.makeMeasureSpec(i2, 1073741824) : i;
    }

    private int dpToPixel(int i) {
        return (i * getResources().getConfiguration().densityDpi) / 160;
    }

    private int setMaxWidth(int i, int i2, int i3) {
        int i4 = (i2 * i3) / 100;
        Log.D("force screenWidthDp=" + i4 + " (" + i3 + "%)");
        return makeExactlyMeasureSpec(i, dpToPixel(i4));
    }
}
