/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.microblink.hardware.accelerometer;

public interface IAccelerometerFilter {
    public void addAcceleration(float var1, float var2, float var3);

    public float getX();

    public float getY();

    public float getZ();

    public void setSamplePeriod(float var1);
}

