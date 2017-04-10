/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$MemoryInfo
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.SharedPreferences
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Resources
 *  android.hardware.Sensor
 *  android.hardware.SensorManager
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build
 *  android.os.Debug
 *  android.os.StatFs
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 *  java.io.Closeable
 *  java.io.File
 *  java.io.Flushable
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Scanner
 */
package b.a.a.a.a.b;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Debug;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import b.a.a.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class i {
    public static final Comparator<File> a;
    private static Boolean b;
    private static final char[] c;
    private static long d;

    static {
        b = null;
        c = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        d = -1;
        a = new Comparator<File>(){

            public int a(File file, File file2) {
                return (int)(file.lastModified() - file2.lastModified());
            }

            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((File)object, (File)object2);
            }
        };
    }

    public static int a() {
        return a.a().ordinal();
    }

    public static int a(Context context, String string, String string2) {
        return context.getResources().getIdentifier(string, string2, i.j(context));
    }

    public static int a(Context context, boolean bl) {
        Float f2 = i.c(context);
        if (!bl || f2 == null) {
            return 1;
        }
        if ((double)f2.floatValue() >= 99.0) {
            return 3;
        }
        if ((double)f2.floatValue() < 99.0) {
            return 2;
        }
        return 0;
    }

    static long a(String string, String string2, int n2) {
        return Long.parseLong((String)string.split(string2)[0].trim()) * (long)n2;
    }

    public static ActivityManager.RunningAppProcessInfo a(String string, Context context) {
        List list = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses();
        if (list != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (!runningAppProcessInfo.processName.equals((Object)string)) continue;
                return runningAppProcessInfo;
            }
        }
        return null;
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("com.crashlytics.prefs", 0);
    }

    public static String a(int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException("value must be zero or greater");
        }
        Locale locale = Locale.US;
        Object[] arrobject = new Object[]{n2};
        return String.format((Locale)locale, (String)"%1$10s", (Object[])arrobject).replace(' ', '0');
    }

    /*
     * Exception decompiling
     */
    public static String a(File var0, String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 8[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:841)
        throw new IllegalStateException("Decompilation failed");
    }

    public static String a(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
        if (scanner.hasNext()) {
            return scanner.next();
        }
        return "";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(InputStream inputStream, String string) {
        try {
            int n2;
            MessageDigest messageDigest = MessageDigest.getInstance((String)"SHA-1");
            byte[] arrby = new byte[1024];
            while ((n2 = inputStream.read(arrby)) != -1) {
                messageDigest.update(arrby, 0, n2);
            }
            return i.a(messageDigest.digest());
        }
        catch (Exception var2_5) {
            c.h().e("Fabric", "Could not calculate hash for app icon.", (Throwable)var2_5);
            return "";
        }
    }

    public static String a(String string) {
        return i.a(string, "SHA-1");
    }

    private static String a(String string, String string2) {
        return i.a(string.getBytes(), string2);
    }

    public static String a(byte[] arrby) {
        char[] arrc = new char[2 * arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = 255 & arrby[i2];
            arrc[i2 * 2] = c[n2 >>> 4];
            arrc[1 + i2 * 2] = c[n2 & 15];
        }
        return new String(arrc);
    }

    private static String a(byte[] arrby, String string) {
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance((String)string);
        }
        catch (NoSuchAlgorithmException var2_3) {
            c.h().e("Fabric", "Could not create hashing algorithm: " + string + ", returning empty string.", (Throwable)var2_3);
            return "";
        }
        messageDigest.update(arrby);
        return i.a(messageDigest.digest());
    }

    public static /* varargs */ String a(String ... arrstring) {
        if (arrstring == null || arrstring.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String string : arrstring) {
            if (string == null) continue;
            arrayList.add((Object)string.replace((CharSequence)"-", (CharSequence)"").toLowerCase(Locale.US));
        }
        Collections.sort((List)arrayList);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append((String)iterator.next());
        }
        String string2 = stringBuilder.toString();
        if (string2.length() > 0) {
            return i.a(string2);
        }
        return null;
    }

    public static void a(Context context, int n2, String string, String string2) {
        if (i.e(context)) {
            c.h().a(n2, "Fabric", string2);
        }
    }

    public static void a(Context context, String string) {
        if (i.e(context)) {
            c.h().a("Fabric", string);
        }
    }

    public static void a(Context context, String string, Throwable throwable) {
        if (i.e(context)) {
            c.h().e("Fabric", string);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (RuntimeException var2_1) {
            throw var2_1;
        }
        catch (Exception var1_2) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Closeable closeable, String string) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (IOException var2_2) {
            c.h().e("Fabric", string, (Throwable)var2_2);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Flushable flushable, String string) {
        if (flushable == null) return;
        try {
            flushable.flush();
            return;
        }
        catch (IOException var2_2) {
            c.h().e("Fabric", string, (Throwable)var2_2);
            return;
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream, byte[] arrby) throws IOException {
        int n2;
        while ((n2 = inputStream.read(arrby)) != -1) {
            outputStream.write(arrby, 0, n2);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(Context context, String string, boolean bl) {
        if (context == null) return bl;
        Resources resources = context.getResources();
        if (resources == null) return bl;
        int n2 = i.a(context, string, "bool");
        if (n2 > 0) {
            return resources.getBoolean(n2);
        }
        int n3 = i.a(context, string, "string");
        if (n3 <= 0) return bl;
        return Boolean.parseBoolean((String)context.getString(n3));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static long b() {
        reference var10 = i.class;
        synchronized (i.class) {
            if (d != -1) return d;
            long l2 = 0;
            String string = i.a(new File("/proc/meminfo"), "MemTotal");
            if (!TextUtils.isEmpty((CharSequence)string)) {
                String string2 = string.toUpperCase(Locale.US);
                try {
                    if (string2.endsWith("KB")) {
                        long l3;
                        l2 = l3 = i.a(string2, "KB", 1024);
                    } else if (string2.endsWith("MB")) {
                        l2 = i.a(string2, "MB", 1048576);
                    } else if (string2.endsWith("GB")) {
                        l2 = i.a(string2, "GB", 1073741824);
                    } else {
                        c.h().a("Fabric", "Unexpected meminfo format while computing RAM: " + string2);
                    }
                }
                catch (NumberFormatException var7_6) {
                    c.h().e("Fabric", "Unexpected meminfo format while computing RAM: " + string2, (Throwable)var7_6);
                }
            }
            d = l2;
            return d;
        }
    }

    public static long b(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager)context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static long b(String string) {
        StatFs statFs = new StatFs(string);
        long l2 = statFs.getBlockSize();
        return l2 * (long)statFs.getBlockCount() - l2 * (long)statFs.getAvailableBlocks();
    }

    public static String b(int n2) {
        switch (n2) {
            default: {
                return "?";
            }
            case 7: {
                return "A";
            }
            case 3: {
                return "D";
            }
            case 6: {
                return "E";
            }
            case 4: {
                return "I";
            }
            case 2: {
                return "V";
            }
            case 5: 
        }
        return "W";
    }

    public static String b(Context context, String string) {
        int n2 = i.a(context, string, "string");
        if (n2 > 0) {
            return context.getString(n2);
        }
        return "";
    }

    public static String b(InputStream inputStream) {
        return i.a(inputStream, "SHA-1");
    }

    public static Float c(Context context) {
        Intent intent = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intent == null) {
            return null;
        }
        int n2 = intent.getIntExtra("level", -1);
        int n3 = intent.getIntExtra("scale", -1);
        return Float.valueOf((float)((float)n2 / (float)n3));
    }

    public static boolean c() {
        if (Debug.isDebuggerConnected() || Debug.waitingForDebugger()) {
            return true;
        }
        return false;
    }

    public static boolean c(Context context, String string) {
        if (context.checkCallingOrSelfPermission(string) == 0) {
            return true;
        }
        return false;
    }

    public static boolean c(String string) {
        if (string == null || string.length() == 0) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean d(Context context) {
        if (i.f(context)) {
            return false;
        }
        if (((SensorManager)context.getSystemService("sensor")).getDefaultSensor(8) == null) return false;
        return true;
    }

    public static boolean e(Context context) {
        if (b == null) {
            b = i.a(context, "com.crashlytics.Trace", false);
        }
        return b;
    }

    public static boolean f(Context context) {
        String string = Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
        if ("sdk".equals((Object)Build.PRODUCT) || "google_sdk".equals((Object)Build.PRODUCT) || string == null) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static boolean g(Context context) {
        boolean bl = i.f(context);
        String string = Build.TAGS;
        if (!bl && string != null && string.contains((CharSequence)"test-keys")) {
            return true;
        }
        if (new File("/system/app/Superuser.apk").exists()) return true;
        File file = new File("/system/xbin/su");
        if (bl) return false;
        if (file.exists()) return true;
        return false;
    }

    public static int h(Context context) {
        boolean bl = i.f(context);
        int n2 = 0;
        if (bl) {
            n2 = 1;
        }
        if (i.g(context)) {
            n2 |= 2;
        }
        if (i.c()) {
            n2 |= 4;
        }
        return n2;
    }

    public static boolean i(Context context) {
        if ((2 & context.getApplicationInfo().flags) != 0) {
            return true;
        }
        return false;
    }

    public static String j(Context context) {
        int n2 = context.getApplicationContext().getApplicationInfo().icon;
        if (n2 > 0) {
            return context.getResources().getResourcePackageName(n2);
        }
        return context.getPackageName();
    }

    /*
     * Exception decompiling
     */
    public static String k(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 7[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:841)
        throw new IllegalStateException("Decompilation failed");
    }

    public static int l(Context context) {
        return context.getApplicationContext().getApplicationInfo().icon;
    }

    public static String m(Context context) {
        int n2 = i.a(context, "io.fabric.android.build_id", "string");
        if (n2 == 0) {
            n2 = i.a(context, "com.crashlytics.android.build_id", "string");
        }
        String string = null;
        if (n2 != 0) {
            string = context.getResources().getString(n2);
            c.h().a("Fabric", "Build ID is: " + string);
        }
        return string;
    }

    public static boolean n(Context context) {
        if (i.c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo networkInfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
                return true;
            }
            return false;
        }
        return true;
    }

    static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        public static final /* enum */ a c = new a();
        public static final /* enum */ a d = new a();
        public static final /* enum */ a e = new a();
        public static final /* enum */ a f = new a();
        public static final /* enum */ a g = new a();
        public static final /* enum */ a h = new a();
        public static final /* enum */ a i = new a();
        public static final /* enum */ a j = new a();
        private static final Map<String, a> k;
        private static final /* synthetic */ a[] l;

        static {
            a[] arra = new a[]{a, b, c, d, e, f, g, h, i, j};
            l = arra;
            k = new HashMap(4);
            k.put((Object)"armeabi-v7a", (Object)g);
            k.put((Object)"armeabi", (Object)f);
            k.put((Object)"arm64-v8a", (Object)j);
            k.put((Object)"x86", (Object)a);
        }

        private a() {
            super(string, n2);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        static a a() {
            String string = Build.CPU_ABI;
            if (TextUtils.isEmpty((CharSequence)string)) {
                c.h().a("Fabric", "Architecture#getValue()::Build.CPU_ABI returned null or empty");
                return h;
            }
            String string2 = string.toLowerCase(Locale.US);
            a a2 = (a)((Object)k.get((Object)string2));
            if (a2 != null) return a2;
            return h;
        }

        public static a valueOf(String string) {
            return (a)Enum.valueOf((Class)a.class, (String)string);
        }

        public static a[] values() {
            return (a[])l.clone();
        }
    }

}

