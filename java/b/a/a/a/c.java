/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.Callable
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package b.a.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import b.a.a.a.a;
import b.a.a.a.a.b.o;
import b.a.a.a.a.c.d;
import b.a.a.a.a.c.k;
import b.a.a.a.a.c.m;
import b.a.a.a.b;
import b.a.a.a.e;
import b.a.a.a.f;
import b.a.a.a.h;
import b.a.a.a.i;
import b.a.a.a.j;
import b.a.a.a.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class c {
    static volatile c a;
    static final l b;
    final l c;
    final boolean d;
    private final Context e;
    private final Map<Class<? extends i>, i> f;
    private final ExecutorService g;
    private final Handler h;
    private final f<c> i;
    private final f<?> j;
    private final o k;
    private b.a.a.a.a l;
    private WeakReference<Activity> m;
    private AtomicBoolean n;

    static {
        b = new b();
    }

    c(Context context, Map<Class<? extends i>, i> map, k k2, Handler handler, l l2, boolean bl, f f2, o o2) {
        this.e = context.getApplicationContext();
        this.f = map;
        this.g = k2;
        this.h = handler;
        this.c = l2;
        this.d = bl;
        this.i = f2;
        this.n = new AtomicBoolean(false);
        this.j = this.a(map.size());
        this.k = o2;
        this.a(this.c(context));
    }

    static c a() {
        if (a == null) {
            throw new IllegalStateException("Must Initialize Fabric before using singleton()");
        }
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static /* varargs */ c a(Context context, i ... arri) {
        if (a != null) return a;
        reference var3_2 = c.class;
        // MONITORENTER : b.a.a.a.c.class
        if (a == null) {
            c.c(new a(context).a(arri).a());
        }
        // MONITOREXIT : var3_2
        return a;
    }

    public static <T extends i> T a(Class<T> class_) {
        return (T)((i)c.a().f.get(class_));
    }

    private static void a(Map<Class<? extends i>, i> map, Collection<? extends i> collection) {
        for (i i2 : collection) {
            map.put((Object)i2.getClass(), (Object)i2);
            if (!(i2 instanceof j)) continue;
            c.a(map, ((j)((Object)i2)).c());
        }
    }

    private static Map<Class<? extends i>, i> b(Collection<? extends i> collection) {
        HashMap hashMap = new HashMap(collection.size());
        c.a(hashMap, collection);
        return hashMap;
    }

    private Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity)context;
        }
        return null;
    }

    private static void c(c c2) {
        a = c2;
        c2.j();
    }

    public static l h() {
        if (a == null) {
            return b;
        }
        return c.a.c;
    }

    public static boolean i() {
        if (a == null) {
            return false;
        }
        return c.a.d;
    }

    private void j() {
        this.l = new b.a.a.a.a(this.e);
        this.l.a(new a.b(){

            @Override
            public void a(Activity activity) {
                c.this.a(activity);
            }

            @Override
            public void a(Activity activity, Bundle bundle) {
                c.this.a(activity);
            }

            @Override
            public void b(Activity activity) {
                c.this.a(activity);
            }
        });
        this.a(this.e);
    }

    public c a(Activity activity) {
        this.m = new WeakReference((Object)activity);
        return this;
    }

    f<?> a(final int n2) {
        return new f(){
            final CountDownLatch a;

            @Override
            public void a(Exception exception) {
                c.this.i.a(exception);
            }

            public void a(Object object) {
                this.a.countDown();
                if (this.a.getCount() == 0) {
                    c.this.n.set(true);
                    c.this.i.a(c.this);
                }
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(Context context) {
        Future<Map<String, b.a.a.a.k>> future = this.b(context);
        Collection<i> collection = this.g();
        b.a.a.a.m m2 = new b.a.a.a.m(future, collection);
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort((List)arrayList);
        m2.a(context, this, f.d, this.k);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            ((i)iterator.next()).a(context, this, this.j, this.k);
        }
        m2.p();
        StringBuilder stringBuilder = c.h().a("Fabric", 3) ? new StringBuilder("Initializing ").append(this.d()).append(" [Version: ").append(this.c()).append("], with the following kits:\n") : null;
        for (i i2 : arrayList) {
            i2.f.a(m2.f);
            this.a(this.f, i2);
            i2.p();
            if (stringBuilder == null) continue;
            stringBuilder.append(i2.b()).append(" [Version: ").append(i2.a()).append("]\n");
        }
        if (stringBuilder != null) {
            c.h().a("Fabric", stringBuilder.toString());
        }
    }

    void a(Map<Class<? extends i>, i> map, i i2) {
        d d2 = i2.j;
        if (d2 != null) {
            for (Class class_ : d2.a()) {
                if (class_.isInterface()) {
                    for (i i3 : map.values()) {
                        if (!class_.isAssignableFrom(i3.getClass())) continue;
                        i2.f.a(i3.f);
                    }
                    continue;
                }
                if ((i)map.get(class_) == null) {
                    throw new m("Referenced Kit was null, does the kit exist?");
                }
                i2.f.a(((i)map.get(class_)).f);
            }
        }
    }

    public Activity b() {
        if (this.m != null) {
            return (Activity)this.m.get();
        }
        return null;
    }

    Future<Map<String, b.a.a.a.k>> b(Context context) {
        e e2 = new e(context.getPackageCodePath());
        return this.f().submit((Callable)e2);
    }

    public String c() {
        return "1.3.16.dev";
    }

    public String d() {
        return "io.fabric.sdk.android:fabric";
    }

    public b.a.a.a.a e() {
        return this.l;
    }

    public ExecutorService f() {
        return this.g;
    }

    public Collection<i> g() {
        return this.f.values();
    }

    public static class a {
        private final Context a;
        private i[] b;
        private k c;
        private Handler d;
        private l e;
        private boolean f;
        private String g;
        private String h;
        private f<c> i;

        public a(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.a = context;
        }

        public /* varargs */ a a(i ... arri) {
            if (this.b != null) {
                throw new IllegalStateException("Kits already set.");
            }
            this.b = arri;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public c a() {
            if (this.c == null) {
                this.c = k.a();
            }
            if (this.d == null) {
                this.d = new Handler(Looper.getMainLooper());
            }
            if (this.e == null) {
                this.e = this.f ? new b(3) : new b();
            }
            if (this.h == null) {
                this.h = this.a.getPackageName();
            }
            if (this.i == null) {
                this.i = f.d;
            }
            HashMap hashMap = this.b == null ? new HashMap() : c.b((Collection)Arrays.asList((Object[])this.b));
            o o2 = new o(this.a, this.h, this.g, hashMap.values());
            return new c(this.a, (Map<Class<? extends i>, i>)hashMap, this.c, this.d, this.e, this.f, this.i, o2);
        }
    }

}

