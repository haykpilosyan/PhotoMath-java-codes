/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  com.microblink.hardware.orientation.Orientation
 *  java.lang.Object
 */
package com.microblink.hardware.camera.frame;

import android.graphics.RectF;
import com.microblink.hardware.camera.CameraDataFormat;
import com.microblink.hardware.orientation.Orientation;
import com.microblink.util.pool.PoolObject;

public interface ICameraFrame
extends PoolObject {
    public CameraDataFormat getFormat();

    public long getFrameID();

    public double getFrameQuality();

    public int getHeight();

    public long getNativeCameraFrame();

    public Orientation getOrientation();

    public RectF getVisiblePart();

    public int getWidth();

    public boolean initializeNativePart(long var1);

    public boolean isDeviceMoving();

    public boolean isFocused();

    public boolean isPhoto();

    public void recycle();

    public void setOrientation(Orientation var1);

    public void setVisiblePart(RectF var1);
}

