package com.alphacrud.phototranslator;

import static com.alphacrud.phototranslator.MyApplication.DA;
import static com.alphacrud.phototranslator.MyApplication.one;
import static com.alphacrud.phototranslator.MyApplication.three;
import static com.alphacrud.phototranslator.MyApplication.two;

import android.Manifest;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alphacrud.phototranslator.Adapter.HomeClassAdapter;
import com.alphacrud.phototranslator.Model.HomeImageModel;
import com.alphacrud.phototranslator.ads.AdsCallBack;
import com.alphacrud.phototranslator.ads.AdsManager;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class Home extends AppCompatActivity implements View.OnClickListener {

    private static final int PERMISSION_ALL = 1;
    private static final int PERMISSION_REQUEST_CODE = 200;
    private static final String TAG = "int";
    private final int UPDATE_REQUEST_CODE = 123;

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    private final String[] PERMISSIONS33 = {
            Manifest.permission.READ_MEDIA_IMAGES,
            Manifest.permission.READ_MEDIA_VIDEO,
            android.Manifest.permission.CAMERA,
    };

    private final String[] PERMISSION = {
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    private final String[] PERMISSIONS =
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU ? PERMISSIONS33 : PERMISSION;

    ArrayList<HomeImageModel> list;
    Bitmap bitmap;
    TemplateView template;
    boolean t = false;
    HomeClassAdapter homeClassAdapter;
    LinearLayout linearAdd;
    AdView mAdView;
    ProgressBar progressed;
    FloatingActionButton fab;
    //    public static com.google.android.gms.ads.interstitial.InterstitialAd mInterstitialAd;
    ImageButton btm;
    private AppUpdateManager appUpdateManager;
    private RecyclerView recyclerView;
    private ImageView allow;
    private ProgressBar progress;
    private LinearLayout linearGalery;
    private AdLoader adLoader;
    private boolean adLoaded = false;
    private LinearLayout linearPreviousScan;
    private Button mNextLevelButton;
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {

                        case R.id.action_favorites:

                            showInterstitial();

                            one = true;
                            two = false;
                            break;

                        case R.id.action_schedules1:
                            one = false;
                            two = true;
                            showInterstitial();

                            break;
                    }
                    return true;
                }
            };

    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, ExitActivity.class));
        finish();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        oninit();

        AdsManager.loadNativeAd(this, findViewById(R.id.nativeAd), R.layout.ad_unified_small);

        findViewById(R.id.tvOpenTT).setOnClickListener(view -> {
            AdsManager.showInterstitialWithInterval(this, () -> startActivity(new Intent(Home.this, TextTranslator.class)));

        });


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btm = findViewById(R.id.btm);

        progressed = findViewById(R.id.progressed);
        linearPreviousScan = findViewById(R.id.linearPreviousScan);
        fab = findViewById(R.id.fab);
        progressed.setVisibility(View.VISIBLE);
        CustomBottomNavigationView1 customBottomNavigationView1 = findViewById(R.id.customBottomBar);
        customBottomNavigationView1.inflateMenu(R.menu.menu);

        customBottomNavigationView1.setOnNavigationItemSelectedListener(navListener);

        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Home.this.openOptionsMenu();
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                three = true;
                showInterstitial();
            }
        });

        linearPreviousScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                Intent in = new Intent(Home.this, PreviousData.class);
                startActivity(in);
            }
        });

    }

    @Override
    public void onClick(View view) {

    }

    private void loadNativeAd() {
        // Creating  an Ad Request
        AdRequest adRequest = new AdRequest.Builder().build();
        adLoader.loadAd(adRequest);

        // load Native Ad with the Request
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showNativeAd();

            }
        }, 3000);
        // Showing a simple Toast message to user when Native an ad is Loading

    }

    private void showNativeAd() {

        if (adLoaded) {
            template.setVisibility(View.VISIBLE);
        } else {
            loadNativeAd();
        }
    }

    private void oninit() {
        recyclerView = findViewById(R.id.recyclerView);
        allow = findViewById(R.id.allow);
        progress = findViewById(R.id.progress);
        linearGalery = findViewById(R.id.linearGalery);
        linearAdd = findViewById(R.id.linearAdd);
        list = new ArrayList();
        Configuration configuration = Home.this.getResources().getConfiguration();
        int screenWidthDp = configuration.screenWidthDp; //The current width of the available screen space, in dp units, corresponding to screen width resource qualifier.
        int screenHeightDp = configuration.screenHeightDp; //T// he current width of the available screen space, in dp units, corresponding to screen width resource qualifier.
        if (screenHeightDp < 780) {
            t = false;
        } else {
            t = true;
        }

        if (!hasPermissions(Home.this, PERMISSIONS)) {
            progress.setVisibility(View.VISIBLE);
            allow.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);

            ActivityCompat.requestPermissions(Home.this, PERMISSIONS, PERMISSION_ALL);
        } else {
            allow.setVisibility(View.GONE);
            progress.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            list = getAllShownImagesPath();
            homeClassAdapter = new HomeClassAdapter(this, list, t);
            recyclerView.setAdapter(homeClassAdapter);
        }

        linearGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!hasPermissions(Home.this, PERMISSIONS)) {
                    ActivityCompat.requestPermissions(Home.this, PERMISSIONS, PERMISSION_ALL);
                } else {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto, 1);
                }
            }
        });
        linearAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearAdd.setEnabled(false);
                Intent in = new Intent(Home.this, Adds.class);
                startActivity(in);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        linearAdd.setEnabled(true);
