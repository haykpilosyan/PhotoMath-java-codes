/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package c;

import c.a.b.g;
import c.ab;
import c.e;
import c.f;
import c.n;
import c.s;
import c.t;
import c.w;
import c.z;
import java.io.IOException;
import java.util.List;

final class y
implements e {
    volatile boolean a;
    z b;
    g c;
    private final w d;
    private boolean e;

    protected y(w w2, z z2) {
        this.d = w2;
        this.b = z2;
    }

    static /* synthetic */ ab a(y y2, boolean bl) throws IOException {
        return y2.a(bl);
    }

    private ab a(boolean bl) throws IOException {
        return new a(0, this.b, bl).a(this.b);
    }

    static /* synthetic */ String a(y y2) {
        return y2.d();
    }

    /*
     * Enabled aggressive block sorting
     */
    private String d() {
        String string = this.a ? "canceled call" : "call";
        s s2 = this.b.a().c("/...");
        return string + " to " + s2;
    }

    /*
     * Exception decompiling
     */
    ab a(z var1_1, boolean var2_2) throws IOException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:371)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:449)
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
    public z a() {
        return this.b;
    }

    @Override
    public void a(f f2) {
        this.a(f2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(f f2, boolean bl) {
        y y2 = this;
        synchronized (y2) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        this.d.s().a(new b(f2, bl));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public ab b() throws IOException {
        y y2 = this;
        synchronized (y2) {
            if (this.e) {
                throw new IllegalStateException("Already Executed");
            }
            this.e = true;
        }
        try {
            this.d.s().a(this);
            ab ab2 = this.a(false);
            if (ab2 != null) return ab2;
            {
                throw new IOException("Canceled");
            }
        }
        finally {
            this.d.s().a((e)this);
        }
    }

    @Override
    public void c() {
        this.a = true;
        if (this.c != null) {
            this.c.f();
        }
    }

    class a
    implements t.a {
        private final int b;
        private final z c;
        private final boolean d;

        a(int n2, z z2, boolean bl) {
            this.b = n2;
            this.c = z2;
            this.d = bl;
        }

        @Override
        public ab a(z z2) throws IOException {
            if (this.b < y.this.d.v().size()) {
                a a2 = new a(1 + this.b, z2, this.d);
                t t2 = (t)y.this.d.v().get(this.b);
                ab ab2 = t2.a(a2);
                if (ab2 == null) {
                    throw new NullPointerException("application interceptor " + t2 + " returned null");
                }
                return ab2;
            }
            return y.this.a(z2, this.d);
        }
    }

    final class b
    extends c.a.e {
        private final f c;
        private final boolean d;

        private b(f f2, boolean bl) {
            Object[] arrobject = new Object[]{y.this.b.a().toString()};
            super("OkHttp %s", arrobject);
            this.c = f2;
            this.d = bl;
        }

        String a() {
            return y.this.b.a().f();
        }

        /*
         * Exception decompiling
         */
        @Override
        protected void b() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 6[CATCHBLOCK]
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
    }

}

