/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Runtime
 *  java.lang.String
 *  java.lang.Thread
 *  java.util.List
 *  java.util.Locale
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ThreadFactory
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicLong
 */
package b.a.a.a.a.b;

import b.a.a.a.a.b.h;
import b.a.a.a.c;
import b.a.a.a.l;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public final class n {
    public static ExecutorService a(String string) {
        ExecutorService executorService = Executors.newSingleThreadExecutor((ThreadFactory)n.c(string));
        n.a(string, executorService);
        return executorService;
    }

    private static final void a(String string, ExecutorService executorService) {
        n.a(string, executorService, 2, TimeUnit.SECONDS);
    }

    public static final void a(final String string, final ExecutorService executorService, final long l2, final TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread((Runnable)new h(){

            @Override
            public void a() {
                try {
                    c.h().a("Fabric", "Executing shutdown hook for " + string);
                    executorService.shutdown();
                    if (!executorService.awaitTermination(l2, timeUnit)) {
                        c.h().a("Fabric", string + " did not shut down in the allocated time. Requesting immediate shutdown.");
                        executorService.shutdownNow();
                    }
                    return;
                }
                catch (InterruptedException var1_1) {
                    l l22 = c.h();
                    Locale locale = Locale.US;
                    Object[] arrobject = new Object[]{string};
                    l22.a("Fabric", String.format((Locale)locale, (String)"Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", (Object[])arrobject));
                    executorService.shutdownNow();
                    return;
                }
            }
        }, "Crashlytics Shutdown Hook for " + string));
    }

    public static ScheduledExecutorService b(String string) {
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor((ThreadFactory)n.c(string));
        n.a(string, (ExecutorService)scheduledExecutorService);
        return scheduledExecutorService;
    }

    public static final ThreadFactory c(final String string) {
        return new ThreadFactory(new AtomicLong(1)){
            final /* synthetic */ AtomicLong b;

            public Thread newThread(final Runnable runnable) {
                Thread thread = Executors.defaultThreadFactory().newThread((Runnable)new h(){

                    @Override
                    public void a() {
                        runnable.run();
                    }
                });
                thread.setName(string + this.b.getAndIncrement());
                return thread;
            }

        };
    }

}

