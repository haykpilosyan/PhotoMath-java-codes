/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  d.c
 *  d.e
 *  d.f
 *  d.l
 *  d.m
 *  java.io.IOException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.zip.DataFormatException
 *  java.util.zip.Inflater
 */
package c.a.a;

import c.a.a.f;
import c.a.a.o;
import d.c;
import d.e;
import d.i;
import d.l;
import d.m;
import d.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

class k {
    private final l a;
    private int b;
    private final e c;

    public k(e e2) {
        this.a = new l((t)new i((t)e2){

            /*
             * Enabled aggressive block sorting
             */
            @Override
            public long read(c c2, long l2) throws IOException {
                long l3;
                if (k.this.b == 0 || (l3 = super.read(c2, Math.min((long)l2, (long)k.this.b))) == -1) {
                    return -1;
                }
                k.this.b = (int)((long)k.this.b - l3);
                return l3;
            }
        }, new Inflater(){

            public int inflate(byte[] arrby, int n2, int n3) throws DataFormatException {
                int n4 = super.inflate(arrby, n2, n3);
                if (n4 == 0 && this.needsDictionary()) {
                    this.setDictionary(o.a);
                    n4 = super.inflate(arrby, n2, n3);
                }
                return n4;
            }
        });
        this.c = m.a((t)this.a);
    }

    private d.f b() throws IOException {
        int n2 = this.c.k();
        return this.c.c((long)n2);
    }

    private void c() throws IOException {
        if (this.b > 0) {
            this.a.a();
            if (this.b != 0) {
                throw new IOException("compressedLimit > 0: " + this.b);
            }
        }
    }

    public List<f> a(int n2) throws IOException {
        this.b = n2 + this.b;
        int n3 = this.c.k();
        if (n3 < 0) {
            throw new IOException("numberOfPairs < 0: " + n3);
        }
        if (n3 > 1024) {
            throw new IOException("numberOfPairs > 1024: " + n3);
        }
        ArrayList arrayList = new ArrayList(n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            d.f f2 = this.b().e();
            d.f f3 = this.b();
            if (f2.f() == 0) {
                throw new IOException("name.size == 0");
            }
            arrayList.add((Object)new f(f2, f3));
        }
        this.c();
        return arrayList;
    }

    public void a() throws IOException {
        this.c.close();
    }

}

