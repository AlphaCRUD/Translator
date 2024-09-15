package com.alphacrud.phototranslator;

import static android.hardware.camera2.CameraMetadata.FLASH_MODE_OFF;
import static android.hardware.camera2.CameraMetadata.FLASH_MODE_SINGLE;
import static com.alphacrud.phototranslator.MyApplication.DA;

import android.Manifest;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraMetadata;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.AudioManager;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.exifinterface.media.ExifInterface;

import com.alphacrud.phototranslator.Utilis.SharedPreferenceClass;
import com.alphacrud.phototranslator.ads.AdsManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Camera extends AppCompatActivity {
    private static final String TAG = "AndroidCameraApi";
    private Button btn_Zoom, btn_brightnes;
    ImageButton takePictureButton;
    private TextureView textureView;
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    int layoutheights, layoutwidths;
    int textureheights, texturewidths;
    int totalheight, margin;

    static {
        ORIENTATIONS.append(Surface.ROTATION_0, 90);
        ORIENTATIONS.append(Surface.ROTATION_90, 0);
        ORIENTATIONS.append(Surface.ROTATION_180, 270);
        ORIENTATIONS.append(Surface.ROTATION_270, 180);
    }

    CameraCharacteristics characteristics;
    CameraManager manager;
    Rect zoom;
    public float finger_spacing = 0;
    public int zoom_level = 1;
    private String cameraId;
    protected CameraDevice cameraDevice;
    protected CameraCaptureSession cameraCaptureSessions;
    protected CaptureRequest captureRequest;
    protected CaptureRequest.Builder captureRequestBuilder;

    private Size imageDimension;
    private ImageReader imageReader;
    private File file;
    private static final int REQUEST_CAMERA_PERMISSION = 200;
    private boolean mFlashSupported;
    private Handler mBackgroundHandler;
    private HandlerThread mBackgroundThread;
    protected float fingerSpacing = 0;
    protected float zoomLevel = 1f;
    protected float maximumZoomLevel;
    private LinearLayout ocr, idcard;
    Bitmap croppedImage;
    View linearss;
    private ImageButton btnflas;
    boolean flashOn;
    String always = "";
    boolean mManualFocusEngaged;
    ProgressBar progressed;
    private LinearLayout rlprogress;
    private ImageView imgOcr, imgCard;
    private RelativeLayout rlcontainer;
    View vc, viewtwos;
    ImageView setImg;
    int setImgheigh, setImgWidth, viewtwosheight, viewtwosWidth;
    boolean idCard = false;
    boolean backCard = false, frontCard = false;
    TextView txtTop;
    private SeekBar sBar, seekBar2;
    String path = "";
    ImageView zoomin, zoomout, brighout, brightin;
    int z = 0;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        SharedPreferenceClass.getInstance(getApplicationContext());


        AdsManager.loadNativeAd(this, findViewById(R.id.nativeAd), R.layout.ad_unified_small);


        textureView = (TextureView) findViewById(R.id.texture);
//        LinearLayout linearLayout = findViewById(R.id.surface);
//        linearLayout.addView(new CustomView(this));

        ocr = findViewById(R.id.ocr);
        vc = findViewById(R.id.vc);
        rlprogress = findViewById(R.id.rlprogress);
        imgOcr = findViewById(R.id.imgOcr);
        zoomin = findViewById(R.id.zoomin);
        zoomout = findViewById(R.id.zoomout);
        txtTop = findViewById(R.id.txtTop);
        setImg = findViewById(R.id.setImg);
        viewtwos = findViewById(R.id.viewtwos);
        brighout = findViewById(R.id.brighout);
        brightin = findViewById(R.id.brightin);
        brighout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = seekBar2.getProgress();
                v = v + 1;
                seekBar2.setProgress(v);
                bright(v);
            }
        });
        brightin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int v = seekBar2.getProgress();
                v = v - 1;
                seekBar2.setProgress(v);
                bright(v);
            }
        });
        imgCard = findViewById(R.id.imgCard);
        rlprogress.setVisibility(View.GONE);
        idcard = findViewById(R.id.idcard);
        sBar = (SeekBar) findViewById(R.id.seekBar1);
        seekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        seekBar2.setProgress(6);
        rlcontainer = findViewById(R.id.rlcontainer);
        btn_Zoom = (Button) findViewById(R.id.btn_Zoom);
        linearss = (View) findViewById(R.id.linearss);
        btn_brightnes = (Button) findViewById(R.id.btn_brightnes);
        btnflas = (ImageButton) findViewById(R.id.btnflas);
        takePictureButton = (ImageButton) findViewById(R.id.btn_takepicture);
        assert textureView != null;
        textureView.setSurfaceTextureListener(textureListener);
        sBar.setProgress(z);
        progressed = findViewById(R.id.progressed);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        zoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                z = sBar.getProgress();
                z = z + 1;

                sBar.setProgress(z);
                Zoom(z);
            }
        });
        zoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                z = sBar.getProgress();
                z = z - 1;
                sBar.setProgress(z);
                Zoom(z);
            }
        });
        sBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
                Zoom(pval);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pval = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval = progress;
                bright(pval);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        progressed.setVisibility(View.VISIBLE);


        ViewTreeObserver viewTreeObserver = linearss.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    linearss.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    layoutheights = linearss.getHeight();
                    layoutwidths = linearss.getWidth();
                }
            });
        }

        ViewTreeObserver viewTreeObservera = textureView.getViewTreeObserver();
        if (viewTreeObservera.isAlive()) {
            viewTreeObservera.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    textureView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    textureheights = textureView.getHeight();
                    texturewidths = textureView.getWidth();

                }
            });
        }
        textureView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                try {
                    CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
                    characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
                    float maxzoom = (characteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)) * 3;

                    Rect m = characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
                    int action = event.getAction();
                    float current_finger_spacing;

                    if (event.getPointerCount() > 1) {
                        // Multi touch logic
                        current_finger_spacing = getFingerSpacing(event);

                        if (finger_spacing != 0) {
                            if (current_finger_spacing > finger_spacing && maxzoom > zoom_level) {
                                zoom_level = zoom_level + 2;

                            } else if (current_finger_spacing < finger_spacing && zoom_level > 1) {
                                zoom_level = zoom_level - 2;

                            }
                            int minW = (int) (m.width() / maxzoom);
                            int minH = (int) (m.height() / maxzoom);
                            int difW = m.width() - minW;
                            int difH = m.height() - minH;
                            int cropW = difW / 100 * (int) zoom_level;
                            int cropH = difH / 100 * (int) zoom_level;
                            cropW -= cropW & 3;
                            cropH -= cropH & 3;
                            zoom = new Rect(cropW, cropH, m.width() - cropW, m.height() - cropH);
                            captureRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, zoom);
                            Log.d("xomf", String.valueOf(zoom));
                        }
                        finger_spacing = current_finger_spacing;
                    } else {
//                        if (action == MotionEvent.ACTION_UP) {
//                            btn_Zoom.setVisibility(View.GONE);
//                            //single touch logic
//                        }
//                        if (action == MotionEvent.ACTION_UP) {
//                            new Handler().postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    try {
//                                        bright();
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }, 2000);
//                            //single touch logic
//                        }
//                        else
                        if (action == MotionEvent.ACTION_UP) {
                            setFocusArea((int) event.getX(),
                                    (int) event.getY());
//                            new Handler().postDelayed(new Runnable() {
//                                @Override
//                                public void run() {
//                                    try {
//                                        brightlow();
//                                    } catch (Exception e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }, 2000);                            //single touch logic
                        }
                    }

                    try {

                        cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);

                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    } catch (NullPointerException ex) {
                        ex.printStackTrace();
                    }
                } catch (CameraAccessException e) {
                    throw new RuntimeException("can not access camera.", e);
                }

                return true;
            }
        });

        assert takePictureButton != null;
        takePictureButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        rlprogress.setVisibility(View.VISIBLE);

                    }
                });
                takePicture();
            }
        });
        always = SharedPreferenceClass.getValue("flashStatus", "");

        if (always != null && always.equals("off")) {
            SharedPreferenceClass.setValue("flashStatus", "off");
            btnflas.setBackground(getResources().getDrawable(R.drawable.ic_baseline_flash_off_24));
        } else if (always != null && always.equals("on")) {
            SharedPreferenceClass.setValue("flashStatus", "on");
            btnflas.setBackground(getResources().getDrawable(R.drawable.ic_baseline_flash_on_24));
        } else {
            SharedPreferenceClass.setValue("flashStatus", "off");
            btnflas.setBackground(getResources().getDrawable(R.drawable.ic_baseline_flash_off_24));
        }

        assert btnflas != null;

        btnflas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                always = SharedPreferenceClass.getValue("flashStatus", "");

                if (always != null && always.equals("on")) {
                    SharedPreferenceClass.setValue("flashStatus", "alwaysoff");
                    btnflas.setBackground(getResources().getDrawable(R.drawable.ic_baseline_flash_off_24));
                } else if (always != null && always.equals("off")) {
                    SharedPreferenceClass.setValue("flashStatus", "on");
                    btnflas.setBackground(getResources().getDrawable(R.drawable.ic_baseline_flash_on_24));
                }
            }
        });
        assert idcard != null;
        assert ocr != null;
        idcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idCard = true;
                imgOcr.setVisibility(View.GONE);
                imgCard.setVisibility(View.VISIBLE);
                rlcontainer.setVisibility(View.VISIBLE);
                txtTop.setText("ID Card Front");
                frontCard = false;
                backCard = false;

            }
        });
        ocr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                idCard = false;
                imgOcr.setVisibility(View.VISIBLE);
                imgCard.setVisibility(View.GONE);
                rlcontainer.setVisibility(View.GONE);
                txtTop.setText("Camera");
                frontCard = false;
                backCard = false;


            }
        });
        ViewTreeObserver viewTreeObservers = setImg.getViewTreeObserver();
        if (viewTreeObservers.isAlive()) {
            viewTreeObservers.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    setImg.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    setImgheigh = setImg.getHeight();
                    setImgWidth = setImg.getWidth();

                }
            });
        }
        ViewTreeObserver viewTreeObservers2 = viewtwos.getViewTreeObserver();
        if (viewTreeObservers2.isAlive()) {
            viewTreeObservers2.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    viewtwos.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    viewtwosheight = viewtwos.getHeight();
                    viewtwosWidth = viewtwos.getWidth();

                }
            });
        }
