/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  com.microblink.hardware.orientation.Orientation
 *  com.microblink.util.CommonUtils
 *  java.lang.Object
 */
package com.microblink.hardware.camera.camera1.frame;

import android.graphics.RectF;
import com.microblink.hardware.camera.camera1.Camera1Manager;
import com.microblink.hardware.camera.frame.ICameraFrame;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.util.CommonUtils;

public abstract class Camera1AbstractFrame
implements ICameraFrame {
    protected Camera1Manager mCamera1Manager;
    protected boolean mDeviceMoving;
    protected boolean mFocused;
    protected long mID;
    protected byte[] mImgBuffer = null;
    protected int mImgHeight;
    protected int mImgWidth;
    protected long mNativeContext = 0;
    protected Orientation mOrientation;
    protected RectF mVisiblePart;

    protected Camera1AbstractFrame(int n2, int n3, int n4, Camera1Manager camera1Manager) {
        this.mImgWidth = n2;
        this.mImgHeight = n3;
        this.mCamera1Manager = camera1Manager;
        if (n4 > 0) {
            this.mImgBuffer = new byte[n4];
        }
    }

    public void dispose() {
        this.mImgBuffer = null;
        this.mCamera1Manager = null;
        this.mVisiblePart = null;
        this.mOrientation = null;
    }

    @Override
    public void finalizePoolObject() {
        if (this.mCamera1Manager != null) {
            this.mCamera1Manager.recycleFrame(this);
        }
        this.mVisiblePart = null;
        this.mOrientation = null;
    }

    @Override
    public long getFrameID() {
        return this.mID;
    }

    @Override
    public final int getHeight() {
        return this.mImgHeight;
    }

    public byte[] getImgBuffer() {
        return this.mImgBuffer;
    }

    @Override
    public long getNativeCameraFrame() {
        return this.mNativeContext;
    }

    @Override
    public Orientation getOrientation() {
        return this.mOrientation;
    }

    @Override
    public final RectF getVisiblePart() {
        return this.mVisiblePart;
    }

    @Override
    public final int getWidth() {
        return this.mImgWidth;
    }

    @Override
    public void initializePoolObject() {
        this.mVisiblePart = null;
        this.mOrientation = null;
    }

    @Override
    public final boolean isDeviceMoving() {
        return this.mDeviceMoving;
    }

    @Override
    public final boolean isFocused() {
        return this.mFocused;
    }

    public final void setDeviceMoving(boolean bl) {
        this.mDeviceMoving = bl;
    }

    public final void setFocused(boolean bl) {
        this.mFocused = bl;
    }

    public void setFrameID(long l2) {
        this.mID = l2;
    }

    public final void setImgBuffer(byte[] arrby) {
        this.mImgBuffer = arrby;
    }

    @Override
    public void setOrientation(Orientation orientation) {
        this.mOrientation = orientation;
    }

    @Override
    public final void setVisiblePart(RectF rectF) {
        this.mVisiblePart = rectF;
        CommonUtils.clampToUnitRect((RectF)this.mVisiblePart);
    }
}

