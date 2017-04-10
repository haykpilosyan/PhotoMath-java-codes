/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.security.cert.TrustAnchor
 *  java.security.cert.X509Certificate
 *  javax.net.ssl.X509TrustManager
 */
package c.a.d;

import c.a.d.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class a
implements f {
    private final X509TrustManager a;
    private final Method b;

    public a(X509TrustManager x509TrustManager, Method method) {
        this.b = method;
        this.a = x509TrustManager;
    }

    public static f a(X509TrustManager x509TrustManager) {
        try {
            Method method = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[]{X509Certificate.class});
            method.setAccessible(true);
            a a2 = new a(x509TrustManager, method);
            return a2;
        }
        catch (NoSuchMethodException var1_3) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public X509Certificate a(X509Certificate x509Certificate) {
        TrustAnchor trustAnchor = (TrustAnchor)this.b.invoke((Object)this.a, new Object[]{x509Certificate});
        if (trustAnchor == null) return null;
        try {
            return trustAnchor.getTrustedCert();
        }
        catch (IllegalAccessException var3_4) {
            throw new AssertionError();
        }
        catch (InvocationTargetException var2_5) {
            return null;
        }
    }
}

