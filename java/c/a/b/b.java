/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  java.util.concurrent.TimeUnit
 */
package c.a.b;

import c.a.b.c;
import c.a.b.f;
import c.a.b.j;
import c.ab;
import c.d;
import c.q;
import c.r;
import c.s;
import c.z;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class b {
    public final z a;
    public final ab b;

    private b(z z2, ab ab2) {
        this.a = z2;
        this.b = ab2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(ab ab2, z z2) {
        switch (ab2.b()) {
            case 302: 
            case 307: {
                if (ab2.a("Expires") != null || ab2.i().c() != -1 || ab2.i().e() || ab2.i().d()) break;
            }
            default: {
                return false;
            }
            case 200: 
            case 203: 
            case 204: 
            case 300: 
            case 301: 
            case 308: 
            case 404: 
            case 405: 
            case 410: 
            case 414: 
            case 501: 
        }
        if (ab2.i().b() || z2.f().b()) return false;
        return true;
    }

    public static class a {
        final long a;
        final z b;
        final ab c;
        private Date d;
        private String e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l = -1;

        /*
         * Enabled aggressive block sorting
         */
        public a(long l2, z z2, ab ab2) {
            this.a = l2;
            this.b = z2;
            this.c = ab2;
            if (ab2 != null) {
                r r2 = ab2.f();
                int n2 = r2.a();
                for (int i2 = 0; i2 < n2; ++i2) {
                    String string = r2.a(i2);
                    String string2 = r2.b(i2);
                    if ("Date".equalsIgnoreCase(string)) {
                        this.d = f.a(string2);
                        this.e = string2;
                        continue;
                    }
                    if ("Expires".equalsIgnoreCase(string)) {
                        this.h = f.a(string2);
                        continue;
                    }
                    if ("Last-Modified".equalsIgnoreCase(string)) {
                        this.f = f.a(string2);
                        this.g = string2;
                        continue;
                    }
                    if ("ETag".equalsIgnoreCase(string)) {
                        this.k = string2;
                        continue;
                    }
                    if ("Age".equalsIgnoreCase(string)) {
                        this.l = c.b(string2, -1);
                        continue;
                    }
                    if (j.b.equalsIgnoreCase(string)) {
                        this.i = Long.parseLong((String)string2);
                        continue;
                    }
                    if (!j.c.equalsIgnoreCase(string)) continue;
                    this.j = Long.parseLong((String)string2);
                }
            }
        }

        private static boolean a(z z2) {
            if (z2.a("If-Modified-Since") != null || z2.a("If-None-Match") != null) {
                return true;
            }
            return false;
        }

        /*
         * Enabled aggressive block sorting
         */
        private b b() {
            z z2;
            long l2 = 0;
            if (this.c == null) {
                return new b(this.b, null);
            }
            if (this.b.g() && this.c.e() == null) {
                return new b(this.b, null);
            }
            if (!b.a(this.c, this.b)) {
                return new b(this.b, null);
            }
            d d2 = this.b.f();
            if (d2.a() || a.a(this.b)) {
                return new b(this.b, null);
            }
            long l3 = this.d();
            long l4 = this.c();
            if (d2.c() != -1) {
                l4 = Math.min((long)l4, (long)TimeUnit.SECONDS.toMillis((long)d2.c()));
            }
            long l5 = d2.h() != -1 ? TimeUnit.SECONDS.toMillis((long)d2.h()) : l2;
            d d3 = this.c.i();
            if (!d3.f() && d2.g() != -1) {
                l2 = TimeUnit.SECONDS.toMillis((long)d2.g());
            }
            if (!d3.a() && l3 + l5 < l2 + l4) {
                ab.a a2 = this.c.h();
                if (l5 + l3 >= l4) {
                    a2.b("Warning", "110 HttpURLConnection \"Response is stale\"");
                }
                if (l3 > 86400000 && this.e()) {
                    a2.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                }
                return new b(null, a2.a());
            }
            z.a a3 = this.b.e();
            if (this.k != null) {
                a3.a("If-None-Match", this.k);
            } else if (this.f != null) {
                a3.a("If-Modified-Since", this.g);
            } else if (this.d != null) {
                a3.a("If-Modified-Since", this.e);
            }
            if (a.a(z2 = a3.a())) {
                return new b(z2, this.c);
            }
            return new b(z2, null);
        }

        /*
         * Enabled aggressive block sorting
         */
        private long c() {
            long l2 = 0;
            d d2 = this.c.i();
            if (d2.c() != -1) {
                return TimeUnit.SECONDS.toMillis((long)d2.c());
            }
            if (this.h != null) {
                long l3 = this.d != null ? this.d.getTime() : this.j;
                long l4 = this.h.getTime() - l3;
                if (l4 <= l2) return l2;
                return l4;
            }
            if (this.f == null) return l2;
            if (this.c.a().a().l() != null) return l2;
            long l5 = this.d != null ? this.d.getTime() : this.i;
            long l6 = l5 - this.f.getTime();
            if (l6 <= l2) return l2;
            return l6 / 10;
        }

        private long d() {
            long l2 = 0;
            if (this.d != null) {
                l2 = Math.max((long)l2, (long)(this.j - this.d.getTime()));
            }
            if (this.l != -1) {
                l2 = Math.max((long)l2, (long)TimeUnit.SECONDS.toMillis((long)this.l));
            }
            long l3 = this.j - this.i;
            return this.a - this.j + (l2 + l3);
        }

        private boolean e() {
            if (this.c.i().c() == -1 && this.h == null) {
                return true;
            }
            return false;
        }

        public b a() {
            b b2 = this.b();
            if (b2.a != null && this.b.f().i()) {
                b2 = new b(null, null);
            }
            return b2;
        }
    }

}

