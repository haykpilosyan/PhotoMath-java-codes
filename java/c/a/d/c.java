/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  javax.security.auth.x500.X500Principal
 */
package c.a.d;

import javax.security.auth.x500.X500Principal;

final class c {
    private final String a;
    private final int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    public c(X500Principal x500Principal) {
        this.a = x500Principal.getName("RFC2253");
        this.b = this.a.length();
    }

    /*
     * Enabled aggressive block sorting
     */
    private int a(int n2) {
        int n3;
        char c2;
        int n4;
        if (n2 + 1 >= this.b) {
            throw new IllegalStateException("Malformed DN: " + this.a);
        }
        char c3 = this.g[n2];
        if (c3 >= '0' && c3 <= '9') {
            n3 = c3 - 48;
        } else if (c3 >= 'a' && c3 <= 'f') {
            n3 = c3 - 87;
        } else {
            if (c3 < 'A') throw new IllegalStateException("Malformed DN: " + this.a);
            if (c3 > 'F') throw new IllegalStateException("Malformed DN: " + this.a);
            n3 = c3 - 55;
        }
        if ((c2 = this.g[n2 + 1]) >= '0' && c2 <= '9') {
            n4 = c2 - 48;
            return n4 + (n3 << 4);
        }
        if (c2 >= 'a' && c2 <= 'f') {
            n4 = c2 - 87;
            return n4 + (n3 << 4);
        }
        if (c2 < 'A') throw new IllegalStateException("Malformed DN: " + this.a);
        if (c2 > 'F') throw new IllegalStateException("Malformed DN: " + this.a);
        n4 = c2 - 55;
        return n4 + (n3 << 4);
    }

