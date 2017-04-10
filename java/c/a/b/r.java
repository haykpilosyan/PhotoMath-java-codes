/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.d
 *  d.e
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.ref.Reference
 *  java.lang.ref.WeakReference
 *  java.net.ProtocolException
 *  java.net.Socket
 *  java.net.SocketTimeoutException
 *  java.security.cert.CertificateException
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  javax.net.ssl.SSLHandshakeException
 *  javax.net.ssl.SSLPeerUnverifiedException
 */
package c.a.b;

import c.a;
import c.a.b.d;
import c.a.b.e;
import c.a.b.n;
import c.a.b.o;
import c.a.b.p;
import c.a.c;
import c.a.c.b;
import c.a.h;
import c.a.i;
import c.ad;
import c.j;
import c.k;
import d.s;
import d.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class r {
    public final a a;
    private ad b;
    private final j c;
    private p d;
    private b e;
    private boolean f;
    private boolean g;
    private c.a.b.i h;

    public r(j j2, a a2) {
        this.c = j2;
        this.a = a2;
        this.d = new p(a2, this.e());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private b a(int n2, int n3, int n4, boolean bl) throws IOException, o {
        ad ad2;
        j j2;
        j j3;
        j j4 = j2 = this.c;
        // MONITORENTER : j4
        if (this.f) {
            throw new IllegalStateException("released");
        }
        if (this.h != null) {
            throw new IllegalStateException("stream != null");
        }
        if (this.g) {
            throw new IOException("Canceled");
        }
        b b2 = this.e;
        if (b2 != null && !b2.i) {
            // MONITOREXIT : j4
            return b2;
        }
        b b3 = c.b.a(this.c, this.a, this);
        if (b3 != null) {
            this.e = b3;
            // MONITOREXIT : j4
            return b3;
        }
        ad ad3 = this.b;
        // MONITOREXIT : j4
        if (ad3 == null) {
            j j5;
            ad ad4 = this.d.b();
            j j6 = j5 = this.c;
            // MONITORENTER : j6
            this.b = ad4;
            // MONITOREXIT : j6
            ad2 = ad4;
        } else {
            ad2 = ad3;
        }
        b b4 = new b(ad2);
        this.a(b4);
        j j7 = j3 = this.c;
        // MONITORENTER : j7
        c.b.b(this.c, b4);
        this.e = b4;
        if (this.g) {
            throw new IOException("Canceled");
        }
        // MONITOREXIT : j7
        b4.a(n2, n3, n4, this.a.f(), bl);
        this.e().b(b4.a());
        return b4;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void a(boolean var1_1, boolean var2_2, boolean var3_3) {
        var12_5 = var4_4 = this.c;
        // MONITORENTER : var12_5
        if (var3_3) {
            this.h = null;
        }
        if (var2_2) {
            this.f = true;
        }
        var6_6 = this.e;
        var7_7 = null;
        if (var6_6 == null) ** GOTO lbl29
        if (var1_1) {
            this.e.i = true;
        }
        var8_8 = this.h;
        var7_7 = null;
        if (var8_8 != null) ** GOTO lbl29
        if (this.f) ** GOTO lbl-1000
        var11_9 = this.e.i;
        var7_7 = null;
        if (var11_9) lbl-1000: // 2 sources:
        {
            this.b(this.e);
            var9_10 = this.e.h.isEmpty();
            var7_7 = null;
            if (var9_10) {
                this.e.j = System.nanoTime();
                var10_11 = c.b.a(this.c, this.e);
                var7_7 = null;
                if (var10_11) {
                    var7_7 = this.e;
                }
            }
            this.e = null;
        }
lbl29: // 5 sources:
        // MONITOREXIT : var12_5
        if (var7_7 == null) return;
        i.a(var7_7.c());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private b b(int n2, int n3, int n4, boolean bl, boolean bl2) throws IOException, o {
        do {
            j j2;
            b b2 = this.a(n2, n3, n4, bl);
            j j3 = j2 = this.c;
            // MONITORENTER : j3
            if (b2.d == 0) {
                // MONITOREXIT : j3
                return b2;
            }
            // MONITOREXIT : j3
            if (b2.a(bl2)) return b2;
            this.a(new IOException());
        } while (true);
    }

    private void b(b b2) {
        int n2 = b2.h.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            if (((Reference)b2.h.get(i2)).get() != this) continue;
            b2.h.remove(i2);
            return;
        }
        throw new IllegalStateException();
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private boolean b(IOException iOException) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            return iOException instanceof SocketTimeoutException;
        }
        if (iOException instanceof SSLHandshakeException) {
            if (iOException.getCause() instanceof CertificateException) return false;
        }
        if (iOException instanceof SSLPeerUnverifiedException) return false;
        return true;
    }

    private h e() {
        return c.b.a(this.c);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public c.a.b.i a(int n2, int n3, int n4, boolean bl, boolean bl2) throws o, IOException {
        c.a.b.i i22;
        try {
            c.a.b.i i22;
            j j2;
            b b2 = this.b(n2, n3, n4, bl, bl2);
            if (b2.c != null) {
                i22 = new e(this, b2.c);
            } else {
                b2.c().setSoTimeout(n3);
                b2.e.timeout().timeout(n3, TimeUnit.MILLISECONDS);
                b2.f.timeout().timeout(n4, TimeUnit.MILLISECONDS);
                i22 = new d(this, b2.e, b2.f);
            }
            j j3 = j2 = this.c;
            // MONITORENTER : j3
        }
        catch (IOException var6_10) {
            throw new o(var6_10);
        }
        this.h = i22;
        // MONITOREXIT : j3
        return i22;
    }

    public b a() {
        r r2 = this;
        synchronized (r2) {
            b b2 = this.e;
            return b2;
        }
    }

    public void a(b b2) {
        b2.h.add((Object)new WeakReference((Object)this));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(IOException iOException) {
        j j2;
        j j3 = j2 = this.c;
        synchronized (j3) {
            if (this.e != null && this.e.d == 0) {
                if (this.b != null && iOException != null) {
                    this.d.a(this.b, iOException);
                }
                this.b = null;
            }
        }
        this.a(true, false, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl, c.a.b.i i2) {
        j j2;
        j j3 = j2 = this.c;
        synchronized (j3) {
            if (i2 == null || i2 != this.h) {
                throw new IllegalStateException("expected " + this.h + " but was " + i2);
            }
            if (!bl) {
                b b2 = this.e;
                b2.d = 1 + b2.d;
            }
        }
        this.a(bl, false, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(IOException iOException, s s2) {
        boolean bl = true;
        if (this.e != null) {
            this.a(iOException);
        }
        boolean bl2 = s2 == null || s2 instanceof n ? bl : false;
        if (this.d != null) {
            if (!this.d.a()) return false;
        }
        if (!this.b(iOException)) return false;
        if (bl2) return bl;
        return false;
    }

    public void b() {
        this.a(false, true, false);
    }

    public void c() {
        this.a(true, false, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void d() {
        j j2;
        j j3 = j2 = this.c;
        // MONITORENTER : j3
        this.g = true;
        c.a.b.i i2 = this.h;
        b b2 = this.e;
        // MONITOREXIT : j3
        if (i2 != null) {
            i2.a();
            return;
        }
        if (b2 == null) return;
        b2.b();
    }

    public String toString() {
        return this.a.toString();
    }
}

