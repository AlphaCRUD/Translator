package com.alphacrud.phototranslator;

import static android.Manifest.permission.ACCESS_MEDIA_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.os.Build.VERSION.SDK_INT;
import static com.alphacrud.phototranslator.MyApplication.DA;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
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
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.extensions.HdrImageCaptureExtender;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;

import com.alphacrud.phototranslator.Utilis.SharedPreferenceClass;
import com.alphacrud.phototranslator.ads.AdsManager;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class CameraX extends AppCompatActivity implements ImageAnalysis.Analyzer {

    public static final String OUTPUT_FILES_RESULT = "outputFilesResult";
    private Executor executor = Executors.newSingleThreadExecutor();
    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA"};
    //    PreviewView mPreviewView;
//    ImageView captureImage;
    private static final int REQUEST_CODE_QR_SCAN = 101;
    Uri uri;
    TextRecognizer textRecognizer;
    StringBuilder stringBuilder;
    String imageText = " ";
    Camera camera;
    ImageView btn_takepicture;
    boolean isRotation = false;
    private PreviewView previewView;

    int condition = 0;
    Boolean condition_on_off = false;
    ImageButton btnflas;
    private static final String TAG = "AndroidCameraApi";
    private Button btn_Zoom, btn_brightnes;
    ImageView takePictureButton;
    private TextureView textureView;
    private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
    int layoutheights, layoutwidths;
    int textureheights, texturewidths;
    int totalheight, margin;
    TemplateView template;
    private AdLoader adLoader ;
    private boolean adLoaded=false;

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
    public double zoom_level = 1;
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
    String always = "";

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
        setContentView(R.layout.activity_camera_x);

        previewView = findViewById(R.id.previewView);
        btnflas = findViewById(R.id.btnflas);
        btn_takepicture = findViewById(R.id.btn_takepicture);

        AdsManager.loadNativeAd(this, findViewById(R.id.nativeAd),R.layout.ad_unified_small);
        SharedPreferenceClass.getInstance(getApplicationContext());

        textureView = (TextureView) findViewById(R.id.texture);

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
        btnflas = (ImageButton) findViewById(R.id.btnflash);
        takePictureButton = (ImageView) findViewById(R.id.btn_takepicture);
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
        btnflas.setEnabled(true);
        btnflas.setClickable(true);

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
//        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            int pval = 0;
//
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                pval = progress;
//                bright(pval);
//
//
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                //write custom code to on start progress
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//            }
//        });
        progressed.setVisibility(View.VISIBLE);


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

        // intialize stringbuilder
        stringBuilder = new StringBuilder();

        if (allPermissionsGranted()) {
            startCamera(); //start camera if permission has been granted by user
        } else {
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS);
        }
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
//        adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110").forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
//
//            private ColorDrawable background;
//            @Override
//            public void onNativeAdLoaded(@NonNull  NativeAd unifiedNativeAd) {
//
//                NativeTemplateStyle styles = new
//                        NativeTemplateStyle.Builder().build();
//
//                template = findViewById(R.id.nativeTemplateView);
//                template.setStyles(styles);
//                template.setNativeAd(unifiedNativeAd);
//                adLoaded = true;
//
////
//
//                // Showing a simple Toast message to user when Native an ad is Loaded and ready to show
//
//            }
//
//        }).build();
////        adLoader.loadAd(new AdRequest.Builder().build());
//                new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                loadNativeAd();
//
//            }
//        },2000);
    }
    private void loadNativeAd()
    {
        // Creating  an Ad Request
        AdRequest adRequest = new AdRequest.Builder().build() ;
        adLoader.loadAd(adRequest) ;

        // load Native Ad with the Request
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showNativeAd();

            }
        },3000);
        // Showing a simple Toast message to user when Native an ad is Loading

    }
    private void showNativeAd()
    {

        if ( adLoaded )
        {
            template.setVisibility( View.VISIBLE) ;

            // Showing a simple Toast message to user when an Native ad is shown to the user
        }
        else
        {
            //Load the Native ad if it is not loaded
            loadNativeAd() ;

            // Showing a simple Toast message to user when Native ad is not loaded
        }
    }
    private boolean checkPermission() {
        if (SDK_INT >= Build.VERSION_CODES.Q) {
            int result = ContextCompat.checkSelfPermission(CameraX.this, CAMERA);
            int result1 = ContextCompat.checkSelfPermission(CameraX.this, ACCESS_MEDIA_LOCATION);
            int result2 = ContextCompat.checkSelfPermission(CameraX.this, WRITE_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED
                    && result2 == PackageManager.PERMISSION_GRANTED;

        } else {
            int result = ContextCompat.checkSelfPermission(CameraX.this, CAMERA);
            int result1 = ContextCompat.checkSelfPermission(CameraX.this, WRITE_EXTERNAL_STORAGE);
            return result == PackageManager.PERMISSION_GRANTED && result1 == PackageManager.PERMISSION_GRANTED;

        }
    }

    private void requestPermission() {
        if (SDK_INT >= Build.VERSION_CODES.Q) {
            //below android 11
            ActivityCompat.requestPermissions(CameraX.this, new String[]{CAMERA, ACCESS_MEDIA_LOCATION,
                    WRITE_EXTERNAL_STORAGE}, 1);
            // ActivityCompat.requestPermissions(MainActivity.this, new String[]{CAMERA}, 2296);
        } else {
            ActivityCompat.requestPermissions(CameraX.this, new String[]{CAMERA, WRITE_EXTERNAL_STORAGE}, 2);

        }

    }

    private void startCamera() {

        final ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);

        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {

                    ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                    bindPreview(cameraProvider);

                } catch (ExecutionException | InterruptedException e) {
                    // No errors need to be handled for this Future.
                    // This should never be reached.
                }
            }
        }, ContextCompat.getMainExecutor(this));
    }

    ImageCapture.Builder builder;

    void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {

        Preview preview = new Preview.Builder()
                .build();

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();

        ImageAnalysis imageAnalysis = new ImageAnalysis.Builder()
                .build();

        builder = new ImageCapture.Builder();

        //Vendor-Extensions (The CameraX extensions dependency in build.gradle)
        HdrImageCaptureExtender hdrImageCaptureExtender = HdrImageCaptureExtender.create(builder);

        // Query if extension is available (optional).
        if (hdrImageCaptureExtender.isExtensionAvailable(cameraSelector)) {
            // Enable the extension if available.
            hdrImageCaptureExtender.enableExtension(cameraSelector);
        }

        final ImageCapture imageCapture = builder
                .setTargetRotation(this.getWindowManager().getDefaultDisplay().getRotation())
                .build();

        preview.setSurfaceProvider(previewView.createSurfaceProvider());

        camera = cameraProvider.bindToLifecycle((LifecycleOwner) this, cameraSelector, preview, imageAnalysis, imageCapture);

        btn_takepicture.setOnClickListener(v -> {

            btn_takepicture.setClickable(false);
            btn_takepicture.setEnabled(false);
            // Toast.makeText(CameraXActivity.this, "okokoko", Toast.LENGTH_SHORT).show();
            final CameraInfo cameraInfo = camera.getCameraInfo();
            final CameraControl cameraControl = camera.getCameraControl();
            always = SharedPreferenceClass.getValue("flashStatus", "");

            if (always != null && always.equals("off")) {
                cameraControl.enableTorch(false); // You can listen to this future to handle errors

            } else if (always != null && always.equals("on")) {
                if (cameraInfo.hasFlashUnit()) {

                    cameraControl.enableTorch(true); // You can listen to this future to handle errors
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            cameraControl.enableTorch(false); // You can listen to this future to handle errors

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, 400);
            } else {
                cameraControl.enableTorch(false); // You can listen to this future to handle errors

            }


            SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
            String dirPath = getBatchDirectoryName();
            if (dirPath != null) {
                File file = new File(dirPath, mDateFormat.format(new Date()) + ".jpg");

                ImageCapture.OutputFileOptions option = new ImageCapture.OutputFileOptions.Builder(file).build();

                ImageCapture.OutputFileOptions outputFileOptions = new ImageCapture.OutputFileOptions.Builder(file).build();
                imageCapture.takePicture(outputFileOptions, executor, new ImageCapture.OnImageSavedCallback() {
                    @Override
                    public void onImageSaved(@NonNull ImageCapture.OutputFileResults outputFileResults) {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(CameraX.this, "Capturing", Toast.LENGTH_SHORT).show();

                                btn_takepicture.setClickable(true);
                                btn_takepicture.setEnabled(true);
//                                Log.d("OUTPUT_FILES_RESULT0", Uri.fromFile(new File(outputFileResults.toString())) + "");
//                                Log.d("outputFilesOption", outputFileOptions.toString());
//                                Log.d("Filepathh", file.getAbsolutePath());

                                uri = Uri.fromFile(file);
                                InputStream iStream = null;
                                try {
                                    iStream = getContentResolver().openInputStream(uri);
                                    byte[] inputData = getBytes(iStream);
                                    Bitmap bitmap = BitmapFactory.decodeByteArray(inputData, 0, inputData.length);
                                    Image image = null;




                                } catch (FileNotFoundException e) {
                                    e.printStackTrace();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                Bitmap bitmap = null;
                                try {
                                     bitmap = MediaStore.Images.Media.getBitmap(CameraX.this.getContentResolver(), uri);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                try {



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
                                                croppedImage=bmp;
//                                                croppedImage = Bitmap.createBitmap(bmp, 100, bitheight, bitwigth - 200, bitheight * 2, null, false);

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
                                }


//                        Log.d("FileeeUriii", uri.toString());
//                        Intent intent = new Intent(CameraXActivity.this, Preview_Image_ScreenActivity.class);
//                        intent.putExtra("image", uri.toString());
//                        intent.putExtra("isRotated",isRotation);
//                        startActivity(intent);
//                        finish();
//
                            }
                        });
                    }

                    @Override
                    public void onError(@NonNull ImageCaptureException error) {
                        error.printStackTrace();
                    }
                });

            } else {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
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
                    MediaScannerConnection.scanFile(CameraX.this, new String[]{filePath}, null,
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

            MediaScannerConnection.scanFile(CameraX.this, new String[]{f.toString()}, null,
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1020 && resultCode == RESULT_OK && data != null) {
            try {
                final Uri uriImage = data.getData();
                final InputStream inputStream = getContentResolver().openInputStream(uriImage);
                final Bitmap imageMap = BitmapFactory.decodeStream(inputStream);

//                Intent intent = new Intent(CameraXActivity.this, Preview_Image_ScreenActivity.class);
//                intent.putExtra("image", getRealPath(uriImage.toString()));
//                Log.d("image", "onActivityResult: "+uriImage);
//                startActivity(intent);
//                finish();


            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Toast.makeText(CameraX.this, "Image was not found", Toast.LENGTH_SHORT).show();
            }
        }
        if (requestCode == REQUEST_CODE_QR_SCAN) {
            if (data == null)
                return;
//            //Getting the passed result
//            String result = data.getStringExtra("com.blikoon.qrcodescanner.got_qr_scan_relult");
//            Intent intent = new Intent(CameraXActivity.this, QrScannerActivity.class);
//            intent.putExtra("name", result);
//
//            startActivity(intent);
//            finish();

        }

    }

    @SuppressWarnings("deprecation")
//    public  String getRealPath(String uriString) {
//        String realPath = null;
//
//
//        final boolean isKitKat = true;
//
//        // DocumentProvider
//
//            Cursor cursor = CameraXActivity.this. getContentResolver().query(Uri.parse(uriString), null, null, null, null);
//            cursor.moveToFirst();
//            String document_id = cursor.getString(0);
//            document_id = document_id.substring(document_id.lastIndexOf(":")+1);
//            cursor.close();
//
//            cursor = getContentResolver().query(
//                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
//                    null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
//            cursor.moveToFirst();
//            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
//            realPath = path;
//            cursor.close();
//
//        return realPath;
//    }
    public String getBatchDirectoryName() {
        String app_path;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            app_path = getExternalFilesDir("Scanner").getAbsolutePath();
        } else {
            app_path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + ".Scanner";

        }
        String filePath = app_path + "/temp/";
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdir();
            dir.mkdirs();
        }

        if (dir.exists()) {
            return dir.getAbsolutePath();
        } else {
            return null;
        }
    }

    private boolean allPermissionsGranted() {

        for (String permission : REQUIRED_PERMISSIONS) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 1) {
            if (grantResults.length > 0) {
                boolean camera = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean storage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (camera && storage) {
                    Toast.makeText(CameraX.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CameraX.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                }
            }

        }
        if (requestCode == 2) {
            if (grantResults.length > 0) {
                boolean camera = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean storage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                if (camera && storage) {
                    Toast.makeText(CameraX.this, "Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CameraX.this, "Permission not granted", Toast.LENGTH_SHORT).show();
                }
            }

        }
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera();
            } else {
                Toast.makeText(this, "Permissions not granted by the user.", Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }
    }

    @Override
    public void analyze(@NonNull ImageProxy imageProxy) {
        @SuppressLint("UnsafeOptInUsageError")
        Image mediaImage = imageProxy.getImage();
        if (mediaImage != null) {
            InputImage image =
                    InputImage.fromMediaImage(mediaImage, imageProxy.getImageInfo().getRotationDegrees());
            // Pass image to an ML Kit Vision API
            // ...
        }

    }



    public byte[] getBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteBuffer = new ByteArrayOutputStream();
        int bufferSize = 1024;
        byte[] buffer = new byte[bufferSize];

        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            byteBuffer.write(buffer, 0, len);
        }
        return byteBuffer.toByteArray();
    }
    private void Zoom(int zooms) {
        zoom_level = 1;
        if (zooms == 0) {
            zoom_level = zoom_level;

        } else if (zooms == 1) {
            zoom_level =zoom_level+ 0.5;
        } else if (zooms == 2) {
            zoom_level = zoom_level + 1;

        } else if (zooms == 3) {
            zoom_level = zoom_level + 2;

        } else if (zooms == 4) {
            zoom_level = zoom_level + 3;

        } else if (zooms == 5) {
            zoom_level = zoom_level + 4;

        } else if (zooms == 6) {
            zoom_level = zoom_level + 5;

        }else if (zooms == 7) {
            zoom_level = zoom_level + 6;

        }
        final CameraInfo cameraInfo = camera.getCameraInfo();
        final CameraControl cameraControl = camera.getCameraControl();
               cameraControl.setZoomRatio((float)zoom_level);
//        try {
//            CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
//            characteristics = manager.getCameraCharacteristics(cameraDevice.getId());
//            float maxzoom = (characteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)) * 60;
//
//            Rect m = characteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
//            float current_finger_spacing;
//            if (zooms == 0) {
//                zoom_level = 0;
//
//
//            } else if (zooms == 1) {
//                zoom_level = zoom_level + 5;
//            } else if (zooms == 2) {
//                zoom_level = zoom_level + 10;
//
//            } else if (zooms == 3) {
//                zoom_level = zoom_level + 15;
//
//            } else if (zooms == 4) {
//                zoom_level = zoom_level + 20;
//
//            } else if (zooms == 5) {
//                zoom_level = zoom_level + 25;
//
//            } else if (zooms == 6) {
//                zoom_level = zoom_level + 35;
//
//            }
//
//
//            int minW = (int) (m.width() / maxzoom);
//            int minH = (int) (m.height() / maxzoom);
//            int difW = m.width() - minW;
//            int difH = m.height() - minH;
//            int cropW = difW / 100 * (int) zoom_level;
//            int cropH = difH / 100 * (int) zoom_level;
//            cropW -= cropW & 3;
//            cropH -= cropH & 3;
//            Rect zoom = new Rect(cropW, cropH, m.width() - cropW, m.height() - cropH);
//            captureRequestBuilder.set(CaptureRequest.SCALER_CROP_REGION, zoom);
////                    if (event.getPointerCount() > 1) {
////                        // Multi touch logic
////                        current_finger_spacing = getFingerSpacing(event);
////
////                        if(finger_spacing != 0){
//////                            if(current_finger_spacing > finger_spacing && maxzoom > zoom_level){
//////                                zoom_level++;
//////
//////                            }
//////                            else if (current_finger_spacing < finger_spacing && zoom_level > 1){
//////                                zoom_level--;
//////
//////                            }
////
////                        }
////                        finger_spacing = current_finger_spacing;
////                    }
////                    else{
//////                        if (action == MotionEvent.ACTION_UP) {
//////                            //single touch logic
//////                        }
////                    }
//
////            try {
////
////                cameraCaptureSessions.setRepeatingRequest(captureRequestBuilder.build(), null, mBackgroundHandler);
////
////            } catch (CameraAccessException e) {
////                e.printStackTrace();
////            }
//
//            catch (NullPointerException ex) {
//                ex.printStackTrace();
//            }
//        } catch (CameraAccessException e) {
//            throw new RuntimeException("can not access camera.", e);
//        }
    }
    private void detectText(Bitmap b, String path) throws CameraAccessException {

        InputImage image = InputImage.fromBitmap(b, 0);
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

                            Intent intent = new Intent(CameraX.this, ScanResult.class);
                            intent.putExtra("txt", scannedText);
                            startActivity(intent);
                            finish();

                        } else {
                            Toast.makeText(CameraX.this, "No Text Found", Toast.LENGTH_SHORT).show();

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
                        Toast.makeText(CameraX.this, "Please capture a clear picture of ID card", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(LiveFeed.this, "ID Card Not Found", Toast.LENGTH_LONG).show();

                    }
                });


    }

    String line = "";
    String line2 = "";

    private void detectText2(Bitmap b, String path) throws CameraAccessException {

        InputImage image = InputImage.fromBitmap(b, 0);
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
                                DA.insertClient(line , path);
                                Intent intent = new Intent(CameraX.this, ScanResult.class);
                                intent.putExtra("txt", line);
                                startActivity(intent);
                                finish();
//                                txtTop.setText("ID Card Back");
                                z = 0;
//                                sBar.setProgress(0);


                            } else if (backCard
                            ) {
                                line2 = scannedText;

                            }
                            if (backCard) {
                                DA.insertClient(line + "\n" + line2, path);

                                Intent intent = new Intent(CameraX.this, ScanResult.class);
                                intent.putExtra("txt", line + "\n" + line2);
                                startActivity(intent);
                                finish();
                            }

                        } else {
                            Toast.makeText(CameraX.this, "No Text Found", Toast.LENGTH_SHORT).show();

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
                        Toast.makeText(CameraX.this, "Please capture a clear picture of ID card", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(LiveFeed.this, "ID Card Not Found", Toast.LENGTH_LONG).show();

                    }
                });


    }
}
