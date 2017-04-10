/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  d.e
 *  d.m
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.net.ConnectException
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Socket
 *  java.net.SocketTimeoutException
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.SSLSocketFactory
 */
package c.a.c;

import c.a.a;
import c.a.a.d;
import c.a.a.e;
import c.a.b.o;
import c.a.g;
import c.a.i;
import c.a.j;
import c.ab;
import c.ad;
import c.h;
import c.k;
import c.q;
import c.r;
import c.s;
import c.x;
import c.z;
import d.c;
import d.m;
import d.t;
import d.u;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;

public final class b
extends d.b
implements c.i {
    public Socket b;
    public volatile d c;
    public int d;
    public d.e e;
    public d.d f;
    public int g;
    public final List<Reference<c.a.b.r>> h = new ArrayList();
    public boolean i;
    public long j = Long.MAX_VALUE;
    private final ad k;
    private Socket l;
    private q m;
    private x n;

    public b(ad ad2) {
        this.k = ad2;
    }

    private void a(int n2, int n3) throws IOException {
        z z2 = this.e();
        s s2 = z2.a();
        String string = "CONNECT " + i.a(s2, true) + " HTTP/1.1";
        block4 : do {
            c.a.b.d d2 = new c.a.b.d(null, this.e, this.f);
            this.e.timeout().timeout(n2, TimeUnit.MILLISECONDS);
            this.f.timeout().timeout(n3, TimeUnit.MILLISECONDS);
            d2.a(z2.c(), string);
            d2.c();
            ab ab2 = d2.d().a(z2).a();
            long l2 = c.a.b.j.a(ab2);
            if (l2 == -1) {
                l2 = 0;
            }
            t t2 = d2.b(l2);
            i.b(t2, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            t2.close();
            switch (ab2.b()) {
                default: {
                    throw new IOException("Unexpected response code for CONNECT: " + ab2.b());
                }
                case 200: {
                    if (this.e.b().f() && this.f.b().f()) break block4;
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                case 407: {
                    if ((z2 = this.k.a().d().a(this.k, ab2)) != null) continue block4;
                    throw new IOException("Failed to authenticate with proxy");
                }
            }
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n2, int n3, int n4, a a2) throws IOException {
        this.l.setSoTimeout(n3);
        try {
            g.a().a(this.l, this.k.c(), n2);
        }
        catch (ConnectException var5_6) {
            throw new ConnectException("Failed to connect to " + (Object)this.k.c());
        }
        this.e = m.a((t)m.b((Socket)this.l));
        this.f = m.a((d.s)m.a((Socket)this.l));
        if (this.k.a().i() != null) {
            this.a(n3, n4, a2);
        } else {
            this.n = x.b;
            this.b = this.l;
        }
        if (this.n != x.c && this.n != x.d) {
            this.g = 1;
            return;
        }
        this.b.setSoTimeout(0);
        d d2 = new d.a(true).a(this.b, this.k.a().a().f(), this.e, this.f).a(this.n).a(this).a();
        d2.d();
        this.g = d2.b();
        this.c = d2;
    }

    /*
     * Exception decompiling
     */
    private void a(int var1_1, int var2_2, a var3_3) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredDo.transformStructuredChildren(StructuredDo.java:53)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredCatch.transformStructuredChildren(StructuredCatch.java:72)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredTry.transformStructuredChildren(StructuredTry.java:81)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.transformStructuredChildren(Block.java:378)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:487)
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

    private z e() throws IOException {
        return new z.a().a(this.k.a().a()).a("Host", i.a(this.k.a().a(), true)).a("Proxy-Connection", "Keep-Alive").a("User-Agent", j.a()).a();
    }

    @Override
    public ad a() {
        return this.k;
    }

    /*
     * Exception decompiling
     */
    public void a(int var1_1, int var2_2, int var3_3, List<k> var4_4, boolean var5_5) throws o {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
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

    @Override
    public void a(d d2) {
        this.g = d2.b();
    }

    @Override
    public void a(e e2) throws IOException {
        e2.a(c.a.a.a.k);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean a(boolean var1_1) {
        var2_2 = true;
        if (this.b.isClosed() != false) return false;
        if (this.b.isInputShutdown() != false) return false;
        if (this.b.isOutputShutdown()) {
            return false;
        }
        if (this.c != null) return var2_2;
        if (var1_1 == false) return var2_2;
        var5_3 = this.b.getSoTimeout();
        this.b.setSoTimeout(1);
        var7_4 = this.e.f();
        if (!var7_4) ** GOTO lbl20
        {
            catch (Throwable var6_5) {
                this.b.setSoTimeout(var5_3);
                throw var6_5;
            }
        }
        try {
            this.b.setSoTimeout(var5_3);
            return false;
lbl20: // 1 sources:
            this.b.setSoTimeout(var5_3);
            return var2_2;
        }
        catch (IOException var3_6) {
            return false;
        }
        catch (SocketTimeoutException var4_7) {
            return var2_2;
        }
    }

    public void b() {
        i.a(this.l);
    }

    public Socket c() {
        return this.b;
    }

    public q d() {
        return this.m;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder().append("Connection{").append(this.k.a().a().f()).append(":").append(this.k.a().a().g()).append(", proxy=").append((Object)this.k.b()).append(" hostAddress=").append((Object)this.k.c()).append(" cipherSuite=");
        if (this.m != null) {
            object = this.m.a();
            do {
                return stringBuilder.append(object).append(" protocol=").append((Object)this.n).append('}').toString();
                break;
            } while (true);
        }
        object = "none";
        return stringBuilder.append(object).append(" protocol=").append((Object)this.n).append('}').toString();
    }
}