//
    }

    TextureView.SurfaceTextureListener textureListener = new TextureView.SurfaceTextureListener() {
        @Override
        public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
            //open your camera here
            openCamera();
        }

        @Override
        public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
            // Transform you image captured size according to the surface width and height
        }

        @Override
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
            return false;
        }

        @Override
        public void onSurfaceTextureUpdated(SurfaceTexture surface) {
        }
    };
    private final CameraDevice.StateCallback stateCallback = new CameraDevice.StateCallback() {
        @Override
        public void onOpened(CameraDevice camera) {
            //This is called when the camera is open
            Log.e(TAG, "onOpened");
            cameraDevice = camera;
            createCameraPreview();
        }

        @Override
        public void onDisconnected(CameraDevice camera) {
            cameraDevice.close();
        }

        @Override
        public void onError(CameraDevice camera, int error) {
            cameraDevice.close();
            cameraDevice = null;
        }
    };
    final CameraCaptureSession.CaptureCallback captureCallbackListener = new CameraCaptureSession.CaptureCallback() {
        @Override
        public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
            super.onCaptureCompleted(session, request, result);
            createCameraPreview();
        }
    };

    protected void startBackgroundThread() {
        mBackgroundThread = new HandlerThread("Camera Background");
        mBackgroundThread.start();
        mBackgroundHandler = new Handler(mBackgroundThread.getLooper());
    }

    protected void stopBackgroundThread() {
        mBackgroundThread.quitSafely();
        try {
            mBackgroundThread.join();
            mBackgroundThread = null;
            mBackgroundHandler = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void takePicture() {
        if (null == cameraDevice) {
            Log.e(TAG, "cameraDevice is null");
            return;
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                final Handler handler = new Handler();
                Timer t = new Timer();
                t.schedule(new TimerTask() {
                    public void run() {
                        handler.post(new Runnable() {
                            public void run() {
                                Toast.makeText(Camera.this, "Capturing", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }, 1000);
            }
        });
        CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);


        try {
            CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
            maximumZoomLevel = characteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);

//            try {
//                manager.setTorchMode(cameraId,true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            Size[] jpegSizes = null;
            if (characteristics != null) {
                jpegSizes = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP).getOutputSizes(ImageFormat.JPEG);
            }
            int width = 640;
            int height = 480;
            if (jpegSizes != null && 0 < jpegSizes.length) {
                width = jpegSizes[0].getWidth();
                height = jpegSizes[0].getHeight();
            }
            ImageReader reader = ImageReader.newInstance(width, height, ImageFormat.JPEG, 1);
            List<Surface> outputSurfaces = new ArrayList<Surface>(2);
            outputSurfaces.add(reader.getSurface());
            outputSurfaces.add(new Surface(textureView.getSurfaceTexture()));
            final CaptureRequest.Builder captureBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_STILL_CAPTURE);
            always = SharedPreferenceClass.getValue("flashStatus", "");

            if (always != null && always.equals("off")) {
                captureBuilder.set(CaptureRequest.FLASH_MODE, FLASH_MODE_OFF);

            } else if (always != null && always.equals("on")) {
                captureBuilder.set(CaptureRequest.FLASH_MODE, FLASH_MODE_SINGLE);

            } else {
                captureBuilder.set(CaptureRequest.FLASH_MODE, FLASH_MODE_OFF);

            }
            final Handler handler = new Handler();
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                public void run() {
                    handler.post(new Runnable() {
                        public void run() {
                            AudioManager mgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                            mgr.setStreamMute(AudioManager.STREAM_SYSTEM, false);
                        }
                    });
                }
            }, 1000);
            captureBuilder.addTarget(reader.getSurface());
            captureBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
            captureBuilder.set(CaptureRequest.SCALER_CROP_REGION, zoom);

            // Orientation
            int rotation = getWindowManager().getDefaultDisplay().getRotation();
            captureBuilder.set(CaptureRequest.JPEG_ORIENTATION, ORIENTATIONS.get(rotation));
            final File file = new File(String.valueOf(System.currentTimeMillis()) + Environment.getExternalStorageDirectory() + "/pic.jpg");
            ImageReader.OnImageAvailableListener readerListener = new ImageReader.OnImageAvailableListener() {
                @Override
                public void onImageAvailable(ImageReader reader) {
                    Image image = null;

                    try {
                        image = reader.acquireLatestImage();
                        ByteBuffer buffer = image.getPlanes()[0].getBuffer();
                        byte[] bytes = new byte[buffer.capacity()];
                        buffer.get(bytes);


                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                        totalheight = textureheights - layoutheights;
//                        margin = totalheight / 2;
//                        int pic = layoutheights - 330;

                        if (idCard) {
                            int bitheight = setImgheigh - viewtwosheight;
                            int bitwigth = bitmap.getWidth();

                            Bitmap finalBitmap = bitmap;
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    setImg.setImageBitmap(finalBitmap);
                                    Drawable dr = ((ImageView) setImg).getDrawable();
                                    Bitmap bmp = ((BitmapDrawable) dr.getCurrent()).getBitmap();
                                    croppedImage = Bitmap.createBitmap(bmp, 100, bitheight, bitwigth - 200, bitheight * 2, null, false);

                                }
                            });
                            if (croppedImage != null) {
                                bitmap = croppedImage;
                            }
                        } else {
                        }
                        String c = saveImageToGallery(bitmap);

                        if (bitmap != null && !idCard) {
                            detectText(bitmap, c);
                        } else {
                            Bitmap finalBitmap1 = bitmap;
                            if (!frontCard) {
                                try {
                                    frontCard = true;
                                    detectText2(bitmap, c);

                                } catch (CameraAccessException e) {
                                    e.printStackTrace();
                                }

                            } else if (!backCard) {
                                backCard = true;
                                detectText2(bitmap, c);

                            }
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {


                                }
                            });
                        }

