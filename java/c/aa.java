/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.d
 *  d.f
 *  d.m
 *  java.io.File
 *  java.io.IOException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.charset.Charset
 */
package c;

import c.a.i;
import c.u;
import d.d;
import d.f;
import d.m;
import d.t;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public abstract class aa {
    public static aa create(final u u2, final f f2) {
        return new aa(){

            @Override
            public long contentLength() throws IOException {
                return f2.f();
            }

            @Override
            public u contentType() {
                return u2;
            }

            @Override
            public void writeTo(d d2) throws IOException {
                d2.b(f2);
            }
        };
    }

    public static aa create(final u u2, final File file) {
        if (file == null) {
            throw new NullPointerException("content == null");
        }
        return new aa(){

            @Override
            public long contentLength() {
                return file.length();
            }

            @Override
            public u contentType() {
                return u2;
            }

            @Override
            public void writeTo(d d2) throws IOException {
                t t2 = null;
                try {
                    t2 = m.a((File)file);
                    d2.a(t2);
                    return;
                }
                finally {
                    i.a(t2);
                }
            }
        };
    }

    public static aa create(u u2, String string) {
        Charset charset = i.c;
        if (u2 != null && (charset = u2.b()) == null) {
            charset = i.c;
            u2 = u.a(u2 + "; charset=utf-8");
        }
        return aa.create(u2, string.getBytes(charset));
    }

    public static aa create(u u2, byte[] arrby) {
        return aa.create(u2, arrby, 0, arrby.length);
    }

    public static aa create(final u u2, final byte[] arrby, final int n2, final int n3) {
        if (arrby == null) {
            throw new NullPointerException("content == null");
        }
        i.a(arrby.length, (long)n2, (long)n3);
        return new aa(){

            @Override
            public long contentLength() {
                return n3;
            }

            @Override
            public u contentType() {
                return u2;
            }

            @Override
            public void writeTo(d d2) throws IOException {
                d2.c(arrby, n2, n3);
            }
        };
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract u contentType();

    public abstract void writeTo(d var1) throws IOException;

}

