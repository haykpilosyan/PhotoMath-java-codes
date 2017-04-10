/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.google.a;

import com.google.a.b.g;
import com.google.a.l;
import com.google.a.n;
import java.util.Map;
import java.util.Set;

public final class o
extends l {
    private final g<String, l> a = new g();

    public void a(String string, l l2) {
        if (l2 == null) {
            l2 = n.a;
        }
        this.a.put(string, l2);
    }

    public boolean equals(Object object) {
        if (object == this || object instanceof o && ((o)object).a.equals(this.a)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Set<Map.Entry<String, l>> o() {
        return this.a.entrySet();
    }
}

