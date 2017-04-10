/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package a.a.a.a.a;

import a.a.a.a.b;
import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class c
extends Thread {
    private final a.a.a.a.a.b a;
    private final AtomicBoolean b;
    private final Object c;
    private b d;

    public c(a.a.a.a.a.b b2, String string) {
        super(string);
        this.a = b2;
        this.c = new Object();
        this.b = new AtomicBoolean(true);
    }

    public void a() {
        this.b.set(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(b b2) {
        Object object;
        Object object2 = object = this.c;
        synchronized (object2) {
            if (this.d != null) {
                return false;
            }
            this.d = b2;
            this.c.notify();
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Process.setThreadPriority((int)10);
        while (this.b.get()) {
            Object object;
            Object object2 = object = this.c;
            synchronized (object2) {
                b b2;
                while ((b2 = this.d) == null) {
                    try {
                        this.c.wait();
                    }
                    catch (InterruptedException var12_5) {
                        var12_5.printStackTrace();
                    }
                }
            }
            try {
                this.d.e.c(this.d);
                continue;
            }
            catch (Exception var8_8) {
                throw new RuntimeException((Throwable)var8_8);
            }
            finally {
                Object object3;
                b b3 = this.d;
                Object object4 = object3 = this.c;
                synchronized (object4) {
                    this.d = null;
                }
                this.a.b(b3);
                continue;
            }
            break;
        }
        return;
    }
}

