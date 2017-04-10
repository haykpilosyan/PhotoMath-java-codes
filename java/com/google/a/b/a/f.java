/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package com.google.a.b.a;

import com.google.a.d.c;
import com.google.a.i;
import com.google.a.l;
import com.google.a.n;
import com.google.a.o;
import com.google.a.q;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f
extends c {
    private static final Writer a = new Writer(){

        public void close() throws IOException {
            throw new AssertionError();
        }

        public void flush() throws IOException {
            throw new AssertionError();
        }

        public void write(char[] arrc, int n2, int n3) {
            throw new AssertionError();
        }
    };
    private static final q b = new q("closed");
    private final List<l> c = new ArrayList();
    private String d;
    private l e = n.a;

    public f() {
        super(a);
    }

    private void a(l l2) {
        if (this.d != null) {
            if (!l2.j() || this.i()) {
                ((o)this.j()).a(this.d, l2);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = l2;
            return;
        }
        l l3 = this.j();
        if (l3 instanceof i) {
            ((i)l3).a(l2);
            return;
        }
        throw new IllegalStateException();
    }

    private l j() {
        return (l)this.c.get(-1 + this.c.size());
    }

    @Override
    public c a(long l2) throws IOException {
        this.a(new q(l2));
        return this;
    }

    @Override
    public c a(Number number) throws IOException {
        double d2;
        if (number == null) {
            return this.f();
        }
        if (!this.g() && (Double.isNaN((double)(d2 = number.doubleValue())) || Double.isInfinite((double)d2))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + (Object)number);
        }
        this.a(new q(number));
        return this;
    }

    @Override
    public c a(String string) throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (this.j() instanceof o) {
            this.d = string;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public c a(boolean bl) throws IOException {
        this.a(new q(bl));
        return this;
    }

    public l a() {
        if (!this.c.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.c);
        }
        return this.e;
    }

    @Override
    public c b() throws IOException {
        i i2 = new i();
        this.a(i2);
        this.c.add((Object)i2);
        return this;
    }

    @Override
    public c b(String string) throws IOException {
        if (string == null) {
            return this.f();
        }
        this.a(new q(string));
        return this;
    }

    @Override
    public c c() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (this.j() instanceof i) {
            this.c.remove(-1 + this.c.size());
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add((Object)b);
    }

    @Override
    public c d() throws IOException {
        o o2 = new o();
        this.a(o2);
        this.c.add((Object)o2);
        return this;
    }

    @Override
    public c e() throws IOException {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (this.j() instanceof o) {
            this.c.remove(-1 + this.c.size());
            return this;
        }
        throw new IllegalStateException();
    }

    @Override
    public c f() throws IOException {
        this.a(n.a);
        return this;
    }

    @Override
    public void flush() throws IOException {
    }

}

