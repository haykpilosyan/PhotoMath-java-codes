/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package com.google.a;

import com.google.a.b.j;
import com.google.a.d.c;
import com.google.a.i;
import com.google.a.n;
import com.google.a.o;
import com.google.a.q;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public abstract class l {
    public Number a() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public String b() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public double c() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public long d() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public int e() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public boolean f() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public boolean g() {
        return this instanceof i;
    }

    public boolean h() {
        return this instanceof o;
    }

    public boolean i() {
        return this instanceof q;
    }

    public boolean j() {
        return this instanceof n;
    }

    public o k() {
        if (this.h()) {
            return (o)this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public i l() {
        if (this.g()) {
            return (i)this;
        }
        throw new IllegalStateException("This is not a JSON Array.");
    }

    public q m() {
        if (this.i()) {
            return (q)this;
        }
        throw new IllegalStateException("This is not a JSON Primitive.");
    }

    Boolean n() {
        throw new UnsupportedOperationException(this.getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            c c2 = new c((Writer)stringWriter);
            c2.b(true);
            j.a(this, c2);
            String string = stringWriter.toString();
            return string;
        }
        catch (IOException var3_4) {
            throw new AssertionError((Object)var3_4);
        }
    }
}

