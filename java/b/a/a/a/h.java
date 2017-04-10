/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 */
package b.a.a.a;

import b.a.a.a.a.b.t;
import b.a.a.a.a.c.e;
import b.a.a.a.a.c.f;
import b.a.a.a.a.c.m;
import b.a.a.a.c;
import b.a.a.a.g;
import b.a.a.a.i;

class h<Result>
extends f<Void, Void, Result> {
    final i<Result> a;

    public h(i<Result> i2) {
        this.a = i2;
    }

    private t a(String string) {
        t t2 = new t(this.a.b() + "." + string, "KitInitialization");
        t2.a();
        return t2;
    }

    protected /* varargs */ Result a(Void ... arrvoid) {
        t t2 = this.a("doInBackground");
        boolean bl = this.e();
        Result Result = null;
        if (!bl) {
            Result = this.a.f();
        }
        t2.b();
        return Result;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    protected void a() {
        super.a();
        t t2 = this.a("onPreExecute");
        try {
            boolean bl = this.a.a_();
            t2.b();
            if (bl) return;
        }
        catch (m var6_3) {
            throw var6_3;
            {
                catch (Throwable throwable) {
                    throw throwable;
                }
            }
            catch (Exception exception) {
                c.h().e("Fabric", "Failure onPreExecute()", (Throwable)exception);
                return;
            }
        }
        finally {
            t2.b();
            this.a(true);
        }
        this.a(true);
        return;
    }

    @Override
    protected void a(Result Result) {
        this.a.a(Result);
        this.a.h.a(Result);
    }

    @Override
    public e b() {
        return e.c;
    }

    @Override
    protected void b(Result Result) {
        this.a.b(Result);
        g g2 = new g(this.a.b() + " Initialization was cancelled");
        this.a.h.a((Exception)g2);
    }
}

