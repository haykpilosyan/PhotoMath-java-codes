/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.SurfaceHolder
 *  java.lang.Object
 */
package com.microblink.hardware.camera;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

public class CameraSurface {
    private int mHeight = 0;
    private SurfaceHolder mSurfaceHolder = null;
    private SurfaceTexture mSurfaceTexture = null;
    private int mWidth = 0;

    public CameraSurface(SurfaceTexture surfaceTexture, int n2, int n3) {
        this.mSurfaceTexture = surfaceTexture;
        this.mWidth = n2;
        this.mHeight = n3;
    }

    public CameraSurface(SurfaceHolder surfaceHolder, int n2, int n3) {
        this.mSurfaceHolder = surfaceHolder;
        this.mWidth = n2;
        this.mHeight = n3;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public SurfaceHolder getSurfaceHolder() {
        return this.mSurfaceHolder;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isSurfaceSane() {
        if ((this.mSurfaceHolder != null || this.mSurfaceTexture != null) && this.mWidth > 0 && this.mHeight > 0) {
            return true;
        }
        return false;
    }
}

