package com.alphacrud.phototranslator;

import static com.alphacrud.phototranslator.MyApplication.DA;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.alphacrud.phototranslator.Database.DatabaseAssist;
import com.alphacrud.phototranslator.ads.AdsManager;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.firebase.FirebaseApp;

public class Splash extends AppCompatActivity {

    private AppUpdateManager appUpdateManager;
    private boolean isUpdateAvailable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        FirebaseApp.initializeApp(this);
        appUpdateManager = AppUpdateManagerFactory.create(this);

        AdsManager.loadInterstitial(this);


        DA = DatabaseAssist.getInstance(this);
        try {
            DA.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }


        new Handler().postDelayed(() -> AdsManager.showInterstitialAd(Splash.this, () -> {
            Intent in = new Intent(Splash.this, Home.class);
            startActivity(in);
            finish();
        }), 7000);
    }


    @Override
    protected void onResume() {
        super.onResume();

        // Check for app updates
        appUpdateManager.getAppUpdateInfo().addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE) {
                // An update is available, show the update prompt
                try {

                    isUpdateAvailable = true;


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private void showUpdateDialog() {
        findViewById(R.id.updateLayout).setVisibility(View.VISIBLE);
        findViewById(R.id.buttonUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateApp();
            }
        });

    }

    public void updateApp() {
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