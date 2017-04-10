/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.e
 *  d.f
 *  d.m
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.ProtocolException
 *  java.util.ArrayList
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.TimeUnit
 */
package c.a.b;

import c.a.a.d;
import c.a.b.g;
import c.a.b.k;
import c.a.b.m;
import c.a.b.n;
import c.a.b.q;
import c.a.b.r;
import c.a.i;
import c.ab;
import c.ac;
import c.r;
import c.s;
import c.w;
import c.x;
import c.z;
import d.f;
import d.t;
import d.u;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class e
implements c.a.b.i {
    private static final f a = f.a((String)"connection");
    private static final f b = f.a((String)"host");
    private static final f c = f.a((String)"keep-alive");
    private static final f d = f.a((String)"proxy-connection");
    private static final f e = f.a((String)"transfer-encoding");
    private static final f f = f.a((String)"te");
    private static final f g = f.a((String)"encoding");
    private static final f h = f.a((String)"upgrade");
    private static final List<f> i;
    private static final List<f> j;
    private static final List<f> k;
    private static final List<f> l;
    private final r m;
    private final d n;
    private g o;
    private c.a.a.e p;

    static {
        f[] arrf = new f[]{a, b, c, d, e, c.a.a.f.b, c.a.a.f.c, c.a.a.f.d, c.a.a.f.e, c.a.a.f.f, c.a.a.f.g};
        i = i.a(arrf);
        f[] arrf2 = new f[]{a, b, c, d, e};
        j = i.a(arrf2);
        f[] arrf3 = new f[]{a, b, c, d, f, e, g, h, c.a.a.f.b, c.a.a.f.c, c.a.a.f.d, c.a.a.f.e, c.a.a.f.f, c.a.a.f.g};
        k = i.a(arrf3);
        f[] arrf4 = new f[]{a, b, c, d, f, e, g, h};
        l = i.a(arrf4);
    }

    public e(r r2, d d2) {
        this.m = r2;
        this.n = d2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ab.a a(List<c.a.a.f> list) throws IOException {
        String string = null;
        String string2 = "HTTP/1.1";
        r.a a2 = new r.a();
        int n2 = list.size();
        int n3 = 0;
        do {
            String string3;
            int n4;
            f f2;
            String string4;
            if (n3 < n2) {
                f2 = ((c.a.a.f)list.get((int)n3)).h;
                string3 = ((c.a.a.f)list.get((int)n3)).i.a();
                string4 = string2;
                n4 = 0;
            } else {
                if (string == null) {
                    throw new ProtocolException("Expected ':status' header not present");
                }
                q q2 = q.a(string2 + " " + string);
                return new ab.a().a(x.c).a(q2.b).a(q2.c).a(a2.a());
            }
            while (n4 < string3.length()) {
                int n5 = string3.indexOf(0, n4);
                if (n5 == -1) {
                    n5 = string3.length();
                }
                String string5 = string3.substring(n4, n5);
                if (!f2.equals((Object)c.a.a.f.a)) {
                    if (f2.equals((Object)c.a.a.f.g)) {
                        string4 = string5;
                        string5 = string;
                    } else {
                        if (!j.contains((Object)f2)) {
                            a2.a(f2.a(), string5);
                        }
                        string5 = string;
                    }
                }
                int n6 = n5 + 1;
                string = string5;
                n4 = n6;
            }
            ++n3;
            string2 = string4;
        } while (true);
    }

    private static String a(String string, String string2) {
        return string + '\u0000' + string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static ab.a b(List<c.a.a.f> list) throws IOException {
        String string = null;
        r.a a2 = new r.a();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = ((c.a.a.f)list.get((int)i2)).h;
            String string2 = ((c.a.a.f)list.get((int)i2)).i.a();
            if (!f2.equals((Object)c.a.a.f.a)) {
                if (!l.contains((Object)f2)) {
                    a2.a(f2.a(), string2);
                }
                string2 = string;
            }
            string = string2;
        }
        if (string == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        q q2 = q.a("HTTP/1.1 " + string);
        return new ab.a().a(x.d).a(q2.b).a(q2.c).a(a2.a());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static List<c.a.a.f> b(z var0) {
        var1_1 = var0.c();
        var2_2 = new ArrayList(5 + var1_1.a());
        var2_2.add((Object)new c.a.a.f(c.a.a.f.b, var0.b()));
        var2_2.add((Object)new c.a.a.f(c.a.a.f.c, m.a(var0.a())));
        var2_2.add((Object)new c.a.a.f(c.a.a.f.g, "HTTP/1.1"));
        var2_2.add((Object)new c.a.a.f(c.a.a.f.f, i.a(var0.a(), false)));
        var2_2.add((Object)new c.a.a.f(c.a.a.f.d, var0.a().b()));
        var8_3 = new LinkedHashSet();
        var9_4 = var1_1.a();
        var10_5 = 0;
        block0 : do {
            if (var10_5 >= var9_4) return var2_2;
            var11_6 = f.a((String)var1_1.a(var10_5).toLowerCase(Locale.US));
            if (e.i.contains((Object)var11_6)) ** GOTO lbl-1000
            var12_7 = var1_1.b(var10_5);
            if (!var8_3.add((Object)var11_6)) ** GOTO lbl19
            var2_2.add((Object)new c.a.a.f(var11_6, var12_7));
            ** GOTO lbl-1000
lbl19: // 1 sources:
            var13_8 = 0;
            do {
                if (var13_8 >= var2_2.size()) lbl-1000: // 4 sources:
                {
                    do {
                        ++var10_5;
                        continue block0;
                        break;
                    } while (true);
                }
                if (((c.a.a.f)var2_2.get((int)var13_8)).h.equals((Object)var11_6)) {
                    var2_2.set(var13_8, (Object)new c.a.a.f(var11_6, e.a(((c.a.a.f)var2_2.get((int)var13_8)).i.a(), var12_7)));
                    ** continue;
                }
                ++var13_8;
            } while (true);
            break;
        } while (true);
    }

    public static List<c.a.a.f> c(z z2) {
        c.r r2 = z2.c();
        ArrayList arrayList = new ArrayList(4 + r2.a());
        arrayList.add((Object)new c.a.a.f(c.a.a.f.b, z2.b()));
        arrayList.add((Object)new c.a.a.f(c.a.a.f.c, m.a(z2.a())));
        arrayList.add((Object)new c.a.a.f(c.a.a.f.e, i.a(z2.a(), false)));
        arrayList.add((Object)new c.a.a.f(c.a.a.f.d, z2.a().b()));
        int n2 = r2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            f f2 = f.a((String)r2.a(i2).toLowerCase(Locale.US));
            if (k.contains((Object)f2)) continue;
            arrayList.add((Object)new c.a.a.f(f2, r2.b(i2)));
        }
        return arrayList;
    }

    @Override
    public ac a(ab ab2) throws IOException {
        a a2 = new a(this.p.g());
        return new k(ab2.f(), d.m.a((t)a2));
    }

    @Override
    public d.s a(z z2, long l2) throws IOException {
        return this.p.h();
    }

    @Override
    public void a() {
        if (this.p != null) {
            this.p.b(c.a.a.a.l);
        }
    }

    @Override
    public void a(g g2) {
        this.o = g2;
    }

    @Override
    public void a(n n2) throws IOException {
        n2.a(this.p.h());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(z z2) throws IOException {
        if (this.p != null) {
            return;
        }
        this.o.b();
        boolean bl = this.o.a(z2);
        List<c.a.a.f> list = this.n.a() == x.d ? e.c(z2) : e.b(z2);
        this.p = this.n.a(list, bl, true);
        this.p.e().timeout(this.o.a.b(), TimeUnit.MILLISECONDS);
        this.p.f().timeout(this.o.a.c(), TimeUnit.MILLISECONDS);
    }

    @Override
    public ab.a b() throws IOException {
        if (this.n.a() == x.d) {
            return e.b(this.p.d());
        }
        return e.a(this.p.d());
    }

    @Override
    public void c() throws IOException {
        this.p.h().close();
    }

    class a
    extends d.i {
        public a(t t2) {
            super(t2);
        }

        @Override
        public void close() throws IOException {
            e.this.m.a(false, e.this);
            super.close();
        }
    }

}

