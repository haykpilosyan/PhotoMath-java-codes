/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 */
package b.a.a.a.a.a;

import android.content.Context;
import b.a.a.a.a.a.c;
import b.a.a.a.a.a.d;

public abstract class a<T>
implements c<T> {
    private final c<T> a;

    public a(c<T> c2) {
        this.a = c2;
    }

    private void b(Context context, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        this.a(context, t2);
    }

    protected abstract T a(Context var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public final T a(Context context, d<T> d2) throws Exception {
        a a2 = this;
        synchronized (a2) {
            T t2 = this.a(context);
            if (t2 == null) {
                T t3;
                t2 = this.a != null ? this.a.a(context, d2) : (t3 = d2.b(context));
                this.b(context, t2);
            }
            return t2;
        }
    }

    protected abstract void a(Context var1, T var2);
}

