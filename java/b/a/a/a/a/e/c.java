/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a.e;

public final class c
extends Enum<c> {
    public static final /* enum */ c a = new c();
    public static final /* enum */ c b = new c();
    public static final /* enum */ c c = new c();
    public static final /* enum */ c d = new c();
    private static final /* synthetic */ c[] e;

    static {
        c[] arrc = new c[]{a, b, c, d};
        e = arrc;
    }

    private c() {
        super(string, n2);
    }

    public static c valueOf(String string) {
        return (c)Enum.valueOf((Class)c.class, (String)string);
    }

    public static c[] values() {
        return (c[])e.clone();
    }
}

