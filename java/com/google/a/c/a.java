/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.util.HashMap
 *  java.util.Map
 */
package com.google.a.c;

import com.google.a.b.b;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

public class a<T> {
    final int hashCode;
    final Class<? super T> rawType;
    final Type type;

    protected a() {
        this.type = a.getSuperclassTypeParameter(this.getClass());
        this.rawType = b.e(this.type);
        this.hashCode = this.type.hashCode();
    }

    a(Type type) {
        this.type = b.d(com.google.a.b.a.a(type));
        this.rawType = b.e(this.type);
        this.hashCode = this.type.hashCode();
    }

    private static /* varargs */ AssertionError buildUnexpectedTypeError(Type type, Class<?> ... arrclass) {
        StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
        int n2 = arrclass.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            stringBuilder.append(arrclass[i2].getName()).append(", ");
        }
        stringBuilder.append("but got: ").append(type.getClass().getName()).append(", for type token: ").append(type.toString()).append('.');
        return new AssertionError((Object)stringBuilder.toString());
    }

    public static <T> a<T> get(Class<T> class_) {
        return new a<T>((Type)class_);
    }

    public static a<?> get(Type type) {
        return new a<T>(type);
    }

    static Type getSuperclassTypeParameter(Class<?> class_) {
        Type type = class_.getGenericSuperclass();
        if (type instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.d(((ParameterizedType)type).getActualTypeArguments()[0]);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean isAssignableFrom(Type type, GenericArrayType genericArrayType) {
        Type type2 = genericArrayType.getGenericComponentType();
        if (!(type2 instanceof ParameterizedType)) {
            return true;
        }
        if (type instanceof GenericArrayType) {
            type = ((GenericArrayType)type).getGenericComponentType();
            return a.isAssignableFrom(type, (ParameterizedType)type2, new HashMap());
        } else {
            if (!(type instanceof Class)) return a.isAssignableFrom(type, (ParameterizedType)type2, new HashMap());
            {
                type = (Class)type;
                while (type.isArray()) {
                    type = type.getComponentType();
                }
            }
        }
        return a.isAssignableFrom(type, (ParameterizedType)type2, new HashMap());
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean isAssignableFrom(Type type, ParameterizedType parameterizedType, Map<String, Type> map) {
        int n2 = 0;
        if (type == null) {
            return false;
        }
        if (parameterizedType.equals((Object)type)) {
            return true;
        }
        Class class_ = b.e(type);
        ParameterizedType parameterizedType2 = type instanceof ParameterizedType ? (ParameterizedType)type : null;
        if (parameterizedType2 != null) {
            Type[] arrtype = parameterizedType2.getActualTypeArguments();
            TypeVariable[] arrtypeVariable = class_.getTypeParameters();
            for (int i2 = 0; i2 < arrtype.length; ++i2) {
                Type type2 = arrtype[i2];
                TypeVariable typeVariable = arrtypeVariable[i2];
                while (type2 instanceof TypeVariable) {
                    type2 = (Type)map.get((Object)((TypeVariable)type2).getName());
                }
                map.put((Object)typeVariable.getName(), (Object)type2);
            }
            if (a.typeEquals(parameterizedType2, parameterizedType, map)) {
                return true;
            }
        }
        Type[] arrtype = class_.getGenericInterfaces();
        int n3 = arrtype.length;
        while (n2 < n3) {
            if (a.isAssignableFrom(arrtype[n2], parameterizedType, new HashMap(map))) {
                return true;
            }
            ++n2;
        }
        return a.isAssignableFrom(class_.getGenericSuperclass(), parameterizedType, new HashMap(map));
    }

    private static boolean matches(Type type, Type type2, Map<String, Type> map) {
        if (type2.equals((Object)type) || type instanceof TypeVariable && type2.equals(map.get((Object)((TypeVariable)type).getName()))) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean typeEquals(ParameterizedType parameterizedType, ParameterizedType parameterizedType2, Map<String, Type> map) {
        if (!parameterizedType.getRawType().equals((Object)parameterizedType2.getRawType())) return false;
        Type[] arrtype = parameterizedType.getActualTypeArguments();
        Type[] arrtype2 = parameterizedType2.getActualTypeArguments();
        int n2 = 0;
        while (n2 < arrtype.length) {
            if (!a.matches(arrtype[n2], arrtype2[n2], map)) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public final boolean equals(Object object) {
        if (object instanceof a && b.a(this.type, ((a)object).type)) {
            return true;
        }
        return false;
    }

    public final Class<? super T> getRawType() {
        return this.rawType;
    }

    public final Type getType() {
        return this.type;
    }

    public final int hashCode() {
        return this.hashCode;
    }

    @Deprecated
    public boolean isAssignableFrom(a<?> a2) {
        return this.isAssignableFrom(a2.getType());
    }

    @Deprecated
    public boolean isAssignableFrom(Class<?> class_) {
        return this.isAssignableFrom((Type)class_);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Deprecated
    public boolean isAssignableFrom(Type type) {
        if (type == null) {
            return false;
        }
        if (this.type.equals((Object)type)) {
            return true;
        }
        if (this.type instanceof Class) {
            return this.rawType.isAssignableFrom(b.e(type));
        }
        if (this.type instanceof ParameterizedType) {
            return a.isAssignableFrom(type, (ParameterizedType)this.type, new HashMap());
        }
        if (!(this.type instanceof GenericArrayType)) throw a.buildUnexpectedTypeError(this.type, Class.class, ParameterizedType.class, GenericArrayType.class);
        if (!this.rawType.isAssignableFrom(b.e(type))) return false;
        if (!a.isAssignableFrom(type, (GenericArrayType)this.type)) return false;
        return true;
    }

    public final String toString() {
        return b.f(this.type);
    }
}

