/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.support.annotation.NonNull
 *  java.lang.Object
 */
package com.microblink.hardware.camera;

import android.support.annotation.NonNull;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.CameraFrameFactory;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.VideoResolutionPreset;

public class CameraSettings {
    private CameraFrameFactory mCameraFrameFactory = new CameraFrameFactory();
    private CameraType mCameraType = CameraType.CAMERA_DEFAULT;
    private boolean mCrashIfAutofocusNotSupported = false;
    private boolean mForceTextureView = false;
    private float mInitialZoomLevel = 0.0f;
    private int mMaxAllowedPhotoDimension = 2000;
    private int mMinAllowedVideoResolution = 230400;
    private boolean mOptimizeForNearScan = false;
    private VideoResolutionPreset mResolutionPreset = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;
    private boolean mShouldAlwaysUsePhotoMode = false;
    private ShakeCallback mSlaveAccelerometerDelegate;
    private boolean mUseLegacyCamera = false;
    private boolean mUseMegapixelsTargetForChoosingPhotoSize = false;

    public CameraFrameFactory getCameraFrameFactory() {
        return this.mCameraFrameFactory;
    }

    public CameraType getCameraType() {
        return this.mCameraType;
    }

    public float getInitialZoomLevel() {
        return this.mInitialZoomLevel;
    }

    public int getMaxAllowedPhotoDimension() {
        return this.mMaxAllowedPhotoDimension;
    }

    public int getMinAllowedVideoResolution() {
        return this.mMinAllowedVideoResolution;
    }

    public ShakeCallback getSlaveAccelerometerDelegate() {
        return this.mSlaveAccelerometerDelegate;
    }

    public VideoResolutionPreset getVideoResolutionPreset() {
        return this.mResolutionPreset;
    }

    public boolean isForceTextureView() {
        return this.mForceTextureView;
    }

    public boolean isUseLegacyCamera() {
        return this.mUseLegacyCamera;
    }

    public boolean isUseMegapixelsTargetForChoosingPhotoSize() {
        return this.mUseMegapixelsTargetForChoosingPhotoSize;
    }

    public void setCameraFrameFactory(@NonNull CameraFrameFactory cameraFrameFactory) {
        this.mCameraFrameFactory = cameraFrameFactory;
    }

    public void setCameraType(CameraType cameraType) {
        this.mCameraType = cameraType;
    }

    public void setCrashIfAutofocusNotSupported(boolean bl) {
        this.mCrashIfAutofocusNotSupported = bl;
    }

    public void setForceTextureView(boolean bl) {
        this.mForceTextureView = bl;
    }

    public void setInitialZoomLevel(float f2) {
        this.mInitialZoomLevel = f2;
    }

    public void setMaxAllowedPhotoDimension(int n2) {
        this.mMaxAllowedPhotoDimension = n2;
    }

    public void setMinAllowedVideoResolution(int n2) {
        this.mMinAllowedVideoResolution = n2;
    }

    public void setOptimizeForNearScan(boolean bl) {
        this.mOptimizeForNearScan = bl;
    }

    public void setShouldAlwaysUsePhotoMode(boolean bl) {
        this.mShouldAlwaysUsePhotoMode = bl;
    }

    public void setSlaveAccelerometerDelegate(ShakeCallback shakeCallback) {
        this.mSlaveAccelerometerDelegate = shakeCallback;
    }

    public void setUseLegacyCamera(boolean bl) {
        this.mUseLegacyCamera = bl;
    }

    public void setUseMegapixelsTargetForChoosingPhotoSize(boolean bl) {
        this.mUseMegapixelsTargetForChoosingPhotoSize = bl;
    }

    public void setVideoResolutionPreset(VideoResolutionPreset videoResolutionPreset) {
        if (videoResolutionPreset != null) {
            this.mResolutionPreset = videoResolutionPreset;
            return;
        }
        this.mResolutionPreset = VideoResolutionPreset.VIDEO_RESOLUTION_DEFAULT;
    }

    public boolean shouldAlwaysUsePhotoMode() {
        return this.mShouldAlwaysUsePhotoMode;
    }

    public boolean shouldCrashIfAutofocusNotSupported() {
        return this.mCrashIfAutofocusNotSupported;
    }

    public boolean shouldOptimizeForNearScan() {
        return this.mOptimizeForNearScan;
    }
}

