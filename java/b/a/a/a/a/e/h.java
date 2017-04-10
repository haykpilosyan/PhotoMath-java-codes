/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.security.KeyStore
 *  java.security.KeyStoreException
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.security.PublicKey
 *  java.security.cert.CertificateException
 *  java.security.cert.X509Certificate
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Set
 *  javax.net.ssl.TrustManager
 *  javax.net.ssl.TrustManagerFactory
 *  javax.net.ssl.X509TrustManager
 */
package b.a.a.a.a.e;

import b.a.a.a.a.e.a;
import b.a.a.a.a.e.g;
import b.a.a.a.a.e.i;
import b.a.a.a.c;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

class h
implements X509TrustManager {
    private static final X509Certificate[] a = new X509Certificate[0];
    private final TrustManager[] b;
    private final i c;
    private final long d;
    private final List<byte[]> e = new LinkedList();
    private final Set<X509Certificate> f = Collections.synchronizedSet((Set)new HashSet());

    public h(i i2, g g2) {
        this.b = this.a(i2);
        this.c = i2;
        this.d = g2.d();
        for (String string : g2.c()) {
            this.e.add((Object)this.a(string));
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(X509Certificate[] arrx509Certificate) throws CertificateException {
        if (this.d != -1 && System.currentTimeMillis() - this.d > 15552000000L) {
            c.h().d("Fabric", "Certificate pins are stale, (" + (System.currentTimeMillis() - this.d) + " millis vs " + 15552000000L + " millis) falling back to system trust.");
            return;
        } else {
            X509Certificate[] arrx509Certificate2 = a.a(arrx509Certificate, this.c);
            int n2 = arrx509Certificate2.length;
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    throw new CertificateException("No valid pins found in chain!");
                }
                if (this.a(arrx509Certificate2[n3])) return;
                ++n3;
            } while (true);
        }
    }

    private void a(X509Certificate[] arrx509Certificate, String string) throws CertificateException {
        TrustManager[] arrtrustManager = this.b;
        int n2 = arrtrustManager.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            ((X509TrustManager)arrtrustManager[i2]).checkServerTrusted(arrx509Certificate, string);
        }
    }

    private boolean a(X509Certificate x509Certificate) throws CertificateException {
        try {
            byte[] arrby = MessageDigest.getInstance((String)"SHA1").digest(x509Certificate.getPublicKey().getEncoded());
            Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                boolean bl = Arrays.equals((byte[])((byte[])iterator.next()), (byte[])arrby);
                if (!bl) continue;
                return true;
            }
            return false;
        }
        catch (NoSuchAlgorithmException var2_5) {
            throw new CertificateException((Throwable)var2_5);
        }
    }

    private byte[] a(String string) {
        int n2 = string.length();
        byte[] arrby = new byte[n2 / 2];
        for (int i2 = 0; i2 < n2; i2 += 2) {
            arrby[i2 / 2] = (byte)((Character.digit((char)string.charAt(i2), (int)16) << 4) + Character.digit((char)string.charAt(i2 + 1), (int)16));
        }
        return arrby;
    }

    private TrustManager[] a(i i2) {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance((String)"X509");
            trustManagerFactory.init(i2.a);
            TrustManager[] arrtrustManager = trustManagerFactory.getTrustManagers();
            return arrtrustManager;
        }
        catch (NoSuchAlgorithmException var3_4) {
            throw new AssertionError((Object)var3_4);
        }
        catch (KeyStoreException var2_5) {
            throw new AssertionError((Object)var2_5);
        }
    }

    public void checkClientTrusted(X509Certificate[] arrx509Certificate, String string) throws CertificateException {
        throw new CertificateException("Client certificates not supported!");
    }

    public void checkServerTrusted(X509Certificate[] arrx509Certificate, String string) throws CertificateException {
        if (this.f.contains((Object)arrx509Certificate[0])) {
            return;
        }
        this.a(arrx509Certificate, string);
        this.a(arrx509Certificate);
        this.f.add((Object)arrx509Certificate[0]);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return a;
    }
}

