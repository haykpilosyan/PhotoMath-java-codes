/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  com.microblink.hardware.camera.camera1.strategy.CameraStrategy
 *  com.microblink.hardware.camera.camera1.strategy.CameraStrategy$PreviewSize
 *  com.microblink.util.Log
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.microblink.hardware;

import com.microblink.hardware.VersionInterval;
import com.microblink.hardware.camera.camera1.strategy.CameraStrategy;
import com.microblink.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceInfo {
    private VersionInterval mBlacklistedInVersions;
    private int mCameraInitDelay = -1;
    private String mDevice;
    private VersionInterval mDisplayOrientationNotWorkingInVersions;
    private VersionInterval mEglPbufferNotSupportedInVersions;
    private VersionInterval mFocusUntrustyInVersions;
    private VersionInterval mForceUseLegacyCamera;
    private double mFrameQualityFactor = 1.0;
    private double mMaxZoomLevel = 1.0;
    private VersionInterval mMeteringNotWorkingInVersions;
    private double mMinZoomLevel = 0.0;
    private String mModel;
    private VersionInterval mNaturalOrientationIsLandscapeLeftInVersions;
    private CameraStrategy.PreviewSize mOptimalBackFacingPictureSize;
    private CameraStrategy.PreviewSize mOptimalBackFacingPreviewSize;
    private CameraStrategy.PreviewSize mOptimalFrontFacingPictureSize;
    private CameraStrategy.PreviewSize mOptimalFrontFacingPreviewSize;
    private VersionInterval mPhaseAutofocusSupportedInVersions;
    private VersionInterval mZeroCopyBufferAllowedInVersions;

    public DeviceInfo(String string, String string2) {
        if (string == null || string2 == null) {
            throw new IllegalArgumentException("Device and Model cannot be null");
        }
        this.mDevice = string;
        this.mModel = string2;
    }

    public DeviceInfo(JSONObject jSONObject, String string) throws JSONException {
        String[] arrstring = string.split("::");
        this.mModel = arrstring[1];
        this.mDevice = arrstring[0];
        if (jSONObject.has("backFacingPreviewSize")) {
            JSONArray jSONArray = jSONObject.getJSONArray("backFacingPreviewSize");
            this.mOptimalBackFacingPreviewSize = new CameraStrategy.PreviewSize(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("backFacingPictureSize")) {
            JSONArray jSONArray = jSONObject.getJSONArray("backFacingPictureSize");
            this.mOptimalBackFacingPictureSize = new CameraStrategy.PreviewSize(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("frontFacingPreviewSize")) {
            JSONArray jSONArray = jSONObject.getJSONArray("frontFacingPreviewSize");
            this.mOptimalFrontFacingPreviewSize = new CameraStrategy.PreviewSize(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("frontFacingPictureSize")) {
            JSONArray jSONArray = jSONObject.getJSONArray("frontFacingPictureSize");
            this.mOptimalFrontFacingPictureSize = new CameraStrategy.PreviewSize(jSONArray.getInt(0), jSONArray.getInt(1));
        }
        if (jSONObject.has("cameraInitDelayMs")) {
            this.mCameraInitDelay = jSONObject.getInt("cameraInitDelayMs");
        }
        if (jSONObject.has("minZoomLevel")) {
            this.mMinZoomLevel = jSONObject.getDouble("minZoomLevel");
        }
        if (jSONObject.has("maxZoomLevel")) {
            this.mMaxZoomLevel = jSONObject.getDouble("maxZoomLevel");
        }
        if (jSONObject.has("blacklisted")) {
            this.mBlacklistedInVersions = new VersionInterval(jSONObject.getString("blacklisted"));
        }
        if (jSONObject.has("displayOrientationNotWorking")) {
            this.mDisplayOrientationNotWorkingInVersions = new VersionInterval(jSONObject.getString("displayOrientationNotWorking"));
        }
        if (jSONObject.has("naturalOrientationIsLandscapeLeft")) {
            this.mNaturalOrientationIsLandscapeLeftInVersions = new VersionInterval(jSONObject.getString("naturalOrientationIsLandscapeLeft"));
        }
        if (jSONObject.has("focusUntrusty")) {
            this.mFocusUntrustyInVersions = new VersionInterval(jSONObject.getString("focusUntrusty"));
        }
        if (jSONObject.has("meteringNotWorking")) {
            this.mMeteringNotWorkingInVersions = new VersionInterval(jSONObject.getString("meteringNotWorking"));
        }
        if (jSONObject.has("zeroCopyBufferAllowed")) {
            this.mZeroCopyBufferAllowedInVersions = new VersionInterval(jSONObject.getString("zeroCopyBufferAllowed"));
        }
        if (jSONObject.has("eglPbufferNotSupported")) {
            this.mEglPbufferNotSupportedInVersions = new VersionInterval(jSONObject.getString("eglPbufferNotSupported"));
        }
        if (jSONObject.has("frameQualityFactor")) {
            this.mFrameQualityFactor = jSONObject.getDouble("frameQualityFactor");
        }
        if (jSONObject.has("phaseAutoFocusSupported")) {
            this.mPhaseAutofocusSupportedInVersions = new VersionInterval(jSONObject.getString("phaseAutoFocusSupported"));
        }
        if (jSONObject.has("forceUseLegacyCamera")) {
            this.mForceUseLegacyCamera = new VersionInterval(jSONObject.getString("forceUseLegacyCamera"));
        }
    }

    VersionInterval getBlacklistedInVersions() {
        return this.mBlacklistedInVersions;
    }

    public int getCameraInitDelay() {
        return this.mCameraInitDelay;
    }

    public String getDevice() {
        return this.mDevice;
    }

    VersionInterval getDisplayOrientationNotWorkingInVersions() {
        return this.mDisplayOrientationNotWorkingInVersions;
    }

    VersionInterval getEglPbufferNotSupportedInVersions() {
        return this.mEglPbufferNotSupportedInVersions;
    }

    VersionInterval getFocusUntrustyInVersions() {
        return this.mFocusUntrustyInVersions;
    }

    VersionInterval getForceUseLegacyCamera() {
        return this.mForceUseLegacyCamera;
    }

    public double getFrameQualityFactor() {
        return this.mFrameQualityFactor;
    }

    public double getMaxZoomLevel() {
        return this.mMaxZoomLevel;
    }

    VersionInterval getMeteringNotWorkingInVersions() {
        return this.mMeteringNotWorkingInVersions;
    }

    public double getMinZoomLevel() {
        return this.mMinZoomLevel;
    }

    public String getModel() {
        return this.mModel;
    }

    VersionInterval getNaturalOrientationIsLandscapeLeftInVersions() {
        return this.mNaturalOrientationIsLandscapeLeftInVersions;
    }

    public CameraStrategy.PreviewSize getOptimalBackFacingPictureSize() {
        return this.mOptimalBackFacingPictureSize;
    }

    public CameraStrategy.PreviewSize getOptimalBackFacingPreviewSize() {
        return this.mOptimalBackFacingPreviewSize;
    }

    public CameraStrategy.PreviewSize getOptimalFrontFacingPictureSize() {
        return this.mOptimalFrontFacingPictureSize;
    }

    public CameraStrategy.PreviewSize getOptimalFrontFacingPreviewSize() {
        return this.mOptimalFrontFacingPreviewSize;
    }

    VersionInterval getPhaseAutofocusSupportedInVersions() {
        return this.mPhaseAutofocusSupportedInVersions;
    }

    public String getUniqueName() {
        return this.mDevice + "::" + this.mModel;
    }

    VersionInterval getZeroCopyBufferAllowedInVersions() {
        return this.mZeroCopyBufferAllowedInVersions;
    }

    public void logi() {
        Object[] arrobject = new Object[]{this.mDevice};
        Log.i((Object)this, (String)"Device: {}", (Object[])arrobject);
        Object[] arrobject2 = new Object[]{this.mModel};
        Log.i((Object)this, (String)"Model: {}", (Object[])arrobject2);
    }

    public String toString() {
        return "DeviceInfo{mDevice='" + this.mDevice + '\'' + ", mModel='" + this.mModel + '\'' + '}';
    }
}

