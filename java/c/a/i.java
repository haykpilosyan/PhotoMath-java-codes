/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.f
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.ArrayIndexOutOfBoundsException
 *  java.lang.AssertionError
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Error
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.reflect.Array
 *  java.net.IDN
 *  java.net.Socket
 *  java.nio.charset.Charset
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.List
 *  java.util.Locale
 *  java.util.TimeZone
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package c.a;

import c.s;
import d.f;
import d.t;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.IDN;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];
    public static final Charset c = Charset.forName((String)"UTF-8");
    public static final TimeZone d = TimeZone.getTimeZone((String)"GMT");
    private static final Pattern e = Pattern.compile((String)"([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(String string, int n2, int n3) {
        int n4 = n2;
        while (n4 < n3) {
            switch (string.charAt(n4)) {
                default: {
                    return n4;
                }
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case ' ': 
            }
            ++n4;
        }
        return n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(String string, int n2, int n3, char c2) {
        int n4 = n2;
        while (n4 < n3) {
            if (string.charAt(n4) == c2) {
                return n4;
            }
            ++n4;
        }
        return n3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(String string, int n2, int n3, String string2) {
        int n4 = n2;
        while (n4 < n3) {
            if (string2.indexOf((int)string.charAt(n4)) != -1) {
                return n4;
            }
            ++n4;
        }
        return n3;
    }

    public static f a(f f2) {
        try {
            f f3 = f.a((byte[])MessageDigest.getInstance((String)"SHA-1").digest(f2.g()));
            return f3;
        }
        catch (NoSuchAlgorithmException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String a(s s2, boolean bl) {
        String string = s2.f().contains((CharSequence)":") ? "[" + s2.f() + "]" : s2.f();
        if (bl) return string + ":" + s2.g();
        if (s2.g() == s.a(s2.b())) return string;
        return string + ":" + s2.g();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(String string) {
        try {
            String string2 = IDN.toASCII((String)string).toLowerCase(Locale.US);
            if (string2.isEmpty()) {
                return null;
            }
            boolean bl = i.c(string2);
            if (bl) return null;
            return string2;
        }
        catch (IllegalArgumentException var1_3) {
            // empty catch block
        }
        return null;
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList((List)new ArrayList(list));
    }

    public static /* varargs */ <T> List<T> a(T ... arrT) {
        return Collections.unmodifiableList((List)Arrays.asList((Object[])((Object[])arrT.clone())));
    }

    private static <T> List<T> a(T[] arrT, T[] arrT2) {
        ArrayList arrayList = new ArrayList();
        block0 : for (T t2 : arrT) {
            int n2 = arrT2.length;
            int n3 = 0;
            do {
                if (n3 >= n2) continue block0;
                T t3 = arrT2[n3];
                if (t2.equals(t3)) {
                    arrayList.add(t3);
                    continue block0;
                }
                ++n3;
            } while (true);
        }
        return arrayList;
    }

    public static ThreadFactory a(final String string, final boolean bl) {
        return new ThreadFactory(){

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, string);
                thread.setDaemon(bl);
                return thread;
            }
        };
    }

    public static void a(long l2, long l3, long l4) {
        if ((l3 | l4) < 0 || l3 > l2 || l2 - l3 < l4) {
            throw new ArrayIndexOutOfBoundsException();
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
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public static void a(Closeable var0, Closeable var1_1) throws IOException {
        var2_2 = null;
        try {
            var0.close();
        }
        catch (Throwable var2_3) {
            ** continue;
        }
lbl4: // 2 sources:
        do {
            try {
                var1_1.close();
lbl7: // 3 sources:
                while (var2_2 == null) {
                    return;
                }
            }
            catch (Throwable var3_4) {
                if (var2_2 != null) ** GOTO lbl7
                var2_2 = var3_4;
                ** GOTO lbl7
            }
            if (var2_2 instanceof IOException) {
                throw (IOException)var2_2;
            }
            if (var2_2 instanceof RuntimeException) {
                throw (RuntimeException)var2_2;
            }
            if (var2_2 instanceof Error) {
                throw (Error)var2_2;
            }
            throw new AssertionError((Object)var2_2);
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Socket socket) {
        if (socket == null) return;
        try {
            socket.close();
            return;
        }
        catch (AssertionError var3_1) {
            if (i.a(var3_1)) return;
            throw var3_1;
        }
        catch (RuntimeException var2_2) {
            throw var2_2;
        }
        catch (Exception var1_3) {
            return;
        }
    }

    public static boolean a(t t2, int n2, TimeUnit timeUnit) {
        try {
            boolean bl = i.b(t2, n2, timeUnit);
            return bl;
        }
        catch (IOException var3_4) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        if (assertionError.getCause() != null && assertionError.getMessage() != null && assertionError.getMessage().contains((CharSequence)"getsockname failed")) {
            return true;
        }
        return false;
    }

    public static boolean a(Object object, Object object2) {
        if (object == object2 || object != null && object.equals(object2)) {
            return true;
        }
        return false;
    }

    public static boolean a(String[] arrstring, String string) {
        return Arrays.asList((Object[])arrstring).contains((Object)string);
    }

    public static <T> T[] a(Class<T> class_, T[] arrT, T[] arrT2) {
        List<T> list = i.a(arrT, arrT2);
        return list.toArray((Object[])Array.newInstance(class_, (int)list.size()));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int b(String string, int n2, int n3) {
        int n4 = n3 - 1;
        while (n4 >= n2) {
            switch (string.charAt(n4)) {
                default: {
                    return n4 + 1;
                }
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case ' ': 
            }
            --n4;
        }
        return n2;
    }

    public static f b(f f2) {
        try {
            f f3 = f.a((byte[])MessageDigest.getInstance((String)"SHA-256").digest(f2.g()));
            return f3;
        }
        catch (NoSuchAlgorithmException var1_2) {
            throw new AssertionError((Object)var1_2);
        }
    }

    /*
     * Exception decompiling
     */
    public static boolean b(t var0, int var1_1, TimeUnit var2_2) throws IOException {
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

    public static boolean b(String string) {
        return e.matcher((CharSequence)string).matches();
    }

    public static String[] b(String[] arrstring, String string) {
        String[] arrstring2 = new String[1 + arrstring.length];
        System.arraycopy((Object)arrstring, (int)0, (Object)arrstring2, (int)0, (int)arrstring.length);
        arrstring2[-1 + arrstring2.length] = string;
        return arrstring2;
    }

    public static String c(String string, int n2, int n3) {
        int n4 = i.a(string, n2, n3);
        return string.substring(n4, i.b(string, n4, n3));
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean c(String string) {
        int n2 = 0;
        do {
            int n3 = string.length();
            boolean bl = false;
            if (n2 >= n3) return bl;
            char c2 = string.charAt(n2);
            if (c2 <= '\u001f') return true;
            if (c2 >= '') {
                return true;
            }
            if (" #%/:?@[\\]".indexOf((int)c2) != -1) {
                return true;
            }
            ++n2;
        } while (true);
    }

}

