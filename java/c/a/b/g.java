/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  d.e
 *  d.k
 *  d.m
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.ProxySelector
 *  java.util.Date
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 */
package c.a.b;

import c.a.b.b;
import c.a.b.h;
import c.a.b.k;
import c.a.b.l;
import c.a.b.n;
import c.a.b.o;
import c.a.b.r;
import c.a.c;
import c.a.d;
import c.a.i;
import c.a.j;
import c.aa;
import c.ab;
import c.ac;
import c.ad;
import c.m;
import c.q;
import c.r;
import c.s;
import c.t;
import c.u;
import c.w;
import c.x;
import c.z;
import d.e;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class g {
    private static final ac e = new ac(){

        @Override
        public long contentLength() {
            return 0;
        }

        @Override
        public u contentType() {
            return null;
        }

        @Override
        public e source() {
            return new d.c();
        }
    };
    final w a;
    public final r b;
    long c = -1;
    public final boolean d;
    private final ab f;
    private c.a.b.i g;
    private boolean h;
    private final z i;
    private z j;
    private ab k;
    private ab l;
    private d.s m;
    private d.d n;
    private final boolean o;
    private final boolean p;
    private c.a.b.a q;
    private b r;

    /*
     * Enabled aggressive block sorting
     */
    public g(w w2, z z2, boolean bl, boolean bl2, boolean bl3, r r2, n n2, ab ab2) {
        this.a = w2;
        this.i = z2;
        this.d = bl;
        this.o = bl2;
        this.p = bl3;
        if (r2 == null) {
            r2 = new r(w2.o(), g.a(w2, z2));
        }
        this.b = r2;
        this.m = n2;
        this.f = ab2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static c.a a(w w2, z z2) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        c.g g2;
        if (z2.g()) {
            sSLSocketFactory = w2.j();
            hostnameVerifier = w2.k();
            g2 = w2.l();
            do {
                return new c.a(z2.a().f(), z2.a().g(), w2.h(), w2.i(), sSLSocketFactory, hostnameVerifier, g2, w2.n(), w2.d(), w2.t(), w2.u(), w2.e());
                break;
            } while (true);
        }
        sSLSocketFactory = null;
        hostnameVerifier = null;
        g2 = null;
        return new c.a(z2.a().f(), z2.a().g(), w2.h(), w2.i(), sSLSocketFactory, hostnameVerifier, g2, w2.n(), w2.d(), w2.t(), w2.u(), w2.e());
    }

    /*
     * Enabled aggressive block sorting
     */
    private ab a(c.a.b.a a2, ab ab2) throws IOException {
        d.s s2;
        if (a2 == null || (s2 = a2.a()) == null) {
            return ab2;
        }
        d.t t2 = new d.t(ab2.g().source(), a2, d.m.a((d.s)s2)){
            boolean a;
            final /* synthetic */ e b;
            final /* synthetic */ c.a.b.a c;
            final /* synthetic */ d.d d;

            @Override
            public void close() throws IOException {
                if (!this.a && !i.a(this, 100, TimeUnit.MILLISECONDS)) {
                    this.a = true;
                    this.c.b();
                }
                this.b.close();
            }

            /*
             * Exception decompiling
             */
            @Override
            public long read(d.c var1_1, long var2_2) throws IOException {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 2[SIMPLE_IF_TAKEN]
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
                // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
                // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
                // org.benf.cfr.reader.Main.doJar(Main.java:128)
                // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
                // java.lang.Thread.run(Thread.java:841)
                throw new IllegalStateException("Decompilation failed");
            }

            @Override
            public d.u timeout() {
                return this.b.timeout();
            }
        };
        return ab2.h().a(new k(ab2.f(), d.m.a((d.t)t2))).a();
    }

    /*
     * Enabled aggressive block sorting
     */
    private static c.r a(c.r r2, c.r r3) throws IOException {
        int n2 = 0;
        r.a a2 = new r.a();
        int n3 = r2.a();
        for (int i2 = 0; i2 < n3; ++i2) {
            String string = r2.a(i2);
            String string2 = r2.b(i2);
            if ("Warning".equalsIgnoreCase(string) && string2.startsWith("1") || c.a.b.j.a(string) && r3.a(string) != null) continue;
            a2.a(string, string2);
        }
        int n4 = r3.a();
        while (n2 < n4) {
            String string = r3.a(n2);
            if (!"Content-Length".equalsIgnoreCase(string) && c.a.b.j.a(string)) {
                a2.a(string, r3.b(n2));
            }
            ++n2;
        }
        return a2.a();
    }

    private String a(List<c.l> list) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                stringBuilder.append("; ");
            }
            c.l l2 = (c.l)list.get(i2);
            stringBuilder.append(l2.a()).append('=').append(l2.b());
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean a(ab ab2) {
        if (ab2.a().b().equals((Object)"HEAD")) {
            return false;
        }
        int n2 = ab2.b();
        if ((n2 < 100 || n2 >= 200) && n2 != 204 && n2 != 304) {
            return true;
        }
        if (c.a.b.j.a(ab2) != -1) return true;
        if (!"chunked".equalsIgnoreCase(ab2.a("Transfer-Encoding"))) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean a(ab ab2, ab ab3) {
        Date date;
        Date date2;
        if (ab3.b() == 304 || (date = ab2.f().b("Last-Modified")) != null && (date2 = ab3.f().b("Last-Modified")) != null && date2.getTime() < date.getTime()) {
            return true;
        }
        return false;
    }

    private static ab b(ab ab2) {
        if (ab2 != null && ab2.g() != null) {
            ab2 = ab2.h().a((ac)null).a();
        }
        return ab2;
    }

    private z b(z z2) throws IOException {
        List<c.l> list;
        z.a a2 = z2.e();
        if (z2.a("Host") == null) {
            a2.a("Host", i.a(z2.a(), false));
        }
        if (z2.a("Connection") == null) {
            a2.a("Connection", "Keep-Alive");
        }
        if (z2.a("Accept-Encoding") == null) {
            this.h = true;
            a2.a("Accept-Encoding", "gzip");
        }
        if (!(list = this.a.f().a(z2.a())).isEmpty()) {
            a2.a("Cookie", this.a(list));
        }
        if (z2.a("User-Agent") == null) {
            a2.a("User-Agent", j.a());
        }
        return a2.a();
    }

    /*
     * Enabled aggressive block sorting
     */
    private ab c(ab ab2) throws IOException {
        if (!this.h || !"gzip".equalsIgnoreCase(this.l.a("Content-Encoding")) || ab2.g() == null) {
            return ab2;
        }
        d.k k2 = new d.k((d.t)ab2.g().source());
        c.r r2 = ab2.f().b().b("Content-Encoding").b("Content-Length").a();
        return ab2.h().a(r2).a(new k(r2, d.m.a((d.t)k2))).a();
    }

    private boolean j() {
        if (this.o && this.a(this.j) && this.m == null) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private c.a.b.i k() throws o, l, IOException {
        boolean bl;
        if (!this.j.b().equals((Object)"GET")) {
            bl = true;
            do {
                return this.b.a(this.a.a(), this.a.b(), this.a.c(), this.a.r(), bl);
                break;
            } while (true);
        }
        bl = false;
        return this.b.a(this.a.a(), this.a.b(), this.a.c(), this.a.r(), bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void l() throws IOException {
        d d2 = c.b.a(this.a);
        if (d2 == null) {
            return;
        }
        if (b.a(this.l, this.j)) {
            this.q = d2.a(g.b(this.l));
            return;
        }
        if (!h.a(this.j.b())) return;
        try {
            d2.b(this.j);
            return;
        }
        catch (IOException var2_2) {
            return;
        }
    }

    private ab m() throws IOException {
        this.g.c();
        ab ab2 = this.g.b().a(this.j).a(this.b.a().d()).a(c.a.b.j.b, Long.toString((long)this.c)).a(c.a.b.j.c, Long.toString((long)System.currentTimeMillis())).a();
        if (!this.p) {
            ab2 = ab2.h().a(this.g.a(ab2)).a();
        }
        if ("close".equalsIgnoreCase(ab2.a().a("Connection")) || "close".equalsIgnoreCase(ab2.a("Connection"))) {
            this.b.c();
        }
        return ab2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public g a(IOException iOException, d.s s2) {
        if (!this.b.a(iOException, s2) || !this.a.r()) {
            return null;
        }
        r r2 = this.g();
        return new g(this.a, this.i, this.d, this.o, this.p, r2, (n)s2, this.f);
    }

    /*
     * Exception decompiling
     */
    public void a() throws l, o, IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:841)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(c.r r2) throws IOException {
        List<c.l> list;
        if (this.a.f() == m.a || (list = c.l.a(this.i.a(), r2)).isEmpty()) {
            return;
        }
        this.a.f().a(this.i.a(), list);
    }

    public boolean a(s s2) {
        s s3 = this.i.a();
        if (s3.f().equals((Object)s2.f()) && s3.g() == s2.g() && s3.b().equals((Object)s2.b())) {
            return true;
        }
        return false;
    }

    boolean a(z z2) {
        return h.c(z2.b());
    }

    public void b() {
        if (this.c != -1) {
            throw new IllegalStateException();
        }
        this.c = System.currentTimeMillis();
    }

    public ab c() {
        if (this.l == null) {
            throw new IllegalStateException();
        }
        return this.l;
    }

    public c.i d() {
        return this.b.a();
    }

    public void e() throws IOException {
        this.b.b();
    }

    public void f() {
        this.b.d();
    }

    /*
     * Enabled aggressive block sorting
     */
    public r g() {
        if (this.n != null) {
            i.a((Closeable)this.n);
        } else if (this.m != null) {
            i.a(this.m);
        }
        if (this.l != null) {
            i.a(this.l.g());
            return this.b;
        }
        this.b.a((IOException)null);
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void h() throws IOException {
        ab ab2;
        if (this.l != null) {
            return;
        }
        if (this.j == null && this.k == null) {
            throw new IllegalStateException("call sendRequest() first!");
        }
        if (this.j == null) return;
        if (this.p) {
            this.g.a(this.j);
            ab2 = this.m();
        } else if (!this.o) {
            ab2 = new a(0, this.j).a(this.j);
        } else {
            if (this.n != null && this.n.b().a() > 0) {
                this.n.e();
            }
            if (this.c == -1) {
                if (c.a.b.j.a(this.j) == -1 && this.m instanceof n) {
                    long l2 = ((n)this.m).a();
                    this.j = this.j.e().a("Content-Length", Long.toString((long)l2)).a();
                }
                this.g.a(this.j);
            }
            if (this.m != null) {
                if (this.n != null) {
                    this.n.close();
                } else {
                    this.m.close();
                }
                if (this.m instanceof n) {
                    this.g.a((n)this.m);
                }
            }
            ab2 = this.m();
        }
        this.a(ab2.f());
        if (this.k != null) {
            if (g.a(this.k, ab2)) {
                this.l = this.k.h().a(this.i).c(g.b(this.f)).a(g.a(this.k.f(), ab2.f())).b(g.b(this.k)).a(g.b(ab2)).a();
                ab2.g().close();
                this.e();
                d d2 = c.b.a(this.a);
                d2.a();
                d2.a(this.k, g.b(this.l));
                this.l = this.c(this.l);
                return;
            }
            i.a(this.k.g());
        }
        this.l = ab2.h().a(this.i).c(g.b(this.f)).b(g.b(this.k)).a(g.b(ab2)).a();
        if (!g.a(this.l)) return;
        this.l();
        this.l = this.c(this.a(this.q, this.l));
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public z i() throws IOException {
        if (this.l == null) {
            throw new IllegalStateException();
        }
        c.a.c.b b2 = this.b.a();
        ad ad2 = b2 != null ? b2.a() : null;
        int n2 = this.l.b();
        String string = this.i.b();
        switch (n2) {
            default: {
                return null;
            }
            case 407: {
                Proxy proxy = ad2 != null ? ad2.b() : this.a.d();
                if (proxy.type() == Proxy.Type.HTTP) return this.a.m().a(ad2, this.l);
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            case 401: {
                return this.a.m().a(ad2, this.l);
            }
            case 307: 
            case 308: {
                if (!string.equals((Object)"GET")) {
                    if (!string.equals((Object)"HEAD")) return null;
                }
            }
            case 300: 
            case 301: 
            case 302: 
            case 303: {
                if (!this.a.q()) return null;
                String string2 = this.l.a("Location");
                if (string2 == null) return null;
                s s2 = this.i.a().c(string2);
                if (s2 == null) return null;
                if (!s2.b().equals((Object)this.i.a().b())) {
                    if (!this.a.p()) return null;
                }
                z.a a2 = this.i.e();
                if (h.c(string)) {
                    if (h.d(string)) {
                        a2.a("GET", (aa)null);
                    } else {
                        a2.a(string, (aa)null);
                    }
                    a2.b("Transfer-Encoding");
                    a2.b("Content-Length");
                    a2.b("Content-Type");
                }
                if (this.a(s2)) return a2.a(s2).a();
                a2.b("Authorization");
                return a2.a(s2).a();
            }
            case 408: 
        }
        boolean bl = this.m == null || this.m instanceof n;
        if (!this.o) return this.i;
        if (!bl) return null;
        return this.i;
    }

    class a
    implements t.a {
        private final int b;
        private final z c;
        private int d;

        a(int n2, z z2) {
            this.b = n2;
            this.c = z2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public ab a(z z2) throws IOException {
            int n2;
            ab ab2;
            this.d = 1 + this.d;
            if (this.b > 0) {
                t t2 = (t)g.this.a.w().get(-1 + this.b);
                c.a a2 = this.a().a().a();
                if (!z2.a().f().equals((Object)a2.a().f())) throw new IllegalStateException("network interceptor " + t2 + " must retain the same host and port");
                if (z2.a().g() != a2.a().g()) {
                    throw new IllegalStateException("network interceptor " + t2 + " must retain the same host and port");
                }
                if (this.d > 1) {
                    throw new IllegalStateException("network interceptor " + t2 + " must call proceed() exactly once");
                }
            }
            if (this.b < g.this.a.w().size()) {
                a a3 = new a(1 + this.b, z2);
                t t3 = (t)g.this.a.w().get(this.b);
                ab ab3 = t3.a(a3);
                if (a3.d != 1) {
                    throw new IllegalStateException("network interceptor " + t3 + " must call proceed() exactly once");
                }
                if (ab3 != null) return ab3;
                throw new NullPointerException("network interceptor " + t3 + " returned null");
            }
            g.this.g.a(z2);
            g.this.j = z2;
            if (g.this.a(z2) && z2.d() != null) {
                d.d d2 = d.m.a((d.s)g.this.g.a(z2, z2.d().contentLength()));
                z2.d().writeTo(d2);
                d2.close();
            }
            if ((n2 = (ab2 = g.this.m()).b()) != 204) {
                if (n2 != 205) return ab2;
            }
            if (ab2.g().contentLength() <= 0) return ab2;
            throw new ProtocolException("HTTP " + n2 + " had non-zero Content-Length: " + ab2.g().contentLength());
        }

        public c.i a() {
            return g.this.b.a();
        }
    }

}

