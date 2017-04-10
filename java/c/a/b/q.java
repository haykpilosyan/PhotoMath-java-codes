/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.ProtocolException
 */
package c.a.b;

import c.x;
import java.io.IOException;
import java.net.ProtocolException;

public final class q {
    public final x a;
    public final int b;
    public final String c;

    public q(x x2, int n2, String string) {
        this.a = x2;
        this.b = n2;
        this.c = string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static q a(String string) throws IOException {
        int n2;
        x x2;
        String string2;
        int n3 = 9;
        if (string.startsWith("HTTP/1.")) {
            if (string.length() < n3) throw new ProtocolException("Unexpected status line: " + string);
            if (string.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + string);
            }
            int n4 = -48 + string.charAt(7);
            if (n4 == 0) {
                x2 = x.a;
            } else {
                if (n4 != 1) throw new ProtocolException("Unexpected status line: " + string);
                x2 = x.b;
            }
        } else {
            if (!string.startsWith("ICY ")) throw new ProtocolException("Unexpected status line: " + string);
            x2 = x.a;
            n3 = 4;
        }
        if (string.length() < n3 + 3) {
            throw new ProtocolException("Unexpected status line: " + string);
        }
        int n5 = n3 + 3;
        try {
            n2 = Integer.parseInt((String)string.substring(n3, n5));
        }
        catch (NumberFormatException var4_6) {
            throw new ProtocolException("Unexpected status line: " + string);
        }
        if (string.length() <= n3 + 3) {
            string2 = "";
            return new q(x2, n2, string2);
        }
        if (string.charAt(n3 + 3) != ' ') {
            throw new ProtocolException("Unexpected status line: " + string);
        }
        string2 = string.substring(n3 + 4);
        return new q(x2, n2, string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = this.a == x.a ? "HTTP/1.0" : "HTTP/1.1";
        stringBuilder.append(string);
        stringBuilder.append(' ').append(this.b);
        if (this.c != null) {
            stringBuilder.append(' ').append(this.c);
        }
        return stringBuilder.toString();
    }
}

