/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a.b;

class b {
    public final String a;
    public final boolean b;

    b(String string, boolean bl) {
        this.a = string;
        this.b = bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        b b2 = (b)object;
        if (this.b != b2.b) {
            return false;
        }
        if (this.a != null) {
            if (this.a.equals((Object)b2.a)) return true;
            return false;
        }
        if (b2.a == null) return true;
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = this.a != null ? this.a.hashCode() : 0;
        int n3 = n2 * 31;
        boolean bl = this.b;
        int n4 = 0;
        if (bl) {
            n4 = 1;
        }
        return n3 + n4;
    }
}

