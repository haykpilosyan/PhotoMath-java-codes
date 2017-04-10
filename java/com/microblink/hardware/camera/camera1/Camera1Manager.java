/*
 * Decompiled with CFR 0_110.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.ImageFormat
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.graphics.SurfaceTexture
 *  android.hardware.Camera
 *  android.hardware.Camera$CameraInfo
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$Size
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.support.annotation.Nullable
 *  android.support.annotation.UiThread
 *  android.view.Display
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.WindowManager
 *  com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool
 *  com.microblink.hardware.camera.camera1.strategy.CameraStrategy
 *  com.microblink.hardware.camera.camera1.strategy.factory.ICameraStrategyFactory
 *  com.microblink.util.CameraCompatibility
 *  com.microblink.util.IProcessingQueue
 *  com.microblink.util.Log
 *  com.microblink.util.ProcessingQueue
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.InterruptedException
 *  java.lang.Math
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.microblink.hardware.camera.camera1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.WindowManager;
import com.microblink.hardware.DeviceManager;
import com.microblink.hardware.SuccessCallback;
import com.microblink.hardware.accelerometer.AccelerometerManager;
import com.microblink.hardware.accelerometer.ShakeCallback;
import com.microblink.hardware.camera.CameraListener;
import com.microblink.hardware.camera.CameraResolutionTooSmallException;
import com.microblink.hardware.camera.CameraSettings;
import com.microblink.hardware.camera.CameraSurface;
import com.microblink.hardware.camera.CameraType;
import com.microblink.hardware.camera.ICameraManager;
import com.microblink.hardware.camera.ImageSize;
import com.microblink.hardware.camera.VideoResolutionPreset;
import com.microblink.hardware.camera.camera1.focus.IFocusManager;
import com.microblink.hardware.camera.camera1.frame.Camera1AbstractFrame;
import com.microblink.hardware.camera.camera1.frame.Camera1PreviewFramePool;
import com.microblink.hardware.camera.camera1.strategy.CameraStrategy;
import com.microblink.hardware.camera.camera1.strategy.factory.ICameraStrategyFactory;
import com.microblink.util.CameraCompatibility;
import com.microblink.util.IProcessingQueue;
import com.microblink.util.Log;
import com.microblink.util.ProcessingQueue;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint(value={"NewApi"})
public abstract class Camera1Manager
implements ICameraManager {
    protected AccelerometerManager mAccelManager = null;
    protected Boolean mAutofocusSupported = null;
    protected Camera mCamera = null;
    protected CameraListener mCameraDelegate = null;
    private boolean mCameraLikeActive = false;
    private IProcessingQueue mCameraQueue;
    private int mCameraSensorOrientation = -1;
    protected CameraSettings mCameraSettings = null;
    private boolean mCameraShuttingDown = false;
    private ICameraManager.CameraStartupCallback mCameraStartupCallback;
    protected CameraStrategy mCameraStrategy = null;
    private ICameraStrategyFactory mCameraStrategyFactory = null;
    protected CameraSurface mCameraSurface = null;
    private CameraType mCameraType = null;
    private Camera.Size mCurrentPreviewSize = null;
    protected DeviceManager mDeviceManager;
    protected boolean mDeviceShaking = true;
    private AtomicBoolean mDisposed = new AtomicBoolean(false);
    private IFocusManager mFocusManager = null;
    private int mLastRotation = 0;
    protected volatile boolean mPreviewActive = false;
    protected Camera1PreviewFramePool mPreviewFramePool = null;
    protected ShakeCallback mShakeCallback = null;
    private Boolean mTorchSupported = null;

    @UiThread
    public Camera1Manager(DeviceManager deviceManager, AccelerometerManager accelerometerManager, ICameraStrategyFactory iCameraStrategyFactory, CameraListener cameraListener, CameraSettings cameraSettings) {
        this.mAccelManager = accelerometerManager;
        this.mDeviceManager = deviceManager;
        if (!this.mDeviceManager.hasDeviceListsLoaded()) {
            throw new IllegalArgumentException("Provided device manager must have device lists loaded!");
        }
        this.mCameraDelegate = cameraListener;
        this.mCameraSettings = cameraSettings;
        this.mCameraStrategyFactory = iCameraStrategyFactory;
        if (this.mAccelManager == null || this.mCameraStrategyFactory == null) {
            throw new NullPointerException("Camera manager requires accelerometer manager and camera strategy factory to be non-null");
        }
        if (this.mCameraDelegate == null) {
            throw new NullPointerException("Camera delegate can't be null.");
        }
        if (this.mCameraSettings == null) {
            this.mCameraSettings = new CameraSettings();
        }
        this.mAccelManager.setAccelerometerDelegate(this);
        this.mCameraQueue = CameraThreadHolder.INSTANCE.getCameraQueue();
    }

    static /* synthetic */ Camera access$100(Camera1Manager camera1Manager, CameraType cameraType) {
        return camera1Manager.openCamera(cameraType);
    }

    static /* synthetic */ ICameraStrategyFactory access$200(Camera1Manager camera1Manager) {
        return camera1Manager.mCameraStrategyFactory;
    }

    static /* synthetic */ int access$302(Camera1Manager camera1Manager, int n2) {
        camera1Manager.mCameraSensorOrientation = n2;
        return n2;
    }

    static /* synthetic */ int access$500(Camera1Manager camera1Manager) {
        return camera1Manager.mLastRotation;
    }

    static /* synthetic */ AtomicBoolean access$600(Camera1Manager camera1Manager) {
        return camera1Manager.mDisposed;
    }

    static /* synthetic */ ICameraManager.CameraStartupCallback access$700(Camera1Manager camera1Manager) {
        return camera1Manager.mCameraStartupCallback;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void applyZoomLevel(float f2, Camera.Parameters parameters) {
        float f3 = 1.0f;
        float f4 = this.mDeviceManager.adjustZoomLevel(f2);
        if (f4 <= f3) {
            f3 = f4 < 0.0f ? 0.0f : f4;
        }
        parameters.setZoom(Math.round((float)(f3 * (float)parameters.getMaxZoom())));
    }

    private boolean checkForAutofocus(int n2) {
        Camera camera = Camera.open((int)n2);
        boolean bl = camera.getParameters().getSupportedFocusModes().contains((Object)"auto");
        camera.release();
        return bl;
    }

    private void closeCamera() {
        if (this.mCamera != null) {
            if (this.isUsingBufferedCallback()) {
                this.mCamera.setPreviewCallbackWithBuffer(null);
            }
            Log.i((Object)this, (String)"Stopping camera preview", (Object[])new Object[0]);
            this.mPreviewActive = false;
            this.mCamera.stopPreview();
            if (!this.mDisposed.get()) {
                this.mCameraStartupCallback.onPreviewStopped();
            }
            Log.i((Object)this, (String)"Releasing camera", (Object[])new Object[0]);
            this.mCamera.release();
            Log.i((Object)this, (String)"Camera released", (Object[])new Object[0]);
            this.mCamera = null;
            this.mTorchSupported = null;
            this.mAutofocusSupported = null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void determineIfTorchIsSupported() {
        if (this.mCamera == null) return;
        List list = this.mCamera.getParameters().getSupportedFlashModes();
        if (list != null && list.contains((Object)"torch")) {
            Log.i((Object)this, (String)"Camera supports torch!", (Object[])new Object[0]);
            this.mTorchSupported = Boolean.TRUE;
            return;
        }
        Log.i((Object)this, (String)"Camera does not support torch!", (Object[])new Object[0]);
        this.mTorchSupported = Boolean.FALSE;
    }

    private void determinePreviewSize(CameraSurface cameraSurface) {
        this.mCurrentPreviewSize = this.mCameraStrategy.getOptimalPreviewSize(cameraSurface.getWidth(), cameraSurface.getHeight(), this.mCameraType);
        if (this.mCurrentPreviewSize == null) {
            throw new CameraResolutionTooSmallException("Camera preview size could not be chosen!");
        }
        Object[] arrobject = new Object[]{cameraSurface.getWidth(), cameraSurface.getHeight(), this.mCameraSettings.getVideoResolutionPreset(), this.mCurrentPreviewSize.width, this.mCurrentPreviewSize.height};
        Log.i((Object)this, (String)"For surface size {}x{} and preset {}, selected preview size is {}x{}", (Object[])arrobject);
    }

    /*
     * Exception decompiling
     */
    private void localStartPreview() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 4[TRYBLOCK]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:394)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:446)
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

    /*
     * Enabled aggressive block sorting
     */
    private Camera openCamera(CameraType cameraType) {
        if (Build.VERSION.SDK_INT < 9) {
            this.mCameraType = CameraType.CAMERA_BACKFACE;
            return Camera.open();
        }
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int n2 = Camera.getNumberOfCameras();
        int n3 = -1;
        int n4 = -1;
        int n5 = -1;
        int n6 = -1;
        boolean bl = false;
        boolean bl2 = false;
        for (int i2 = 0; i2 < n2; ++i2) {
            Camera.getCameraInfo((int)i2, (Camera.CameraInfo)cameraInfo);
            if (cameraInfo.facing == 1) {
                if (n3 == -1) {
                    n5 = cameraInfo.orientation;
                    Object[] arrobject = new Object[]{n5};
                    Log.i((Object)this, (String)"Front facing orientation: {}", (Object[])arrobject);
                    bl = this.checkForAutofocus(i2);
                    n3 = i2;
                    continue;
                }
                if (!bl) {
                    if (!this.checkForAutofocus(i2)) continue;
                    n5 = cameraInfo.orientation;
                    Object[] arrobject = new Object[]{n5};
                    Log.i((Object)this, (String)"Front facing orientation: {}", (Object[])arrobject);
                    bl = true;
                    n3 = i2;
                    continue;
                }
                Object[] arrobject = new Object[]{n3};
                Log.w((Object)this, (String)"Handling multiple front cameras with autofocus currently not supported! Will use the first found '{}'", (Object[])arrobject);
                continue;
            }
            if (cameraInfo.facing != 0) continue;
            if (n4 == -1) {
                n6 = cameraInfo.orientation;
                Object[] arrobject = new Object[]{n6};
                Log.i((Object)this, (String)"Back facing orientation: {}", (Object[])arrobject);
                bl2 = this.checkForAutofocus(i2);
                n4 = i2;
                continue;
            }
            if (!bl2) {
                if (!this.checkForAutofocus(i2)) continue;
                n6 = cameraInfo.orientation;
                bl2 = true;
                n4 = i2;
                continue;
            }
            Object[] arrobject = new Object[]{n4};
            Log.w((Object)this, (String)"Handling multiple back cameras with autofocus currently not supported. Will use the first found '{}'", (Object[])arrobject);
        }
        if (cameraType == CameraType.CAMERA_BACKFACE) {
            if (n4 > -1) {
                this.mCameraType = CameraType.CAMERA_BACKFACE;
                this.mCameraSensorOrientation = n6;
                return Camera.open((int)n4);
            }
            throw new RuntimeException("Device does not have back facing camera!");
        }
        if (cameraType == CameraType.CAMERA_FRONTFACE) {
            if (n3 > -1) {
                this.mCameraType = CameraType.CAMERA_FRONTFACE;
                this.mCameraSensorOrientation = n5;
                return Camera.open((int)n3);
            }
            throw new RuntimeException("Device does not have front facing camera!");
        }
        if (n4 > -1) {
            this.mCameraType = CameraType.CAMERA_BACKFACE;
            this.mCameraSensorOrientation = n6;
            return Camera.open((int)n4);
        }
        if (n3 > -1) {
            this.mCameraType = CameraType.CAMERA_FRONTFACE;
            this.mCameraSensorOrientation = n5;
            return Camera.open((int)n3);
        }
        throw new RuntimeException("Device does not have cameras!");
    }

    @Override
    public boolean areOpenedCamerasPixelsLandscapeLeft() {
        if (this.mCameraSensorOrientation == 270) {
            return true;
        }
        return false;
    }

    protected int calculateBufferSize(Camera.Size size, int n2) {
        int n3 = ImageFormat.getBitsPerPixel((int)n2);
        if (n3 == -1) {
            n3 = 24;
        }
        return n3 * (size.width * size.height) / 8;
    }

    @UiThread
    @Override
    public boolean cameraSupportsTorch() {
        if (this.mTorchSupported != null) {
            return this.mTorchSupported;
        }
        Log.e((Object)this, (String)"Camera not yet initialized. Unable to determine if torch is supported!", (Object[])new Object[0]);
        return false;
    }

    @UiThread
    @Override
    public void dispose() {
        if (this.mDisposed.compareAndSet(false, true)) {
            if (this.mPreviewFramePool != null) {
                this.mPreviewFramePool.dispose();
            }
            this.mPreviewFramePool = null;
            if (this.mFocusManager != null) {
                this.mFocusManager.dispose();
            }
            this.mFocusManager = null;
            this.mAccelManager = null;
            this.mCameraSettings = null;
            this.mCameraDelegate = null;
            this.mCameraStrategyFactory = null;
            this.mShakeCallback = null;
            this.mCurrentPreviewSize = null;
            this.mCameraType = null;
            this.mDeviceManager = null;
            this.mCameraStartupCallback = null;
        }
    }

    @Override
    public boolean doesCameraHaveSurface() {
        if (this.mCameraSurface != null) {
            return true;
        }
        return false;
    }

    protected void finalize() throws Throwable {
        this.dispose();
        super.finalize();
    }

    protected IProcessingQueue getCameraQueue() {
        return this.mCameraQueue;
    }

    @Override
    public ImageSize getCurrentPreviewSize() {
        if (this.mCurrentPreviewSize == null) {
            return null;
        }
        return new ImageSize(this.mCurrentPreviewSize.width, this.mCurrentPreviewSize.height);
    }

    protected IFocusManager getFocusManager() {
        return this.mFocusManager;
    }

    @Override
    public final CameraType getOpenedCameraType() {
        return this.mCameraType;
    }

    protected abstract Camera.PreviewCallback getPreviewCallback();

    @Override
    public SurfaceHolder.Callback getSurfaceHolderCallback() {
        return new SurfaceHolder.Callback(){

            public void surfaceChanged(SurfaceHolder surfaceHolder, int n2, int n3, int n4) {
                Camera1Manager camera1Manager = Camera1Manager.this;
                Object[] arrobject = new Object[]{n3, n4, n2};
                Log.d((Object)camera1Manager, (String)"Surface changed to size: {}x{}, format: {}", (Object[])arrobject);
            }

            /*
             * Enabled aggressive block sorting
             */
            public void surfaceCreated(final SurfaceHolder surfaceHolder) {
                int n2;
                int n3;
                Log.i((Object)Camera1Manager.this, (String)"Surface has been created!", (Object[])new Object[0]);
                Display display = ((WindowManager)Camera1Manager.this.mDeviceManager.getContext().getSystemService("window")).getDefaultDisplay();
                if (Build.VERSION.SDK_INT >= 13) {
                    Point point = new Point();
                    display.getSize(point);
                    n2 = point.x;
                    n3 = point.y;
                } else {
                    n2 = display.getWidth();
                    n3 = display.getHeight();
                }
                if (!Camera1Manager.this.mPreviewActive) {
                    Camera1Manager.this.mCameraQueue.postJob(new Runnable(){

                        public void run() {
                            Camera1Manager.this.mCameraSurface = new CameraSurface(surfaceHolder, n2, n3);
                            Camera1Manager.this.localStartPreview();
                        }
                    });
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                Log.i((Object)Camera1Manager.this, (String)"Surface is being destroyed", (Object[])new Object[0]);
                Camera1Manager.this.runOnCameraThread(new Runnable(){

                    public void run() {
                        if (Camera1Manager.this.mCameraSurface != null) {
                            Log.i((Object)Camera1Manager.this, (String)"Removing callback from surface holder", (Object[])new Object[0]);
                            Camera1Manager.this.mCameraSurface.getSurfaceHolder().removeCallback(this);
                            Camera1Manager.this.mCameraSurface = null;
                        }
                    }
                });
            }

        };
    }

    @Override
    public TextureView.SurfaceTextureListener getSurfaceTextureListener() {
        return new TextureView.SurfaceTextureListener(){

            public void onSurfaceTextureAvailable(final SurfaceTexture surfaceTexture, final int n2, final int n3) {
                Camera1Manager camera1Manager = Camera1Manager.this;
                Object[] arrobject = new Object[]{n2, n3};
                Log.i((Object)camera1Manager, (String)"SurfaceTexture has become available (size: {}x{})", (Object[])arrobject);
                if (!Camera1Manager.this.mPreviewActive) {
                    Camera1Manager.this.mCameraQueue.postJob(new Runnable(){

                        public void run() {
                            Camera1Manager.this.mCameraSurface = new CameraSurface(surfaceTexture, n2, n3);
                            Camera1Manager.this.localStartPreview();
                        }
                    });
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                Log.i((Object)Camera1Manager.this, (String)"SurfaceTexture is about to be destroyed", (Object[])new Object[0]);
                if (Camera1Manager.this.mCameraQueue != null) {
                    Camera1Manager.this.mCameraQueue.postJob(new Runnable(){

                        public void run() {
                            if (Camera1Manager.this.mCameraSurface != null) {
                                Log.i((Object)Camera1Manager.this, (String)"Releasing SurfaceTexture", (Object[])new Object[0]);
                                Camera1Manager.this.mCameraSurface.getSurfaceTexture().release();
                                Camera1Manager.this.mCameraSurface = null;
                            }
                        }
                    });
                    return false;
                }
                Log.i((Object)Camera1Manager.this, (String)"Immediately releasing SurfaceTexture", (Object[])new Object[0]);
                return true;
            }

            public void onSurfaceTextureSizeChanged(final SurfaceTexture surfaceTexture, final int n2, final int n3) {
                Camera1Manager camera1Manager = Camera1Manager.this;
                Object[] arrobject = new Object[]{n2, n3};
                Log.i((Object)camera1Manager, (String)"SurfaceTexture has changed size (new size: {}x{})", (Object[])arrobject);
                if (!Camera1Manager.this.mPreviewActive) {
                    Camera1Manager.this.mCameraQueue.postJob(new Runnable(){

                        public void run() {
                            Camera1Manager.this.mCameraSurface = new CameraSurface(surfaceTexture, n2, n3);
                            Camera1Manager.this.localStartPreview();
                        }
                    });
                }
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

        };
    }

    @Nullable
    @Override
    public Boolean isAutofocusSupported() {
        return this.mAutofocusSupported;
    }

    @UiThread
    @Override
    public boolean isCameraFocusing() {
        IFocusManager iFocusManager = this.mFocusManager;
        if (iFocusManager != null && iFocusManager.isAutofocusing()) {
            return true;
        }
        return false;
    }

    @UiThread
    @Override
    public boolean isCameraInFocus() {
        IFocusManager iFocusManager = this.mFocusManager;
        if (iFocusManager != null && iFocusManager.isCameraFocused()) {
            return true;
        }
        return false;
    }

    @UiThread
    @Override
    public boolean isDeviceShaking() {
        return this.mDeviceShaking;
    }

    @Override
    public boolean isPreviewActive() {
        return this.mPreviewActive;
    }

    protected boolean isUsingBufferedCallback() {
        if (Build.VERSION.SDK_INT >= 8) {
            return true;
        }
        return false;
    }

    @UiThread
    @Override
    public void onShakingStarted() {
        Object[] arrobject = new Object[]{this, this.mFocusManager, this.mCameraQueue};
        Log.v((Object)this, (String)"shaking started, this = {}, focus manager: {}, camera queue: {}", (Object[])arrobject);
        this.mDeviceShaking = true;
        if (this.mFocusManager != null) {
            this.mCameraQueue.postJob(new Runnable(){

                public void run() {
                    IFocusManager iFocusManager = Camera1Manager.this.mFocusManager;
                    if (iFocusManager != null) {
                        iFocusManager.pauseFocusing();
                    }
                }
            });
        }
        if (this.mShakeCallback != null) {
            this.mShakeCallback.onShakingStarted();
        }
    }

    @UiThread
    @Override
    public void onShakingStopped() {
        Object[] arrobject = new Object[]{this, this.mFocusManager, this.mCameraQueue};
        Log.v((Object)this, (String)"shaking stopped, this = {}, focus manager: {}, camera queue: {}", (Object[])arrobject);
        if (this.mFocusManager != null) {
            this.mCameraQueue.postJob(new Runnable(){

                public void run() {
                    IFocusManager iFocusManager = Camera1Manager.this.mFocusManager;
                    if (iFocusManager != null) {
                        iFocusManager.resumeFocusing();
                        iFocusManager.invalidateFocus();
                        iFocusManager.doAutofocus(false);
                    }
                }
            });
        }
        this.mDeviceShaking = false;
        if (this.mShakeCallback != null) {
            this.mShakeCallback.onShakingStopped();
        }
    }

    @UiThread
    @Override
    public void performAutofocus() {
        if (this.mFocusManager != null && !this.mFocusManager.isAutofocusing()) {
            this.mCameraQueue.postJob(new Runnable(){

                public void run() {
                    IFocusManager iFocusManager = Camera1Manager.this.mFocusManager;
                    if (iFocusManager != null && !iFocusManager.isAutofocusing()) {
                        iFocusManager.doAutofocus(true);
                    }
                }
            });
        }
    }

    protected abstract IFocusManager prepareCameraParameteresAndFocusManager(Camera.Parameters var1);

    public void recycleFrame(final Camera1AbstractFrame camera1AbstractFrame) {
        this.runOnCameraThread(new Runnable(){

            /*
             * Enabled aggressive block sorting
             */
            public void run() {
                if (Camera1Manager.this.mCamera != null && !Camera1Manager.this.mCameraShuttingDown) {
                    IFocusManager iFocusManager;
                    if (Camera1Manager.this.isUsingBufferedCallback()) {
                        if (camera1AbstractFrame.getImgBuffer() != null) {
                            Camera1Manager.this.mCamera.addCallbackBuffer(camera1AbstractFrame.getImgBuffer());
                        }
                    } else {
                        Camera1Manager.this.mCamera.setOneShotPreviewCallback(Camera1Manager.this.getPreviewCallback());
                    }
                    if ((iFocusManager = Camera1Manager.this.mFocusManager) != null) {
                        iFocusManager.checkFocus();
                    }
                    return;
                }
                Log.w((Object)Camera1Manager.this, (String)"Camera is released, cannot request another frame", (Object[])new Object[0]);
            }
        });
    }

    @UiThread
    public void rotateCameraPreview(final int n2) {
        this.mLastRotation = n2;
        if (this.mPreviewActive) {
            this.mCameraQueue.postJob(new Runnable(){

                /*
                 * Enabled aggressive block sorting
                 */
                public void run() {
                    IFocusManager iFocusManager;
                    boolean bl = true;
                    if (Camera1Manager.this.mPreviewActive && DeviceManager.getSdkVersion() < 14) {
                        Camera1Manager.this.mCamera.stopPreview();
                    }
                    if ((iFocusManager = Camera1Manager.this.mFocusManager).isAutofocusing()) {
                        iFocusManager.cancelOngoingFocus();
                    }
                    Camera1Manager camera1Manager = Camera1Manager.this;
                    Object[] arrobject = new Object[bl];
                    arrobject[0] = n2;
                    Log.i((Object)camera1Manager, (String)"Rotating camera preview by {} degrees!", (Object[])arrobject);
                    Camera camera = Camera1Manager.this.mCamera;
                    int n22 = n2;
                    int n3 = Camera1Manager.this.mCameraSensorOrientation;
                    if (Camera1Manager.this.mCameraType != CameraType.CAMERA_FRONTFACE) {
                        bl = false;
                    }
                    CameraCompatibility.setDisplayOrientation((Camera)camera, (int)n22, (int)n3, (boolean)bl);
                    Camera1Manager.this.mLastRotation = n2;
                    if (DeviceManager.getSdkVersion() < 14) {
                        Camera1Manager.this.mCamera.startPreview();
                    }
                }
            });
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    protected void runOnCameraThread(Runnable runnable) {
        if (this.mCameraQueue == null) return;
        if (Looper.myLooper() == this.mCameraQueue.getHandler().getLooper()) {
            runnable.run();
            return;
        }
        this.mCameraQueue.postJob(runnable);
    }

    @UiThread
    @Override
    public void setMeteringAreas(final Rect[] arrrect) {
        if (Build.VERSION.SDK_INT >= 14 && !this.mDeviceManager.isMeteringAreaBuggy()) {
            if (this.mCameraQueue != null && this.mFocusManager != null) {
                this.mCameraQueue.postJob(new Runnable(){

                    public void run() {
                        IFocusManager iFocusManager = Camera1Manager.this.mFocusManager;
                        if (iFocusManager != null) {
                            iFocusManager.setMeteringAreas(arrrect);
                        }
                    }
                });
            }
            return;
        }
        Log.e((Object)this, (String)"Setting metering areas not supported on this device", (Object[])new Object[0]);
    }

    @UiThread
    @Override
    public void setShakeCallback(ShakeCallback shakeCallback) {
        this.mShakeCallback = shakeCallback;
    }

    @UiThread
    @Override
    public void setTorchState(final boolean bl, final SuccessCallback successCallback) {
        if (!this.cameraSupportsTorch()) {
            Log.e((Object)this, (String)"Camera does not support torch! Cannot change torch state!", (Object[])new Object[0]);
            if (successCallback != null) {
                successCallback.onOperationDone(false);
            }
            return;
        }
        this.mCameraQueue.postJob(new Runnable(){

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                if (Camera1Manager.this.mCamera != null) {
                    IFocusManager iFocusManager = Camera1Manager.this.mFocusManager;
                    if (iFocusManager != null && Camera1Manager.this.isCameraFocusing()) {
                        iFocusManager.cancelOngoingFocus();
                    }
                    try {
                        Camera.Parameters parameters = Camera1Manager.this.mCamera.getParameters();
                        if (bl) {
                            parameters.setFlashMode("torch");
                        } else {
                            List list = parameters.getSupportedFlashModes();
                            if (list != null && list.contains((Object)"off")) {
                                parameters.setFlashMode("off");
                            }
                        }
                        Camera1Manager.this.mCamera.setParameters(parameters);
                        Camera1Manager.this.performAutofocus();
                        if (successCallback == null) return;
                        {
                            successCallback.onOperationDone(true);
                            return;
                        }
                    }
                    catch (RuntimeException var2_4) {
                        if (successCallback == null) return;
                        {
                            successCallback.onOperationDone(false);
                            return;
                        }
                    }
                }
                Log.e((Object)Camera1Manager.this, (String)"Camera not yet initialized. Unable to change torch state!", (Object[])new Object[0]);
                if (successCallback == null) return;
                {
                    successCallback.onOperationDone(false);
                }
            }
        });
    }

    @UiThread
    @Override
    public void setZoomLevel(final float f2) {
        this.mCameraQueue.postJob(new Runnable(){

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public void run() {
                if (Camera1Manager.this.mCamera == null) return;
                try {
                    Camera.Parameters parameters = Camera1Manager.this.mCamera.getParameters();
                    Camera1Manager.this.applyZoomLevel(f2, parameters);
                    Camera1Manager.this.mCamera.setParameters(parameters);
                    return;
                }
                catch (RuntimeException var1_2) {
                    Camera1Manager camera1Manager = Camera1Manager.this;
                    Object[] arrobject = new Object[]{Float.valueOf((float)f2)};
                    Log.e((Object)camera1Manager, (String)"Failed to set zoom level to {}", (Object[])arrobject);
                    return;
                }
            }
        });
    }

    @UiThread
    @Override
    public void startPreview(final DeviceManager deviceManager, final CameraSettings cameraSettings, ICameraManager.CameraStartupCallback cameraStartupCallback) {
        if (this.mCameraLikeActive) {
            Log.i((Object)this, (String)"Start preview has already been called. Ignoring this call!", (Object[])new Object[0]);
            return;
        }
        Log.i((Object)this, (String)"Camera1Manager.startPreview", (Object[])new Object[0]);
        this.mCameraLikeActive = true;
        this.mCameraStartupCallback = cameraStartupCallback;
        this.mCameraSettings = cameraSettings;
        this.mCameraQueue.postJob(new Runnable(){

            /*
             * Exception decompiling
             */
            public void run() {
                // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                // java.util.ConcurrentModificationException
                // java.util.LinkedList$ReverseLinkIterator.next(LinkedList.java:217)
                // org.benf.cfr.reader.bytecode.analysis.structured.statement.Block.extractLabelledBlocks(Block.java:212)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement$LabelledBlockExtractor.transform(Op04StructuredStatement.java:485)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.transform(Op04StructuredStatement.java:639)
                // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.insertLabelledBlocks(Op04StructuredStatement.java:649)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:816)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:220)
                // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:165)
                // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:91)
                // org.benf.cfr.reader.entities.Method.analyse(Method.java:354)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:751)
                // org.benf.cfr.reader.entities.ClassFile.analyseInnerClassesPass1(ClassFile.java:664)
                // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:747)
                // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:683)
                // org.benf.cfr.reader.Main.doJar(Main.java:128)
                // com.njlabs.showjava.processor.JavaExtractor$1.run(JavaExtractor.java:100)
                // java.lang.Thread.run(Thread.java:841)
                throw new IllegalStateException("Decompilation failed");
            }
        });
    }

    @UiThread
    @Override
    public void stopPreview() {
        if (!this.mCameraLikeActive) {
            Log.i((Object)this, (String)"Stop preview has already been called. Ignoring this call!", (Object[])new Object[0]);
            return;
        }
        this.mCameraLikeActive = false;
        Log.i((Object)this, (String)"Camera1Manager.stopPreview", (Object[])new Object[0]);
        this.mCameraShuttingDown = true;
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mCameraQueue.postJob(new Runnable(){

            public void run() {
                AccelerometerManager accelerometerManager;
                IFocusManager iFocusManager = Camera1Manager.this.mFocusManager;
                if (iFocusManager != null) {
                    Log.i((Object)Camera1Manager.this, (String)"Pausing focus manager", (Object[])new Object[0]);
                    iFocusManager.pauseFocusing();
                    iFocusManager.setCamera(null);
                }
                if ((accelerometerManager = Camera1Manager.this.mAccelManager) != null) {
                    Log.i((Object)Camera1Manager.this, (String)"Pausing accelerometer", (Object[])new Object[0]);
                    accelerometerManager.stopAccelerometer();
                }
                Camera1Manager.this.closeCamera();
                Camera1Manager.this.mCameraStrategy = null;
                Camera1Manager.this.mCameraShuttingDown = false;
                countDownLatch.countDown();
            }
        });
        try {
            Log.i((Object)this, (String)"Waiting for camera preview to stop...", (Object[])new Object[0]);
            countDownLatch.await();
            Log.i((Object)this, (String)"Camera preview has stopped.", (Object[])new Object[0]);
            return;
        }
        catch (InterruptedException var2_2) {
            Log.w((Object)this, (Throwable)var2_2, (String)"Interrupted while waiting for camera preview to stop", (Object[])new Object[0]);
            return;
        }
    }

    private static final class CameraThreadHolder
    extends Enum<CameraThreadHolder> {
        private static final /* synthetic */ CameraThreadHolder[] $VALUES;
        public static final /* enum */ CameraThreadHolder INSTANCE = new CameraThreadHolder();
        private IProcessingQueue mCameraQueue;

        static {
            CameraThreadHolder[] arrcameraThreadHolder = new CameraThreadHolder[]{INSTANCE};
            $VALUES = arrcameraThreadHolder;
        }

        private CameraThreadHolder() {
            super(string, n2);
            ProcessingQueue processingQueue = new ProcessingQueue("Camera1");
            processingQueue.start();
            this.mCameraQueue = processingQueue;
        }

        public static CameraThreadHolder valueOf(String string) {
            return (CameraThreadHolder)Enum.valueOf((Class)CameraThreadHolder.class, (String)string);
        }

        public static CameraThreadHolder[] values() {
            return (CameraThreadHolder[])$VALUES.clone();
        }

        public IProcessingQueue getCameraQueue() {
            return this.mCameraQueue;
        }
    }

}

