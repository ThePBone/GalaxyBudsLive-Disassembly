package androidx.reflect.lunarcalendar;

import androidx.reflect.SeslBaseReflector;
import androidx.reflect.SeslPathClassReflector;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Method;

public class SeslFeatureReflector {
    private static final String mClassName = "com.android.calendar.Feature";

    private SeslFeatureReflector() {
    }

    public static Object getSolarLunarConverter(PathClassLoader pathClassLoader) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getSolarLunarConverter", new Class[0]);
        if (method != null) {
            return SeslBaseReflector.invoke((Object) null, method, new Object[0]);
        }
        return null;
    }

    public static Object getSolarLunarTables(PathClassLoader pathClassLoader) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "getSolarLunarTables", new Class[0]);
        if (method != null) {
            return SeslBaseReflector.invoke((Object) null, method, new Object[0]);
        }
        return null;
    }
}
