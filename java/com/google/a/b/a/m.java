/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.NoSuchFieldException
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.UnsupportedOperationException
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.math.BigDecimal
 *  java.math.BigInteger
 *  java.net.InetAddress
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.sql.Timestamp
 *  java.util.ArrayList
 *  java.util.BitSet
 *  java.util.Calendar
 *  java.util.Currency
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.StringTokenizer
 *  java.util.UUID
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicIntegerArray
 */
package com.google.a.b.a;

import com.google.a.b.f;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.i;
import com.google.a.l;
import com.google.a.n;
import com.google.a.o;
import com.google.a.q;
import com.google.a.t;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class m {
    public static final w<String> A;
    public static final w<BigDecimal> B;
    public static final w<BigInteger> C;
    public static final x D;
    public static final w<StringBuilder> E;
    public static final x F;
    public static final w<StringBuffer> G;
    public static final x H;
    public static final w<URL> I;
    public static final x J;
    public static final w<URI> K;
    public static final x L;
    public static final w<InetAddress> M;
    public static final x N;
    public static final w<UUID> O;
    public static final x P;
    public static final w<Currency> Q;
    public static final x R;
    public static final x S;
    public static final w<Calendar> T;
    public static final x U;
    public static final w<Locale> V;
    public static final x W;
    public static final w<l> X;
    public static final x Y;
    public static final x Z;
    public static final w<Class> a;
    public static final x b;
    public static final w<BitSet> c;
    public static final x d;
    public static final w<Boolean> e;
    public static final w<Boolean> f;
    public static final x g;
    public static final w<Number> h;
    public static final x i;
    public static final w<Number> j;
    public static final x k;
    public static final w<Number> l;
    public static final x m;
    public static final w<AtomicInteger> n;
    public static final x o;
    public static final w<AtomicBoolean> p;
    public static final x q;
    public static final w<AtomicIntegerArray> r;
    public static final x s;
    public static final w<Number> t;
    public static final w<Number> u;
    public static final w<Number> v;
    public static final w<Number> w;
    public static final x x;
    public static final w<Character> y;
    public static final x z;

    static {
        a = new w<Class>(){

            public Class a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }

            @Override
            public void a(c c2, Class class_) throws IOException {
                if (class_ == null) {
                    c2.f();
                    return;
                }
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + class_.getName() + ". Forgot to register a type adapter?");
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        b = m.a(Class.class, a);
        c = new w<BitSet>(){

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public BitSet a(com.google.a.d.a a2) throws IOException {
                String string;
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                BitSet bitSet = new BitSet();
                a2.a();
                b b2 = a2.f();
                int n2 = 0;
                do {
                    boolean bl;
                    if (b2 == b.b) {
                        a2.b();
                        return bitSet;
                    }
                    switch (.a[b2.ordinal()]) {
                        default: {
                            throw new t("Invalid bitset value type: " + (Object)((Object)b2));
                        }
                        case 1: {
                            if (a2.m() != 0) {
                                bl = true;
                                break;
                            }
                            bl = false;
                            break;
                        }
                        case 2: {
                            bl = a2.i();
                            break;
                        }
                        case 3: {
                            string = a2.h();
                            int n3 = Integer.parseInt((String)string);
                            bl = n3 != 0;
                        }
                    }
                    if (bl) {
                        bitSet.set(n2);
                    }
                    ++n2;
                    b2 = a2.f();
                } while (true);
                catch (NumberFormatException numberFormatException) {
                    throw new t("Error: Expecting: bitset number value (1, 0), Found: " + string);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, BitSet bitSet) throws IOException {
                if (bitSet == null) {
                    c2.f();
                    return;
                }
                c2.b();
                int n2 = 0;
                do {
                    if (n2 >= bitSet.length()) {
                        c2.c();
                        return;
                    }
                    boolean bl = bitSet.get(n2);
                    c2.a((long)bl ? 1 : 0);
                    ++n2;
                } while (true);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        d = m.a(BitSet.class, c);
        e = new w<Boolean>(){

            public Boolean a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                if (a2.f() == b.f) {
                    return Boolean.parseBoolean((String)a2.h());
                }
                return a2.i();
            }

            @Override
            public void a(c c2, Boolean bl) throws IOException {
                if (bl == null) {
                    c2.f();
                    return;
                }
                c2.a(bl);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        f = new w<Boolean>(){

            public Boolean a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                return Boolean.valueOf((String)a2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, Boolean bl) throws IOException {
                String string = bl == null ? "null" : bl.toString();
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        g = m.a(Boolean.TYPE, Boolean.class, e);
        h = new w<Number>(){

            public Number a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                try {
                    Byte by = Byte.valueOf((byte)((byte)a2.m()));
                    return by;
                }
                catch (NumberFormatException var2_3) {
                    throw new t((Throwable)var2_3);
                }
            }

            @Override
            public void a(c c2, Number number) throws IOException {
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        i = m.a(Byte.TYPE, Byte.class, h);
        j = new w<Number>(){

            public Number a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                try {
                    Short s2 = (short)a2.m();
                    return s2;
                }
                catch (NumberFormatException var2_3) {
                    throw new t((Throwable)var2_3);
                }
            }

            @Override
            public void a(c c2, Number number) throws IOException {
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        k = m.a(Short.TYPE, Short.class, j);
        l = new w<Number>(){

            public Number a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                try {
                    Integer n2 = a2.m();
                    return n2;
                }
                catch (NumberFormatException var2_3) {
                    throw new t((Throwable)var2_3);
                }
            }

            @Override
            public void a(c c2, Number number) throws IOException {
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        m = m.a(Integer.TYPE, Integer.class, l);
        n = new w<AtomicInteger>(){

            public AtomicInteger a(com.google.a.d.a a2) throws IOException {
                try {
                    AtomicInteger atomicInteger = new AtomicInteger(a2.m());
                    return atomicInteger;
                }
                catch (NumberFormatException var3_3) {
                    throw new t((Throwable)var3_3);
                }
            }

            @Override
            public void a(c c2, AtomicInteger atomicInteger) throws IOException {
                c2.a((long)atomicInteger.get());
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        }.a();
        o = m.a(AtomicInteger.class, n);
        p = new w<AtomicBoolean>(){

            public AtomicBoolean a(com.google.a.d.a a2) throws IOException {
                return new AtomicBoolean(a2.i());
            }

            @Override
            public void a(c c2, AtomicBoolean atomicBoolean) throws IOException {
                c2.a(atomicBoolean.get());
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        }.a();
        q = m.a(AtomicBoolean.class, p);
        r = new w<AtomicIntegerArray>(){

            public AtomicIntegerArray a(com.google.a.d.a a2) throws IOException {
                ArrayList arrayList = new ArrayList();
                a2.a();
                while (a2.e()) {
                    try {
                        arrayList.add((Object)a2.m());
                        continue;
                    }
                    catch (NumberFormatException var6_3) {
                        throw new t((Throwable)var6_3);
                    }
                }
                a2.b();
                int n2 = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(n2);
                for (int i2 = 0; i2 < n2; ++i2) {
                    atomicIntegerArray.set(i2, ((Integer)arrayList.get(i2)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override
            public void a(c c2, AtomicIntegerArray atomicIntegerArray) throws IOException {
                c2.b();
                int n2 = atomicIntegerArray.length();
                for (int i2 = 0; i2 < n2; ++i2) {
                    c2.a((long)atomicIntegerArray.get(i2));
                }
                c2.c();
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        }.a();
        s = m.a(AtomicIntegerArray.class, r);
        t = new w<Number>(){

            public Number a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                try {
                    Long l2 = a2.l();
                    return l2;
                }
                catch (NumberFormatException var2_3) {
                    throw new t((Throwable)var2_3);
                }
            }

            @Override
            public void a(c c2, Number number) throws IOException {
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        u = new w<Number>(){

            public Number a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                return Float.valueOf((float)((float)a2.k()));
            }

            @Override
            public void a(c c2, Number number) throws IOException {
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        v = new w<Number>(){

            public Number a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                return a2.k();
            }

            @Override
            public void a(c c2, Number number) throws IOException {
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        w = new w<Number>(){

            public Number a(com.google.a.d.a a2) throws IOException {
                b b2 = a2.f();
                switch (.a[b2.ordinal()]) {
                    default: {
                        throw new t("Expecting number, got: " + (Object)((Object)b2));
                    }
                    case 4: {
                        a2.j();
                        return null;
                    }
                    case 1: 
                }
                return new f(a2.h());
            }

            @Override
            public void a(c c2, Number number) throws IOException {
                c2.a(number);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        x = m.a(Number.class, w);
        y = new w<Character>(){

            public Character a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                String string = a2.h();
                if (string.length() != 1) {
                    throw new t("Expecting character, got: " + string);
                }
                return Character.valueOf((char)string.charAt(0));
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, Character c3) throws IOException {
                String string = c3 == null ? null : String.valueOf((Object)c3);
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        z = m.a(Character.TYPE, Character.class, y);
        A = new w<String>(){

            public String a(com.google.a.d.a a2) throws IOException {
                b b2 = a2.f();
                if (b2 == b.i) {
                    a2.j();
                    return null;
                }
                if (b2 == b.h) {
                    return Boolean.toString((boolean)a2.i());
                }
                return a2.h();
            }

            @Override
            public void a(c c2, String string) throws IOException {
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        B = new w<BigDecimal>(){

            public BigDecimal a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                try {
                    BigDecimal bigDecimal = new BigDecimal(a2.h());
                    return bigDecimal;
                }
                catch (NumberFormatException var3_3) {
                    throw new t((Throwable)var3_3);
                }
            }

            @Override
            public void a(c c2, BigDecimal bigDecimal) throws IOException {
                c2.a((Number)bigDecimal);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        C = new w<BigInteger>(){

            public BigInteger a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                try {
                    BigInteger bigInteger = new BigInteger(a2.h());
                    return bigInteger;
                }
                catch (NumberFormatException var3_3) {
                    throw new t((Throwable)var3_3);
                }
            }

            @Override
            public void a(c c2, BigInteger bigInteger) throws IOException {
                c2.a((Number)bigInteger);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        D = m.a(String.class, A);
        E = new w<StringBuilder>(){

            public StringBuilder a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                return new StringBuilder(a2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, StringBuilder stringBuilder) throws IOException {
                String string = stringBuilder == null ? null : stringBuilder.toString();
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        F = m.a(StringBuilder.class, E);
        G = new w<StringBuffer>(){

            public StringBuffer a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                return new StringBuffer(a2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, StringBuffer stringBuffer) throws IOException {
                String string = stringBuffer == null ? null : stringBuffer.toString();
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        H = m.a(StringBuffer.class, G);
        I = new w<URL>(){

            /*
             * Enabled aggressive block sorting
             */
            public URL a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                } else {
                    String string = a2.h();
                    if ("null".equals((Object)string)) return null;
                    return new URL(string);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, URL uRL) throws IOException {
                String string = uRL == null ? null : uRL.toExternalForm();
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        J = m.a(URL.class, I);
        K = new w<URI>(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public URI a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                try {
                    String string = a2.h();
                    if ("null".equals((Object)string)) return null;
                    return new URI(string);
                }
                catch (URISyntaxException var2_4) {
                    throw new com.google.a.m((Throwable)var2_4);
                }
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, URI uRI) throws IOException {
                String string = uRI == null ? null : uRI.toASCIIString();
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        L = m.a(URI.class, K);
        M = new w<InetAddress>(){

            public InetAddress a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                return InetAddress.getByName((String)a2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, InetAddress inetAddress) throws IOException {
                String string = inetAddress == null ? null : inetAddress.getHostAddress();
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        N = m.b(InetAddress.class, M);
        O = new w<UUID>(){

            public UUID a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                return UUID.fromString((String)a2.h());
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, UUID uUID) throws IOException {
                String string = uUID == null ? null : uUID.toString();
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        P = m.a(UUID.class, O);
        Q = new w<Currency>(){

            public Currency a(com.google.a.d.a a2) throws IOException {
                return Currency.getInstance((String)a2.h());
            }

            @Override
            public void a(c c2, Currency currency) throws IOException {
                c2.b(currency.getCurrencyCode());
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        }.a();
        R = m.a(Currency.class, Q);
        S = new x(){

            @Override
            public <T> w<T> a(com.google.a.f f2, com.google.a.c.a<T> a2) {
                if (a2.getRawType() != Timestamp.class) {
                    return null;
                }
                return new w<Timestamp>(f2.a(Date.class)){
                    final /* synthetic */ w a;

                    public Timestamp a(com.google.a.d.a a2) throws IOException {
                        Date date = (Date)this.a.b(a2);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override
                    public void a(c c2, Timestamp timestamp) throws IOException {
                        this.a.a(c2, timestamp);
                    }

                    @Override
                    public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                        return this.a(a2);
                    }
                };
            }

        };
        T = new w<Calendar>(){

            public Calendar a(com.google.a.d.a a2) throws IOException {
                int n2 = 0;
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                a2.c();
                int n3 = 0;
                int n4 = 0;
                int n5 = 0;
                int n6 = 0;
                int n7 = 0;
                while (a2.f() != b.d) {
                    String string = a2.g();
                    int n8 = a2.m();
                    if ("year".equals((Object)string)) {
                        n7 = n8;
                        continue;
                    }
                    if ("month".equals((Object)string)) {
                        n6 = n8;
                        continue;
                    }
                    if ("dayOfMonth".equals((Object)string)) {
                        n5 = n8;
                        continue;
                    }
                    if ("hourOfDay".equals((Object)string)) {
                        n4 = n8;
                        continue;
                    }
                    if ("minute".equals((Object)string)) {
                        n3 = n8;
                        continue;
                    }
                    if (!"second".equals((Object)string)) continue;
                    n2 = n8;
                }
                a2.d();
                return new GregorianCalendar(n7, n6, n5, n4, n3, n2);
            }

            @Override
            public void a(c c2, Calendar calendar) throws IOException {
                if (calendar == null) {
                    c2.f();
                    return;
                }
                c2.d();
                c2.a("year");
                c2.a((long)calendar.get(1));
                c2.a("month");
                c2.a((long)calendar.get(2));
                c2.a("dayOfMonth");
                c2.a((long)calendar.get(5));
                c2.a("hourOfDay");
                c2.a((long)calendar.get(11));
                c2.a("minute");
                c2.a((long)calendar.get(12));
                c2.a("second");
                c2.a((long)calendar.get(13));
                c2.e();
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        U = m.b(Calendar.class, GregorianCalendar.class, T);
        V = new w<Locale>(){

            /*
             * Enabled aggressive block sorting
             */
            public Locale a(com.google.a.d.a a2) throws IOException {
                if (a2.f() == b.i) {
                    a2.j();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(a2.h(), "_");
                String string = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String string2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String string3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (string2 != null) return new Locale(string, string2);
                if (string3 == null) {
                    return new Locale(string);
                }
                if (string3 == null) {
                    return new Locale(string, string2);
                }
                return new Locale(string, string2, string3);
            }

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public void a(c c2, Locale locale) throws IOException {
                String string = locale == null ? null : locale.toString();
                c2.b(string);
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        W = m.a(Locale.class, V);
        X = new w<l>(){

            @Override
            public l a(com.google.a.d.a a2) throws IOException {
                switch (.a[a2.f().ordinal()]) {
                    default: {
                        throw new IllegalArgumentException();
                    }
                    case 3: {
                        return new q(a2.h());
                    }
                    case 1: {
                        return new q(new f(a2.h()));
                    }
                    case 2: {
                        return new q(a2.i());
                    }
                    case 4: {
                        a2.j();
                        return n.a;
                    }
                    case 5: {
                        i i2 = new i();
                        a2.a();
                        while (a2.e()) {
                            i2.a(this.a(a2));
                        }
                        a2.b();
                        return i2;
                    }
                    case 6: 
                }
                o o2 = new o();
                a2.c();
                while (a2.e()) {
                    o2.a(a2.g(), this.a(a2));
                }
                a2.d();
                return o2;
            }

            @Override
            public void a(c c2, l l2) throws IOException {
                if (l2 == null || l2.j()) {
                    c2.f();
                    return;
                }
                if (l2.i()) {
                    q q2 = l2.m();
                    if (q2.p()) {
                        c2.a(q2.a());
                        return;
                    }
                    if (q2.o()) {
                        c2.a(q2.f());
                        return;
                    }
                    c2.b(q2.b());
                    return;
                }
                if (l2.g()) {
                    c2.b();
                    Iterator<l> iterator = l2.l().iterator();
                    while (iterator.hasNext()) {
                        this.a(c2, (l)iterator.next());
                    }
                    c2.c();
                    return;
                }
                if (l2.h()) {
                    c2.d();
                    for (Map.Entry entry : l2.k().o()) {
                        c2.a((String)entry.getKey());
                        this.a(c2, (l)entry.getValue());
                    }
                    c2.e();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + (Object)l2.getClass());
            }

            @Override
            public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
                return this.a(a2);
            }
        };
        Y = m.b(l.class, X);
        Z = new x(){

            @Override
            public <T> w<T> a(com.google.a.f f2, com.google.a.c.a<T> a2) {
                Class class_ = a2.getRawType();
                if (!Enum.class.isAssignableFrom(class_) || class_ == Enum.class) {
                    return null;
                }
                if (!class_.isEnum()) {
                    class_ = class_.getSuperclass();
                }
                return new a(class_);
            }
        };
    }

    public static <TT> x a(final com.google.a.c.a<TT> a2, final w<TT> w2) {
        return new x(){

            @Override
            public <T> w<T> a(com.google.a.f f2, com.google.a.c.a<T> a22) {
                if (a22.equals(a2)) {
                    return w2;
                }
                return null;
            }
        };
    }

    public static <TT> x a(final Class<TT> class_, final w<TT> w2) {
        return new x(){

            @Override
            public <T> w<T> a(com.google.a.f f2, com.google.a.c.a<T> a2) {
                if (a2.getRawType() == class_) {
                    return w2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_.getName() + ",adapter=" + w2 + "]";
            }
        };
    }

    public static <TT> x a(final Class<TT> class_, final Class<TT> class_2, final w<? super TT> w2) {
        return new x(){

            @Override
            public <T> w<T> a(com.google.a.f f2, com.google.a.c.a<T> a2) {
                Class<T> class_3 = a2.getRawType();
                if (class_3 == class_ || class_3 == class_2) {
                    return w2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_2.getName() + "+" + class_.getName() + ",adapter=" + w2 + "]";
            }
        };
    }

    public static <T1> x b(final Class<T1> class_, final w<T1> w2) {
        return new x(){

            public <T2> w<T2> a(com.google.a.f f2, com.google.a.c.a<T2> a2) {
                final Class<T2> class_2 = a2.getRawType();
                if (!class_.isAssignableFrom(class_2)) {
                    return null;
                }
                return new w<T1>(){

                    @Override
                    public void a(c c2, T1 T1) throws IOException {
                        w2.a(c2, T1);
                    }

                    @Override
                    public T1 b(com.google.a.d.a a2) throws IOException {
                        Object t2 = w2.b(a2);
                        if (t2 != null && !class_2.isInstance(t2)) {
                            throw new t("Expected a " + class_2.getName() + " but was " + t2.getClass().getName());
                        }
                        return (T1)t2;
                    }
                };
            }

            public String toString() {
                return "Factory[typeHierarchy=" + class_.getName() + ",adapter=" + w2 + "]";
            }

        };
    }

    public static <TT> x b(final Class<TT> class_, final Class<? extends TT> class_2, final w<? super TT> w2) {
        return new x(){

            @Override
            public <T> w<T> a(com.google.a.f f2, com.google.a.c.a<T> a2) {
                Class<T> class_3 = a2.getRawType();
                if (class_3 == class_ || class_3 == class_2) {
                    return w2;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + class_.getName() + "+" + class_2.getName() + ",adapter=" + w2 + "]";
            }
        };
    }

    private static final class a<T extends Enum<T>>
    extends w<T> {
        private final Map<String, T> a = new HashMap();
        private final Map<T, String> b = new HashMap();

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public a(Class<T> class_) {
            try {
                Enum[] arrenum = (Enum[])class_.getEnumConstants();
                int n2 = arrenum.length;
                int n3 = 0;
                while (n3 < n2) {
                    Enum enum_ = arrenum[n3];
                    String string = enum_.name();
                    com.google.a.a.c c2 = (com.google.a.a.c)class_.getField(string).getAnnotation((Class)com.google.a.a.c.class);
                    if (c2 != null) {
                        string = c2.a();
                        for (String string2 : c2.b()) {
                            this.a.put((Object)string2, (Object)enum_);
                        }
                    }
                    String string3 = string;
                    this.a.put((Object)string3, (Object)enum_);
                    this.b.put((Object)enum_, (Object)string3);
                    ++n3;
                }
                return;
            }
            catch (NoSuchFieldException var2_13) {
                throw new AssertionError("Missing field in " + class_.getName(), (Throwable)var2_13);
            }
        }

        public T a(com.google.a.d.a a2) throws IOException {
            if (a2.f() == b.i) {
                a2.j();
                return null;
            }
            return (T)((Enum)this.a.get((Object)a2.h()));
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(c c2, T t2) throws IOException {
            String string = t2 == null ? null : (String)this.b.get(t2);
            c2.b(string);
        }

        @Override
        public /* synthetic */ Object b(com.google.a.d.a a2) throws IOException {
            return this.a(a2);
        }
    }

}

