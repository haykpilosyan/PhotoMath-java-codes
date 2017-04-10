/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.RemoteException
 *  java.lang.Exception
 *  java.lang.InterruptedException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.TimeUnit
 */
package b.a.a.a.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import b.a.a.a.a.b.f;
import b.a.a.a.c;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class e
implements f {
    private final Context a;

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public b.a.a.a.a.b.b a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c.h().a("Fabric", "AdvertisingInfoServiceStrategy cannot be called on the main thread");
            return null;
        }
        this.a.getPackageManager().getPackageInfo("com.android.vending", 0);
        var4_1 = new a();
        var5_2 = new Intent("com.google.android.gms.ads.identifier.service.START");
        var5_2.setPackage("com.google.android.gms");
        var8_3 = this.a.bindService(var5_2, (ServiceConnection)var4_1, 1);
        ** if (!var8_3) goto lbl-1000
lbl-1000: // 1 sources:
        {
            var9_4 = new b(var4_1.a());
            var10_5 = new b.a.a.a.a.b.b(var9_4.a(), var9_4.b());
            this.a.unbindService((ServiceConnection)var4_1);
            return var10_5;
        }
lbl-1000: // 1 sources:
        {
        }
        catch (PackageManager.NameNotFoundException var2_6) {
            c.h().a("Fabric", "Unable to find Google Play Services package name");
            return null;
        }
        catch (Exception var1_7) {
            c.h().a("Fabric", "Unable to determine if Google Play Services is available", (Throwable)var1_7);
            return null;
        }
        catch (Exception var12_8) {
            c.h().d("Fabric", "Exception in binding to Google Play Service to capture AdvertisingId", (Throwable)var12_8);
            this.a.unbindService((ServiceConnection)var4_1);
            return null;
            {
                catch (Throwable var7_9) {
                    c.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId", var7_9);
                    return null;
                }
            }
            catch (Throwable var11_10) {
                this.a.unbindService((ServiceConnection)var4_1);
                throw var11_10;
            }
        }
        c.h().a("Fabric", "Could not bind to Google Play Service to capture AdvertisingId");
        return null;
    }

    private static final class a
    implements ServiceConnection {
        private boolean a = false;
        private final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue(1);

        private a() {
        }

        public IBinder a() {
            if (this.a) {
                c.h().e("Fabric", "getBinder already called");
            }
            this.a = true;
            try {
                IBinder iBinder = (IBinder)this.b.poll(200, TimeUnit.MILLISECONDS);
                return iBinder;
            }
            catch (InterruptedException var1_2) {
                return null;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.b.put((Object)iBinder);
                return;
            }
            catch (InterruptedException var3_3) {
                return;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.b.clear();
        }
    }

    private static final class b
    implements IInterface {
        private final IBinder a;

        public b(IBinder iBinder) {
            this.a = iBinder;
        }

        public String a() throws RemoteException {
            Parcel parcel = Parcel.obtain();
            Parcel parcel2 = Parcel.obtain();
            try {
                parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.a.transact(1, parcel, parcel2, 0);
                parcel2.readException();
                String string = parcel2.readString();
                return string;
            }
            catch (Exception var4_4) {
                c.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
                return null;
            }
            finally {
                parcel2.recycle();
                parcel.recycle();
            }
        }

        public IBinder asBinder() {
            return this.a;
        }

        /*
         * Exception decompiling
         */
        public boolean b() throws RemoteException {
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
            // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
            // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
            // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
            // org.benf.cfr.reader.Main.doJar(Main.java:128)
            // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
            // java.lang.Thread.run(Thread.java:841)
            throw new IllegalStateException("Decompilation failed");
        }
    }

}

