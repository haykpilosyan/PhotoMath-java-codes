/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.lang.reflect.Type
 *  java.util.Collection
 *  java.util.LinkedHashMap
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 */
package com.google.a.b.a;

import com.google.a.b.a.l;
import com.google.a.b.c;
import com.google.a.b.d;
import com.google.a.b.h;
import com.google.a.e;
import com.google.a.f;
import com.google.a.t;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class i
implements x {
    private final c a;
    private final e b;
    private final d c;

    public i(c c2, e e2, d d2) {
        this.a = c2;
        this.b = e2;
        this.c = d2;
    }

    private b a(final f f2, final Field field, String string, final com.google.a.c.a<?> a2, boolean bl, boolean bl2) {
        return new b(string, bl, bl2, com.google.a.b.i.a(a2.getRawType())){
            final w<?> a;
            final /* synthetic */ boolean e;

            @Override
            void a(com.google.a.d.a a22, Object object) throws IOException, IllegalAccessException {
                Object obj = this.a.b(a22);
                if (obj != null || !this.e) {
                    field.set(object, obj);
                }
            }

            @Override
            void a(com.google.a.d.c c2, Object object) throws IOException, IllegalAccessException {
                Object object2 = field.get(object);
                new l(f2, this.a, a2.getType()).a(c2, (Object)object2);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public boolean a(Object object) throws IOException, IllegalAccessException {
                if (!this.h || field.get(object) == object) {
                    return false;
                }
                return true;
            }
        };
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static List<String> a(e e2, Field field) {
        com.google.a.a.c c2 = (com.google.a.a.c)field.getAnnotation((Class)com.google.a.a.c.class);
        LinkedList linkedList = new LinkedList();
        if (c2 == null) {
            linkedList.add((Object)e2.a(field));
            return linkedList;
        }
        linkedList.add((Object)c2.a());
        String[] arrstring = c2.b();
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            linkedList.add((Object)arrstring[n3]);
            ++n3;
        }
        return linkedList;
    }

    private List<String> a(Field field) {
        return i.a(this.b, field);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private Map<String, b> a(f var1_1, com.google.a.c.a<?> var2_2, Class<?> var3_3) {
        var4_4 = new LinkedHashMap();
        if (var3_3.isInterface()) {
            return var4_4;
        }
        var5_5 = var2_2.getType();
        block0 : do {
            if (var3_3 == Object.class) return var4_4;
            var6_6 = var3_3.getDeclaredFields();
            var7_7 = var6_6.length;
            var8_8 = 0;
            block1 : do {
                if (var8_8 < var7_7) {
                    var11_11 = var6_6[var8_8];
                    var12_12 = this.a(var11_11, true);
                    var13_13 = this.a(var11_11, false);
                    if (var12_12 || var13_13) {
                        var11_11.setAccessible(true);
                        var14_14 = var2_2.getType();
                        var15_15 = var11_11.getGenericType();
                        var16_17 = com.google.a.b.b.a(var14_14, var3_3, var15_15);
                        var17_16 = this.a(var11_11);
                        var18_19 = null;
                        var19_18 = 0;
                        break block0;
                    }
                } else {
                    var9_9 = var2_2.getType();
                    var10_10 = var3_3.getGenericSuperclass();
                    var2_2 = com.google.a.c.a.get(com.google.a.b.b.a(var9_9, var3_3, var10_10));
                    var3_3 = var2_2.getRawType();
                    continue block0;
                }
                do {
                    ++var8_8;
                    continue block1;
                    break;
                } while (true);
                break;
            } while (true);
            break;
        } while (true);
        do {
            if (var19_18 >= var17_16.size()) ** continue;
            var20_21 = (String)var17_16.get(var19_18);
            if (var19_18 != 0) {
                var12_12 = false;
            }
            var21_20 = (b)var4_4.put((Object)var20_21, (Object)this.a(var1_1, var11_11, var20_21, com.google.a.c.a.get(var16_17), var12_12, var13_13));
            if (var18_19 != null) {
                var21_20 = var18_19;
            }
            ++var19_18;
            var18_19 = var21_20;
        } while (true);
    }

    static boolean a(Field field, boolean bl, d d2) {
        if (!d2.a(field.getType(), bl) && !d2.a(field, bl)) {
            return true;
        }
        return false;
    }

    @Override
    public <T> w<T> a(f f2, com.google.a.c.a<T> a2) {
        Class<T> class_ = a2.getRawType();
        if (!Object.class.isAssignableFrom(class_)) {
            return null;
        }
        return new a<T>(this.a.a(a2), this.a(f2, a2, class_));
    }

    w<?> a(f f2, Field field, com.google.a.c.a<?> a2) {
        w w2;
        com.google.a.a.b b2 = (com.google.a.a.b)field.getAnnotation((Class)com.google.a.a.b.class);
        if (b2 != null && (w2 = com.google.a.b.a.d.a(this.a, f2, a2, b2)) != null) {
            return w2;
        }
        return f2.a(a2);
    }

    public boolean a(Field field, boolean bl) {
        return i.a(field, bl, this.c);
    }

    public static final class a<T>
    extends w<T> {
        private final h<T> a;
        private final Map<String, b> b;

        a(h<T> h2, Map<String, b> map) {
            this.a = h2;
            this.b = map;
        }

        @Override
        public void a(com.google.a.d.c c2, T t2) throws IOException {
            if (t2 == null) {
                c2.f();
                return;
            }
            c2.d();
            try {
                for (b b2 : this.b.values()) {
                    if (!b2.a(t2)) continue;
                    c2.a(b2.g);
                    b2.a(c2, t2);
                }
            }
            catch (IllegalAccessException var4_5) {
                throw new AssertionError((Object)var4_5);
            }
            c2.e();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public T b(com.google.a.d.a a2) throws IOException {
            if (a2.f() == com.google.a.d.b.i) {
                a2.j();
                return null;
            }
            T t2 = this.a.a();
            try {
                a2.c();
                while (a2.e()) {
                    String string = a2.g();
                    b b2 = (b)this.b.get((Object)string);
                    if (b2 == null || !b2.i) {
                        a2.n();
                        continue;
                    }
                    b2.a(a2, t2);
                }
            }
            catch (IllegalStateException var4_5) {
                throw new t((Throwable)var4_5);
            }
            catch (IllegalAccessException var3_6) {
                throw new AssertionError((Object)var3_6);
            }
            a2.d();
            return t2;
        }
    }

    static abstract class b {
        final String g;
        final boolean h;
        final boolean i;

        protected b(String string, boolean bl, boolean bl2) {
            this.g = string;
            this.h = bl;
            this.i = bl2;
        }

        abstract void a(com.google.a.d.a var1, Object var2) throws IOException, IllegalAccessException;

        abstract void a(com.google.a.d.c var1, Object var2) throws IOException, IllegalAccessException;

        abstract boolean a(Object var1) throws IOException, IllegalAccessException;
    }

}

