/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  java.io.Closeable
 *  java.io.IOException
 *  java.lang.Object
 */
package d;

import d.c;
import d.u;
import java.io.Closeable;
import java.io.IOException;

public interface t
extends Closeable {
    public void close() throws IOException;

    public long read(c var1, long var2) throws IOException;

    public u timeout();
}

