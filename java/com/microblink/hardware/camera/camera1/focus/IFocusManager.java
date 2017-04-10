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

public interface IFocusManager {
    public void cancelOngoingFocus();

    public void checkFocus();

    public void dispose();

    public void doAutofocus(boolean var1);

    public void invalidateFocus();

    public boolean isAutofocusing();

    public boolean isCameraFocused();

    public boolean isFocusManagerPaused();

    public void pauseFocusing();

    public void resumeFocusing();

    public void setCamera(Camera var1);

    public void setMeteringAreas(Rect[] var1);
}

