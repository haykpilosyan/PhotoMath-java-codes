/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.e
 *  java.io.Closeable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package c;

import c.a.i;
import c.u;
import d.c;
import d.e;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public abstract class ac
implements Closeable {
    private Reader reader;

    private Charset charset() {
        u u2 = this.contentType();
        if (u2 != null) {
            return u2.a(i.c);
        }
        return i.c;
    }

    public static ac create(final u u2, final long l2, final e e2) {
        if (e2 == null) {
            throw new NullPointerException("source == null");
        }
        return new ac(){

            @Override
            public long contentLength() {
                return l2;
            }

            @Override
            public u contentType() {
                return u2;
            }

            @Override
            public e source() {
                return e2;
            }
        };
    }

    public static ac create(u u2, String string) {
        Charset charset = i.c;
        if (u2 != null && (charset = u2.b()) == null) {
            charset = i.c;
            u2 = u.a(u2 + "; charset=utf-8");
        }
        c c2 = new c().a(string, charset);
        return ac.create(u2, c2.a(), (e)c2);
    }

    public static ac create(u u2, byte[] arrby) {
        c c2 = new c().b(arrby);
        return ac.create(u2, arrby.length, (e)c2);
    }

    public final InputStream byteStream() {
        return this.source().g();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final byte[] bytes() throws IOException {
        long l2 = this.contentLength();
        if (l2 > Integer.MAX_VALUE) {
            throw new IOException("Cannot buffer entire body for content length: " + l2);
        }
        e e2 = this.source();
        byte[] arrby = e2.s();
        if (l2 == -1 || l2 == (long)arrby.length) return arrby;
        throw new IOException("Content-Length and stream length disagree");
        finally {
            i.a((Closeable)e2);
        }
    }

    public final Reader charStream() {
        InputStreamReader inputStreamReader;
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        this.reader = inputStreamReader = new InputStreamReader(this.byteStream(), this.charset());
        return inputStreamReader;
    }

    public void close() {
        i.a((Closeable)this.source());
    }

    public abstract long contentLength();

    public abstract u contentType();

    public abstract e source();

    public final String string() throws IOException {
        return new String(this.bytes(), this.charset().name());
    }

}

