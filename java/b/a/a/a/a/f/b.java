/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a.f;

import android.content.Context;
import b.a.a.a.a.f.a;
import b.a.a.a.c;
import b.a.a.a.i;
import java.io.File;

public class b
implements a {
    private final Context a;
    private final String b;
    private final String c;

    public b(i i2) {
        if (i2.r() == null) {
            throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
        }
        this.a = i2.r();
        this.b = i2.t();
        this.c = "Android/" + this.a.getPackageName();
    }

    @Override
    public File a() {
        return this.a(this.a.getFilesDir());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    File a(File file) {
        if (file != null) {
            if (file.exists() || file.mkdirs()) {
                return file;
            }
            c.h().d("Fabric", "Couldn't create file");
            do {
                return null;
                break;
            } while (true);
        }
        c.h().a("Fabric", "Null File");
        return null;
    }
}

