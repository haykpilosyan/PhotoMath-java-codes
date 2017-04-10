/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  java.io.Closeable
 *  java.io.File
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.LinkedHashMap
 *  java.util.concurrent.Executor
 *  java.util.regex.Pattern
 */
package c.a;

import d.c;
import d.d;
import d.s;
import d.u;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public final class b
implements Closeable,
Flushable {
    static final Pattern a;
    static final /* synthetic */ boolean b;
    private static final s p;
    private final c.a.c.a c;
    private long d;
    private final int e;
    private long f;
    private d g;
    private final LinkedHashMap<String, b> h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private long m;
    private final Executor n;
    private final Runnable o;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !b.class.desiredAssertionStatus();
        b = bl;
        a = Pattern.compile((String)"[a-z0-9_-]{1,120}");
        p = new s(){

            @Override
            public void close() throws IOException {
            }

            @Override
            public void flush() throws IOException {
            }

            @Override
            public u timeout() {
                return u.NONE;
            }

            @Override
            public void write(c c2, long l2) throws IOException {
                c2.g(l2);
            }
        };
    }

    /*
     * Exception decompiling
     */
    private void a(a var1_1, boolean var2_2) throws IOException {
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

    private boolean a(b b2) throws IOException {
        if (b2.f != null) {
            b2.f.d = true;
        }
        for (int i2 = 0; i2 < this.e; ++i2) {
            this.c.a(b2.c[i2]);
            this.f -= b2.b[i2];
            b.b((b)b2)[i2] = 0;
        }
        this.i = 1 + this.i;
        this.g.b("REMOVE").i(32).b(b2.a).i(10);
        this.h.remove((Object)b2.a);
        if (this.b()) {
            this.n.execute(this.o);
        }
        return true;
    }

    private boolean b() {
        if (this.i >= 2000 && this.i >= this.h.size()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c() {
        b b2 = this;
        synchronized (b2) {
            if (!this.a()) return;
            throw new IllegalStateException("cache is closed");
        }
    }

    private void d() throws IOException {
        while (this.f > this.d) {
            this.a((b)this.h.values().iterator().next());
        }
        this.l = false;
    }

    public boolean a() {
        b b2 = this;
        synchronized (b2) {
            boolean bl = this.k;
            return bl;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void close() throws IOException {
        b b2 = this;
        // MONITORENTER : b2
        if (!this.j || this.k) {
            this.k = true;
            // MONITOREXIT : b2
            return;
        }
        b[] arrb = (b[])this.h.values().toArray((Object[])new b[this.h.size()]);
        int n2 = arrb.length;
        int n3 = 0;
        do {
            if (n3 >= n2) {
                this.d();
                this.g.close();
                this.g = null;
                this.k = true;
                return;
            }
            b b3 = arrb[n3];
            if (b3.f != null) {
                b3.f.a();
            }
            ++n3;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void flush() throws IOException {
        b b2 = this;
        synchronized (b2) {
            boolean bl = this.j;
            if (bl) {
                this.c();
                this.d();
                this.g.flush();
            }
            return;
        }
    }

    public final class a {
        final /* synthetic */ b a;
        private final b b;
        private final boolean[] c;
        private boolean d;

        static /* synthetic */ b a(a a2) {
            return a2.b;
        }

        static /* synthetic */ boolean[] b(a a2) {
            return a2.c;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void a() throws IOException {
            b b2;
            b b3 = b2 = this.a;
            synchronized (b3) {
                this.a.a(this, false);
                return;
            }
        }
    }

    private final class b {
        private final String a;
        private final long[] b;
        private final File[] c;
        private final File[] d;
        private boolean e;
        private a f;
        private long g;

        static /* synthetic */ long a(b b2, long l2) {
            b2.g = l2;
            return l2;
        }

        static /* synthetic */ a a(b b2, a a2) {
            b2.f = a2;
            return a2;
        }

        static /* synthetic */ boolean a(b b2, boolean bl) {
            b2.e = bl;
            return bl;
        }

        static /* synthetic */ File[] d(b b2) {
            return b2.d;
        }

        static /* synthetic */ boolean f(b b2) {
            return b2.e;
        }

        void a(d d2) throws IOException {
            for (long l2 : this.b) {
                d2.i(32).k(l2);
            }
        }
    }

}

