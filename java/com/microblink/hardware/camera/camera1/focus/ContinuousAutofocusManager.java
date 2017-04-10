/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Rect
 *  android.hardware.Camera
 *  android.hardware.Camera$Area
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$AutoFocusMoveCallback
 *  android.hardware.Camera$Parameters
 *  com.microblink.util.Log
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 */
package com.microblink.hardware.camera.camera1.focus;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.Camera;
import com.microblink.hardware.DeviceManager;
import com.microblink.hardware.camera.AutofocusListener;
import com.microblink.hardware.camera.camera1.focus.IFocusManager;
import com.microblink.util.Log;
import java.util.ArrayList;
import java.util.List;

@TargetApi(value=16)
public class ContinuousAutofocusManager
implements IFocusManager {
    private AutofocusListener mAfStatusView = null;
    private Camera mCamera;
    private DeviceManager mDeviceManager;
    private Rect[] mFocusAreas = null;
    private boolean mFocusInProgress = false;
    private boolean mFocusPaused = false;
    private boolean mFocused = false;
    private boolean mFullAutofocusInProgress = false;
    private boolean mMacroMode = false;

    public ContinuousAutofocusManager(AutofocusListener autofocusListener, DeviceManager deviceManager, boolean bl) {
        this.mAfStatusView = autofocusListener;
        this.mDeviceManager = deviceManager;
        if (!this.mDeviceManager.hasDeviceListsLoaded()) {
            throw new IllegalArgumentException("Device manager needs to have device lists loaded");
        }
        this.mMacroMode = bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void cancelOngoingFocus() {
        if (this.mCamera == null || !this.mFullAutofocusInProgress) return;
        try {
            this.mCamera.cancelAutoFocus();
            Camera.Parameters parameters = this.mCamera.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.mCamera.setParameters(parameters);
            return;
        }
        catch (RuntimeException var1_2) {
            Log.w((Object)this, (Throwable)var1_2, (String)"Failed to resume continuous autofocus because attempt to modify camera parameters failed or because autofocus cancelling has failed.", (Object[])new Object[0]);
            return;
        }
    }

    @Override
    public void checkFocus() {
    }

    @Override
    public void dispose() {
        this.mCamera = null;
        this.mAfStatusView = null;
        this.mFocusAreas = null;
        this.mDeviceManager = null;
    }

    /*
     * Exception decompiling
     */
    @Override
    public void doAutofocus(boolean var1_1) {
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

    @Override
    public void invalidateFocus() {
        this.mFocused = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean isAutofocusing() {
        Object[] arrobject = new Object[]{this.mFocusInProgress, this.mFullAutofocusInProgress};
        Log.v((Object)this, (String)"Focus in progress: {}, full autofocus in progress: {}", (Object[])arrobject);
        if (this.mFocusInProgress) return true;
        boolean bl = this.mFullAutofocusInProgress;
        boolean bl2 = false;
        if (!bl) return bl2;
        return true;
    }

    @Override
    public boolean isCameraFocused() {
        return this.mFocused;
    }

    @Override
    public boolean isFocusManagerPaused() {
        return this.mFocusPaused;
    }

    @Override
    public void pauseFocusing() {
        this.mFocusPaused = true;
    }

    @Override
    public void resumeFocusing() {
        this.mFocusPaused = false;
    }

    @Override
    public void setCamera(Camera camera) {
        if (camera == null) {
            if (this.mCamera != null) {
                this.mCamera.setAutoFocusMoveCallback(null);
            }
            this.mCamera = null;
            return;
        }
        this.mCamera = camera;
        this.mCamera.setAutoFocusMoveCallback(new Camera.AutoFocusMoveCallback(){

            /*
             * Enabled aggressive block sorting
             */
            public void onAutoFocusMoving(boolean bl, Camera camera) {
                ContinuousAutofocusManager continuousAutofocusManager = ContinuousAutofocusManager.this;
                Object[] arrobject = new Object[]{bl};
                Log.d((Object)continuousAutofocusManager, (String)"Autofocus move callback start: {}", (Object[])arrobject);
                if (bl) {
                    ContinuousAutofocusManager.this.mFocusInProgress = true;
                } else {
                    ContinuousAutofocusManager.this.mFocusInProgress = false;
                }
                if (ContinuousAutofocusManager.this.mAfStatusView != null) {
                    if (!bl) {
                        ContinuousAutofocusManager.this.mAfStatusView.onAutofocusStopped(ContinuousAutofocusManager.this.mFocusAreas);
                        ContinuousAutofocusManager.this.mFocused = true;
                        return;
                    }
                    ContinuousAutofocusManager.this.mAfStatusView.onAutofocusStarted(ContinuousAutofocusManager.this.mFocusAreas);
                    ContinuousAutofocusManager.this.mFocused = false;
                }
            }
        });
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @Override
    public void setMeteringAreas(Rect[] var1_1) {
        if (this.mCamera != null) {
            try {
                var3_2 = this.mCamera.getParameters();
                ** if (var1_1 != null) goto lbl-1000
            }
            catch (RuntimeException var2_3) {
                Log.w((Object)this, (Throwable)var2_3, (String)"Failed to obtain camera paremeters. Cannot set metering areas!", (Object[])new Object[0]);
                return;
            }
lbl-1000: // 1 sources:
            {
                var3_2.setMeteringAreas(null);
                var3_2.setFocusAreas(null);
lbl7: // 2 sources:
                do {
                    this.mCamera.setParameters(var3_2);
                    this.mFocusAreas = var1_1;
                    return;
                    break;
                } while (true);
            }
lbl-1000: // 1 sources:
            {
            }
            var4_4 = new ArrayList();
            for (var5_5 = 0; var5_5 < var3_2.getMaxNumFocusAreas() && var5_5 < var1_1.length; ++var5_5) {
                var11_6 = new Object[]{var1_1[var5_5]};
                Log.d((Object)this, (String)"Adding focus area {}", (Object[])var11_6);
                var4_4.add((Object)new Camera.Area(var1_1[var5_5], 1000));
            }
            var6_7 = new ArrayList();
            for (var7_8 = 0; var7_8 < var3_2.getMaxNumMeteringAreas() && var7_8 < var1_1.length; ++var7_8) {
                var9_9 = new Object[]{var1_1[var7_8]};
                Log.d((Object)this, (String)"Adding metering area {}", (Object[])var9_9);
                var6_7.add((Object)new Camera.Area(var1_1[var7_8], 1000));
            }
            var3_2.setMeteringAreas((List)var6_7);
            var3_2.setFocusAreas((List)var4_4);
            ** continue;
            catch (RuntimeException var8_10) {
                Log.e((Object)this, (String)"Failed to apply new camera parameters!", (Object[])new Object[0]);
                return;
            }
        }
        Log.w((Object)this, (String)"Cannot set focus area, camera is null", (Object[])new Object[0]);
    }

}

