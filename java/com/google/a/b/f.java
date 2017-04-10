/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigDecimal
 */
package com.google.a.b;

import java.math.BigDecimal;

public final class f
extends Number {
    private final String a;

    public f(String string) {
        this.a = string;
    }

    public double doubleValue() {
        return Double.parseDouble((String)this.a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        boolean bl = object instanceof f;
        boolean bl2 = false;
        if (!bl) return bl2;
        f f2 = (f)((Object)object);
        if (this.a == f2.a) return true;
        boolean bl3 = this.a.equals((Object)f2.a);
        bl2 = false;
        if (!bl3) return bl2;
        return true;
    }

    public float floatValue() {
        return Float.parseFloat((String)this.a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public int intValue() {
        try {
            int n2 = Integer.parseInt((String)this.a);
            return n2;
        }
        catch (NumberFormatException var1_2) {
            long l2;
            try {
                l2 = Long.parseLong((String)this.a);
            }
            catch (NumberFormatException var2_4) {
                return new BigDecimal(this.a).intValue();
            }
            return (int)l2;
        }
    }

    public long longValue() {
        try {
            long l2 = Long.parseLong((String)this.a);
            return l2;
        }
        catch (NumberFormatException var1_2) {
            return new BigDecimal(this.a).longValue();
        }
    }

    public String toString() {
        return this.a;
    }
}

