/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  java.io.Closeable
 *  java.io.Flushable
 *  java.io.IOException
 *  java.lang.Object
 */
package d;

import d.c;
import d.u;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface s
extends Closeable,
Flushable {
    public void close() throws IOException;

    public void flush() throws IOException;

    public u timeout();

    public void write(c var1, long var2) throws IOException;
}

