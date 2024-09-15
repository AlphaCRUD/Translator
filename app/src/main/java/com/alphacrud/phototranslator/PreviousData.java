package com.alphacrud.phototranslator;

import static com.alphacrud.phototranslator.MyApplication.DA;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.alphacrud.phototranslator.Adapter.PreviousScanAdapter;
import com.alphacrud.phototranslator.Database.DatabaseAssist;
import com.alphacrud.phototranslator.Model.PreviousDataModel;
import com.alphacrud.phototranslator.ads.AdsCallBack;
import com.alphacrud.phototranslator.ads.AdsManager;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;

import java.util.ArrayList;
import java.util.Collections;

public class PreviousData extends AppCompatActivity {
    private RecyclerView recyclerView;
    ArrayList<PreviousDataModel> list;
    PreviousScanAdapter previousScanAdapter;
    private LinearLayout linearNo;
    ImageButton btnBack;
//    AdView mAdView;
    ProgressBar progressed;
    TemplateView template;
    private AdLoader adLoader;
    private boolean adLoaded = false;
    LottieAnimationView animationView2;

    private static final int SECOND_ACTIVITY_REQUEST_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous_data);

        Configuration configuration = getResources().getConfiguration();
        int screenHeightDp = configuration.screenHeightDp; //T// he current width of the available screen space, in dp units, corresponding to screen width resource qualifier.
        if (screenHeightDp < 680) {
            AdsManager.loadNativeAd(this, findViewById(R.id.llNativeLarge), R.layout.ad_unified_small);
        } else {
            AdsManager.loadNativeAd(this, findViewById(R.id.llNativeLarge), R.layout.ad_unified_medium);
        }

        findViewById(R.id.rlTT).setOnClickListener(view -> {
            AdsManager.showInterstitialWithInterval(this, () -> startActivity(new Intent(PreviousData.this, TextTranslator.class)));

        });

        list = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        linearNo = findViewById(R.id.linearNo);
        DA = DatabaseAssist.getInstance(this);
        btnBack = findViewById(R.id.btnBack);
//        mAdView = findViewById(R.id.adView);
//        mAdView.setVisibility(View.GONE);
        progressed = findViewById(R.id.progressed);
        progressed.setVisibility(View.VISIBLE);
         animationView2
                = findViewById(R.id.animation_view2);
        animationView2
                .addAnimatorUpdateListener(
                        (animation) -> {
                            // Do something.
                        });
        animationView2
                .playAnimation();
//        AdRequest adRequest = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest);
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdClicked() {
//                // Code to be executed when the user clicks on an ad.
//            }
//
//            @Override
//            public void onAdClosed() {
//                // Code to be executed when the user is about to return
//                // to the app after tapping on an ad.
//            }
//
//            @Override
//            public void onAdFailedToLoad(LoadAdError adError) {
//                progressed.setVisibility(View.GONE);
//
//                // Code to be executed when an ad request fails.
//            }
//
//            @Override
//            public void onAdImpression() {
//                // Code to be executed when an impression is recorded
//                // for an ad.
//            }
//
//            @Override
//            public void onAdLoaded() {
//                mAdView.setVisibility(View.VISIBLE);
//                progressed.setVisibility(View.GONE);
//
//                // Code to be executed when an ad finishes loading.
//            }
//
//            @Override
//            public void onAdOpened() {
//                // Code to be executed when an ad opens an overlay that
//                // covers the screen.
//            }
//        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        adLoader = new AdLoader.Builder(this, "ca-app-pub-3940256099942544/2247696110").forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
//
//            private ColorDrawable background;
//
//            @Override
//            public void onNativeAdLoaded(@NonNull NativeAd unifiedNativeAd) {
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
//        adLoader.loadAd(new AdRequest.Builder().build());

    }

    @Override
    protected void onResume() {
        super.onResume();
        list = DA.getSingleCustomerData();
        if (list.size() == 0) {
            linearNo.setVisibility(View.VISIBLE);
        } else {
            linearNo.setVisibility(View.GONE);

        }

        Collections.reverse(list);
        previousScanAdapter = new PreviousScanAdapter(PreviousData.this, list);

        recyclerView.setAdapter(previousScanAdapter);


    }

    public void showmenu(View v, int id) {
        try {
            PopupMenu popup = new PopupMenu(PreviousData.this, v);
            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    switch (item.getItemId()) {
                        case R.id.switchSupplier:
                            AdsManager.showInterstitialWithInterval(PreviousData.this, new AdsCallBack() {
                                @Override
                                public void onClosed() {
                                    long v = DA.delete(id);
                                    if (v > 0) {
                                        onResume();
                                    }
                                }
                            });

                            return true;


                        default:
                            return false;
                    }
                }
            });
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.business_menu, popup.getMenu());
            popup.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    String txt2;

    public void Intenta(String txt) {
        txt2 = txt;
        Intent in = new Intent(PreviousData.this, ScanResult.class);
        in.putExtra("txt", txt2);
        startActivity(in);
//        Intent in = new Intent(PreviousData.this, Adds.class);
//        in.putExtra("screen_name", "Previous");
//        startActivityForResult(in, SECOND_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // Get String data from Intent
                String returnString = data.getStringExtra("keyName");
                // Set text view with string

                if (returnString != null && returnString.contains("ok")) {
                    Intent in = new Intent(PreviousData.this, ScanResult.class);
                    in.putExtra("txt", txt2);
                    startActivity(in);

                }


            }
        }

    }

}