/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 */
package com.google.a.b.a;

import com.google.a.b.g;
import com.google.a.d.a;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.util.ArrayList;

public final class h
extends w<Object> {
    public static final x a = new x(){

        @Override
        public <T> w<T> a(f f2, com.google.a.c.a<T> a2) {
            if (a2.getRawType() == Object.class) {
                return new h(f2);
            }
            return null;
        }
    };
    private final f b;

    h(f f2) {
        this.b = f2;
    }

    @Override
    public void a(c c2, Object object) throws IOException {
        if (object == null) {
            c2.f();
            return;
        }
        w<Object> w2 = this.b.a(object.getClass());
        if (w2 instanceof h) {
            c2.d();
            c2.e();
            return;
        }
        w2.a(c2, object);
    }

    @Override
    public Object b(a a2) throws IOException {
        b b2 = a2.f();
        switch (.a[b2.ordinal()]) {
            default: {
                throw new IllegalStateException();
            }
            case 1: {
                ArrayList arrayList = new ArrayList();
                a2.a();
                while (a2.e()) {
                    arrayList.add(this.b(a2));
                }
                a2.b();
                return arrayList;
            }
            case 2: {
                g g2 = new g();
                a2.c();
                while (a2.e()) {
                    g2.put((Object)a2.g(), this.b(a2));
                }
                a2.d();
                return g2;
            }
            case 3: {
                return a2.h();
            }
            case 4: {
                return a2.k();
            }
            case 5: {
                return a2.i();
            }
            case 6: 
        }
        a2.j();
        return null;
    }

}

