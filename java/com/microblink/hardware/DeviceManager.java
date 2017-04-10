/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.res.AssetManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.microblink.hardware.camera.camera1.strategy.CameraStrategy
 *  com.microblink.hardware.camera.camera1.strategy.CameraStrategy$PreviewSize
 *  com.microblink.util.Log
 *  com.microblink.view.NotSupportedReason
 *  java.io.BufferedReader
 *  java.io.File
 *  java.io.FileFilter
 *  java.io.FileReader
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.InputStreamReader
 *  java.io.Reader
 *  java.io.StringWriter
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runtime
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.regex.Pattern
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.microblink.hardware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import com.microblink.hardware.DeviceInfo;
import com.microblink.hardware.NativeDeviceManager;
import com.microblink.hardware.Version;
import com.microblink.hardware.VersionInterval;
import com.microblink.hardware.camera.camera1.strategy.CameraStrategy;
import com.microblink.util.Log;
import com.microblink.view.NotSupportedReason;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceManager {
    private static int sNumberOfCores;
    private static boolean sProcessorCompatible;
    private static int sProcessorFrequency;
    private Context mContext;
    private Map<String, DeviceInfo> mDeviceList;

    static {
        int n2;
        sNumberOfCores = n2 = 1;
        sProcessorFrequency = -1;
        if (DeviceManager.isArm7Processor()) {
            n2 = (int)DeviceManager.hasNeon() ? 1 : 0;
        }
        sProcessorCompatible = n2;
        DeviceManager.calcNumberOfCoresAndMaxClock();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DeviceManager(Context context, boolean bl) {
        int n2;
        JSONObject jSONObject;
        JSONArray jSONArray;
        this.mContext = context;
        if (!bl) {
            return;
        }
        String string = this.loadDeviceListJson();
        try {
            jSONObject = new JSONObject(string);
            jSONArray = jSONObject.names();
            this.mDeviceList = new HashMap(jSONArray.length());
            n2 = 0;
        }
        catch (JSONException var5_9) {
            var5_9.printStackTrace();
            throw new RuntimeException("Failed to parse /res/raw/device_list.json. Please make sure JSON syntax is correct!", (Throwable)var5_9);
        }
        while (n2 < jSONArray.length()) {
            String string2 = jSONArray.getString(n2);
            DeviceInfo deviceInfo = new DeviceInfo(jSONObject.getJSONObject(string2), string2);
            this.mDeviceList.put((Object)string2, (Object)deviceInfo);
            ++n2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void calcNumberOfCoresAndMaxClock() {
        File[] arrfile;
        int n2 = 0;
        try {
            arrfile = new File("/sys/devices/system/cpu/").listFiles(new FileFilter(){

                public boolean accept(File file) {
                    if (Pattern.matches((String)"cpu[0-9]", (CharSequence)file.getName())) {
                        return true;
                    }
                    return false;
                }
            });
            sNumberOfCores = arrfile.length;
            sProcessorFrequency = -1;
        }
        catch (Exception var1_5) {
            sNumberOfCores = Runtime.getRuntime().availableProcessors();
            sProcessorFrequency = -1;
            return;
        }
        do {
            if (n2 < arrfile.length) {
                String string = arrfile[n2].getAbsolutePath() + "/cpufreq/cpuinfo_max_freq";
                Log.d((Object)DeviceManager.class, (String)"Examining file {}", (Object[])new Object[]{string});
                int n3 = DeviceManager.readFreq(string);
                if (n3 > sProcessorFrequency) {
                    sProcessorFrequency = n3;
                }
            } else {
                if (sProcessorFrequency != -1) {
                    sProcessorFrequency = Math.round((float)((float)sProcessorFrequency / 1000.0f));
                }
                Object[] arrobject = new Object[]{sProcessorFrequency};
                Log.i((Object)DeviceManager.class, (String)"Calculated max CPU frequency: {} MHz", (Object[])arrobject);
                return;
            }
            ++n2;
        } while (true);
    }

    public static String getAndroidRelease() {
        return Build.VERSION.RELEASE;
    }

    public static Version getAndroidVersion() {
        return new Version(DeviceManager.getAndroidRelease());
    }

    public static String getDevice() {
        return Build.DEVICE;
    }

    public static DeviceInfo getDeviceInfo() {
        return new DeviceInfo(DeviceManager.getDevice(), DeviceManager.getModel());
    }

    private DeviceInfo getDeviceInfoFromList() {
        DeviceInfo deviceInfo = DeviceManager.getDeviceInfo();
        return (DeviceInfo)this.mDeviceList.get((Object)deviceInfo.getUniqueName());
    }

    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public static int getMaxCPUFrequency() {
        return sProcessorFrequency;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static int getNumberOfCores() {
        return sNumberOfCores;
    }

    public static String getProcessorABI() {
        return Build.CPU_ABI;
    }

    public static int getSdkVersion() {
        return Build.VERSION.SDK_INT;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean hasNeon() {
        if (!new File("/proc/cpuinfo").exists()) {
            Log.e((Object)DeviceManager.class, (String)"File /proc/cpuinfo seems to be missing. Cannot determine whether NEON is supported. Will assume it is (and risk crash).", (Object[])new Object[0]);
            return true;
        }
        try {
            String string;
            BufferedReader bufferedReader = new BufferedReader((Reader)new FileReader(new File("/proc/cpuinfo")));
            do {
                if ((string = bufferedReader.readLine()) != null) continue;
                bufferedReader.close();
                return false;
            } while (!string.contains((CharSequence)"neon"));
            bufferedReader.close();
            return true;
        }
        catch (IOException var1_2) {
            Log.e((Object)DeviceManager.class, (Throwable)var1_2, (String)"Cannot read /proc/cpuinfo to obtain whether NEON is supported. Will assume it is (and risk crash).", (Object[])new Object[0]);
            return true;
        }
    }

    static boolean isArm7Processor() {
        return Build.CPU_ABI.equals((Object)"armeabi-v7a");
    }

    public static boolean isProcessorCompatible() {
        return sProcessorCompatible;
    }

    private String loadDeviceListJson() {
        AssetManager assetManager = this.mContext.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("microblink/device_list.json");
            StringWriter stringWriter = new StringWriter();
            BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(inputStream, "UTF-8"));
            String string = bufferedReader.readLine();
            while (string != null) {
                stringWriter.write(string);
                string = bufferedReader.readLine();
            }
            String string2 = stringWriter.toString();
            return string2;
        }
        catch (IOException var5_7) {
            throw new RuntimeException("Cannot load asset microblink/device_list.json. Please make sure that this asset exists!", (Throwable)var5_7);
        }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    private boolean matchesVersionInterval(VersionInterval versionInterval) {
        if (versionInterval == null) {
            return false;
        }
        try {
            boolean bl = versionInterval.contains(DeviceManager.getAndroidVersion());
            return bl;
        }
        catch (Exception var2_3) {
            Log.w((Object)this, (Throwable)var2_3, (String)"Failed to extract android version number!", (Object[])new Object[0]);
            return false;
        }
    }

    /*
     * Exception decompiling
     */
    private static int readFreq(String var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 3 blocks at once
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:371)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:449)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:2859)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:805)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
        // org.benf.cfr.reader.Main.doJar(Main.java:128)
        // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
        // java.lang.Thread.run(Thread.java:841)
        throw new IllegalStateException("Decompilation failed");
    }

    public float adjustZoomLevel(float f2) {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo != null) {
            float f3 = (float)deviceInfo.getMinZoomLevel();
            float f4 = f3 + f2 * ((float)deviceInfo.getMaxZoomLevel() - f3);
            Object[] arrobject = new Object[]{Float.valueOf((float)f2), Float.valueOf((float)f4)};
            Log.i((Object)this, (String)"Adjusting zoom level from {} to {}", (Object[])arrobject);
            return f4;
        }
        Object[] arrobject = new Object[]{Float.valueOf((float)f2)};
        Log.i((Object)this, (String)"Keeping zoom level at {}", (Object[])arrobject);
        return f2;
    }

    public boolean deviceHasAutofocus() {
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.autofocus");
    }

    @SuppressLint(value={"InlinedApi"})
    public boolean deviceHasCamera() {
        if (Build.VERSION.SDK_INT >= 9) {
            if (this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera") || this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera.front")) {
                return true;
            }
            return false;
        }
        return this.mContext.getPackageManager().hasSystemFeature("android.hardware.camera");
    }

    public int getCameraInitDelay() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return -1;
        }
        return deviceInfo.getCameraInitDelay();
    }

    public Context getContext() {
        return this.mContext;
    }

    public double getFrameQualityFactor() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo != null) {
            return deviceInfo.getFrameQualityFactor();
        }
        return 1.0;
    }

    public NativeDeviceManager getNativeDeviceManager() {
        if (this.mDeviceList == null) {
            throw new RuntimeException("Device lists have to be loaded to build native device manager");
        }
        return new NativeDeviceManager(this);
    }

    public CameraStrategy.PreviewSize getOptimalBackFacingPhotoSize() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return null;
        }
        return deviceInfo.getOptimalBackFacingPictureSize();
    }

    public CameraStrategy.PreviewSize getOptimalBackFacingPreviewSize() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return null;
        }
        return deviceInfo.getOptimalBackFacingPreviewSize();
    }

    public CameraStrategy.PreviewSize getOptimalFrontFacingPhotoSize() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return null;
        }
        return deviceInfo.getOptimalFrontFacingPictureSize();
    }

    public CameraStrategy.PreviewSize getOptimalFrontFacingPreviewSize() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return null;
        }
        return deviceInfo.getOptimalFrontFacingPreviewSize();
    }

    public NotSupportedReason getReasonForLackOfSupport(boolean bl) {
        if (DeviceManager.getSdkVersion() < 7) {
            return NotSupportedReason.UNSUPPORTED_ANDROID_VERSION;
        }
        if (!this.deviceHasCamera()) {
            return NotSupportedReason.NO_CAMERA;
        }
        if (bl && !this.deviceHasAutofocus()) {
            return NotSupportedReason.NO_AUTOFOCUS_CAMERA;
        }
        if (this.isDeviceOnBlackList()) {
            return NotSupportedReason.BLACKLISTED_DEVICE;
        }
        if (!DeviceManager.isProcessorCompatible()) {
            return NotSupportedReason.UNSUPPORTED_PROCESSOR_ARCHITECTURE;
        }
        return null;
    }

    public boolean hasDeviceListsLoaded() {
        if (this.mDeviceList != null) {
            return true;
        }
        return false;
    }

    public boolean isAllowedToUseZeroCopyBuffer() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return false;
        }
        return this.matchesVersionInterval(deviceInfo.getZeroCopyBufferAllowedInVersions());
    }

    public boolean isDeviceLandscapeLeftTablet() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return false;
        }
        return this.matchesVersionInterval(deviceInfo.getNaturalOrientationIsLandscapeLeftInVersions());
    }

    public boolean isDeviceOnBlackList() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return false;
        }
        return this.matchesVersionInterval(deviceInfo.getBlacklistedInVersions());
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean isDeviceSupported() {
        boolean bl = DeviceManager.getSdkVersion() >= 7;
        if (!this.deviceHasCamera()) return false;
        boolean bl2 = this.deviceHasAutofocus();
        if (!bl) return false;
        if (bl2 && !this.isDeviceOnBlackList()) {
            return true;
        }
        return false;
    }

    public boolean isDisplayOrientationBlacklisted() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return false;
        }
        return this.matchesVersionInterval(deviceInfo.getDisplayOrientationNotWorkingInVersions());
    }

    public boolean isEGLPbufferNotSupported() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return false;
        }
        return this.matchesVersionInterval(deviceInfo.getEglPbufferNotSupportedInVersions());
    }

    public boolean isFocusCallbackUntrusty() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return false;
        }
        return this.matchesVersionInterval(deviceInfo.getFocusUntrustyInVersions());
    }

    public boolean isForceUseLegacyCameraAPI() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return false;
        }
        return this.matchesVersionInterval(deviceInfo.getForceUseLegacyCamera());
    }

    public boolean isMeteringAreaBuggy() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null) {
            return false;
        }
        return this.matchesVersionInterval(deviceInfo.getMeteringNotWorkingInVersions());
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean isPhaseAutofocusBuggy() {
        DeviceInfo deviceInfo = this.getDeviceInfoFromList();
        if (deviceInfo == null || !this.matchesVersionInterval(deviceInfo.getPhaseAutofocusSupportedInVersions())) {
            return true;
        }
        return false;
    }

}

