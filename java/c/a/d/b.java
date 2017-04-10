/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.GeneralSecurityException
 *  java.security.Principal
 *  java.security.PublicKey
 *  java.security.cert.Certificate
 *  java.security.cert.X509Certificate
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.List
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package c.a.d;

import c.a.d.f;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class b {
    private final f a;

    public b(f f2) {
        this.a = f2;
    }

    private boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals((Object)x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        }
        catch (GeneralSecurityException var3_3) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public List<Certificate> a(List<Certificate> list) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        int n2 = 0;
        boolean bl = false;
        while (n2 < 9) {
            boolean bl2;
            X509Certificate x509Certificate = (X509Certificate)arrayList.get(-1 + arrayList.size());
            X509Certificate x509Certificate2 = this.a.a(x509Certificate);
            if (x509Certificate2 != null) {
                if (arrayList.size() > 1 || !x509Certificate.equals((Object)x509Certificate2)) {
                    arrayList.add((Object)x509Certificate2);
                }
                if (this.a(x509Certificate2, x509Certificate2)) {
                    return arrayList;
                }
                bl2 = true;
            } else {
                X509Certificate x509Certificate3;
                Iterator iterator = arrayDeque.iterator();
                do {
                    if (iterator.hasNext()) continue;
                    if (!bl) throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + (Object)x509Certificate);
                    return arrayList;
                } while (!this.a(x509Certificate, x509Certificate3 = (X509Certificate)iterator.next()));
                iterator.remove();
                arrayList.add((Object)x509Certificate3);
                bl2 = bl;
            }
            ++n2;
            bl = bl2;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + (Object)arrayList);
    }
}

