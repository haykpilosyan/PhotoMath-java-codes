/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.FileWriter
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package b.a.a.a.a.g;

import b.a.a.a.a.f.b;
import b.a.a.a.a.g.g;
import b.a.a.a.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import org.json.JSONObject;

class i
implements g {
    private final b.a.a.a.i a;

    public i(b.a.a.a.i i2) {
        this.a = i2;
    }

    /*
     * Exception decompiling
     */
    @Override
    public JSONObject a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[CATCHBLOCK]], but top level block is 8[UNCONDITIONALDOLOOP]
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

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Override
    public void a(long var1_1, JSONObject var3_2) {
        c.h().a("Fabric", "Writing settings to cache file...");
        if (var3_2 != null) {
            var4_3 = null;
            var3_2.put("expires_at", var1_1);
            var7_4 = new FileWriter(new File(new b(this.a).a(), "com.crashlytics.settings.json"));
            var7_4.write(var3_2.toString());
            var7_4.flush();
            b.a.a.a.a.b.i.a((Closeable)var7_4, "Failed to close settings writer.");
        }
        return;
        catch (Exception var6_5) {
            var7_4 = null;
lbl15: // 3 sources:
            c.h().e("Fabric", "Failed to cache settings", (Throwable)var6_6);
            b.a.a.a.a.b.i.a((Closeable)var7_4, "Failed to close settings writer.");
            return;
        }
        catch (Throwable var5_8) lbl-1000: // 2 sources:
        {
            do {
                b.a.a.a.a.b.i.a((Closeable)var4_3, "Failed to close settings writer.");
                throw var5_9;
                break;
            } while (true);
        }
        {
            catch (Throwable var5_10) {
                var4_3 = var7_4;
                ** continue;
            }
        }
        catch (Exception var6_7) {
            ** GOTO lbl15
        }
    }
}

