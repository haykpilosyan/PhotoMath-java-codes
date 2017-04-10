/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.microblink.hardware.camera;

import android.os.Parcel;
import android.os.Parcelable;

public final class CameraType
extends Enum<CameraType>
implements Parcelable {
    private static final /* synthetic */ CameraType[] $VALUES;
    public static final /* enum */ CameraType CAMERA_BACKFACE;
    public static final /* enum */ CameraType CAMERA_DEFAULT;
    public static final /* enum */ CameraType CAMERA_FRONTFACE;
    public static final Parcelable.Creator<CameraType> CREATOR;

    static {
        CAMERA_DEFAULT = new CameraType();
        CAMERA_BACKFACE = new CameraType();
        CAMERA_FRONTFACE = new CameraType();
        CameraType[] arrcameraType = new CameraType[]{CAMERA_DEFAULT, CAMERA_BACKFACE, CAMERA_FRONTFACE};
        $VALUES = arrcameraType;
        CREATOR = new Parcelable.Creator<CameraType>(){

            public CameraType createFromParcel(Parcel parcel) {
                return CameraType.values()[parcel.readInt()];
            }

            public CameraType[] newArray(int n2) {
                return new CameraType[n2];
            }
        };
    }

    private CameraType() {
        super(string, n2);
    }

    public static CameraType valueOf(String string) {
        return (CameraType)Enum.valueOf((Class)CameraType.class, (String)string);
    }

    public static CameraType[] values() {
        return (CameraType[])$VALUES.clone();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.ordinal());
    }

}