//                        save(bytes);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    } finally {
                        if (image != null) {
                            image.close();
                        }
                    }
                }

                public String saveImageToGallery(Bitmap bitmap) throws IOException {
                    String name = "IMG_" + System.currentTimeMillis();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        String mimeType = "image/jpeg";
                        String directory = Environment.DIRECTORY_PICTURES + "/Photo Translator";
                        Uri mediaContentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

                        ContentValues values = new ContentValues();

                        values.put(MediaStore.Images.Media.DISPLAY_NAME, name);
                        values.put(MediaStore.Images.Media.MIME_TYPE, mimeType);
                        values.put(MediaStore.Images.Media.RELATIVE_PATH, directory);

                        Uri uri = getContentResolver().insert(mediaContentUri, values);

                        if (uri != null) {
                            OutputStream imageOutStream = getContentResolver().openOutputStream(uri);
                            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, imageOutStream);
                            if (imageOutStream != null) {
                                imageOutStream.flush();
                                imageOutStream.close();
                            }
                            String filePath = getRealPathFromURI(uri);
                            if (filePath != null && !filePath.isEmpty()) {
                                if (!filePath.contains("file")) {
                                    path = "file://" + filePath;
                                } else {
                                    path = filePath;
                                }
                                MediaScannerConnection.scanFile(Camera.this, new String[]{filePath}, null,
                                        new MediaScannerConnection.OnScanCompletedListener() {
                                            public void onScanCompleted(String path, Uri uri) {
                                                Log.i("ExternalStorage", "Scanned " + path + ":");
                                                Log.i("ExternalStorage", "-> uri=" + uri);
                                            }
                                        });
                            }
                        }

                    } else {
                        OutputStream fos;

                        String imagesDir = Environment.getExternalStorageDirectory().toString() + File.separator + "Photo Translator";

                        File file = new File(imagesDir);

                        if (!file.exists()) {
                            file.mkdir();
                        }

                        File f = new File(imagesDir, name + ".jpg");
                        if (f.exists()) {
                            f.delete();
                        }

                        path = Uri.fromFile(f).toString();
                        fos = new FileOutputStream(f);
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                        fos.flush();
                        fos.close();

                        MediaScannerConnection.scanFile(Camera.this, new String[]{f.toString()}, null,
                                new MediaScannerConnection.OnScanCompletedListener() {
                                    public void onScanCompleted(String path, Uri uri) {
                                        Log.i("ExternalStorage", "Scanned " + path + ":");
                                        Log.i("ExternalStorage", "-> uri=" + uri);
                                    }
                                });
                    }

                    return path;
                }

                public String getRealPathFromURI(Uri contentURI) {
                    String result;
                    Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
                    if (cursor == null) { // Source is Dropbox or other similar local file path
                        result = contentURI.getPath();
                    } else {
                        cursor.moveToFirst();
                        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                        result = cursor.getString(idx);
                        cursor.close();
                    }
                    return result;
                }

                private void save(byte[] bytes) throws IOException {
                    OutputStream output = null;
                    try {
                        output = new FileOutputStream(file);
                        output.write(bytes);
                    } finally {
                        if (null != output) {
                            output.close();
                        }
                    }
                }
            };
            reader.setOnImageAvailableListener(readerListener, mBackgroundHandler);
            final CameraCaptureSession.CaptureCallback captureListener = new CameraCaptureSession.CaptureCallback() {
                @Override
                public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
                    super.onCaptureCompleted(session, request, result);
                    createCameraPreview();
                }
            };
            cameraDevice.createCaptureSession(outputSurfaces, new CameraCaptureSession.StateCallback() {
                @Override
                public void onConfigured(CameraCaptureSession session) {
                    try {
                        session.capture(captureBuilder.build(), captureListener, mBackgroundHandler);
                    } catch (CameraAccessException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onConfigureFailed(CameraCaptureSession session) {
                }
            }, mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    protected void createCameraPreview() {
        try {
            SurfaceTexture texture = textureView.getSurfaceTexture();
            assert texture != null;
            texture.setDefaultBufferSize(imageDimension.getWidth(), imageDimension.getHeight());
            Surface surface = new Surface(texture);
            captureRequestBuilder = cameraDevice.createCaptureRequest(CameraDevice.TEMPLATE_PREVIEW);
            captureRequestBuilder.addTarget(surface);
            cameraDevice.createCaptureSession(Arrays.asList(surface), new CameraCaptureSession.StateCallback() {
                @Override
                public void onConfigured(@NonNull CameraCaptureSession cameraCaptureSession) {
                    //The camera is already closed
                    if (null == cameraDevice) {
                        return;
                    }
                    // When the session is ready, we start displaying the preview.
                    cameraCaptureSessions = cameraCaptureSession;
                    updatePreview();
                }

                @Override
                public void onConfigureFailed(@NonNull CameraCaptureSession cameraCaptureSession) {
                    Toast.makeText(Camera.this, "Configuration change", Toast.LENGTH_SHORT).show();
                }
            }, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void openCamera() {
        manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        Log.e(TAG, "is camera open");
        try {
            cameraId = manager.getCameraIdList()[0];
            characteristics = manager.getCameraCharacteristics(cameraId);
            StreamConfigurationMap map = characteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            assert map != null;
            imageDimension = map.getOutputSizes(SurfaceTexture.class)[0];
            // Add permission for camera and let user grant the permission
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(Camera.this, new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CAMERA_PERMISSION);
                return;
            }
            manager.openCamera(cameraId, stateCallback, null);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        Log.e(TAG, "openCamera X");
    }

    protected void updatePreview() {
        if (null == cameraDevice) {
            Log.e(TAG, "updatePreview error, return");
        }
        captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        try {
            cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void closeCamera() {
        if (null != cameraDevice) {
            cameraDevice.close();
            cameraDevice = null;
        }
        if (null != imageReader) {
            imageReader.close();
            imageReader = null;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CAMERA_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                // close the app
                Toast.makeText(Camera.this, "Sorry!!!, you can't use this app without granting permission", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
        startBackgroundThread();
        if (textureView.isAvailable()) {
            openCamera();
        } else {
            textureView.setSurfaceTextureListener(textureListener);
        }
    }

    @Override
    protected void onPause() {
        Log.e(TAG, "onPause");
        //closeCamera();
        stopBackgroundThread();
        super.onPause();
    }


    //Determine the space between the first two fingers
    @SuppressWarnings("deprecation")
    private float getFingerSpacing(MotionEvent event) {

        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        return (float) Math.sqrt(x * x + y * y);
    }

    public void bright(int pvl) {
        try {
            double v = 0;
            if (pvl == 0) {
                v = -1.3;
            } else if (pvl == 1) {
                v = -1.2;
            } else if (pvl == 2) {
                v = -1;
            } else if (pvl == 3) {
                v = -0.9;
            } else if (pvl == 4) {
                v = -0.7;
            } else if (pvl == 5) {
                v = -0.5;
            } else if (pvl == 6) {
                v = 0;
            } else if (pvl == 7) {
                v = 0.5;
            } else if (pvl == 8) {
                v = 0.7;
            } else if (pvl == 9) {
                v = 0.9;
            } else if (pvl == 10) {
                v = 1.0;
            } else if (pvl == 11) {
                v = 1.2;
            } else if (pvl == 12) {
                v = 1.4;
            }

            CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
            double exposureCompensationSteps = characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP).doubleValue();
            int exposureCompensation = (int) (v / exposureCompensationSteps);
            captureRequestBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, exposureCompensation);
            try {

                cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);

            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    public void brightlow() {
        try {


            CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
            double exposureCompensationSteps = characteristics.get(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP).doubleValue();
            int exposureCompensation = (int) (-0.5 / exposureCompensationSteps);
            captureRequestBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, exposureCompensation);
            try {

                cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);

            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }


    private void setFocusArea(int focus_point_x, int focus_point_y) throws CameraAccessException {

        if (cameraId == null || mManualFocusEngaged) return;

        if (manager == null) {
            manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        }

        MeteringRectangle focusArea = null;

        if (manager != null) {
            if (characteristics == null) {
                characteristics = manager.getCameraCharacteristics(cameraId);
            }

            final Rect sensorArraySize = characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);

            int y = focus_point_x;
            int x = focus_point_y;

            if (sensorArraySize != null) {
                y = (int) (((float) focus_point_x / texturewidths) * (float) sensorArraySize.height());
                x = (int) (((float) focus_point_y / textureheights) * (float) sensorArraySize.width());
            }

            final int halfTouchLength = 150;
            focusArea = new MeteringRectangle(Math.max(x - halfTouchLength, 0),
                    Math.max(y - halfTouchLength, 0),
                    halfTouchLength * 2,
                    halfTouchLength * 2,
                    MeteringRectangle.METERING_WEIGHT_MAX - 1);
        }

//        CameraCaptureSession.CaptureCallback mCaptureCallback = new CameraCaptureSession.CaptureCallback() {
//
//            @Override
//            public void onCaptureCompleted(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull TotalCaptureResult result) {
//                super.onCaptureCompleted(session, request, result);
//
//                mManualFocusEngaged = false;
//
//                if (request.getTag().equals("TAG")) { // previously getTag == "Focus_tag"
//                    //the focus trigger is complete -
//                    //resume repeating (preview surface will get frames), clear AF trigger
//                    captureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_IDLE);
//                    captureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_CANCEL);
//                    captureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, null);// As documentation says AF_trigger can be null in some device
//                    try {
//                        cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);
//                    } catch (CameraAccessException e) {
//                        // error handling
//                    }
//                }
//            }
//
//            @Override
//            public void onCaptureFailed(@NonNull CameraCaptureSession session, @NonNull CaptureRequest request, @NonNull CaptureFailure failure) {
//                super.onCaptureFailed(session, request, failure);
//                mManualFocusEngaged = false;
//            }
//
//        };

        captureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_IDLE);
        captureRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, CameraMetadata.CONTROL_AF_TRIGGER_START);

        if (isMeteringAreaAESupported()) {
            captureRequestBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{focusArea});
        }
        if (isMeteringAreaAFSupported()) {
            captureRequestBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{focusArea});
            captureRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, CaptureRequest.CONTROL_AF_MODE_AUTO);
        }

        captureRequestBuilder.setTag("TAG"); //it will be checked inside mCaptureCallback
        if (null == cameraDevice) {
            Log.e(TAG, "updatePreview error, return");
        }
        captureRequestBuilder.set(CaptureRequest.CONTROL_MODE, CameraMetadata.CONTROL_MODE_AUTO);
        try {
            cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
        mManualFocusEngaged = true;
    }


    private boolean isMeteringAreaAFSupported() { // AF stands for AutoFocus

        Integer afRegion = characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        return afRegion != null && afRegion >= 1;

    }


    private boolean isMeteringAreaAESupported() {//AE stands for AutoExposure

        Integer aeState = characteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        return aeState != null && aeState >= 1;

    }

    private void detectText(Bitmap b, String path) throws CameraAccessException {
        int rotation = getRotationCompensation(cameraId, Camera.this, false);

        InputImage image = InputImage.fromBitmap(b, rotation);
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);


        //   Uri uri= getImageUri(LiveFeed.this,b);

        //  b=  rotateImageIfRequired(b,uri);
        Task<Text> result =
                recognizer.process(image).addOnSuccessListener(new OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(Text text) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rlprogress.setVisibility(View.GONE);

                            }
                        });
                        String scannedText = text.getText().trim();
                        if (scannedText != null && !scannedText.isEmpty()) {
                            DA.insertClient(scannedText, path);

                            Intent intent = new Intent(Camera.this, ScanResult.class);
                            intent.putExtra("txt", scannedText);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(Camera.this, "No Text Found", Toast.LENGTH_SHORT).show();

                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rlprogress.setVisibility(View.GONE);

                            }
                        });
                        Toast.makeText(Camera.this, "Please capture a clear picture of ID card", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(LiveFeed.this, "ID Card Not Found", Toast.LENGTH_LONG).show();

                    }
                });


    }

    String line = "";
    String line2 = "";

    private void detectText2(Bitmap b, String path) throws CameraAccessException {
        int rotation = getRotationCompensation(cameraId, Camera.this, false);

        InputImage image = InputImage.fromBitmap(b, rotation);
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);


        //   Uri uri= getImageUri(LiveFeed.this,b);

        //  b=  rotateImageIfRequired(b,uri);
        Task<Text> result =
                recognizer.process(image).addOnSuccessListener(new OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(Text text) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rlprogress.setVisibility(View.GONE);

                            }
                        });
                        String scannedText = text.getText().trim();

                        if (scannedText != null && !scannedText.isEmpty()) {
                            if (frontCard) {
                                line = scannedText;
                                txtTop.setText("ID Card Back");
                                z = 2;
                                sBar.setProgress(2);


                            } else if (backCard
                            ) {
                                line2 = scannedText;

                            }
                            if (backCard) {
                                DA.insertClient(line + "\n" + line2, path);

                                Intent intent = new Intent(Camera.this, ScanResult.class);
                                intent.putExtra("txt", line + "\n" + line2);
                                startActivity(intent);
                                finish();
                            }

                        } else {
                            Toast.makeText(Camera.this, "No Text Found", Toast.LENGTH_SHORT).show();

                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                rlprogress.setVisibility(View.GONE);

                            }
                        });
                        Toast.makeText(Camera.this, "Please capture a clear picture of ID card", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(LiveFeed.this, "ID Card Not Found", Toast.LENGTH_LONG).show();

                    }
                });


    }

    public Bitmap scaleDown(Bitmap realImage, float maxImageSize, boolean filter, String path) throws IOException {
        float ratio = Math.min(
                maxImageSize / realImage.getWidth(),
                maxImageSize / realImage.getHeight());
        if (ratio >= 1.0) {
            return realImage;
        }
        int width = Math.round(ratio * realImage.getWidth());
        int height = Math.round(ratio * realImage.getHeight());

        Bitmap bitmap = Bitmap.createScaledBitmap(realImage, width, height, filter);

        return rotateImageIfRequired(bitmap, path, width, height);
    }

    private Bitmap rotateImageIfRequired(Bitmap img, String path, int width, int height) throws IOException {
        if (path != null && !path.isEmpty()) {
            ExifInterface ei = new ExifInterface(path);
            int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    return rotateImage(img, width, height, 90);
                case ExifInterface.ORIENTATION_ROTATE_180:
                    return rotateImage(img, width, height, 180);
                case ExifInterface.ORIENTATION_ROTATE_270:
                    return rotateImage(img, width, height, 270);
                default:
                    return img;
            }
        } else {
            return img;
        }

    }

    private Bitmap rotateImage(Bitmap img, int width, int height, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, width, height, matrix, true);
        img.recycle();
        return rotatedImg;
    }

    public static Bitmap rotateImages(byte[] data, Context context) {
        if (data != null) {
            int screenWidth = context.getResources().getDisplayMetrics().widthPixels;
            int screenHeight = context.getResources().getDisplayMetrics().heightPixels;
            Bitmap bm = BitmapFactory.decodeByteArray(data, 0,
                    (data != null) ? data.length : 0);

            if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                // Notice that width and height are reversed
                Bitmap scaled = Bitmap.createScaledBitmap(bm, screenHeight,
                        screenWidth, true);
                int w = scaled.getWidth();
                int h = scaled.getHeight();
                // Setting post rotate to 90
                Matrix mtx = new Matrix();
                mtx.postRotate(270);
                // Rotating Bitmap
                bm = Bitmap.createBitmap(scaled, 0, 0, w, h, mtx, true);
            } else {// LANDSCAPE MODE
                //No need to reverse width and height
                Bitmap scaled = Bitmap.createScaledBitmap(bm, screenWidth,
                        screenHeight, true);
                bm = scaled;
            }
            return bm;
        }
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private int getRotationCompensation(String cameraId, Activity activity, boolean isFrontFacing)
            throws CameraAccessException {
        // Get the device's current rotation relative to its "native" orientation.
        // Then, from the ORIENTATIONS table, look up the angle the image must be
        // rotated to compensate for the device's rotation.
        int deviceRotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int rotationCompensation = ORIENTATIONS.get(deviceRotation);

        // Get the device's sensor orientation.
        CameraManager cameraManager = (CameraManager) activity.getSystemService(CAMERA_SERVICE);
        int sensorOrientation = cameraManager
                .getCameraCharacteristics(cameraId)
                .get(CameraCharacteristics.SENSOR_ORIENTATION);

        if (isFrontFacing) {
            rotationCompensation = (sensorOrientation + rotationCompensation) % 360;
        } else { // back-facing
            rotationCompensation = (sensorOrientation - rotationCompensation + 360) % 360;
        }
        return rotationCompensation;
    }

    private void Zoom(int zooms) {
        zoom_level = 1;
        try {
            CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
            characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
            float maxzoom = (characteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)) * 60;

            Rect m = characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            float current_finger_spacing;
            if (zooms == 0) {
                zoom_level = 0;


            } else if (zooms == 1) {
                zoom_level = zoom_level + 5;
            } else if (zooms == 2) {
                zoom_level = zoom_level + 10;

            } else if (zooms == 3) {
                zoom_level = zoom_level + 15;

            } else if (zooms == 4) {
                zoom_level = zoom_level + 20;

            } else if (zooms == 5) {
                zoom_level = zoom_level + 25;

            } else if (zooms == 6) {
                zoom_level = zoom_level + 35;

            }


            int minW = (int) (m.width() / maxzoom);
            int minH = (int) (m.height() / maxzoom);
            int difW = m.width() - minW;
            int difH = m.height() - minH;
            int cropW = difW / 100 * (int) zoom_level;
            int cropH = difH / 100 * (int) zoom_level;
            cropW -= cropW & 3;
            cropH -= cropH & 3;
            Rect zoom = new Rect(cropW, cropH, m.width() - cropW, m.height() - cropH);
            captureRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, zoom);
