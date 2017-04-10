/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 *  java.util.Collection
 */
package com.google.a.b.a;

import com.google.a.b.a.l;
import com.google.a.b.c;
import com.google.a.b.h;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

public final class b
implements x {
    private final c a;

    public b(c c2) {
        this.a = c2;
    }

    @Override
    public <T> w<T> a(f f2, com.google.a.c.a<T> a2) {
        Type type = a2.getType();
        Class<T> class_ = a2.getRawType();
        if (!Collection.class.isAssignableFrom(class_)) {
            return null;
        }
        Type type2 = com.google.a.b.b.a(type, class_);
        return new a(f2, type2, f2.a(com.google.a.c.a.get(type2)), this.a.a(a2));
    }

    private static final class a<E>
    extends w<Collection<E>> {
        private final w<E> a;
        private final h<? extends Collection<E>> b;

        public a(f f2, Type type, w<E> w2, h<? extends Collection<E>> h2) {
            this.a = new l<E>(f2, w2, type);
            this.b = h2;
        }

        public Collection<E> a(com.google.a.d.a a2) throws IOException {
            if (a2.f() == com.google.a.d.b.i) {
                a2.j();
                return null;
            }
            Collection<E> collection = this.b.a();
            a2.a();
            while (a2.e()) {
                collection.add(this.a.b(a2));
            }
            a2.b();
            return collection;
        }

        @Override
        public void a(com.google.a.d.c c2, Collection<E> collection) throws IOException {
            if (collection == null) {
                c2.f();
                return;
            }
            c2.b();
            for (Object object : collection) {
                this.a.a(c2, (Object)object);
            }
            c2.c();
        }

        @Override
        public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
            return this.a(a2);
        }
    }

}

