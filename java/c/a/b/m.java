/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.Proxy
 *  java.net.Proxy$Type
 */
package c.a.b;

import c.s;
import c.z;
import java.net.Proxy;

public final class m {
    public static String a(s s2) {
        String string = s2.h();
        String string2 = s2.k();
        if (string2 != null) {
            string = string + '?' + string2;
        }
        return string;
    }

    /*
     * Enabled aggressive block sorting
     */
    static String a(z z2, Proxy.Type type) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z2.b());
        stringBuilder.append(' ');
        if (m.b(z2, type)) {
            stringBuilder.append((Object)z2.a());
        } else {
            stringBuilder.append(m.a(z2.a()));
        }
        stringBuilder.append(" HTTP/1.1");
        return stringBuilder.toString();
    }

    private static boolean b(z z2, Proxy.Type type) {
        if (!z2.g() && type == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }
}

