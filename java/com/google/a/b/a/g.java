/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.google.a.b.a;

import com.google.a.b.a.m;
import com.google.a.b.b;
import com.google.a.b.c;
import com.google.a.b.e;
import com.google.a.b.h;
import com.google.a.f;
import com.google.a.l;
import com.google.a.q;
import com.google.a.t;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class g
implements x {
    final boolean a;
    private final c b;

    public g(c c2, boolean bl) {
        this.b = c2;
        this.a = bl;
    }

    private w<?> a(f f2, Type type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            return m.f;
        }
        return f2.a(com.google.a.c.a.get(type));
    }

    @Override
    public <T> w<T> a(f f2, com.google.a.c.a<T> a2) {
        Type type = a2.getType();
        if (!Map.class.isAssignableFrom(a2.getRawType())) {
            return null;
        }
        Type[] arrtype = b.b(type, b.e(type));
        w w2 = this.a(f2, arrtype[0]);
        w w3 = f2.a(com.google.a.c.a.get(arrtype[1]));
        h<T> h2 = this.b.a(a2);
        return new a(f2, arrtype[0], w2, arrtype[1], w3, h2);
    }

    private final class a<K, V>
    extends w<Map<K, V>> {
        private final w<K> b;
        private final w<V> c;
        private final h<? extends Map<K, V>> d;

        public a(f f2, Type type, w<K> w2, Type type2, w<V> w3, h<? extends Map<K, V>> h2) {
            this.b = new com.google.a.b.a.l<K>(f2, w2, type);
            this.c = new com.google.a.b.a.l<V>(f2, w3, type2);
            this.d = h2;
        }

        private String a(l l2) {
            if (l2.i()) {
                q q2 = l2.m();
                if (q2.p()) {
                    return String.valueOf((Object)q2.a());
                }
                if (q2.o()) {
                    return Boolean.toString((boolean)q2.f());
                }
                if (q2.q()) {
                    return q2.b();
                }
                throw new AssertionError();
            }
            if (l2.j()) {
                return "null";
            }
            throw new AssertionError();
        }

        public Map<K, V> a(com.google.a.d.a a2) throws IOException {
            com.google.a.d.b b2 = a2.f();
            if (b2 == com.google.a.d.b.i) {
                a2.j();
                return null;
            }
            Map<K, V> map = this.d.a();
            if (b2 == com.google.a.d.b.a) {
                a2.a();
                while (a2.e()) {
                    a2.a();
                    K k2 = this.b.b(a2);
                    if (map.put(k2, this.c.b(a2)) != null) {
                        throw new t("duplicate key: " + k2);
                    }
                    a2.b();
                }
                a2.b();
                return map;
            }
            a2.c();
            while (a2.e()) {
                e.a.a(a2);
                K k3 = this.b.b(a2);
                if (map.put(k3, this.c.b(a2)) == null) continue;
                throw new t("duplicate key: " + k3);
            }
            a2.d();
            return map;
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(com.google.a.d.c c2, Map<K, V> map) throws IOException {
            int n2 = 0;
            if (map == null) {
                c2.f();
                return;
            }
            if (!g.this.a) {
                c2.d();
                Iterator iterator = map.entrySet().iterator();
                do {
                    if (!iterator.hasNext()) {
                        c2.e();
                        return;
                    }
                    Map.Entry entry = (Map.Entry)iterator.next();
                    c2.a(String.valueOf((Object)entry.getKey()));
                    this.c.a(c2, (Object)entry.getValue());
                } while (true);
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            Iterator iterator = map.entrySet().iterator();
            boolean bl = false;
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                l l2 = this.b.a((Object)entry.getKey());
                arrayList.add((Object)l2);
                arrayList2.add(entry.getValue());
                boolean bl2 = l2.g() || l2.h();
                bl = bl2 | bl;
            }
            c2.d();
            do {
                if (n2 >= arrayList.size()) {
                    c2.e();
                    return;
                }
                c2.a(this.a((l)arrayList.get(n2)));
                this.c.a(c2, (Object)arrayList2.get(n2));
                ++n2;
            } while (true);
        }

        @Override
        public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
            return this.a(a2);
        }
    }

}

