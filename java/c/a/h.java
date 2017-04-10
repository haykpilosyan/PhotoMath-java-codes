/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.LinkedHashSet
 *  java.util.Set
 */
package c.a;

import c.ad;
import java.util.LinkedHashSet;
import java.util.Set;

public final class h {
    private final Set<ad> a = new LinkedHashSet();

    public void a(ad ad2) {
        h h2 = this;
        synchronized (h2) {
            this.a.add((Object)ad2);
            return;
        }
    }

    public void b(ad ad2) {
        h h2 = this;
        synchronized (h2) {
            this.a.remove((Object)ad2);
            return;
        }
    }

    public boolean c(ad ad2) {
        h h2 = this;
        synchronized (h2) {
            boolean bl = this.a.contains((Object)ad2);
            return bl;
        }
    }
}

