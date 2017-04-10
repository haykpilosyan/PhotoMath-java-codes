/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 */
package com.google.a;

import com.google.a.b.j;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.k;
import com.google.a.l;
import com.google.a.r;
import com.google.a.s;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Type;

final class v<T>
extends w<T> {
    private final s<T> a;
    private final k<T> b;
    private final f c;
    private final com.google.a.c.a<T> d;
    private final x e;
    private w<T> f;

    v(s<T> s2, k<T> k2, f f2, com.google.a.c.a<T> a2, x x2) {
        this.a = s2;
        this.b = k2;
        this.c = f2;
        this.d = a2;
        this.e = x2;
    }

    public static x a(com.google.a.c.a<?> a2, Object object) {
        return new a(object, a2, false, null);
    }

    private w<T> b() {
        w<T> w2;
        w<T> w3 = this.f;
        if (w3 != null) {
            return w3;
        }
        this.f = w2 = this.c.a(this.e, this.d);
        return w2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static x b(com.google.a.c.a<?> a2, Object object) {
        boolean bl;
        if (a2.getType() == a2.getRawType()) {
            bl = true;
            do {
                return new a(object, a2, bl, null);
                break;
            } while (true);
        }
        bl = false;
        return new a(object, a2, bl, null);
    }

    @Override
    public void a(c c2, T t2) throws IOException {
        if (this.a == null) {
            this.b().a(c2, t2);
            return;
        }
        if (t2 == null) {
            c2.f();
            return;
        }
        j.a(this.a.serialize(t2, this.d.getType(), this.c.b), c2);
    }

    @Override
    public T b(com.google.a.d.a a2) throws IOException {
        if (this.b == null) {
            return this.b().b(a2);
        }
        l l2 = j.a(a2);
        if (l2.j()) {
            return null;
        }
        return this.b.deserialize(l2, this.d.getType(), this.c.a);
    }

    private static class a
    implements x {
        private final com.google.a.c.a<?> a;
        private final boolean b;
        private final Class<?> c;
        private final s<?> d;
        private final k<?> e;

        /*
         * Enabled aggressive block sorting
         */
        a(Object object, com.google.a.c.a<?> a2, boolean bl, Class<?> class_) {
            s s2 = object instanceof s ? (s)object : null;
            this.d = s2;
            k k2 = object instanceof k ? (k)object : null;
            this.e = k2;
            boolean bl2 = this.d != null || this.e != null;
            com.google.a.b.a.a(bl2);
            this.a = a2;
            this.b = bl;
            this.c = class_;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public <T> w<T> a(f f2, com.google.a.c.a<T> a2) {
            if (this.a != null) {
                if (this.a.equals(a2) || this.b && this.a.getType() == a2.getRawType()) {
                    return new v(this.d, this.e, f2, a2, this);
                }
                return null;
            }
            boolean bl = this.c.isAssignableFrom(a2.getRawType());
            if (bl) {
                return new v(this.d, this.e, f2, a2, this);
            }
            return null;
        }
    }

}

