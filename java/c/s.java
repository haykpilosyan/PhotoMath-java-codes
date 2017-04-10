/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.InetAddress
 *  java.net.URI
 *  java.net.URISyntaxException
 *  java.net.UnknownHostException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package c;

import c.a.i;
import d.c;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class s {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    /*
     * Enabled aggressive block sorting
     */
    private s(a a2) {
        this.b = a2.a;
        this.c = s.a(a2.b, false);
        this.d = s.a(a2.c, false);
        this.e = a2.d;
        this.f = a2.a();
        this.g = this.a(a2.f, false);
        List<String> list = a2.g != null ? this.a(a2.g, true) : null;
        this.h = list;
        String string = a2.h;
        String string2 = null;
        if (string != null) {
            string2 = s.a(a2.h, false);
        }
        this.i = string2;
        this.j = a2.toString();
    }

    static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - 48;
        }
        if (c2 >= 'a' && c2 <= 'f') {
            return 10 + (c2 - 97);
        }
        if (c2 >= 'A' && c2 <= 'F') {
            return 10 + (c2 - 65);
        }
        return -1;
    }

    public static int a(String string) {
        if (string.equals((Object)"http")) {
            return 80;
        }
        if (string.equals((Object)"https")) {
            return 443;
        }
        return -1;
    }

    static /* synthetic */ String a(s s2) {
        return s2.b;
    }

    static String a(String string, int n2, int n3, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n4;
        for (int i2 = n2; i2 < n3; i2 += Character.charCount((int)n4)) {
            n4 = string.codePointAt(i2);
            if (!(n4 < 32 || n4 == 127 || n4 >= 128 && bl4 || string2.indexOf(n4) != -1 || n4 == 37 && (!bl || bl2 && !s.a(string, i2, n3))) && (n4 != 43 || !bl3)) continue;
            c c2 = new c();
            c2.a(string, n2, i2);
            s.a(c2, string, i2, n3, string2, bl, bl2, bl3, bl4);
            return c2.q();
        }
        return string.substring(n2, n3);
    }

    static String a(String string, int n2, int n3, boolean bl) {
        for (int i2 = n2; i2 < n3; ++i2) {
            char c2 = string.charAt(i2);
            if (c2 != '%' && (c2 != '+' || !bl)) continue;
            c c3 = new c();
            c3.a(string, n2, i2);
            s.a(c3, string, i2, n3, bl);
            return c3.q();
        }
        return string.substring(n2, n3);
    }

    static String a(String string, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        return s.a(string, 0, string.length(), string2, bl, bl2, bl3, bl4);
    }

    static String a(String string, boolean bl) {
        return s.a(string, 0, string.length(), bl);
    }

    /*
     * Enabled aggressive block sorting
     */
    private List<String> a(List<String> list, boolean bl) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            String string2 = string != null ? s.a(string, bl) : null;
            arrayList.add((Object)string2);
        }
        return Collections.unmodifiableList((List)arrayList);
    }

    /*
     * Enabled aggressive block sorting
     */
    static void a(c c2, String string, int n2, int n3, String string2, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        c c3 = null;
        while (n2 < n3) {
            int n4 = string.codePointAt(n2);
            if (!bl || n4 != 9 && n4 != 10 && n4 != 12 && n4 != 13) {
                if (n4 == 43 && bl3) {
                    String string3 = bl ? "+" : "%2B";
                    c2.a(string3);
                } else if (n4 < 32 || n4 == 127 || n4 >= 128 && bl4 || string2.indexOf(n4) != -1 || n4 == 37 && (!bl || bl2 && !s.a(string, n2, n3))) {
                    if (c3 == null) {
                        c3 = new c();
                    }
                    c3.a(n4);
                    while (!c3.f()) {
                        int n5 = 255 & c3.i();
                        c2.b(37);
                        c2.b((int)a[15 & n5 >> 4]);
                        c2.b((int)a[n5 & 15]);
                    }
                } else {
                    c2.a(n4);
                }
            }
            n2 += Character.charCount((int)n4);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static void a(c var0, String var1_1, int var2_2, int var3_3, boolean var4_4) {
        var5_5 = var2_2;
        while (var5_5 < var3_3) {
            var6_6 = var1_1.codePointAt(var5_5);
            if (var6_6 != 37 || var5_5 + 2 >= var3_3) ** GOTO lbl11
            var9_7 = s.a(var1_1.charAt(var5_5 + 1));
            var10_8 = s.a(var1_1.charAt(var5_5 + 2));
            if (var9_7 == -1 || var10_8 == -1) ** GOTO lbl-1000
            var0.b(var10_8 + (var9_7 << 4));
            var5_5 += 2;
            ** GOTO lbl15
lbl11: // 1 sources:
            if (var6_6 == 43 && var4_4) {
                var0.b(32);
            } else lbl-1000: // 2 sources:
            {
                var0.a(var6_6);
            }
lbl15: // 3 sources:
            var5_5 += Character.charCount((int)var6_6);
        }
    }

    static void a(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append('/');
            stringBuilder.append((String)list.get(i2));
        }
    }

    static boolean a(String string, int n2, int n3) {
        if (n2 + 2 < n3 && string.charAt(n2) == '%' && s.a(string.charAt(n2 + 1)) != -1 && s.a(string.charAt(n2 + 2)) != -1) {
            return true;
        }
        return false;
    }

    static /* synthetic */ String b(s s2) {
        return s2.e;
    }

    /*
     * Enabled aggressive block sorting
     */
    static List<String> b(String string) {
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        while (n2 <= string.length()) {
            int n3;
            int n4 = string.indexOf(38, n2);
            if (n4 == -1) {
                n4 = string.length();
            }
            if ((n3 = string.indexOf(61, n2)) == -1 || n3 > n4) {
                arrayList.add((Object)string.substring(n2, n4));
                arrayList.add((Object)null);
            } else {
                arrayList.add((Object)string.substring(n2, n3));
                arrayList.add((Object)string.substring(n3 + 1, n4));
            }
            n2 = n4 + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder stringBuilder, List<String> list) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; i2 += 2) {
            String string = (String)list.get(i2);
            String string2 = (String)list.get(i2 + 1);
            if (i2 > 0) {
                stringBuilder.append('&');
            }
            stringBuilder.append(string);
            if (string2 == null) continue;
            stringBuilder.append('=');
            stringBuilder.append(string2);
        }
    }

    static /* synthetic */ int c(s s2) {
        return s2.f;
    }

    public static s e(String string) {
        a a2 = new a();
        a.a a3 = a2.a((s)null, string);
        a.a a4 = a.a.a;
        s s2 = null;
        if (a3 == a4) {
            s2 = a2.c();
        }
        return s2;
    }

    public URI a() {
        String string = this.n().b().toString();
        try {
            URI uRI = new URI(string);
            return uRI;
        }
        catch (URISyntaxException var3_3) {
            try {
                URI uRI = URI.create((String)string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
                return uRI;
            }
            catch (Exception var4_5) {
                throw new RuntimeException((Throwable)var3_3);
            }
        }
    }

    public String b() {
        return this.b;
    }

    public s c(String string) {
        a a2 = this.d(string);
        if (a2 != null) {
            return a2.c();
        }
        return null;
    }

    public boolean c() {
        return this.b.equals((Object)"https");
    }

    public a d(String string) {
        a a2 = new a();
        if (a2.a(this, string) == a.a.a) {
            return a2;
        }
        return null;
    }

    public String d() {
        if (this.c.isEmpty()) {
            return "";
        }
        int n2 = 3 + this.b.length();
        int n3 = i.a(this.j, n2, this.j.length(), ":@");
        return this.j.substring(n2, n3);
    }

    public String e() {
        if (this.d.isEmpty()) {
            return "";
        }
        int n2 = 1 + this.j.indexOf(58, 3 + this.b.length());
        int n3 = this.j.indexOf(64);
        return this.j.substring(n2, n3);
    }

    public boolean equals(Object object) {
        if (object instanceof s && ((s)object).j.equals((Object)this.j)) {
            return true;
        }
        return false;
    }

    public String f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public String h() {
        int n2 = this.j.indexOf(47, 3 + this.b.length());
        int n3 = i.a(this.j, n2, this.j.length(), "?#");
        return this.j.substring(n2, n3);
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public List<String> i() {
        int n2 = this.j.indexOf(47, 3 + this.b.length());
        int n3 = i.a(this.j, n2, this.j.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (n2 < n3) {
            int n4 = n2 + 1;
            n2 = i.a(this.j, n4, n3, '/');
            arrayList.add((Object)this.j.substring(n4, n2));
        }
        return arrayList;
    }

    public List<String> j() {
        return this.g;
    }

    public String k() {
        if (this.h == null) {
            return null;
        }
        int n2 = 1 + this.j.indexOf(63);
        int n3 = i.a(this.j, n2 + 1, this.j.length(), '#');
        return this.j.substring(n2, n3);
    }

    public String l() {
        if (this.h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        s.b(stringBuilder, this.h);
        return stringBuilder.toString();
    }

    public String m() {
        if (this.i == null) {
            return null;
        }
        int n2 = 1 + this.j.indexOf(35);
        return this.j.substring(n2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public a n() {
        a a2 = new a();
        a2.a = this.b;
        a2.b = this.d();
        a2.c = this.e();
        a2.d = this.e;
        int n2 = this.f != s.a(this.b) ? this.f : -1;
        a2.e = n2;
        a2.f.clear();
        a2.f.addAll(this.i());
        a2.c(this.k());
        a2.h = this.m();
        return a2;
    }

    public String toString() {
        return this.j;
    }

    public static final class c.s$a {
        String a;
        String b = "";
        String c = "";
        String d;
        int e = -1;
        final List<String> f = new ArrayList();
        List<String> g;
        String h;

        public c.s$a() {
            this.f.add((Object)"");
        }

        private static String a(byte[] arrby) {
            int n2 = 0;
            int n3 = 0;
            int n4 = -1;
            int n5 = 0;
            while (n5 < arrby.length) {
                int n6;
                for (n6 = n5; n6 < 16 && arrby[n6] == 0 && arrby[n6 + 1] == 0; n6 += 2) {
                }
                int n7 = n6 - n5;
                if (n7 > n3) {
                    n3 = n7;
                    n4 = n5;
                }
                n5 = n6 + 2;
            }
            c c2 = new c();
            while (n2 < arrby.length) {
                if (n2 == n4) {
                    c2.b(58);
                    if ((n2 += n3) != 16) continue;
                    c2.b(58);
                    continue;
                }
                if (n2 > 0) {
                    c2.b(58);
                }
                c2.i((long)((255 & arrby[n2]) << 8 | 255 & arrby[n2 + 1]));
                n2 += 2;
            }
            return c2.q();
        }

        /*
         * Enabled aggressive block sorting
         */
        private void a(String string, int n2, int n3) {
            if (n2 != n3) {
                char c2 = string.charAt(n2);
                if (c2 == '/' || c2 == '\\') {
                    this.f.clear();
                    this.f.add((Object)"");
                    ++n2;
                } else {
                    this.f.set(-1 + this.f.size(), (Object)"");
                }
                int n4 = n2;
                while (n4 < n3) {
                    int n5 = i.a(string, n4, n3, "/\\");
                    boolean bl = n5 < n3;
                    this.a(string, n4, n5, bl, true);
                    if (bl) {
                        ++n5;
                    }
                    n4 = n5;
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private void a(String string, int n2, int n3, boolean bl, boolean bl2) {
            String string2 = s.a(string, n2, n3, " \"<>^`{}|/\\?#", bl2, false, false, true);
            if (this.d(string2)) {
                return;
            }
            if (this.e(string2)) {
                this.d();
                return;
            }
            if (((String)this.f.get(-1 + this.f.size())).isEmpty()) {
                this.f.set(-1 + this.f.size(), (Object)string2);
            } else {
                this.f.add((Object)string2);
            }
            if (!bl) return;
            this.f.add((Object)"");
        }

        private static boolean a(String string, int n2, int n3, byte[] arrby, int n4) {
            int n5 = n2;
            int n6 = n4;
            while (n5 < n3) {
                if (n6 == arrby.length) {
                    return false;
                }
                if (n6 != n4) {
                    if (string.charAt(n5) != '.') {
                        return false;
                    }
                    ++n5;
                }
                int n7 = 0;
                int n8 = n5;
                do {
                    char c2;
                    if (n8 >= n3 || (c2 = string.charAt(n8)) < '0' || c2 > '9') {
                        if (n8 - n5 != 0) break;
                        return false;
                    }
                    if (n7 == 0 && n5 != n8) {
                        return false;
                    }
                    if ((n7 = -48 + (c2 + n7 * 10)) > 255) {
                        return false;
                    }
                    ++n8;
                } while (true);
                int n9 = n6 + 1;
                arrby[n6] = n7;
                n6 = n9;
                n5 = n8;
            }
            if (n6 != n4 + 4) {
                return false;
            }
            return true;
        }

        /*
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private static int b(String string, int n2, int n3) {
            if (n3 - n2 < 2) {
                return -1;
            }
            char c2 = string.charAt(n2);
            if (c2 < 'a' || c2 > 'z') {
                if (c2 < 'A') return -1;
                if (c2 > 'Z') return -1;
            }
            int n4 = n2 + 1;
            while (n4 < n3) {
                char c3 = string.charAt(n4);
                if (!(c3 >= 'a' && c3 <= 'z' || c3 >= 'A' && c3 <= 'Z' || c3 >= '0' && c3 <= '9' || c3 == '+' || c3 == '-' || c3 == '.')) {
                    if (c3 != ':') return -1;
                    return n4;
                }
                ++n4;
            }
            return -1;
        }

        private static int c(String string, int n2, int n3) {
            char c2;
            int n4 = 0;
            while (n2 < n3 && ((c2 = string.charAt(n2)) == '\\' || c2 == '/')) {
                ++n4;
                ++n2;
            }
            return n4;
        }

        /*
         * Exception decompiling
         */
        private static int d(String var0, int var1_1, int var2_2) {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:486)
            // org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:65)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:422)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
            // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
            // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
            // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:841)
            throw new IllegalStateException("Decompilation failed");
        }

        private void d() {
            if (((String)this.f.remove(-1 + this.f.size())).isEmpty() && !this.f.isEmpty()) {
                this.f.set(-1 + this.f.size(), (Object)"");
                return;
            }
            this.f.add((Object)"");
        }

        private boolean d(String string) {
            if (string.equals((Object)".") || string.equalsIgnoreCase("%2e")) {
                return true;
            }
            return false;
        }

        /*
         * Enabled aggressive block sorting
         */
        private static String e(String string, int n2, int n3) {
            String string2 = s.a(string, n2, n3, false);
            if (!string2.contains((CharSequence)":")) {
                return i.a(string2);
            }
            InetAddress inetAddress = string2.startsWith("[") && string2.endsWith("]") ? c.s$a.f(string2, 1, -1 + string2.length()) : c.s$a.f(string2, 0, string2.length());
            if (inetAddress == null) {
                return null;
            }
            byte[] arrby = inetAddress.getAddress();
            if (arrby.length == 16) {
                return c.s$a.a(arrby);
            }
            throw new AssertionError();
        }

        private boolean e(String string) {
            if (string.equals((Object)"..") || string.equalsIgnoreCase("%2e.") || string.equalsIgnoreCase(".%2e") || string.equalsIgnoreCase("%2e%2e")) {
                return true;
            }
            return false;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        private static InetAddress f(String var0, int var1_1, int var2_2) {
            var3_3 = new byte[16];
            var4_4 = var1_1;
            var5_5 = -1;
            var6_6 = -1;
            var7_7 = 0;
            do {
                if (var4_4 >= var2_2) ** GOTO lbl28
                if (var7_7 == var3_3.length) {
                    return null;
                }
                if (var4_4 + 2 > var2_2 || !var0.regionMatches(var4_4, "::", 0, 2)) ** GOTO lbl17
                if (var6_6 != -1) {
                    return null;
                }
                var6_6 = var7_7 + 2;
                if ((var4_4 += 2) != var2_2) ** GOTO lbl26
                var7_7 = var6_6;
                ** GOTO lbl28
lbl17: // 1 sources:
                if (var7_7 == 0) ** GOTO lbl37
                if (!var0.regionMatches(var4_4, ":", 0, 1)) ** GOTO lbl21
                ++var4_4;
                ** GOTO lbl37
lbl21: // 1 sources:
                if (var0.regionMatches(var4_4, ".", 0, 1) == false) return null;
                if (!c.s$a.a(var0, var5_5, var2_2, var3_3, var7_7 - 2)) {
                    return null;
                }
                var7_7 += 2;
                ** GOTO lbl28
lbl26: // 1 sources:
                var7_7 = var6_6;
                ** GOTO lbl37
lbl28: // 3 sources:
                if (var7_7 != var3_3.length) {
                    if (var6_6 == -1) {
                        return null;
                    }
                    System.arraycopy((Object)var3_3, (int)var6_6, (Object)var3_3, (int)(var3_3.length - (var7_7 - var6_6)), (int)(var7_7 - var6_6));
                    Arrays.fill((byte[])var3_3, (int)var6_6, (int)(var6_6 + (var3_3.length - var7_7)), (byte)0);
                }
                try {
                    return InetAddress.getByAddress((byte[])var3_3);
                }
                catch (UnknownHostException var8_14) {
                    throw new AssertionError();
                }
lbl37: // 3 sources:
                var10_8 = 0;
                var11_9 = var4_4;
                do {
                    if (var11_9 >= var2_2 || (var14_12 = s.a(var0.charAt(var11_9))) == -1) {
                        var12_10 = var11_9 - var4_4;
                        if (var12_10 == 0) return null;
                        if (var12_10 <= 4) break;
                        return null;
                    }
                    var10_8 = var14_12 + (var10_8 << 4);
                    ++var11_9;
                } while (true);
                var13_11 = var7_7 + 1;
                var3_3[var7_7] = (byte)(255 & var10_8 >>> 8);
                var7_7 = var13_11 + 1;
                var3_3[var13_11] = (byte)(var10_8 & 255);
                var5_5 = var4_4;
                var4_4 = var11_9;
            } while (true);
        }

        private static int g(String string, int n2, int n3) {
            try {
                int n4 = Integer.parseInt((String)s.a(string, n2, n3, "", false, false, false, true));
                if (n4 > 0 && n4 <= 65535) {
                    return n4;
                }
                return -1;
            }
            catch (NumberFormatException var3_4) {
                return -1;
            }
        }

        int a() {
            if (this.e != -1) {
                return this.e;
            }
            return s.a(this.a);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        a a(s var1_1, String var2_2) {
            var3_3 = i.a(var2_2, 0, var2_2.length());
            if (c.s$a.b(var2_2, var3_3, var4_4 = i.b(var2_2, var3_3, var2_2.length())) != -1) {
                if (var2_2.regionMatches(true, var3_3, "https:", 0, 6)) {
                    this.a = "https";
                    var3_3 += "https:".length();
                } else {
                    if (var2_2.regionMatches(true, var3_3, "http:", 0, 5) == false) return a.c;
                    this.a = "http";
                    var3_3 += "http:".length();
                }
            } else {
                if (var1_1 == null) return a.b;
                this.a = s.a(var1_1);
            }
            if ((var5_5 = c.s$a.c(var2_2, var3_3, var4_4)) >= 2 || var1_1 == null || !s.a(var1_1).equals((Object)this.a)) ** GOTO lbl23
            this.b = var1_1.d();
            this.c = var1_1.e();
            this.d = s.b(var1_1);
            this.e = s.c(var1_1);
            this.f.clear();
            this.f.addAll(var1_1.i());
            if (var3_3 == var4_4 || var2_2.charAt(var3_3) == '#') {
                this.c(var1_1.k());
            }
            ** GOTO lbl68
lbl23: // 1 sources:
            var6_6 = var3_3 + var5_5;
            var7_7 = false;
            var8_8 = false;
            var9_9 = var6_6;
            block4 : do {
                var11_11 = (var10_10 = i.a(var2_2, var9_9, var4_4, "@/\\?#")) != var4_4 ? (int)var2_2.charAt(var10_10) : -1;
                switch (var11_11) {
                    default: {
                        var16_14 = var7_7;
                        var15_12 = var9_9;
                        var17_13 = var8_8;
                        ** GOTO lbl51
                    }
                    case 64: {
                        if (!var7_7) {
                            var18_16 = i.a(var2_2, var9_9, var10_10, ':');
                            var19_15 = s.a(var2_2, var9_9, var18_16, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (var8_8) {
                                var19_15 = this.b + "%40" + var19_15;
                            }
                            this.b = var19_15;
                            if (var18_16 != var10_10) {
                                var7_7 = true;
                                this.c = s.a(var2_2, var18_16 + 1, var10_10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            }
                            var8_8 = true;
                        } else {
                            this.c = this.c + "%40" + s.a(var2_2, var9_9, var10_10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        }
                        var15_12 = var10_10 + 1;
                        var16_14 = var7_7;
                        var17_13 = var8_8;
lbl51: // 2 sources:
                        var7_7 = var16_14;
                        var8_8 = var17_13;
                        var9_9 = var15_12;
                        continue block4;
                    }
                    case -1: 
                    case 35: 
                    case 47: 
                    case 63: 
                    case 92: 
                }
                break;
            } while (true);
            var12_17 = c.s$a.d(var2_2, var9_9, var10_10);
            if (var12_17 + 1 < var10_10) {
                this.d = c.s$a.e(var2_2, var9_9, var12_17);
                this.e = c.s$a.g(var2_2, var12_17 + 1, var10_10);
                if (this.e == -1) {
                    return a.d;
                }
            } else {
                this.d = c.s$a.e(var2_2, var9_9, var12_17);
                this.e = s.a(this.a);
            }
            if (this.d == null) {
                return a.e;
            }
            var3_3 = var10_10;
lbl68: // 2 sources:
            var13_18 = i.a(var2_2, var3_3, var4_4, "?#");
            this.a(var2_2, var3_3, var13_18);
            if (var13_18 < var4_4 && var2_2.charAt(var13_18) == '?') {
                var14_19 = i.a(var2_2, var13_18, var4_4, '#');
                this.g = s.b(s.a(var2_2, var13_18 + 1, var14_19, " \"'<>#", true, false, true, true));
            } else {
                var14_19 = var13_18;
            }
            if (var14_19 >= var4_4) return a.a;
            if (var2_2.charAt(var14_19) != '#') return a.a;
            this.h = s.a(var2_2, var14_19 + 1, var4_4, "", true, false, false, false);
            return a.a;
        }

        public c.s$a a(int n2) {
            if (n2 <= 0 || n2 > 65535) {
                throw new IllegalArgumentException("unexpected port: " + n2);
            }
            this.e = n2;
            return this;
        }

        public c.s$a a(String string) {
            if (string == null) {
                throw new IllegalArgumentException("scheme == null");
            }
            if (string.equalsIgnoreCase("http")) {
                this.a = "http";
                return this;
            }
            if (string.equalsIgnoreCase("https")) {
                this.a = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + string);
        }

        /*
         * Enabled aggressive block sorting
         */
        public c.s$a a(String string, String string2) {
            if (string == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add((Object)s.a(string, " \"'<>#&=", false, false, true, true));
            List<String> list = this.g;
            String string3 = string2 != null ? s.a(string2, " \"'<>#&=", false, false, true, true) : null;
            list.add((Object)string3);
            return this;
        }

        c.s$a b() {
            int n2 = this.f.size();
            for (int i2 = 0; i2 < n2; ++i2) {
                String string = (String)this.f.get(i2);
                this.f.set(i2, (Object)s.a(string, "[]", true, true, false, true));
            }
            if (this.g != null) {
                int n3 = this.g.size();
                for (int i3 = 0; i3 < n3; ++i3) {
                    String string = (String)this.g.get(i3);
                    if (string == null) continue;
                    this.g.set(i3, (Object)s.a(string, "\\^`{|}", true, true, true, true));
                }
            }
            if (this.h != null) {
                this.h = s.a(this.h, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public c.s$a b(String string) {
            if (string == null) {
                throw new IllegalArgumentException("host == null");
            }
            String string2 = c.s$a.e(string, 0, string.length());
            if (string2 == null) {
                throw new IllegalArgumentException("unexpected host: " + string);
            }
            this.d = string2;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public c.s$a b(String string, String string2) {
            if (string == null) {
                throw new IllegalArgumentException("encodedName == null");
            }
            if (this.g == null) {
                this.g = new ArrayList();
            }
            this.g.add((Object)s.a(string, " \"'<>#&=", true, false, true, true));
            List<String> list = this.g;
            String string3 = string2 != null ? s.a(string2, " \"'<>#&=", true, false, true, true) : null;
            list.add((Object)string3);
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public c.s$a c(String string) {
            List<String> list = string != null ? s.b(s.a(string, " \"'<>#", true, false, true, true)) : null;
            this.g = list;
            return this;
        }

        public s c() {
            if (this.a == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.d == null) {
                throw new IllegalStateException("host == null");
            }
            return new s(this);
        }

        /*
         * Enabled aggressive block sorting
         */
        public String toString() {
            int n2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("://");
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                stringBuilder.append(this.b);
                if (!this.c.isEmpty()) {
                    stringBuilder.append(':');
                    stringBuilder.append(this.c);
                }
                stringBuilder.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                stringBuilder.append('[');
                stringBuilder.append(this.d);
                stringBuilder.append(']');
            } else {
                stringBuilder.append(this.d);
            }
            if ((n2 = this.a()) != s.a(this.a)) {
                stringBuilder.append(':');
                stringBuilder.append(n2);
            }
            s.a(stringBuilder, this.f);
            if (this.g != null) {
                stringBuilder.append('?');
                s.b(stringBuilder, this.g);
            }
            if (this.h != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.h);
            }
            return stringBuilder.toString();
        }

        static final class a
        extends Enum<a> {
            public static final /* enum */ a a = new a();
            public static final /* enum */ a b = new a();
            public static final /* enum */ a c = new a();
            public static final /* enum */ a d = new a();
            public static final /* enum */ a e = new a();
            private static final /* synthetic */ a[] f;

            static {
                a[] arra = new a[]{a, b, c, d, e};
                f = arra;
            }

            private a() {
                super(string, n2);
            }

            public static a valueOf(String string) {
                return (a)Enum.valueOf((Class)a.class, (String)string);
            }

            public static a[] values() {
                return (a[])f.clone();
            }
        }

    }

}

