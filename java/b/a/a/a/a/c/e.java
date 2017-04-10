/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a.c;

import b.a.a.a.a.c.i;

public final class e
extends Enum<e> {
    public static final /* enum */ e a = new e();
    public static final /* enum */ e b = new e();
    public static final /* enum */ e c = new e();
    public static final /* enum */ e d = new e();
    private static final /* synthetic */ e[] e;

    static {
        e[] arre = new e[]{a, b, c, d};
        e = arre;
    }

    private e() {
        super(string, n2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static <Y> int a(i i2, Y y2) {
        e e2;
        if (y2 instanceof i) {
            e2 = ((i)y2).b();
            do {
                return e2.ordinal() - i2.b().ordinal();
                break;
            } while (true);
        }
        e2 = b;
        return e2.ordinal() - i2.b().ordinal();
    }

    public static e valueOf(String string) {
        return (e)Enum.valueOf((Class)e.class, (String)string);
    }

    public static e[] values() {
        return (e[])e.clone();
    }
}

