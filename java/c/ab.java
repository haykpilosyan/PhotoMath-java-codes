/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package c;

import c.ac;
import c.d;
import c.q;
import c.r;
import c.s;
import c.x;
import c.z;

public final class ab {
    private final z a;
    private final x b;
    private final int c;
    private final String d;
    private final q e;
    private final r f;
    private final ac g;
    private ab h;
    private ab i;
    private final ab j;
    private volatile d k;

    private ab(a a2) {
        this.a = a2.a;
        this.b = a2.b;
        this.c = a2.c;
        this.d = a2.d;
        this.e = a2.e;
        this.f = a2.f.a();
        this.g = a2.g;
        this.h = a2.h;
        this.i = a2.i;
        this.j = a2.j;
    }

    public z a() {
        return this.a;
    }

    public String a(String string) {
        return this.a(string, null);
    }

    public String a(String string, String string2) {
        String string3 = this.f.a(string);
        if (string3 != null) {
            string2 = string3;
        }
        return string2;
    }

    public int b() {
        return this.c;
    }

    public boolean c() {
        if (this.c >= 200 && this.c < 300) {
            return true;
        }
        return false;
    }

    public String d() {
        return this.d;
    }

    public q e() {
        return this.e;
    }

    public r f() {
        return this.f;
    }

    public ac g() {
        return this.g;
    }

    public a h() {
        return new a(this);
    }

    public d i() {
        d d2;
        d d3 = this.k;
        if (d3 != null) {
            return d3;
        }
        this.k = d2 = d.a(this.f);
        return d2;
    }

    public String toString() {
        return "Response{protocol=" + (Object)((Object)this.b) + ", code=" + this.c + ", message=" + this.d + ", url=" + this.a.a() + '}';
    }

    public static class a {
        private z a;
        private x b;
        private int c = -1;
        private String d;
        private q e;
        private r.a f;
        private ac g;
        private ab h;
        private ab i;
        private ab j;

        public a() {
            this.f = new r.a();
        }

        private a(ab ab2) {
            this.a = ab2.a;
            this.b = ab2.b;
            this.c = ab2.c;
            this.d = ab2.d;
            this.e = ab2.e;
            this.f = ab2.f.b();
            this.g = ab2.g;
            this.h = ab2.h;
            this.i = ab2.i;
            this.j = ab2.j;
        }

        private void a(String string, ab ab2) {
            if (ab2.g != null) {
                throw new IllegalArgumentException(string + ".body != null");
            }
            if (ab2.h != null) {
                throw new IllegalArgumentException(string + ".networkResponse != null");
            }
            if (ab2.i != null) {
                throw new IllegalArgumentException(string + ".cacheResponse != null");
            }
            if (ab2.j != null) {
                throw new IllegalArgumentException(string + ".priorResponse != null");
            }
        }

        private void d(ab ab2) {
            if (ab2.g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(int n2) {
            this.c = n2;
            return this;
        }

        public a a(ab ab2) {
            if (ab2 != null) {
                this.a("networkResponse", ab2);
            }
            this.h = ab2;
            return this;
        }

        public a a(ac ac2) {
            this.g = ac2;
            return this;
        }

        public a a(q q2) {
            this.e = q2;
            return this;
        }

        public a a(r r2) {
            this.f = r2.b();
            return this;
        }

        public a a(x x2) {
            this.b = x2;
            return this;
        }

        public a a(z z2) {
            this.a = z2;
            return this;
        }

        public a a(String string) {
            this.d = string;
            return this;
        }

        public a a(String string, String string2) {
            this.f.c(string, string2);
            return this;
        }

        public ab a() {
            if (this.a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.c < 0) {
                throw new IllegalStateException("code < 0: " + this.c);
            }
            return new ab(this);
        }

        public a b(ab ab2) {
            if (ab2 != null) {
                this.a("cacheResponse", ab2);
            }
            this.i = ab2;
            return this;
        }

        public a b(String string, String string2) {
            this.f.a(string, string2);
            return this;
        }

        public a c(ab ab2) {
            if (ab2 != null) {
                this.d(ab2);
            }
            this.j = ab2;
            return this;
        }
    }

}

