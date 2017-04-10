/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.microblink.hardware.camera;

import com.microblink.hardware.camera.AutofocusListener;
import com.microblink.hardware.camera.frame.ICameraFrame;

public interface CameraListener
extends AutofocusListener {
    public boolean canReceiveFrame();

    public void onCameraFrame(ICameraFrame var1);

    public void onTakePictureFail();
}

