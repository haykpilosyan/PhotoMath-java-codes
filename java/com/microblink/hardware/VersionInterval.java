/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.microblink.hardware;

import com.microblink.hardware.Version;

public class VersionInterval {
    private boolean mAllVersions = false;
    private boolean mEqualLowerBound = true;
    private boolean mEqualUpperBound = true;
    private Version mLowerBound = null;
    private Version mUpperBound = null;

    /*
     * Enabled aggressive block sorting
     */
    public VersionInterval(String string) {
        if (string == null || string.length() == 0) {
            throw new NullPointerException("Interval expression cannot be null nor empty!");
        }
        String string2 = string.trim();
        if ("*".equals((Object)string2)) {
            this.mAllVersions = true;
            return;
        } else {
            String[] arrstring;
            int n2;
            if (string2.charAt(0) == '[') {
                this.mEqualLowerBound = true;
            } else {
                if (string2.charAt(0) != '<') {
                    throw new IllegalArgumentException("Invalid version interval: " + string2);
                }
                this.mEqualLowerBound = false;
            }
            if (string2.charAt(n2 = -1 + string2.length()) == ']') {
                this.mEqualUpperBound = true;
            } else {
                if (string2.charAt(n2) != '>') {
                    throw new IllegalArgumentException("Invalid version interval: " + string2);
                }
                this.mEqualUpperBound = false;
            }
            if ((arrstring = string2.substring(1, n2).split(",")).length != 2) {
                throw new IllegalArgumentException("Invalid version interval: " + string2);
            }
            if (!"*".equals((Object)arrstring[0])) {
                this.mLowerBound = new Version(arrstring[0]);
            }
            if ("*".equals((Object)arrstring[1])) return;
            {
                this.mUpperBound = new Version(arrstring[1]);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean contains(Version version) {
        boolean bl;
        boolean bl2;
        if (version == null) return true;
        if (this.mAllVersions) {
            return true;
        }
        if (this.mLowerBound != null) {
            if (this.mEqualLowerBound) {
                if (!version.greaterOrEqualThan(this.mLowerBound)) return false;
            } else if (!version.greaterThan(this.mLowerBound)) return false;
        }
        if (!(bl = true)) {
            return false;
        }
        if (this.mUpperBound == null) return true;
        if (this.mEqualUpperBound) {
            boolean bl3 = this.mUpperBound.greaterOrEqualThan(version);
            bl2 = false;
            if (!bl3) return bl2;
            return true;
        } else {
            boolean bl4 = this.mUpperBound.greaterThan(version);
            bl2 = false;
            if (!bl4) return bl2;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.mAllVersions) {
            stringBuilder.append('*');
            return stringBuilder.toString();
        }
        if (this.mEqualLowerBound) {
            stringBuilder.append('[');
        } else {
            stringBuilder.append('<');
        }
        if (this.mLowerBound != null) {
            stringBuilder.append(this.mLowerBound.toString());
        } else {
            stringBuilder.append('*');
        }
        stringBuilder.append(',');
        if (this.mUpperBound != null) {
            stringBuilder.append(this.mUpperBound.toString());
        } else {
            stringBuilder.append('*');
        }
        if (this.mEqualUpperBound) {
            stringBuilder.append(']');
            return stringBuilder.toString();
        }
        stringBuilder.append('>');
        return stringBuilder.toString();
    }
}

