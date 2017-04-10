/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.hardware.Camera
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PictureCallback
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$ShutterCallback
 *  android.hardware.Camera$Size
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool
 *  com.microblink.hardware.camera.camera1.strategy.CameraStrategy
 *  com.microblink.hardware.camera.camera1.strategy.PhotoPreviewCameraStrategy
 *  com.microblink.hardware.camera.camera1.strategy.factory.ICameraStrategyFactory
 *  com.microblink.util.IProcessingQueue
 *  com.microblink.util.Log
 *  java.lang.Boolean
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 */
package com.microblink.hardware.camera.camera1;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.os.Build;
import com.microblink.hardware.DeviceManager;
import com.microblink.hardware.accelerometer.AccelerometerManager;
import com.microblink.hardware.camera.AutoFocusRequiredButNotSupportedException;
import com.microblink.hardware.camera.AutofocusListener;
import com.microblink.hardware.camera.CameraListener;
import com.microblink.hardware.camera.CameraSettings;
import com.microblink.hardware.camera.CameraSurface;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.camera1.Camera1Manager;
import com.microblink.hardware.camera.camera1.focus.AutoFocusManager;
import com.microblink.hardware.camera.camera1.focus.IFocusManager;
import com.microblink.hardware.camera.camera1.focus.StillFocusManager;
import com.microblink.hardware.camera.camera1.frame.Camera1AbstractFrame;
import com.microblink.hardware.camera.camera1.frame.Camera1PhotoFrame;
import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFrame;
import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool;
import com.microblink.hardware.camera.camera1.strategy.CameraStrategy;
import com.microblink.hardware.camera.camera1.strategy.PhotoPreviewCameraStrategy;
import com.microblink.hardware.camera.camera1.strategy.factory.ICameraStrategyFactory;
import com.microblink.hardware.camera.frame.ICameraFrame;
import com.microblink.util.IProcessingQueue;
import com.microblink.util.Log;
import java.util.List;

