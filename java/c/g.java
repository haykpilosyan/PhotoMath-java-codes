/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.f
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.security.Principal
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package c;

import c.a.d.f;
import c.a.i;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class g {
    public static final g a = new a().a();
    private final List<b> b;
    private final f c;

    private g(a a2) {
        this.b = i.a(a2.a);
        this.c = a2.b;
    }

    static d.f a(X509Certificate x509Certificate) {
        return i.a(d.f.a((byte[])x509Certificate.getPublicKey().getEncoded()));
    }

    public static String a(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + g.b((X509Certificate)certificate).b();
    }

    static d.f b(X509Certificate x509Certificate) {
        return i.b(d.f.a((byte[])x509Certificate.getPublicKey().getEncoded()));
    }

    a a() {
        return new a(this);
    }

    List<b> a(String string) {
        List list = Collections.emptyList();
        for (b b2 : this.b) {
            if (!b2.a(string)) continue;
            if (list.isEmpty()) {
                list = new ArrayList();
            }
            list.add((Object)b2);
        }
        return list;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(String string, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> list2 = this.a(string);
        if (!list2.isEmpty()) {
            if (this.c != null) {
                list = new c.a.d.b(this.c).a(list);
            }
            int n2 = list.size();
            int n3 = 0;
            block0 : do {
                d.f f2;
                int n4;
                X509Certificate x509Certificate;
                d.f f3;
                if (n3 < n2) {
                    x509Certificate = (X509Certificate)list.get(n3);
                    n4 = list2.size();
                    f2 = null;
                    f3 = null;
                } else {
                    StringBuilder stringBuilder = new StringBuilder().append("Certificate pinning failure!").append("\n  Peer certificate chain:");
                    int n5 = list.size();
                    for (int i2 = 0; i2 < n5; ++i2) {
                        X509Certificate x509Certificate2 = (X509Certificate)list.get(i2);
                        stringBuilder.append("\n    ").append(g.a((Certificate)x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
                    }
                    stringBuilder.append("\n  Pinned certificates for ").append(string).append(":");
                    int n6 = list2.size();
                    int n7 = 0;
                    do {
                        if (n7 >= n6) {
                            throw new SSLPeerUnverifiedException(stringBuilder.toString());
                        }
                        b b2 = (b)list2.get(n7);
                        stringBuilder.append("\n    ").append((Object)b2);
                        ++n7;
                    } while (true);
                }
                for (int i3 = 0; i3 < n4; ++i3) {
                    b b3 = (b)list2.get(i3);
                    if (b3.b.equals((Object)"sha256/")) {
                        if (f2 == null) {
                            f2 = g.b(x509Certificate);
                        }
                        if (b3.c.equals((Object)f2)) break block0;
                    } else {
                        if (!b3.b.equals((Object)"sha1/")) {
                            throw new AssertionError();
                        }
                        if (f3 == null) {
                            f3 = g.a(x509Certificate);
                        }
                        if (b3.c.equals((Object)f3)) {
                            return;
                        }
                    }
                    d.f f4 = f2;
                    d.f f5 = f3;
                    f3 = f5;
                    f2 = f4;
                }
                ++n3;
            } while (true);
        }
    }

    public static final class a {
        private final List<b> a = new ArrayList();
        private f b;

        public a() {
        }

        a(g g2) {
            this.a.addAll((Collection)g2.b);
            this.b = g2.c;
        }

        public a a(f f2) {
            this.b = f2;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    static final class b {
        final String a;
        final String b;
        final d.f c;

        boolean a(String string) {
            if (this.a.equals((Object)string)) {
                return true;
            }
            int n2 = string.indexOf(46);
            boolean bl = this.a.startsWith("*.");
            boolean bl2 = false;
            if (bl) {
                boolean bl3 = string.regionMatches(false, n2 + 1, this.a, 2, -2 + this.a.length());
                bl2 = false;
                if (bl3) {
                    bl2 = true;
                }
            }
            return bl2;
        }

        public boolean equals(Object object) {
            if (object instanceof b && this.a.equals((Object)((b)object).a) && this.b.equals((Object)((b)object).b) && this.c.equals((Object)((b)object).c)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode();
        }

        public String toString() {
            return this.b + this.c.b();
        }
    }

}

