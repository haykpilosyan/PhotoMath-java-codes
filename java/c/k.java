/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLSocket
 */
package c;

import c.a.i;
import c.ae;
import c.h;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class k {
    public static final k a;
    public static final k b;
    public static final k c;
    private static final h[] d;
    private final boolean e;
    private final boolean f;
    private final String[] g;
    private final String[] h;

    static {
        h[] arrh = new h[]{h.aK, h.aO, h.W, h.am, h.al, h.av, h.aw, h.F, h.J, h.U, h.D, h.H, h.h};
        d = arrh;
        a a2 = new a(true).a(d);
        ae[] arrae = new ae[]{ae.a, ae.b, ae.c};
        a = a2.a(arrae).a(true).a();
        a a3 = new a(a);
        ae[] arrae2 = new ae[]{ae.c};
        b = a3.a(arrae2).a(true).a();
        c = new a(false).a();
    }

    private k(a a2) {
        this.e = a2.a;
        this.g = a2.b;
        this.h = a2.c;
        this.f = a2.d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(String[] arrstring, String[] arrstring2) {
        if (arrstring == null || arrstring2 == null || arrstring.length == 0 || arrstring2.length == 0) {
            return false;
        }
        int n2 = arrstring.length;
        int n3 = 0;
        while (n3 < n2) {
            if (i.a(arrstring2, arrstring[n3])) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private k b(SSLSocket sSLSocket, boolean bl) {
        String[] arrstring = this.g != null ? i.a(String.class, this.g, sSLSocket.getEnabledCipherSuites()) : sSLSocket.getEnabledCipherSuites();
        String[] arrstring2 = this.h != null ? i.a(String.class, this.h, sSLSocket.getEnabledProtocols()) : sSLSocket.getEnabledProtocols();
        if (bl && i.a(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV")) {
            arrstring = i.b(arrstring, "TLS_FALLBACK_SCSV");
        }
        return new a(this).a(arrstring).b(arrstring2).a();
    }

    void a(SSLSocket sSLSocket, boolean bl) {
        k k2 = this.b(sSLSocket, bl);
        if (k2.h != null) {
            sSLSocket.setEnabledProtocols(k2.h);
        }
        if (k2.g != null) {
            sSLSocket.setEnabledCipherSuites(k2.g);
        }
    }

    public boolean a() {
        return this.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(SSLSocket sSLSocket) {
        if (!this.e || this.h != null && !k.a(this.h, sSLSocket.getEnabledProtocols()) || this.g != null && !k.a(this.g, sSLSocket.getEnabledCipherSuites())) {
            return false;
        }
        return true;
    }

    public List<h> b() {
        if (this.g == null) {
            return null;
        }
        h[] arrh = new h[this.g.length];
        for (int i2 = 0; i2 < this.g.length; ++i2) {
            arrh[i2] = h.a(this.g[i2]);
        }
        return i.a(arrh);
    }

    public List<ae> c() {
        if (this.h == null) {
            return null;
        }
        ae[] arrae = new ae[this.h.length];
        for (int i2 = 0; i2 < this.h.length; ++i2) {
            arrae[i2] = ae.a(this.h[i2]);
        }
        return i.a(arrae);
    }

    public boolean d() {
        return this.f;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof k)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        k k2 = (k)object;
        if (this.e != k2.e) return false;
        if (!this.e) return true;
        if (!Arrays.equals((Object[])this.g, (Object[])k2.g)) return false;
        if (!Arrays.equals((Object[])this.h, (Object[])k2.h)) return false;
        if (this.f != k2.f) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        int n2;
        int n3 = 17;
        if (!this.e) return n3;
        int n4 = 31 * (31 * (527 + Arrays.hashCode((Object[])this.g)) + Arrays.hashCode((Object[])this.h));
        if (this.f) {
            n2 = 0;
            do {
                return n2 + n4;
                break;
            } while (true);
        }
        n2 = 1;
        return n2 + n4;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        String string;
        if (!this.e) {
            return "ConnectionSpec()";
        }
        String string2 = this.g != null ? this.b().toString() : "[all enabled]";
        if (this.h != null) {
            string = this.c().toString();
            return "ConnectionSpec(cipherSuites=" + string2 + ", tlsVersions=" + string + ", supportsTlsExtensions=" + this.f + ")";
        }
        string = "[all enabled]";
        return "ConnectionSpec(cipherSuites=" + string2 + ", tlsVersions=" + string + ", supportsTlsExtensions=" + this.f + ")";
    }

    public static final class a {
        private boolean a;
        private String[] b;
        private String[] c;
        private boolean d;

        public a(k k2) {
            this.a = k2.e;
            this.b = k2.g;
            this.c = k2.h;
            this.d = k2.f;
        }

        a(boolean bl) {
            this.a = bl;
        }

        public a a(boolean bl) {
            if (!this.a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            }
            this.d = bl;
            return this;
        }

        public /* varargs */ a a(ae ... arrae) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            String[] arrstring = new String[arrae.length];
            for (int i2 = 0; i2 < arrae.length; ++i2) {
                arrstring[i2] = arrae[i2].e;
            }
            return this.b(arrstring);
        }

        public /* varargs */ a a(h ... arrh) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            String[] arrstring = new String[arrh.length];
            for (int i2 = 0; i2 < arrh.length; ++i2) {
                arrstring[i2] = arrh[i2].aS;
            }
            return this.a(arrstring);
        }

        public /* varargs */ a a(String ... arrstring) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            }
            if (arrstring.length == 0) {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            this.b = (String[])arrstring.clone();
            return this;
        }

        public k a() {
            return new k(this);
        }

        public /* varargs */ a b(String ... arrstring) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            if (arrstring.length == 0) {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            this.c = (String[])arrstring.clone();
            return this;
        }
    }

}

