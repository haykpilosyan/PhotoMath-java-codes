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

public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a(0, -1, 0);
    public static final /* enum */ a b = new a(1, 1, 1);
    public static final /* enum */ a c = new a(1, 2, -1);
    public static final /* enum */ a d = new a(1, 4, -1);
    public static final /* enum */ a e = new a(1, 8, -1);
    public static final /* enum */ a f = new a(1, 9, -1);
    public static final /* enum */ a g = new a(2, 6, 2);
    public static final /* enum */ a h = new a(3, 7, -1);
    public static final /* enum */ a i = new a(5, -1, -1);
    public static final /* enum */ a j = new a(6, 11, -1);
    public static final /* enum */ a k = new a(7, 3, -1);
    public static final /* enum */ a l = new a(8, 5, -1);
    public static final /* enum */ a m = new a(9, -1, -1);
    public static final /* enum */ a n = new a(10, -1, -1);
    public static final /* enum */ a o = new a(11, -1, -1);
    public static final /* enum */ a p = new a(12, -1, -1);
    public static final /* enum */ a q = new a(13, -1, -1);
    public static final /* enum */ a r = new a(-1, 10, -1);
    private static final /* synthetic */ a[] v;
    public final int s;
    public final int t;
    public final int u;

    static {
        a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r};
        v = arra;
    }

    private a(int n3, int n4, int n5) {
        super(string, n2);
        this.s = n3;
        this.t = n4;
        this.u = n5;
    }

    public static a a(int n2) {
        for (a a2 : a.values()) {
            if (a2.t != n2) continue;
            return a2;
        }
        return null;
    }

    public static a b(int n2) {
        for (a a2 : a.values()) {
            if (a2.s != n2) continue;
            return a2;
        }
        return null;
    }

    public static a c(int n2) {
        for (a a2 : a.values()) {
            if (a2.u != n2) continue;
            return a2;
        }
        return null;
    }

    public static a valueOf(String string) {
        return (a)Enum.valueOf((Class)a.class, (String)string);
    }

    public static a[] values() {
        return (a[])v.clone();
    }
}

