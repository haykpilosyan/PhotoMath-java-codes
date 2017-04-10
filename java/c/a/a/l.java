/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.System
 *  java.util.concurrent.CountDownLatch
 */
package c.a.a;

import java.util.concurrent.CountDownLatch;

public final class l {
    private final CountDownLatch a = new CountDownLatch(1);
    private long b = -1;
    private long c = -1;

    l() {
    }

    void a() {
        if (this.b != -1) {
            throw new IllegalStateException();
        }
        this.b = System.nanoTime();
    }

    void b() {
        if (this.c != -1 || this.b == -1) {
            throw new IllegalStateException();
        }
        this.c = System.nanoTime();
        this.a.countDown();
    }

    void c() {
        if (this.c != -1 || this.b == -1) {
            throw new IllegalStateException();
        }
        this.c = this.b - 1;
        this.a.countDown();
    }
}

