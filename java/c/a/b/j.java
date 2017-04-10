/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.b;

import c.a.g;
import c.ab;
import c.r;
import c.z;

public final class j {
    static final String a = g.a().b();
    public static final String b = a + "-Sent-Millis";
    public static final String c = a + "-Received-Millis";
    public static final String d = a + "-Selected-Protocol";
    public static final String e = a + "-Response-Source";

    public static long a(ab ab2) {
        return j.a(ab2.f());
    }

    public static long a(r r2) {
        return j.b(r2.a("Content-Length"));
    }

    public static long a(z z2) {
        return j.a(z2.c());
    }

    static boolean a(String string) {
        if (!("Connection".equalsIgnoreCase(string) || "Keep-Alive".equalsIgnoreCase(string) || "Proxy-Authenticate".equalsIgnoreCase(string) || "Proxy-Authorization".equalsIgnoreCase(string) || "TE".equalsIgnoreCase(string) || "Trailers".equalsIgnoreCase(string) || "Transfer-Encoding".equalsIgnoreCase(string) || "Upgrade".equalsIgnoreCase(string))) {
            return true;
        }
        return false;
    }

    private static long b(String string) {
        if (string == null) {
            return -1;
        }
        try {
            long l2 = Long.parseLong((String)string);
            return l2;
        }
        catch (NumberFormatException var1_2) {
            return -1;
        }
    }
}

