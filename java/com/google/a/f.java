/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.ThreadLocal
 *  java.lang.Throwable
 *  java.lang.reflect.Type
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicLong
 *  java.util.concurrent.atomic.AtomicLongArray
 */
package com.google.a;

import com.google.a.b.a.b;
import com.google.a.b.a.c;
import com.google.a.b.a.d;
import com.google.a.b.a.g;
import com.google.a.b.a.h;
import com.google.a.b.a.i;
import com.google.a.b.a.j;
import com.google.a.b.a.k;
import com.google.a.b.a.m;
import com.google.a.e;
import com.google.a.l;
import com.google.a.n;
import com.google.a.r;
import com.google.a.t;
import com.google.a.u;
import com.google.a.w;
import com.google.a.x;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public final class f {
    final com.google.a.j a;
    final r b;
    private final ThreadLocal<Map<com.google.a.c.a<?>, a<?>>> c = new ThreadLocal();
    private final Map<com.google.a.c.a<?>, w<?>> d = Collections.synchronizedMap((Map)new HashMap());
    private final List<x> e;
    private final com.google.a.b.c f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final boolean k;

    public f() {
        this(com.google.a.b.d.a, com.google.a.d.a, Collections.emptyMap(), false, false, false, true, false, false, false, u.a, Collections.emptyList());
    }

    f(com.google.a.b.d d2, e e2, Map<Type, com.google.a.h<?>> map, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, u u2, List<x> list) {
        this.a = new com.google.a.j(){};
        this.b = new r(){};
        this.f = new com.google.a.b.c(map);
        this.g = bl;
        this.i = bl3;
        this.h = bl4;
        this.j = bl5;
        this.k = bl6;
        ArrayList arrayList = new ArrayList();
        arrayList.add((Object)m.Y);
        arrayList.add((Object)h.a);
        arrayList.add((Object)d2);
        arrayList.addAll(list);
        arrayList.add((Object)m.D);
        arrayList.add((Object)m.m);
        arrayList.add((Object)m.g);
        arrayList.add((Object)m.i);
        arrayList.add((Object)m.k);
        w<Number> w2 = f.a(u2);
        arrayList.add((Object)m.a(Long.TYPE, Long.class, w2));
        arrayList.add((Object)m.a(Double.TYPE, Double.class, this.a(bl7)));
        arrayList.add((Object)m.a(Float.TYPE, Float.class, this.b(bl7)));
        arrayList.add((Object)m.x);
        arrayList.add((Object)m.o);
        arrayList.add((Object)m.q);
        arrayList.add((Object)m.a(AtomicLong.class, f.a(w2)));
        arrayList.add((Object)m.a(AtomicLongArray.class, f.b(w2)));
        arrayList.add((Object)m.s);
        arrayList.add((Object)m.z);
        arrayList.add((Object)m.F);
        arrayList.add((Object)m.H);
        arrayList.add((Object)m.a(BigDecimal.class, m.B));
        arrayList.add((Object)m.a(BigInteger.class, m.C));
        arrayList.add((Object)m.J);
        arrayList.add((Object)m.L);
        arrayList.add((Object)m.P);
        arrayList.add((Object)m.R);
        arrayList.add((Object)m.W);
        arrayList.add((Object)m.N);
        arrayList.add((Object)m.d);
        arrayList.add((Object)c.a);
        arrayList.add((Object)m.U);
        arrayList.add((Object)k.a);
        arrayList.add((Object)j.a);
        arrayList.add((Object)m.S);
        arrayList.add((Object)com.google.a.b.a.a.a);
        arrayList.add((Object)m.b);
        arrayList.add((Object)new b(this.f));
        arrayList.add((Object)new g(this.f, bl2));
        arrayList.add((Object)new d(this.f));
        arrayList.add((Object)m.Z);
        arrayList.add((Object)new i(this.f, e2, d2));
        this.e = Collections.unmodifiableList((List)arrayList);
    }

    private static w<Number> a(u u2) {
        if (u2 == u.a) {
            return m.t;
        }
        return new w<Number>(){

            public Number a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == com.google.a.d.b.i) {
                    a2.j();
                    return null;
                }
                return a2.l();
            }

            @Override
            public void a(com.google.a.d.c c2, Number number) throws IOException {
                if (number == null) {
                    c2.f();
                    return;
                }
                c2.b(number.toString());
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
    }

    private static w<AtomicLong> a(final w<Number> w2) {
        return new w<AtomicLong>(){

            public AtomicLong a(com.google.a.d.a a2) throws IOException {
                return new AtomicLong(((Number)w2.b(a2)).longValue());
            }

            @Override
            public void a(com.google.a.d.c c2, AtomicLong atomicLong) throws IOException {
                w2.a(c2, atomicLong.get());
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        }.a();
    }

    private w<Number> a(boolean bl) {
        if (bl) {
            return m.v;
        }
        return new w<Number>(){

            public Double a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == com.google.a.d.b.i) {
                    a2.j();
                    return null;
                }
                return a2.k();
            }

            @Override
            public void a(com.google.a.d.c c2, Number number) throws IOException {
                if (number == null) {
                    c2.f();
                    return;
                }
                f.a(number.doubleValue());
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
    }

    static void a(double d2) {
        if (Double.isNaN((double)d2) || Double.isInfinite((double)d2)) {
            throw new IllegalArgumentException("" + d2 + " is not a valid double value as per JSON specification. To override this" + " behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static void a(Object object, com.google.a.d.a a2) {
        if (object != null) {
            try {
                if (a2.f() != com.google.a.d.b.j) {
                    throw new com.google.a.m("JSON document was not fully consumed.");
                }
            }
            catch (com.google.a.d.d var3_2) {
                throw new t((Throwable)var3_2);
            }
            catch (IOException var2_3) {
                throw new com.google.a.m((Throwable)var2_3);
            }
        }
    }

    private static w<AtomicLongArray> b(final w<Number> w2) {
        return new w<AtomicLongArray>(){

            public AtomicLongArray a(com.google.a.d.a a2) throws IOException {
                ArrayList arrayList = new ArrayList();
                a2.a();
                while (a2.e()) {
                    arrayList.add((Object)((Number)w2.b(a2)).longValue());
                }
                a2.b();
                int n2 = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(n2);
                for (int i2 = 0; i2 < n2; ++i2) {
                    atomicLongArray.set(i2, ((Long)arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }

            @Override
            public void a(com.google.a.d.c c2, AtomicLongArray atomicLongArray) throws IOException {
                c2.b();
                int n2 = atomicLongArray.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    w2.a(c2, atomicLongArray.get(i2));
                }
                c2.c();
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        }.a();
    }

    private w<Number> b(boolean bl) {
        if (bl) {
            return m.u;
        }
        return new w<Number>(){

            public Float a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == com.google.a.d.b.i) {
                    a2.j();
                    return null;
                }
                return Float.valueOf((float)((float)a2.k()));
            }

            @Override
            public void a(com.google.a.d.c c2, Number number) throws IOException {
                if (number == null) {
                    c2.f();
                    return;
                }
                f.a(number.floatValue());
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
    }

    public com.google.a.d.a a(Reader reader) {
        com.google.a.d.a a2 = new com.google.a.d.a(reader);
        a2.a(this.k);
        return a2;
    }

    public com.google.a.d.c a(Writer writer) throws IOException {
        if (this.i) {
            writer.write(")]}'\n");
        }
        com.google.a.d.c c2 = new com.google.a.d.c(writer);
        if (this.j) {
            c2.c("  ");
        }
        c2.d(this.g);
        return c2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public <T> w<T> a(com.google.a.c.a<T> a2) {
        Map map;
        boolean bl;
        w<T> w2 = (w<T>)this.d.get(a2);
        if (w2 != null) {
            return w2;
        }
        Map map2 = (Map)this.c.get();
        if (map2 == null) {
            HashMap hashMap = new HashMap();
            this.c.set((Object)hashMap);
            map = hashMap;
            bl = true;
        } else {
            map = map2;
            bl = false;
        }
        if ((w2 = (a)map.get(a2)) != null) return w2;
        try {
            a<T> a3 = new a<T>();
            map.put(a2, a3);
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                w2 = ((x)iterator.next()).a(this, a2);
                if (w2 == null) continue;
                a3.a(w2);
                this.d.put(a2, w2);
            }
        }
        catch (Throwable var8_9) {
            map.remove(a2);
            if (!bl) throw var8_9;
            this.c.remove();
            throw var8_9;
        }
        {
            map.remove(a2);
            if (!bl) return w2;
            this.c.remove();
            return w2;
        }
        throw new IllegalArgumentException("GSON cannot handle " + a2);
    }

    public <T> w<T> a(x x2, com.google.a.c.a<T> a2) {
        boolean bl = this.e.contains((Object)x2);
        boolean bl2 = false;
        if (!bl) {
            bl2 = true;
        }
        Iterator iterator = this.e.iterator();
        boolean bl3 = bl2;
        while (iterator.hasNext()) {
            x x3 = (x)iterator.next();
            if (!bl3) {
                if (x3 != x2) continue;
                bl3 = true;
                continue;
            }
            w<T> w2 = x3.a(this, a2);
            if (w2 == null) continue;
            return w2;
        }
        throw new IllegalArgumentException("GSON cannot serialize " + a2);
    }

    public <T> w<T> a(Class<T> class_) {
        return this.a(com.google.a.c.a.get(class_));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public <T> T a(com.google.a.d.a a2, Type type) throws com.google.a.m, t {
        boolean bl = true;
        boolean bl2 = a2.p();
        a2.a(bl);
        try {
            a2.f();
            bl = false;
            Object obj = this.a(com.google.a.c.a.get(type)).b(a2);
            return (T)obj;
        }
        catch (EOFException var8_6) {
            if (!bl) throw new t((Throwable)var8_6);
            return null;
        }
        catch (IllegalStateException var7_8) {
            throw new t((Throwable)var7_8);
        }
        catch (IOException var5_9) {
            throw new t((Throwable)var5_9);
        }
        finally {
            a2.a(bl2);
        }
    }

    public <T> T a(Reader reader, Type type) throws com.google.a.m, t {
        com.google.a.d.a a2 = this.a(reader);
        T t2 = this.a(a2, type);
        f.a(t2, a2);
        return t2;
    }

    public <T> T a(String string, Class<T> class_) throws t {
        T t2 = this.a(string, (Type)class_);
        return (T)com.google.a.b.i.a(class_).cast(t2);
    }

    public <T> T a(String string, Type type) throws t {
        if (string == null) {
            return null;
        }
        return this.a((Reader)new StringReader(string), type);
    }

    public String a(l l2) {
        StringWriter stringWriter = new StringWriter();
        this.a(l2, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public String a(Object object) {
        if (object == null) {
            return this.a(n.a);
        }
        return this.a(object, (Type)object.getClass());
    }

    public String a(Object object, Type type) {
        StringWriter stringWriter = new StringWriter();
        this.a(object, type, (Appendable)stringWriter);
        return stringWriter.toString();
    }

    public void a(l l2, com.google.a.d.c c2) throws com.google.a.m {
        boolean bl = c2.g();
        c2.b(true);
        boolean bl2 = c2.h();
        c2.c(this.h);
        boolean bl3 = c2.i();
        c2.d(this.g);
        try {
            com.google.a.b.j.a(l2, c2);
            return;
        }
        catch (IOException var7_6) {
            throw new com.google.a.m((Throwable)var7_6);
        }
        finally {
            c2.b(bl);
            c2.c(bl2);
            c2.d(bl3);
        }
    }

    public void a(l l2, Appendable appendable) throws com.google.a.m {
        try {
            this.a(l2, this.a(com.google.a.b.j.a(appendable)));
            return;
        }
        catch (IOException var3_3) {
            throw new RuntimeException((Throwable)var3_3);
        }
    }

    public void a(Object object, Type type, com.google.a.d.c c2) throws com.google.a.m {
        w w2 = this.a(com.google.a.c.a.get(type));
        boolean bl = c2.g();
        c2.b(true);
        boolean bl2 = c2.h();
        c2.c(this.h);
        boolean bl3 = c2.i();
        c2.d(this.g);
        try {
            w2.a(c2, (Object)object);
            return;
        }
        catch (IOException var9_8) {
            throw new com.google.a.m((Throwable)var9_8);
        }
        finally {
            c2.b(bl);
            c2.c(bl2);
            c2.d(bl3);
        }
    }

    public void a(Object object, Type type, Appendable appendable) throws com.google.a.m {
        try {
            this.a(object, type, this.a(com.google.a.b.j.a(appendable)));
            return;
        }
        catch (IOException var4_4) {
            throw new com.google.a.m((Throwable)var4_4);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.g + "factories:" + this.e + ",instanceCreators:" + this.f + "}";
    }

    static class a<T>
    extends w<T> {
        private w<T> a;

        a() {
        }

        @Override
        public void a(com.google.a.d.c c2, T t2) throws IOException {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            this.a.a(c2, t2);
        }

        public void a(w<T> w2) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = w2;
        }

        @Override
        public T b(com.google.a.d.a a2) throws IOException {
            if (this.a == null) {
                throw new IllegalStateException();
            }
            return this.a.b(a2);
        }
    }

}

