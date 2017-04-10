/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package a.a.a.a;

import a.a.a.a.b;

public class c {
    protected b a;
    protected b b;

    public b a() {
        if (this.a == null) {
            return null;
        }
        b b2 = this.a;
        this.a = this.a.a;
        if (this.a == null) {
            this.b = null;
        }
        return b2;
    }

    public void a(b b2) {
        if (this.b == null) {
            this.a = b2;
            this.b = b2;
            return;
        }
        this.b.a = b2;
        this.b = b2;
    }

    public void b(b b2) {
        if (this.a == null) {
            this.b = b2;
            this.a = b2;
            return;
        }
        b2.a = this.a;
        this.a = b2;
    }

    public boolean b() {
        if (this.a == null) {
            return true;
        }
        return false;
    }
}

