package com.samsung.accessory.neobeanmgr.core.appwidget.base;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.samsung.accessory.neobeanmgr.core.appwidget.util.WidgetInfoManager;
import java.util.ArrayList;

public abstract class WidgetBaseProvider extends AppWidgetProvider {
    /* access modifiers changed from: protected */
    public abstract RemoteViews getRemoteView(Context context, int i);

    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        updateUI(context, appWidgetManager, iArr);
    }

    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
        WidgetInfoManager widgetInfoManager = new WidgetInfoManager(context, getClass());
        for (int removeWidgetInfo : iArr) {
            widgetInfoManager.removeWidgetInfo(removeWidgetInfo);
        }
    }

    public void updateUI(Context context) {
        AppWidgetManager instance = AppWidgetManager.getInstance(context);
        updateUI(context, instance, instance.getAppWidgetIds(new ComponentName(context, getClass())));
    }

    /* access modifiers changed from: protected */
    public void updateUI(final Context context, final int i) {
        new Thread(new Runnable() {
            public void run() {
                AppWidgetManager instance = AppWidgetManager.getInstance(context);
                int i = i;
                instance.updateAppWidget(i, WidgetBaseProvider.this.getRemoteView(context, i));
            }
        }).start();
    }

    private void updateUI(final Context context, final AppWidgetManager appWidgetManager, final int[] iArr) {
        new Thread(new Runnable() {
            public void run() {
                ArrayList arrayList = new ArrayList();
                for (int remoteView : iArr) {
                    arrayList.add(WidgetBaseProvider.this.getRemoteView(context, remoteView));
                }
                for (int i = 0; i < arrayList.size(); i++) {
                    appWidgetManager.updateAppWidget(iArr[i], (RemoteViews) arrayList.get(i));
                }
            }
        }).start();
    }

    /* access modifiers changed from: protected */
    public PendingIntent getPendingIntent(Context context, String str) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(str);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
}
