/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  java.lang.Object
 */
package com.microblink.hardware.camera;

import android.graphics.Rect;

public interface AutofocusListener {
    public void onAutofocusFailed();

    public void onAutofocusStarted(Rect[] var1);

    public void onAutofocusStopped(Rect[] var1);
}

