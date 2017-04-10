/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.Proxy
 *  java.net.ProxySelector
 *  java.util.List
 *  javax.net.SocketFactory
 *  javax.net.ssl.HostnameVerifier
 *  javax.net.ssl.SSLSocketFactory
 */
package c;

import c.a.i;
import c.b;
import c.g;
import c.k;
import c.o;
import c.s;
import c.x;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class a {
    final s a;
    final o b;
    final SocketFactory c;
    final b d;
    final List<x> e;
    final List<k> f;
    final ProxySelector g;
    final Proxy h;
    final SSLSocketFactory i;
    final HostnameVerifier j;
    final g k;

    /*
     * Enabled aggressive block sorting
     */
    public a(String string, int n2, o o2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g g2, b b2, Proxy proxy, List<x> list, List<k> list2, ProxySelector proxySelector) {
        s.a a2 = new s.a();
        String string2 = sSLSocketFactory != null ? "https" : "http";
        this.a = a2.a(string2).b(string).a(n2).c();
        if (o2 == null) {
            throw new IllegalArgumentException("dns == null");
        }
        this.b = o2;
        if (socketFactory == null) {
            throw new IllegalArgumentException("socketFactory == null");
        }
        this.c = socketFactory;
        if (b2 == null) {
            throw new IllegalArgumentException("proxyAuthenticator == null");
        }
        this.d = b2;
        if (list == null) {
            throw new IllegalArgumentException("protocols == null");
        }
        this.e = i.a(list);
        if (list2 == null) {
            throw new IllegalArgumentException("connectionSpecs == null");
        }
        this.f = i.a(list2);
        if (proxySelector == null) {
            throw new IllegalArgumentException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = g2;
    }

    public s a() {
        return this.a;
    }

    public o b() {
        return this.b;
    }

    public SocketFactory c() {
        return this.c;
    }

    public b d() {
        return this.d;
    }

    public List<x> e() {
        return this.e;
    }

    public boolean equals(Object object) {
        boolean bl = object instanceof a;
        boolean bl2 = false;
        if (bl) {
            a a2 = (a)object;
            boolean bl3 = this.a.equals(a2.a);
            bl2 = false;
            if (bl3) {
                boolean bl4 = this.b.equals((Object)a2.b);
                bl2 = false;
                if (bl4) {
                    boolean bl5 = this.d.equals((Object)a2.d);
                    bl2 = false;
                    if (bl5) {
                        boolean bl6 = this.e.equals(a2.e);
                        bl2 = false;
                        if (bl6) {
                            boolean bl7 = this.f.equals(a2.f);
                            bl2 = false;
                            if (bl7) {
                                boolean bl8 = this.g.equals((Object)a2.g);
                                bl2 = false;
                                if (bl8) {
                                    boolean bl9 = i.a((Object)this.h, (Object)a2.h);
                                    bl2 = false;
                                    if (bl9) {
                                        boolean bl10 = i.a((Object)this.i, (Object)a2.i);
                                        bl2 = false;
                                        if (bl10) {
                                            boolean bl11 = i.a((Object)this.j, (Object)a2.j);
                                            bl2 = false;
                                            if (bl11) {
                                                boolean bl12 = i.a(this.k, a2.k);
                                                bl2 = false;
                                                if (bl12) {
                                                    bl2 = true;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public List<k> f() {
        return this.f;
    }

    public ProxySelector g() {
        return this.g;
    }

    public Proxy h() {
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (31 * (527 + this.a.hashCode()) + this.b.hashCode()) + this.d.hashCode()) + this.e.hashCode()) + this.f.hashCode()) + this.g.hashCode());
        int n3 = this.h != null ? this.h.hashCode() : 0;
        int n4 = 31 * (n3 + n2);
        int n5 = this.i != null ? this.i.hashCode() : 0;
        int n6 = 31 * (n5 + n4);
        int n7 = this.j != null ? this.j.hashCode() : 0;
        int n8 = 31 * (n7 + n6);
        g g2 = this.k;
        int n9 = 0;
        if (g2 != null) {
            n9 = this.k.hashCode();
        }
        return n8 + n9;
    }

    public SSLSocketFactory i() {
        return this.i;
    }

    public HostnameVerifier j() {
        return this.j;
    }

    public g k() {
        return this.k;
    }
}

