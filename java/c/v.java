/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  d.f
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.UUID
 */
package c;

import c.a.i;
import c.aa;
import c.r;
import c.u;
import d.c;
import d.d;
import d.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class v
extends aa {
    public static final u a = u.a("multipart/mixed");
    public static final u b = u.a("multipart/alternative");
    public static final u c = u.a("multipart/digest");
    public static final u d = u.a("multipart/parallel");
    public static final u e = u.a("multipart/form-data");
    private static final byte[] f = new byte[]{58, 32};
    private static final byte[] g = new byte[]{13, 10};
    private static final byte[] h = new byte[]{45, 45};
    private final f i;
    private final u j;
    private final u k;
    private final List<b> l;
    private long m = -1;

    v(f f2, u u2, List<b> list) {
        this.i = f2;
        this.j = u2;
        this.k = u.a(u2 + "; boundary=" + f2.a());
        this.l = i.a(list);
    }

    /*
     * Enabled aggressive block sorting
     */
    private long a(d d2, boolean bl) throws IOException {
        c c2;
        long l2 = 0;
        if (bl) {
            c c3;
            c2 = c3 = new c();
            d2 = c3;
        } else {
            c2 = null;
        }
        int n2 = this.l.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            long l3;
            u u2;
            b b2 = (b)this.l.get(i2);
            r r2 = b2.a;
            aa aa2 = b2.b;
            d2.c(h);
            d2.b(this.i);
            d2.c(g);
            if (r2 != null) {
                int n3 = r2.a();
                for (int i3 = 0; i3 < n3; ++i3) {
                    d2.b(r2.a(i3)).c(f).b(r2.b(i3)).c(g);
                }
            }
            if ((u2 = aa2.contentType()) != null) {
                d2.b("Content-Type: ").b(u2.toString()).c(g);
            }
            if ((l3 = aa2.contentLength()) != -1) {
                d2.b("Content-Length: ").k(l3).c(g);
            } else if (bl) {
                c2.t();
                return -1;
            }
            d2.c(g);
            if (bl) {
                l2 += l3;
            } else {
                aa2.writeTo(d2);
            }
            d2.c(g);
        }
        d2.c(h);
        d2.b(this.i);
        d2.c(h);
        d2.c(g);
        if (!bl) return l2;
        long l4 = l2 + c2.a();
        c2.t();
        return l4;
    }

    @Override
    public long contentLength() throws IOException {
        long l2;
        long l3 = this.m;
        if (l3 != -1) {
            return l3;
        }
        this.m = l2 = this.a(null, true);
        return l2;
    }

    @Override
    public u contentType() {
        return this.k;
    }

    @Override
    public void writeTo(d d2) throws IOException {
        this.a(d2, false);
    }

    public static final class a {
        private final f a;
        private u b = v.a;
        private final List<b> c = new ArrayList();

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String string) {
            this.a = f.a((String)string);
        }

        public a a(r r2, aa aa2) {
            return this.a(b.a(r2, aa2));
        }

        public a a(u u2) {
            if (u2 == null) {
                throw new NullPointerException("type == null");
            }
            if (!u2.a().equals((Object)"multipart")) {
                throw new IllegalArgumentException("multipart != " + u2);
            }
            this.b = u2;
            return this;
        }

        public a a(b b2) {
            if (b2 == null) {
                throw new NullPointerException("part == null");
            }
            this.c.add((Object)b2);
            return this;
        }

        public v a() {
            if (this.c.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new v(this.a, this.b, this.c);
        }
    }

    public static final class b {
        private final r a;
        private final aa b;

        private b(r r2, aa aa2) {
            this.a = r2;
            this.b = aa2;
        }

        public static b a(r r2, aa aa2) {
            if (aa2 == null) {
                throw new NullPointerException("body == null");
            }
            if (r2 != null && r2.a("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (r2 != null && r2.a("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new b(r2, aa2);
        }
    }

}

