/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.a$1
 *  d.a$2
 *  d.a$a
 *  java.io.IOException
 *  java.io.InterruptedIOException
 *  java.lang.AssertionError
 *  java.lang.IllegalStateException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
package d;

import d.a;
import d.s;
import d.t;
import d.u;
import java.io.IOException;
import java.io.InterruptedIOException;

public class a
extends u {
    private static a head;
    private boolean inQueue;
    private a next;
    private long timeoutAt;

    static /* synthetic */ a access$000() throws InterruptedException {
        return a.awaitTimeout();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static a awaitTimeout() throws InterruptedException {
        a a2 = null;
        reference var7_1 = a.class;
        synchronized (a.class) {
            a a3 = a.head.next;
            if (a3 != null) {
                long l2 = a3.remainingNanos(System.nanoTime());
                if (l2 > 0) {
                    long l3 = l2 / 1000000;
                    a.class.wait(l3, (int)(l2 - 1000000 * l3));
                    return null;
                }
                a.head.next = a3.next;
                a3.next = null;
                return a3;
            }
            a.class.wait();
            // ** MonitorExit[var7_1] (shouldn't be in output)
            return a2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean cancelScheduledTimeout(a a2) {
        reference var4_1 = a.class;
        synchronized (a.class) {
            a a3 = head;
            while (a3 != null) {
                if (a3.next == a2) {
                    a3.next = a2.next;
                    a2.next = null;
                    return false;
                }
                a3 = a3.next;
            }
            return true;
        }
    }

    private long remainingNanos(long l2) {
        return this.timeoutAt - l2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void scheduleTimeout(a a2, long l2, boolean bl) {
        reference var12_3 = a.class;
        synchronized (a.class) {
            if (head == null) {
                head = new a();
                new a().start();
            }
            long l3 = System.nanoTime();
            if (l2 != 0 && bl) {
                a2.timeoutAt = l3 + Math.min((long)l2, (long)(a2.deadlineNanoTime() - l3));
            } else if (l2 != 0) {
                long l4;
                a2.timeoutAt = l4 = l3 + l2;
            } else {
                if (!bl) {
                    throw new AssertionError();
                }
                a2.timeoutAt = a2.deadlineNanoTime();
            }
            long l5 = a2.remainingNanos(l3);
            a a3 = head;
            do {
                if (a3.next == null || l5 < a3.next.remainingNanos(l3)) {
                    a2.next = a3.next;
                    a3.next = a2;
                    if (a3 == head) {
                        a.class.notify();
                    }
                    // ** MonitorExit[var12_3] (shouldn't be in output)
                    return;
                }
                a3 = a3.next;
            } while (true);
        }
    }

    public final void enter() {
        if (this.inQueue) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long l2 = this.timeoutNanos();
        boolean bl = this.hasDeadline();
        if (l2 == 0 && !bl) {
            return;
        }
        this.inQueue = true;
        a.scheduleTimeout(this, l2, bl);
    }

    final IOException exit(IOException iOException) throws IOException {
        if (!this.exit()) {
            return iOException;
        }
        return this.newTimeoutException(iOException);
    }

    final void exit(boolean bl) throws IOException {
        if (this.exit() && bl) {
            throw this.newTimeoutException(null);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return a.cancelScheduledTimeout(this);
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause((Throwable)iOException);
        }
        return interruptedIOException;
    }

    public final s sink(s s2) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public final t source(t t2) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    protected void timedOut() {
    }
}

