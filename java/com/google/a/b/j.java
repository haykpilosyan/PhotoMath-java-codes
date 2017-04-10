/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.io.IOException
 *  java.io.Writer
 *  java.lang.Appendable
 *  java.lang.CharSequence
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.google.a.b;

import com.google.a.b.a.m;
import com.google.a.d.b;
import com.google.a.d.c;
import com.google.a.d.d;
import com.google.a.l;
import com.google.a.n;
import com.google.a.p;
import com.google.a.t;
import com.google.a.w;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

public final class j {
    public static l a(com.google.a.d.a a2) throws p {
        boolean bl = true;
        a2.f();
        bl = false;
        try {
            l l2 = m.X.b(a2);
            return l2;
        }
        catch (EOFException var5_3) {
            if (bl) {
                return n.a;
            }
            throw new t((Throwable)var5_3);
        }
        catch (d var4_4) {
            throw new t((Throwable)var4_4);
        }
        catch (IOException var3_5) {
            throw new com.google.a.m((Throwable)var3_5);
        }
        catch (NumberFormatException var2_6) {
            throw new t((Throwable)var2_6);
        }
    }

    public static Writer a(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer)appendable;
        }
        return new a(appendable);
    }

    public static void a(l l2, c c2) throws IOException {
        m.X.a(c2, l2);
    }

    private static final class com.google.a.b.j$a
    extends Writer {
        private final Appendable a;
        private final a b = new a();

        com.google.a.b.j$a(Appendable appendable) {
            this.a = appendable;
        }

        public void close() {
        }

        public void flush() {
        }

        public void write(int n2) throws IOException {
            this.a.append((char)n2);
        }

        public void write(char[] arrc, int n2, int n3) throws IOException {
            this.b.a = arrc;
            this.a.append((CharSequence)this.b, n2, n2 + n3);
        }

        static class a
        implements CharSequence {
            char[] a;

            a() {
            }

            public char charAt(int n2) {
                return this.a[n2];
            }

            public int length() {
                return this.a.length;
            }

            public CharSequence subSequence(int n2, int n3) {
                return new String(this.a, n2, n3 - n2);
            }
        }

    }

}

