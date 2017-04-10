/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.microblink.util.Log
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 */
package com.microblink.hardware.accelerometer;

import com.microblink.hardware.accelerometer.IAccelerometerFilter;
import com.microblink.util.Log;

public class LowPassAccelerometerFilter
implements IAccelerometerFilter {
    private float filterConstant_;
    private float mX;
    private float mY;
    private float mZ;

    public LowPassAccelerometerFilter(float f2, float f3) {
        float f4 = 1.0f / f2;
        this.filterConstant_ = f4 / (f4 + 1.0f / f3);
    }

    @Override
    public void addAcceleration(float f2, float f3, float f4) {
        this.mX = f2;
        this.mY = f3;
        this.mZ = f4;
        Object[] arrobject = new Object[]{Float.valueOf((float)f2), Float.valueOf((float)f3), Float.valueOf((float)f4)};
        Log.i((Object)this, (String)"current acceleration: ({}, {}, {})", (Object[])arrobject);
    }

    @Override
    public float getX() {
        return this.mX;
    }

    @Override
    public float getY() {
        return this.mY;
    }

    @Override
    public float getZ() {
        return this.mZ;
    }

    @Override
    public void setSamplePeriod(float f2) {
    }
}

