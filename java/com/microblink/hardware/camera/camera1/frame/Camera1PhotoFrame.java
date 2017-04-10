/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.UnsupportedOperationException
 */
package com.microblink.hardware.camera.camera1.frame;

import com.microblink.hardware.camera.CameraDataFormat;
import com.microblink.hardware.camera.camera1.Camera1Manager;
import com.microblink.hardware.camera.camera1.frame.Camera1AbstractFrame;

public class Camera1PhotoFrame
extends Camera1AbstractFrame {
    public Camera1PhotoFrame(int n2, int n3, int n4, Camera1Manager camera1Manager) {
        super(n2, n3, n4, camera1Manager);
    }

    @Override
    public CameraDataFormat getFormat() {
        return CameraDataFormat.JPEG;
    }

    @Override
    public double getFrameQuality() {
        return -1.0;
    }

    @Override
    public long getNativeCameraFrame() {
        throw new UnsupportedOperationException("JPEG frames do not have native part.");
    }

    @Override
    public boolean initializeNativePart(long l2) {
        throw new UnsupportedOperationException("JPEG frames do not have native part.");
    }

    @Override
    public boolean isPhoto() {
        return true;
    }

    @Override
    public void recycle() {
        this.finalizePoolObject();
    }
}

