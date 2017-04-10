/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package a.a.a.a;

import a.a.a.a.a;
import a.a.a.d;
import java.lang.ref.WeakReference;

public class b
implements Runnable {
    private static final b h = new b(32);
    public b a;
    public d b;
    public int c;
    public Object d;
    public a e;
    public a.b f;
    public WeakReference<Object> g;

    private b() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b a(d d2, int n2, Object object) {
        b b2;
        b b3;
        b b4 = b3 = h;
        synchronized (b4) {
            b2 = h.a();
        }
        b2.b = d2;
        b2.c = n2;
        b2.d = object;
        b2.a = null;
        return b2;
    }

    public b a(a a2) {
        this.e = a2;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        b b2;
        this.b = null;
        this.d = null;
        this.e = null;
        b b3 = b2 = h;
        synchronized (b3) {
            h.a(this);
            return;
        }
    }

    public void run() {
        switch (this.c) {
            default: {
                throw new IllegalStateException(String.valueOf((int)this.c));
            }
            case 10: {
                this.e.a(this);
                return;
            }
            case 3: 
        }
        this.e.b(this);
    }

    public static interface a {
        public void a(b var1);

        public void b(b var1);

        public void c(b var1) throws Exception;
    }

    static class b {
        private final int a;
        private int b;
        private b c;

        public b(int n2) {
            this.a = n2;
        }

        b a() {
            b b2 = this.c;
            if (b2 == null) {
                return new b();
            }
            this.c = b2.a;
            this.b = -1 + this.b;
            return b2;
        }

        void a(b b2) {
            if (this.b < this.a) {
                b2.a = this.c;
                this.c = b2;
                this.b = 1 + this.b;
            }
        }
    }

}

