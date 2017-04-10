/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package b.a.a.a.a.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b.a.a.a.a.b.b;
import b.a.a.a.a.b.d;
import b.a.a.a.a.b.e;
import b.a.a.a.a.b.f;
import b.a.a.a.a.b.h;

class c {
    private final Context a;
    private final b.a.a.a.a.f.c b;

    public c(Context context) {
        this.a = context.getApplicationContext();
        this.b = new b.a.a.a.a.f.d(context, "TwitterAdvertisingInfoPreferences");
    }

    private void a(final b b2) {
        new Thread((Runnable)new h(){

            @Override
            public void a() {
                b b22 = c.this.e();
                if (!b2.equals(b22)) {
                    b.a.a.a.c.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
                    c.this.b(b22);
                }
            }
        }).start();
    }

    @SuppressLint(value={"CommitPrefEdits"})
    private void b(b b2) {
        if (this.c(b2)) {
            this.b.a(this.b.b().putString("advertising_id", b2.a).putBoolean("limit_ad_tracking_enabled", b2.b));
            return;
        }
        this.b.a(this.b.b().remove("advertising_id").remove("limit_ad_tracking_enabled"));
    }

    private boolean c(b b2) {
        if (b2 != null && !TextUtils.isEmpty((CharSequence)b2.a)) {
            return true;
        }
        return false;
    }

    private b e() {
        b b2 = this.c().a();
        if (!this.c(b2)) {
            b b3 = this.d().a();
            if (!this.c(b3)) {
                b.a.a.a.c.h().a("Fabric", "AdvertisingInfo not present");
                return b3;
            }
            b.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Service Provider");
            return b3;
        }
        b.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Reflection Provider");
        return b2;
    }

    public b a() {
        b b2 = this.b();
        if (this.c(b2)) {
            b.a.a.a.c.h().a("Fabric", "Using AdvertisingInfo from Preference Store");
            this.a(b2);
            return b2;
        }
        b b3 = this.e();
        this.b(b3);
        return b3;
    }

    protected b b() {
        return new b(this.b.a().getString("advertising_id", ""), this.b.a().getBoolean("limit_ad_tracking_enabled", false));
    }

    public f c() {
        return new d(this.a);
    }

    public f d() {
        return new e(this.a);
    }

}

