/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.String
 */
package c.a.c;

import java.io.File;
import java.io.IOException;

public interface a {
    public static final a a = new a(){

        @Override
        public void a(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + (Object)file);
            }
        }

        @Override
        public void a(File file, File file2) throws IOException {
            this.a(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + (Object)file + " to " + (Object)file2);
            }
        }

        @Override
        public boolean b(File file) {
            return file.exists();
        }

        @Override
        public long c(File file) {
            return file.length();
        }
    };

    public void a(File var1) throws IOException;

    public void a(File var1, File var2) throws IOException;

    public boolean b(File var1);

    public long c(File var1);

}

