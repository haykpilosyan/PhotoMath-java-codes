/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 */
package com.google.a.b.a;

import com.google.a.a.b;
import com.google.a.b.c;
import com.google.a.b.h;
import com.google.a.c.a;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.lang.annotation.Annotation;

public final class d
implements x {
    private final c a;

    public d(c c2) {
        this.a = c2;
    }

    /*
     * Enabled aggressive block sorting
     */
    static w<?> a(c c2, f f2, a<?> a2, b b2) {
        void var5_8;
        void var5_6;
        Class class_ = b2.a();
        if (w.class.isAssignableFrom(class_)) {
            w w2 = (w)c2.a(a.get(class_)).a();
        } else {
            if (!x.class.isAssignableFrom(class_)) {
                throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
            }
            w w3 = ((x)c2.a(a.get(class_)).a()).a(f2, a2);
        }
        if (var5_6 != null) {
            w w4 = var5_6.a();
        }
        return var5_8;
    }

    @Override
    public <T> w<T> a(f f2, a<T> a2) {
        b b2 = (b)a2.getRawType().getAnnotation((Class)b.class);
        if (b2 == null) {
            return null;
        }
        return d.a(this.a, f2, a2, b2);
    }
}

