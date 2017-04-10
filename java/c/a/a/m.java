/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.e
 *  java.io.IOException
 *  java.lang.Object
 *  java.util.List
 */
package c.a.a;

import c.a.a.a;
import c.a.a.f;
import d.e;
import java.io.IOException;
import java.util.List;

public interface m {
    public static final m a = new m(){

        @Override
        public void a(int n2, a a2) {
        }

        @Override
        public boolean a(int n2, e e2, int n3, boolean bl) throws IOException {
            e2.g((long)n3);
            return true;
        }

        @Override
        public boolean a(int n2, List<f> list) {
            return true;
        }

        @Override
        public boolean a(int n2, List<f> list, boolean bl) {
            return true;
        }
    };

    public void a(int var1, a var2);

    public boolean a(int var1, e var2, int var3, boolean var4) throws IOException;

    public boolean a(int var1, List<f> var2);

    public boolean a(int var1, List<f> var2, boolean var3);

}

