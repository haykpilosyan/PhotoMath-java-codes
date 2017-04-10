/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Byte
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.Short
 *  java.lang.String
 *  java.math.BigInteger
 */
package com.google.a;

import com.google.a.b.a;
import com.google.a.b.f;
import com.google.a.l;
import java.math.BigInteger;

public final class q
extends l {
    private static final Class<?>[] a;
    private Object b;

    static {
        Class[] arrclass = new Class[]{Integer.TYPE, Long.TYPE, Short.TYPE, Float.TYPE, Double.TYPE, Byte.TYPE, Boolean.TYPE, Character.TYPE, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class};
        a = arrclass;
    }

    public q(Boolean bl) {
        this.a((Object)bl);
    }

    public q(Number number) {
        this.a((Object)number);
    }

    public q(String string) {
        this.a(string);
    }

    private static boolean a(q q2) {
        if (q2.b instanceof Number) {
            Number number = (Number)q2.b;
            if (number instanceof BigInteger || number instanceof Long || number instanceof Integer || number instanceof Short || number instanceof Byte) {
                return true;
            }
            return false;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static boolean b(Object object) {
        if (object instanceof String) {
            return true;
        }
        Class class_ = object.getClass();
        Class<?>[] arrclass = a;
        int n2 = arrclass.length;
        int n3 = 0;
        while (n3 < n2) {
            if (arrclass[n3].isAssignableFrom(class_)) return true;
            ++n3;
        }
        return false;
    }

    @Override
    public Number a() {
        if (this.b instanceof String) {
            return new f((String)this.b);
        }
        return (Number)this.b;
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(Object object) {
        if (object instanceof Character) {
            this.b = String.valueOf((char)((Character)object).charValue());
            return;
        }
        boolean bl = object instanceof Number || q.b(object);
        a.a(bl);
        this.b = object;
    }

    @Override
    public String b() {
        if (this.p()) {
            return this.a().toString();
        }
        if (this.o()) {
            return this.n().toString();
        }
        return (String)this.b;
    }

    @Override
    public double c() {
        if (this.p()) {
            return this.a().doubleValue();
        }
        return Double.parseDouble((String)this.b());
    }

    @Override
    public long d() {
        if (this.p()) {
            return this.a().longValue();
        }
        return Long.parseLong((String)this.b());
    }

    @Override
    public int e() {
        if (this.p()) {
            return this.a().intValue();
        }
        return Integer.parseInt((String)this.b());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        double d2;
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        q q2 = (q)object;
        if (this.b == null) {
            if (q2.b == null) return true;
            return false;
        }
        if (q.a(this) && q.a(q2)) {
            if (this.a().longValue() == q2.a().longValue()) return true;
            return false;
        }
        if (!(this.b instanceof Number)) return this.b.equals(q2.b);
        if (!(q2.b instanceof Number)) return this.b.equals(q2.b);
        double d3 = this.a().doubleValue();
        if (d3 == (d2 = q2.a().doubleValue())) return true;
        boolean bl = Double.isNaN((double)d3);
        boolean bl2 = false;
        if (!bl) return bl2;
        boolean bl3 = Double.isNaN((double)d2);
        bl2 = false;
        if (!bl3) return bl2;
        return true;
    }

    @Override
    public boolean f() {
        if (this.o()) {
            return this.n();
        }
        return Boolean.parseBoolean((String)this.b());
    }

    public int hashCode() {
        if (this.b == null) {
            return 31;
        }
        if (q.a(this)) {
            long l2 = this.a().longValue();
            return (int)(l2 ^ l2 >>> 32);
        }
        if (this.b instanceof Number) {
            long l3 = Double.doubleToLongBits((double)this.a().doubleValue());
            return (int)(l3 ^ l3 >>> 32);
        }
        return this.b.hashCode();
    }

    @Override
    Boolean n() {
        return (Boolean)this.b;
    }

    public boolean o() {
        return this.b instanceof Boolean;
    }

    public boolean p() {
        return this.b instanceof Number;
    }

    public boolean q() {
        return this.b instanceof String;
    }
}

