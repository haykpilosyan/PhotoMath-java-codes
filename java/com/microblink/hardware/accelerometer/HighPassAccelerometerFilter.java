/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.microblink.hardware.accelerometer;

import com.microblink.hardware.accelerometer.IAccelerometerFilter;

public class HighPassAccelerometerFilter
implements IAccelerometerFilter {
    private float mEstimatedX;
    private float mEstimatedY;
    private float mEstimatedZ;
    private float mFilterConstant;
    private float mLowPassX;
    private float mLowPassY;
    private float mLowPassZ;
    private float mSamplePeriod;
    private float mTauFactor;

    public HighPassAccelerometerFilter(float f2, float f3) {
        this.mSamplePeriod = f2;
        this.mTauFactor = f3;
        this.mFilterConstant = f2 / (f2 + f2 * f3);
    }

    @Override
    public void addAcceleration(float f2, float f3, float f4) {
        this.mLowPassX = f2 * this.mFilterConstant + this.mLowPassX * (1.0f - this.mFilterConstant);
        this.mLowPassY = f3 * this.mFilterConstant + this.mLowPassY * (1.0f - this.mFilterConstant);
        this.mLowPassZ = f4 * this.mFilterConstant + this.mLowPassZ * (1.0f - this.mFilterConstant);
        this.mEstimatedX = f2 - this.mLowPassX;
        this.mEstimatedY = f3 - this.mLowPassY;
        this.mEstimatedZ = f4 - this.mLowPassZ;
    }

    @Override
    public float getX() {
        return this.mEstimatedX;
    }

    @Override
    public float getY() {
        return this.mEstimatedY;
    }

    @Override
    public float getZ() {
        return this.mEstimatedZ;
    }

    @Override
    public void setSamplePeriod(float f2) {
        float f3 = this.mSamplePeriod = f2;
        this.mFilterConstant = f3 / (f3 + this.mSamplePeriod * this.mTauFactor);
    }
}

