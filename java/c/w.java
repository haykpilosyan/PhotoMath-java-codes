/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Cloneable
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.security.GeneralSecurityException
 *  java.security.SecureRandom
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.KeyManager
 *  javax.net.ssl.SSLContext
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.X509TrustManager
 */
package c;

import c.a.b.r;
import c.a.c;
import c.a.d;
import c.a.d.f;
import c.a.g;
import c.a.h;
import c.a.i;
import c.b;
import c.e;
import c.g;
import c.j;
import c.k;
import c.m;
import c.n;
import c.o;
import c.r;
import c.t;
import c.x;
import c.y;
import c.z;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class w
implements e.a,
Cloneable {
    private static final List<k> A;
    private static final List<x> z;
    final n a;
    final Proxy b;
    final List<x> c;
    final List<k> d;
    final List<t> e;
    final List<t> f;
    final ProxySelector g;
    final m h;
    final c.c i;
    final d j;
    final SocketFactory k;
    final SSLSocketFactory l;
    final f m;
    final HostnameVerifier n;
    final c.g o;
    final b p;
    final b q;
    final j r;
    final o s;
    final boolean t;
    final boolean u;
    final boolean v;
    final int w;
    final int x;
    final int y;

    static {
        x[] arrx = new x[]{x.d, x.c, x.b};
        z = i.a(arrx);
        k[] arrk = new k[]{k.a, k.b, k.c};
        A = i.a(arrk);
        c.b = new c(){

            @Override
            public c.a.c.b a(j j2, c.a a2, r r2) {
                return j2.a(a2, r2);
            }

            @Override
            public d a(w w2) {
                return w2.g();
            }

            @Override
            public h a(j j2) {
                return j2.a;
            }

            @Override
            public void a(k k2, SSLSocket sSLSocket, boolean bl) {
                k2.a(sSLSocket, bl);
            }

            @Override
            public void a(r.a a2, String string) {
                a2.a(string);
            }

            @Override
            public boolean a(j j2, c.a.c.b b2) {
                return j2.b(b2);
            }

            @Override
            public void b(j j2, c.a.c.b b2) {
                j2.a(b2);
            }
        };
    }

    public w() {
        this(new a());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private w(a var1_1) {
        super();
        this.a = var1_1.a;
        this.b = var1_1.b;
        this.c = var1_1.c;
        this.d = var1_1.d;
        this.e = i.a(var1_1.e);
        this.f = i.a(var1_1.f);
        this.g = var1_1.g;
        this.h = var1_1.h;
        this.i = var1_1.i;
        this.j = var1_1.j;
        this.k = var1_1.k;
        var2_2 = this.d.iterator();
        var3_3 = false;
        while (var2_2.hasNext()) {
            var7_5 = (k)var2_2.next();
            var8_4 = var3_3 != false || var7_5.a() != false;
            var3_3 = var8_4;
        }
        if (var1_1.l != null || !var3_3) {
            this.l = var1_1.l;
        } else {
            var6_7 = SSLContext.getInstance((String)"TLS");
            var6_7.init(null, null, null);
            this.l = var6_7.getSocketFactory();
        }
        if (this.l == null || var1_1.m != null) ** GOTO lbl37
        var4_6 = g.a().a(this.l);
        if (var4_6 == null) {
            throw new IllegalStateException("Unable to extract the trust manager on " + g.a() + ", sslSocketFactory is " + (Object)this.l.getClass());
        }
        ** GOTO lbl34
        catch (GeneralSecurityException var5_8) {
            throw new AssertionError();
        }
lbl34: // 1 sources:
        this.m = g.a().a(var4_6);
        this.o = var1_1.o.a().a(this.m).a();
        ** GOTO lbl39
lbl37: // 1 sources:
        this.m = var1_1.m;
        this.o = var1_1.o;
lbl39: // 2 sources:
        this.n = var1_1.n;
        this.p = var1_1.p;
        this.q = var1_1.q;
        this.r = var1_1.r;
        this.s = var1_1.s;
        this.t = var1_1.t;
        this.u = var1_1.u;
        this.v = var1_1.v;
        this.w = var1_1.w;
        this.x = var1_1.x;
        this.y = var1_1.y;
    }

    static /* synthetic */ List x() {
        return z;
    }

    static /* synthetic */ List y() {
        return A;
    }

    public int a() {
        return this.w;
    }

    @Override
    public e a(z z2) {
        return new y(this, z2);
    }

    public int b() {
        return this.x;
    }

    public int c() {
        return this.y;
    }

    public Proxy d() {
        return this.b;
    }

    public ProxySelector e() {
        return this.g;
    }

    public m f() {
        return this.h;
    }

    d g() {
        if (this.i != null) {
            return this.i.a;
        }
        return this.j;
    }

    public o h() {
        return this.s;
    }

    public SocketFactory i() {
        return this.k;
    }

    public SSLSocketFactory j() {
        return this.l;
    }

    public HostnameVerifier k() {
        return this.n;
    }

    public c.g l() {
        return this.o;
    }

    public b m() {
        return this.q;
    }

    public b n() {
        return this.p;
    }

    public j o() {
        return this.r;
    }

    public boolean p() {
        return this.t;
    }

    public boolean q() {
        return this.u;
    }

    public boolean r() {
        return this.v;
    }

    public n s() {
        return this.a;
    }

    public List<x> t() {
        return this.c;
    }

    public List<k> u() {
        return this.d;
    }

    public List<t> v() {
        return this.e;
    }

    public List<t> w() {
        return this.f;
    }

    public static final class a {
        n a = new n();
        Proxy b;
        List<x> c = w.x();
        List<k> d = w.y();
        final List<t> e = new ArrayList();
        final List<t> f = new ArrayList();
        ProxySelector g = ProxySelector.getDefault();
        m h = m.a;
        c.c i;
        d j;
        SocketFactory k = SocketFactory.getDefault();
        SSLSocketFactory l;
        f m;
        HostnameVerifier n = c.a.d.d.a;
        c.g o = c.g.a;
        b p = b.a;
        b q = b.a;
        j r = new j();
        o s = o.a;
        boolean t = true;
        boolean u = true;
        boolean v = true;
        int w = 10000;
        int x = 10000;
        int y = 10000;
    }

}

