/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.UUID
 *  java.util.concurrent.locks.ReentrantLock
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package b.a.a.a.a.b;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import b.a.a.a.a.b.b;
import b.a.a.a.a.b.c;
import b.a.a.a.a.b.i;
import b.a.a.a.a.b.m;
import b.a.a.a.a.b.p;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class o {
    private static final Pattern d = Pattern.compile((String)"[^\\p{Alnum}]");
    private static final String e = Pattern.quote((String)"/");
    c a;
    b b;
    boolean c;
    private final ReentrantLock f = new ReentrantLock();
    private final p g;
    private final boolean h;
    private final boolean i;
    private final Context j;
    private final String k;
    private final String l;
    private final Collection<b.a.a.a.i> m;

    public o(Context context, String string, String string2, Collection<b.a.a.a.i> collection) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (string == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        if (collection == null) {
            throw new IllegalArgumentException("kits must not be null");
        }
        this.j = context;
        this.k = string;
        this.l = string2;
        this.m = collection;
        this.g = new p();
        this.a = new c(context);
        this.h = i.a(context, "com.crashlytics.CollectDeviceIdentifiers", true);
        if (!this.h) {
            b.a.a.a.c.h().a("Fabric", "Device ID collection disabled for " + context.getPackageName());
        }
        this.i = i.a(context, "com.crashlytics.CollectUserIdentifiers", true);
        if (!this.i) {
            b.a.a.a.c.h().a("Fabric", "User information collection disabled for " + context.getPackageName());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String a(SharedPreferences sharedPreferences) {
        this.f.lock();
        String string = sharedPreferences.getString("crashlytics.installation.id", null);
        if (string != null) return string;
        string = this.a(UUID.randomUUID().toString());
        sharedPreferences.edit().putString("crashlytics.installation.id", string).commit();
        return string;
        finally {
            this.f.unlock();
        }
    }

    private String a(String string) {
        if (string == null) {
            return null;
        }
        return d.matcher((CharSequence)string).replaceAll("").toLowerCase(Locale.US);
    }

    private void a(Map<a, String> map, a a2, String string) {
        if (string != null) {
            map.put((Object)a2, (Object)string);
        }
    }

    private String b(String string) {
        return string.replaceAll(e, "");
    }

    public boolean a() {
        return this.i;
    }

    public String b() {
        SharedPreferences sharedPreferences;
        String string = this.l;
        if (string == null && (string = (sharedPreferences = i.a(this.j)).getString("crashlytics.installation.id", null)) == null) {
            string = this.a(sharedPreferences);
        }
        return string;
    }

    public String c() {
        return this.k;
    }

    public String d() {
        return this.e() + "/" + this.f();
    }

    public String e() {
        return this.b(Build.VERSION.RELEASE);
    }

    public String f() {
        return this.b(Build.VERSION.INCREMENTAL);
    }

    public String g() {
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{this.b(Build.MANUFACTURER), this.b(Build.MODEL)};
        return String.format((Locale)locale, (String)"%s/%s", (Object[])arrobject);
    }

    public String h() {
        SharedPreferences sharedPreferences;
        String string = "";
        if (this.h && (string = this.n()) == null && (string = (sharedPreferences = i.a(this.j)).getString("crashlytics.installation.id", null)) == null) {
            string = this.a(sharedPreferences);
        }
        return string;
    }

    public Map<a, String> i() {
        HashMap hashMap = new HashMap();
        for (b.a.a.a.i i2 : this.m) {
            if (!(i2 instanceof m)) continue;
            for (Map.Entry entry : ((m)((Object)i2)).e().entrySet()) {
                this.a((Map<a, String>)hashMap, (a)((Object)entry.getKey()), (String)entry.getValue());
            }
        }
        this.a((Map<a, String>)hashMap, a.d, this.n());
        this.a((Map<a, String>)hashMap, a.g, this.m());
        return Collections.unmodifiableMap((Map)hashMap);
    }

    public String j() {
        return this.g.a(this.j);
    }

    b k() {
        o o2 = this;
        synchronized (o2) {
            if (!this.c) {
                this.b = this.a.a();
                this.c = true;
            }
            b b2 = this.b;
            return b2;
        }
    }

    public Boolean l() {
        boolean bl = this.h;
        Boolean bl2 = null;
        if (bl) {
            b b2 = this.k();
            bl2 = null;
            if (b2 != null) {
                bl2 = b2.b;
            }
        }
        return bl2;
    }

    public String m() {
        boolean bl = this.h;
        String string = null;
        if (bl) {
            b b2 = this.k();
            string = null;
            if (b2 != null) {
                string = b2.a;
            }
        }
        return string;
    }

    public String n() {
        boolean bl = this.h;
        String string = null;
        if (bl) {
            String string2 = Settings.Secure.getString((ContentResolver)this.j.getContentResolver(), (String)"android_id");
            boolean bl2 = "9774d56d682e549c".equals((Object)string2);
            string = null;
            if (!bl2) {
                string = this.a(string2);
            }
        }
        return string;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a(1);
        public static final /* enum */ a b = new a(2);
        public static final /* enum */ a c = new a(53);
        public static final /* enum */ a d = new a(100);
        public static final /* enum */ a e = new a(101);
        public static final /* enum */ a f = new a(102);
        public static final /* enum */ a g = new a(103);
        private static final /* synthetic */ a[] i;
        public final int h;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g};
            i = arra;
        }

        private a(int n3) {
            super(string, n2);
            this.h = n3;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf((Class)a.class, (String)string);
        }

        public static a[] values() {
            return (a[])i.clone();
        }
    }

}

