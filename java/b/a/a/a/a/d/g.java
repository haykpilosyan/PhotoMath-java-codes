/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.io.FileOutputStream
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.String
 *  java.util.zip.GZIPOutputStream
 */
package b.a.a.a.a.d;

import android.content.Context;
import b.a.a.a.a.d.h;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

public class g
extends h {
    public g(Context context, File file, String string, String string2) throws IOException {
        super(context, file, string, string2);
    }

    @Override
    public OutputStream a(File file) throws IOException {
        return new GZIPOutputStream((OutputStream)new FileOutputStream(file));
    }
}

