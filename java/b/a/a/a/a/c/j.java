/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicReference
 */
package b.a.a.a.a.c;

import b.a.a.a.a.c.b;
import b.a.a.a.a.c.e;
import b.a.a.a.a.c.i;
import b.a.a.a.a.c.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class j
implements b<l>,
i,
l {
    private final List<l> a = new ArrayList();
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final AtomicReference<Throwable> c = new AtomicReference((Object)null);

    public static boolean a(Object object) {
        try {
            b b2 = (b)object;
            l l2 = (l)object;
            i i2 = (i)object;
            if (b2 != null && l2 != null && i2 != null) {
                return true;
            }
            return false;
        }
        catch (ClassCastException var1_4) {
            return false;
        }
    }

    public void a(l l2) {
        j j2 = this;
        synchronized (j2) {
            this.a.add((Object)l2);
            return;
        }
    }

    @Override
    public void a(Throwable throwable) {
        this.c.set((Object)throwable);
    }

    @Override
    public e b() {
        return e.b;
    }

    @Override
    public void b(boolean bl) {
        j j2 = this;
        synchronized (j2) {
            this.b.set(bl);
            return;
        }
    }

    @Override
    public Collection<l> c() {
        j j2 = this;
        synchronized (j2) {
            Collection collection = Collections.unmodifiableCollection(this.a);
            return collection;
        }
    }

    @Override
    public /* synthetic */ void c(Object object) {
        this.a((l)object);
    }

    public int compareTo(Object object) {
        return e.a(this, object);
    }

    @Override
    public boolean d() {
        Iterator iterator = this.c().iterator();
        while (iterator.hasNext()) {
            if (((l)iterator.next()).f()) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean f() {
        return this.b.get();
    }
}

