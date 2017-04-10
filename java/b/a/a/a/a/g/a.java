/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  java.io.Closeable
 *  java.io.InputStream
 *  java.lang.Number
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collection
 *  java.util.Locale
 */
package b.a.a.a.a.g;

import android.content.Context;
import android.content.res.Resources;
import b.a.a.a.a.b.r;
import b.a.a.a.a.e.e;
import b.a.a.a.a.g.d;
import b.a.a.a.a.g.n;
import b.a.a.a.c;
import b.a.a.a.i;
import b.a.a.a.k;
import java.io.Closeable;
import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;

abstract class a
extends b.a.a.a.a.b.a {
    public a(i i2, String string, String string2, e e2, b.a.a.a.a.e.c c2) {
        super(i2, string, string2, e2, c2);
    }

    private b.a.a.a.a.e.d a(b.a.a.a.a.e.d d2, d d3) {
        return d2.a("X-CRASHLYTICS-API-KEY", d3.a).a("X-CRASHLYTICS-API-CLIENT-TYPE", "android").a("X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private b.a.a.a.a.e.d b(b.a.a.a.a.e.d var1_1, d var2_2) {
        var3_3 = var1_1.e("app[identifier]", var2_2.b).e("app[name]", var2_2.f).e("app[display_version]", var2_2.c).e("app[build_version]", var2_2.d).a("app[source]", (Number)var2_2.g).e("app[minimum_sdk_version]", var2_2.h).e("app[built_sdk_version]", var2_2.i);
        if (!b.a.a.a.a.b.i.c(var2_2.e)) {
            var3_3.e("app[instance_identifier]", var2_2.e);
        }
        if (var2_2.j != null) {
            var8_4 = null;
            var8_4 = this.a.r().getResources().openRawResource(var2_2.j.b);
            var3_3.e("app[icon][hash]", var2_2.j.a).a("app[icon][data]", "icon.png", "application/octet-stream", var8_4).a("app[icon][width]", (Number)var2_2.j.c).a("app[icon][height]", (Number)var2_2.j.d);
        }
lbl9: // 5 sources:
        while (var2_2.k != null) {
            for (k var5_7 : var2_2.k) {
                var3_3.e(this.a(var5_7), var5_7.b());
                var3_3.e(this.b(var5_7), var5_7.c());
            }
            return var3_3;
        }
        return var3_3;
        catch (Resources.NotFoundException var10_5) {
            c.h().e("Fabric", "Failed to find app icon with resource ID: " + var2_2.j.b, (Throwable)var10_5);
        }
        finally {
            b.a.a.a.a.b.i.a((Closeable)var8_4, "Failed to close app icon InputStream.");
        }
        ** GOTO lbl9
    }

    String a(k k2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{k2.a()};
        return String.format((Locale)locale, (String)"app[build][libraries][%s][version]", (Object[])arrobject);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean a(d d2) {
        b.a.a.a.a.e.d d3 = this.b(this.a(this.b(), d2), d2);
        c.h().a("Fabric", "Sending app info to " + this.a());
        if (d2.j != null) {
            c.h().a("Fabric", "App icon hash is " + d2.j.a);
            c.h().a("Fabric", "App icon size is " + d2.j.c + "x" + d2.j.d);
        }
        int n2 = d3.b();
        String string = "POST".equals((Object)d3.p()) ? "Create" : "Update";
        c.h().a("Fabric", string + " app request ID: " + d3.b("X-REQUEST-ID"));
        c.h().a("Fabric", "Result was " + n2);
        if (r.a(n2) == 0) {
            return true;
        }
        return false;
    }

    String b(k k2) {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{k2.a()};
        return String.format((Locale)locale, (String)"app[build][libraries][%s][type]", (Object[])arrobject);
    }
}

