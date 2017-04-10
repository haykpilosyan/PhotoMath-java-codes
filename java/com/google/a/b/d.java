/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.CloneNotSupportedException
 *  java.lang.Cloneable
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Field
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.google.a.b;

import com.google.a.a.e;
import com.google.a.b;
import com.google.a.c;
import com.google.a.d.a;
import com.google.a.f;
import com.google.a.w;
import com.google.a.x;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class d
implements x,
Cloneable {
    public static final d a = new d();
    private double b = -1.0;
    private int c = 136;
    private boolean d = true;
    private boolean e;
    private List<b> f = Collections.emptyList();
    private List<b> g = Collections.emptyList();

    private boolean a(com.google.a.a.d d2) {
        if (d2 != null && d2.a() > this.b) {
            return false;
        }
        return true;
    }

    private boolean a(com.google.a.a.d d2, e e2) {
        if (this.a(d2) && this.a(e2)) {
            return true;
        }
        return false;
    }

    private boolean a(e e2) {
        if (e2 != null && e2.a() <= this.b) {
            return false;
        }
        return true;
    }

    private boolean a(Class<?> class_) {
        if (!Enum.class.isAssignableFrom(class_) && (class_.isAnonymousClass() || class_.isLocalClass())) {
            return true;
        }
        return false;
    }

    private boolean b(Class<?> class_) {
        if (class_.isMemberClass() && !this.c(class_)) {
            return true;
        }
        return false;
    }

    private boolean c(Class<?> class_) {
        if ((8 & class_.getModifiers()) != 0) {
            return true;
        }
        return false;
    }

    protected d a() {
        try {
            d d2 = (d)super.clone();
            return d2;
        }
        catch (CloneNotSupportedException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    @Override
    public <T> w<T> a(final f f2, final com.google.a.c.a<T> a2) {
        Class<T> class_ = a2.getRawType();
        final boolean bl = this.a(class_, true);
        final boolean bl2 = this.a(class_, false);
        if (!bl && !bl2) {
            return null;
        }
        return new w<T>(){
            private w<T> f;

            private w<T> b() {
                w w2;
                w<T> w3 = this.f;
                if (w3 != null) {
                    return w3;
                }
                this.f = w2 = f2.a(d.this, a2);
                return w2;
            }

            @Override
            public void a(com.google.a.d.c c2, T t2) throws IOException {
                if (bl) {
                    c2.f();
                    return;
                }
                this.b().a(c2, t2);
            }

            @Override
            public T b(a a22) throws IOException {
                if (bl2) {
                    a22.n();
                    return null;
                }
                return this.b().b(a22);
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(Class<?> class_, boolean bl) {
        if (this.b != -1.0 && !this.a((com.google.a.a.d)class_.getAnnotation((Class)com.google.a.a.d.class), (e)class_.getAnnotation((Class)e.class))) {
            return true;
        }
        if (!this.d && this.b(class_)) {
            return true;
        }
        if (this.a(class_)) {
            return true;
        }
        List<b> list = bl ? this.f : this.g;
        Iterator iterator = list.iterator();
        do {
            if (iterator.hasNext()) continue;
            return false;
        } while (!((b)iterator.next()).a(class_));
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(Field field, boolean bl) {
        com.google.a.a.a a2;
        if ((this.c & field.getModifiers()) != 0) {
            return true;
        }
        if (this.b != -1.0 && !this.a((com.google.a.a.d)field.getAnnotation((Class)com.google.a.a.d.class), (e)field.getAnnotation((Class)e.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (this.e && ((a2 = (com.google.a.a.a)field.getAnnotation((Class)com.google.a.a.a.class)) == null || (bl ? !a2.a() : !a2.b()))) {
            return true;
        }
        if (!this.d && this.b(field.getType())) {
            return true;
        }
        if (this.a(field.getType())) {
            return true;
        }
        List<b> list = bl ? this.f : this.g;
        if (!list.isEmpty()) {
            c c2 = new c(field);
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                if (!((b)iterator.next()).a(c2)) continue;
                return true;
            }
        }
        return false;
    }

    protected /* synthetic */ Object clone() throws CloneNotSupportedException {
        return this.a();
    }

}

