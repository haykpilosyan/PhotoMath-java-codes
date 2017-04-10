/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.f
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.a;

public final class f {
    public static final d.f a = d.f.a((String)":status");
    public static final d.f b = d.f.a((String)":method");
    public static final d.f c = d.f.a((String)":path");
    public static final d.f d = d.f.a((String)":scheme");
    public static final d.f e = d.f.a((String)":authority");
    public static final d.f f = d.f.a((String)":host");
    public static final d.f g = d.f.a((String)":version");
    public final d.f h;
    public final d.f i;
    final int j;

    public f(d.f f2, d.f f3) {
        this.h = f2;
        this.i = f3;
        this.j = 32 + f2.f() + f3.f();
    }

    public f(d.f f2, String string) {
        this(f2, d.f.a((String)string));
    }

    public f(String string, String string2) {
        this(d.f.a((String)string), d.f.a((String)string2));
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof f;
        boolean bl2 = false;
        if (bl) {
            f f2 = (f)object;
            boolean bl3 = this.h.equals((Object)f2.h);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.i.equals((Object)f2.i);
                bl2 = false;
                if (bl4) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return 31 * (527 + this.h.hashCode()) + this.i.hashCode();
    }

    public String toString() {
        Object[] arrobject = new Object[]{this.h.a(), this.i.a()};
        return String.format((String)"%s: %s", (Object[])arrobject);
    }
}

