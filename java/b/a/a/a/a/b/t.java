/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a.b;

import android.os.SystemClock;
import android.util.Log;

public class t {
    private final String a;
    private final String b;
    private final boolean c;
    private long d;
    private long e;

    /*
     * Enabled aggressive block sorting
     */
    public t(String string, String string2) {
        this.a = string;
        this.b = string2;
        boolean bl = !Log.isLoggable((String)string2, (int)2);
        this.c = bl;
    }

    private void c() {
        Log.v((String)this.b, (String)(this.a + ": " + this.e + "ms"));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        t t2 = this;
        synchronized (t2) {
            boolean bl = this.c;
            if (!bl) {
                this.d = SystemClock.elapsedRealtime();
                this.e = 0;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        t t2 = this;
        synchronized (t2) {
            boolean bl = this.c;
            if (!bl && this.e == 0) {
                this.e = SystemClock.elapsedRealtime() - this.d;
                this.c();
            }
            return;
        }
    }
}

