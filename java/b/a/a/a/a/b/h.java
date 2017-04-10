/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Process
 *  java.lang.Object
 *  java.lang.Runnable
 */
package b.a.a.a.a.b;

import android.os.Process;

public abstract class h
implements Runnable {
    protected abstract void a();

    public final void run() {
        Process.setThreadPriority((int)10);
        this.a();
    }
}

