/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Rect
 *  android.support.annotation.Nullable
 *  android.support.annotation.UiThread
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Throwable
 */
package com.microblink.hardware.camera;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.microblink.hardware.DeviceManager;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.CameraSettings;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.ImageSize;

public interface ICameraManager
extends ShakeCallback {
    public boolean areOpenedCamerasPixelsLandscapeLeft();

    @UiThread
    public boolean cameraSupportsTorch();

    public void dispose();

    public boolean doesCameraHaveSurface();

    @UiThread
    public ImageSize getCurrentPreviewSize();

    public CameraType getOpenedCameraType();

    public SurfaceHolder.Callback getSurfaceHolderCallback();

    @TargetApi(value=14)
    public TextureView.SurfaceTextureListener getSurfaceTextureListener();

    @Nullable
    @UiThread
    public Boolean isAutofocusSupported();

    @UiThread
    public boolean isCameraFocusing();

    @UiThread
    public boolean isCameraInFocus();

    public boolean isDeviceShaking();

    public boolean isPreviewActive();

    @UiThread
    public void performAutofocus();

    @UiThread
    public void setMeteringAreas(Rect[] var1);

    public void setShakeCallback(ShakeCallback var1);

    @UiThread
    public void setTorchState(boolean var1, SuccessCallback var2);

    @UiThread
    public void setZoomLevel(float var1);

    @UiThread
    public void startPreview(DeviceManager var1, CameraSettings var2, CameraStartupCallback var3);

    @UiThread
    public void stopPreview();

    public static interface CameraStartupCallback {
        public void onCameraPreviewSizeChosen(int var1, int var2);

        public void onExceptionCaught(Throwable var1);

        public void onPreviewStarted();

        public void onPreviewStopped();
    }

}

