/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package c.a.b;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class o
extends Exception {
    private static final Method a;
    private IOException b;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Method method;
        try {
            Method method2;
            method = method2 = Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class});
        }
        catch (Exception var0_2) {
            method = null;
        }
        a = method;
    }

    public o(IOException iOException) {
        super((Throwable)iOException);
        this.b = iOException;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(IOException iOException, IOException iOException2) {
        if (a == null) return;
        try {
            a.invoke((Object)iOException, new Object[]{iOException2});
            return;
        }
        catch (IllegalAccessException var4_3) {
            return;
        }
        catch (InvocationTargetException var3_4) {
            return;
        }
    }

    public IOException a() {
        return this.b;
    }

    public void a(IOException iOException) {
        this.a(iOException, this.b);
        this.b = iOException;
    }
}