//                    if (event.getPointerCount() > 1) {
//                        // Multi touch logic
//                        current_finger_spacing = getFingerSpacing(event);
//
//                        if(finger_spacing != 0){
////                            if(current_finger_spacing > finger_spacing && maxzoom > zoom_level){
////                                zoom_level++;
////
////                            }
////                            else if (current_finger_spacing < finger_spacing && zoom_level > 1){
////                                zoom_level--;
////
////                            }
//
//                        }
//                        finger_spacing = current_finger_spacing;
//                    }
//                    else{
////                        if (action == MotionEvent.ACTION_UP) {
////                            //single touch logic
////                        }
//                    }

            try {

                cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);

            } catch (CameraAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException ex) {
                ex.printStackTrace();
            }
        } catch (CameraAccessException e) {
            throw new RuntimeException("can not access camera.", e);
        }
    }

    Paint paint;
    boolean grid;

    protected void onDraw(Canvas canvas) {
        if (grid) {
            //  Find Screen size first
            DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
            int screenWidth = metrics.widthPixels;
            int screenHeight = (int) (metrics.heightPixels * 0.9);

            //  Set paint options
            paint.setAntiAlias(true);
            paint.setStrokeWidth(3);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.argb(255, 255, 255, 255));

            canvas.drawLine((screenWidth / 3) * 2, 0, (screenWidth / 3) * 2, screenHeight, paint);
            canvas.drawLine((screenWidth / 3), 0, (screenWidth / 3), screenHeight, paint);
            canvas.drawLine(0, (screenHeight / 3) * 2, screenWidth, (screenHeight / 3) * 2, paint);
            canvas.drawLine(0, (screenHeight / 3), screenWidth, (screenHeight / 3), paint);
        }
    }
}


