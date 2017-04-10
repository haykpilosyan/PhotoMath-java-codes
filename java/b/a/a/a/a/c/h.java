/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.concurrent.Callable
 *  java.util.concurrent.FutureTask
 */
package b.a.a.a.a.c;

import b.a.a.a.a.c.b;
import b.a.a.a.a.c.e;
import b.a.a.a.a.c.i;
import b.a.a.a.a.c.j;
import b.a.a.a.a.c.l;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class h<V>
extends FutureTask<V>
implements b<l>,
i,
l {
    final Object b;

    public h(Runnable runnable, V v2) {
        super(runnable, v2);
        this.b = this.a((Object)runnable);
    }

    public h(Callable<V> callable) {
        super(callable);
        this.b = this.a(callable);
    }

    public <T extends b<l>,  extends i> T a() {
        return (T)((b)this.b);
    }

    protected <T extends b<l>,  extends i> T a(Object object) {
        if (j.a(object)) {
            return (T)((b)object);
        }
        return (T)new j();
    }

    public void a(l l2) {
        ((b)((Object)((i)this.a()))).c(l2);
    }

    @Override
    public void a(Throwable throwable) {
        ((l)((Object)((i)this.a()))).a(throwable);
    }

    @Override
    public e b() {
        return ((i)this.a()).b();
    }

    @Override
    public void b(boolean bl) {
        ((l)((Object)((i)this.a()))).b(bl);
    }

    @Override
    public Collection<l> c() {
        return ((b)((Object)((i)this.a()))).c();
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((l)object);
    }

    public int compareTo(Object object) {
        return ((i)this.a()).compareTo(object);
    }

    @Override
    public boolean d() {
        return ((b)((Object)((i)this.a()))).d();
    }

    @Override
    public boolean f() {
        return ((l)((Object)((i)this.a()))).f();
    }
}

