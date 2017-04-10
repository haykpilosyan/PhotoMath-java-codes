/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileInputStream
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 */
package b.a.a.a.a.d;

import android.content.Context;
import b.a.a.a.a.b.i;
import b.a.a.a.a.b.q;
import b.a.a.a.a.d.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class h
implements c {
    private final Context a;
    private final File b;
    private final String c;
    private final File d;
    private q e;
    private File f;

    public h(Context context, File file, String string, String string2) throws IOException {
        this.a = context;
        this.b = file;
        this.c = string2;
        this.d = new File(this.b, string);
        this.e = new q(this.d);
        this.e();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void a(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        OutputStream outputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        }
        catch (Throwable var5_5) {
            void var5_6;
            fileInputStream = null;
            i.a((Closeable)fileInputStream, "Failed to close file input stream");
            i.a((Closeable)outputStream, "Failed to close output stream");
            file.delete();
            throw var5_6;
        }
        outputStream = this.a(file2);
        i.a((InputStream)fileInputStream, outputStream, new byte[1024]);
        {
            catch (Throwable throwable) {}
        }
        i.a((Closeable)fileInputStream, "Failed to close file input stream");
        i.a((Closeable)outputStream, "Failed to close output stream");
        file.delete();
    }

    private void e() {
        this.f = new File(this.b, this.c);
        if (!this.f.exists()) {
            this.f.mkdirs();
        }
    }

    @Override
    public int a() {
        return this.e.a();
    }

    public OutputStream a(File file) throws IOException {
        return new FileOutputStream(file);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public List<File> a(int n2) {
        ArrayList arrayList = new ArrayList();
        File[] arrfile = this.f.listFiles();
        int n3 = arrfile.length;
        int n4 = 0;
        while (n4 < n3) {
            arrayList.add((Object)arrfile[n4]);
            if (arrayList.size() >= n2) {
                return arrayList;
            }
            ++n4;
        }
        return arrayList;
    }

    @Override
    public void a(String string) throws IOException {
        this.e.close();
        this.a(this.d, new File(this.f, string));
        this.e = new q(this.d);
    }

    @Override
    public void a(List<File> list) {
        for (File file : list) {
            Context context = this.a;
            Object[] arrobject = new Object[]{file.getName()};
            i.a(context, String.format((String)"deleting sent analytics file %s", (Object[])arrobject));
            file.delete();
        }
    }

    @Override
    public void a(byte[] arrby) throws IOException {
        this.e.a(arrby);
    }

    @Override
    public boolean a(int n2, int n3) {
        return this.e.a(n2, n3);
    }

    @Override
    public boolean b() {
        return this.e.b();
    }

    @Override
    public List<File> c() {
        return Arrays.asList((Object[])this.f.listFiles());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Override
    public void d() {
        try {
            this.e.close();
        }
        catch (IOException var1_1) {
            ** continue;
        }
lbl5: // 2 sources:
        do {
            this.d.delete();
            return;
            break;
        } while (true);
    }
}

