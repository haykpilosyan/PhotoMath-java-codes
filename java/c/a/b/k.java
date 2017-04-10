/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.e
 *  java.lang.String
 */
package c.a.b;

import c.a.b.j;
import c.ac;
import c.r;
import c.u;
import d.e;

public final class k
extends ac {
    private final r a;
    private final e b;

    public k(r r2, e e2) {
        this.a = r2;
        this.b = e2;
    }

    @Override
    public long contentLength() {
        return j.a(this.a);
    }

    @Override
    public u contentType() {
        String string = this.a.a("Content-Type");
        if (string != null) {
            return u.a(string);
        }
        return null;
    }

    @Override
    public e source() {
        return this.b;
    }
}

