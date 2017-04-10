/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.lang.annotation.Annotation
 *  java.util.Collection
 *  java.util.concurrent.ExecutorService
 */
package b.a.a.a;

import android.content.Context;
import b.a.a.a.a.b.o;
import b.a.a.a.a.c.d;
import b.a.a.a.a.c.l;
import b.a.a.a.c;
import b.a.a.a.f;
import b.a.a.a.h;
import java.io.File;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class i<Result>
implements Comparable<i> {
    c e;
    h<Result> f;
    Context g;
    f<Result> h;
    o i;
    final d j;

    public i() {
        this.f = new h(this);
        this.j = (d)this.getClass().getAnnotation((Class)d.class);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public int a(i i2) {
        if (this.b(i2)) {
            return 1;
        }
        if (i2.b(this)) {
            return -1;
        }
        if (this.u()) {
            if (!i2.u()) return 1;
        }
        if (this.u()) return 0;
        if (!i2.u()) return 0;
        return -1;
    }

    public abstract String a();

    void a(Context context, c c2, f<Result> f2, o o2) {
        this.e = c2;
        this.g = new b.a.a.a.d(context, this.b(), this.t());
        this.h = f2;
        this.i = o2;
    }

    protected void a(Result Result) {
    }

    protected boolean a_() {
        return true;
    }

    public abstract String b();

    protected void b(Result Result) {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean b(i i2) {
        boolean bl = this.u();
        boolean bl2 = false;
        if (!bl) return bl2;
        Class<?>[] arrclass = this.j.a();
        int n2 = arrclass.length;
        int n3 = 0;
        do {
            bl2 = false;
            if (n3 >= n2) return bl2;
            if (arrclass[n3].isAssignableFrom(i2.getClass())) {
                return true;
            }
            ++n3;
        } while (true);
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((i)object);
    }

    protected abstract Result f();

    final void p() {
        h<Result> h2 = this.f;
        ExecutorService executorService = this.e.f();
        Void[] arrvoid = new Void[]{null};
        h2.a(executorService, (Params[])arrvoid);
    }

    protected o q() {
        return this.i;
    }

    public Context r() {
        return this.g;
    }

    public c s() {
        return this.e;
    }

    public String t() {
        return ".Fabric" + File.separator + this.b();
    }

    boolean u() {
        if (this.j != null) {
            return true;
        }
        return false;
    }

    protected Collection<l> v() {
        return this.f.c();
    }
}

