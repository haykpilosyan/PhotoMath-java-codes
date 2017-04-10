/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Iterable
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.google.a;

import com.google.a.l;
import com.google.a.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class i
extends l
implements Iterable<l> {
    private final List<l> a = new ArrayList();

    @Override
    public Number a() {
        if (this.a.size() == 1) {
            return ((l)this.a.get(0)).a();
        }
        throw new IllegalStateException();
    }

    public void a(l l2) {
        if (l2 == null) {
            l2 = n.a;
        }
        this.a.add((Object)l2);
    }

    @Override
    public String b() {
        if (this.a.size() == 1) {
            return ((l)this.a.get(0)).b();
        }
        throw new IllegalStateException();
    }

    @Override
    public double c() {
        if (this.a.size() == 1) {
            return ((l)this.a.get(0)).c();
        }
        throw new IllegalStateException();
    }

    @Override
    public long d() {
        if (this.a.size() == 1) {
            return ((l)this.a.get(0)).d();
        }
        throw new IllegalStateException();
    }

    @Override
    public int e() {
        if (this.a.size() == 1) {
            return ((l)this.a.get(0)).e();
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object object) {
        if (object == this || object instanceof i && ((i)object).a.equals(this.a)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean f() {
        if (this.a.size() == 1) {
            return ((l)this.a.get(0)).f();
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public Iterator<l> iterator() {
        return this.a.iterator();
    }
}

