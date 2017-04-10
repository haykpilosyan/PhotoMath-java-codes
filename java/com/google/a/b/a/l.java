/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 */
package com.google.a.b.a;

import com.google.a.b.a.i;
import com.google.a.d.a;
import com.google.a.d.c;
import com.google.a.f;
import com.google.a.w;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class l<T>
extends w<T> {
    private final f a;
    private final w<T> b;
    private final Type c;

    l(f f2, w<T> w2, Type type) {
        this.a = f2;
        this.b = w2;
        this.c = type;
    }

    private Type a(Type type, Object object) {
        if (object != null && (type == Object.class || type instanceof TypeVariable || type instanceof Class)) {
            type = object.getClass();
        }
        return type;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void a(c c2, T t2) throws IOException {
        void var3_5;
        w w2;
        w<T> w3 = this.b;
        Type type = this.a(this.c, t2);
        if (type != this.c && (w2 = this.a.a(com.google.a.c.a.get(type))) instanceof i.a && !(this.b instanceof i.a)) {
            w<T> w4 = this.b;
        }
        var3_5.a(c2, t2);
    }

    @Override
    public T b(a a2) throws IOException {
        return this.b.b(a2);
    }
}

