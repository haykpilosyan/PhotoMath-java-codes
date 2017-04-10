/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Enumeration
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.Callable
 *  java.util.zip.ZipEntry
 *  java.util.zip.ZipFile
 */
package b.a.a.a;

import android.os.SystemClock;
import b.a.a.a.c;
import b.a.a.a.k;
import b.a.a.a.l;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

class e
implements Callable<Map<String, k>> {
    final String a;

    e(String string) {
        this.a = string;
    }

    /*
     * Exception decompiling
     */
    private k a(ZipEntry var1_1, ZipFile var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
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
    public Map<String, k> a() throws Exception {
        var1_1 = new HashMap();
        var2_2 = SystemClock.elapsedRealtime();
        var4_3 = this.b();
        var5_4 = var4_3.entries();
        var6_5 = 0;
        while (var5_4.hasMoreElements()) {
            var8_6 = var6_5 + 1;
            var9_7 = (ZipEntry)var5_4.nextElement();
            if (var9_7.getName().startsWith("fabric/") && var9_7.getName().length() > "fabric/".length() && (var10_8 = this.a(var9_7, var4_3)) != null) {
                var1_1.put((Object)var10_8.a(), (Object)var10_8);
                var12_9 = c.h();
                var13_10 = new Object[]{var10_8.a(), var10_8.b()};
                var12_9.b("Fabric", String.format((String)"Found kit:[%s] version:[%s]", (Object[])var13_10));
            }
            var6_5 = var8_6;
        }
        if (var4_3 != null) {
            var4_3.close();
        }
lbl19: // 4 sources:
        do {
            c.h().b("Fabric", "finish scanning in " + (SystemClock.elapsedRealtime() - var2_2) + " reading:" + var6_5);
            return var1_1;
            break;
        } while (true);
        catch (IOException var7_11) {
            ** continue;
        }
    }

    protected ZipFile b() throws IOException {
        return new ZipFile(this.a);
    }

    public /* synthetic */ Object call() throws Exception {
        return this.a();
    }
}

