/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ref.Reference
 *  java.net.Socket
 *  java.util.ArrayDeque
 *  java.util.Deque
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.Executor
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.logging.Logger
 */
package c;

import c.a;
import c.a.b.r;
import c.a.c;
import c.a.c.b;
import c.a.h;
import c.a.i;
import c.ad;
import c.s;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public final class j {
    static final /* synthetic */ boolean c;
    private static final Executor d;
    final h a;
    boolean b;
    private final int e;
    private final long f;
    private final Runnable g;
    private final Deque<b> h;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !j.class.desiredAssertionStatus();
        c = bl;
        d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), i.a("OkHttp ConnectionPool", true));
    }

    public j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public j(int n2, long l2, TimeUnit timeUnit) {
        this.g = new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
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
        };
        this.h = new ArrayDeque();
        this.a = new h();
        this.e = n2;
        this.f = timeUnit.toNanos(l2);
        if (l2 <= 0) {
            throw new IllegalArgumentException("keepAliveDuration <= 0: " + l2);
        }
    }

    private int a(b b2, long l2) {
        List<Reference<r>> list = b2.h;
        int n2 = 0;
        while (n2 < list.size()) {
            if (((Reference)list.get(n2)).get() != null) {
                ++n2;
                continue;
            }
            c.a.warning("A connection to " + b2.a().a().a() + " was leaked. Did you forget to close a response body?");
            list.remove(n2);
            b2.i = true;
            if (!list.isEmpty()) continue;
            b2.j = l2 - this.f;
            return 0;
        }
        return list.size();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    long a(long var1_1) {
        var3_2 = null;
        var4_3 = Long.MIN_VALUE;
        var22_4 = this;
        // MONITORENTER : var22_4
        var7_5 = this.h.iterator();
        var8_6 = 0;
        var9_7 = 0;
        do {
            if (!var7_5.hasNext()) ** GOTO lbl20
            var15_12 = (b)var7_5.next();
            if (this.a(var15_12, var1_1) > 0) {
                ++var9_7;
                continue;
            }
            var16_9 = var8_6 + 1;
            var17_8 = var1_1 - var15_12.j;
            if (var17_8 <= var4_3) ** GOTO lbl36
            var19_10 = var15_12;
            var20_11 = var17_8;
            ** GOTO lbl38
lbl20: // 1 sources:
            if (var4_3 >= this.f || var8_6 > this.e) {
                this.h.remove((Object)var3_2);
                // MONITOREXIT : var22_4
                i.a(var3_2.c());
                return 0;
            }
            if (var8_6 > 0) {
                var13_13 = this.f - var4_3;
                // MONITOREXIT : var22_4
                return var13_13;
            }
            if (var9_7 > 0) {
                var11_14 = this.f;
                // MONITOREXIT : var22_4
                return var11_14;
            }
            this.b = false;
            // MONITOREXIT : var22_4
            return -1;
lbl36: // 1 sources:
            var19_10 = var3_2;
            var20_11 = var4_3;
lbl38: // 2 sources:
            var4_3 = var20_11;
            var3_2 = var19_10;
            var8_6 = var16_9;
        } while (true);
    }

    b a(a a2, r r2) {
        if (!c && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        for (b b2 : this.h) {
            if (b2.h.size() >= b2.g || !a2.equals(b2.a().a) || b2.i) continue;
            r2.a(b2);
            return b2;
        }
        return null;
    }

    void a(b b2) {
        if (!c && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        if (!this.b) {
            this.b = true;
            d.execute(this.g);
        }
        this.h.add((Object)b2);
    }

    boolean b(b b2) {
        if (!c && !Thread.holdsLock((Object)this)) {
            throw new AssertionError();
        }
        if (b2.i || this.e == 0) {
            this.h.remove((Object)b2);
            return true;
        }
        this.notifyAll();
        return false;
    }

}

