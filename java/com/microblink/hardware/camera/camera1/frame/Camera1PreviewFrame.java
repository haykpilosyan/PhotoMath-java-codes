/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool
 *  com.microblink.hardware.orientation.Orientation
 *  com.microblink.recognition.NativeLibraryLoader
 *  com.microblink.util.Log
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.microblink.hardware.camera.camera1.frame;

import android.graphics.RectF;
import com.microblink.hardware.camera.CameraDataFormat;
import com.microblink.hardware.camera.camera1.Camera1Manager;
import com.microblink.hardware.camera.camera1.frame.Camera1AbstractFrame;
import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.recognition.NativeLibraryLoader;
import com.microblink.util.Log;

public class Camera1PreviewFrame
extends Camera1AbstractFrame {
    private Camera1PreviewFramePool mOwner;
    private double mQuality = -1.0;

    static {
        NativeLibraryLoader.loadNativeLibrary();
    }

    public Camera1PreviewFrame(int n2, int n3, int n4, Camera1PreviewFramePool camera1PreviewFramePool, Camera1Manager camera1Manager) {
        super(n2, n3, n4, camera1Manager);
        this.mOwner = camera1PreviewFramePool;
    }

    private static native long initializeNativeCamera1Frame(long var0, int var2, int var3, byte[] var4, boolean var5, boolean var6, int var7, float var8, float var9, float var10, float var11);

    private static native double nativeGetCamera1FrameQuality(long var0);

    private static native void terminateNativeCamera1Frame(long var0);

    @Override
    public void dispose() {
        super.dispose();
        this.mOwner = null;
    }

    @Override
    public void finalizePoolObject() {
        Object[] arrobject = new Object[]{this.mID};
        Log.v((Object)this, (String)"Finalizing frame ID: {}", (Object[])arrobject);
        Camera1PreviewFrame.terminateNativeCamera1Frame(this.mNativeContext);
        this.mNativeContext = 0;
        super.finalizePoolObject();
    }

    @Override
    public final CameraDataFormat getFormat() {
        return CameraDataFormat.YUV_NV21;
    }

    @Override
    public double getFrameQuality() {
        if (this.mQuality < 0.0) {
            NativeLibraryLoader.ensureNativeLibraryLoaded();
            if (this.mNativeContext == 0) {
                throw new IllegalStateException("Prior calling getFrameQuality make sure you have initialized native part of frame");
            }
            this.mQuality = Camera1PreviewFrame.nativeGetCamera1FrameQuality(this.mNativeContext);
        }
        return this.mQuality;
    }

    @Override
    public boolean initializeNativePart(long l2) {
        if (this.mNativeContext != 0) {
            throw new IllegalStateException("Native part is already initialized!");
        }
        this.mNativeContext = Camera1PreviewFrame.initializeNativeCamera1Frame(l2, this.mImgWidth, this.mImgHeight, this.mImgBuffer, this.mFocused, this.mDeviceMoving, this.mOrientation.intValue(), this.mVisiblePart.left, this.mVisiblePart.top, this.mVisiblePart.width(), this.mVisiblePart.height());
        if (this.mNativeContext != 0) {
            return true;
        }
        return false;
    }

    @Override
    public void initializePoolObject() {
        super.initializePoolObject();
        this.mQuality = -1.0;
    }

    @Override
    public boolean isPhoto() {
        return false;
    }

    @Override
    public void recycle() {
        if (this.mOwner != null) {
            this.mOwner.recycle(this);
        }
    }
}

