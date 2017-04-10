/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.microblink.hardware.camera;

public final class CameraDataFormat
extends Enum<CameraDataFormat> {
    private static final /* synthetic */ CameraDataFormat[] $VALUES;
    public static final /* enum */ CameraDataFormat ALPHA_8;
    public static final /* enum */ CameraDataFormat ARGB;
    public static final /* enum */ CameraDataFormat BGRA;
    public static final /* enum */ CameraDataFormat JPEG;
    public static final /* enum */ CameraDataFormat MULTI_PLANAR_YUV_420_888;
    public static final /* enum */ CameraDataFormat YUV_NV21;

    static {
        YUV_NV21 = new CameraDataFormat();
        JPEG = new CameraDataFormat();
        MULTI_PLANAR_YUV_420_888 = new CameraDataFormat();
        ARGB = new CameraDataFormat();
        ALPHA_8 = new CameraDataFormat();
        BGRA = new CameraDataFormat();
        CameraDataFormat[] arrcameraDataFormat = new CameraDataFormat[]{YUV_NV21, JPEG, MULTI_PLANAR_YUV_420_888, ARGB, ALPHA_8, BGRA};
        $VALUES = arrcameraDataFormat;
    }

    private CameraDataFormat() {
        super(string, n2);
    }

    public static CameraDataFormat valueOf(String string) {
        return (CameraDataFormat)Enum.valueOf((Class)CameraDataFormat.class, (String)string);
    }

    public static CameraDataFormat[] values() {
        return (CameraDataFormat[])$VALUES.clone();
    }
}

