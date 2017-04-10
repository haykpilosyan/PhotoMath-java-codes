/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package c;

import c.a.b.h;
import c.aa;
import c.d;
import c.r;
import c.s;

public final class z {
    private final s a;
    private final String b;
    private final r c;
    private final aa d;
    private final Object e;
    private volatile d f;

    /*
     * Enabled aggressive block sorting
     */
    private z(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c.a();
        this.d = a2.d;
        Object object = a2.e != null ? a2.e : this;
        this.e = object;
    }

    public s a() {
        return this.a;
    }

    public String a(String string) {
        return this.c.a(string);
    }

    public String b() {
        return this.b;
    }

    public r c() {
        return this.c;
    }

    public aa d() {
        return this.d;
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d d2;
        d d3 = this.f;
        if (d3 != null) {
            return d3;
        }
        this.f = d2 = d.a(this.c);
        return d2;
    }

    public boolean g() {
        return this.a.c();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder().append("Request{method=").append(this.b).append(", url=").append((Object)this.a).append(", tag=");
        if (this.e != this) {
            object = this.e;
            do {
                return stringBuilder.append(object).append('}').toString();
                break;
            } while (true);
        }
        object = null;
        return stringBuilder.append(object).append('}').toString();
    }

    public static class a {
        private s a;
        private String b;
        private r.a c;
        private aa d;
        private Object e;

        public a() {
            this.b = "GET";
            this.c = new r.a();
        }

        private a(z z2) {
            this.a = z2.a;
            this.b = z2.b;
            this.d = z2.d;
            this.e = z2.e;
            this.c = z2.c.b();
        }

        public a a(r r2) {
            this.c = r2.b();
            return this;
        }

        public a a(s s2) {
            if (s2 == null) {
                throw new IllegalArgumentException("url == null");
            }
            this.a = s2;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public a a(String string) {
            s s2;
            if (string == null) {
                throw new IllegalArgumentException("url == null");
            }
            if (string.regionMatches(true, 0, "ws:", 0, 3)) {
                string = "http:" + string.substring(3);
            } else if (string.regionMatches(true, 0, "wss:", 0, 4)) {
                string = "https:" + string.substring(4);
            }
            if ((s2 = s.e(string)) == null) {
                throw new IllegalArgumentException("unexpected url: " + string);
            }
            return this.a(s2);
        }

        public a a(String string, aa aa2) {
            if (string == null || string.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (aa2 != null && !h.c(string)) {
                throw new IllegalArgumentException("method " + string + " must not have a request body.");
            }
            if (aa2 == null && h.b(string)) {
                throw new IllegalArgumentException("method " + string + " must have a request body.");
            }
            this.b = string;
            this.d = aa2;
            return this;
        }

        public a a(String string, String string2) {
            this.c.c(string, string2);
            return this;
        }

        public z a() {
            if (this.a == null) {
                throw new IllegalStateException("url == null");
            }
            return new z(this);
        }

        public a b(String string) {
            this.c.b(string);
            return this;
        }

        public a b(String string, String string2) {
            this.c.a(string, string2);
            return this;
        }
    }

}

