package com.alphacrud.phototranslator;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;

import androidx.appcompat.app.AppCompatActivity;

import com.alphacrud.phototranslator.ads.AdsCallBack;
import com.alphacrud.phototranslator.ads.AdsManager;

public class ExitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);

        Configuration configuration = getResources().getConfiguration();
        int screenHeightDp = configuration.screenHeightDp; //T// he current width of the available screen space, in dp units, corresponding to screen width resource qualifier.
        if (screenHeightDp < 680) {
            AdsManager.loadNativeAd(this, findViewById(R.id.nativeAd), R.layout.ad_unified_small);
        } else {
            AdsManager.loadNativeAd(this, findViewById(R.id.nativeAd), R.layout.ad_unified_medium);
        }



        findViewById(R.id.rlYes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });


        findViewById(R.id.icClose).setOnClickListener(view -> {

            AdsManager.showInterstitialWithInterval(this, () -> {
                startActivity(new Intent(ExitActivity.this, Home.class));

                finish();
            });

        });




        RatingBar ratingBar = findViewById(R.id.rating_bar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                String url = "https://play.google.com/store/apps/details?id=" + getPackageName();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });




        findViewById(R.id.rlNo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdsManager.showInterstitialAd(ExitActivity.this, new AdsCallBack() {
                    @Override
                    public void onClosed() {
                        startActivity(new Intent(ExitActivity.this, Home.class));
                        finish();
                    }
                });


            }
        });



    }


    @Override
    public void onBackPressed() {
        AdsManager.showInterstitialAd(this, () -> {
            startActivity(new Intent(ExitActivity.this, Home.class));
            finish();
        });

    }
}