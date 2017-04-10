/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 */
package c;

import c.a.i;
import c.aa;
import c.s;
import c.u;
import d.c;
import d.d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class p
extends aa {
    private static final u a = u.a("application/x-www-form-urlencoded");
    private final List<String> b;
    private final List<String> c;

    private p(List<String> list, List<String> list2) {
        this.b = i.a(list);
        this.c = i.a(list2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private long a(d d2, boolean bl) {
        long l2 = 0;
        c c2 = bl ? new c() : d2.b();
        int n2 = this.b.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (i2 > 0) {
                c2.b(38);
            }
            c2.a((String)this.b.get(i2));
            c2.b(61);
            c2.a((String)this.c.get(i2));
        }
        if (bl) {
            l2 = c2.a();
            c2.t();
        }
        return l2;
    }

    @Override
    public long contentLength() {
        return this.a(null, true);
    }

    @Override
    public u contentType() {
        return a;
    }

    @Override
    public void writeTo(d d2) throws IOException {
        this.a(d2, false);
    }

    public static final class a {
        private final List<String> a = new ArrayList();
        private final List<String> b = new ArrayList();

        public a a(String string, String string2) {
            this.a.add((Object)s.a(string, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.b.add((Object)s.a(string2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public p a() {
            return new p(this.a, this.b);
        }

        public a b(String string, String string2) {
            this.a.add((Object)s.a(string, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.b.add((Object)s.a(string2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }
    }

}

