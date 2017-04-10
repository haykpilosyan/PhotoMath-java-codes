/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  javax.net.ssl.SSLSocketFactory
 */
package c;

import c.a;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.net.ssl.SSLSocketFactory;

public final class ad {
    final a a;
    final Proxy b;
    final InetSocketAddress c;

    public ad(a a2, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (a2 == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.a = a2;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public a a() {
        return this.a;
    }

    public Proxy b() {
        return this.b;
    }

    public InetSocketAddress c() {
        return this.c;
    }

    public boolean d() {
        if (this.a.i != null && this.b.type() == Proxy.Type.HTTP) {
            return true;
        }
        return false;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof ad;
        boolean bl2 = false;
        if (bl) {
            ad ad2 = (ad)object;
            boolean bl3 = this.a.equals(ad2.a);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.b.equals((Object)ad2.b);
                bl2 = false;
                if (bl4) {
                    boolean bl5 = this.c.equals((Object)ad2.c);
                    bl2 = false;
                    if (bl5) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    public int hashCode() {
        return 31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.c.hashCode();
    }
}

