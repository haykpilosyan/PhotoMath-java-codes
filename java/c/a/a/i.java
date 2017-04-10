/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  d.e
 *  d.f
 *  java.io.IOException
 *  java.lang.Byte
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 *  java.util.List
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package c.a.a;

import c.a.a.b;
import c.a.a.f;
import c.a.a.g;
import c.a.a.h;
import c.a.a.n;
import c.a.a.p;
import d.e;
import d.t;
import d.u;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class i
implements p {
    private static final Logger a = Logger.getLogger((String)b.class.getName());
    private static final d.f b = d.f.a((String)"PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    private static int b(int n2, byte by, short s2) throws IOException {
        if ((by & 8) != 0) {
            --n2;
        }
        if (s2 > n2) {
            Object[] arrobject = new Object[]{s2, n2};
            throw i.d("PROTOCOL_ERROR padding %s > remaining length %s", arrobject);
        }
        return (short)(n2 - s2);
    }

    private static int b(e e2) throws IOException {
        return (255 & e2.i()) << 16 | (255 & e2.i()) << 8 | 255 & e2.i();
    }

    private static void b(d.d d2, int n2) throws IOException {
        d2.i(255 & n2 >>> 16);
        d2.i(255 & n2 >>> 8);
        d2.i(n2 & 255);
    }

    private static /* varargs */ IllegalArgumentException c(String string, Object ... arrobject) {
        throw new IllegalArgumentException(String.format((String)string, (Object[])arrobject));
    }

    private static /* varargs */ IOException d(String string, Object ... arrobject) throws IOException {
        throw new IOException(String.format((String)string, (Object[])arrobject));
    }

    @Override
    public c.a.a.b a(e e2, boolean bl) {
        return new c(e2, 4096, bl);
    }

    @Override
    public c.a.a.c a(d.d d2, boolean bl) {
        return new d(d2, bl);
    }

    static final class a
    implements t {
        int a;
        byte b;
        int c;
        int d;
        short e;
        private final e f;

        public a(e e2) {
            this.f = e2;
        }

        private void a() throws IOException {
            int n2;
            int n3 = this.c;
            this.d = n2 = i.b(this.f);
            this.a = n2;
            byte by = (byte)(255 & this.f.i());
            this.b = (byte)(255 & this.f.i());
            if (a.isLoggable(Level.FINE)) {
                a.fine(b.a(true, this.c, this.a, by, this.b));
            }
            this.c = Integer.MAX_VALUE & this.f.k();
            if (by != 9) {
                Object[] arrobject = new Object[]{Byte.valueOf((byte)by)};
                throw i.d("%s != TYPE_CONTINUATION", arrobject);
            }
            if (this.c != n3) {
                throw i.d("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override
        public void close() throws IOException {
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public long read(d.c c2, long l2) throws IOException {
            while (this.d == 0) {
                this.f.g((long)this.e);
                this.e = 0;
                if ((4 & this.b) != 0) return -1;
                {
                    this.a();
                    continue;
                }
            }
            long l3 = this.f.read(c2, Math.min((long)l2, (long)this.d));
            if (l3 == -1) {
                return -1;
            }
            this.d = (int)((long)this.d - l3);
            return l3;
        }

        @Override
        public u timeout() {
            return this.f.timeout();
        }
    }

    static final class b {
        private static final String[] a = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        private static final String[] b = new String[64];
        private static final String[] c = new String[256];

        static {
            for (int i2 = 0; i2 < c.length; ++i2) {
                String[] arrstring = c;
                Object[] arrobject = new Object[]{Integer.toBinaryString((int)i2)};
                arrstring[i2] = String.format((String)"%8s", (Object[])arrobject).replace(' ', '0');
            }
            b.b[0] = "";
            b.b[1] = "END_STREAM";
            int[] arrn = new int[]{1};
            b.b[8] = "PADDED";
            int n2 = arrn.length;
            for (int i3 = 0; i3 < n2; ++i3) {
                int n3 = arrn[i3];
                b.b[n3 | 8] = b[n3] + "|PADDED";
            }
            b.b[4] = "END_HEADERS";
            b.b[32] = "PRIORITY";
            b.b[36] = "END_HEADERS|PRIORITY";
            int[] arrn2 = new int[]{4, 32, 36};
            int n4 = arrn2.length;
            int n5 = 0;
            do {
                if (n5 >= n4) break;
                int n6 = arrn2[n5];
                for (int n7 : arrn) {
                    b.b[n7 | n6] = b[n7] + '|' + b[n6];
                    b.b[8 | (n7 | n6)] = b[n7] + '|' + b[n6] + "|PADDED";
                }
                ++n5;
            } while (true);
            for (int i4 = 0; i4 < b.length; ++i4) {
                if (b[i4] != null) continue;
                b.b[i4] = c[i4];
            }
        }

        b() {
        }

        /*
         * Enabled aggressive block sorting
         */
        static String a(byte by, byte by2) {
            String string;
            if (by2 == 0) {
                return "";
            }
            switch (by) {
                default: {
                    string = by2 < b.length ? b[by2] : c[by2];
                }
                case 4: 
                case 6: {
                    if (by2 != 1) return c[by2];
                    return "ACK";
                }
                case 2: 
                case 3: 
                case 7: 
                case 8: {
                    return c[by2];
                }
            }
            if (by == 5 && (by2 & 4) != 0) {
                return string.replace((CharSequence)"HEADERS", (CharSequence)"PUSH_PROMISE");
            }
            if (by != 0) return string;
            if ((by2 & 32) == 0) return string;
            return string.replace((CharSequence)"PRIORITY", (CharSequence)"COMPRESSED");
        }

        /*
         * Enabled aggressive block sorting
         */
        static String a(boolean bl, int n2, int n3, byte by, byte by2) {
            String string;
            if (by < a.length) {
                string = a[by];
            } else {
                Object[] arrobject = new Object[]{Byte.valueOf((byte)by)};
                string = String.format((String)"0x%02x", (Object[])arrobject);
            }
            String string2 = b.a(by, by2);
            Object[] arrobject = new Object[5];
            String string3 = bl ? "<<" : ">>";
            arrobject[0] = string3;
            arrobject[1] = n2;
            arrobject[2] = n3;
            arrobject[3] = string;
            arrobject[4] = string2;
            return String.format((String)"%s 0x%08x %5d %-13s %s", (Object[])arrobject);
        }
    }

    static final class c
    implements c.a.a.b {
        final h.a a;
        private final e b;
        private final a c;
        private final boolean d;

        c(e e2, int n2, boolean bl) {
            this.b = e2;
            this.d = bl;
            this.c = new a(this.b);
            this.a = new h.a(n2, this.c);
        }

        private List<f> a(int n2, short s2, byte by, int n3) throws IOException {
            a a2 = this.c;
            this.c.d = n2;
            a2.a = n2;
            this.c.e = s2;
            this.c.b = by;
            this.c.c = n3;
            this.a.a();
            return this.a.b();
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(b.a a2, int n2) throws IOException {
            int n3 = this.b.k();
            boolean bl = (Integer.MIN_VALUE & n3) != 0;
            a2.a(n2, n3 & Integer.MAX_VALUE, 1 + (255 & this.b.i()), bl);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n3 == 0) {
                throw i.d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean bl = (by & 1) != 0;
            short s2 = (by & 8) != 0 ? (short)(255 & this.b.i()) : 0;
            if ((by & 32) != 0) {
                this.a(a2, n3);
                n2 -= 5;
            }
            a2.a(false, bl, n3, -1, this.a(i.b(n2, by, s2), s2, by, n3), g.d);
        }

        /*
         * Enabled aggressive block sorting
         */
        private void b(b.a a2, int n2, byte by, int n3) throws IOException {
            boolean bl = true;
            boolean bl2 = (by & 1) != 0 ? bl : false;
            if ((by & 32) == 0) {
                bl = false;
            }
            if (bl) {
                throw i.d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            int n4 = by & 8;
            short s2 = 0;
            if (n4 != 0) {
                s2 = (short)(255 & this.b.i());
            }
            int n5 = i.b(n2, by, s2);
            a2.a(bl2, n3, this.b, n5);
            this.b.g((long)s2);
        }

        private void c(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 != 5) {
                Object[] arrobject = new Object[]{n2};
                throw i.d("TYPE_PRIORITY length: %d != 5", arrobject);
            }
            if (n3 == 0) {
                throw i.d("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            this.a(a2, n3);
        }

        private void d(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 != 4) {
                Object[] arrobject = new Object[]{n2};
                throw i.d("TYPE_RST_STREAM length: %d != 4", arrobject);
            }
            if (n3 == 0) {
                throw i.d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int n4 = this.b.k();
            c.a.a.a a3 = c.a.a.a.b(n4);
            if (a3 == null) {
                Object[] arrobject = new Object[]{n4};
                throw i.d("TYPE_RST_STREAM unexpected error code: %d", arrobject);
            }
            a2.a(n3, a3);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private void e(b.a var1_1, int var2_2, byte var3_3, int var4_4) throws IOException {
            if (var4_4 != 0) {
                throw i.a("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((var3_3 & 1) != 0) {
                if (var2_2 != 0) {
                    throw i.a("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                var1_1.a();
                return;
            }
            if (var2_2 % 6 != 0) {
                var11_5 = new Object[]{var2_2};
                throw i.a("TYPE_SETTINGS length %% 6 != 0: %s", var11_5);
            }
            var5_6 = new n();
            var6_7 = 0;
            do {
                if (var6_7 >= var2_2) {
                    var1_1.a(false, var5_6);
                    if (var5_6.c() < 0) return;
                    this.a.a(var5_6.c());
                    return;
                }
                var7_8 = this.b.j();
                var8_9 = this.b.k();
                switch (var7_8) {
                    case 2: {
                        if (var8_9 != 0 && var8_9 != 1) {
                            throw i.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                        ** GOTO lbl28
                    }
                    case 3: {
                        var7_8 = 4;
                    }
lbl28: // 3 sources:
                    default: {
                        ** GOTO lbl39
                    }
                    case 4: {
                        var7_8 = 7;
                        if (var8_9 < 0) {
                            throw i.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                        ** GOTO lbl39
                    }
                    case 5: 
                }
                if (var8_9 < 16384 || var8_9 > 16777215) {
                    var9_10 = new Object[]{var8_9};
                    throw i.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", var9_10);
                }
lbl39: // 4 sources:
                var5_6.a(var7_8, 0, var8_9);
                var6_7 += 6;
            } while (true);
        }

        private void f(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n3 == 0) {
                throw i.d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            int n4 = by & 8;
            short s2 = 0;
            if (n4 != 0) {
                s2 = (short)(255 & this.b.i());
            }
            a2.a(n3, Integer.MAX_VALUE & this.b.k(), this.a(i.b(n2 - 4, by, s2), s2, by, n3));
        }

        /*
         * Enabled aggressive block sorting
         */
        private void g(b.a a2, int n2, byte by, int n3) throws IOException {
            boolean bl = true;
            if (n2 != 8) {
                Object[] arrobject = new Object[bl];
                arrobject[0] = n2;
                throw i.d("TYPE_PING length != 8: %s", arrobject);
            }
            if (n3 != 0) {
                throw i.d("TYPE_PING streamId != 0", new Object[0]);
            }
            int n4 = this.b.k();
            int n5 = this.b.k();
            if ((by & 1) == 0) {
                bl = false;
            }
            a2.a(bl, n4, n5);
        }

        private void h(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 < 8) {
                Object[] arrobject = new Object[]{n2};
                throw i.d("TYPE_GOAWAY length < 8: %s", arrobject);
            }
            if (n3 != 0) {
                throw i.d("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int n4 = this.b.k();
            int n5 = this.b.k();
            int n6 = n2 - 8;
            c.a.a.a a3 = c.a.a.a.b(n5);
            if (a3 == null) {
                Object[] arrobject = new Object[]{n5};
                throw i.d("TYPE_GOAWAY unexpected error code: %d", arrobject);
            }
            d.f f2 = d.f.b;
            if (n6 > 0) {
                f2 = this.b.c((long)n6);
            }
            a2.a(n4, a3, f2);
        }

        private void i(b.a a2, int n2, byte by, int n3) throws IOException {
            if (n2 != 4) {
                Object[] arrobject = new Object[]{n2};
                throw i.d("TYPE_WINDOW_UPDATE length !=4: %s", arrobject);
            }
            long l2 = Integer.MAX_VALUE & (long)this.b.k();
            if (l2 == 0) {
                Object[] arrobject = new Object[]{l2};
                throw i.d("windowSizeIncrement was 0", arrobject);
            }
            a2.a(n3, l2);
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public void a() throws IOException {
            if (this.d) {
                return;
            }
            d.f f2 = this.b.c((long)b.f());
            if (a.isLoggable(Level.FINE)) {
                Logger logger = a;
                Object[] arrobject = new Object[]{f2.d()};
                logger.fine(String.format((String)"<< CONNECTION %s", (Object[])arrobject));
            }
            if (b.equals((Object)f2)) return;
            Object[] arrobject = new Object[]{f2.a()};
            throw i.d("Expected a connection header but was %s", arrobject);
        }

        @Override
        public boolean a(b.a a2) throws IOException {
            try {
                this.b.a(9);
            }
            catch (IOException var2_4) {
                return false;
            }
            int n2 = i.b(this.b);
            if (n2 < 0 || n2 > 16384) {
                Object[] arrobject = new Object[]{n2};
                throw i.d("FRAME_SIZE_ERROR: %s", arrobject);
            }
            byte by = (byte)(255 & this.b.i());
            byte by2 = (byte)(255 & this.b.i());
            int n3 = Integer.MAX_VALUE & this.b.k();
            if (a.isLoggable(Level.FINE)) {
                a.fine(b.a(true, n3, n2, by, by2));
            }
            switch (by) {
                default: {
                    this.b.g((long)n2);
                    return true;
                }
                case 0: {
                    this.b(a2, n2, by2, n3);
                    return true;
                }
                case 1: {
                    this.a(a2, n2, by2, n3);
                    return true;
                }
                case 2: {
                    this.c(a2, n2, by2, n3);
                    return true;
                }
                case 3: {
                    this.d(a2, n2, by2, n3);
                    return true;
                }
                case 4: {
                    this.e(a2, n2, by2, n3);
                    return true;
                }
                case 5: {
                    this.f(a2, n2, by2, n3);
                    return true;
                }
                case 6: {
                    this.g(a2, n2, by2, n3);
                    return true;
                }
                case 7: {
                    this.h(a2, n2, by2, n3);
                    return true;
                }
                case 8: 
            }
            this.i(a2, n2, by2, n3);
            return true;
        }

        public void close() throws IOException {
            this.b.close();
        }
    }

    static final class d
    implements c.a.a.c {
        private final d.d a;
        private final boolean b;
        private final d.c c;
        private final h.b d;
        private int e;
        private boolean f;

        d(d.d d2, boolean bl) {
            this.a = d2;
            this.b = bl;
            this.c = new d.c();
            this.d = new h.b(this.c);
            this.e = 16384;
        }

        /*
         * Enabled aggressive block sorting
         */
        private void b(int n2, long l2) throws IOException {
            while (l2 > 0) {
                int n3;
                byte by = (l2 -= (long)(n3 = (int)Math.min((long)this.e, (long)l2))) == 0 ? 4 : 0;
                this.a(n2, n3, 9, by);
                this.a.write(this.c, (long)n3);
            }
            return;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a() throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                boolean bl = this.b;
                if (bl) {
                    if (a.isLoggable(Level.FINE)) {
                        Logger logger = a;
                        Object[] arrobject = new Object[]{b.d()};
                        logger.fine(String.format((String)">> CONNECTION %s", (Object[])arrobject));
                    }
                    this.a.c(b.g());
                    this.a.flush();
                }
                return;
            }
        }

        void a(int n2, byte by, d.c c2, int n3) throws IOException {
            this.a(n2, n3, 0, by);
            if (n3 > 0) {
                this.a.write(c2, (long)n3);
            }
        }

        void a(int n2, int n3, byte by, byte by2) throws IOException {
            if (a.isLoggable(Level.FINE)) {
                a.fine(b.a(false, n2, n3, by, by2));
            }
            if (n3 > this.e) {
                Object[] arrobject = new Object[]{this.e, n3};
                throw i.c("FRAME_SIZE_ERROR length > %d: %d", arrobject);
            }
            if ((Integer.MIN_VALUE & n2) != 0) {
                Object[] arrobject = new Object[]{n2};
                throw i.c("reserved bit set: %s", arrobject);
            }
            i.b(this.a, n3);
            this.a.i(by & 255);
            this.a.i(by2 & 255);
            this.a.g(Integer.MAX_VALUE & n2);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, int n3, List<f> list) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                this.d.a(list);
                long l2 = this.c.a();
                int n4 = (int)Math.min((long)(-4 + this.e), (long)l2);
                byte by = l2 == (long)n4 ? 4 : 0;
                this.a(n2, n4 + 4, 5, by);
                this.a.g(Integer.MAX_VALUE & n3);
                this.a.write(this.c, (long)n4);
                if (l2 > (long)n4) {
                    this.b(n2, l2 - (long)n4);
                }
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, long l2) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                if (l2 != 0 && l2 <= Integer.MAX_VALUE) {
                    this.a(n2, 4, 8, 0);
                    this.a.g((int)l2);
                    this.a.flush();
                    return;
                }
                Object[] arrobject = new Object[]{l2};
                throw i.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", arrobject);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(int n2, c.a.a.a a2) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                if (a2.s == -1) {
                    throw new IllegalArgumentException();
                }
                this.a(n2, 4, 3, 0);
                this.a.g(a2.s);
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
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                if (a2.s == -1) {
                    throw i.c("errorCode.httpCode == -1", new Object[0]);
                }
                this.a(0, 8 + arrby.length, 7, 0);
                this.a.g(n2);
                this.a.g(a2.s);
                if (arrby.length > 0) {
                    this.a.c(arrby);
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
        public void a(n n2) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                this.e = n2.e(this.e);
                this.a(0, 0, 4, 1);
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
        public void a(boolean bl, int n2, int n3) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                byte by = 0;
                if (bl) {
                    by = 1;
                }
                this.a(0, 8, 6, by);
                this.a.g(n2);
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
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                byte by = 0;
                if (bl) {
                    by = 1;
                }
                this.a(n2, by, c2, n3);
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        void a(boolean bl, int n2, List<f> list) throws IOException {
            if (this.f) {
                throw new IOException("closed");
            }
            this.d.a(list);
            long l2 = this.c.a();
            int n3 = (int)Math.min((long)this.e, (long)l2);
            byte by = l2 == (long)n3 ? 4 : 0;
            if (bl) {
                by = (byte)(by | 1);
            }
            this.a(n2, n3, 1, by);
            this.a.write(this.c, (long)n3);
            if (l2 > (long)n3) {
                this.b(n2, l2 - (long)n3);
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void a(boolean bl, boolean bl2, int n2, int n3, List<f> list) throws IOException {
            d d2 = this;
            synchronized (d2) {
                if (bl2) {
                    throw new UnsupportedOperationException();
                }
                if (this.f) {
                    throw new IOException("closed");
                }
                this.a(bl, n2, list);
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
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
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
            int n3 = 0;
            d d2 = this;
            synchronized (d2) {
                if (this.f) {
                    throw new IOException("closed");
                }
                this.a(0, 6 * n2.b(), 4, 0);
                do {
                    if (n3 >= 10) {
                        this.a.flush();
                        return;
                    }
                    if (n2.a(n3)) {
                        int n4 = n3 == 4 ? 3 : (n3 == 7 ? 4 : n3);
                        this.a.h(n4);
                        this.a.g(n2.b(n3));
                    }
                    ++n3;
                } while (true);
            }
        }

        @Override
        public int c() {
            return this.e;
        }

        public void close() throws IOException {
            d d2 = this;
            synchronized (d2) {
                this.f = true;
                this.a.close();
                return;
            }
        }
    }

}

