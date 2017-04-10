/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Throwable
 */
package com.google.a;

import com.google.a.b.a.f;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.l;
import com.google.a.m;
import java.io.IOException;

public abstract class w<T> {
    public final l a(T t2) {
        try {
            f f2 = new f();
            this.a(f2, t2);
            l l2 = f2.a();
            return l2;
        }
        catch (IOException var3_4) {
            throw new m((Throwable)var3_4);
        }
    }

    public final w<T> a() {
        return new w<T>(){

            @Override
            public void a(c c2, T t2) throws IOException {
                if (t2 == null) {
                    c2.f();
                    return;
                }
                w.this.a(c2, t2);
            }

            @Override
            public T b(a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                return w.this.b(a2);
            }
        };
    }

    public abstract void a(c var1, T var2) throws IOException;

    public abstract T b(a var1) throws IOException;

}

