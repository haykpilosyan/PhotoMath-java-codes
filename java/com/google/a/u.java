/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.google.a;

public abstract class u
extends Enum<u> {
    public static final /* enum */ u a = new u("DEFAULT", 0){};
    public static final /* enum */ u b = new u("STRING", 1){};
    private static final /* synthetic */ u[] c;

    static {
        u[] arru = new u[]{a, b};
        c = arru;
    }

    private u() {
        super(string, n2);
    }

    public static u valueOf(String string) {
        return (u)Enum.valueOf((Class)u.class, (String)string);
    }

    public static u[] values() {
        return (u[])c.clone();
    }

}

