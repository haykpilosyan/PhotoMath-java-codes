/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.RectF
 *  com.microblink.hardware.camera.memory.BitmapCameraFrame
 *  com.microblink.hardware.orientation.Orientation
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 */
package com.microblink.hardware.camera.camera1.frame;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import com.microblink.hardware.camera.CameraDataFormat;
import com.microblink.hardware.camera.camera1.frame.Camera1PhotoFrame;
import com.microblink.hardware.camera.frame.ICameraFrame;
import com.microblink.hardware.camera.memory.BitmapCameraFrame;
import com.microblink.hardware.orientation.Orientation;

public class Camera1PhotoBitmapFrame
implements ICameraFrame {
    private BitmapCameraFrame mBitmapFrame;
    private Camera1PhotoFrame mPhotoFrame;

    public Camera1PhotoBitmapFrame(Camera1PhotoFrame camera1PhotoFrame) {
        this.mPhotoFrame = camera1PhotoFrame;
        Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])this.mPhotoFrame.getImgBuffer(), (int)0, (int)this.mPhotoFrame.getImgBuffer().length);
        if (bitmap == null) {
            throw new RuntimeException("Failed to decode photo data!");
        }
        this.mBitmapFrame = new BitmapCameraFrame(bitmap, this.mPhotoFrame.getFrameID());
    }

    @Override
    public void finalizePoolObject() {
    }

    @Override
    public CameraDataFormat getFormat() {
        return this.mBitmapFrame.getFormat();
    }

    @Override
    public long getFrameID() {
        return this.mPhotoFrame.getFrameID();
    }

    @Override
    public double getFrameQuality() {
        return this.mBitmapFrame.getFrameQuality();
    }

    @Override
    public int getHeight() {
        return this.mBitmapFrame.getHeight();
    }

    @Override
    public long getNativeCameraFrame() {
        return this.mBitmapFrame.getNativeCameraFrame();
    }

    @Override
    public Orientation getOrientation() {
        return this.mBitmapFrame.getOrientation();
    }

    @Override
    public RectF getVisiblePart() {
        return this.mBitmapFrame.getVisiblePart();
    }

    @Override
    public int getWidth() {
        return this.mBitmapFrame.getWidth();
    }

    @Override
    public boolean initializeNativePart(long l2) {
        return this.mBitmapFrame.initializeNativePart(l2);
    }

    @Override
    public void initializePoolObject() {
    }

    @Override
    public boolean isDeviceMoving() {
        return this.mBitmapFrame.isDeviceMoving();
    }

    @Override
    public boolean isFocused() {
        return this.mBitmapFrame.isFocused();
    }

    @Override
    public boolean isPhoto() {
        return true;
    }

    @Override
    public void recycle() {
        this.mBitmapFrame.recycle();
        this.mPhotoFrame.recycle();
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.mBitmapFrame.setOrientation(orientation);
    }

    @Override
    public void setVisiblePart(RectF rectF) {
        this.mBitmapFrame.setVisiblePart(rectF);
    }
}

