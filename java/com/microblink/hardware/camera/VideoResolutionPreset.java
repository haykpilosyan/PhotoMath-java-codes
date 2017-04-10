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

public final class VideoResolutionPreset
extends Enum<VideoResolutionPreset>
implements Parcelable {
    private static final /* synthetic */ VideoResolutionPreset[] $VALUES;
    public static final Parcelable.Creator<VideoResolutionPreset> CREATOR;
    public static final /* enum */ VideoResolutionPreset VIDEO_RESOLUTION_1080p;
    public static final /* enum */ VideoResolutionPreset VIDEO_RESOLUTION_2160p;
    public static final /* enum */ VideoResolutionPreset VIDEO_RESOLUTION_480p;
    public static final /* enum */ VideoResolutionPreset VIDEO_RESOLUTION_720p;
    public static final /* enum */ VideoResolutionPreset VIDEO_RESOLUTION_DEFAULT;
    public static final /* enum */ VideoResolutionPreset VIDEO_RESOLUTION_MAX_AVAILABLE;
    private int mHeight;

    static {
        VIDEO_RESOLUTION_DEFAULT = new VideoResolutionPreset(1080);
        VIDEO_RESOLUTION_480p = new VideoResolutionPreset(480);
        VIDEO_RESOLUTION_720p = new VideoResolutionPreset(720);
        VIDEO_RESOLUTION_1080p = new VideoResolutionPreset(1080);
        VIDEO_RESOLUTION_2160p = new VideoResolutionPreset(2160);
        VIDEO_RESOLUTION_MAX_AVAILABLE = new VideoResolutionPreset(4320);
        VideoResolutionPreset[] arrvideoResolutionPreset = new VideoResolutionPreset[]{VIDEO_RESOLUTION_DEFAULT, VIDEO_RESOLUTION_480p, VIDEO_RESOLUTION_720p, VIDEO_RESOLUTION_1080p, VIDEO_RESOLUTION_2160p, VIDEO_RESOLUTION_MAX_AVAILABLE};
        $VALUES = arrvideoResolutionPreset;
        CREATOR = new Parcelable.Creator<VideoResolutionPreset>(){

            public VideoResolutionPreset createFromParcel(Parcel parcel) {
                return VideoResolutionPreset.values()[parcel.readInt()];
            }

            public VideoResolutionPreset[] newArray(int n2) {
                return new VideoResolutionPreset[n2];
            }
        };
    }

    private VideoResolutionPreset(int n3) {
        super(string, n2);
        this.mHeight = n3;
    }

    public static VideoResolutionPreset valueOf(String string) {
        return (VideoResolutionPreset)Enum.valueOf((Class)VideoResolutionPreset.class, (String)string);
    }

    public static VideoResolutionPreset[] values() {
        return (VideoResolutionPreset[])$VALUES.clone();
    }

    public int describeContents() {
        return 0;
    }

    public int getIdealHeight() {
        return this.mHeight;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeInt(this.ordinal());
    }

}

