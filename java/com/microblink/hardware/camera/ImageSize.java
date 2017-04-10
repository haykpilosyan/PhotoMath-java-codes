/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.microblink.hardware.camera;

public class ImageSize {
    private int mHeight;
    private int mWidth;

    public ImageSize(int n2, int n3) {
        this.mWidth = n2;
        this.mHeight = n3;
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        if (!(object instanceof ImageSize)) {
            return false;
        }
        ImageSize imageSize = (ImageSize)object;
        if (this.mWidth != imageSize.mWidth) return false;
        if (this.mHeight != imageSize.mHeight) return false;
        return true;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        return 32713 * this.mWidth + this.mHeight;
    }
}

