/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package b.a.a.a.a.a;

import android.content.Context;
import b.a.a.a.a.a.a;
import b.a.a.a.a.a.c;

public class b<T>
extends a<T> {
    private T a;

    public b() {
        this(null);
    }

    public b(c<T> c2) {
        super(c2);
    }

    @Override
    protected T a(Context context) {
        return this.a;
    }

    @Override
    protected void a(Context context, T t2) {
        this.a = t2;
    }
}

