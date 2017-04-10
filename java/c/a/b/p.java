/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.InetAddress
 *  java.net.InetSocketAddress
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.ProxySelector
 *  java.net.SocketAddress
 *  java.net.SocketException
 *  java.net.URI
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.NoSuchElementException
 */
package c.a.b;

import c.a;
import c.a.h;
import c.ad;
import c.o;
import c.s;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public final class p {
    private final a a;
    private final h b;
    private Proxy c;
    private InetSocketAddress d;
    private List<Proxy> e = Collections.emptyList();
    private int f;
    private List<InetSocketAddress> g = Collections.emptyList();
    private int h;
    private final List<ad> i = new ArrayList();

    public p(a a2, h h2) {
        this.a = a2;
        this.b = h2;
        this.a(a2.a(), a2.h());
    }

    static String a(InetSocketAddress inetSocketAddress) {
        InetAddress inetAddress = inetSocketAddress.getAddress();
        if (inetAddress == null) {
            return inetSocketAddress.getHostName();
        }
        return inetAddress.getHostAddress();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(s s2, Proxy proxy) {
        if (proxy != null) {
            this.e = Collections.singletonList((Object)proxy);
        } else {
            this.e = new ArrayList();
            List list = this.a.g().select(s2.a());
            if (list != null) {
                this.e.addAll((Collection)list);
            }
            this.e.removeAll((Collection)Collections.singleton((Object)Proxy.NO_PROXY));
            this.e.add((Object)Proxy.NO_PROXY);
        }
        this.f = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(Proxy proxy) throws IOException {
        String string;
        int n2;
        this.g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            String string2 = this.a.a().f();
            n2 = this.a.a().g();
            string = string2;
        } else {
            SocketAddress socketAddress = proxy.address();
            if (!(socketAddress instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + (Object)socketAddress.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
            String string3 = p.a(inetSocketAddress);
            n2 = inetSocketAddress.getPort();
            string = string3;
        }
        if (n2 < 1 || n2 > 65535) {
            throw new SocketException("No route to " + string + ":" + n2 + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.g.add((Object)InetSocketAddress.createUnresolved((String)string, (int)n2));
        } else {
            List<InetAddress> list = this.a.b().a(string);
            int n3 = list.size();
            for (int i2 = 0; i2 < n3; ++i2) {
                InetAddress inetAddress = (InetAddress)list.get(i2);
                this.g.add((Object)new InetSocketAddress(inetAddress, n2));
            }
        }
        this.h = 0;
    }

    private boolean c() {
        if (this.f < this.e.size()) {
            return true;
        }
        return false;
    }

    private Proxy d() throws IOException {
        if (!this.c()) {
            throw new SocketException("No route to " + this.a.a().f() + "; exhausted proxy configurations: " + this.e);
        }
        List<Proxy> list = this.e;
        int n2 = this.f;
        this.f = n2 + 1;
        Proxy proxy = (Proxy)list.get(n2);
        this.a(proxy);
        return proxy;
    }

    private boolean e() {
        if (this.h < this.g.size()) {
            return true;
        }
        return false;
    }

    private InetSocketAddress f() throws IOException {
        if (!this.e()) {
            throw new SocketException("No route to " + this.a.a().f() + "; exhausted inet socket addresses: " + this.g);
        }
        List<InetSocketAddress> list = this.g;
        int n2 = this.h;
        this.h = n2 + 1;
        return (InetSocketAddress)list.get(n2);
    }

    private boolean g() {
        if (!this.i.isEmpty()) {
            return true;
        }
        return false;
    }

    private ad h() {
        return (ad)this.i.remove(0);
    }

    public void a(ad ad2, IOException iOException) {
        if (ad2.b().type() != Proxy.Type.DIRECT && this.a.g() != null) {
            this.a.g().connectFailed(this.a.a().a(), ad2.b().address(), iOException);
        }
        this.b.a(ad2);
    }

    public boolean a() {
        if (this.e() || this.c() || this.g()) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ad b() throws IOException {
        if (!this.e()) {
            if (!this.c()) {
                if (this.g()) return this.h();
                throw new NoSuchElementException();
            }
            this.c = this.d();
        }
        this.d = this.f();
        ad ad2 = new ad(this.a, this.c, this.d);
        if (!this.b.c(ad2)) return ad2;
        this.i.add((Object)ad2);
        return this.b();
    }
}

