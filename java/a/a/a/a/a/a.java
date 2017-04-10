/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.ref.WeakReference
 *  java.util.ArrayList
 *  java.util.HashMap
 */
package a.a.a.a.a;

import a.a.a.a.a;
import a.a.a.a.c;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public class a {
    private final a.a.a.a.a.b a;
    private final a b;
    private final HashMap<String, b> c;
    private final ArrayList<b> d;

    public a() {
        HandlerThread handlerThread = new HandlerThread("tinybus-dispatcher");
        handlerThread.start();
        this.a = new a.a.a.a.a.b(this, 3);
        this.c = new HashMap(4);
        this.d = new ArrayList(4);
        this.b = new a(handlerThread.getLooper(), this);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c() {
        this.a();
        for (b b2 : this.d) {
            if (b2.c() || b2.b()) continue;
            if (b2 == null) {
                return;
            }
            a.a.a.a.b b3 = b2.a();
            if (this.a.a(b3)) {
                b2.a(true);
                return;
            }
            b2.b(b3);
            return;
        }
    }

    void a() {
        if (Thread.currentThread() != this.b.getLooper().getThread()) {
            throw new IllegalStateException("method accessed from wrong thread");
        }
    }

    public void a(a.a.a.a.b b2) {
        this.b.a(b2);
    }

    void b() {
        this.a.a();
    }

    void b(a.a.a.a.b b2) {
        this.b.b(b2);
    }

    void c(a.a.a.a.b b2) {
        this.a();
        b b3 = (b)this.c.get((Object)b2.f.c);
        if (b3 == null) {
            b3 = new b(b2.f.c);
            this.c.put((Object)b2.f.c, (Object)b3);
            this.d.add((Object)b3);
        }
        b3.a(b2);
        this.c();
    }

    void d(a.a.a.a.b b2) {
        this.a();
        ((b)this.c.get((Object)b2.f.c)).a(false);
        b2.a();
        this.c();
    }

    static class a
    extends Handler {
        private final WeakReference<a> a;

        public a(Looper looper, a a2) {
            super(looper);
            this.a = new WeakReference((Object)a2);
        }

        void a(a.a.a.a.b b2) {
            this.obtainMessage(1, (Object)b2).sendToTarget();
        }

        void b(a.a.a.a.b b2) {
            this.obtainMessage(2, (Object)b2).sendToTarget();
        }

        public void handleMessage(Message message) {
            a a2 = (a)this.a.get();
            if (a2 == null) {
                message.what = 100;
            }
            switch (message.what) {
                default: {
                    return;
                }
                case 1: {
                    a2.c((a.a.a.a.b)message.obj);
                    return;
                }
                case 2: {
                    a2.d((a.a.a.a.b)message.obj);
                    return;
                }
                case 100: 
            }
            a2.b();
            this.getLooper().quit();
        }
    }

    static class b
    extends c {
        private final String c;
        private boolean d;
        private int e;

        public b(String string) {
            this.c = string;
        }

        @Override
        public a.a.a.a.b a() {
            this.e = -1 + this.e;
            return super.a();
        }

        @Override
        public void a(a.a.a.a.b b2) {
            super.a(b2);
            this.e = 1 + this.e;
        }

        public void a(boolean bl) {
            this.d = bl;
        }

        @Override
        public void b(a.a.a.a.b b2) {
            super.b(b2);
            this.e = 1 + this.e;
        }

        public boolean c() {
            return this.d;
        }
    }

}

