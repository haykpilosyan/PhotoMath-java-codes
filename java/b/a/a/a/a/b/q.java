/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileNotFoundException
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.RandomAccessFile
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.nio.channels.FileChannel
 *  java.nio.channels.WritableByteChannel
 *  java.util.NoSuchElementException
 *  java.util.logging.Level
 *  java.util.logging.Logger
 */
package b.a.a.a.a.b;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class q
implements Closeable {
    private static final Logger b = Logger.getLogger((String)q.class.getName());
    int a;
    private final RandomAccessFile c;
    private int d;
    private a e;
    private a f;
    private final byte[] g = new byte[16];

    public q(File file) throws IOException {
        if (!file.exists()) {
            q.a(file);
        }
        this.c = q.b(file);
        this.e();
    }

    private static int a(byte[] arrby, int n2) {
        return ((255 & arrby[n2]) << 24) + ((255 & arrby[n2 + 1]) << 16) + ((255 & arrby[n2 + 2]) << 8) + (255 & arrby[n2 + 3]);
    }

    private a a(int n2) throws IOException {
        if (n2 == 0) {
            return a.a;
        }
        this.c.seek((long)n2);
        return new a(n2, this.c.readInt());
    }

    private void a(int n2, int n3, int n4, int n5) throws IOException {
        q.a(this.g, n2, n3, n4, n5);
        this.c.seek(0);
        this.c.write(this.g);
    }

    private void a(int n2, byte[] arrby, int n3, int n4) throws IOException {
        int n5 = this.b(n2);
        if (n5 + n4 <= this.a) {
            this.c.seek((long)n5);
            this.c.write(arrby, n3, n4);
            return;
        }
        int n6 = this.a - n5;
        this.c.seek((long)n5);
        this.c.write(arrby, n3, n6);
        this.c.seek(16);
        this.c.write(arrby, n3 + n6, n4 - n6);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile randomAccessFile = q.b(file2);
        randomAccessFile.setLength(4096);
        randomAccessFile.seek(0);
        byte[] arrby = new byte[16];
        q.a(arrby, 4096, 0, 0, 0);
        randomAccessFile.write(arrby);
        if (file2.renameTo(file)) return;
        throw new IOException("Rename failed!");
        finally {
            randomAccessFile.close();
        }
    }

    private static /* varargs */ void a(byte[] arrby, int ... arrn) {
        int n2 = arrn.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            q.b(arrby, n3, arrn[i2]);
            n3 += 4;
        }
    }

    private int b(int n2) {
        if (n2 < this.a) {
            return n2;
        }
        return n2 + 16 - this.a;
    }

    private static RandomAccessFile b(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private static <T> T b(T t2, String string) {
        if (t2 == null) {
            throw new NullPointerException(string);
        }
        return t2;
    }

    private void b(int n2, byte[] arrby, int n3, int n4) throws IOException {
        int n5 = this.b(n2);
        if (n5 + n4 <= this.a) {
            this.c.seek((long)n5);
            this.c.readFully(arrby, n3, n4);
            return;
        }
        int n6 = this.a - n5;
        this.c.seek((long)n5);
        this.c.readFully(arrby, n3, n6);
        this.c.seek(16);
        this.c.readFully(arrby, n3 + n6, n4 - n6);
    }

    private static void b(byte[] arrby, int n2, int n3) {
        arrby[n2] = (byte)(n3 >> 24);
        arrby[n2 + 1] = (byte)(n3 >> 16);
        arrby[n2 + 2] = (byte)(n3 >> 8);
        arrby[n2 + 3] = (byte)n3;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void c(int n2) throws IOException {
        int n3 = n2 + 4;
        int n4 = this.f();
        if (n4 >= n3) {
            return;
        }
        int n5 = this.a;
        while ((n4 += (n5 <<= 1)) < n3) {
        }
        this.d(n5);
        int n6 = this.b(4 + this.f.b + this.f.c);
        if (n6 < this.e.b) {
            FileChannel fileChannel = this.c.getChannel();
            fileChannel.position((long)this.a);
            int n7 = n6 - 4;
            if (fileChannel.transferTo(16, (long)n7, (WritableByteChannel)fileChannel) != (long)n7) {
                throw new AssertionError((Object)"Copied insufficient number of bytes!");
            }
        }
        if (this.f.b < this.e.b) {
            int n8 = -16 + (this.a + this.f.b);
            this.a(n5, this.d, this.e.b, n8);
            this.f = new a(n8, this.f.c);
        } else {
            this.a(n5, this.d, this.e.b, this.f.b);
        }
        this.a = n5;
    }

    private void d(int n2) throws IOException {
        this.c.setLength((long)n2);
        this.c.getChannel().force(true);
    }

    private void e() throws IOException {
        this.c.seek(0);
        this.c.readFully(this.g);
        this.a = q.a(this.g, 0);
        if ((long)this.a > this.c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.a + ", Actual length: " + this.c.length());
        }
        this.d = q.a(this.g, 4);
        int n2 = q.a(this.g, 8);
        int n3 = q.a(this.g, 12);
        this.e = this.a(n2);
        this.f = this.a(n3);
    }

    private int f() {
        return this.a - this.a();
    }

    public int a() {
        if (this.d == 0) {
            return 16;
        }
        if (this.f.b >= this.e.b) {
            return 16 + (4 + (this.f.b - this.e.b) + this.f.c);
        }
        return 4 + this.f.b + this.f.c + this.a - this.e.b;
    }

    public void a(c c2) throws IOException {
        q q2 = this;
        synchronized (q2) {
            int n2 = this.e.b;
            int n3 = 0;
            do {
                int n4;
                if (n3 >= this.d) break;
                a a2 = this.a(n2);
                c2.a(new b(a2), a2.c);
                n2 = n4 = this.b(4 + a2.b + a2.c);
                ++n3;
            } while (true);
            return;
        }
    }

    public void a(byte[] arrby) throws IOException {
        this.a(arrby, 0, arrby.length);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(byte[] arrby, int n2, int n3) throws IOException {
        q q2 = this;
        synchronized (q2) {
            q.b(arrby, "buffer");
            if ((n2 | n3) < 0 || n3 > arrby.length - n2) {
                throw new IndexOutOfBoundsException();
            }
            this.c(n3);
            boolean bl = this.b();
            int n4 = bl ? 16 : this.b(4 + this.f.b + this.f.c);
            a a2 = new a(n4, n3);
            q.b(this.g, 0, n3);
            this.a(a2.b, this.g, 0, 4);
            this.a(4 + a2.b, arrby, n2, n3);
            int n5 = bl ? a2.b : this.e.b;
            this.a(this.a, 1 + this.d, n5, a2.b);
            this.f = a2;
            this.d = 1 + this.d;
            if (bl) {
                this.e = this.f;
            }
            return;
        }
    }

    public boolean a(int n2, int n3) {
        if (n2 + (4 + this.a()) <= n3) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean b() {
        q q2 = this;
        synchronized (q2) {
            int n2 = this.d;
            if (n2 != 0) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() throws IOException {
        q q2 = this;
        synchronized (q2) {
            if (this.b()) {
                throw new NoSuchElementException();
            }
            if (this.d == 1) {
                this.d();
            } else {
                int n2 = this.b(4 + this.e.b + this.e.c);
                this.b(n2, this.g, 0, 4);
                int n3 = q.a(this.g, 0);
                this.a(this.a, -1 + this.d, n2, this.f.b);
                this.d = -1 + this.d;
                this.e = new a(n2, n3);
            }
            return;
        }
    }

    public void close() throws IOException {
        q q2 = this;
        synchronized (q2) {
            this.c.close();
            return;
        }
    }

    public void d() throws IOException {
        q q2 = this;
        synchronized (q2) {
            this.a(4096, 0, 0, 0);
            this.d = 0;
            this.e = a.a;
            this.f = a.a;
            if (this.a > 4096) {
                this.d(4096);
            }
            this.a = 4096;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.a);
        stringBuilder.append(", size=").append(this.d);
        stringBuilder.append(", first=").append((Object)this.e);
        stringBuilder.append(", last=").append((Object)this.f);
        stringBuilder.append(", element lengths=[");
        try {
            this.a(new c(){
                boolean a;

                /*
                 * Enabled aggressive block sorting
                 */
                @Override
                public void a(InputStream inputStream, int n2) throws IOException {
                    if (this.a) {
                        this.a = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(n2);
                }
            });
        }
        catch (IOException var8_2) {
            b.log(Level.WARNING, "read error", (Throwable)var8_2);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    static class a {
        static final a a = new a(0, 0);
        final int b;
        final int c;

        a(int n2, int n3) {
            this.b = n2;
            this.c = n3;
        }

        public String toString() {
            return this.getClass().getSimpleName() + "[position = " + this.b + ", length = " + this.c + "]";
        }
    }

    private final class b
    extends InputStream {
        private int b;
        private int c;

        private b(a a2) {
            this.b = q.this.b(4 + a2.b);
            this.c = a2.c;
        }

        public int read() throws IOException {
            if (this.c == 0) {
                return -1;
            }
            q.this.c.seek((long)this.b);
            int n2 = q.this.c.read();
            this.b = q.this.b(1 + this.b);
            this.c = -1 + this.c;
            return n2;
        }

        public int read(byte[] arrby, int n2, int n3) throws IOException {
            q.b((Object)arrby, "buffer");
            if ((n2 | n3) < 0 || n3 > arrby.length - n2) {
                throw new ArrayIndexOutOfBoundsException();
            }
            if (this.c > 0) {
                if (n3 > this.c) {
                    n3 = this.c;
                }
                q.this.b(this.b, arrby, n2, n3);
                this.b = q.this.b(n3 + this.b);
                this.c -= n3;
                return n3;
            }
            return -1;
        }
    }

    public static interface c {
        public void a(InputStream var1, int var2) throws IOException;
    }

}