public class PhotoCamera1Manager
extends Camera1Manager {
    protected final Camera.PictureCallback mPhotoCallback;
    protected volatile boolean mPhotographyInProgress = false;
    protected final Camera.PreviewCallback mPreviewCallback;
    protected final Camera.ShutterCallback shutterCallback_;

    public PhotoCamera1Manager(DeviceManager deviceManager, AccelerometerManager accelerometerManager, ICameraStrategyFactory iCameraStrategyFactory, CameraListener cameraListener, CameraSettings cameraSettings) {
        super(deviceManager, accelerometerManager, iCameraStrategyFactory, cameraListener, cameraSettings);
        this.shutterCallback_ = new Camera.ShutterCallback(){

            public void onShutter() {
                Log.i((Object)this, (String)"on shutter", (Object[])new Object[0]);
            }
        };
        this.mPhotoCallback = new Camera.PictureCallback(){
            private long mFrameID;

            public void onPictureTaken(byte[] arrby, Camera camera) {
                Log.i((Object)this, (String)"on picture taken", (Object[])new Object[0]);
                PhotoCamera1Manager.this.mPreviewActive = false;
                if (Build.VERSION.SDK_INT >= 14) {
                    PhotoCamera1Manager.this.mCamera.stopPreview();
                }
                Camera.Size size = camera.getParameters().getPictureSize();
                Camera1PhotoFrame camera1PhotoFrame = new Camera1PhotoFrame(size.width, size.height, 0, PhotoCamera1Manager.this);
                camera1PhotoFrame.setFocused(true);
                camera1PhotoFrame.setDeviceMoving(false);
                camera1PhotoFrame.setImgBuffer(arrby);
                long l2 = this.mFrameID;
                this.mFrameID = 1 + l2;
                camera1PhotoFrame.setFrameID(l2);
                PhotoCamera1Manager.this.mPhotographyInProgress = false;
                if (PhotoCamera1Manager.this.mCameraDelegate != null && PhotoCamera1Manager.this.mCameraDelegate.canReceiveFrame()) {
                    PhotoCamera1Manager.this.mCameraDelegate.onCameraFrame(camera1PhotoFrame);
                    return;
                }
                camera1PhotoFrame.recycle();
            }
        };
        this.mPreviewCallback = new Camera.PreviewCallback(){
            private long mFrameID;

            public void onPreviewFrame(byte[] arrby, Camera camera) {
                Camera1PreviewFrame camera1PreviewFrame = PhotoCamera1Manager.this.mPreviewFramePool.getFrameByItsBuffer(arrby);
                if (camera1PreviewFrame == null) {
                    camera1PreviewFrame = PhotoCamera1Manager.this.mPreviewFramePool.obtain();
                    camera1PreviewFrame.setImgBuffer(arrby);
                }
                camera1PreviewFrame.setDeviceMoving(PhotoCamera1Manager.this.mAccelManager.isPhoneShaking());
                camera1PreviewFrame.setFocused(PhotoCamera1Manager.this.isCameraInFocus());
                long l2 = this.mFrameID;
                this.mFrameID = 1 + l2;
                camera1PreviewFrame.setFrameID(l2);
                if (PhotoCamera1Manager.this.mCameraDelegate != null && PhotoCamera1Manager.this.mCameraDelegate.canReceiveFrame()) {
                    PhotoCamera1Manager.this.mCameraDelegate.onCameraFrame(camera1PreviewFrame);
                    return;
                }
                camera1PreviewFrame.recycle();
            }
        };
    }

    @Override
    protected Camera.PreviewCallback getPreviewCallback() {
        return null;
    }

    @Override
    protected boolean isUsingBufferedCallback() {
        return false;
    }

    @Override
    public void onShakingStopped() {
        super.onShakingStopped();
    }

    /*
     * Enabled aggressive block sorting
     */
    @SuppressLint(value={"InlinedApi"})
    @Override
    protected IFocusManager prepareCameraParameteresAndFocusManager(Camera.Parameters parameters) {
        IFocusManager iFocusManager2;
        List list;
        List list2;
        List list3 = parameters.getSupportedFocusModes();
        if (list3 != null && list3.contains((Object)"macro")) {
            parameters.setFocusMode("macro");
            Log.i((Object)this, (String)"Activated macro focus mode", (Object[])new Object[0]);
            AutoFocusManager autoFocusManager = new AutoFocusManager(this.mCameraDelegate, this.mDeviceManager);
            this.mAutofocusSupported = Boolean.TRUE;
            iFocusManager2 = autoFocusManager;
        } else if (list3 != null && list3.contains((Object)"auto")) {
            parameters.setFocusMode("auto");
            Log.i((Object)this, (String)"Activated autofocus", (Object[])new Object[0]);
            AutoFocusManager autoFocusManager = new AutoFocusManager(this.mCameraDelegate, this.mDeviceManager);
            this.mAutofocusSupported = Boolean.TRUE;
            iFocusManager2 = autoFocusManager;
        } else {
            Log.i((Object)this, (String)"Autofocus not supported", (Object[])new Object[0]);
            this.mAutofocusSupported = Boolean.FALSE;
            if (this.mCameraSettings.shouldCrashIfAutofocusNotSupported()) {
                throw new AutoFocusRequiredButNotSupportedException("Autofocus is required, but not supported on this device");
            }
            iFocusManager2 = new StillFocusManager();
        }
        if ((list2 = parameters.getSupportedFlashModes()) != null && list2.contains((Object)"auto")) {
            parameters.setFlashMode("auto");
        }
        if ((list = parameters.getSupportedWhiteBalance()) != null && list.contains((Object)"auto")) {
            parameters.setWhiteBalance("auto");
            Log.i((Object)this, (String)"Activated automatic white balance correction", (Object[])new Object[0]);
        } else {
            Log.w((Object)this, (String)"Automatic white balance not supported!!!", (Object[])new Object[0]);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            parameters.setPictureFormat(256);
        }
        parameters.setJpegQuality(40);
        if (this.mCameraStrategy instanceof PhotoPreviewCameraStrategy) {
            IFocusManager iFocusManager2;
            Camera.Size size = ((PhotoPreviewCameraStrategy)this.mCameraStrategy).getOptimalPhotoSize(this.mCameraSurface.getWidth(), this.mCameraSurface.getHeight(), this.getOpenedCameraType());
            Log.i((Object)this, (String)("Picture size is: " + size.width + "x" + size.height), (Object[])new Object[0]);
            parameters.setPictureSize(size.width, size.height);
            return iFocusManager2;
        }
        Log.e((Object)this, (String)"PhotoCameraManager should have a camera strategy that is instance of PhotoPreviewCameraStrategy in order to be able to calculate photo image size. Without this, PhotoPay will most likely crash!", (Object[])new Object[0]);
        throw new IllegalStateException("PhotoCameraManager should have a camera strategy that is instance of PhotoPreviewCameraStrategy in order to be able to calculate photo image size.");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void recycleFrame(Camera1AbstractFrame camera1AbstractFrame) {
        if (camera1AbstractFrame instanceof Camera1PhotoFrame && this.mCamera != null && !this.mPreviewActive) {
            this.mPreviewActive = true;
            try {
                this.mCamera.startPreview();
                this.getCameraQueue().postJobDelayed(new Runnable(){

                    public void run() {
                        IFocusManager iFocusManager = PhotoCamera1Manager.this.getFocusManager();
                        if (PhotoCamera1Manager.this.mAccelManager != null && iFocusManager != null) {
                            iFocusManager.resumeFocusing();
                        }
                    }
                }, (long)this.mCameraStrategy.getCameraInitDelay());
            }
            catch (RuntimeException var2_2) {
                Log.e((Object)this, (Throwable)var2_2, (String)"Unable to restart camera preview", (Object[])new Object[0]);
            }
        }
        super.recycleFrame(camera1AbstractFrame);
    }

    public void takePicture() {
        this.getCameraQueue().postJob(new Runnable(){

            public void run() {
                Log.i((Object)this, (String)"taking picture", (Object[])new Object[0]);
                if (PhotoCamera1Manager.this.mCamera != null && !PhotoCamera1Manager.this.mPhotographyInProgress && PhotoCamera1Manager.this.mPreviewActive) {
                    PhotoCamera1Manager.this.mPhotographyInProgress = true;
                    Log.i((Object)this, (String)"requesting autofocus", (Object[])new Object[0]);
                    PhotoCamera1Manager.this.mCamera.autoFocus(new Camera.AutoFocusCallback(){

                        public void onAutoFocus(boolean bl, Camera camera) {
                            Object[] arrobject = new Object[]{bl};
                            Log.i((Object)this, (String)"focus success: {}", (Object[])arrobject);
                            if (bl) {
                                PhotoCamera1Manager.this.mCamera.takePicture(null, null, PhotoCamera1Manager.this.mPhotoCallback);
                                return;
                            }
                            Log.e((Object)this, (String)"Focusing failed", (Object[])new Object[0]);
                            PhotoCamera1Manager.this.mPhotoCallback.onPictureTaken(null, null);
                        }
                    });
                }
            }

        });
    }

}

