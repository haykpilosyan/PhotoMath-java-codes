/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.Camera
 *  java.lang.Object
 */
package com.microblink.hardware.camera.camera1.focus;

import android.graphics.Rect;
import android.hardware.Camera;
import com.microblink.hardware.camera.camera1.focus.IFocusManager;

public class StillFocusManager
implements IFocusManager {
    private volatile boolean mFocusPaused = true;

    @Override
    public void cancelOngoingFocus() {
    }

    @Override
    public void checkFocus() {
    }

    @Override
    public void dispose() {
    }

    @Override
    public void doAutofocus(boolean bl) {
    }

    @Override
    public void invalidateFocus() {
    }

    @Override
    public boolean isAutofocusing() {
        return false;
    }

    @Override
    public boolean isCameraFocused() {
        return true;
    }

    @Override
    public boolean isFocusManagerPaused() {
        return this.mFocusPaused;
    }

    @Override
    public void pauseFocusing() {
        this.mFocusPaused = true;
    }

    @Override
    public void resumeFocusing() {
        this.mFocusPaused = false;
    }

    @Override
    public void setCamera(Camera camera) {
    }

    @Override
    public void setMeteringAreas(Rect[] arrrect) {
    }
}

