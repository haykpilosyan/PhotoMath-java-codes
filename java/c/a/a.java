/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.UnknownServiceException
 *  java.security.cert.CertificateException
 *  java.util.Arrays
 *  java.util.List
 *  javax.net.ssl.SSLHandshakeException
 *  javax.net.ssl.SSLPeerUnverifiedException
 *  javax.net.ssl.SSLProtocolException
 *  javax.net.ssl.SSLSocket
 */
package c.a;

import c.a.c;
import c.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class a {
    private final List<k> a;
    private int b = 0;
    private boolean c;
    private boolean d;

    public a(List<k> list) {
        this.a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i2 = this.b; i2 < this.a.size(); ++i2) {
            if (!((k)this.a.get(i2)).a(sSLSocket)) continue;
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public k a(SSLSocket var1_1) throws IOException {
        var2_2 = this.b;
        var3_3 = this.a.size();
        for (var4_4 = var2_2; var4_4 < var3_3; ++var4_4) {
            var5_5 = (k)this.a.get(var4_4);
            if (!var5_5.a(var1_1)) continue;
            this.b = var4_4 + 1;
lbl7: // 2 sources:
            if (var5_5 == null) {
                throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + Arrays.toString((Object[])var1_1.getEnabledProtocols()));
            }
            this.c = this.b(var1_1);
            c.b.a(var5_5, var1_1, this.d);
            return var5_5;
        }
        var5_5 = null;
        ** GOTO lbl7
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(IOException iOException) {
        this.d = true;
        if (!this.c || iOException instanceof ProtocolException || iOException instanceof InterruptedIOException || iOException instanceof SSLHandshakeException && iOException.getCause() instanceof CertificateException || iOException instanceof SSLPeerUnverifiedException || !(iOException instanceof SSLHandshakeException) && !(iOException instanceof SSLProtocolException)) {
            return false;
        }
        return true;
    }
}

