/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 */
package b.a.a.a.a.b;

import android.content.Context;
import b.a.a.a.a.b.b;
import b.a.a.a.a.b.f;
import b.a.a.a.c;
import java.lang.reflect.Method;

class d
implements f {
    private final Context a;

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    private String b() {
        try {
            String string = (String)Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("getId", new Class[0]).invoke(this.d(), new Object[0]);
            return string;
        }
        catch (Exception var1_2) {
            c.h().d("Fabric", "Could not call getId on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return null;
        }
    }

    private boolean c() {
        try {
            boolean bl = (Boolean)Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient$Info").getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(this.d(), new Object[0]);
            return bl;
        }
        catch (Exception var1_2) {
            c.h().d("Fabric", "Could not call isLimitAdTrackingEnabled on com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            return false;
        }
    }

    private Object d() {
        try {
            Method method = Class.forName((String)"com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", new Class[]{Context.class});
            Object[] arrobject = new Object[]{this.a};
            Object object = method.invoke((Object)null, arrobject);
            return object;
        }
        catch (Exception var1_4) {
            c.h().d("Fabric", "Could not call getAdvertisingIdInfo on com.google.android.gms.ads.identifier.AdvertisingIdClient");
            return null;
        }
    }

    @Override
    public b a() {
        if (this.a(this.a)) {
            return new b(this.b(), this.c());
        }
        return null;
    }

    boolean a(Context context) {
        try {
            int n2 = (Integer)Class.forName((String)"com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", new Class[]{Context.class}).invoke((Object)null, new Object[]{context});
            if (n2 == 0) {
                return true;
            }
            return false;
        }
        catch (Exception var2_3) {
            return false;
        }
    }
}

