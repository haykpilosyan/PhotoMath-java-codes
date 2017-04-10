/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package c;

import java.io.IOException;

public final class x
extends Enum<x> {
    public static final /* enum */ x a = new x("http/1.0");
    public static final /* enum */ x b = new x("http/1.1");
    public static final /* enum */ x c = new x("spdy/3.1");
    public static final /* enum */ x d = new x("h2");
    private static final /* synthetic */ x[] f;
    private final String e;

    static {
        x[] arrx = new x[]{a, b, c, d};
        f = arrx;
    }

    private x(String string2) {
        super(string, n2);
        this.e = string2;
    }

    public static x a(String string) throws IOException {
        if (string.equals((Object)x.a.e)) {
            return a;
        }
        if (string.equals((Object)x.b.e)) {
            return b;
        }
        if (string.equals((Object)x.d.e)) {
            return d;
        }
        if (string.equals((Object)x.c.e)) {
            return c;
        }
        throw new IOException("Unexpected protocol: " + string);
    }

    public static x valueOf(String string) {
        return (x)Enum.valueOf((Class)x.class, (String)string);
    }

    public static x[] values() {
        return (x[])f.clone();
    }

    public String toString() {
        return this.e;
    }
}

