/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.ref.WeakReference
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 */
package a.a.a;

import a.a.a.a.a;
import a.a.a.a.b;
import a.a.a.a.c;
import a.a.a.a.d;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class d
implements a.a.a.a {
    private static final HashMap<Class<?>, a.a.a.a.a> d = new HashMap();
    final c a;
    boolean b;
    ArrayList<b> c;
    private final HashMap<Class<?>, HashSet<Object>> e = new HashMap();
    private final HashMap<Class<?>, Object> f = new HashMap();
    private final a g;
    private final Handler h;
    private final Thread i;

    public d() {
        this(null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public d(Context context) {
        this.g = new a();
        this.g.a(context);
        this.a = new c();
        this.i = Thread.currentThread();
        Looper looper = Looper.myLooper();
        Handler handler = looper == null ? null : new Handler(looper);
        this.h = handler;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static d a(Context context) {
        reference var5_1 = d.class;
        synchronized (d.class) {
            a.a.a.a.d d2 = a.a.a.a.d.a(context);
            d d3 = d2.c(context);
            if (d3 != null) return d3;
            d d4 = d2.b(context);
            return d4;
        }
    }

    private RuntimeException a(Exception exception) {
        if (exception instanceof RuntimeException) {
            return (RuntimeException)exception;
        }
        if (exception instanceof InvocationTargetException) {
            String string = Log.getStackTraceString((Throwable)exception.getCause());
            int n2 = 3 + string.indexOf("at");
            String string2 = string.substring(n2, string.indexOf(10, n2));
            Log.e((String)"tinybus", (String)("Exception in @Subscriber method: " + string2 + ". See stack trace for more details."));
        }
        return new RuntimeException((Throwable)exception);
    }

    private Handler c() {
        if (this.h == null) {
            throw new IllegalStateException("You can only call post() from a background thread, if the thread, in which TinyBus was created, had a Looper. Solution: create TinyBus in MainThread or in another thread with Looper.");
        }
        return this.h;
    }

    private void d(Object object) {
        if (object == null) {
            throw new NullPointerException("Object must not be null");
        }
        if (this.i != Thread.currentThread()) {
            throw new IllegalStateException("You must call this method from the same thread, in which TinyBus was created. Created: " + (Object)this.i + ", current thread: " + (Object)Thread.currentThread());
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    void a() {
        this.b = true;
        try {
            do {
                a.a.a.a.b b2 = this.a.a();
                if (b2 == null) return;
                Object object = b2.d;
                Class class_ = object.getClass();
                switch (b2.c) {
                    default: {
                        throw new IllegalStateException("unexpected task code: " + b2.c);
                    }
                    case 0: {
                        a.a.a.a.a a2 = (a.a.a.a.a)d.get((Object)class_);
                        if (a2 == null) {
                            a2 = new a.a.a.a.a(object);
                            d.put((Object)class_, (Object)a2);
                        }
                        a2.c(object, this.e);
                        a2.b(object, this.f);
                        try {
                            a2.a(object, this.e, d, (a.a)this.g);
                            a2.a(this.f, object, d, (a.a)this.g);
                            break;
                        }
                        catch (Exception var13_11) {
                            throw this.a(var13_11);
                        }
                    }
                    case 1: {
                        a.a.a.a.a a3 = (a.a.a.a.a)d.get((Object)class_);
                        a3.d(object, this.e);
                        a3.a(object, this.f);
                        break;
                    }
                    case 2: {
                        HashSet hashSet = (HashSet)this.e.get((Object)class_);
                        if (hashSet == null) break;
                        for (Object object2 : hashSet) {
                            a.b b3 = ((a.a.a.a.a)d.get((Object)object2.getClass())).a(class_);
                            this.g.a(b3, object2, object);
                        }
                    }
                }
                b2.a();
            } while (true);
            catch (Exception exception) {
                throw this.a(exception);
            }
        }
        finally {
            this.b = false;
        }
    }

    public void a(Object object) {
        this.d(object);
        this.a.a(a.a.a.a.b.a(this, 0, object));
        if (!this.b) {
            this.a();
        }
    }

    public d.a b() {
        return this.g;
    }

    public void b(Object object) {
        this.d(object);
        this.a.a(a.a.a.a.b.a(this, 1, object));
        if (!this.b) {
            this.a();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void c(Object object) {
        if (object == null) {
            throw new NullPointerException("Event must not be null");
        }
        if (this.i == Thread.currentThread()) {
            a.a.a.a.b b2 = a.a.a.a.b.a(this, 2, object);
            this.a.a(b2);
            if (this.b) return;
            {
                this.a();
                return;
            }
        } else {
            if (!this.i.isAlive()) return;
            {
                a.a.a.a.b b3 = a.a.a.a.b.a(this, 10, object).a(this.g);
                this.c().post((Runnable)b3);
                return;
            }
        }
    }

    class a
    implements a.a,
    b.a,
    d.a {
        private WeakReference<Context> b;
        private HashMap<Class<?>, a.a.a.a.b> c;

        a() {
        }

        @Override
        public void a() {
            if (d.this.c != null) {
                Iterator iterator = d.this.c.iterator();
                while (iterator.hasNext()) {
                    ((b)iterator.next()).b();
                }
            }
        }

        @Override
        public void a(a.b b2, Object object, Object object2) throws Exception {
            if (b2.b == 1) {
                a.a.a.a.b b3 = a.a.a.a.b.a(d.this, 11, object2).a(this);
                b3.f = b2;
                b3.g = new WeakReference(object);
                a.a.a.a.d.a(this.d()).a().a(b3);
                return;
            }
            b2.a.invoke(object, new Object[]{object2});
        }

        @Override
        public void a(a.a.a.a.b b2) {
            b2.c = 2;
            d.this.a.a(b2);
            if (!d.this.b) {
                d.this.a();
            }
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public void a(Context context) {
            WeakReference weakReference = context == null ? null : new WeakReference((Object)context);
            this.b = weakReference;
        }

        @Override
        public void b() {
            if (d.this.c != null) {
                Iterator iterator = d.this.c.iterator();
                while (iterator.hasNext()) {
                    ((b)iterator.next()).c();
                }
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void b(a.a.a.a.b b2) {
            a a2 = this;
            synchronized (a2) {
                this.c.remove((Object)b2.d.getClass());
                b2.c = 2;
            }
            d.this.a.a(b2);
            if (!d.this.b) {
                d.this.a();
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void c() {
            if (d.this.c != null) {
                Iterator iterator = d.this.c.iterator();
                while (iterator.hasNext()) {
                    ((b)iterator.next()).a();
                }
            }
            a a2 = this;
            synchronized (a2) {
                if (this.c != null && this.c.size() > 0) {
                    Handler handler = d.this.c();
                    for (a.a.a.a.b b2 : this.c.values()) {
                        handler.removeCallbacks((Runnable)b2);
                        b2.a();
                    }
                    this.c.clear();
                }
                return;
            }
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        @Override
        public void c(a.a.a.a.b b2) throws Exception {
            Object object = b2.g.get();
            if (object == null) return;
            Method method = b2.f.a;
            if (method.getParameterTypes().length == 2) {
                Object[] arrobject = new Object[]{b2.d, b2.b};
                method.invoke(object, arrobject);
                return;
            }
            Object[] arrobject = new Object[]{b2.d};
            method.invoke(object, arrobject);
        }

        /*
         * Enabled aggressive block sorting
         */
        public Context d() {
            Context context = this.b == null ? null : (Context)this.b.get();
            if (context == null) {
                throw new IllegalStateException("You must create bus with TinyBus.from(Context) method to use this function.");
            }
            return context;
        }
    }

    public static abstract class b {
        protected a.a.a.a a;
        protected Context b;

        protected void a() {
            this.a = null;
            this.b = null;
        }

        protected void b() {
        }

        protected void c() {
        }
    }

}

