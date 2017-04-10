/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  java.io.IOException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.net.ProtocolException
 */
package c.a.b;

import c.a.i;
import d.c;
import d.s;
import d.u;
import java.io.IOException;
import java.net.ProtocolException;

public final class n
implements s {
    private boolean a;
    private final int b;
    private final c c = new c();

    public n() {
        this(-1);
    }

    public n(int n2) {
        this.b = n2;
    }

    public long a() throws IOException {
        return this.c.a();
    }

    public void a(s s2) throws IOException {
        c c2 = new c();
        this.c.a(c2, 0, this.c.a());
        s2.write(c2, c2.a());
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public void close() throws IOException {
        if (this.a) {
            return;
        }
        this.a = true;
        if (this.c.a() >= (long)this.b) return;
        throw new ProtocolException("content-length promised " + this.b + " bytes, but received " + this.c.a());
    }

    @Override
    public void flush() throws IOException {
    }

    @Override
    public u timeout() {
        return u.NONE;
    }

    @Override
    public void write(c c2, long l2) throws IOException {
        if (this.a) {
            throw new IllegalStateException("closed");
        }
        i.a(c2.a(), 0, l2);
        if (this.b != -1 && this.c.a() > (long)this.b - l2) {
            throw new ProtocolException("exceeded content-length limit of " + this.b + " bytes");
        }
        this.c.write(c2, l2);
    }
}

