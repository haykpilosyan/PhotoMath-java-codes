/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.AssertionError
 *  java.lang.Class
 *  java.lang.IllegalAccessException
 *  java.lang.NoSuchMethodException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.InvocationTargetException
 *  java.lang.reflect.Method
 */
package c.a;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class f<T> {
    private final Class<?> a;
    private final String b;
    private final Class[] c;

    public /* varargs */ f(Class<?> class_, String string, Class ... arrclass) {
        this.a = class_;
        this.b = string;
        this.c = arrclass;
    }

    private Method a(Class<?> class_) {
        Method method;
        if (this.b == null || (method = f.a(class_, this.b, this.c)) != null && this.a != null && !this.a.isAssignableFrom(method.getReturnType())) {
            return null;
        }
        return method;
    }

    private static Method a(Class<?> class_, String string, Class[] arrclass) {
        int n2;
        Method method;
        try {
            method = class_.getMethod(string, arrclass);
        }
        catch (NoSuchMethodException var3_5) {
            return null;
        }
        try {
            n2 = method.getModifiers();
        }
        catch (NoSuchMethodException var5_6) {
            return method;
        }
        if ((n2 & 1) == 0) {
            return null;
        }
        return method;
    }

    public /* varargs */ Object a(T t2, Object ... arrobject) throws InvocationTargetException {
        Method method = this.a(t2.getClass());
        if (method == null) {
            return null;
        }
        try {
            Object object = method.invoke(t2, arrobject);
            return object;
        }
        catch (IllegalAccessException var4_5) {
            return null;
        }
    }

    public boolean a(T t2) {
        if (this.a(t2.getClass()) != null) {
            return true;
        }
        return false;
    }

    public /* varargs */ Object b(T t2, Object ... arrobject) {
        try {
            Object object = this.a(t2, arrobject);
            return object;
        }
        catch (InvocationTargetException var3_4) {
            Throwable throwable = var3_4.getTargetException();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            AssertionError assertionError = new AssertionError((Object)"Unexpected exception");
            assertionError.initCause(throwable);
            throw assertionError;
        }
    }

    public /* varargs */ Object c(T t2, Object ... arrobject) throws InvocationTargetException {
        Method method = this.a(t2.getClass());
        if (method == null) {
            throw new AssertionError((Object)("Method " + this.b + " not supported for object " + t2));
        }
        try {
            Object object = method.invoke(t2, arrobject);
            return object;
        }
        catch (IllegalAccessException var4_5) {
            AssertionError assertionError = new AssertionError((Object)("Unexpectedly could not call: " + (Object)method));
            assertionError.initCause((Throwable)var4_5);
            throw assertionError;
        }
    }

    public /* varargs */ Object d(T t2, Object ... arrobject) {
        try {
            Object object = this.c(t2, arrobject);
            return object;
        }
        catch (InvocationTargetException var3_4) {
            Throwable throwable = var3_4.getTargetException();
            if (throwable instanceof RuntimeException) {
                throw (RuntimeException)throwable;
            }
            AssertionError assertionError = new AssertionError((Object)"Unexpected exception");
            assertionError.initCause(throwable);
            throw assertionError;
        }
    }
}

