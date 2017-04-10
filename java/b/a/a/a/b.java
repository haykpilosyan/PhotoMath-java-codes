/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package b.a.a.a;

import android.util.Log;
import b.a.a.a.l;

public class b
implements l {
    private int a;

    public b() {
        this.a = 4;
    }

    public b(int n2) {
        this.a = n2;
    }

    @Override
    public void a(int n2, String string, String string2) {
        this.a(n2, string, string2, false);
    }

    @Override
    public void a(int n2, String string, String string2, boolean bl) {
        if (bl || this.a(string, n2)) {
            Log.println((int)n2, (String)string, (String)string2);
        }
    }

    @Override
    public void a(String string, String string2) {
        this.a(string, string2, null);
    }

    @Override
    public void a(String string, String string2, Throwable throwable) {
        if (this.a(string, 3)) {
            Log.d((String)string, (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public boolean a(String string, int n2) {
        if (this.a <= n2) {
            return true;
        }
        return false;
    }

    @Override
    public void b(String string, String string2) {
        this.b(string, string2, null);
    }

    public void b(String string, String string2, Throwable throwable) {
        if (this.a(string, 2)) {
            Log.v((String)string, (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public void c(String string, String string2) {
        this.c(string, string2, null);
    }

    public void c(String string, String string2, Throwable throwable) {
        if (this.a(string, 4)) {
            Log.i((String)string, (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public void d(String string, String string2) {
        this.d(string, string2, null);
    }

    @Override
    public void d(String string, String string2, Throwable throwable) {
        if (this.a(string, 5)) {
            Log.w((String)string, (String)string2, (Throwable)throwable);
        }
    }

    @Override
    public void e(String string, String string2) {
        this.e(string, string2, null);
    }

    @Override
    public void e(String string, String string2, Throwable throwable) {
        if (this.a(string, 6)) {
            Log.e((String)string, (String)string2, (Throwable)throwable);
        }
    }
}

