/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.d
 *  d.e
 *  d.j
 *  d.m
 *  java.io.EOFException
 *  java.io.IOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.net.ProtocolException
 *  java.net.Proxy
 *  java.net.Proxy$Type
 *  java.util.concurrent.TimeUnit
 */
package c.a.b;

import c.a.b.g;
import c.a.b.j;
import c.a.b.k;
import c.a.b.m;
import c.a.b.n;
import c.a.b.q;
import c.a.b.r;
import c.ab;
import c.ac;
import c.ad;
import c.i;
import c.r;
import c.x;
import c.z;
import d.s;
import d.t;
import d.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;

public final class d
implements c.a.b.i {
    private final r a;
    private final d.e b;
    private final d.d c;
    private g d;
    private int e = 0;

    public d(r r2, d.e e2, d.d d2) {
        this.a = r2;
        this.b = e2;
        this.c = d2;
    }

    private void a(d.j j2) {
        u u2 = j2.a();
        j2.a(u.NONE);
        u2.clearDeadline();
        u2.clearTimeout();
    }

    private t b(ab ab2) throws IOException {
        if (!g.a(ab2)) {
            return this.b(0);
        }
        if ("chunked".equalsIgnoreCase(ab2.a("Transfer-Encoding"))) {
            return this.b(this.d);
        }
        long l2 = j.a(ab2);
        if (l2 != -1) {
            return this.b(l2);
        }
        return this.g();
    }

    @Override
    public ac a(ab ab2) throws IOException {
        t t2 = this.b(ab2);
        return new k(ab2.f(), d.m.a((t)t2));
    }

    public s a(long l2) {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new d(l2);
    }

    @Override
    public s a(z z2, long l2) throws IOException {
        if ("chunked".equalsIgnoreCase(z2.a("Transfer-Encoding"))) {
            return this.f();
        }
        if (l2 != -1) {
            return this.a(l2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    @Override
    public void a() {
        c.a.c.b b2 = this.a.a();
        if (b2 != null) {
            b2.b();
        }
    }

    @Override
    public void a(g g2) {
        this.d = g2;
    }

    @Override
    public void a(n n2) throws IOException {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 3;
        n2.a((s)this.c);
    }

    public void a(c.r r2, String string) throws IOException {
        if (this.e != 0) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.c.b(string).b("\r\n");
        int n2 = r2.a();
        for (int i2 = 0; i2 < n2; ++i2) {
            this.c.b(r2.a(i2)).b(": ").b(r2.b(i2)).b("\r\n");
        }
        this.c.b("\r\n");
        this.e = 1;
    }

    @Override
    public void a(z z2) throws IOException {
        this.d.b();
        String string = m.a(z2, this.d.d().a().b().type());
        this.a(z2.c(), string);
    }

    @Override
    public ab.a b() throws IOException {
        return this.d();
    }

    public t b(long l2) throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new e(l2);
    }

    public t b(g g2) throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 5;
        return new c(g2);
    }

    @Override
    public void c() throws IOException {
        this.c.flush();
    }

    public ab.a d() throws IOException {
        if (this.e != 1 && this.e != 3) {
            throw new IllegalStateException("state: " + this.e);
        }
        try {
            ab.a a2;
            do {
                q q2 = q.a(this.b.r());
                a2 = new ab.a().a(q2.a).a(q2.b).a(q2.c).a(this.e());
            } while (q2.b == 100);
            this.e = 4;
            return a2;
        }
        catch (EOFException var1_3) {
            IOException iOException = new IOException("unexpected end of stream on " + this.a);
            iOException.initCause((Throwable)var1_3);
            throw iOException;
        }
    }

    public c.r e() throws IOException {
        String string;
        r.a a2 = new r.a();
        while ((string = this.b.r()).length() != 0) {
            c.a.c.b.a(a2, string);
        }
        return a2.a();
    }

    public s f() {
        if (this.e != 1) {
            throw new IllegalStateException("state: " + this.e);
        }
        this.e = 2;
        return new b();
    }

    public t g() throws IOException {
        if (this.e != 4) {
            throw new IllegalStateException("state: " + this.e);
        }
        if (this.a == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.e = 5;
        this.a.c();
        return new f();
    }

    private abstract class a
    implements t {
        protected final d.j a;
        protected boolean b;

        private a() {
            this.a = new d.j(d.this.b.timeout());
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        protected final void a(boolean bl) throws IOException {
            if (d.this.e == 6) {
                return;
            }
            if (d.this.e != 5) {
                throw new IllegalStateException("state: " + d.this.e);
            }
            d.this.a(this.a);
            d.this.e = 6;
            if (d.this.a == null) return;
            r r2 = d.this.a;
            boolean bl2 = !bl;
            r2.a(bl2, d.this);
        }

        @Override
        public u timeout() {
            return this.a;
        }
    }

    private final class b
    implements s {
        private final d.j b;
        private boolean c;

        private b() {
            this.b = new d.j(d.this.c.timeout());
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void close() throws IOException {
            b b2 = this;
            synchronized (b2) {
                boolean bl = this.c;
                if (!bl) {
                    this.c = true;
                    d.this.c.b("0\r\n\r\n");
                    d.this.a(this.b);
                    d.this.e = 3;
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
        public void flush() throws IOException {
            b b2 = this;
            synchronized (b2) {
                boolean bl = this.c;
                if (!bl) {
                    d.this.c.flush();
                }
                return;
            }
        }

        @Override
        public u timeout() {
            return this.b;
        }

        @Override
        public void write(d.c c2, long l2) throws IOException {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            if (l2 == 0) {
                return;
            }
            d.this.c.j(l2);
            d.this.c.b("\r\n");
            d.this.c.write(c2, l2);
            d.this.c.b("\r\n");
        }
    }

    private class c
    extends a {
        private long e;
        private boolean f;
        private final g g;

        c(g g2) throws IOException {
            this.e = -1;
            this.f = true;
            this.g = g2;
        }

        private void a() throws IOException {
            if (this.e != -1) {
                d.this.b.r();
            }
            try {
                this.e = d.this.b.o();
                String string = d.this.b.r().trim();
                if (this.e < 0 || !string.isEmpty() && !string.startsWith(";")) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.e + string + "\"");
                }
            }
            catch (NumberFormatException var1_2) {
                throw new ProtocolException(var1_2.getMessage());
            }
            if (this.e == 0) {
                this.f = false;
                this.g.a(d.this.e());
                this.a(true);
            }
        }

        @Override
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f && !c.a.i.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.a(false);
            }
            this.b = true;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        public long read(d.c c2, long l2) throws IOException {
            long l3;
            if (l2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + l2);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (!this.f) {
                return -1;
            }
            if (this.e == 0 || this.e == -1) {
                this.a();
                if (!this.f) return -1;
            }
            if ((l3 = d.this.b.read(c2, Math.min((long)l2, (long)this.e))) == -1) {
                this.a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.e -= l3;
            return l3;
        }
    }

    private final class d
    implements s {
        private final d.j b;
        private boolean c;
        private long d;

        private d(long l2) {
            this.b = new d.j(d.this.c.timeout());
            this.d = l2;
        }

        @Override
        public void close() throws IOException {
            if (this.c) {
                return;
            }
            this.c = true;
            if (this.d > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            d.this.a(this.b);
            d.this.e = 3;
        }

        @Override
        public void flush() throws IOException {
            if (this.c) {
                return;
            }
            d.this.c.flush();
        }

        @Override
        public u timeout() {
            return this.b;
        }

        @Override
        public void write(d.c c2, long l2) throws IOException {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            c.a.i.a(c2.a(), 0, l2);
            if (l2 > this.d) {
                throw new ProtocolException("expected " + this.d + " bytes but received " + l2);
            }
            d.this.c.write(c2, l2);
            this.d -= l2;
        }
    }

    private class e
    extends a {
        private long e;

        public e(long l2) throws IOException {
            this.e = l2;
            if (this.e == 0) {
                this.a(true);
            }
        }

        @Override
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.e != 0 && !c.a.i.a(this, 100, TimeUnit.MILLISECONDS)) {
                this.a(false);
            }
            this.b = true;
        }

        @Override
        public long read(d.c c2, long l2) throws IOException {
            if (l2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + l2);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (this.e == 0) {
                return -1;
            }
            long l3 = d.this.b.read(c2, Math.min((long)this.e, (long)l2));
            if (l3 == -1) {
                this.a(false);
                throw new ProtocolException("unexpected end of stream");
            }
            this.e -= l3;
            if (this.e == 0) {
                this.a(true);
            }
            return l3;
        }
    }

    private class f
    extends a {
        private boolean e;

        private f() {
        }

        @Override
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (!this.e) {
                this.a(false);
            }
            this.b = true;
        }

        @Override
        public long read(d.c c2, long l2) throws IOException {
            if (l2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + l2);
            }
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (this.e) {
                return -1;
            }
            long l3 = d.this.b.read(c2, l2);
            if (l3 == -1) {
                this.e = true;
                this.a(true);
                return -1;
            }
            return l3;
        }
    }

}

