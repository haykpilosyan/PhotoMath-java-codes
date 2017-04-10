/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.microblink.hardware;

import com.microblink.hardware.DeviceManager;

public class NativeDeviceManager {
    private long mNativeContext = 0;

    NativeDeviceManager(DeviceManager deviceManager) {
        this.mNativeContext = NativeDeviceManager.nativeConstruct(DeviceManager.getAndroidRelease(), DeviceManager.getManufacturer(), DeviceManager.getModel(), DeviceManager.getDevice(), DeviceManager.getNumberOfCores(), DeviceManager.getMaxCPUFrequency(), deviceManager.isAllowedToUseZeroCopyBuffer(), deviceManager.isEGLPbufferNotSupported());
    }

    private static native long nativeConstruct(String var0, String var1, String var2, String var3, int var4, int var5, boolean var6, boolean var7);

    private static native void nativeDestruct(long var0);

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mNativeContext != 0) {
            NativeDeviceManager.nativeDestruct(this.mNativeContext);
        }
    }

    public long getNativeContext() {
        return this.mNativeContext;
    }
}

