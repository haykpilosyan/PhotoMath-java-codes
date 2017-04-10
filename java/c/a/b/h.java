/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.b;

public final class h {
    public static boolean a(String string) {
        if (string.equals((Object)"POST") || string.equals((Object)"PATCH") || string.equals((Object)"PUT") || string.equals((Object)"DELETE") || string.equals((Object)"MOVE")) {
            return true;
        }
        return false;
    }

    public static boolean b(String string) {
        if (string.equals((Object)"POST") || string.equals((Object)"PUT") || string.equals((Object)"PATCH") || string.equals((Object)"PROPPATCH") || string.equals((Object)"REPORT")) {
            return true;
        }
        return false;
    }

    public static boolean c(String string) {
        if (h.b(string) || string.equals((Object)"OPTIONS") || string.equals((Object)"DELETE") || string.equals((Object)"PROPFIND") || string.equals((Object)"MKCOL") || string.equals((Object)"LOCK")) {
            return true;
        }
        return false;
    }

    public static boolean d(String string) {
        if (!string.equals((Object)"PROPFIND")) {
            return true;
        }
        return false;
    }
}

