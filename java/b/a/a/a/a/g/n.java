/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package b.a.a.a.a.g;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import b.a.a.a.a.b.i;
import b.a.a.a.c;

public class n {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public n(String string, int n2, int n3, int n4) {
        this.a = string;
        this.b = n2;
        this.c = n3;
        this.d = n4;
    }

    public static n a(Context context, String string) {
        if (string != null) {
            try {
                int n2 = i.l(context);
                c.h().a("Fabric", "App icon resource ID is " + n2);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeResource((Resources)context.getResources(), (int)n2, (BitmapFactory.Options)options);
                n n3 = new n(string, n2, options.outWidth, options.outHeight);
                return n3;
            }
            catch (Exception var2_5) {
                c.h().e("Fabric", "Failed to load icon", (Throwable)var2_5);
            }
        }
        return null;
    }
}

