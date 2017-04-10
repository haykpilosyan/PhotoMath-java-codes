/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.google.a.b.g.c
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.ClassCastException
 *  java.lang.Comparable
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.AbstractMap
 *  java.util.AbstractSet
 *  java.util.Comparator
 *  java.util.ConcurrentModificationException
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.NoSuchElementException
 *  java.util.Set
 */
package com.google.a.b;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class g<K, V>
extends AbstractMap<K, V>
implements Serializable {
    static final /* synthetic */ boolean f;
    private static final Comparator<Comparable> g;
    Comparator<? super K> a;
    d<K, V> b;
    int c = 0;
    int d = 0;
    final d<K, V> e = new d();
    private g<K, V> h;
    private g<K, V> i;

    /*
     * Enabled aggressive block sorting
     */
    static {
        boolean bl = !g.class.desiredAssertionStatus();
        f = bl;
        g = new Comparator<Comparable>(){

            public int a(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo((Object)comparable2);
            }

            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((Comparable)object, (Comparable)object2);
            }
        };
    }

    public g() {
        this(g);
    }

    /*
     * Enabled aggressive block sorting
     */
    public g(Comparator<? super K> comparator) {
        if (comparator == null) {
            comparator = g;
        }
        this.a = comparator;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(d<K, V> d2) {
        d d3 = d2.b;
        d d4 = d2.c;
        d d5 = d4.b;
        d d6 = d4.c;
        d2.c = d5;
        if (d5 != null) {
            d5.a = d2;
        }
        this.a(d2, d4);
        d4.b = d2;
        d2.a = d4;
        int n2 = d3 != null ? d3.h : 0;
        int n3 = d5 != null ? d5.h : 0;
        int n4 = d2.h = 1 + Math.max((int)n2, (int)n3);
        int n5 = 0;
        if (d6 != null) {
            n5 = d6.h;
        }
        d4.h = 1 + Math.max((int)n4, (int)n5);
    }

    private void a(d<K, V> d2, d<K, V> d3) {
        d d4 = d2.a;
        d2.a = null;
        if (d3 != null) {
            d3.a = d4;
        }
        if (d4 != null) {
            if (d4.b == d2) {
                d4.b = d3;
                return;
            }
            if (!f && d4.c != d2) {
                throw new AssertionError();
            }
            d4.c = d3;
            return;
        }
        this.b = d3;
    }

    private boolean a(Object object, Object object2) {
        if (object == object2 || object != null && object.equals(object2)) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(d<K, V> d2) {
        d d3;
        d d4 = d2.b;
        d d5 = d2.c;
        d d6 = d4.b;
        d2.b = d3 = d4.c;
        if (d3 != null) {
            d3.a = d2;
        }
        this.a(d2, d4);
        d4.c = d2;
        d2.a = d4;
        int n2 = d5 != null ? d5.h : 0;
        int n3 = d3 != null ? d3.h : 0;
        int n4 = d2.h = 1 + Math.max((int)n2, (int)n3);
        int n5 = 0;
        if (d6 != null) {
            n5 = d6.h;
        }
        d4.h = 1 + Math.max((int)n4, (int)n5);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(d<K, V> d2, boolean bl) {
        while (d2 != null) {
            int n2;
            d d3;
            d d4 = d2.b;
            int n3 = d4 != null ? d4.h : 0;
            int n4 = n3 - (n2 = (d3 = d2.c) != null ? d3.h : 0);
            if (n4 == -2) {
                int n5;
                d d5;
                d d6 = d3.b;
                int n6 = d6 != null ? d6.h : 0;
                int n7 = n6 - (n5 = (d5 = d3.c) != null ? d5.h : 0);
                if (n7 == -1 || n7 == 0 && !bl) {
                    this.a(d2);
                } else {
                    if (!f && n7 != 1) {
                        throw new AssertionError();
                    }
                    this.b(d3);
                    this.a(d2);
                }
                if (bl) {
                    return;
                }
            } else if (n4 == 2) {
                int n8;
                d d7;
                d d8 = d4.b;
                int n9 = d8 != null ? d8.h : 0;
                int n10 = n9 - (n8 = (d7 = d4.c) != null ? d7.h : 0);
                if (n10 == 1 || n10 == 0 && !bl) {
                    this.b(d2);
                } else {
                    if (!f && n10 != -1) {
                        throw new AssertionError();
                    }
                    this.a(d4);
                    this.b(d2);
                }
                if (bl) return;
            } else if (n4 == 0) {
                d2.h = n3 + 1;
                if (bl) {
                    return;
                }
            } else {
                if (!f && n4 != -1 && n4 != 1) {
                    throw new AssertionError();
                }
                d2.h = 1 + Math.max((int)n3, (int)n2);
                if (!bl) {
                    return;
                }
            }
            d2 = d2.a;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    d<K, V> a(Object object) {
        d<Object, V> d2 = null;
        if (object == null) return d2;
        try {
            d<Object, V> d3 = this.a((K)object, false);
            return d3;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    /*
     * Exception decompiling
     */
    d<K, V> a(K var1_1, boolean var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.util.ConcurrentModificationException
        // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
        // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:841)
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> d2 = this.a(entry.getKey());
        if (d2 == null || !this.a(d2.g, entry.getValue())) return null;
        return d2;
    }

    /*
     * Enabled aggressive block sorting
     */
    void a(d<K, V> d2, boolean bl) {
        if (bl) {
            d2.e.d = d2.d;
            d2.d.e = d2.e;
        }
        d d3 = d2.b;
        d d4 = d2.c;
        d d5 = d2.a;
        if (d3 != null && d4 != null) {
            int n2;
            d d6 = d3.h > d4.h ? d3.b() : d4.a();
            this.a((d<K, V>)d6, false);
            d d7 = d2.b;
            if (d7 != null) {
                n2 = d7.h;
                d6.b = d7;
                d7.a = d6;
                d2.b = null;
            } else {
                n2 = 0;
            }
            d d8 = d2.c;
            int n3 = 0;
            if (d8 != null) {
                n3 = d8.h;
                d6.c = d8;
                d8.a = d6;
                d2.c = null;
            }
            d6.h = 1 + Math.max((int)n2, (int)n3);
            this.a(d2, d6);
            return;
        }
        if (d3 != null) {
            this.a(d2, d3);
            d2.b = null;
        } else if (d4 != null) {
            this.a(d2, d4);
            d2.c = null;
        } else {
            this.a(d2, null);
        }
        this.b(d5, false);
        this.c = -1 + this.c;
        this.d = 1 + this.d;
    }

    d<K, V> b(Object object) {
        d<K, V> d2 = this.a(object);
        if (d2 != null) {
            this.a(d2, true);
        }
        return d2;
    }

    public void clear() {
        d<K, V> d2;
        this.b = null;
        this.c = 0;
        this.d = 1 + this.d;
        d2.e = d2 = this.e;
        d2.d = d2;
    }

    public boolean containsKey(Object object) {
        if (this.a(object) != null) {
            return true;
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        a a2;
        g<K, V> g2 = this.h;
        if (g2 != null) {
            return g2;
        }
        this.h = a2 = new a();
        return a2;
    }

    public V get(Object object) {
        d<K, V> d2 = this.a(object);
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    public Set<K> keySet() {
        b b2;
        g<K, V> g2 = this.i;
        if (g2 != null) {
            return g2;
        }
        this.i = b2 = new b();
        return b2;
    }

    public V put(K k2, V v2) {
        if (k2 == null) {
            throw new NullPointerException("key == null");
        }
        d<K, V> d2 = this.a(k2, true);
        Object v3 = d2.g;
        d2.g = v2;
        return v3;
    }

    public V remove(Object object) {
        d<K, V> d2 = this.b(object);
        if (d2 != null) {
            return d2.g;
        }
        return null;
    }

    public int size() {
        return this.c;
    }

    class a
    extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        public void clear() {
            g.this.clear();
        }

        public boolean contains(Object object) {
            if (object instanceof Map.Entry && g.this.a((Map.Entry)object) != null) {
                return true;
            }
            return false;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new com.google.a.b.g.c<Map.Entry<K, V>>(){

                public Map.Entry<K, V> a() {
                    return this.b();
                }

                public /* synthetic */ Object next() {
                    return this.a();
                }
            };
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean remove(Object object) {
            d d2;
            if (!(object instanceof Map.Entry) || (d2 = g.this.a((Map.Entry)object)) == null) {
                return false;
            }
            g.this.a(d2, true);
            return true;
        }

        public int size() {
            return g.this.c;
        }

    }

    final class b
    extends AbstractSet<K> {
        b() {
        }

        public void clear() {
            g.this.clear();
        }

        public boolean contains(Object object) {
            return g.this.containsKey(object);
        }

        public Iterator<K> iterator() {
            return new g<K, V>(){

                public K next() {
                    return this.b().f;
                }
            };
        }

        public boolean remove(Object object) {
            if (g.this.b(object) != null) {
                return true;
            }
            return false;
        }

        public int size() {
            return g.this.c;
        }

    }

    private abstract class c<T>
    implements Iterator<T> {
        d<K, V> b;
        d<K, V> c;
        int d;

        c() {
            this.b = g.this.e.d;
            this.c = null;
            this.d = g.this.d;
        }

        final d<K, V> b() {
            d<K, V> d2 = this.b;
            if (d2 == g.this.e) {
                throw new NoSuchElementException();
            }
            if (g.this.d != this.d) {
                throw new ConcurrentModificationException();
            }
            this.b = d2.d;
            this.c = d2;
            return d2;
        }

        public final boolean hasNext() {
            if (this.b != g.this.e) {
                return true;
            }
            return false;
        }

        public final void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            g.this.a(this.c, true);
            this.c = null;
            this.d = g.this.d;
        }
    }

    static final class d<K, V>
    implements Map.Entry<K, V> {
        d<K, V> a;
        d<K, V> b;
        d<K, V> c;
        d<K, V> d;
        d<K, V> e;
        final K f;
        V g;
        int h;

        d() {
            this.f = null;
            this.e = this;
            this.d = this;
        }

        d(d<K, V> d2, K k2, d<K, V> d3, d<K, V> d4) {
            this.a = d2;
            this.f = k2;
            this.h = 1;
            this.d = d3;
            this.e = d4;
            d4.d = this;
            d3.e = this;
        }

        public d<K, V> a() {
            d<K, V> d2 = d4.b;
            while (d2 != null) {
                d<K, V> d3 = d2.b;
                d<K, V> d4 = d2;
                d2 = d3;
            }
            return d4;
        }

        public d<K, V> b() {
            d<K, V> d2 = d4.c;
            while (d2 != null) {
                d<K, V> d3 = d2.c;
                d<K, V> d4 = d2;
                d2 = d3;
            }
            return d4;
        }

        /*
         * Enabled aggressive block sorting
         */
        public boolean equals(Object object) {
            boolean bl = object instanceof Map.Entry;
            boolean bl2 = false;
            if (!bl) return bl2;
            Map.Entry entry = (Map.Entry)object;
            if (this.f == null) {
                Object object2 = entry.getKey();
                bl2 = false;
                if (object2 != null) return bl2;
            } else {
                boolean bl3 = this.f.equals(entry.getKey());
                bl2 = false;
                if (!bl3) return bl2;
            }
            if (this.g == null) {
                Object object3 = entry.getValue();
                bl2 = false;
                if (object3 != null) return bl2;
                return true;
            } else {
                boolean bl4 = this.g.equals(entry.getValue());
                bl2 = false;
                if (!bl4) return bl2;
            }
            return true;
        }

        public K getKey() {
            return this.f;
        }

        public V getValue() {
            return this.g;
        }

        /*
         * Enabled aggressive block sorting
         */
        public int hashCode() {
            int n2 = this.f == null ? 0 : this.f.hashCode();
            V v2 = this.g;
            int n3 = 0;
            if (v2 == null) {
                return n2 ^ n3;
            }
            n3 = this.g.hashCode();
            return n2 ^ n3;
        }

        public V setValue(V v2) {
            V v3 = this.g;
            this.g = v2;
            return v3;
        }

        public String toString() {
            return this.f + "=" + this.g;
        }
    }

}

