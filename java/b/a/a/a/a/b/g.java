/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package b.a.a.a.a.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import b.a.a.a.a.b.i;
import b.a.a.a.c;

public class g {
    protected String a() {
        return "Fabric could not be initialized, API key missing from AndroidManifest.xml. Add the following tag to your Application element \n\t<meta-data android:name=\"io.fabric.ApiKey\" android:value=\"YOUR_API_KEY\"/>";
    }

    public String a(Context context) {
        String string = this.b(context);
        if (TextUtils.isEmpty((CharSequence)string)) {
            string = this.c(context);
        }
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.d(context);
        }
        return string;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected String b(Context context) {
        Bundle bundle;
        String string = null;
        try {
            String string2 = context.getPackageName();
            bundle = context.getPackageManager().getApplicationInfo((String)string2, (int)128).metaData;
            string = null;
            if (bundle == null) return string;
        }
        catch (Exception var3_6) {
            c.h().a("Fabric", "Caught non-fatal exception while retrieving apiKey: " + (Object)var3_6);
            return string;
        }
        string = bundle.getString("io.fabric.ApiKey");
        if (string != null) return string;
        c.h().a("Fabric", "Falling back to Crashlytics key lookup from Manifest");
        String string3 = bundle.getString("com.crashlytics.ApiKey");
        return string3;
    }

    protected String c(Context context) {
        int n2 = i.a(context, "io.fabric.ApiKey", "string");
        if (n2 == 0) {
            c.h().a("Fabric", "Falling back to Crashlytics key lookup from Strings");
            n2 = i.a(context, "com.crashlytics.ApiKey", "string");
        }
        String string = null;
        if (n2 != 0) {
            string = context.getResources().getString(n2);
        }
        return string;
    }

    protected void d(Context context) {
        if (c.i() || i.i(context)) {
            throw new IllegalArgumentException(this.a());
        }
        c.h().e("Fabric", this.a());
    }
}

