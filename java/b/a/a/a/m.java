/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.Future
 */
package b.a.a.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import b.a.a.a.a.b.g;
import b.a.a.a.a.b.i;
import b.a.a.a.a.b.l;
import b.a.a.a.a.b.o;
import b.a.a.a.a.e.b;
import b.a.a.a.a.g.d;
import b.a.a.a.a.g.e;
import b.a.a.a.a.g.h;
import b.a.a.a.a.g.n;
import b.a.a.a.a.g.q;
import b.a.a.a.a.g.t;
import b.a.a.a.a.g.y;
import b.a.a.a.c;
import b.a.a.a.k;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

class m
extends b.a.a.a.i<Boolean> {
    private final b.a.a.a.a.e.e a = new b();
    private PackageManager b;
    private String c;
    private PackageInfo d;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private final Future<Map<String, k>> p;
    private final Collection<b.a.a.a.i> q;

    public m(Future<Map<String, k>> future, Collection<b.a.a.a.i> collection) {
        this.p = future;
        this.q = collection;
    }

    private d a(n n2, Collection<k> collection) {
        Context context = this.r();
        String string = new g().a(context);
        String string2 = i.a(new String[]{i.m(context)});
        int n3 = l.a(this.m).a();
        return new d(string, this.q().c(), this.l, this.k, string2, this.n, n3, this.o, "0", n2, collection);
    }

    private boolean a(e e2, n n2, Collection<k> collection) {
        d d2 = this.a(n2, collection);
        return new y(this, this.e(), e2.c, this.a).a(d2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean a(String string, e e2, Collection<k> collection) {
        boolean bl = true;
        if ("new".equals((Object)e2.b)) {
            if (this.b(string, e2, collection)) {
                return q.a().d();
            }
            c.h().e("Fabric", "Failed to create app with Crashlytics service.", null);
            return false;
        }
        if ("configured".equals((Object)e2.b)) {
            return q.a().d();
        }
        if (!e2.e) return bl;
        c.h().a("Fabric", "Server says an update is required - forcing a full App update.");
        this.c(string, e2, collection);
        return bl;
    }

    private boolean b(String string, e e2, Collection<k> collection) {
        d d2 = this.a(n.a(this.r(), string), collection);
        return new h(this, this.e(), e2.c, this.a).a(d2);
    }

    private boolean c(String string, e e2, Collection<k> collection) {
        return this.a(e2, n.a(this.r(), string), collection);
    }

    private t g() {
        try {
            q.a().a(this, this.i, this.a, this.k, this.l, this.e()).c();
            t t2 = q.a().b();
            return t2;
        }
        catch (Exception var1_2) {
            c.h().e("Fabric", "Error dealing with settings", (Throwable)var1_2);
            return null;
        }
    }

    @Override
    public String a() {
        return "1.3.16.dev";
    }

    Map<String, k> a(Map<String, k> map, Collection<b.a.a.a.i> collection) {
        for (b.a.a.a.i i2 : collection) {
            if (map.containsKey((Object)i2.b())) continue;
            map.put((Object)i2.b(), (Object)new k(i2.b(), i2.a(), "binary"));
        }
        return map;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected boolean a_() {
        try {
            this.m = this.q().j();
            this.b = this.r().getPackageManager();
            this.c = this.r().getPackageName();
            this.d = this.b.getPackageInfo(this.c, 0);
            this.k = Integer.toString((int)this.d.versionCode);
            String string = this.d.versionName == null ? "0.0" : this.d.versionName;
            this.l = string;
            this.n = this.b.getApplicationLabel(this.r().getApplicationInfo()).toString();
            this.o = Integer.toString((int)this.r().getApplicationInfo().targetSdkVersion);
            return true;
        }
        catch (PackageManager.NameNotFoundException var1_2) {
            c.h().e("Fabric", "Failed init", (Throwable)var1_2);
            return false;
        }
    }

    @Override
    public String b() {
        return "io.fabric.sdk.android:fabric";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected Boolean d() {
        boolean bl;
        String string = i.k(this.r());
        t t2 = this.g();
        if (t2 != null) {
            try {
                boolean bl2;
                Map map = this.p != null ? (Map)this.p.get() : new HashMap();
                Map<String, k> map2 = this.a(map, this.q);
                bl = bl2 = this.a(string, t2.a, map2.values());
            }
            catch (Exception var4_7) {
                c.h().e("Fabric", "Error performing auto configuration.", (Throwable)var4_7);
            }
            return bl;
        }
        bl = false;
        return bl;
    }

    String e() {
        return i.b(this.r(), "com.crashlytics.ApiEndpoint");
    }

    @Override
    protected /* synthetic */ Object f() {
        return this.d();
    }
}

