/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.security.GeneralSecurityException
 *  java.security.PublicKey
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.LinkedList
 *  javax.security.auth.x500.X500Principal
 */
package b.a.a.a.a.e;

import b.a.a.a.a.e.i;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.LinkedList;
import javax.security.auth.x500.X500Principal;

final class a {
    private static boolean a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getSubjectX500Principal().equals((Object)x509Certificate2.getIssuerX500Principal())) {
            return false;
        }
        try {
            x509Certificate2.verify(x509Certificate.getPublicKey());
            return true;
        }
        catch (GeneralSecurityException var2_2) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static X509Certificate[] a(X509Certificate[] arrx509Certificate, i i2) throws CertificateException {
        X509Certificate x509Certificate;
        int n2;
        int n3 = 1;
        LinkedList linkedList = new LinkedList();
        int n4 = i2.a(arrx509Certificate[0]) ? n3 : 0;
        linkedList.add((Object)arrx509Certificate[0]);
        int n5 = n4;
        for (n2 = n3; n2 < arrx509Certificate.length; ++n2) {
            if (i2.a(arrx509Certificate[n2])) {
                n5 = n3;
            }
            if (!a.a(arrx509Certificate[n2], arrx509Certificate[n2 - 1])) break;
            linkedList.add((Object)arrx509Certificate[n2]);
        }
        if ((x509Certificate = i2.b(arrx509Certificate[n2 - 1])) != null) {
            linkedList.add((Object)x509Certificate);
        } else {
            n3 = n5;
        }
        if (n3 != 0) {
            return (X509Certificate[])linkedList.toArray((Object[])new X509Certificate[linkedList.size()]);
        }
        throw new CertificateException("Didn't find a trust anchor in chain cleanup!");
    }
}

