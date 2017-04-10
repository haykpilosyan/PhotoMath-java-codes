/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package d;

import d.c;
import d.t;
import d.u;
import java.io.IOException;

public abstract class i
implements t {
    private final t delegate;

    public i(t t2) {
        if (t2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.delegate = t2;
    }

    @Override
    public void close() throws IOException {
        this.delegate.close();
    }

    public final t delegate() {
        return this.delegate;
    }

    @Override
    public long read(c c2, long l2) throws IOException {
        return this.delegate.read(c2, l2);
    }

    @Override
    public u timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return this.getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}