    private String a() {
        while (this.c < this.b && this.g[this.c] == ' ') {
            this.c = 1 + this.c;
        }
        if (this.c == this.b) {
            return null;
        }
        this.d = this.c;
        this.c = 1 + this.c;
        while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] != ' ') {
            this.c = 1 + this.c;
        }
        if (this.c >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.e = this.c;
        if (this.g[this.c] == ' ') {
            while (this.c < this.b && this.g[this.c] != '=' && this.g[this.c] == ' ') {
                this.c = 1 + this.c;
            }
            if (this.g[this.c] != '=' || this.c == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
        this.c = 1 + this.c;
        while (this.c < this.b && this.g[this.c] == ' ') {
            this.c = 1 + this.c;
        }
        if (!(this.e - this.d <= 4 || this.g[3 + this.d] != '.' || this.g[this.d] != 'O' && this.g[this.d] != 'o' || this.g[1 + this.d] != 'I' && this.g[1 + this.d] != 'i' || this.g[2 + this.d] != 'D' && this.g[2 + this.d] != 'd')) {
            this.d = 4 + this.d;
        }
        return new String(this.g, this.d, this.e - this.d);
    }

    /*
     * Enabled aggressive block sorting
     */
    private String b() {
        this.e = this.d = (this.c = 1 + this.c);
        do {
            if (this.c == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            if (this.g[this.c] == '\"') {
                this.c = 1 + this.c;
                while (this.c < this.b && this.g[this.c] == ' ') {
                    this.c = 1 + this.c;
                }
                return new String(this.g, this.d, this.e - this.d);
            }
            this.g[this.e] = this.g[this.c] == '\\' ? this.e() : this.g[this.c];
            this.c = 1 + this.c;
            this.e = 1 + this.e;
        } while (true);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private String c() {
        if (4 + this.c >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.d = this.c;
        this.c = 1 + this.c;
        do {
            if (this.c != this.b && this.g[this.c] != '+' && this.g[this.c] != ',' && this.g[this.c] != ';') ** GOTO lbl9
            this.e = this.c;
            ** GOTO lbl16
lbl9: // 1 sources:
            if (this.g[this.c] == ' ') {
                this.e = this.c;
                this.c = 1 + this.c;
                while (this.c < this.b && this.g[this.c] == ' ') {
                    this.c = 1 + this.c;
                }
            }
            ** GOTO lbl19
lbl16: // 2 sources:
            if ((var1_3 = this.e - this.d) < 5) throw new IllegalStateException("Unexpected end of DN: " + this.a);
            if ((var1_3 & 1) != 0) break;
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
lbl19: // 1 sources:
            if (this.g[this.c] >= 'A' && this.g[this.c] <= 'F') {
                var5_1 = this.g;
                var6_2 = this.c;
                var5_1[var6_2] = (char)(32 + var5_1[var6_2]);
            }
            this.c = 1 + this.c;
        } while (true);
        var2_4 = new byte[var1_3 / 2];
        var3_5 = 0;
        var4_6 = 1 + this.d;
        while (var3_5 < var2_4.length) {
            var2_4[var3_5] = (byte)this.a(var4_6);
            var4_6 += 2;
            ++var3_5;
        }
        return new String(this.g, this.d, var1_3);
    }

    private String d() {
        this.d = this.c;
        this.e = this.c;
        block5 : do {
            if (this.c >= this.b) {
                return new String(this.g, this.d, this.e - this.d);
            }
            switch (this.g[this.c]) {
                default: {
                    char[] arrc = this.g;
                    int n2 = this.e;
                    this.e = n2 + 1;
                    arrc[n2] = this.g[this.c];
                    this.c = 1 + this.c;
                    continue block5;
                }
                case '+': 
                case ',': 
                case ';': {
                    return new String(this.g, this.d, this.e - this.d);
                }
                case '\\': {
                    char[] arrc = this.g;
                    int n3 = this.e;
                    this.e = n3 + 1;
                    arrc[n3] = this.e();
                    this.c = 1 + this.c;
                    continue block5;
                }
                case ' ': 
            }
            this.f = this.e;
            this.c = 1 + this.c;
            char[] arrc = this.g;
            int n4 = this.e;
            this.e = n4 + 1;
            arrc[n4] = 32;
            while (this.c < this.b && this.g[this.c] == ' ') {
                char[] arrc2 = this.g;
                int n5 = this.e;
                this.e = n5 + 1;
                arrc2[n5] = 32;
                this.c = 1 + this.c;
            }
            if (this.c == this.b || this.g[this.c] == ',' || this.g[this.c] == '+' || this.g[this.c] == ';') break;
        } while (true);
        return new String(this.g, this.d, this.f - this.d);
    }

    private char e() {
        this.c = 1 + this.c;
        if (this.c == this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        switch (this.g[this.c]) {
            default: {
                return this.f();
            }
            case ' ': 
            case '\"': 
            case '#': 
            case '%': 
            case '*': 
            case '+': 
            case ',': 
            case ';': 
            case '<': 
            case '=': 
            case '>': 
            case '\\': 
            case '_': 
        }
        return this.g[this.c];
    }

    /*
     * Enabled aggressive block sorting
     */
    private char f() {
        int n2;
        int n3;
        int n4 = this.a(this.c);
        this.c = 1 + this.c;
        if (n4 < 128) {
            return (char)n4;
        }
        if (n4 >= 192 && n4 <= 247) {
            if (n4 <= 223) {
                n2 = 1;
                n3 = n4 & 31;
            } else if (n4 <= 239) {
                n2 = 2;
                n3 = n4 & 15;
            } else {
                n2 = 3;
                n3 = n4 & 7;
            }
        } else {
            return '?';
        }
        int n5 = n3;
        int n6 = 0;
        while (n6 < n2) {
            this.c = 1 + this.c;
            if (this.c == this.b || this.g[this.c] != '\\') {
                return '?';
            }
            this.c = 1 + this.c;
            int n7 = this.a(this.c);
            this.c = 1 + this.c;
            if ((n7 & 192) != 128) {
                return '?';
            }
            n5 = (n5 << 6) + (n7 & 63);
            ++n6;
        }
        return (char)n5;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String a(String string) {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        String string2 = this.a();
        if (string2 == null) {
            return null;
        }
        do {
            String string3 = "";
            if (this.c == this.b) {
                return null;
            }
            switch (this.g[this.c]) {
                default: {
                    string3 = this.d();
                    break;
                }
                case '\"': {
                    string3 = this.b();
                    break;
                }
                case '#': {
                    string3 = this.c();
                }
                case '+': 
                case ',': 
                case ';': 
            }
            if (string.equalsIgnoreCase(string2)) return string3;
            if (this.c >= this.b) {
                return null;
            }
            if (this.g[this.c] != ',' && this.g[this.c] != ';' && this.g[this.c] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.c = 1 + this.c;
        } while ((string2 = this.a()) != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}

