/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Throwable
 */
package c.a.b;

import java.io.IOException;

public final class l
extends Exception {
    public IOException a() {
        return (IOException)super.getCause();
    }

    public /* synthetic */ Throwable getCause() {
        return this.a();
    }
}

