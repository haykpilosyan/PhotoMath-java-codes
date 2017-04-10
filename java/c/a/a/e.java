/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.e
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.SocketTimeoutException
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.List
 */
package c.a.a;

import c.a.a.d;
import c.a.a.f;
import c.a.a.g;
import c.a.a.n;
import d.s;
import d.t;
import d.u;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class e {
    static final /* synthetic */ boolean d;
    long a = 0;
    long b;
    final a c;
    private final int e;
    private final d f;
    private final List<f> g;
    private List<f> h;
    private final b i;
    private final c j;
    private final c k;
    private c.a.a.a l;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !e.class.desiredAssertionStatus();
        d = bl;
    }

    e(int n2, d d2, boolean bl, boolean bl2, List<f> list) {
        this.j = new c();
        this.k = new c();
        this.l = null;
        if (d2 == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.e = n2;
        this.f = d2;
        this.b = d2.f.f(65536);
        this.i = new b(d2.e.f(65536));
        this.c = new a();
        this.i.g = bl2;
        this.c.e = bl;
        this.g = list;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean d(c.a.a.a a2) {
        if (!d && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        e e2 = this;
        synchronized (e2) {
            if (this.l != null) {
                return false;
            }
            if (this.i.g && this.c.e) {
                return false;
            }
            this.l = a2;
            this.notifyAll();
        }
        this.f.b(this.e);
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void j() throws IOException {
        if (!d && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        e e2 = this;
        // MONITORENTER : e2
        boolean bl = !this.i.g && this.i.f && (this.c.e || this.c.d);
        boolean bl2 = this.b();
        // MONITOREXIT : e2
        if (bl) {
            this.a(c.a.a.a.l);
            return;
        }
        if (bl2) return;
        this.f.b(this.e);
    }

    private void k() throws IOException {
        if (this.c.d) {
            throw new IOException("stream closed");
        }
        if (this.c.e) {
            throw new IOException("stream finished");
        }
        if (this.l != null) {
            throw new IOException("stream was reset: " + (Object)((Object)this.l));
        }
    }

    private void l() throws InterruptedIOException {
        try {
            this.wait();
            return;
        }
        catch (InterruptedException var1_1) {
            throw new InterruptedIOException();
        }
    }

    public int a() {
        return this.e;
    }

    void a(long l2) {
        this.b = l2 + this.b;
        if (l2 > 0) {
            this.notifyAll();
        }
    }

    public void a(c.a.a.a a2) throws IOException {
        if (!this.d(a2)) {
            return;
        }
        this.f.b(this.e, a2);
    }

    void a(d.e e2, int n2) throws IOException {
        if (!d && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        this.i.a(e2, n2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void a(List<f> list, g g2) {
        c.a.a.a a2;
        if (!d && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        boolean bl = true;
        e e2 = this;
        // MONITORENTER : e2
        if (this.h == null) {
            if (g2.c()) {
                a2 = c.a.a.a.b;
            } else {
                this.h = list;
                bl = this.b();
                this.notifyAll();
                a2 = null;
            }
        } else if (g2.d()) {
            a2 = c.a.a.a.e;
        } else {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.h);
            arrayList.addAll(list);
            this.h = arrayList;
            a2 = null;
        }
        // MONITOREXIT : e2
        if (a2 != null) {
            this.b(a2);
            return;
        }
        if (bl) return;
        this.f.b(this.e);
    }

    public void b(c.a.a.a a2) {
        if (!this.d(a2)) {
            return;
        }
        this.f.a(this.e, a2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b() {
        e e2 = this;
        synchronized (e2) {
            c.a.a.a a2 = this.l;
            boolean bl = false;
            if (a2 != null) return bl;
            if (!this.i.g) {
                if (!this.i.f) return true;
            }
            if (!this.c.e) {
                if (!this.c.d) return true;
            }
            List<f> list = this.h;
            bl = false;
            if (list != null) return bl;
            return true;
        }
    }

    void c(c.a.a.a a2) {
        e e2 = this;
        synchronized (e2) {
            if (this.l == null) {
                this.l = a2;
                this.notifyAll();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean c() {
        boolean bl = (1 & this.e) == 1;
        if (this.f.b != bl) return false;
        return true;
    }

    /*
     * Exception decompiling
     */
    public List<f> d() throws IOException {
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

    public u e() {
        return this.j;
    }

    public u f() {
        return this.k;
    }

    public t g() {
        return this.i;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public s h() {
        e e2 = this;
        synchronized (e2) {
            if (this.h == null && !this.c()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
            return this.c;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void i() {
        if (!d && Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        e e2 = this;
        // MONITORENTER : e2
        this.i.g = true;
        boolean bl = this.b();
        this.notifyAll();
        // MONITOREXIT : e2
        if (bl) return;
        this.f.b(this.e);
    }

    final class a
    implements s {
        static final /* synthetic */ boolean a;
        private final d.c c;
        private boolean d;
        private boolean e;

        /*
         * Enabled aggressive block sorting
         */
        static {
            boolean bl = !e.class.desiredAssertionStatus();
            a = bl;
        }

        a() {
            this.c = new d.c();
        }

        /*
         * Exception decompiling
         */
        private void a(boolean var1_1) throws IOException {
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
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:841)
            throw new IllegalStateException("Decompilation failed");
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void close() throws IOException {
            e e2;
            e e3;
            if (!a && Thread.holdsLock((Object)e.this)) {
                throw new AssertionError();
            }
            e e4 = e3 = e.this;
            // MONITORENTER : e4
            if (this.d) {
                // MONITOREXIT : e4
                return;
            }
            // MONITOREXIT : e4
            if (!e.this.c.e) {
                if (this.c.a() > 0) {
                    while (this.c.a() > 0) {
                        this.a(true);
                    }
                } else {
                    e.this.f.a(e.this.e, true, null, 0);
                }
            }
            e e5 = e2 = e.this;
            // MONITORENTER : e5
            this.d = true;
            // MONITOREXIT : e5
            e.this.f.c();
            e.this.j();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void flush() throws IOException {
            e e2;
            if (!a && Thread.holdsLock((Object)e.this)) {
                throw new AssertionError();
            }
            e e3 = e2 = e.this;
            synchronized (e3) {
                e.this.k();
            }
            while (this.c.a() > 0) {
                this.a(false);
                e.this.f.c();
            }
            return;
        }

        @Override
        public u timeout() {
            return e.this.k;
        }

        @Override
        public void write(d.c c2, long l2) throws IOException {
            if (!a && Thread.holdsLock((Object)e.this)) {
                throw new AssertionError();
            }
            this.c.write(c2, l2);
            while (this.c.a() >= 16384) {
                this.a(false);
            }
        }
    }

    private final class b
    implements t {
        static final /* synthetic */ boolean a;
        private final d.c c;
        private final d.c d;
        private final long e;
        private boolean f;
        private boolean g;

        /*
         * Enabled aggressive block sorting
         */
        static {
            boolean bl = !e.class.desiredAssertionStatus();
            a = bl;
        }

        private b(long l2) {
            this.c = new d.c();
            this.d = new d.c();
            this.e = l2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private void a() throws IOException {
            e.this.j.enter();
            try {
                while (this.d.a() == 0 && !this.g && !this.f && e.this.l == null) {
                    e.this.l();
                }
                return;
            }
            finally {
                e.this.j.a();
            }
        }

        private void b() throws IOException {
            if (this.f) {
                throw new IOException("stream closed");
            }
            if (e.this.l != null) {
                throw new IOException("stream was reset: " + (Object)((Object)e.this.l));
            }
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        void a(d.e var1_1, long var2_2) throws IOException {
            if (b.a || !Thread.holdsLock((Object)e.this)) ** GOTO lbl11
            throw new AssertionError();
lbl-1000: // 1 sources:
            {
                var2_2 -= var8_7;
                var15_10 = var10_8 = e.this;
                // MONITORENTER : var15_10
                var12_9 = this.d.a() == 0;
                this.d.a((t)this.c);
                if (var12_9) {
                    e.this.notifyAll();
                }
                // MONITOREXIT : var15_10
lbl11: // 2 sources:
                if (var2_2 <= 0) return;
                var16_3 = var4_4 = e.this;
                // MONITORENTER : var16_3
                var6_5 = this.g;
                var7_6 = var2_2 + this.d.a() > this.e;
                // MONITOREXIT : var16_3
                if (var7_6) {
                    var1_1.g(var2_2);
                    e.this.b(c.a.a.a.h);
                    return;
                }
                if (!var6_5) continue;
                var1_1.g(var2_2);
                return;
                ** while ((var8_7 = var1_1.read((d.c)this.c, (long)var2_2)) != -1)
            }
lbl25: // 1 sources:
            throw new EOFException();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void close() throws IOException {
            e e2;
            e e3 = e2 = e.this;
            synchronized (e3) {
                this.f = true;
                this.d.t();
                e.this.notifyAll();
            }
            e.this.j();
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public long read(d.c c2, long l2) throws IOException {
            long l3;
            d d2;
            e e2;
            if (l2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + l2);
            }
            e e3 = e2 = e.this;
            synchronized (e3) {
                this.a();
                this.b();
                if (this.d.a() == 0) {
                    return -1;
                }
                l3 = this.d.read(c2, Math.min((long)l2, (long)this.d.a()));
                e e4 = e.this;
                e4.a = l3 + e4.a;
                if (e.this.a >= (long)(e.a((e)e.this).e.f(65536) / 2)) {
                    e.this.f.a(e.this.e, e.this.a);
                    e.this.a = 0;
                }
            }
            d d3 = d2 = e.this.f;
            synchronized (d3) {
                d d4 = e.this.f;
                d4.c = l3 + d4.c;
                if (e.a((e)e.this).c >= (long)(e.a((e)e.this).e.f(65536) / 2)) {
                    e.this.f.a(0, e.a((e)e.this).c);
                    e.a((e)e.this).c = 0;
                }
                return l3;
            }
        }

        @Override
        public u timeout() {
            return e.this.j;
        }
    }

    class c
    extends d.a {
        c() {
        }

        public void a() throws IOException {
            if (this.exit()) {
                throw this.newTimeoutException(null);
            }
        }

        @Override
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause((Throwable)iOException);
            }
            return socketTimeoutException;
        }

        @Override
        protected void timedOut() {
            e.this.b(c.a.a.a.l);
        }
    }

}

