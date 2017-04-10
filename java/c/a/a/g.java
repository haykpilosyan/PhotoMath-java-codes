/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a;

public final class g
extends Enum<g> {
    public static final /* enum */ g a = new g();
    public static final /* enum */ g b = new g();
    public static final /* enum */ g c = new g();
    public static final /* enum */ g d = new g();
    private static final /* synthetic */ g[] e;

    static {
        g[] arrg = new g[]{a, b, c, d};
        e = arrg;
    }

    private g() {
        super(string, n2);
    }

    public static g valueOf(String string) {
        return (g)Enum.valueOf((Class)g.class, (String)string);
    }

    public static g[] values() {
        return (g[])e.clone();
    }

    public boolean a() {
        if (this == b || this == c) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this == a) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this == c) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this == b) {
            return true;
        }
        return false;
    }
}

