/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.Object
 */
package c;

import c.a.b;
import c.a.d;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public final class c
implements Closeable,
Flushable {
    final d a;
    private final b b;

    public void close() throws IOException {
        this.b.close();
    }

    public void flush() throws IOException {
        this.b.flush();
    }
}

