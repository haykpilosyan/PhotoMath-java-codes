/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package b.a.a.a.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import b.a.a.a.a.a.b;
import b.a.a.a.a.a.d;
import b.a.a.a.c;

public class p {
    private final d<String> a;
    private final b<String> b;

    public p() {
        this.a = new d<String>(){

            public String a(Context context) throws Exception {
                String string = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                if (string == null) {
                    string = "";
                }
                return string;
            }

            @Override
            public /* synthetic */ Object b(Context context) throws Exception {
                return this.a(context);
            }
        };
        this.b = new b();
    }

    public String a(Context context) {
        try {
            String string = this.b.a(context, this.a);
            boolean bl = "".equals((Object)string);
            if (bl) {
                string = null;
            }
            return string;
        }
        catch (Exception var2_4) {
            c.h().e("Fabric", "Failed to determine installer package name", (Throwable)var2_4);
            return null;
        }
    }

}

