package seccompat;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Field;

public class SecCompatUtil {
    private static final String TAG = "NeoBean_SecCompatUtil";
    private static final boolean sIsSEPDevice;

    static {
        boolean z;
        try {
            Class.forName("android.content.pm.PackageManager").getField("SEM_FEATURE_SAMSUNG_EXPERIENCE_MOBILE");
            z = true;
        } catch (Exception unused) {
            Log.w(TAG, "ReflectiveOperationException e");
            z = false;
        }
        sIsSEPDevice = z;
    }

    public static boolean isSEPDevice() {
        return sIsSEPDevice;
    }

    public static boolean isSemAvailable(Context context) {
        return context.getPackageManager().hasSystemFeature("com.samsung.feature.samsung_experience_mobile");
    }

    public static int getSemPlatformVersion() {
        Log.d(TAG, "getSemPlatformVersion");
        int i = -1;
        try {
            Field field = Build.VERSION.class.getField("SEM_PLATFORM_INT");
            if (field != null) {
                i = field.getInt(field);
                Log.d(TAG, "getSemPlatformVersion : " + i);
            } else {
                Log.w(TAG, "getSemPlatformVersion - field not exist");
            }
        } catch (Exception unused) {
            Log.w(TAG, "ReflectiveOperationException e");
        }
        Log.d(TAG, "getSemPlatformVersion : " + i);
        return i;
    }
}
