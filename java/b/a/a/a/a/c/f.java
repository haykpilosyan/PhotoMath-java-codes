/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.concurrent.Executor
 *  java.util.concurrent.ExecutorService
 */
package b.a.a.a.a.c;

import b.a.a.a.a.c.a;
import b.a.a.a.a.c.b;
import b.a.a.a.a.c.e;
import b.a.a.a.a.c.h;
import b.a.a.a.a.c.i;
import b.a.a.a.a.c.j;
import b.a.a.a.a.c.l;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public abstract class f<Params, Progress, Result>
extends b.a.a.a.a.c.a<Params, Progress, Result>
implements b<l>,
i,
l {
    private final j a = new j();

    @Override
    public void a(l l2) {
        if (this.b_() != a.d.a) {
            throw new IllegalStateException("Must not add Dependency after task is running");
        }
        ((b)((Object)((i)this.g()))).c(l2);
    }

    @Override
    public void a(Throwable throwable) {
        ((l)((Object)((i)this.g()))).a(throwable);
    }

    public final /* varargs */ void a(ExecutorService executorService, Params ... arrParams) {
        super.a(new a((Executor)executorService, this), arrParams);
    }

    @Override
    public e b() {
        return ((i)this.g()).b();
    }

    @Override
    public void b(boolean bl) {
        ((l)((Object)((i)this.g()))).b(bl);
    }

    @Override
    public Collection<l> c() {
        return ((b)((Object)((i)this.g()))).c();
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((l)object);
    }

    public int compareTo(Object object) {
        return e.a(this, object);
    }

    @Override
    public boolean d() {
        return ((b)((Object)((i)this.g()))).d();
    }

    @Override
    public boolean f() {
        return ((l)((Object)((i)this.g()))).f();
    }

    public <T extends b<l>,  extends i> T g() {
        return (T)this.a;
    }

    private static class a<Result>
    implements Executor {
        private final Executor a;
        private final f b;

        public a(Executor executor, f f2) {
            this.a = executor;
            this.b = f2;
        }

        public void execute(Runnable runnable) {
            this.a.execute((Runnable)new h<Result>(runnable, null){

                @Override
                public <T extends b<l>,  extends i> T a() {
                    return (T)a.this.b;
                }
            });
        }

    }

}

