/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.concurrent.TimeUnit
 */
package c;

import c.a.b.c;
import c.r;
import java.util.concurrent.TimeUnit;

public final class d {
    public static final d a = new a().a().c();
    public static final d b = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
    String c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;

    private d(a a2) {
        this.d = a2.a;
        this.e = a2.b;
        this.f = a2.c;
        this.g = -1;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = a2.d;
        this.l = a2.e;
        this.m = a2.f;
        this.n = a2.g;
    }

    private d(boolean bl, boolean bl2, int n2, int n3, boolean bl3, boolean bl4, boolean bl5, int n4, int n5, boolean bl6, boolean bl7, String string) {
        this.d = bl;
        this.e = bl2;
        this.f = n2;
        this.g = n3;
        this.h = bl3;
        this.i = bl4;
        this.j = bl5;
        this.k = n4;
        this.l = n5;
        this.m = bl6;
        this.n = bl7;
        this.c = string;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static d a(r var0) {
        var1_1 = false;
        var2_2 = -1;
        var3_3 = -1;
        var4_4 = false;
        var5_5 = false;
        var6_6 = false;
        var7_7 = -1;
        var8_8 = -1;
        var9_9 = false;
        var10_10 = false;
        var11_11 = true;
        var12_12 = var0.a();
        var13_13 = 0;
        var14_14 = null;
        var15_15 = false;
        do {
            if (var13_13 >= var12_12) ** GOTO lbl33
            var17_16 = var0.a(var13_13);
            var18_18 = var0.b(var13_13);
            if (!var17_16.equalsIgnoreCase("Cache-Control")) ** GOTO lbl26
            if (var14_14 != null) {
                var11_11 = false;
            } else {
                var14_14 = var18_18;
            }
            ** GOTO lbl28
lbl26: // 1 sources:
            if (!var17_16.equalsIgnoreCase("Pragma")) ** GOTO lbl31
            var11_11 = false;
lbl28: // 3 sources:
            var19_17 = var15_15;
            var20_20 = 0;
            ** GOTO lbl38
lbl31: // 1 sources:
            var19_17 = var15_15;
            ** GOTO lbl90
lbl33: // 1 sources:
            if (!var11_11) {
                var16_29 = null;
                return new d(var15_15, var1_1, var2_2, var3_3, var4_4, var5_5, var6_6, var7_7, var8_8, var9_9, var10_10, var16_29);
            }
            var16_29 = var14_14;
            return new d(var15_15, var1_1, var2_2, var3_3, var4_4, var5_5, var6_6, var7_7, var8_8, var9_9, var10_10, var16_29);
lbl38: // 13 sources:
            while (var20_20 < var18_18.length()) {
                var21_19 = c.a(var18_18, var20_20, "=,;");
                var22_22 = var18_18.substring(var20_20, var21_19).trim();
                if (var21_19 == var18_18.length() || var18_18.charAt(var21_19) == ',' || var18_18.charAt(var21_19) == ';') {
                    var20_20 = var21_19 + 1;
                    var23_21 = null;
                } else {
                    var24_24 = c.a(var18_18, var21_19 + 1);
                    if (var24_24 < var18_18.length() && var18_18.charAt(var24_24) == '\"') {
                        var27_25 = var24_24 + 1;
                        var28_28 = c.a(var18_18, var27_25, "\"");
                        var29_27 = var18_18.substring(var27_25, var28_28);
                        var20_20 = var28_28 + 1;
                        var23_21 = var29_27;
                    } else {
                        var25_23 = c.a(var18_18, var24_24, ",;");
                        var26_26 = var18_18.substring(var24_24, var25_23).trim();
                        var20_20 = var25_23;
                        var23_21 = var26_26;
                    }
                }
                if ("no-cache".equalsIgnoreCase(var22_22)) {
                    var19_17 = true;
                    continue;
                }
                if ("no-store".equalsIgnoreCase(var22_22)) {
                    var1_1 = true;
                    continue;
                }
                if ("max-age".equalsIgnoreCase(var22_22)) {
                    var2_2 = c.b(var23_21, -1);
                    continue;
                }
                if ("s-maxage".equalsIgnoreCase(var22_22)) {
                    var3_3 = c.b(var23_21, -1);
                    continue;
                }
                if ("private".equalsIgnoreCase(var22_22)) {
                    var4_4 = true;
                    continue;
                }
                if ("public".equalsIgnoreCase(var22_22)) {
                    var5_5 = true;
                    continue;
                }
                if ("must-revalidate".equalsIgnoreCase(var22_22)) {
                    var6_6 = true;
                    continue;
                }
                if ("max-stale".equalsIgnoreCase(var22_22)) {
                    var7_7 = c.b(var23_21, Integer.MAX_VALUE);
                    continue;
                }
                if ("min-fresh".equalsIgnoreCase(var22_22)) {
                    var8_8 = c.b(var23_21, -1);
                    continue;
                }
                if ("only-if-cached".equalsIgnoreCase(var22_22)) {
                    var9_9 = true;
                    continue;
                }
                if (!"no-transform".equalsIgnoreCase(var22_22)) continue;
                var10_10 = true;
            }
lbl90: // 2 sources:
            ++var13_13;
            var15_15 = var19_17;
        } while (true);
    }

    private String j() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.d) {
            stringBuilder.append("no-cache, ");
        }
        if (this.e) {
            stringBuilder.append("no-store, ");
        }
        if (this.f != -1) {
            stringBuilder.append("max-age=").append(this.f).append(", ");
        }
        if (this.g != -1) {
            stringBuilder.append("s-maxage=").append(this.g).append(", ");
        }
        if (this.h) {
            stringBuilder.append("private, ");
        }
        if (this.i) {
            stringBuilder.append("public, ");
        }
        if (this.j) {
            stringBuilder.append("must-revalidate, ");
        }
        if (this.k != -1) {
            stringBuilder.append("max-stale=").append(this.k).append(", ");
        }
        if (this.l != -1) {
            stringBuilder.append("min-fresh=").append(this.l).append(", ");
        }
        if (this.m) {
            stringBuilder.append("only-if-cached, ");
        }
        if (this.n) {
            stringBuilder.append("no-transform, ");
        }
        if (stringBuilder.length() == 0) {
            return "";
        }
        stringBuilder.delete(-2 + stringBuilder.length(), stringBuilder.length());
        return stringBuilder.toString();
    }

    public boolean a() {
        return this.d;
    }

    public boolean b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }

    public boolean f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public int h() {
        return this.l;
    }

    public boolean i() {
        return this.m;
    }

    public String toString() {
        String string;
        String string2 = this.c;
        if (string2 != null) {
            return string2;
        }
        this.c = string = this.j();
        return string;
    }

    public static final class a {
        boolean a;
        boolean b;
        int c = -1;
        int d = -1;
        int e = -1;
        boolean f;
        boolean g;

        public a a() {
            this.a = true;
            return this;
        }

        /*
         * Enabled aggressive block sorting
         */
        public a a(int n2, TimeUnit timeUnit) {
            if (n2 < 0) {
                throw new IllegalArgumentException("maxStale < 0: " + n2);
            }
            long l2 = timeUnit.toSeconds((long)n2);
            int n3 = l2 > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)l2;
            this.d = n3;
            return this;
        }

        public a b() {
            this.f = true;
            return this;
        }

        public d c() {
            return new d(this);
        }
    }

}

