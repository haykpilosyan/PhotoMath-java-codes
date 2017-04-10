/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.annotation.Annotation
 *  java.lang.reflect.Method
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package a.a.a.a;

import a.a.a.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class a {
    private final HashMap<Class<? extends Object>, b> a = new HashMap();
    private HashMap<Class<? extends Object>, Method> b;

    /*
     * Enabled aggressive block sorting
     */
    public a(Object object) {
        Method[] arrmethod = object.getClass().getMethods();
        int n2 = arrmethod.length;
        int n3 = 0;
        while (n3 < n2) {
            Method method = arrmethod[n3];
            if (!method.isBridge() && !method.isSynthetic()) {
                c c2 = (c)method.getAnnotation((Class)c.class);
                if (c2 != null) {
                    Class[] arrclass = method.getParameterTypes();
                    if ((b)this.a.put((Object)arrclass[0], (Object)new b(method, c2)) != null) {
                        throw new IllegalArgumentException("Only one @Subscriber can be defined for one event type in the same class. Event type: " + (Object)arrclass[0] + ". Class: " + (Object)object.getClass());
                    }
                } else if (method.isAnnotationPresent((Class)a.a.a.b.class)) {
                    if (this.b == null) {
                        this.b = new HashMap();
                    }
                    this.b.put((Object)method.getReturnType(), (Object)method);
                }
            }
            ++n3;
        }
    }

    public b a(Class<?> class_) {
        return (b)this.a.get(class_);
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void a(Object object, HashMap<Class<? extends Object>, Object> hashMap) {
        if (this.b == null) {
            return;
        }
        Iterator iterator = this.b.keySet().iterator();
        do {
            if (!iterator.hasNext()) return;
        } while (hashMap.remove((Object)((Class)iterator.next())) != null);
        throw new IllegalArgumentException("Unable to unregister producer, because it wasn't registered before, " + object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(Object object, HashMap<Class<? extends Object>, HashSet<Object>> hashMap, HashMap<Class<? extends Object>, a> hashMap2, a a2) throws Exception {
        if (this.b != null) {
            Iterator iterator = this.b.entrySet().iterator();
            while (iterator.hasNext()) {
                Object object2;
                Class class_ = (Class)((Map.Entry)iterator.next()).getKey();
                HashSet hashSet = (HashSet)hashMap.get((Object)class_);
                if (hashSet == null || hashSet.size() <= 0 || (object2 = ((Method)this.b.get((Object)class_)).invoke(object, new Object[0])) == null) continue;
                for (Object object3 : hashSet) {
                    b b2 = (b)((a)hashMap2.get((Object)object3.getClass())).a.get((Object)class_);
                    if (b2 == null) continue;
                    a2.a(b2, object3, object2);
                }
            }
        }
    }

    public void a(HashMap<Class<? extends Object>, Object> hashMap, Object object, HashMap<Class<? extends Object>, a> hashMap2, a a2) throws Exception {
        for (Class class_ : this.a.keySet()) {
            Object object2;
            b b2;
            Object object3 = hashMap.get((Object)class_);
            if (object3 == null || (object2 = ((Method)((a)hashMap2.get((Object)object3.getClass())).b.get((Object)class_)).invoke(object3, new Object[0])) == null || (b2 = (b)this.a.get((Object)class_)) == null) continue;
            a2.a(b2, object, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public void b(Object object, HashMap<Class<? extends Object>, Object> hashMap) {
        if (this.b == null) {
            return;
        }
        Iterator iterator = this.b.keySet().iterator();
        do {
            if (!iterator.hasNext()) return;
        } while (hashMap.put((Object)((Class)iterator.next()), object) == null);
        throw new IllegalArgumentException("Unable to register producer, because another producer is already registered, " + object);
    }

    public void c(Object object, HashMap<Class<? extends Object>, HashSet<Object>> hashMap) {
        for (Class class_ : this.a.keySet()) {
            HashSet hashSet = (HashSet)hashMap.get((Object)class_);
            if (hashSet == null) {
                hashSet = new HashSet();
                hashMap.put((Object)class_, (Object)hashSet);
            }
            if (hashSet.add(object)) continue;
            throw new IllegalArgumentException("Unable to registered receiver because it has already been registered: " + object);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void d(Object object, HashMap<Class<? extends Object>, HashSet<Object>> hashMap) {
        boolean bl;
        HashSet hashSet;
        Iterator iterator = this.a.keySet().iterator();
        do {
            if (!iterator.hasNext()) return;
        } while (!(bl = (hashSet = (HashSet)hashMap.get((Object)((Class)iterator.next()))) == null ? true : !hashSet.remove(object)));
        throw new IllegalArgumentException("Unregistering receiver which was not registered before: " + object);
    }

    public static interface a {
        public void a(b var1, Object var2, Object var3) throws Exception;
    }

    public static class b {
        public final Method a;
        public final int b;
        public final String c;

        public b(Method method, c c2) {
            this.a = method;
            this.b = c2.a();
            this.c = c2.b();
        }
    }

}

