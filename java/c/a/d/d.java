/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.security.cert.Certificate
 *  java.security.cert.CertificateParsingException
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Locale
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLException
 *  javax.net.ssl.SSLSession
 *  javax.security.auth.x500.X500Principal
 */
package c.a.d;

import c.a.d.c;
import c.a.i;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;

public final class d
implements HostnameVerifier {
    public static final d a = new d();

    private d() {
    }

    public static List<String> a(X509Certificate x509Certificate) {
        List<String> list = d.a(x509Certificate, 7);
        List<String> list2 = d.a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static List<String> a(X509Certificate x509Certificate, int n2) {
        ArrayList arrayList = new ArrayList();
        try {
            Collection collection = x509Certificate.getSubjectAlternativeNames();
            if (collection == null) {
                return Collections.emptyList();
            }
            for (List list : collection) {
                Integer n3;
                String string;
                if (list == null || list.size() < 2 || (n3 = (Integer)list.get(0)) == null || n3 != n2 || (string = (String)list.get(1)) == null) continue;
                arrayList.add((Object)string);
            }
            return arrayList;
        }
        catch (CertificateParsingException var3_8) {
            return Collections.emptyList();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean a(String string, String string2) {
        String string3;
        if (string == null) return false;
        if (string.length() == 0) return false;
        if (string.startsWith(".")) return false;
        if (string.endsWith("..")) {
            return false;
        }
        if (string2 == null) return false;
        if (string2.length() == 0) return false;
        if (string2.startsWith(".")) return false;
        if (string2.endsWith("..")) return false;
        if (!string.endsWith(".")) {
            string = string + '.';
        }
        if (!string2.endsWith(".")) {
            string2 = string2 + '.';
        }
        if (!(string3 = string2.toLowerCase(Locale.US)).contains((CharSequence)"*")) {
            return string.equals((Object)string3);
        }
        if (!string3.startsWith("*.")) return false;
        if (string3.indexOf(42, 1) != -1) return false;
        if (string.length() < string3.length()) return false;
        if ("*.".equals((Object)string3)) return false;
        String string4 = string3.substring(1);
        if (!string.endsWith(string4)) return false;
        int n2 = string.length() - string4.length();
        if (n2 <= 0) return true;
        if (string.lastIndexOf(46, n2 - 1) != -1) return false;
        return true;
    }

    private boolean b(String string, X509Certificate x509Certificate) {
        List<String> list = d.a(x509Certificate, 7);
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!string.equalsIgnoreCase((String)list.get(i2))) continue;
            return true;
        }
        return false;
    }

    private boolean c(String string, X509Certificate x509Certificate) {
        String string2;
        String string3 = string.toLowerCase(Locale.US);
        List<String> list = d.a(x509Certificate, 2);
        int n2 = list.size();
        boolean bl = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (this.a(string3, (String)list.get(i2))) {
                return true;
            }
            bl = true;
        }
        if (!bl && (string2 = new c(x509Certificate.getSubjectX500Principal()).a("cn")) != null) {
            return this.a(string3, string2);
        }
        return false;
    }

    public boolean a(String string, X509Certificate x509Certificate) {
        if (i.b(string)) {
            return this.b(string, x509Certificate);
        }
        return this.c(string, x509Certificate);
    }

    public boolean verify(String string, SSLSession sSLSession) {
        try {
            boolean bl = this.a(string, (X509Certificate)sSLSession.getPeerCertificates()[0]);
            return bl;
        }
        catch (SSLException var3_4) {
            return false;
        }
    }
}

