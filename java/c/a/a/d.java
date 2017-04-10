/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  d.e
 *  d.f
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.net.Socket
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.LinkedHashSet
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Future
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.SynchronousQueue
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package c.a.a;

import c.a.a.b;
import c.a.a.e;
import c.a.a.f;
import c.a.a.g;
import c.a.a.l;
import c.a.a.m;
import c.a.a.n;
import c.a.a.o;
import c.a.a.p;
import c.a.i;
import c.x;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class d
implements Closeable {
    static final /* synthetic */ boolean k;
    private static final ExecutorService l;
    final x a;
    final boolean b;
    long c;
    long d;
    n e;
    final n f;
    final p g;
    final Socket h;
    final c.a.a.c i;
    final c j;
    private final b m;
    private final Map<Integer, e> n;
    private final String o;
    private int p;
    private int q;
    private boolean r;
    private long s;
    private final ExecutorService t;
    private Map<Integer, l> u;
    private final m v;
    private int w;
    private boolean x;
    private final Set<Integer> y;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !d.class.desiredAssertionStatus();
        k = bl;
        l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, (BlockingQueue)new SynchronousQueue(), i.a("OkHttp FramedConnection", true));
    }

    /*
     * Enabled aggressive block sorting
     */
    private d(a a2) throws IOException {
        int n2 = 2;
        this.n = new HashMap();
        this.s = System.nanoTime();
        this.c = 0;
        this.e = new n();
        this.f = new n();
        this.x = false;
        this.y = new LinkedHashSet();
        this.a = a2.f;
        this.v = a2.g;
        this.b = a2.h;
        this.m = a2.e;
        int n3 = a2.h ? 1 : n2;
        this.q = n3;
        if (a2.h && this.a == x.d) {
            this.q = 2 + this.q;
        }
        if (a2.h) {
            n2 = 1;
        }
        this.w = n2;
        if (a2.h) {
            this.e.a(7, 0, 16777216);
        }
        this.o = a2.b;
        if (this.a == x.d) {
            this.g = new c.a.a.i();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            Object[] arrobject = new Object[]{this.o};
            this.t = new ThreadPoolExecutor(0, 1, 60, timeUnit, (BlockingQueue)linkedBlockingQueue, i.a(String.format((String)"OkHttp %s Push Observer", (Object[])arrobject), true));
            this.f.a(7, 0, 65535);
            this.f.a(5, 0, 16384);
        } else {
            if (this.a != x.c) {
                throw new AssertionError((Object)this.a);
            }
            this.g = new o();
            this.t = null;
        }
        this.d = this.f.f(65536);
        this.h = a2.a;
        this.i = this.g.a(a2.d, this.b);
        this.j = new c(this.g.a(a2.c, this.b));
        new Thread((Runnable)this.j).start();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private e a(int n2, List<f> list, boolean bl, boolean bl2) throws IOException {
        c.a.a.c c2;
        boolean bl3 = true;
        boolean bl4 = !bl ? bl3 : false;
        if (bl2) {
            bl3 = false;
        }
        c.a.a.c c3 = c2 = this.i;
        // MONITORENTER : c3
        d d2 = this;
        // MONITORENTER : d2
        if (this.r) {
            throw new IOException("shutdown");
        }
        int n3 = this.q;
        this.q = 2 + this.q;
        e e2 = new e(n3, this, bl4, bl3, list);
        if (e2.b()) {
            this.n.put((Object)n3, (Object)e2);
            this.a(false);
        }
        // MONITOREXIT : d2
        if (n2 == 0) {
            this.i.a(bl4, bl3, n3, n2, list);
        } else {
            if (this.b) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            }
            this.i.a(n2, n3, list);
        }
        // MONITOREXIT : c3
        if (bl) return e2;
        this.i.b();
        return e2;
    }

    private void a(final int n2, d.e e2, final int n3, final boolean bl) throws IOException {
        final d.c c2 = new d.c();
        e2.a((long)n3);
        e2.read(c2, (long)n3);
        if (c2.a() != (long)n3) {
            throw new IOException("" + c2.a() + " != " + n3);
        }
        ExecutorService executorService = this.t;
        Object[] arrobject = new Object[]{this.o, n2};
        executorService.execute((Runnable)new c.a.e("OkHttp %s Push Data[%s]", arrobject){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            public void b() {
                try {
                    d d2;
                    boolean bl2 = d.this.v.a(n2, (d.e)c2, n3, bl);
                    if (bl2) {
                        d.this.i.a(n2, c.a.a.a.l);
                    }
                    if (!bl2) {
                        if (!bl) return;
                    }
                    d d3 = d2 = d.this;
                    // MONITORENTER : d3
                }
                catch (IOException var1_4) {
                    // empty catch block
                }
                d.this.y.remove((Object)n2);
                // MONITOREXIT : d3
                return;
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(final int n2, final List<f> list) {
        d d2 = this;
        synchronized (d2) {
            if (this.y.contains((Object)n2)) {
                this.a(n2, c.a.a.a.b);
                return;
            }
            this.y.add((Object)n2);
        }
        ExecutorService executorService = this.t;
        Object[] arrobject = new Object[]{this.o, n2};
        executorService.execute((Runnable)new c.a.e("OkHttp %s Push Request[%s]", arrobject){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            public void b() {
                if (!d.this.v.a(n2, list)) return;
                try {
                    d d2;
                    d.this.i.a(n2, c.a.a.a.l);
                    d d3 = d2 = d.this;
                    // MONITORENTER : d3
                }
                catch (IOException var1_3) {
                    // empty catch block
                }
                d.this.y.remove((Object)n2);
                // MONITOREXIT : d3
                return;
            }
        });
    }

    private void a(final int n2, final List<f> list, final boolean bl) {
        ExecutorService executorService = this.t;
        Object[] arrobject = new Object[]{this.o, n2};
        executorService.execute((Runnable)new c.a.e("OkHttp %s Push Headers[%s]", arrobject){

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            @Override
            public void b() {
                var1_1 = d.h(d.this).a(n2, list, bl);
                if (!var1_1) ** GOTO lbl5
                try {
                    d.this.i.a(n2, c.a.a.a.l);
lbl5: // 2 sources:
                    if (!var1_1) {
                        if (bl == false) return;
                    }
                    var6_3 = var3_2 = d.this;
                    // MONITORENTER : var6_3
                }
                catch (IOException var2_4) {
                    // empty catch block
                }
                d.i(d.this).remove((Object)n2);
                // MONITOREXIT : var6_3
                return;
            }
        });
    }

    /*
     * Exception decompiling
     */
    private void a(c.a.a.a var1_1, c.a.a.a var2_2) throws IOException {
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

    static /* synthetic */ void a(d d2, c.a.a.a a2, c.a.a.a a3) throws IOException {
        d2.a(a2, a3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(boolean bl) {
        d d2 = this;
        synchronized (d2) {
            long l2 = bl ? System.nanoTime() : Long.MAX_VALUE;
            this.s = l2;
            return;
        }
    }

    private void a(final boolean bl, final int n2, final int n3, final l l2) {
        ExecutorService executorService = l;
        Object[] arrobject = new Object[]{this.o, n2, n3};
        executorService.execute((Runnable)new c.a.e("OkHttp %s ping %08x%08x", arrobject){

            @Override
            public void b() {
                try {
                    d.this.b(bl, n2, n3, l2);
                    return;
                }
                catch (IOException var1_1) {
                    return;
                }
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(boolean bl, int n2, int n3, l l2) throws IOException {
        c.a.a.c c2;
        c.a.a.c c3 = c2 = this.i;
        synchronized (c3) {
            if (l2 != null) {
                l2.a();
            }
            this.i.a(bl, n2, n3);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private l c(int n2) {
        d d2 = this;
        synchronized (d2) {
            if (this.u == null) return null;
            return (l)this.u.remove((Object)n2);
        }
    }

    private void c(final int n2, final c.a.a.a a2) {
        ExecutorService executorService = this.t;
        Object[] arrobject = new Object[]{this.o, n2};
        executorService.execute((Runnable)new c.a.e("OkHttp %s Push Reset[%s]", arrobject){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            @Override
            public void b() {
                d d2;
                d.this.v.a(n2, a2);
                d d3 = d2 = d.this;
                synchronized (d3) {
                    d.this.y.remove((Object)n2);
                    return;
                }
            }
        });
    }

    private boolean d(int n2) {
        if (this.a == x.d && n2 != 0 && (n2 & 1) == 0) {
            return true;
        }
        return false;
    }

    e a(int n2) {
        d d2 = this;
        synchronized (d2) {
            e e2 = (e)this.n.get((Object)n2);
            return e2;
        }
    }

    public e a(List<f> list, boolean bl, boolean bl2) throws IOException {
        return this.a(0, list, bl, bl2);
    }

    public x a() {
        return this.a;
    }

    void a(final int n2, final long l2) {
        ExecutorService executorService = l;
        Object[] arrobject = new Object[]{this.o, n2};
        executorService.execute((Runnable)new c.a.e("OkHttp Window Update %s stream %d", arrobject){

            @Override
            public void b() {
                try {
                    d.this.i.a(n2, l2);
                    return;
                }
                catch (IOException var1_1) {
                    return;
                }
            }
        });
    }

    void a(final int n2, final c.a.a.a a2) {
        ExecutorService executorService = l;
        Object[] arrobject = new Object[]{this.o, n2};
        executorService.submit((Runnable)new c.a.e("OkHttp %s stream %d", arrobject){

            @Override
            public void b() {
                try {
                    d.this.b(n2, a2);
                    return;
                }
                catch (IOException var1_1) {
                    return;
                }
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void a(int var1_1, boolean var2_2, d.c var3_3, long var4_4) throws IOException {
        if (var4_4 != 0) ** GOTO lbl10
        this.i.a(var2_2, var1_1, var3_3, 0);
        return;
        {
            var8_5 = Math.min((int)((int)Math.min((long)var4_4, (long)this.d)), (int)this.i.c());
            this.d -= (long)var8_5;
            // MONITOREXIT : this
            var9_6 = this.i;
            var10_7 = var2_2 != false && (var4_4 -= (long)var8_5) == 0;
            var9_6.a(var10_7, var1_1, var3_3, var8_5);
lbl10: // 2 sources:
            if (var4_4 <= 0) return;
            var11_8 = this;
            // MONITORENTER : var11_8
            do {
                if (this.d > 0) continue block6;
                if (!this.n.containsKey((Object)var1_1)) {
                    throw new IOException("stream closed");
                }
                this.wait();
            } while (true);
        }
        catch (InterruptedException var7_9) {
            throw new InterruptedIOException();
        }
    }

    void a(long l2) {
        this.d = l2 + this.d;
        if (l2 > 0) {
            this.notifyAll();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(c.a.a.a a2) throws IOException {
        c.a.a.c c2;
        c.a.a.c c3 = c2 = this.i;
        synchronized (c3) {
            int n2;
            d d2 = this;
            synchronized (d2) {
                if (this.r) {
                    return;
                }
                this.r = true;
                n2 = this.p;
            }
            this.i.a(n2, a2, i.a);
            return;
        }
    }

    public int b() {
        d d2 = this;
        synchronized (d2) {
            int n2 = this.f.d(Integer.MAX_VALUE);
            return n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    e b(int n2) {
        d d2 = this;
        synchronized (d2) {
            e e2 = (e)this.n.remove((Object)n2);
            if (e2 != null && this.n.isEmpty()) {
                this.a(true);
            }
            this.notifyAll();
            return e2;
        }
    }

    void b(int n2, c.a.a.a a2) throws IOException {
        this.i.a(n2, a2);
    }

    public void c() throws IOException {
        this.i.b();
    }

    public void close() throws IOException {
        this.a(c.a.a.a.a, c.a.a.a.l);
    }

    public void d() throws IOException {
        this.i.a();
        this.i.b(this.e);
        int n2 = this.e.f(65536);
        if (n2 != 65536) {
            this.i.a(0, n2 - 65536);
        }
    }

    public static class a {
        private Socket a;
        private String b;
        private d.e c;
        private d.d d;
        private b e = b.a;
        private x f = x.c;
        private m g = m.a;
        private boolean h;

        public a(boolean bl) throws IOException {
            this.h = bl;
        }

        public a a(b b2) {
            this.e = b2;
            return this;
        }

        public a a(x x2) {
            this.f = x2;
            return this;
        }

        public a a(Socket socket, String string, d.e e2, d.d d2) {
            this.a = socket;
            this.b = string;
            this.c = e2;
            this.d = d2;
            return this;
        }

        public d a() throws IOException {
            return new d(this);
        }
    }

    public static abstract class b {
        public static final b a = new b(){

            @Override
            public void a(e e2) throws IOException {
                e2.a(c.a.a.a.k);
            }
        };

        public void a(d d2) {
        }

        public abstract void a(e var1) throws IOException;

    }

    class c
    extends c.a.e
    implements b.a {
        final c.a.a.b a;

        private c(c.a.a.b b2) {
            Object[] arrobject = new Object[]{d.this.o};
            super("OkHttp %s", arrobject);
            this.a = b2;
        }

        private void a(final n n2) {
            ExecutorService executorService = l;
            Object[] arrobject = new Object[]{d.this.o};
            executorService.execute((Runnable)new c.a.e("OkHttp %s ACK Settings", arrobject){

                @Override
                public void b() {
                    try {
                        d.this.i.a(n2);
                        return;
                    }
                    catch (IOException var1_1) {
                        return;
                    }
                }
            });
        }

        @Override
        public void a() {
        }

        @Override
        public void a(int n2, int n3, int n4, boolean bl) {
        }

        @Override
        public void a(int n2, int n3, List<f> list) {
            d.this.a(n3, list);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, long l2) {
            if (n2 == 0) {
                d d2;
                d d3 = d2 = d.this;
                synchronized (d3) {
                    d d4 = d.this;
                    d4.d = l2 + d4.d;
                    d.this.notifyAll();
                    return;
                }
            }
            e e2 = d.this.a(n2);
            if (e2 != null) {
                e e3 = e2;
                synchronized (e3) {
                    e2.a(l2);
                    return;
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(int n2, c.a.a.a a2) {
            if (d.this.d(n2)) {
                d.this.c(n2, a2);
                return;
            } else {
                e e2 = d.this.b(n2);
                if (e2 == null) return;
                {
                    e2.c(a2);
                    return;
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, c.a.a.a a2, d.f f2) {
            e[] arre;
            d d2;
            if (f2.f() > 0) {
                // empty if block
            }
            d d3 = d2 = d.this;
            synchronized (d3) {
                arre = (e[])d.this.n.values().toArray((Object[])new e[d.this.n.size()]);
                d.this.r = true;
            }
            int n3 = arre.length;
            int n4 = 0;
            while (n4 < n3) {
                e e2 = arre[n4];
                if (e2.a() > n2 && e2.c()) {
                    e2.c(c.a.a.a.k);
                    d.this.b(e2.a());
                }
                ++n4;
            }
        }

        @Override
        public void a(boolean bl, int n2, int n3) {
            if (bl) {
                l l2 = d.this.c(n2);
                if (l2 != null) {
                    l2.b();
                }
                return;
            }
            d.this.a(true, n2, n3, null);
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(boolean bl, int n2, d.e e2, int n3) throws IOException {
            if (d.this.d(n2)) {
                d.this.a(n2, e2, n3, bl);
                return;
            } else {
                e e3 = d.this.a(n2);
                if (e3 == null) {
                    d.this.a(n2, c.a.a.a.c);
                    e2.g((long)n3);
                    return;
                }
                e3.a(e2, n3);
                if (!bl) return;
                {
                    e3.i();
                    return;
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void a(boolean bl, n n2) {
            e[] arre;
            d d2;
            int n3;
            long l2;
            d d3 = d2 = d.this;
            // MONITORENTER : d3
            int n4 = d.this.f.f(65536);
            if (bl) {
                d.this.f.a();
            }
            d.this.f.a(n2);
            if (d.this.a() == x.d) {
                this.a(n2);
            }
            if ((n3 = d.this.f.f(65536)) != -1 && n3 != n4) {
                long l3 = n3 - n4;
                if (!d.this.x) {
                    d.this.a(l3);
                    d.this.x = true;
                }
                if (!d.this.n.isEmpty()) {
                    e[] arre2 = (e[])d.this.n.values().toArray((Object[])new e[d.this.n.size()]);
                    l2 = l3;
                    arre = arre2;
                } else {
                    l2 = l3;
                    arre = null;
                }
            } else {
                l2 = 0;
                arre = null;
            }
            ExecutorService executorService = l;
            Object[] arrobject = new Object[]{d.this.o};
            executorService.execute((Runnable)new c.a.e("OkHttp %s settings", arrobject){

                @Override
                public void b() {
                    d.this.m.a(d.this);
                }
            });
            // MONITOREXIT : d3
            if (arre == null) return;
            if (l2 == 0) return;
            int n5 = arre.length;
            int n6 = 0;
            while (n6 < n5) {
                e e2;
                e e3 = e2 = arre[n6];
                // MONITORENTER : e3
                e2.a(l2);
                // MONITOREXIT : e3
                ++n6;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void a(boolean bl, boolean bl2, int n2, int n3, List<f> list, g g2) {
            d d2;
            if (d.this.d(n2)) {
                d.this.a(n2, list, bl2);
                return;
            }
            d d3 = d2 = d.this;
            // MONITORENTER : d3
            if (d.this.r) {
                // MONITOREXIT : d3
                return;
            }
            e e2 = d.this.a(n2);
            if (e2 == null) {
                if (g2.a()) {
                    d.this.a(n2, c.a.a.a.c);
                    // MONITOREXIT : d3
                    return;
                }
                if (n2 <= d.this.p) {
                    // MONITOREXIT : d3
                    return;
                }
                if (n2 % 2 == d.this.q % 2) {
                    // MONITOREXIT : d3
                    return;
                }
                final e e3 = new e(n2, d.this, bl, bl2, list);
                d.this.p = n2;
                d.this.n.put((Object)n2, (Object)e3);
                ExecutorService executorService = l;
                Object[] arrobject = new Object[]{d.this.o, n2};
                executorService.execute((Runnable)new c.a.e("OkHttp %s stream %d", arrobject){

                    @Override
                    public void b() {
                        try {
                            d.this.m.a(e3);
                            return;
                        }
                        catch (IOException var1_1) {
                            c.a.c.a.log(Level.INFO, "FramedConnection.Listener failure for " + d.this.o, (Throwable)var1_1);
                            try {
                                e3.a(c.a.a.a.b);
                                return;
                            }
                            catch (IOException var2_2) {
                                return;
                            }
                        }
                    }
                });
                // MONITOREXIT : d3
                return;
            }
            // MONITOREXIT : d3
            if (g2.b()) {
                e2.b(c.a.a.a.b);
                d.this.b(n2);
                return;
            }
            e2.a(list, g2);
            if (!bl2) return;
            e2.i();
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive exception aggregation
         */
        @Override
        protected void b() {
            var1_1 = c.a.a.a.g;
            var2_2 = c.a.a.a.g;
            if (!d.this.b) {
                this.a.a();
            }
            while (this.a.a(this)) {
            }
            var1_1 = c.a.a.a.a;
            var10_3 = c.a.a.a.l;
            try {
                d.a(d.this, var1_1, var10_3);
            }
            catch (IOException var11_12) {
                ** continue;
            }
lbl12: // 2 sources:
            do {
                i.a(this.a);
                return;
                break;
            } while (true);
            catch (IOException var7_4) {
                var4_5 = c.a.a.a.b;
                var8_6 = c.a.a.a.b;
                try {
                    d.a(d.this, var4_5, var8_6);
                }
                catch (IOException var9_11) {
                    ** continue;
                }
lbl22: // 2 sources:
                do {
                    i.a(this.a);
                    return;
                    break;
                } while (true);
                catch (Throwable var3_7) {
                    var4_5 = var1_1;
                    var5_8 = var3_7;
lbl28: // 2 sources:
                    do {
                        try {
                            d.a(d.this, var4_5, var2_2);
                        }
                        catch (IOException var6_10) {
                            ** continue;
                        }
lbl33: // 2 sources:
                        do {
                            i.a(this.a);
                            throw var5_8;
                            break;
                        } while (true);
                        break;
                    } while (true);
                }
                catch (Throwable var5_9) {
                    ** continue;
                }
            }
        }

    }

}