//        appUpdateManager.getAppUpdateInfo().addOnSuccessListener(appUpdateInfo -> {
//
//            if(appUpdateInfo.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS)
//            {
//                try {
//                    appUpdateManager.startUpdateFlowForResult(appUpdateInfo,AppUpdateType.IMMEDIATE,this,UPDATE_REQUEST_CODE);
//                } catch (IntentSender.SendIntentException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }

    private ArrayList<HomeImageModel> getAllShownImagesPath() {
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        ArrayList<HomeImageModel> listOfAllImages = new ArrayList<HomeImageModel>();
        String absolutePathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = {MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

        cursor = getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);
            listOfAllImages.add(new HomeImageModel(absolutePathOfImage));


        }


        Collections.reverse(listOfAllImages);

        return listOfAllImages;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ALL) {
            if (!hasPermissions(this, PERMISSIONS)) {
                allow.setVisibility(View.VISIBLE);
                progress.setVisibility(View.GONE);
                recyclerView.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "You need to allow all permissions", Toast.LENGTH_LONG).show();
            } else {
                recyclerView.setVisibility(View.VISIBLE);
                allow.setVisibility(View.GONE);
                progress.setVisibility(View.GONE);
                list = getAllShownImagesPath();
                HomeClassAdapter homeClassAdapter = new HomeClassAdapter(this, list, t);
                recyclerView.setAdapter(homeClassAdapter);
            }
        }

    }

    public void openActivity() {
        Intent in = new Intent(Home.this, CameraX.class);
        startActivity(in);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        Uri selectedImage;
        switch (requestCode) {

            case 1:
                if (resultCode == RESULT_OK) {


                    selectedImage = intent.getData();
                    Bitmap real_bitmap = null;
                    try {
                        if (selectedImage != null) {
                            real_bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (real_bitmap != null) {
                        try {
                            bitmap = scaleDown(real_bitmap, 1024, Uri.parse(getRealPathFromURI(selectedImage)), true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (bitmap != null) {
                            detectText(bitmap, Uri.parse(getRealPathFromURI(selectedImage)).toString());
                        }
                    }
                }
                break;
        }
        if (requestCode == UPDATE_REQUEST_CODE && resultCode == Activity.RESULT_CANCELED) {
            finish();
        }

    }

    public Bitmap scaleDown(Bitmap realImage, float maxImageSize, Uri selectedImage, boolean filter) throws IOException {
        float ratio = Math.min(
                maxImageSize / realImage.getWidth(),
                maxImageSize / realImage.getHeight());
        if (ratio >= 1.0) {
            return realImage;
        }
        int width = Math.round(ratio * realImage.getWidth());
        int height = Math.round(ratio * realImage.getHeight());

        Bitmap bitmap = Bitmap.createScaledBitmap(realImage, width, height, filter);

        return rotateImageIfRequired(bitmap, selectedImage, width, height);
    }

    private Bitmap rotateImageIfRequired(Bitmap img, Uri selectedImage, int width, int height) throws IOException {
        if (selectedImage != null) {
            String path = selectedImage.getPath();
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
        } else {
            return img;
        }
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

    private Bitmap rotateImage(Bitmap img, int width, int height, int degree) {
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap rotatedImg = Bitmap.createBitmap(img, 0, 0, width, height, matrix, true);
        img.recycle();
        return rotatedImg;
    }

    public void PassBitmap(String ur) {
        Uri selectedImage;
        if (ur != null && !ur.isEmpty()) {
            File f = new File(ur);
            selectedImage = Uri.fromFile(f);
            Bitmap real_bitmap = null;
            try {
                real_bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (real_bitmap != null) {
                try {
                    bitmap = scaleDown(real_bitmap, 1024, selectedImage, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (bitmap != null) {
                    detectText(bitmap, ur);
                }
            }
        } else {
            Toast.makeText(Home.this, "Error!\nSelect image from gallery.", Toast.LENGTH_SHORT).show();
        }
    }

    private void detectText(Bitmap b, String url) {

        InputImage image = InputImage.fromBitmap(b, 0);
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);


        //   Uri uri= getImageUri(LiveFeed.this,b);

        //  b=  rotateImageIfRequired(b,uri);
        Task<Text> result =
                recognizer.process(image).addOnSuccessListener(new OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(Text text) {

                        progress.setVisibility(View.GONE);
                        String scannedText = text.getText().trim();
                        if (!scannedText.isEmpty()) {
                            DA.insertClient(scannedText, url);
                            AdsManager.showInterstitialWithInterval(Home.this, new AdsCallBack() {
                                @Override
                                public void onClosed() {
                                    Intent intent = new Intent(Home.this, ScanResult.class);
                                    intent.putExtra("txt", scannedText);
                                    startActivity(intent);

                                }
                            });
                        } else {
                            Toast.makeText(Home.this, "No Text found!", Toast.LENGTH_SHORT).show();

                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        e.printStackTrace();

                        Toast.makeText(Home.this, "No Text found!d", Toast.LENGTH_SHORT).show();

//                        Toast.makeText(LiveFeed.this, "ID Card Not Found", Toast.LENGTH_LONG).show();

                    }
                });


    }

//    private void loadAd() {
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//        com.google.android.gms.ads.interstitial.InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest, new InterstitialAdLoadCallback() {
//            @Override
//            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                // The mInterstitialAd reference will be null until
//                // an ad is loaded.
//                mInterstitialAd = interstitialAd;
//                Log.i(TAG, "onAdLoaded");
//
//                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
//                    @Override
//                    public void onAdDismissedFullScreenContent() {
//                        // Called when fullscreen content is dismissed.
//                        if (one) {
//                            one = false;
//                            two = false;
//                            three = false;
//
//                            Log.d("TAG", "The ad was dismissed.");
//                            if (!hasPermissions(Home.this, PERMISSIONS)) {
//                                ActivityCompat.requestPermissions(Home.this, PERMISSIONS, PERMISSION_ALL);
//                            } else {
//                                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
//                                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                                startActivityForResult(pickPhoto, 1);
//                            }
//                        } else if (two) {
//                            one = false;
//                            two = false;
//                            three = false;
//                            linearPreviousScan.performClick();
//
//                        } else if (three) {
//                            one = false;
//                            two = false;
//                            three = false;
//                            openActivity();
//                        }
//                        loadAd();
//                    }
//
//                    @Override
//                    public void onAdFailedToShowFullScreenContent(AdError adError) {
//                        // Called when fullscreen content failed to show.
//                        Log.d("TAG", "The ad failed to show.");
//                    }
//
//                    @Override
//                    public void onAdShowedFullScreenContent() {
//                        // Called when fullscreen content is shown.
//                        // Make sure to set your reference to null so you don't
//                        // show it a second time.
//                        mInterstitialAd = null;
//                        Log.d("TAG", "The ad was shown.");
//                    }
//                });
//            }
//
//            @Override
//            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                // Handle the error
//                Log.i(TAG, loadAdError.getMessage());
//                mInterstitialAd = null;
//            }
//        });
//
//    }

    //
//    private void showInterstitial() {
//        if (mInterstitialAd != null) {
//            mInterstitialAd.show(Home.this);
//        } else {
//            Log.d("TAG", "The interstitial ad wasn't ready yet.");
//        }
//    }
    private void showInterstitial() {
        if (one) {
            one = false;
            two = false;
            three = false;

            Log.d("TAG", "The ad was dismissed.");
            if (!hasPermissions(Home.this, PERMISSIONS)) {
                ActivityCompat.requestPermissions(Home.this, PERMISSIONS, PERMISSION_ALL);
            } else {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto, 1);
            }
        } else if (two) {
            one = false;
            two = false;
            three = false;
            linearPreviousScan.performClick();

        } else if (three) {
            one = false;
            two = false;
            three = false;
            openActivity();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sidemenu, menu);

        return true;
    }

//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        boolean result = super.onPrepareOptionsMenu(menu);
//        View view = findViewById(R.id.setting);
//
//        // Cast to a TextView instance if the menu item was found
//        if (view instanceof TextView) {
//            ((TextView) view).setTextColor( Color.BLUE ); // Make text colour blue
//            ((TextView) view).setTypeface(urduFont);
//            ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_SP, 24); // Increase font size
//        }
//        return result;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.privact:
                Intent in = new Intent(Home.this, privacy_policy.class);
                startActivity(in);

            case R.id.action_review:
                reviewApp();

                return true;
            case R.id.switchSupplier:
                finishAffinity();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void reviewApp() {
        try {
            Intent rateIntent = rateIntentForUrl("market://details");
            startActivity(rateIntent);
        } catch (ActivityNotFoundException e) {
            Intent rateIntent = rateIntentForUrl("https://play.google.com/store/apps/details");
            startActivity(rateIntent);
        }
    }

    private Intent rateIntentForUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21) {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        } else {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }

}