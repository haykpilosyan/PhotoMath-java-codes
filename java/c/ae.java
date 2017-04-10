/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package c;

public final class ae
extends Enum<ae> {
    public static final /* enum */ ae a = new ae("TLSv1.2");
    public static final /* enum */ ae b = new ae("TLSv1.1");
    public static final /* enum */ ae c = new ae("TLSv1");
    public static final /* enum */ ae d = new ae("SSLv3");
    private static final /* synthetic */ ae[] f;
    final String e;

    static {
        ae[] arrae = new ae[]{a, b, c, d};
        f = arrae;
    }

    private ae(String string2) {
        super(string, n2);
        this.e = string2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public static ae a(String var0) {
        var1_1 = -1;
        switch (var0.hashCode()) {
            case -503070502: {
                if (var0.equals((Object)"TLSv1.2")) {
                    var1_1 = 0;
                    ** break;
                }
                ** GOTO lbl16
            }
            case -503070503: {
                if (var0.equals((Object)"TLSv1.1")) {
                    var1_1 = 1;
                    ** break;
                }
                ** GOTO lbl16
            }
            case 79923350: {
                if (var0.equals((Object)"TLSv1")) {
                    var1_1 = 2;
                }
            }
lbl16: // 8 sources:
            default: {
                ** GOTO lbl21
            }
            case 79201641: 
        }
        if (var0.equals((Object)"SSLv3")) {
            var1_1 = 3;
        }
lbl21: // 4 sources:
        switch (var1_1) {
            default: {
                throw new IllegalArgumentException("Unexpected TLS version: " + var0);
            }
            case 0: {
                return ae.a;
            }
            case 1: {
                return ae.b;
            }
            case 2: {
                return ae.c;
            }
            case 3: 
        }
        return ae.d;
    }

    public static ae valueOf(String string) {
        return (ae)Enum.valueOf((Class)ae.class, (String)string);
    }

    public static ae[] values() {
        return (ae[])f.clone();
    }
}

