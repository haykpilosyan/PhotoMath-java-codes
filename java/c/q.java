/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.Certificate
 *  java.util.Collections
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLSession
 */
package c;

import c.a.i;
import c.ae;
import c.h;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class q {
    private final ae a;
    private final h b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private q(ae ae2, h h2, List<Certificate> list, List<Certificate> list2) {
        this.a = ae2;
        this.b = h2;
        this.c = list;
        this.d = list2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static q a(SSLSession sSLSession) {
        List<Certificate> list;
        Certificate[] arrcertificate;
        String string = sSLSession.getCipherSuite();
        if (string == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        h h2 = h.a(string);
        String string2 = sSLSession.getProtocol();
        if (string2 == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        ae ae2 = ae.a(string2);
        try {
            Certificate[] arrcertificate2;
            arrcertificate = arrcertificate2 = sSLSession.getPeerCertificates();
        }
        catch (SSLPeerUnverifiedException var5_10) {
            arrcertificate = null;
        }
        List<Certificate> list2 = arrcertificate != null ? i.a(arrcertificate) : Collections.emptyList();
        Certificate[] arrcertificate3 = sSLSession.getLocalCertificates();
        if (arrcertificate3 != null) {
            list = i.a(arrcertificate3);
            return new q(ae2, h2, list2, list);
        }
        list = Collections.emptyList();
        return new q(ae2, h2, list2, list);
    }

    public h a() {
        return this.b;
    }

    public List<Certificate> b() {
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof q)) {
            return false;
        }
        q q2 = (q)object;
        if (!i.a((Object)this.b, (Object)q2.b)) return false;
        if (!this.b.equals((Object)q2.b)) return false;
        if (!this.c.equals(q2.c)) return false;
        if (!this.d.equals(q2.d)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int hashCode() {
        int n2;
        if (this.a != null) {
            n2 = this.a.hashCode();
            do {
                return 31 * (31 * (31 * (n2 + 527) + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode();
                break;
            } while (true);
        }
        n2 = 0;
        return 31 * (31 * (31 * (n2 + 527) + this.b.hashCode()) + this.c.hashCode()) + this.d.hashCode();
    }
}

