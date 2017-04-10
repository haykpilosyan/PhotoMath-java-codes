/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.hardware.Camera
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool
 *  com.microblink.hardware.camera.camera1.strategy.factory.ICameraStrategyFactory
 *  com.microblink.util.Log
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Iterator
 *  java.util.List
 */
package com.microblink.hardware.camera.camera1;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.os.Build;
import com.microblink.hardware.DeviceManager;
import com.microblink.hardware.accelerometer.AccelerometerManager;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.hardware.camera.AutofocusListener;
import com.microblink.hardware.camera.CameraListener;
import com.microblink.hardware.camera.CameraSettings;
import com.microblink.hardware.camera.camera1.Camera1Manager;
import com.microblink.hardware.camera.camera1.focus.AutoFocusManager;
import com.microblink.hardware.camera.camera1.focus.ContinuousAutofocusManager;
import com.microblink.hardware.camera.camera1.focus.IFocusManager;
import com.microblink.hardware.camera.camera1.focus.StillFocusManager;
import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFrame;
import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool;
import com.microblink.hardware.camera.camera1.strategy.factory.ICameraStrategyFactory;
import com.microblink.hardware.camera.frame.ICameraFrame;
import com.microblink.util.Log;
import java.util.Iterator;
import java.util.List;

public class VideoCamera1Manager
extends Camera1Manager {
    private final Camera.PreviewCallback mPreviewCallback;
    private ShakeCallback mSlaveDelegate;

    public VideoCamera1Manager(DeviceManager deviceManager, AccelerometerManager accelerometerManager, ICameraStrategyFactory iCameraStrategyFactory, CameraListener cameraListener, CameraSettings cameraSettings) {
        super(deviceManager, accelerometerManager, iCameraStrategyFactory, cameraListener, cameraSettings);
        this.mPreviewCallback = new Camera.PreviewCallback(){
            private long mFrameID;

            public void onPreviewFrame(byte[] arrby, Camera camera) {
                if (VideoCamera1Manager.this.mPreviewFramePool == null) {
                    Log.w((Object)VideoCamera1Manager.this, (String)"Cannot obtain frame by its buffer because frame pool has been disposed", (Object[])new Object[0]);
                    return;
                }
                Camera1PreviewFrame camera1PreviewFrame = VideoCamera1Manager.this.mPreviewFramePool.getFrameByItsBuffer(arrby);
                if (camera1PreviewFrame == null) {
                    Log.d((Object)VideoCamera1Manager.this, (String)"Cannot find frame by its buffer. This is OK if buffered callback is disabled. Otherwise this is an error!", (Object[])new Object[0]);
                    camera1PreviewFrame = VideoCamera1Manager.this.mPreviewFramePool.obtain();
                    camera1PreviewFrame.setImgBuffer(arrby);
                }
                long l2 = this.mFrameID;
                this.mFrameID = 1 + l2;
                camera1PreviewFrame.setFrameID(l2);
                camera1PreviewFrame.setDeviceMoving(VideoCamera1Manager.this.mAccelManager.isPhoneShaking());
                camera1PreviewFrame.setFocused(VideoCamera1Manager.this.isCameraInFocus());
                VideoCamera1Manager videoCamera1Manager = VideoCamera1Manager.this;
                Object[] arrobject = new Object[]{camera1PreviewFrame.getFrameID()};
                Log.v((Object)videoCamera1Manager, (String)"Frame {} has arrived from camera", (Object[])arrobject);
                if (VideoCamera1Manager.this.mCameraDelegate != null && VideoCamera1Manager.this.mCameraDelegate.canReceiveFrame()) {
                    VideoCamera1Manager.this.mCameraDelegate.onCameraFrame(camera1PreviewFrame);
                    return;
                }
                camera1PreviewFrame.recycle();
            }
        };
        this.mSlaveDelegate = cameraSettings.getSlaveAccelerometerDelegate();
    }

    @Override
    public void dispose() {
        this.mSlaveDelegate = null;
        super.dispose();
    }

    @Override
    protected Camera.PreviewCallback getPreviewCallback() {
        return this.mPreviewCallback;
    }

    @Override
    public void onShakingStarted() {
        super.onShakingStarted();
        if (this.mSlaveDelegate != null) {
            this.mSlaveDelegate.onShakingStarted();
        }
    }

    @Override
    public void onShakingStopped() {
        super.onShakingStopped();
        if (this.mSlaveDelegate != null) {
            this.mSlaveDelegate.onShakingStopped();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @SuppressLint(value={"NewApi"})
    @Override
    protected IFocusManager prepareCameraParameteresAndFocusManager(Camera.Parameters parameters) {
        IFocusManager iFocusManager2;
        List list;
        IFocusManager iFocusManager2;
        List list2;
        List list3 = parameters.getSupportedFocusModes();
        if (this.mCameraSettings.shouldOptimizeForNearScan()) {
            IFocusManager iFocusManager32;
            IFocusManager iFocusManager32;
            Log.i((Object)this, (String)"Optimizing camera parameters for near scanning", (Object[])new Object[0]);
            if (Build.VERSION.SDK_INT >= 16 && list3 != null && list3.contains((Object)"continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
                Log.d((Object)this, (String)"Activated continous picture autofocus", (Object[])new Object[0]);
                iFocusManager32 = new ContinuousAutofocusManager(this.mCameraDelegate, this.mDeviceManager, true);
                this.mAutofocusSupported = Boolean.TRUE;
            } else if (list3 != null && list3.contains((Object)"macro")) {
                parameters.setFocusMode("macro");
                Log.v((Object)this, (String)"Activated macro focus mode", (Object[])new Object[0]);
                this.mAutofocusSupported = Boolean.TRUE;
                iFocusManager32 = new AutoFocusManager(this.mCameraDelegate, this.mDeviceManager);
            } else if (list3 != null && list3.contains((Object)"auto")) {
                parameters.setFocusMode("auto");
                Log.v((Object)this, (String)"Activated autofocus", (Object[])new Object[0]);
                iFocusManager32 = new AutoFocusManager(this.mCameraDelegate, this.mDeviceManager);
                this.mAutofocusSupported = Boolean.TRUE;
            } else {
                Log.e((Object)this, (String)"Autofocus not supported", (Object[])new Object[0]);
                this.mAutofocusSupported = Boolean.FALSE;
                if (this.mCameraSettings.shouldCrashIfAutofocusNotSupported()) {
                    throw new AutoFocusRequiredButNotSupportedException("Autofocus is required, but not supported on this device");
                }
                iFocusManager32 = new StillFocusManager();
            }
            if (this.mCameraSettings.getInitialZoomLevel() == 0.0f) {
                this.mCameraSettings.setInitialZoomLevel(0.2f);
                iFocusManager2 = iFocusManager32;
            } else {
                iFocusManager2 = iFocusManager32;
            }
        } else {
            Log.i((Object)this, (String)"Optimizing camera parameters for default scanning", (Object[])new Object[0]);
            if (Build.VERSION.SDK_INT >= 16 && list3 != null && list3.contains((Object)"continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
                Log.d((Object)this, (String)"Activated continous picture autofocus", (Object[])new Object[0]);
                ContinuousAutofocusManager continuousAutofocusManager = new ContinuousAutofocusManager(this.mCameraDelegate, this.mDeviceManager, false);
                this.mAutofocusSupported = Boolean.TRUE;
                iFocusManager2 = continuousAutofocusManager;
            } else if (list3 != null && list3.contains((Object)"auto")) {
                parameters.setFocusMode("auto");
                Log.v((Object)this, (String)"Activated autofocus", (Object[])new Object[0]);
                AutoFocusManager autoFocusManager = new AutoFocusManager(this.mCameraDelegate, this.mDeviceManager);
                this.mAutofocusSupported = Boolean.TRUE;
                iFocusManager2 = autoFocusManager;
            } else if (list3 != null && list3.contains((Object)"macro")) {
                parameters.setFocusMode("macro");
                Log.v((Object)this, (String)"Activated macro focus mode", (Object[])new Object[0]);
                AutoFocusManager autoFocusManager = new AutoFocusManager(this.mCameraDelegate, this.mDeviceManager);
                this.mAutofocusSupported = Boolean.TRUE;
                iFocusManager2 = autoFocusManager;
            } else {
                Log.e((Object)this, (String)"Autofocus not supported", (Object[])new Object[0]);
                this.mAutofocusSupported = Boolean.FALSE;
                if (this.mCameraSettings.shouldCrashIfAutofocusNotSupported()) {
                    throw new AutoFocusRequiredButNotSupportedException("Autofocus is required, but not supported on this device");
                }
                iFocusManager2 = new StillFocusManager();
            }
        }
        if ((list = parameters.getSupportedFlashModes()) != null && list.contains((Object)"off")) {
            parameters.setFlashMode("off");
            Log.i((Object)this, (String)"Setting flash mode to OFF!", (Object[])new Object[0]);
        } else {
            Log.e((Object)this, (String)"Flash mode OFF not supported!!!!", (Object[])new Object[0]);
            if (list != null) {
                Log.i((Object)this, (String)"Supported flash modes:", (Object[])new Object[0]);
                Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    Log.i((Object)this, (String)((String)iterator.next()), (Object[])new Object[0]);
                }
            }
        }
        String string = parameters.get("phase-af-values");
        Log.i((Object)this, (String)"Supported Phase AutoFocus modes: {}", (Object[])new Object[]{string});
        if (string != null) {
            String[] arrstring = string.split(",");
            int n2 = arrstring.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (!"on".equals((Object)arrstring[i2])) continue;
                Log.i((Object)this, (String)"Activating Phase Autofocus!", (Object[])new Object[0]);
                parameters.set("phase-af", "on");
            }
        }
        if ((list2 = parameters.getSupportedWhiteBalance()) != null && list2.contains((Object)"auto")) {
            parameters.setWhiteBalance("auto");
            Log.v((Object)this, (String)"Activated automatic white balance correction", (Object[])new Object[0]);
        } else {
            Log.w((Object)this, (String)"Automatic white balance not supported!!!", (Object[])new Object[0]);
        }
        if (Build.VERSION.SDK_INT >= 15 && parameters.isVideoStabilizationSupported()) {
            Log.i((Object)this, (String)"Enabling video stabilization", (Object[])new Object[0]);
            parameters.setVideoStabilization(true);
        }
        if ("Nexus 4".equals((Object)DeviceManager.getModel())) {
            parameters.setRecordingHint(true);
            parameters.setPictureSize(3264, 2448);
        } else if (DeviceManager.getModel().contains((CharSequence)"Glass")) {
            parameters.setPreviewFpsRange(30000, 30000);
        } else {
            parameters.setPreviewFrameRate(30);
        }
        Object[] arrobject = new Object[]{parameters.flatten()};
        Log.v((Object)this, (String)"Final parameters: {}", (Object[])arrobject);
        return iFocusManager2;
    }

}

