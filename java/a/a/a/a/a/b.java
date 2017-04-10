/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package a.a.a.a.a;

import a.a.a.a.a.a;
import a.a.a.a.a.c;

class b {
    private final a a;
    private final c[] b;

    public b(a a2, int n2) {
        this.a = a2;
        this.b = new c[n2];
    }

    public void a() {
        this.a.a();
        for (c c2 : this.b) {
            if (c2 == null) continue;
            c2.a();
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean a(a.a.a.a.b b2) {
        boolean bl = false;
        this.a.a();
        int n2 = this.b.length;
        int n3 = 0;
        while (n3 < n2) {
            c c2 = this.b[n3];
            if (c2 == null) {
                c2 = new c(this, "tinybus-worker-" + n3);
                c2.start();
                this.b[n3] = c2;
            }
            if (bl = c2.a(b2)) {
                return bl;
            }
            ++n3;
        }
        return bl;
    }

    void b(a.a.a.a.b b2) {
        this.a.b(b2);
    }
}

