/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.u$1
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Thread
 *  java.util.concurrent.TimeUnit
 */
package d;

import d.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class u {
    public static final u NONE = new /* Unavailable Anonymous Inner Class!! */;
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    public u clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public u clearTimeout() {
        this.timeoutNanos = 0;
        return this;
    }

    public final u deadline(long l2, TimeUnit timeUnit) {
        if (l2 <= 0) {
            throw new IllegalArgumentException("duration <= 0: " + l2);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        return this.deadlineNanoTime(System.nanoTime() + timeUnit.toNanos(l2));
    }

    public long deadlineNanoTime() {
        if (!this.hasDeadline) {
            throw new IllegalStateException("No deadline");
        }
        return this.deadlineNanoTime;
    }

    public u deadlineNanoTime(long l2) {
        this.hasDeadline = true;
        this.deadlineNanoTime = l2;
        return this;
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        }
        if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public u timeout(long l2, TimeUnit timeUnit) {
        if (l2 < 0) {
            throw new IllegalArgumentException("timeout < 0: " + l2);
        }
        if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        }
        this.timeoutNanos = timeUnit.toNanos(l2);
        return this;
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }
}

