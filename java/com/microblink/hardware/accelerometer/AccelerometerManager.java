/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.os.Handler
 *  com.microblink.util.Log
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.Timer
 *  java.util.TimerTask
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.microblink.hardware.accelerometer;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.microblink.hardware.accelerometer.IAccelerometerFilter;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.util.Log;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class AccelerometerManager
implements SensorEventListener {
    private static float accelerometerMoveThreshold = 0.47f;
    private static float accelerometerStopThreshold = 0.2f;
    private static float samplePeriodForgetFactor = 0.66f;
    private ShakeCallback mAccelerometerDelegate = null;
    private IAccelerometerFilter mAccelerometerFilter = null;
    private Sensor mAccelerometerSensor;
    private long mLastSensorReadTimestamp = -1;
    private Handler mMainThreadHandler;
    private int mSamplePeriod;
    private SensorManager mSensorManager;
    private AtomicBoolean mShaking = new AtomicBoolean(true);
    private Timer mTimer = null;

    public AccelerometerManager(Context context, IAccelerometerFilter iAccelerometerFilter, float f2) {
        this.mSensorManager = (SensorManager)context.getSystemService("sensor");
        this.mAccelerometerFilter = iAccelerometerFilter;
        this.mAccelerometerSensor = this.mSensorManager.getDefaultSensor(1);
        this.mSamplePeriod = 1000 * Math.round((float)(1000.0f * f2));
        this.mMainThreadHandler = new Handler();
    }

    private float getAbsoluteAcceleration() {
        float f2 = this.mAccelerometerFilter.getX();
        float f3 = this.mAccelerometerFilter.getY();
        float f4 = this.mAccelerometerFilter.getZ();
        return (float)Math.sqrt((double)(f2 * f2 + f3 * f3 + f4 * f4));
    }

    private boolean hasDeviceMoved() {
        if (!this.mShaking.get() && this.getAbsoluteAcceleration() > accelerometerMoveThreshold) {
            return true;
        }
        return false;
    }

    private boolean hasDeviceStopped() {
        if (this.mShaking.get() && this.getAbsoluteAcceleration() < accelerometerStopThreshold) {
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void updateAcceleration(float[] arrf) {
        long l2;
        if (this.mLastSensorReadTimestamp >= 0 && (l2 = System.currentTimeMillis() - this.mLastSensorReadTimestamp) > 0) {
            this.mSamplePeriod = (int)((float)this.mSamplePeriod * samplePeriodForgetFactor + (float)(l2 * 1000) * (1.0f - samplePeriodForgetFactor));
            this.mAccelerometerFilter.setSamplePeriod((float)this.mSamplePeriod / 1000.0f / 1000.0f);
        }
        this.mAccelerometerFilter.addAcceleration(arrf[0], arrf[1], arrf[2]);
        if (this.hasDeviceMoved()) {
            this.mShaking.set(true);
            this.mAccelerometerDelegate.onShakingStarted();
        } else if (this.hasDeviceStopped()) {
            this.mShaking.set(false);
            this.mAccelerometerDelegate.onShakingStopped();
        }
        this.mLastSensorReadTimestamp = System.currentTimeMillis();
    }

    public boolean isPhoneShaking() {
        return this.mShaking.get();
    }

    public void onAccuracyChanged(Sensor sensor, int n2) {
        Log.i((Object)this, (String)"Accelerometer accuracy has changed", (Object[])new Object[0]);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.updateAcceleration(sensorEvent.values);
    }

    public void setAccelerometerDelegate(ShakeCallback shakeCallback) {
        this.mAccelerometerDelegate = shakeCallback;
    }

    public void startAccelerometer() {
        Log.v((Object)this, (String)"Registering accelerometer sensor listener {}", (Object[])new Object[]{this});
        boolean bl = this.mSensorManager.registerListener((SensorEventListener)this, this.mAccelerometerSensor, this.mSamplePeriod);
        this.mAccelerometerDelegate.onShakingStarted();
        this.mShaking.set(true);
        if (!bl) {
            Object[] arrobject = new Object[]{this.mSamplePeriod};
            Log.e((Object)this, (String)"unable to register accelerometer sensor with sample period {} microseconds. Trying SENSOR_DELAY_NORMAL...", (Object[])arrobject);
            bl = this.mSensorManager.registerListener((SensorEventListener)this, this.mAccelerometerSensor, 3);
            if (!bl) {
                Log.w((Object)this, (String)"unable to register accelerometer sensor at all", (Object[])new Object[0]);
                this.mShaking.set(false);
                this.mAccelerometerDelegate.onShakingStopped();
            }
        }
        if (bl) {
            this.mTimer = new Timer("Accelerometer timer");
            this.mTimer.schedule((TimerTask)new PeriodicSensorEvent(), 0, (long)this.mSamplePeriod);
        }
    }

    public void stopAccelerometer() {
        Log.v((Object)this, (String)"Unregistering accelerometer sensor listener {}", (Object[])new Object[]{this});
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        this.mSensorManager.unregisterListener((SensorEventListener)this);
    }

    private class PeriodicSensorEvent
    extends TimerTask {
        private float[] mNoAcc;

        public PeriodicSensorEvent() {
            this.mNoAcc = new float[3];
            this.mNoAcc[0] = 0.0f;
            this.mNoAcc[1] = 0.0f;
            this.mNoAcc[2] = 0.0f;
        }

        public void run() {
            AccelerometerManager.this.mMainThreadHandler.post(new Runnable(){

                public void run() {
                    AccelerometerManager.this.updateAcceleration(PeriodicSensorEvent.this.mNoAcc);
                }
            });
        }

    }

}

