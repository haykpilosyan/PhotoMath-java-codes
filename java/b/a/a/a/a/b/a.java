/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.Map
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package b.a.a.a.a.b;

import b.a.a.a.a.b.i;
import b.a.a.a.a.e.c;
import b.a.a.a.a.e.d;
import b.a.a.a.a.e.e;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class a {
    private static final Pattern b = Pattern.compile((String)"http(s?)://[^\\/]+", (int)2);
    protected final b.a.a.a.i a;
    private final String c;
    private final e d;
    private final c e;
    private final String f;

    public a(b.a.a.a.i i2, String string, String string2, e e2, c c2) {
        if (string2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (e2 == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.a = i2;
        this.f = string;
        this.c = this.a(string2);
        this.d = e2;
        this.e = c2;
    }

    private String a(String string) {
        if (!i.c(this.f)) {
            string = b.matcher((CharSequence)string).replaceFirst(this.f);
        }
        return string;
    }

    protected d a(Map<String, String> map) {
        return this.d.a(this.e, this.a(), map).a(false).a(10000).a("User-Agent", "Crashlytics Android SDK/" + this.a.a()).a("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    protected String a() {
        return this.c;
    }

    protected d b() {
        return this.a(Collections.emptyMap());
    }
}

