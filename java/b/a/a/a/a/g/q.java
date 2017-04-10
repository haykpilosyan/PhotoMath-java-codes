/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.atomic.AtomicReference
 */
package b.a.a.a.a.g;

import android.content.Context;
import b.a.a.a.a.b.o;
import b.a.a.a.a.e.e;
import b.a.a.a.a.g.g;
import b.a.a.a.a.g.i;
import b.a.a.a.a.g.j;
import b.a.a.a.a.g.k;
import b.a.a.a.a.g.l;
import b.a.a.a.a.g.r;
import b.a.a.a.a.g.s;
import b.a.a.a.a.g.t;
import b.a.a.a.a.g.v;
import b.a.a.a.a.g.w;
import b.a.a.a.a.g.x;
import b.a.a.a.c;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class q {
    private final AtomicReference<t> a = new AtomicReference();
    private final CountDownLatch b = new CountDownLatch(1);
    private s c;
    private boolean d = false;

    private q() {
    }

    public static q a() {
        return a;
    }

    private void a(t t2) {
        this.a.set((Object)t2);
        this.b.countDown();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public q a(b.a.a.a.i i2, o o2, e e2, String string, String string2, String string3) {
        q q2 = this;
        synchronized (q2) {
            boolean bl = this.d;
            if (bl) {
                return this;
            }
            if (this.c == null) {
                Context context = i2.r();
                String string4 = o2.c();
                String string5 = new b.a.a.a.a.b.g().a(context);
                String string6 = o2.j();
                b.a.a.a.a.b.s s2 = new b.a.a.a.a.b.s();
                k k2 = new k();
                i i3 = new i(i2);
                String string7 = b.a.a.a.a.b.i.k(context);
                String string8 = String.format((Locale)Locale.US, (String)"https://settings.crashlytics.com/spi/v2/platforms/android/apps/%s/settings", (Object[])new Object[]{string4});
                l l2 = new l(i2, string3, string8, e2);
                String string9 = o2.g();
                String string10 = o2.f();
                String string11 = o2.e();
                String string12 = o2.m();
                String string13 = o2.b();
                String string14 = o2.n();
                String[] arrstring = new String[]{b.a.a.a.a.b.i.m(context)};
                this.c = new j(i2, new w(string5, string9, string10, string11, string12, string13, string14, b.a.a.a.a.b.i.a(arrstring), string2, string, b.a.a.a.a.b.l.a(string6).a(), string7), s2, k2, i3, l2);
            }
            this.d = true;
            return this;
        }
    }

    public t b() {
        try {
            this.b.await();
            t t2 = (t)this.a.get();
            return t2;
        }
        catch (InterruptedException var1_2) {
            c.h().e("Fabric", "Interrupted while waiting for settings data.");
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean c() {
        q q2 = this;
        synchronized (q2) {
            t t2 = this.c.a();
            this.a(t2);
            if (t2 == null) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean d() {
        q q2 = this;
        synchronized (q2) {
            t t2 = this.c.a(r.b);
            this.a(t2);
            if (t2 == null) {
                c.h().e("Fabric", "Failed to force reload of settings from Crashlytics.", null);
            }
            if (t2 == null) return false;
            return true;
        }
    }

    static class a {
        private static final q a = new q();
    }

}

