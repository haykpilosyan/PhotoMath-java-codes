/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.BufferedInputStream
 *  java.io.BufferedOutputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.HttpURLConnection
 *  java.net.InetSocketAddress
 *  java.net.MalformedURLException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.net.SocketAddress
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.URL
 *  java.net.URLConnection
 *  java.nio.ByteBuffer
 *  java.nio.CharBuffer
 *  java.nio.charset.Charset
 *  java.nio.charset.CharsetEncoder
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.concurrent.Callable
 *  java.util.zip.GZIPInputStream
 */
package b.a.a.a.a.e;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.GZIPInputStream;

public class d {
    private static final String[] b = new String[0];
    private static b c = b.a;
    public final URL a;
    private HttpURLConnection d = null;
    private final String e;
    private e f;
    private boolean g;
    private boolean h = true;
    private boolean i = false;
    private int j = 8192;
    private String k;
    private int l;

    public d(CharSequence charSequence, String string) throws c {
        try {
            this.a = new URL(charSequence.toString());
        }
        catch (MalformedURLException var3_3) {
            throw new c((IOException)var3_3);
        }
        this.e = string;
    }

    public static d a(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = d.a(charSequence, map);
        if (bl) {
            string = d.a(string);
        }
        return d.b(string);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(CharSequence charSequence) throws c {
        URL uRL;
        try {
            uRL = new URL(charSequence.toString());
        }
        catch (IOException iOException) {
            throw new c(iOException);
        }
        String string2 = uRL.getHost();
        int n3 = uRL.getPort();
        if (n3 != -1) {
            string2 = string2 + ':' + Integer.toString((int)n3);
        }
        try {
            String string = new URI(uRL.getProtocol(), string2, uRL.getPath(), uRL.getQuery(), null).toASCIIString();
            int n2 = string.indexOf(63);
            if (n2 <= 0) return string;
            if (n2 + 1 >= string.length()) return string;
            String string3 = string.substring(0, n2 + 1) + string.substring(n2 + 1).replace((CharSequence)"+", (CharSequence)"%2B");
            return string3;
        }
        catch (URISyntaxException var4_8) {
            IOException iOException = new IOException("Parsing URI failed");
            iOException.initCause((Throwable)var4_8);
            throw new c(iOException);
        }
    }

    public static String a(CharSequence charSequence, Map<?, ?> map) {
        String string = charSequence.toString();
        if (map == null || map.isEmpty()) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder(string);
        d.a(string, stringBuilder);
        d.b(string, stringBuilder);
        Iterator iterator = map.entrySet().iterator();
        Map.Entry entry = (Map.Entry)iterator.next();
        stringBuilder.append(entry.getKey().toString());
        stringBuilder.append('=');
        Object object = entry.getValue();
        if (object != null) {
            stringBuilder.append(object);
        }
        while (iterator.hasNext()) {
            stringBuilder.append('&');
            Map.Entry entry2 = (Map.Entry)iterator.next();
            stringBuilder.append(entry2.getKey().toString());
            stringBuilder.append('=');
            Object object2 = entry2.getValue();
            if (object2 == null) continue;
            stringBuilder.append(object2);
        }
        return stringBuilder.toString();
    }

    private static StringBuilder a(String string, StringBuilder stringBuilder) {
        if (2 + string.indexOf(58) == string.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    public static d b(CharSequence charSequence) throws c {
        return new d(charSequence, "GET");
    }

    public static d b(CharSequence charSequence, Map<?, ?> map, boolean bl) {
        String string = d.a(charSequence, map);
        if (bl) {
            string = d.a(string);
        }
        return d.c(string);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static StringBuilder b(String string, StringBuilder stringBuilder) {
        int n2 = string.indexOf(63);
        int n3 = -1 + stringBuilder.length();
        if (n2 == -1) {
            stringBuilder.append('?');
            return stringBuilder;
        } else {
            if (n2 >= n3 || string.charAt(n3) == '&') return stringBuilder;
            {
                stringBuilder.append('&');
                return stringBuilder;
            }
        }
    }

    public static d c(CharSequence charSequence) throws c {
        return new d(charSequence, "POST");
    }

    public static d d(CharSequence charSequence) throws c {
        return new d(charSequence, "PUT");
    }

    public static d e(CharSequence charSequence) throws c {
        return new d(charSequence, "DELETE");
    }

    private static String f(String string) {
        if (string != null && string.length() > 0) {
            return string;
        }
        return "UTF-8";
    }

    private Proxy q() {
        return new Proxy(Proxy.Type.HTTP, (SocketAddress)new InetSocketAddress(this.k, this.l));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private HttpURLConnection r() {
        try {
            HttpURLConnection httpURLConnection;
            HttpURLConnection httpURLConnection2 = this.k != null ? c.a(this.a, this.q()) : (httpURLConnection = c.a(this.a));
            httpURLConnection2.setRequestMethod(this.e);
            return httpURLConnection2;
        }
        catch (IOException var1_3) {
            throw new c(var1_3);
        }
    }

    public int a(String string, int n2) throws c {
        this.l();
        return this.a().getHeaderFieldInt(string, n2);
    }

    public d a(int n2) {
        this.a().setConnectTimeout(n2);
        return this;
    }

    protected d a(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        return (d)new a<d>((Closeable)inputStream, this.h){

            public d a() throws IOException {
                int n2;
                byte[] arrby = new byte[d.this.j];
                while ((n2 = inputStream.read(arrby)) != -1) {
                    outputStream.write(arrby, 0, n2);
                }
                return d.this;
            }

            @Override
            public /* synthetic */ Object b() throws c, IOException {
                return this.a();
            }
        }.call();
    }

    public d a(String string, Number number) throws c {
        return this.a(string, null, number);
    }

    public d a(String string, String string2) {
        this.a().setRequestProperty(string, string2);
        return this;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public d a(String string, String string2, Number number) throws c {
        String string3;
        if (number != null) {
            string3 = number.toString();
            do {
                return this.b(string, string2, string3);
                break;
            } while (true);
        }
        string3 = null;
        return this.b(string, string2, string3);
    }

    protected d a(String string, String string2, String string3) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"").append(string);
        if (string2 != null) {
            stringBuilder.append("\"; filename=\"").append(string2);
        }
        stringBuilder.append('\"');
        this.f("Content-Disposition", stringBuilder.toString());
        if (string3 != null) {
            this.f("Content-Type", string3);
        }
        return this.f("\r\n");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public d a(String var1_1, String var2_2, String var3_3, File var4_4) throws c {
        var5_5 = new BufferedInputStream((InputStream)new FileInputStream(var4_4));
        var9_6 = this.a(var1_1, var2_2, var3_3, (InputStream)var5_5);
        if (var5_5 == null) return var9_6;
        var5_5.close();
        return var9_6;
        {
            catch (IOException var10_13) {
                return var9_6;
            }
        }
        catch (IOException var6_7) {
            var5_5 = null;
            ** GOTO lbl17
            catch (Throwable var7_12) {
                var5_5 = null;
                ** GOTO lbl-1000
            }
lbl17: // 2 sources:
            do {
                try {
                    throw new c((IOException)var6_8);
                }
                catch (Throwable var7_10) lbl-1000: // 2 sources:
                {
                    if (var5_5 == null) throw var7_11;
                    try {
                        var5_5.close();
                    }
                    catch (IOException var8_14) {
                        throw var7_11;
                    }
                    throw var7_11;
                }
                break;
            } while (true);
        }
        catch (IOException var6_9) {
            ** continue;
        }
    }

    public d a(String string, String string2, String string3, InputStream inputStream) throws c {
        try {
            this.n();
            this.a(string, string2, string3);
            this.a(inputStream, (OutputStream)this.f);
            return this;
        }
        catch (IOException var5_5) {
            throw new c(var5_5);
        }
    }

    public d a(String string, String string2, String string3, String string4) throws c {
        try {
            this.n();
            this.a(string, string2, string3);
            this.f.a(string4);
            return this;
        }
        catch (IOException var5_5) {
            throw new c(var5_5);
        }
    }

    public d a(Map.Entry<String, String> entry) {
        return this.a((String)entry.getKey(), (String)entry.getValue());
    }

    public d a(boolean bl) {
        this.a().setUseCaches(bl);
        return this;
    }

    public String a(String string) throws c {
        ByteArrayOutputStream byteArrayOutputStream = this.d();
        try {
            this.a((InputStream)this.f(), (OutputStream)byteArrayOutputStream);
            String string2 = byteArrayOutputStream.toString(d.f(string));
            return string2;
        }
        catch (IOException var3_4) {
            throw new c(var3_4);
        }
    }

    public HttpURLConnection a() {
        if (this.d == null) {
            this.d = this.r();
        }
        return this.d;
    }

    public int b() throws c {
        try {
            this.k();
            int n2 = this.a().getResponseCode();
            return n2;
        }
        catch (IOException var1_2) {
            throw new c(var1_2);
        }
    }

    public d b(String string, String string2, String string3) throws c {
        return this.a(string, string2, null, string3);
    }

    public String b(String string) throws c {
        this.l();
        return this.a().getHeaderField(string);
    }

    public String b(String string, String string2) {
        return this.c(this.b(string), string2);
    }

    public int c(String string) throws c {
        return this.a(string, -1);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected String c(String string, String string2) {
        int n2;
        int n3;
        if (string == null) return null;
        if (string.length() == 0) {
            return null;
        }
        int n4 = string.length();
        int n5 = 1 + string.indexOf(59);
        if (n5 == 0) return null;
        if (n5 == n4) {
            return null;
        }
        int n6 = string.indexOf(59, n5);
        if (n6 == -1) {
            n3 = n5;
            n2 = n4;
        } else {
            n3 = n5;
            n2 = n6;
        }
        while (n3 < n2) {
            String string3;
            int n7;
            int n8 = string.indexOf(61, n3);
            if (n8 != -1 && n8 < n2 && string2.equals((Object)string.substring(n3, n8).trim()) && (n7 = (string3 = string.substring(n8 + 1, n2).trim()).length()) != 0) {
                if (n7 <= 2) return string3;
                if ('\"' != string3.charAt(0)) return string3;
                if ('\"' != string3.charAt(n7 - 1)) return string3;
                return string3.substring(1, n7 - 1);
            }
            int n9 = n2 + 1;
            int n10 = string.indexOf(59, n9);
            if (n10 == -1) {
                n10 = n4;
            }
            int n11 = n10;
            n3 = n9;
            n2 = n11;
        }
        return null;
    }

    public boolean c() throws c {
        if (200 == this.b()) {
            return true;
        }
        return false;
    }

    public d d(String string) {
        return this.d(string, null);
    }

    public d d(String string, String string2) {
        if (string2 != null && string2.length() > 0) {
            return this.a("Content-Type", string + "; charset=" + string2);
        }
        return this.a("Content-Type", string);
    }

    protected ByteArrayOutputStream d() {
        int n2 = this.j();
        if (n2 > 0) {
            return new ByteArrayOutputStream(n2);
        }
        return new ByteArrayOutputStream();
    }

    public d e(String string, String string2) {
        return this.b(string, null, string2);
    }

    public String e() throws c {
        return this.a(this.h());
    }

    public d f(CharSequence charSequence) throws c {
        try {
            this.m();
            this.f.a(charSequence.toString());
            return this;
        }
        catch (IOException var2_2) {
            throw new c(var2_2);
        }
    }

    public d f(String string, String string2) throws c {
        return this.f(string).f(": ").f(string2).f("\r\n");
    }

    public BufferedInputStream f() throws c {
        return new BufferedInputStream(this.g(), this.j);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public InputStream g() throws c {
        if (this.b() < 400) {
            try {
                var1_2 = var7_1 = this.a().getInputStream();
            }
            catch (IOException var6_3) {
                throw new c(var6_3);
            }
        } else {
            var1_2 = this.a().getErrorStream();
            if (var1_2 == null) {
                var1_2 = var3_4 = this.a().getInputStream();
            }
        }
        if (this.i == false) return var1_2;
        if (!"gzip".equals((Object)this.i())) {
            return var1_2;
        }
        ** GOTO lbl17
        catch (IOException var2_5) {
            throw new c(var2_5);
        }
lbl17: // 1 sources:
        try {
            return new GZIPInputStream(var1_2);
        }
        catch (IOException var5_7) {
            throw new c(var5_7);
        }
    }

    public String h() {
        return this.b("Content-Type", "charset");
    }

    public String i() {
        return this.b("Content-Encoding");
    }

    public int j() {
        return this.c("Content-Length");
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected d k() throws IOException {
        if (this.f == null) {
            return this;
        }
        if (this.g) {
            this.f.a("\r\n--00content0boundary00--\r\n");
        }
        if (this.h) {
            this.f.close();
            ** GOTO lbl12
        } else {
            this.f.close();
        }
        ** GOTO lbl12
        catch (IOException var1_1) {}
lbl12: // 3 sources:
        this.f = null;
        return this;
    }

    protected d l() throws c {
        try {
            d d2 = this.k();
            return d2;
        }
        catch (IOException var1_2) {
            throw new c(var1_2);
        }
    }

    protected d m() throws IOException {
        if (this.f != null) {
            return this;
        }
        this.a().setDoOutput(true);
        String string = this.c(this.a().getRequestProperty("Content-Type"), "charset");
        this.f = new e(this.a().getOutputStream(), string, this.j);
        return this;
    }

    protected d n() throws IOException {
        if (!this.g) {
            this.g = true;
            this.d("multipart/form-data; boundary=00content0boundary00").m();
            this.f.a("--00content0boundary00\r\n");
            return this;
        }
        this.f.a("\r\n--00content0boundary00\r\n");
        return this;
    }

    public URL o() {
        return this.a().getURL();
    }

    public String p() {
        return this.a().getRequestMethod();
    }

    public String toString() {
        return this.p() + ' ' + (Object)this.o();
    }

    protected static abstract class a<V>
    extends d<V> {
        private final Closeable a;
        private final boolean b;

        protected a(Closeable closeable, boolean bl) {
            this.a = closeable;
            this.b = bl;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        protected void c() throws IOException {
            if (this.a instanceof Flushable) {
                ((Flushable)this.a).flush();
            }
            if (!this.b) {
                this.a.close();
                return;
            }
            try {
                this.a.close();
                return;
            }
            catch (IOException iOException) {
                return;
            }
        }
    }

    public static interface b {
        public static final b a = new b(){

            @Override
            public HttpURLConnection a(URL uRL) throws IOException {
                return (HttpURLConnection)uRL.openConnection();
            }

            @Override
            public HttpURLConnection a(URL uRL, Proxy proxy) throws IOException {
                return (HttpURLConnection)uRL.openConnection(proxy);
            }
        };

        public HttpURLConnection a(URL var1) throws IOException;

        public HttpURLConnection a(URL var1, Proxy var2) throws IOException;

    }

    public static class c
    extends RuntimeException {
        protected c(IOException iOException) {
            super((Throwable)iOException);
        }

        public IOException a() {
            return (IOException)super.getCause();
        }

        public /* synthetic */ Throwable getCause() {
            return this.a();
        }
    }

    protected static abstract class d<V>
    implements Callable<V> {
        protected d() {
        }

        protected abstract V b() throws c, IOException;

        protected abstract void c() throws IOException;

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public V call() throws c {
            var1_1 = true;
            var6_2 = this.b();
            try {
                this.c();
            }
            catch (IOException var7_3) {
                throw new c(var7_3);
            }
            return var6_2;
            catch (c var5_4) {
                throw var5_4;
                {
                    catch (Throwable var2_5) {}
                }
                catch (IOException var4_8) {
                    throw new c(var4_8);
                    ** GOTO lbl-1000
                    catch (Throwable var2_7) {
                        var1_1 = false;
                    }
lbl-1000: // 2 sources:
                    {
                        try {
                            this.c();
                        }
                        catch (IOException var3_9) {
                            if (var1_1 != false) throw var2_6;
                            throw new c(var3_9);
                        }
                        throw var2_6;
                    }
                }
            }
        }
    }

    public static class e
    extends BufferedOutputStream {
        private final CharsetEncoder a;

        public e(OutputStream outputStream, String string, int n2) {
            super(outputStream, n2);
            this.a = Charset.forName((String)d.f(string)).newEncoder();
        }

        public e a(String string) throws IOException {
            ByteBuffer byteBuffer = this.a.encode(CharBuffer.wrap((CharSequence)string));
            super.write(byteBuffer.array(), 0, byteBuffer.limit());
            return this;
        }
    }

}

