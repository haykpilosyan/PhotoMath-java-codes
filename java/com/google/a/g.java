/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Type
 *  java.sql.Date
 *  java.sql.Timestamp
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.google.a;

import com.google.a.a;
import com.google.a.b.a.m;
import com.google.a.b.d;
import com.google.a.e;
import com.google.a.f;
import com.google.a.h;
import com.google.a.k;
import com.google.a.s;
import com.google.a.u;
import com.google.a.v;
import com.google.a.w;
import com.google.a.x;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class g {
    private d a = d.a;
    private u b = u.a;
    private e c = com.google.a.d.a;
    private final Map<Type, h<?>> d = new HashMap();
    private final List<x> e = new ArrayList();
    private final List<x> f = new ArrayList();
    private boolean g = false;
    private String h;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void a(String string, int n2, int n3, List<x> list) {
        a a2;
        if (string != null && !"".equals((Object)string.trim())) {
            a2 = new a(string);
        } else {
            if (n2 == 2) return;
            if (n3 == 2) return;
            a2 = new a(n2, n3);
        }
        list.add((Object)v.a(com.google.a.c.a.get(Date.class), a2));
        list.add((Object)v.a(com.google.a.c.a.get(Timestamp.class), a2));
        list.add((Object)v.a(com.google.a.c.a.get(java.sql.Date.class), a2));
    }

    public f a() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.e);
        Collections.reverse((List)arrayList);
        arrayList.addAll(this.f);
        this.a(this.h, this.i, this.j, (List<x>)arrayList);
        return new f(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, (List<x>)arrayList);
    }

    public g a(String string) {
        this.h = string;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public g a(Type type, Object object) {
        boolean bl = object instanceof s || object instanceof k || object instanceof h || object instanceof w;
        com.google.a.b.a.a(bl);
        if (object instanceof h) {
            this.d.put((Object)type, (Object)((h)object));
        }
        if (object instanceof s || object instanceof k) {
            com.google.a.c.a a2 = com.google.a.c.a.get(type);
            this.e.add((Object)v.b(a2, object));
        }
        if (object instanceof w) {
            this.e.add((Object)m.a(com.google.a.c.a.get(type), (w)object));
        }
        return this;
    }
}

