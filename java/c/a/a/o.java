/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  d.e
 *  d.f
 *  d.g
 *  d.m
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.UnsupportedEncodingException
 *  java.lang.AssertionError
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.ProtocolException
 *  java.nio.charset.Charset
 *  java.util.List
 *  java.util.zip.Deflater
 */
package c.a.a;

import c.a.a.b;
import c.a.a.c;
import c.a.a.f;
import c.a.a.g;
import c.a.a.k;
import c.a.a.n;
import c.a.a.p;
import c.a.i;
import d.d;
import d.e;
import d.m;
import d.s;
import d.t;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.zip.Deflater;

public final class o
implements p {
    static final byte[] a;

    static {
        try {
            a = "\u0000\u0000\u0000\u0007options\u0000\u0000\u0000\u0004head\u0000\u0000\u0000\u0004post\u0000\u0000\u0000\u0003put\u0000\u0000\u0000\u0006delete\u0000\u0000\u0000\u0005trace\u0000\u0000\u0000\u0006accept\u0000\u0000\u0000\u000eaccept-charset\u0000\u0000\u0000\u000faccept-encoding\u0000\u0000\u0000\u000faccept-language\u0000\u0000\u0000\raccept-ranges\u0000\u0000\u0000\u0003age\u0000\u0000\u0000\u0005allow\u0000\u0000\u0000\rauthorization\u0000\u0000\u0000\rcache-control\u0000\u0000\u0000\nconnection\u0000\u0000\u0000\fcontent-base\u0000\u0000\u0000\u0010content-encoding\u0000\u0000\u0000\u0010content-language\u0000\u0000\u0000\u000econtent-length\u0000\u0000\u0000\u0010content-location\u0000\u0000\u0000\u000bcontent-md5\u0000\u0000\u0000\rcontent-range\u0000\u0000\u0000\fcontent-type\u0000\u0000\u0000\u0004date\u0000\u0000\u0000\u0004etag\u0000\u0000\u0000\u0006expect\u0000\u0000\u0000\u0007expires\u0000\u0000\u0000\u0004from\u0000\u0000\u0000\u0004host\u0000\u0000\u0000\bif-match\u0000\u0000\u0000\u0011if-modified-since\u0000\u0000\u0000\rif-none-match\u0000\u0000\u0000\bif-range\u0000\u0000\u0000\u0013if-unmodified-since\u0000\u0000\u0000\rlast-modified\u0000\u0000\u0000\blocation\u0000\u0000\u0000\fmax-forwards\u0000\u0000\u0000\u0006pragma\u0000\u0000\u0000\u0012proxy-authenticate\u0000\u0000\u0000\u0013proxy-authorization\u0000\u0000\u0000\u0005range\u0000\u0000\u0000\u0007referer\u0000\u0000\u0000\u000bretry-after\u0000\u0000\u0000\u0006server\u0000\u0000\u0000\u0002te\u0000\u0000\u0000\u0007trailer\u0000\u0000\u0000\u0011transfer-encoding\u0000\u0000\u0000\u0007upgrade\u0000\u0000\u0000\nuser-agent\u0000\u0000\u0000\u0004vary\u0000\u0000\u0000\u0003via\u0000\u0000\u0000\u0007warning\u0000\u0000\u0000\u0010www-authenticate\u0000\u0000\u0000\u0006method\u0000\u0000\u0000\u0003get\u0000\u0000\u0000\u0006status\u0000\u0000\u0000\u0006200 OK\u0000\u0000\u0000\u0007version\u0000\u0000\u0000\bHTTP/1.1\u0000\u0000\u0000\u0003url\u0000\u0000\u0000\u0006public\u0000\u0000\u0000\nset-cookie\u0000\u0000\u0000\nkeep-alive\u0000\u0000\u0000\u0006origin100101201202205206300302303304305306307402405406407408409410411412413414415416417502504505203 Non-Authoritative Information204 No Content301 Moved Permanently400 Bad Request401 Unauthorized403 Forbidden404 Not Found500 Internal Server Error501 Not Implemented503 Service UnavailableJan Feb Mar Apr May Jun Jul Aug Sept Oct Nov Dec 00:00:00 Mon, Tue, Wed, Thu, Fri, Sat, Sun, GMTchunked,text/html,image/png,image/jpg,image/gif,application/xml,application/xhtml+xml,text/plain,text/javascript,publicprivatemax-age=gzip,deflate,sdchcharset=utf-8charset=iso-8859-1,utf-,*,enq=0.".getBytes(i.c.name());
            return;
        }
        catch (UnsupportedEncodingException var0) {
            throw new AssertionError();
        }
    }

    @Override
    public c.a.a.b a(e e2, boolean bl) {
        return new a(e2, bl);
    }

    @Override
    public c a(d d2, boolean bl) {
        return new b(d2, bl);
    }

    static final class a
    implements c.a.a.b {
        private final e a;
        private final boolean b;
        private final k c;

        a(e e2, boolean bl) {
            this.a = e2;
            this.c = new k(this.a);
            this.b = bl;
        }

        private static /* varargs */ IOException a(String string, Object ... arrobject) throws IOException {
            throw new IOException(String.format((String)string, (Object[])arrobject));
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(b.a a2, int n2, int n3) throws IOException {
            boolean bl = true;
            int n4 = this.a.k();
            int n5 = this.a.k();
            int n6 = n4 & Integer.MAX_VALUE;
            int n7 = n5 & Integer.MAX_VALUE;
            this.a.j();
            List<f> list = this.c.a(n3 - 10);
            boolean bl2 = (n2 & 1) != 0 ? bl : false;
            if ((n2 & 2) == 0) {
                bl = false;
            }
            a2.a(bl, bl2, n6, n7, list, g.a);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void b(b.a a2, int n2, int n3) throws IOException {
            int n4 = Integer.MAX_VALUE & this.a.k();
            List<f> list = this.c.a(n3 - 4);
            boolean bl = (n2 & 1) != 0;
            a2.a(false, bl, n4, -1, list, g.b);
        }

        private void c(b.a a2, int n2, int n3) throws IOException {
            if (n3 != 8) {
                Object[] arrobject = new Object[]{n3};
                throw a.a("TYPE_RST_STREAM length: %d != 8", arrobject);
            }
            int n4 = Integer.MAX_VALUE & this.a.k();
            int n5 = this.a.k();
            c.a.a.a a3 = c.a.a.a.a(n5);
            if (a3 == null) {
                Object[] arrobject = new Object[]{n5};
                throw a.a("TYPE_RST_STREAM unexpected error code: %d", arrobject);
            }
            a2.a(n4, a3);
        }

        private void d(b.a a2, int n2, int n3) throws IOException {
            a2.a(false, false, Integer.MAX_VALUE & this.a.k(), -1, this.c.a(n3 - 4), g.c);
        }

        private void e(b.a a2, int n2, int n3) throws IOException {
            if (n3 != 8) {
                Object[] arrobject = new Object[]{n3};
                throw a.a("TYPE_WINDOW_UPDATE length: %d != 8", arrobject);
            }
            int n4 = this.a.k();
            int n5 = this.a.k();
            int n6 = n4 & Integer.MAX_VALUE;
            long l2 = n5 & Integer.MAX_VALUE;
            if (l2 == 0) {
                Object[] arrobject = new Object[]{l2};
                throw a.a("windowSizeIncrement was 0", arrobject);
            }
            a2.a(n6, l2);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void f(b.a a2, int n2, int n3) throws IOException {
            int n4 = 1;
            if (n3 != 4) {
                Object[] arrobject = new Object[n4];
                arrobject[0] = n3;
                throw a.a("TYPE_PING length: %d != 4", arrobject);
            }
            int n5 = this.a.k();
            int n6 = this.b;
            int n7 = (n5 & 1) == n4 ? n4 : 0;
            if (n6 != n7) {
                n4 = 0;
            }
            a2.a((boolean)n4, n5, 0);
        }

        private void g(b.a a2, int n2, int n3) throws IOException {
            if (n3 != 8) {
                Object[] arrobject = new Object[]{n3};
                throw a.a("TYPE_GOAWAY length: %d != 8", arrobject);
            }
            int n4 = Integer.MAX_VALUE & this.a.k();
            int n5 = this.a.k();
            c.a.a.a a3 = c.a.a.a.c(n5);
            if (a3 == null) {
                Object[] arrobject = new Object[]{n5};
                throw a.a("TYPE_GOAWAY unexpected error code: %d", arrobject);
            }
            a2.a(n4, a3, d.f.b);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void h(b.a a2, int n2, int n3) throws IOException {
            boolean bl = true;
            int n4 = this.a.k();
            if (n3 != 4 + n4 * 8) {
                Object[] arrobject = new Object[2];
                arrobject[0] = n3;
                arrobject[bl] = n4;
                throw a.a("TYPE_SETTINGS length: %d != 4 + 8 * %d", arrobject);
            }
            n n5 = new n();
            for (int i2 = 0; i2 < n4; ++i2) {
                int n6 = this.a.k();
                int n7 = this.a.k();
                int n8 = (-16777216 & n6) >>> 24;
                n5.a(n6 & 16777215, n8, n7);
            }
            if ((n2 & 1) == 0) {
                bl = false;
            }
            a2.a(bl, n5);
        }

        @Override
        public void a() {
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        public boolean a(b.a var1_1) throws IOException {
            try {
                var3_2 = this.a.k();
                var4_3 = this.a.k();
            }
            catch (IOException var2_9) {
                return false;
            }
            var5_4 = (Integer.MIN_VALUE & var3_2) != 0;
            var6_5 = (-16777216 & var4_3) >>> 24;
            var7_6 = var4_3 & 16777215;
            if (!var5_4) ** GOTO lbl43
            var11_7 = (2147418112 & var3_2) >>> 16;
            var12_8 = 65535 & var3_2;
            if (var11_7 != 3) {
                throw new ProtocolException("version != 3: " + var11_7);
            }
            switch (var12_8) {
                default: {
                    this.a.g((long)var7_6);
                    return true;
                }
                case 1: {
                    this.a(var1_1, var6_5, var7_6);
                    return true;
                }
                case 2: {
                    this.b(var1_1, var6_5, var7_6);
                    return true;
                }
                case 3: {
                    this.c(var1_1, var6_5, var7_6);
                    return true;
                }
                case 4: {
                    this.h(var1_1, var6_5, var7_6);
                    return true;
                }
                case 6: {
                    this.f(var1_1, var6_5, var7_6);
                    return true;
                }
                case 7: {
                    this.g(var1_1, var6_5, var7_6);
                    return true;
                }
                case 8: {
                    this.d(var1_1, var6_5, var7_6);
                    return true;
                }
                case 9: 
            }
            this.e(var1_1, var6_5, var7_6);
            return true;
lbl43: // 1 sources:
            var8_10 = Integer.MAX_VALUE & var3_2;
            var9_11 = var6_5 & 1;
            var10_12 = false;
            if (var9_11 != 0) {
                var10_12 = true;
            }
            var1_1.a(var10_12, var8_10, this.a, var7_6);
            return true;
        }

        public void close() throws IOException {
            this.c.a();
        }
    }

    static final class b
    implements c {
        private final d a;
        private final d.c b;
        private final d c;
        private final boolean d;
        private boolean e;

        b(d d2, boolean bl) {
            this.a = d2;
            this.d = bl;
            Deflater deflater = new Deflater();
            deflater.setDictionary(o.a);
            this.b = new d.c();
            this.c = m.a((s)new d.g((s)this.b, deflater));
        }

        private void a(List<f> list) throws IOException {
            this.c.g(list.size());
            int n2 = list.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                d.f f2 = ((f)list.get((int)i2)).h;
                this.c.g(f2.f());
                this.c.b(f2);
                d.f f3 = ((f)list.get((int)i2)).i;
                this.c.g(f3.f());
                this.c.b(f3);
            }
            this.c.flush();
        }

        /*
         * Enabled aggressive block sorting
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void a() {
            b b2 = this;
            // MONITORENTER : b2
            // MONITOREXIT : b2
        }

        void a(int n2, int n3, d.c c2, int n4) throws IOException {
            if (this.e) {
                throw new IOException("closed");
            }
            if ((long)n4 > 0xFFFFFF) {
                throw new IllegalArgumentException("FRAME_TOO_LARGE max size is 16Mib: " + n4);
            }
            this.a.g(Integer.MAX_VALUE & n2);
            this.a.g((n3 & 255) << 24 | 16777215 & n4);
            if (n4 > 0) {
                this.a.write(c2, (long)n4);
            }
        }

        @Override
        public void a(int n2, int n3, List<f> list) throws IOException {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, long l2) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                if (l2 != 0 && l2 <= Integer.MAX_VALUE) {
                    this.a.g(-2147287031);
                    this.a.g(8);
                    this.a.g(n2);
                    this.a.g((int)l2);
                    this.a.flush();
                    return;
                }
                throw new IllegalArgumentException("windowSizeIncrement must be between 1 and 0x7fffffff: " + l2);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, c.a.a.a a2) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                if (a2.t == -1) {
                    throw new IllegalArgumentException();
                }
                this.a.g(-2147287037);
                this.a.g(8);
                this.a.g(Integer.MAX_VALUE & n2);
                this.a.g(a2.t);
                this.a.flush();
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, c.a.a.a a2, byte[] arrby) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                if (a2.u == -1) {
                    throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
                }
                this.a.g(-2147287033);
                this.a.g(8);
                this.a.g(n2);
                this.a.g(a2.u);
                this.a.flush();
                return;
            }
        }

        @Override
        public void a(n n2) {
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(boolean n2, int n3, int n4) throws IOException {
            int n5 = 1;
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                int n6 = this.d;
                int n7 = (n3 & 1) == n5 ? n5 : 0;
                if (n6 == n7) {
                    n5 = 0;
                }
                if (n2 != n5) {
                    throw new IllegalArgumentException("payload != reply");
                }
                this.a.g(-2147287034);
                this.a.g(4);
                this.a.g(n3);
                this.a.flush();
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(boolean bl, int n2, d.c c2, int n3) throws IOException {
            b b2 = this;
            synchronized (b2) {
                int n4 = bl ? 1 : 0;
                this.a(n2, n4, c2, n3);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(boolean bl, boolean bl2, int n2, int n3, List<f> list) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                this.a(list);
                int n4 = (int)(10 + this.b.a());
                int n5 = bl ? 1 : 0;
                int n6 = 0;
                if (bl2) {
                    n6 = 2;
                }
                int n7 = n6 | n5;
                this.a.g(-2147287039);
                this.a.g((n7 & 255) << 24 | n4 & 16777215);
                this.a.g(n2 & Integer.MAX_VALUE);
                this.a.g(n3 & Integer.MAX_VALUE);
                this.a.h(0);
                this.a.a((t)this.b);
                this.a.flush();
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void b() throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                this.a.flush();
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void b(n n2) throws IOException {
            b b2 = this;
            synchronized (b2) {
                if (this.e) {
                    throw new IOException("closed");
                }
                int n3 = n2.b();
                int n4 = 4 + n3 * 8;
                this.a.g(-2147287036);
                this.a.g(0 | n4 & 16777215);
                this.a.g(n3);
                int n5 = 0;
                do {
                    if (n5 > 10) {
                        this.a.flush();
                        return;
                    }
                    if (n2.a(n5)) {
                        int n6 = n2.c(n5);
                        this.a.g((n6 & 255) << 24 | n5 & 16777215);
                        this.a.g(n2.b(n5));
                    }
                    ++n5;
                } while (true);
            }
        }

        @Override
        public int c() {
            return 16383;
        }

        public void close() throws IOException {
            b b2 = this;
            synchronized (b2) {
                this.e = true;
                i.a((Closeable)this.a, (Closeable)this.c);
                return;
            }
        }
    }

}

