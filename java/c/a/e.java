/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package c.a;

public abstract class e
implements Runnable {
    protected final String b;

    public /* varargs */ e(String string, Object ... arrobject) {
        this.b = String.format((String)string, (Object[])arrobject);
    }

    protected abstract void b();

    public final void run() {
        String string = Thread.currentThread().getName();
        Thread.currentThread().setName(this.b);
        try {
            this.b();
            return;
        }
        finally {
            Thread.currentThread().setName(string);
        }
    }
}

