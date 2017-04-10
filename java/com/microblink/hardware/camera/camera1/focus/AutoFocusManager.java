/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Rect
 *  android.hardware.Camera
 *  android.hardware.Camera$Area
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$Parameters
 *  com.microblink.util.Log
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.List
 *  java.util.Timer
 *  java.util.TimerTask
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
import java.util.Timer;
import java.util.TimerTask;

public class AutoFocusManager
implements IFocusManager {
    private static final int AF_FAIL_TIMEOUT_INTERVAL = 500;
    private static final int AF_TIMEOUT_INTERVAL = 3000;
    private final Camera.AutoFocusCallback mAutofocusCallback;
    protected volatile boolean mAutofocusInProgress;
    protected Camera mCamera;
    private DeviceManager mDeviceManager;
    private Rect[] mFocusAreas = null;
    private volatile boolean mFocusPaused = false;
    protected volatile boolean mFocused = false;
    private int mNumFailedAutofocusAttempts = 0;
    private AutofocusListener mStatusView;
    protected Timer mTimer = null;
    private volatile int reqCnt = 0;

    public AutoFocusManager(AutofocusListener autofocusListener, DeviceManager deviceManager) {
        this.mAutofocusCallback = new Camera.AutoFocusCallback(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            private void setFocusMode(String string) {
                Camera.Parameters parameters;
                if (AutoFocusManager.this.mCamera == null) {
                    return;
                }
                try {
                    parameters = AutoFocusManager.this.mCamera.getParameters();
                }
                catch (RuntimeException var2_6) {
                    Log.w((Object)this, (Throwable)var2_6, (String)"Failed to get camera parameters! Cannot set focus mode!", (Object[])new Object[0]);
                    return;
                }
                List list = parameters.getSupportedFocusModes();
                String string2 = parameters.getFocusMode();
                if (string == null) return;
                if (list == null) return;
                if (!list.contains((Object)string)) return;
                if (string.equals((Object)string2)) return;
                parameters.setFocusMode(string);
                Log.d((Object)AutoFocusManager.this, (String)"Setting focus mode to {}", (Object[])new Object[]{string});
                try {
                    AutoFocusManager.this.mCamera.setParameters(parameters);
                    return;
                }
                catch (RuntimeException var6_5) {
                    Log.e((Object)AutoFocusManager.this, (Throwable)var6_5, (String)"Setting new camera parameters failed!", (Object[])new Object[0]);
                    return;
                }
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            private void toggleAutofocusMode() {
                Camera.Parameters parameters;
                if (AutoFocusManager.this.mCamera == null) {
                    return;
                }
                try {
                    parameters = AutoFocusManager.this.mCamera.getParameters();
                }
                catch (RuntimeException var1_3) {
                    Log.w((Object)this, (Throwable)var1_3, (String)"Failed to get camera parameters. Cannot toggle autofocus mode!", (Object[])new Object[0]);
                    return;
                }
                String string = parameters.getFocusMode();
                if ("macro".equals((Object)string)) {
                    this.setFocusMode("auto");
                    return;
                }
                if (!"auto".equals((Object)string)) return;
                this.setFocusMode("macro");
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onAutoFocus(boolean bl, Camera camera) {
                int n2 = 1;
                if (AutoFocusManager.this.mStatusView != null) {
                    AutoFocusManager.this.mStatusView.onAutofocusStopped(AutoFocusManager.this.mFocusAreas);
                }
                AutoFocusManager.this.mAutofocusInProgress = false;
                AutoFocusManager.access$210(AutoFocusManager.this);
                AutoFocusManager autoFocusManager = AutoFocusManager.this;
                Object[] arrobject = new Object[2];
                arrobject[0] = bl;
                arrobject[n2] = AutoFocusManager.this.reqCnt;
                Log.i((Object)autoFocusManager, (String)"Autofocus request ended with {}. Request count: {}", (Object[])arrobject);
                if (AutoFocusManager.this.mDeviceManager.isFocusCallbackUntrusty()) {
                    Log.i((Object)AutoFocusManager.this, (String)"This is a device with untrusty focus. We will assume that focus has succeeded!", (Object[])new Object[0]);
                    bl = n2;
                }
                AutoFocusManager.this.mFocused = bl;
                if (bl) {
                    AutoFocusManager.this.invalidateFocus(3000);
                    AutoFocusManager.this.mNumFailedAutofocusAttempts = 0;
                    return;
                }
                if (AutoFocusManager.this.mFocusPaused) {
                    return;
                }
                AutoFocusManager.access$508(AutoFocusManager.this);
                if (AutoFocusManager.this.mNumFailedAutofocusAttempts % 2 == 0) {
                    this.toggleAutofocusMode();
                }
                if (AutoFocusManager.this.mNumFailedAutofocusAttempts == 4 && AutoFocusManager.this.mStatusView != null) {
                    AutoFocusManager.this.mStatusView.onAutofocusFailed();
                }
                if (n2 != 0) {
                    AutoFocusManager.this.invalidateFocus(500);
                }
            }
        };
        this.mStatusView = autofocusListener;
        this.mDeviceManager = deviceManager;
        if (!this.mDeviceManager.hasDeviceListsLoaded()) {
            throw new IllegalArgumentException("Device manager needs to have device lists loaded");
        }
    }

    static /* synthetic */ int access$210(AutoFocusManager autoFocusManager) {
        int n2 = autoFocusManager.reqCnt;
        autoFocusManager.reqCnt = n2 - 1;
        return n2;
    }

    static /* synthetic */ int access$508(AutoFocusManager autoFocusManager) {
        int n2 = autoFocusManager.mNumFailedAutofocusAttempts;
        autoFocusManager.mNumFailedAutofocusAttempts = n2 + 1;
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void doAutofocus(boolean bl, Camera.AutoFocusCallback autoFocusCallback) {
        if (this.mCamera == null || autoFocusCallback == null || this.mFocusPaused) return;
        {
            if (bl || !this.mFocused) {
                if (this.mAutofocusInProgress) {
                    Log.v((Object)this, (String)"Autofocus is in progress...", (Object[])new Object[0]);
                    return;
                }
                try {
                    this.mAutofocusInProgress = true;
                    if (this.mTimer != null) {
                        this.mTimer.cancel();
                        this.mTimer = null;
                    }
                    Log.d((Object)this, (String)"requesting autofocus...", (Object[])new Object[0]);
                    this.reqCnt = 1 + this.reqCnt;
                    Object[] arrobject = new Object[]{this.reqCnt};
                    Log.i((Object)this, (String)"Requests count: {}", (Object[])arrobject);
                    if (this.mStatusView != null) {
                        this.mStatusView.onAutofocusStarted(this.mFocusAreas);
                    }
                    this.mCamera.autoFocus(autoFocusCallback);
                    Log.d((Object)this, (String)"request issued", (Object[])new Object[0]);
                    return;
                }
                catch (RuntimeException var3_4) {
                    Log.w((Object)this, (Throwable)var3_4, (String)"Autofocus call failed!", (Object[])new Object[0]);
                    autoFocusCallback.onAutoFocus(false, this.mCamera);
                    return;
                }
            } else {
                if (!this.mFocused || autoFocusCallback == this.mAutofocusCallback) return;
                {
                    Log.v((Object)this, (String)"Frame should be focused...", (Object[])new Object[0]);
                    this.reqCnt = 1 + this.reqCnt;
                    autoFocusCallback.onAutoFocus(true, this.mCamera);
                    return;
                }
            }
        }
    }

    private void invalidateFocus(int n2) {
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = new Timer();
        this.mTimer.schedule(new TimerTask(){

            public void run() {
                AutoFocusManager.this.invalidateFocus();
            }
        }, 3000);
        Log.v((Object)this, (String)"focus timer set", (Object[])new Object[0]);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void cancelOngoingFocus() {
        if (this.mCamera != null && this.mAutofocusInProgress) {
            try {
                this.mCamera.cancelAutoFocus();
            }
            catch (RuntimeException var1_1) {
                Log.w((Object)this, (Throwable)var1_1, (String)"There has been error in cancelling autofocus cycle. This probably a bug in device", (Object[])new Object[0]);
            }
            this.mAutofocusInProgress = false;
            this.reqCnt = -1 + this.reqCnt;
        }
    }

    @Override
    public void checkFocus() {
        this.doAutofocus(false);
    }

    @Override
    public void dispose() {
        this.mCamera = null;
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = null;
        this.mStatusView = null;
        this.mFocusAreas = null;
        this.mDeviceManager = null;
    }

    @Override
    public void doAutofocus(boolean bl) {
        this.doAutofocus(bl, this.mAutofocusCallback);
    }

    @Override
    public void invalidateFocus() {
        Log.v((Object)this, (String)"invalidating focus", (Object[])new Object[0]);
        this.mFocused = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
        this.mTimer = null;
    }

    @Override
    public boolean isAutofocusing() {
        return this.mAutofocusInProgress;
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
        this.mFocused = false;
    }

    @Override
    public void resumeFocusing() {
        this.mFocusPaused = false;
    }

    @Override
    public void setCamera(Camera camera) {
        this.mCamera = camera;
        this.mAutofocusInProgress = false;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    @TargetApi(value=14)
    @Override
    public void setMeteringAreas(Rect[] var1_1) {
        if (this.mCamera != null) {
            try {
                var3_2 = this.mCamera.getParameters();
                ** if (var1_1 != null) goto lbl-1000
            }
            catch (RuntimeException var2_3) {
                Log.w((Object)this, (Throwable)var2_3, (String)"Failed to get camera parameters. Cannot set metering areas!", (Object[])new Object[0]);
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
                    this.invalidateFocus();
                    this.doAutofocus(false);
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

