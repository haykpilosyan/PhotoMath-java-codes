/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.Date
 *  java.util.GregorianCalendar
 *  java.util.List
 *  java.util.Locale
 *  java.util.TimeZone
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package c;

import c.a.b.f;
import c.a.i;
import c.r;
import c.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class l {
    private static final Pattern a = Pattern.compile((String)"(\\d{2,4})[^\\d]*");
    private static final Pattern b = Pattern.compile((String)"(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern c = Pattern.compile((String)"(\\d{1,2})[^\\d]*");
    private static final Pattern d = Pattern.compile((String)"(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String e;
    private final String f;
    private final long g;
    private final String h;
    private final String i;
    private final boolean j;
    private final boolean k;
    private final boolean l;
    private final boolean m;

    private l(String string, String string2, long l2, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.e = string;
        this.f = string2;
        this.g = l2;
        this.h = string3;
        this.i = string4;
        this.j = bl;
        this.k = bl2;
        this.m = bl3;
        this.l = bl4;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(String string, int n2, int n3, boolean bl) {
        int n4 = n2;
        while (n4 < n3) {
            char c2 = string.charAt(n4);
            boolean bl2 = c2 < ' ' && c2 != '\t' || c2 >= '' || c2 >= '0' && c2 <= '9' || c2 >= 'a' && c2 <= 'z' || c2 >= 'A' && c2 <= 'Z' || c2 == ':';
            boolean bl3 = !bl;
            if (bl2 == bl3) {
                return n4;
            }
            ++n4;
        }
        return n3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static long a(String string) {
        try {
            long l2 = Long.parseLong((String)string);
            if (l2 <= 0) return Long.MIN_VALUE;
            return l2;
        }
        catch (NumberFormatException var1_2) {
            if (!string.matches("-?\\d+")) {
                throw var1_2;
            }
            if (!string.startsWith("-")) return Long.MAX_VALUE;
            return Long.MIN_VALUE;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static long a(String string, int n2, int n3) {
        int n4 = l.a(string, n2, n3, false);
        int n5 = -1;
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        int n9 = -1;
        int n10 = -1;
        Matcher matcher = d.matcher((CharSequence)string);
        while (n4 < n3) {
            int n11 = l.a(string, n4 + 1, n3, true);
            matcher.region(n4, n11);
            if (n5 == -1 && matcher.usePattern(d).matches()) {
                n5 = Integer.parseInt((String)matcher.group(1));
                n6 = Integer.parseInt((String)matcher.group(2));
                n7 = Integer.parseInt((String)matcher.group(3));
            } else if (n8 == -1 && matcher.usePattern(c).matches()) {
                n8 = Integer.parseInt((String)matcher.group(1));
            } else if (n9 == -1 && matcher.usePattern(b).matches()) {
                String string2 = matcher.group(1).toLowerCase(Locale.US);
                n9 = b.pattern().indexOf(string2) / 4;
            } else if (n10 == -1 && matcher.usePattern(a).matches()) {
                n10 = Integer.parseInt((String)matcher.group(1));
            }
            n4 = l.a(string, n11 + 1, n3, false);
        }
        if (n10 >= 70 && n10 <= 99) {
            n10 += 1900;
        }
        if (n10 >= 0 && n10 <= 69) {
            n10 += 2000;
        }
        if (n10 < 1601) {
            throw new IllegalArgumentException();
        }
        if (n9 == -1) {
            throw new IllegalArgumentException();
        }
        if (n8 < 1 || n8 > 31) {
            throw new IllegalArgumentException();
        }
        if (n5 < 0 || n5 > 23) {
            throw new IllegalArgumentException();
        }
        if (n6 < 0 || n6 > 59) {
            throw new IllegalArgumentException();
        }
        if (n7 >= 0 && n7 <= 59) {
            GregorianCalendar gregorianCalendar = new GregorianCalendar(i.d);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, n10);
            gregorianCalendar.set(2, n9 - 1);
            gregorianCalendar.set(5, n8);
            gregorianCalendar.set(11, n5);
            gregorianCalendar.set(12, n6);
            gregorianCalendar.set(13, n7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }
        throw new IllegalArgumentException();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static l a(long var0, s var2_1, String var3_2) {
        var4_3 = var3_2.length();
        var5_4 = i.a(var3_2, 0, var4_3, ';');
        var6_5 = i.a(var3_2, 0, var5_4, '=');
        if (var6_5 == var5_4) {
            return null;
        }
        var7_6 = i.c(var3_2, 0, var6_5);
        if (var7_6.isEmpty()) {
            return null;
        }
        var8_7 = i.c(var3_2, var6_5 + 1, var5_4);
        var9_8 = 253402300799999L;
        var11_9 = -1;
        var13_10 = null;
        var14_11 = null;
        var15_12 = false;
        var16_13 = false;
        var17_14 = true;
        var18_15 = false;
        var19_16 = var5_4 + 1;
        do {
            if (var19_16 >= var4_3) ** GOTO lbl72
            var28_18 = i.a(var3_2, var19_16, var4_3, ';');
            var29_17 = i.a(var3_2, var19_16, var28_18, '=');
            var30_20 = i.c(var3_2, var19_16, var29_17);
            var31_19 = var29_17 < var28_18 ? i.c(var3_2, var29_17 + 1, var28_18) : "";
            if (!var30_20.equalsIgnoreCase("expires")) ** GOTO lbl36
            try {
                var43_29 = l.a(var31_19, 0, var31_19.length());
                var18_15 = true;
                var32_22 = var13_10;
                var33_23 = var43_29;
            }
            catch (IllegalArgumentException var42_28) {
                var32_22 = var13_10;
                var33_23 = var9_8;
            }
            ** GOTO lbl97
lbl36: // 1 sources:
            if (!var30_20.equalsIgnoreCase("max-age")) ** GOTO lbl47
            try {
                var11_9 = var40_30 = l.a(var31_19);
                var18_15 = true;
                var32_22 = var13_10;
                var33_23 = var9_8;
            }
            catch (NumberFormatException var39_25) {
                var32_22 = var13_10;
                var33_23 = var9_8;
            }
            ** GOTO lbl97
lbl47: // 1 sources:
            if (!var30_20.equalsIgnoreCase("domain")) ** GOTO lbl57
            try {
                var32_22 = var38_24 = l.b(var31_19);
                var33_23 = var9_8;
                var17_14 = false;
            }
            catch (IllegalArgumentException var37_27) {
                var32_22 = var13_10;
                var33_23 = var9_8;
            }
            ** GOTO lbl97
lbl57: // 1 sources:
            if (!var30_20.equalsIgnoreCase("path")) ** GOTO lbl62
            var14_11 = var31_19;
            var32_22 = var13_10;
            var33_23 = var9_8;
            ** GOTO lbl97
lbl62: // 1 sources:
            if (!var30_20.equalsIgnoreCase("secure")) ** GOTO lbl67
            var15_12 = true;
            var32_22 = var13_10;
            var33_23 = var9_8;
            ** GOTO lbl97
lbl67: // 1 sources:
            if (!var30_20.equalsIgnoreCase("httponly")) ** GOTO lbl95
            var16_13 = true;
            var32_22 = var13_10;
            var33_23 = var9_8;
            ** GOTO lbl97
lbl72: // 1 sources:
            if (var11_9 == Long.MIN_VALUE) {
                var20_31 = Long.MIN_VALUE;
            } else if (var11_9 != -1) {
                var26_36 = var11_9 <= 9223372036854775L ? var11_9 * 1000 : Long.MAX_VALUE;
                var20_31 = var26_36 + var0;
                if (var20_31 < var0 || var20_31 > 253402300799999L) {
                    var20_31 = 253402300799999L;
                }
            } else {
                var20_31 = var9_8;
            }
            if (var13_10 == null) {
                var13_10 = var2_1.f();
            } else if (!l.b(var2_1, var13_10)) {
                return null;
            }
            if (var14_11 != null && var14_11.startsWith("/")) {
                var25_35 = var14_11;
                return new l(var7_6, var8_7, var20_31, var13_10, var25_35, var15_12, var16_13, var17_14, var18_15);
            }
            var22_32 = var2_1.h();
            var23_33 = var22_32.lastIndexOf(47);
            var24_34 = var23_33 != 0 ? var22_32.substring(0, var23_33) : "/";
            var25_35 = var24_34;
            return new l(var7_6, var8_7, var20_31, var13_10, var25_35, var15_12, var16_13, var17_14, var18_15);
lbl95: // 1 sources:
            var32_22 = var13_10;
            var33_23 = var9_8;
lbl97: // 10 sources:
            var35_21 = var28_18 + 1;
            var36_26 = var32_22;
            var19_16 = var35_21;
            var9_8 = var33_23;
            var13_10 = var36_26;
        } while (true);
    }

    public static l a(s s2, String string) {
        return l.a(System.currentTimeMillis(), s2, string);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static List<l> a(s s2, r r2) {
        List<String> list = r2.c("Set-Cookie");
        ArrayList arrayList = null;
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            l l2 = l.a(s2, (String)list.get(i2));
            if (l2 == null) continue;
            ArrayList arrayList2 = arrayList == null ? new ArrayList() : arrayList;
            arrayList2.add((Object)l2);
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            return Collections.unmodifiableList((List)arrayList);
        }
        return Collections.emptyList();
    }

    private static String b(String string) {
        String string2;
        if (string.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (string.startsWith(".")) {
            string = string.substring(1);
        }
        if ((string2 = i.a(string)) == null) {
            throw new IllegalArgumentException();
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean b(s s2, String string) {
        String string2 = s2.f();
        if (string2.equals((Object)string) || string2.endsWith(string) && string2.charAt(-1 + (string2.length() - string.length())) == '.' && !i.b(string2)) {
            return true;
        }
        return false;
    }

    public String a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof l)) {
            return false;
        }
        l l2 = (l)object;
        if (!l2.e.equals((Object)this.e)) return false;
        if (!l2.f.equals((Object)this.f)) return false;
        if (!l2.h.equals((Object)this.h)) return false;
        if (!l2.i.equals((Object)this.i)) return false;
        if (l2.g != this.g) return false;
        if (l2.j != this.j) return false;
        if (l2.k != this.k) return false;
        if (l2.l != this.l) return false;
        if (l2.m != this.m) return false;
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int hashCode() {
        int n2 = 31 * (31 * (31 * (31 * (31 * (527 + this.e.hashCode()) + this.f.hashCode()) + this.h.hashCode()) + this.i.hashCode()) + (int)(this.g ^ this.g >>> 32));
        int n3 = this.j ? 0 : 1;
        int n4 = 31 * (n3 + n2);
        int n5 = this.k ? 0 : 1;
        int n6 = 31 * (n5 + n4);
        int n7 = this.l ? 0 : 1;
        int n8 = 31 * (n7 + n6);
        boolean bl = this.m;
        int n9 = 0;
        if (bl) {
            return n8 + n9;
        }
        n9 = 1;
        return n8 + n9;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append('=');
        stringBuilder.append(this.f);
        if (this.l) {
            if (this.g == Long.MIN_VALUE) {
                stringBuilder.append("; max-age=0");
            } else {
                stringBuilder.append("; expires=").append(f.a(new Date(this.g)));
            }
        }
        if (!this.m) {
            stringBuilder.append("; domain=").append(this.h);
        }
        stringBuilder.append("; path=").append(this.i);
        if (this.j) {
            stringBuilder.append("; secure");
        }
        if (this.k) {
            stringBuilder.append("; httponly");
        }
        return stringBuilder.toString();
    }
}

