/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.microblink.hardware;

public class Version {
    private int mBugfix = -1;
    private int mMajor = -1;
    private int mMinor = -1;

    public Version(String string) {
        this.initFromVersionString(string);
    }

    private void initFromVersionString(String string) {
        if (string == null) {
            throw new NullPointerException("Cannot parse null version string!");
        }
        String[] arrstring = string.split("\\.");
        if (arrstring.length == 0) {
            throw new IllegalArgumentException("Invalid version string " + string);
        }
        if (arrstring.length >= 1) {
            this.mMajor = Integer.parseInt((String)arrstring[0]);
            if (arrstring.length >= 2) {
                this.mMinor = Integer.parseInt((String)arrstring[1]);
                if (arrstring.length >= 3) {
                    this.mBugfix = Integer.parseInt((String)arrstring[2]);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public boolean equalTo(Version version) {
        if (version == null) {
            return true;
        }
        if (this.mMajor != version.mMajor) {
            return false;
        }
        if (this.mMinor == -1) return true;
        if (version.mMinor == -1) return true;
        if (this.mMinor != version.mMinor) {
            return false;
        }
        if (this.mBugfix == -1) return true;
        if (version.mBugfix == -1) return true;
        if (this.mBugfix == version.mBugfix) return true;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean greaterOrEqualThan(Version version) {
        boolean bl = true;
        if (version == null) {
            throw new NullPointerException("Cannot compare with null version!");
        }
        if (this.mMajor < version.mMajor) {
            return false;
        }
        if (this.mMajor > version.mMajor) return bl;
        if (this.mMinor == -1) {
            if (version.mMinor == -1) return bl;
            if (version.mMinor == 0) return bl;
            return false;
        }
        if (version.mMinor == -1) return bl;
        if (this.mMinor < version.mMinor) {
            return false;
        }
        if (this.mMinor > version.mMinor) return bl;
        if (this.mBugfix == -1) {
            if (version.mBugfix == -1) return bl;
            if (version.mBugfix == 0) return bl;
            return false;
        }
        if (version.mBugfix == -1) return bl;
        if (this.mBugfix >= version.mBugfix) return bl;
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean greaterThan(Version version) {
        boolean bl = true;
        if (version == null) {
            throw new NullPointerException("Cannot compare with null version!");
        }
        if (this.mMajor < version.mMajor) {
            return false;
        }
        if (this.mMajor > version.mMajor) {
            return bl;
        }
        if (this.mMinor == -1) return false;
        if (version.mMinor == -1) {
            if (this.mMinor == 0) return false;
            return bl;
        }
        if (this.mMinor < version.mMinor) return false;
        if (this.mMinor > version.mMinor) {
            return bl;
        }
        if (this.mBugfix == -1) return false;
        if (version.mBugfix == -1) {
            if (this.mBugfix == 0) return false;
            return bl;
        }
        if (this.mBugfix <= version.mBugfix) return false;
        return bl;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mMajor);
        if (this.mMinor != -1) {
            stringBuilder.append('.');
            stringBuilder.append(this.mMinor);
            if (this.mBugfix != -1) {
                stringBuilder.append('.');
                stringBuilder.append(this.mBugfix);
            }
        }
        return stringBuilder.toString();
    }
}

