/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.SparseArray
 *  java.lang.Object
 *  java.lang.String
 *  java.util.WeakHashMap
 */
package a.a.a.a;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import java.util.WeakHashMap;

public class d
implements Application.ActivityLifecycleCallbacks {
    private static final String a = d.class.getSimpleName();
    private static d b;
    private a.a.a.a.a.a c;
    private final WeakHashMap<Context, a.a.a.d> d = new WeakHashMap();
    private final SparseArray<a.a.a.d> e = new SparseArray(3);
    private int f;

    private d(Context context) {
        ((Application)context.getApplicationContext()).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }

    public static d a(Context context) {
        if (b == null) {
            b = new d(context);
        }
        return b;
    }

    public a.a.a.a.a.a a() {
        d d2 = this;
        synchronized (d2) {
            if (this.c == null) {
                this.c = new a.a.a.a.a.a();
            }
            a.a.a.a.a.a a2 = this.c;
            return a2;
        }
    }

    public a.a.a.d b(Context context) {
        a.a.a.d d2 = new a.a.a.d(context);
        this.d.put((Object)context, (Object)d2);
        return d2;
    }

    public a.a.a.d c(Context context) {
        return (a.a.a.d)this.d.get((Object)context);
    }

    void d(Context context) {
        a.a.a.d d2 = (a.a.a.d)this.d.get((Object)context);
        if (d2 != null) {
            d2.b().b();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    void e(Context context) {
        a.a.a.d d2 = (a.a.a.d)this.d.remove((Object)context);
        if (d2 != null) {
            if (context instanceof Activity && ((Activity)context).isChangingConfigurations()) {
                return;
            }
            boolean bl = false;
            if (!bl) {
                d2.b().c();
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        a.a.a.d d2;
        int n2;
        if (bundle != null && (n2 = bundle.getInt("de.halfbit.tinybus.id", -1)) > -1 && (d2 = (a.a.a.d)this.e.get(n2)) != null) {
            this.e.delete(n2);
            d2.b().a((Context)activity);
            this.d.put((Object)activity, (Object)d2);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        this.e((Context)activity);
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        a.a.a.d d2;
        if (activity.isChangingConfigurations() && (d2 = (a.a.a.d)this.d.get((Object)activity)) != null) {
            int n2 = this.f;
            this.f = n2 + 1;
            this.e.put(n2, (Object)d2);
            bundle.putInt("de.halfbit.tinybus.id", n2);
        }
    }

    public void onActivityStarted(Activity activity) {
        a.a.a.d d2 = (a.a.a.d)this.d.get((Object)activity);
        if (d2 != null) {
            d2.b().a();
        }
    }

    public void onActivityStopped(Activity activity) {
        this.d((Context)activity);
    }

    public static interface a {
        public void a();

        public void a(Context var1);

        public void b();

        public void c();
    }

}

