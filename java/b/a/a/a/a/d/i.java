/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package b.a.a.a.a.d;

import android.content.Context;
import b.a.a.a.a.d.e;

public class i
implements Runnable {
    private final Context a;
    private final e b;

    public i(Context context, e e2) {
        this.a = context;
        this.b = e2;
    }

    public void run() {
        try {
            b.a.a.a.a.b.i.a(this.a, "Performing time based file roll over.");
            if (!this.b.c()) {
                this.b.d();
            }
            return;
        }
        catch (Exception var1_1) {
            b.a.a.a.a.b.i.a(this.a, "Failed to roll over file", (Throwable)var1_1);
            return;
        }
    }
}

