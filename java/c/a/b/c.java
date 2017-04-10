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

public final class c {
    public static int a(String string, int n2) {
        char c2;
        while (n2 < string.length() && ((c2 = string.charAt(n2)) == ' ' || c2 == '\t')) {
            ++n2;
        }
        return n2;
    }

    public static int a(String string, int n2, String string2) {
        while (n2 < string.length() && string2.indexOf((int)string.charAt(n2)) == -1) {
            ++n2;
        }
        return n2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int b(String string, int n2) {
        try {
            long l2 = Long.parseLong((String)string);
            if (l2 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (l2 >= 0) return (int)l2;
            return 0;
        }
        catch (NumberFormatException var2_3) {
            return n2;
        }
    }
}

