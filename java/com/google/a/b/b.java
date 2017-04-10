/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.lang.reflect.GenericArrayType
 *  java.lang.reflect.GenericDeclaration
 *  java.lang.reflect.Modifier
 *  java.lang.reflect.ParameterizedType
 *  java.lang.reflect.Type
 *  java.lang.reflect.TypeVariable
 *  java.lang.reflect.WildcardType
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Map
 *  java.util.NoSuchElementException
 *  java.util.Properties
 */
package com.google.a.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class b {
    static final Type[] a = new Type[0];

    static int a(Object object) {
        if (object != null) {
            return object.hashCode();
        }
        return 0;
    }

    private static int a(Object[] arrobject, Object object) {
        for (int i2 = 0; i2 < arrobject.length; ++i2) {
            if (!object.equals(arrobject[i2])) continue;
            return i2;
        }
        throw new NoSuchElementException();
    }

    private static Class<?> a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class)genericDeclaration;
        }
        return null;
    }

    public static GenericArrayType a(Type type) {
        return new a(type);
    }

    public static /* varargs */ ParameterizedType a(Type type, Type type2, Type ... arrtype) {
        return new b(type, type2, arrtype);
    }

    public static Type a(Type type, Class<?> class_) {
        Type type2 = b.b(type, class_, Collection.class);
        if (type2 instanceof WildcardType) {
            type2 = ((WildcardType)type2).getUpperBounds()[0];
        }
        if (type2 instanceof ParameterizedType) {
            return ((ParameterizedType)type2).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    static Type a(Type type, Class<?> class_, Class<?> class_2) {
        if (class_2 == class_) {
            return type;
        }
        if (class_2.isInterface()) {
            Class[] arrclass = class_.getInterfaces();
            int n2 = arrclass.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (arrclass[i2] == class_2) {
                    return class_.getGenericInterfaces()[i2];
                }
                if (!class_2.isAssignableFrom(arrclass[i2])) continue;
                return b.a(class_.getGenericInterfaces()[i2], arrclass[i2], class_2);
            }
        }
        if (!class_.isInterface()) {
            while (class_ != Object.class) {
                Class class_3 = class_.getSuperclass();
                if (class_3 == class_2) {
                    return class_.getGenericSuperclass();
                }
                if (class_2.isAssignableFrom(class_3)) {
                    return b.a(class_.getGenericSuperclass(), class_3, class_2);
                }
                class_ = class_3;
            }
        }
        return class_2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static Type a(Type type, Class<?> class_, Type type2) {
        Type type3 = type2;
        while (type3 instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable)type3;
            Type type4 = b.a(type, class_, typeVariable);
            if (type4 == typeVariable) {
                return type4;
            }
            type3 = type4;
        }
        if (type3 instanceof Class && ((Class)type3).isArray()) {
            Type type5;
            Class class_2 = (type3 = (Class)type3).getComponentType();
            if (class_2 == (type5 = b.a(type, class_, (Type)class_2))) return type3;
            return b.a(type5);
        }
        if (type3 instanceof GenericArrayType) {
            Type type6;
            Type type7 = (type3 = (GenericArrayType)type3).getGenericComponentType();
            if (type7 == (type6 = b.a(type, class_, type7))) return type3;
            return b.a(type6);
        }
        if (type3 instanceof ParameterizedType) {
            Type type8 = (type3 = (ParameterizedType)type3).getOwnerType();
            Type type9 = b.a(type, class_, type8);
            boolean bl = type9 != type8;
            Type[] arrtype = type3.getActualTypeArguments();
            int n2 = arrtype.length;
            boolean bl2 = bl;
            Type[] arrtype2 = arrtype;
            for (int i2 = 0; i2 < n2; ++i2) {
                Type type10 = b.a(type, class_, arrtype2[i2]);
                if (type10 == arrtype2[i2]) continue;
                if (!bl2) {
                    arrtype2 = (Type[])arrtype2.clone();
                    bl2 = true;
                }
                arrtype2[i2] = type10;
            }
            if (!bl2) return type3;
            return b.a(type9, type3.getRawType(), arrtype2);
        }
        if (!(type3 instanceof WildcardType)) return type3;
        type3 = (WildcardType)type3;
        Type[] arrtype = type3.getLowerBounds();
        Type[] arrtype3 = type3.getUpperBounds();
        if (arrtype.length == 1) {
            Type type11 = b.a(type, class_, arrtype[0]);
            if (type11 == arrtype[0]) return type3;
            return b.c(type11);
        }
        if (arrtype3.length != 1) return type3;
        Type type12 = b.a(type, class_, arrtype3[0]);
        if (type12 == arrtype3[0]) return type3;
        return b.b(type12);
    }

    /*
     * Enabled aggressive block sorting
     */
    static Type a(Type type, Class<?> class_, TypeVariable<?> typeVariable) {
        Type type2;
        Class class_2 = b.a(typeVariable);
        if (class_2 == null || !((type2 = b.a(type, class_, class_2)) instanceof ParameterizedType)) {
            return typeVariable;
        }
        int n2 = b.a((Object[])class_2.getTypeParameters(), typeVariable);
        return ((ParameterizedType)type2).getActualTypeArguments()[n2];
    }

    static boolean a(Object object, Object object2) {
        if (object == object2 || object != null && object.equals(object2)) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(Type type, Type type2) {
        boolean bl;
        boolean bl2 = true;
        if (type == type2) {
            return bl2;
        }
        if (type instanceof Class) {
            return type.equals((Object)type2);
        }
        if (type instanceof ParameterizedType) {
            boolean bl3 = type2 instanceof ParameterizedType;
            bl = false;
            if (!bl3) return bl;
            ParameterizedType parameterizedType = (ParameterizedType)type;
            ParameterizedType parameterizedType2 = (ParameterizedType)type2;
            if (!b.a((Object)parameterizedType.getOwnerType(), (Object)parameterizedType2.getOwnerType())) return false;
            if (!parameterizedType.getRawType().equals((Object)parameterizedType2.getRawType())) return false;
            if (!Arrays.equals((Object[])parameterizedType.getActualTypeArguments(), (Object[])parameterizedType2.getActualTypeArguments())) return false;
            return bl2;
        }
        if (type instanceof GenericArrayType) {
            boolean bl4 = type2 instanceof GenericArrayType;
            bl = false;
            if (!bl4) return bl;
            GenericArrayType genericArrayType = (GenericArrayType)type;
            GenericArrayType genericArrayType2 = (GenericArrayType)type2;
            return b.a(genericArrayType.getGenericComponentType(), genericArrayType2.getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            boolean bl5 = type2 instanceof WildcardType;
            bl = false;
            if (!bl5) return bl;
            WildcardType wildcardType = (WildcardType)type;
            WildcardType wildcardType2 = (WildcardType)type2;
            if (!Arrays.equals((Object[])wildcardType.getUpperBounds(), (Object[])wildcardType2.getUpperBounds())) return false;
            if (!Arrays.equals((Object[])wildcardType.getLowerBounds(), (Object[])wildcardType2.getLowerBounds())) return false;
            return bl2;
        }
        boolean bl6 = type instanceof TypeVariable;
        bl = false;
        if (!bl6) return bl;
        boolean bl7 = type2 instanceof TypeVariable;
        bl = false;
        if (!bl7) return bl;
        TypeVariable typeVariable = (TypeVariable)type;
        TypeVariable typeVariable2 = (TypeVariable)type2;
        if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration()) return false;
        if (!typeVariable.getName().equals((Object)typeVariable2.getName())) return false;
        return bl2;
    }

    static Type b(Type type, Class<?> class_, Class<?> class_2) {
        com.google.a.b.a.a(class_2.isAssignableFrom(class_));
        return b.a(type, class_, b.a(type, class_, class_2));
    }

    public static WildcardType b(Type type) {
        return new c(new Type[]{type}, a);
    }

    public static Type[] b(Type type, Class<?> class_) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type type2 = b.b(type, class_, Map.class);
        if (type2 instanceof ParameterizedType) {
            return ((ParameterizedType)type2).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static WildcardType c(Type type) {
        return new c(new Type[]{Object.class}, new Type[]{type});
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Type d(Type type) {
        if (type instanceof Class) {
            Object object;
            Class class_ = (Class)type;
            if (class_.isArray()) {
                object = new a(b.d((Type)class_.getComponentType()));
                do {
                    return (Type)object;
                    break;
                } while (true);
            }
            object = class_;
            return (Type)object;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            return new b(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new a(((GenericArrayType)type).getGenericComponentType());
        }
        if (!(type instanceof WildcardType)) return type;
        WildcardType wildcardType = (WildcardType)type;
        return new c(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Class<?> e(Type type) {
        String string;
        if (type instanceof Class) {
            return (Class)type;
        }
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType)type).getRawType();
            com.google.a.b.a.a(type2 instanceof Class);
            return (Class)type2;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(b.e(((GenericArrayType)type).getGenericComponentType()), (int)0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return b.e(((WildcardType)type).getUpperBounds()[0]);
        }
        if (type == null) {
            string = "null";
            do {
                throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + (Object)type + "> is of type " + string);
                break;
            } while (true);
        }
        string = type.getClass().getName();
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + (Object)type + "> is of type " + string);
    }

    public static String f(Type type) {
        if (type instanceof Class) {
            return ((Class)type).getName();
        }
        return type.toString();
    }

    public static Type g(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType)type).getGenericComponentType();
        }
        return ((Class)type).getComponentType();
    }

    /*
     * Enabled aggressive block sorting
     */
    static void h(Type type) {
        boolean bl = !(type instanceof Class) || !((Class)type).isPrimitive();
        com.google.a.b.a.a(bl);
    }

    private static final class a
    implements Serializable,
    GenericArrayType {
        private final Type a;

        public a(Type type) {
            this.a = b.d(type);
        }

        public boolean equals(Object object) {
            if (object instanceof GenericArrayType && b.a((Type)this, (Type)((GenericArrayType)object))) {
                return true;
            }
            return false;
        }

        public Type getGenericComponentType() {
            return this.a;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return b.f(this.a) + "[]";
        }
    }

    private static final class b
    implements Serializable,
    ParameterizedType {
        private final Type a;
        private final Type b;
        private final Type[] c;

        /*
         * Enabled aggressive block sorting
         */
        public /* varargs */ b(Type type, Type type2, Type ... arrtype) {
            int n2 = 0;
            if (type2 instanceof Class) {
                Class class_ = (Class)type2;
                boolean bl = Modifier.isStatic((int)class_.getModifiers()) || class_.getEnclosingClass() == null;
                boolean bl2 = type != null || bl;
                com.google.a.b.a.a(bl2);
            }
            Type type3 = type == null ? null : b.d(type);
            this.a = type3;
            this.b = b.d(type2);
            this.c = (Type[])arrtype.clone();
            while (n2 < this.c.length) {
                com.google.a.b.a.a(this.c[n2]);
                b.h(this.c[n2]);
                this.c[n2] = b.d(this.c[n2]);
                ++n2;
            }
            return;
        }

        public boolean equals(Object object) {
            if (object instanceof ParameterizedType && b.a((Type)this, (Type)((ParameterizedType)object))) {
                return true;
            }
            return false;
        }

        public Type[] getActualTypeArguments() {
            return (Type[])this.c.clone();
        }

        public Type getOwnerType() {
            return this.a;
        }

        public Type getRawType() {
            return this.b;
        }

        public int hashCode() {
            return Arrays.hashCode((Object[])this.c) ^ this.b.hashCode() ^ b.a((Object)this.a);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(30 * (1 + this.c.length));
            stringBuilder.append(b.f(this.b));
            if (this.c.length == 0) {
                return stringBuilder.toString();
            }
            stringBuilder.append("<").append(b.f(this.c[0]));
            for (int i2 = 1; i2 < this.c.length; ++i2) {
                stringBuilder.append(", ").append(b.f(this.c[i2]));
            }
            return stringBuilder.append(">").toString();
        }
    }

    private static final class c
    implements Serializable,
    WildcardType {
        private final Type a;
        private final Type b;

        /*
         * Enabled aggressive block sorting
         */
        public c(Type[] arrtype, Type[] arrtype2) {
            boolean bl = true;
            boolean bl2 = arrtype2.length <= bl ? bl : false;
            com.google.a.b.a.a(bl2);
            boolean bl3 = arrtype.length == bl ? bl : false;
            com.google.a.b.a.a(bl3);
            if (arrtype2.length != bl) {
                com.google.a.b.a.a(arrtype[0]);
                b.h(arrtype[0]);
                this.b = null;
                this.a = b.d(arrtype[0]);
                return;
            }
            com.google.a.b.a.a(arrtype2[0]);
            b.h(arrtype2[0]);
            if (arrtype[0] != Object.class) {
                bl = false;
            }
            com.google.a.b.a.a(bl);
            this.b = b.d(arrtype2[0]);
            this.a = Object.class;
        }

        public boolean equals(Object object) {
            if (object instanceof WildcardType && b.a((Type)this, (Type)((WildcardType)object))) {
                return true;
            }
            return false;
        }

        public Type[] getLowerBounds() {
            if (this.b != null) {
                Type[] arrtype = new Type[]{this.b};
                return arrtype;
            }
            return b.a;
        }

        public Type[] getUpperBounds() {
            Type[] arrtype = new Type[]{this.a};
            return arrtype;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public int hashCode() {
            int n2;
            if (this.b != null) {
                n2 = 31 + this.b.hashCode();
                do {
                    return n2 ^ 31 + this.a.hashCode();
                    break;
                } while (true);
            }
            n2 = 1;
            return n2 ^ 31 + this.a.hashCode();
        }

        public String toString() {
            if (this.b != null) {
                return "? super " + b.f(this.b);
            }
            if (this.a == Object.class) {
                return "?";
            }
            return "? extends " + b.f(this.a);
        }
    }

}

