/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Field
 *  java.util.Locale
 */
package com.google.a;

import com.google.a.e;
import java.lang.reflect.Field;
import java.util.Locale;

public abstract class d
extends Enum<d>
implements e {
    public static final /* enum */ d a = new d("IDENTITY", 0){

        @Override
        public String a(Field field) {
            return field.getName();
        }
    };
    public static final /* enum */ d b = new d("UPPER_CAMEL_CASE", 1){

        @Override
        public String a(Field field) {
            return .a(field.getName());
        }
    };
    public static final /* enum */ d c = new d("UPPER_CAMEL_CASE_WITH_SPACES", 2){

        @Override
        public String a(Field field) {
            return .a(.a(field.getName(), " "));
        }
    };
    public static final /* enum */ d d = new d("LOWER_CASE_WITH_UNDERSCORES", 3){

        @Override
        public String a(Field field) {
            return .a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    };
    public static final /* enum */ d e = new d("LOWER_CASE_WITH_DASHES", 4){

        @Override
        public String a(Field field) {
            return .a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };
    private static final /* synthetic */ d[] f;

    static {
        d[] arrd = new d[]{a, b, c, d, e};
        f = arrd;
    }

    private d() {
        super(string, n2);
    }

    private static String a(char c2, String string, int n2) {
        if (n2 < string.length()) {
            return "" + c2 + string.substring(n2);
        }
        return String.valueOf((char)c2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static String a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        char c2 = string.charAt(0);
        do {
            if (n2 >= -1 + string.length() || Character.isLetter((char)c2)) {
                if (n2 != string.length()) break;
                return stringBuilder.toString();
            }
            stringBuilder.append(c2);
            c2 = string.charAt(++n2);
        } while (true);
        if (Character.isUpperCase((char)c2)) return string;
        return stringBuilder.append(d.a(Character.toUpperCase((char)c2), string, n2 + 1)).toString();
    }

    static String a(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < string.length(); ++i2) {
            char c2 = string.charAt(i2);
            if (Character.isUpperCase((char)c2) && stringBuilder.length() != 0) {
                stringBuilder.append(string2);
            }
            stringBuilder.append(c2);
        }
        return stringBuilder.toString();
    }

    public static d valueOf(String string) {
        return (d)Enum.valueOf((Class)d.class, (String)string);
    }

    public static d[] values() {
        return (d[])f.clone();
    }

}

