/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
package b.a.a.a.a.g;

import b.a.a.a.a.b.a;
import b.a.a.a.a.e.d;
import b.a.a.a.a.e.e;
import b.a.a.a.a.g.w;
import b.a.a.a.a.g.x;
import b.a.a.a.c;
import b.a.a.a.i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class l
extends a
implements x {
    public l(i i2, String string, String string2, e e2) {
        this(i2, string, string2, e2, b.a.a.a.a.e.c.a);
    }

    l(i i2, String string, String string2, e e2, b.a.a.a.a.e.c c2) {
        super(i2, string, string2, e2, c2);
    }

    private d a(d d2, w w2) {
        this.a(d2, "X-CRASHLYTICS-API-KEY", w2.a);
        this.a(d2, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        this.a(d2, "X-CRASHLYTICS-API-CLIENT-VERSION", this.a.a());
        this.a(d2, "Accept", "application/json");
        this.a(d2, "X-CRASHLYTICS-DEVICE-MODEL", w2.b);
        this.a(d2, "X-CRASHLYTICS-OS-BUILD-VERSION", w2.c);
        this.a(d2, "X-CRASHLYTICS-OS-DISPLAY-VERSION", w2.d);
        this.a(d2, "X-CRASHLYTICS-ADVERTISING-TOKEN", w2.e);
        this.a(d2, "X-CRASHLYTICS-INSTALLATION-ID", w2.f);
        this.a(d2, "X-CRASHLYTICS-ANDROID-ID", w2.g);
        return d2;
    }

    private JSONObject a(String string) {
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject;
        }
        catch (Exception var3_3) {
            c.h().a("Fabric", "Failed to parse settings JSON from " + this.a(), (Throwable)var3_3);
            c.h().a("Fabric", "Settings response " + string);
            return null;
        }
    }

    private void a(d d2, String string, String string2) {
        if (string2 != null) {
            d2.a(string, string2);
        }
    }

    private Map<String, String> b(w w2) {
        String string;
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"build_version", (Object)w2.j);
        hashMap.put((Object)"display_version", (Object)w2.i);
        hashMap.put((Object)"source", (Object)Integer.toString((int)w2.k));
        if (w2.l != null) {
            hashMap.put((Object)"icon_hash", (Object)w2.l);
        }
        if (!b.a.a.a.a.b.i.c(string = w2.h)) {
            hashMap.put((Object)"instance", (Object)string);
        }
        return hashMap;
    }

    JSONObject a(d d2) {
        int n2 = d2.b();
        c.h().a("Fabric", "Settings result was: " + n2);
        if (this.a(n2)) {
            return this.a(d2.e());
        }
        c.h().e("Fabric", "Failed to retrieve settings from " + this.a());
        return null;
    }

    /*
     * Exception decompiling
     */
    @Override
    public JSONObject a(w var1_1) {
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

    boolean a(int n2) {
        if (n2 == 200 || n2 == 201 || n2 == 202 || n2 == 203) {
            return true;
        }
        return false;
    }
}

