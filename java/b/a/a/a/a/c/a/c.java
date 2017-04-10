/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Math
 *  java.lang.Object
 */
package b.a.a.a.a.c.a;

import b.a.a.a.a.c.a.a;

public class c
implements a {
    private final long a;
    private final int b;

    public c(long l2, int n2) {
        this.a = l2;
        this.b = n2;
    }

    @Override
    public long a(int n2) {
        return (long)((double)this.a * Math.pow((double)this.b, (double)n2));
    }
}

