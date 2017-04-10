/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool
 *  com.microblink.hardware.camera.camera2.frame.Camera2Frame
 *  com.microblink.hardware.camera.camera2.frame.Camera2FramePool
 *  java.lang.Object
 */
package com.microblink.hardware.camera;

import com.microblink.hardware.camera.camera1.Camera1Manager;
import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFrame;
import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool;
import com.microblink.hardware.camera.camera2.frame.Camera2Frame;
import com.microblink.hardware.camera.camera2.frame.Camera2FramePool;

public class CameraFrameFactory {
    public Camera1PreviewFrame createCamera1Frame(int n2, int n3, int n4, Camera1PreviewFramePool camera1PreviewFramePool, Camera1Manager camera1Manager) {
        return new Camera1PreviewFrame(n2, n3, n4, camera1PreviewFramePool, camera1Manager);
    }

    public Camera2Frame createCamera2Frame(Camera2FramePool camera2FramePool) {
        return new Camera2Frame(camera2FramePool);
    }
}

