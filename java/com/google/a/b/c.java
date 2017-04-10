/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalAccessException
 *  java.lang.InstantiationException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Constructor
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.EnumSet
 *  java.util.LinkedHashMap
 *  java.util.LinkedHashSet
 *  java.util.LinkedList
 *  java.util.Map
 *  java.util.Queue
 *  java.util.Set
 *  java.util.SortedMap
 *  java.util.SortedSet
 *  java.util.TreeMap
 *  java.util.TreeSet
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ConcurrentMap
 *  java.util.concurrent.ConcurrentNavigableMap
 *  java.util.concurrent.ConcurrentSkipListMap
 */
package com.google.a.b;

import com.google.a.b.g;
import com.google.a.b.h;
import com.google.a.b.k;
import com.google.a.c.a;
import com.google.a.m;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public final class c {
    private final Map<Type, com.google.a.h<?>> a;

    public c(Map<Type, com.google.a.h<?>> map) {
        this.a = map;
    }

    private <T> h<T> a(Class<? super T> class_) {
        try {
            final Constructor constructor = class_.getDeclaredConstructor(new Class[0]);
            if (!constructor.isAccessible()) {
                constructor.setAccessible(true);
            }
            h h2 = new h<T>(){

                @Override
                public T a() {
                    Object object;
                    try {
                        object = constructor.newInstance(null);
                    }
                    catch (InstantiationException var3_2) {
                        throw new RuntimeException("Failed to invoke " + (Object)constructor + " with no args", (Throwable)var3_2);
                    }
                    catch (InvocationTargetException var2_3) {
                        throw new RuntimeException("Failed to invoke " + (Object)constructor + " with no args", var2_3.getTargetException());
                    }
                    catch (IllegalAccessException var1_4) {
                        throw new AssertionError((Object)var1_4);
                    }
                    return (T)object;
                }
            };
            return h2;
        }
        catch (NoSuchMethodException var2_4) {
            return null;
        }
    }

    private <T> h<T> a(final Type type, Class<? super T> class_) {
        if (Collection.class.isAssignableFrom(class_)) {
            if (SortedSet.class.isAssignableFrom(class_)) {
                return new h<T>(){

                    @Override
                    public T a() {
                        return (T)new TreeSet();
                    }
                };
            }
            if (EnumSet.class.isAssignableFrom(class_)) {
                return new h<T>(){

                    @Override
                    public T a() {
                        if (type instanceof ParameterizedType) {
                            Type type2 = ((ParameterizedType)type).getActualTypeArguments()[0];
                            if (type2 instanceof Class) {
                                return (T)EnumSet.noneOf((Class)((Class)type2));
                            }
                            throw new m("Invalid EnumSet type: " + type.toString());
                        }
                        throw new m("Invalid EnumSet type: " + type.toString());
                    }
                };
            }
            if (Set.class.isAssignableFrom(class_)) {
                return new h<T>(){

                    @Override
                    public T a() {
                        return (T)new LinkedHashSet();
                    }
                };
            }
            if (Queue.class.isAssignableFrom(class_)) {
                return new h<T>(){

                    @Override
                    public T a() {
                        return (T)new LinkedList();
                    }
                };
            }
            return new h<T>(){

                @Override
                public T a() {
                    return (T)new ArrayList();
                }
            };
        }
        if (Map.class.isAssignableFrom(class_)) {
            if (ConcurrentNavigableMap.class.isAssignableFrom(class_)) {
                return new h<T>(){

                    @Override
                    public T a() {
                        return (T)new ConcurrentSkipListMap();
                    }
                };
            }
            if (ConcurrentMap.class.isAssignableFrom(class_)) {
                return new h<T>(){

                    @Override
                    public T a() {
                        return (T)new ConcurrentHashMap();
                    }
                };
            }
            if (SortedMap.class.isAssignableFrom(class_)) {
                return new h<T>(){

                    @Override
                    public T a() {
                        return (T)new TreeMap();
                    }
                };
            }
            if (type instanceof ParameterizedType && !String.class.isAssignableFrom(a.get(((ParameterizedType)type).getActualTypeArguments()[0]).getRawType())) {
                return new h<T>(){

                    @Override
                    public T a() {
                        return (T)new LinkedHashMap();
                    }
                };
            }
            return new h<T>(){

                @Override
                public T a() {
                    return (T)((Object)new g());
                }
            };
        }
        return null;
    }

    private <T> h<T> b(final Type type, final Class<? super T> class_) {
        return new h<T>(){
            private final k d;

            @Override
            public T a() {
                Object t2;
                try {
                    t2 = this.d.a(class_);
                }
                catch (Exception var1_2) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + (Object)type + ". " + "Register an InstanceCreator with Gson for this type may fix this problem.", (Throwable)var1_2);
                }
                return t2;
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    public <T> h<T> a(a<T> a2) {
        void var6_6;
        final Type type = a2.getType();
        Class<T> class_ = a2.getRawType();
        final com.google.a.h h2 = (com.google.a.h)this.a.get((Object)type);
        if (h2 != null) {
            h h3 = new h<T>(){

                @Override
                public T a() {
                    return h2.a(type);
                }
            };
            return var6_6;
        } else {
            h<T> h4;
            final com.google.a.h h5 = (com.google.a.h)this.a.get(class_);
            if (h5 != null) {
                return new h<T>(){

                    @Override
                    public T a() {
                        return h5.a(type);
                    }
                };
            }
            h<T> h6 = this.a(class_);
            if (h6 != null || (h4 = this.a(type, class_)) != null) return var6_6;
            return this.b(type, class_);
        }
    }

    public String toString() {
        return this.a.toString();
    }

}

