/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  java.io.IOException
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.ClassNotFoundException
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchFieldException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.SecurityException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.reflect.Field
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.net.InetSocketAddress
 *  java.net.Socket
 *  java.net.SocketAddress
 *  java.nio.charset.Charset
 *  java.security.cert.X509Certificate
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 *  javax.net.ssl.SSLSocket
 *  javax.net.ssl.SSLSocketFactory
 *  javax.net.ssl.X509TrustManager
 */
package c.a;

import c.a.d.e;
import c.a.f;
import c.a.i;
import c.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class g {
    private static final g a = g.c();

    public static g a() {
        return a;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static <T> T a(Object object, Class<T> class_, String string) {
        T t2;
        for (Class class_2 = object.getClass(); class_2 != Object.class; class_2 = class_2.getSuperclass()) {
            Object object2;
            Field field = class_2.getDeclaredField(string);
            field.setAccessible(true);
            Object object3 = field.get(object);
            if (object3 == null) return null;
            try {
                if (!class_.isInstance(object3)) return null;
                object2 = class_.cast(object3);
            }
            catch (IllegalAccessException var6_8) {
                throw new AssertionError();
            }
            catch (NoSuchFieldException var5_5) {
                continue;
            }
            return (T)object2;
        }
        if (string.equals((Object)"delegate") || (t2 = g.a(object, Object.class, "delegate")) == null) return null;
        return g.a(t2, class_, string);
    }

    /*
     * Enabled aggressive block sorting
     */
    static byte[] a(List<x> list) {
        d.c c2 = new d.c();
        int n2 = list.size();
        int n3 = 0;
        while (n3 < n2) {
            x x2 = (x)((Object)list.get(n3));
            if (x2 != x.a) {
                c2.b(x2.toString().length());
                c2.a(x2.toString());
            }
            ++n3;
        }
        return c2.s();
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static g c() {
        try {
            var10_1 = var20 = Class.forName((String)"com.android.org.conscrypt.SSLParametersImpl");
        }
        catch (ClassNotFoundException var0_8) {
            var10_1 = var9_9 = Class.forName((String)"org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            ** continue;
        }
lbl3: // 2 sources:
        do {
            var11_2 = new Class[]{Boolean.TYPE};
            var12_3 = new f<Socket>(null, "setUseSessionTickets", var11_2);
            var13_4 = new f<Socket>(null, "setHostname", new Class[]{String.class});
            Class.forName((String)"android.net.Network");
            var15_5 = new f<Socket>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            var17_6 = new f<T>(null, "setAlpnProtocols", new Class[]{byte[].class});
            var16_7 = var15_5;
lbl14: // 2 sources:
            do {
                return new a(var10_1, var12_3, var13_4, var16_7, var17_6);
                break;
            } while (true);
            break;
        } while (true);
        catch (ClassNotFoundException var14_10) {
            var15_5 = null;
lbl23: // 2 sources:
            do {
                var16_7 = var15_5;
                var17_6 = null;
                ** continue;
                break;
            } while (true);
        }
        {
            catch (ClassNotFoundException var1_11) {
                try {
                    var4_12 = Class.forName((String)"org.eclipse.jetty.alpn.ALPN");
                    var5_13 = Class.forName((String)("org.eclipse.jetty.alpn.ALPN" + "$Provider"));
                    var6_14 = Class.forName((String)("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider"));
                    var7_15 = Class.forName((String)("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider"));
                    return new b(var4_12.getMethod("put", new Class[]{SSLSocket.class, var5_13}), var4_12.getMethod("get", new Class[]{SSLSocket.class}), var4_12.getMethod("remove", new Class[]{SSLSocket.class}), var6_14, var7_15);
                }
                catch (ClassNotFoundException var3_17) {
                    do {
                        return new g();
                        break;
                    } while (true);
                }
                catch (NoSuchMethodException var2_18) {
                    return new g();
                }
            }
        }
        catch (ClassNotFoundException var19_19) {
            ** continue;
        }
    }

    public c.a.d.f a(X509TrustManager x509TrustManager) {
        return new e(x509TrustManager.getAcceptedIssuers());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
        try {
            T t2 = g.a((Object)sSLSocketFactory, Class.forName((String)"sun.security.ssl.SSLContextImpl"), "context");
            if (t2 != null) return (X509TrustManager)g.a(t2, X509TrustManager.class, "trustManager");
            return null;
        }
        catch (ClassNotFoundException var2_4) {
            return null;
        }
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int n2) throws IOException {
        socket.connect((SocketAddress)inetSocketAddress, n2);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String string, List<x> list) {
    }

    public String b() {
        return "OkHttp";
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    private static class a
    extends g {
        private final Class<?> a;
        private final f<Socket> b;
        private final f<Socket> c;
        private final f<Socket> d;
        private final f<Socket> e;

        public a(Class<?> class_, f<Socket> f2, f<Socket> f3, f<Socket> f4, f<Socket> f5) {
            this.a = class_;
            this.b = f2;
            this.c = f3;
            this.d = f4;
            this.e = f5;
        }

        @Override
        public c.a.d.f a(X509TrustManager x509TrustManager) {
            c.a.d.f f2 = c.a.d.a.a(x509TrustManager);
            if (f2 != null) {
                return f2;
            }
            return super.a(x509TrustManager);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public X509TrustManager a(SSLSocketFactory sSLSocketFactory) {
            Object object;
            X509TrustManager x509TrustManager;
            Object obj = a.a((Object)sSLSocketFactory, this.a, "sslParameters");
            if (obj == null) {
                try {
                    Object t2;
                    object = t2 = a.a((Object)sSLSocketFactory, Class.forName((String)"com.google.android.gms.org.conscrypt.SSLParametersImpl", (boolean)false, (ClassLoader)sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
                }
                catch (ClassNotFoundException var5_6) {
                    return super.a(sSLSocketFactory);
                }
            } else {
                object = obj;
            }
            if ((x509TrustManager = (X509TrustManager)a.a(object, X509TrustManager.class, "x509TrustManager")) != null) {
                return x509TrustManager;
            }
            return (X509TrustManager)a.a(object, X509TrustManager.class, "trustManager");
        }

        @Override
        public void a(Socket socket, InetSocketAddress inetSocketAddress, int n2) throws IOException {
            try {
                socket.connect((SocketAddress)inetSocketAddress, n2);
                return;
            }
            catch (AssertionError var7_4) {
                if (i.a(var7_4)) {
                    throw new IOException((Throwable)var7_4);
                }
                throw var7_4;
            }
            catch (SecurityException var4_5) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause((Throwable)var4_5);
                throw iOException;
            }
        }

        @Override
        public void a(SSLSocket sSLSocket, String string, List<x> list) {
            if (string != null) {
                f<Socket> f2 = this.b;
                Object[] arrobject = new Object[]{true};
                f2.b((Socket)sSLSocket, arrobject);
                this.c.b((Socket)sSLSocket, string);
            }
            if (this.e != null && this.e.a((Socket)sSLSocket)) {
                Object[] arrobject = new Object[]{a.a(list)};
                this.e.d((Socket)sSLSocket, arrobject);
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public String b(SSLSocket sSLSocket) {
            if (this.d == null) {
                return null;
            }
            if (!this.d.a((Socket)sSLSocket)) return null;
            byte[] arrby = (byte[])this.d.d((Socket)sSLSocket, new Object[0]);
            if (arrby == null) return null;
            return new String(arrby, i.c);
        }
    }

    private static class b
    extends g {
        private final Method a;
        private final Method b;
        private final Method c;
        private final Class<?> d;
        private final Class<?> e;

        public b(Method method, Method method2, Method method3, Class<?> class_, Class<?> class_2) {
            this.a = method;
            this.b = method2;
            this.c = method3;
            this.d = class_;
            this.e = class_2;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public void a(SSLSocket sSLSocket) {
            try {
                this.c.invoke((Object)null, new Object[]{sSLSocket});
                return;
            }
            catch (IllegalAccessException var3_2) {
                do {
                    throw new AssertionError();
                    break;
                } while (true);
            }
            catch (InvocationTargetException var2_3) {
                throw new AssertionError();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(SSLSocket sSLSocket, String string, List<x> list) {
            void var7_12;
            ArrayList arrayList = new ArrayList(list.size());
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                x x2 = (x)((Object)list.get(i2));
                if (x2 == x.a) continue;
                arrayList.add((Object)x2.toString());
            }
            try {
                ClassLoader classLoader = g.class.getClassLoader();
                Class[] arrclass = new Class[]{this.d, this.e};
                Object object = Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])arrclass, (InvocationHandler)new c((List<String>)arrayList));
                this.a.invoke((Object)null, new Object[]{sSLSocket, object});
                return;
            }
            catch (IllegalAccessException var7_11) {
                throw new AssertionError((Object)var7_12);
            }
            catch (InvocationTargetException var7_13) {
                throw new AssertionError((Object)var7_12);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public String b(SSLSocket sSLSocket) {
            try {
                c c2 = (c)Proxy.getInvocationHandler((Object)this.b.invoke((Object)null, new Object[]{sSLSocket}));
                if (!c2.b && c2.c == null) {
                    c.a.c.a.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (!c2.b) String string;
                return string = c2.c;
                return null;
            }
            catch (IllegalAccessException var3_5) {
                throw new AssertionError();
            }
            catch (InvocationTargetException var2_6) {
                throw new AssertionError();
            }
        }
    }

    private static class c
    implements InvocationHandler {
        private final List<String> a;
        private boolean b;
        private String c;

        public c(List<String> list) {
            this.a = list;
        }

        public Object invoke(Object object, Method method, Object[] arrobject) throws Throwable {
            String string = method.getName();
            Class class_ = method.getReturnType();
            if (arrobject == null) {
                arrobject = i.b;
            }
            if (string.equals((Object)"supports") && Boolean.TYPE == class_) {
                return true;
            }
            if (string.equals((Object)"unsupported") && Void.TYPE == class_) {
                this.b = true;
                return null;
            }
            if (string.equals((Object)"protocols") && arrobject.length == 0) {
                return this.a;
            }
            if ((string.equals((Object)"selectProtocol") || string.equals((Object)"select")) && String.class == class_ && arrobject.length == 1 && arrobject[0] instanceof List) {
                String string2;
                List list = (List)arrobject[0];
                int n2 = list.size();
                for (int i2 = 0; i2 < n2; ++i2) {
                    String string3;
                    if (!this.a.contains(list.get(i2))) continue;
                    this.c = string3 = (String)list.get(i2);
                    return string3;
                }
                this.c = string2 = (String)this.a.get(0);
                return string2;
            }
            if ((string.equals((Object)"protocolSelected") || string.equals((Object)"selected")) && arrobject.length == 1) {
                this.c = (String)arrobject[0];
                return null;
            }
            return method.invoke((Object)this, arrobject);
        }
    }

}

