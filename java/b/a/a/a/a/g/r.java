/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a.g;

public final class r
extends Enum<r> {
    public static final /* enum */ r a = new r();
    public static final /* enum */ r b = new r();
    public static final /* enum */ r c = new r();
    private static final /* synthetic */ r[] d;

    static {
        r[] arrr = new r[]{a, b, c};
        d = arrr;
    }

    private r() {
        super(string, n2);
    }

    public static r valueOf(String string) {
        return (r)Enum.valueOf((Class)r.class, (String)string);
    }

    public static r[] values() {
        return (r[])d.clone();
    }
}

