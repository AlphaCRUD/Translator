package com.alphacrud.phototranslator.ads;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.alphacrud.phototranslator.R;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;

public class AdsManager {
    static int counter=0;
    static InterstitialAd mInterstitialAd;
    public static void loadInterstitial(Activity activity){
        loadInterstitialHightEcpm(activity);
    }

    private static void loadInterstitialHightEcpm(Activity activity) {
        InterstitialAd.load(activity, AdsConstant.interstitialHightEcpmId, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd= null;
                loadInterstitialMediumEcpm(activity);
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
             mInterstitialAd= interstitialAd;
            }
        });
    }
    private static void loadInterstitialMediumEcpm(Activity activity) {
        InterstitialAd.load(activity, AdsConstant.interstitialMediumEcpmId, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd=null;
                loadInterstitialDefaultEcpm(activity);
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mInterstitialAd= interstitialAd;
            }
        });
    }
    private static void loadInterstitialDefaultEcpm(Activity activity) {
        InterstitialAd.load(activity, AdsConstant.interstitialDefaultEcpmId, new AdRequest.Builder().build(), new InterstitialAdLoadCallback() {
            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                mInterstitialAd=null;
            }

            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                mInterstitialAd= interstitialAd;
            }
        });
    }


    public static void showInterstitialWithInterval(Activity activity, AdsCallBack adsCallBack){
      counter++;
      if(counter>= AdsConstant.displayCounter){

          if(mInterstitialAd!=null){
              mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                  @Override
                  public void onAdDismissedFullScreenContent() {
                      loadInterstitial(activity);
                      adsCallBack.onClosed();
                  }

                  @Override
                  public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                      loadInterstitial(activity);
                      adsCallBack.onClosed();
                  }
              });
              mInterstitialAd.show(activity);
          }else{
              loadInterstitial(activity);
              adsCallBack.onClosed();
          }

      }else{
          adsCallBack.onClosed();
      }
    }


    public static void showInterstitialAd(Activity activity, AdsCallBack adsCallBack){
        if(mInterstitialAd!=null){
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    loadInterstitial(activity);
                    adsCallBack.onClosed();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    loadInterstitial(activity);
                    adsCallBack.onClosed();
                }
            });
            mInterstitialAd.show(activity);
        }else{
            loadInterstitial(activity);
            adsCallBack.onClosed();
        }
    }

    //TODO NATIVE

    public static void  loadNativeAd(Activity activity, ViewGroup nativeFrame, int layout){

        loadNativeHightEcpm(activity, nativeFrame,layout);
    }

    private static void loadNativeHightEcpm(Activity activity, ViewGroup nativeFrame, int layout) {
        AdLoader.Builder builder = new AdLoader.Builder(activity, AdsConstant.nativeHighEcpmId);

        // OnLoadedListener implementation.
        builder.forNativeAd(
                nativeAd -> {
                    // If this callback occurs after the activity is destroyed, you must call
                    // destroy and return or you may get a memory leak.
                    boolean isDestroyed = false;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        isDestroyed = activity.isDestroyed();
                    }
                    if (isDestroyed || activity.isFinishing() || activity.isChangingConfigurations()) {
                        nativeAd.destroy();
                        return;
                    }
                    // You must call destroy on old ads when you are done with them,
                    // otherwise you will have a memory leak.

                    NativeAdView adView = (NativeAdView) activity.getLayoutInflater().inflate(layout, null);
                    populateNativeAdView(nativeAd, adView);
                    nativeFrame.removeAllViews();
                    nativeFrame.addView(adView);
                });


        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                loadNativeMediumEcpm(activity,nativeFrame,layout);
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }

    private static void loadNativeMediumEcpm(Activity activity, ViewGroup nativeFrame, int layout) {
        AdLoader.Builder builder = new AdLoader.Builder(activity, AdsConstant.nativeMediumEcpmId);

        // OnLoadedListener implementation.
        builder.forNativeAd(
                nativeAd -> {
                    // If this callback occurs after the activity is destroyed, you must call
                    // destroy and return or you may get a memory leak.
                    boolean isDestroyed = false;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        isDestroyed = activity.isDestroyed();
                    }
                    if (isDestroyed || activity.isFinishing() || activity.isChangingConfigurations()) {
                        nativeAd.destroy();
                        return;
                    }
                    // You must call destroy on old ads when you are done with them,
                    // otherwise you will have a memory leak.

                    NativeAdView adView = (NativeAdView) activity.getLayoutInflater().inflate(layout, null);
                    populateNativeAdView(nativeAd, adView);
                    nativeFrame.removeAllViews();
                    nativeFrame.addView(adView);
                });


        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                loadNativeDefaultEcpm(activity, nativeFrame,layout);
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }
    private static void loadNativeDefaultEcpm(Activity activity, ViewGroup nativeFrame, int layout) {
        AdLoader.Builder builder = new AdLoader.Builder(activity, AdsConstant.nativeDefaultEcpmId);

        // OnLoadedListener implementation.
        builder.forNativeAd(
                nativeAd -> {
                    // If this callback occurs after the activity is destroyed, you must call
                    // destroy and return or you may get a memory leak.
                    boolean isDestroyed = false;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        isDestroyed = activity.isDestroyed();
                    }
                    if (isDestroyed || activity.isFinishing() || activity.isChangingConfigurations()) {
                        nativeAd.destroy();
                        return;
                    }
                    // You must call destroy on old ads when you are done with them,
                    // otherwise you will have a memory leak.

                    NativeAdView adView = (NativeAdView) activity.getLayoutInflater().inflate(layout, null);
                    populateNativeAdView(nativeAd, adView);
                    nativeFrame.removeAllViews();
                    nativeFrame.addView(adView);
                });


        AdLoader adLoader = builder.withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {


            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }

    private static void populateNativeAdView(NativeAd nativeAd, NativeAdView adView) {
        // Set the media view.
        adView.setMediaView((MediaView) adView.findViewById(R.id.ad_media));

        // Set other ad assets.
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
        adView.setPriceView(adView.findViewById(R.id.ad_price));
        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
        adView.setStoreView(adView.findViewById(R.id.ad_store));
        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));

        // The headline and mediaContent are guaranteed to be in every NativeAd.

        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());

        // These assets aren't guaranteed to be in every NativeAd, so it's important to
        // check before trying to display them.
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }

        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(
                    nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getPrice() == null) {
            adView.getPriceView().setVisibility(View.INVISIBLE);
        } else {
            adView.getPriceView().setVisibility(View.VISIBLE);
            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
        }

        if (nativeAd.getStore() == null) {
            adView.getStoreView().setVisibility(View.INVISIBLE);
        } else {
            adView.getStoreView().setVisibility(View.VISIBLE);
            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
        }

        if (nativeAd.getStarRating() == null) {
            adView.getStarRatingView().setVisibility(View.INVISIBLE);
        } else {
            ((RatingBar) adView.getStarRatingView())
                    .setRating(nativeAd.getStarRating().floatValue());
            adView.getStarRatingView().setVisibility(View.VISIBLE);
        }

        if (nativeAd.getAdvertiser() == null) {
            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
        } else {
            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
            adView.getAdvertiserView().setVisibility(View.VISIBLE);
        }

        adView.setNativeAd(nativeAd);

        VideoController vc = nativeAd.getMediaContent().getVideoController();

        // Updates the UI to say whether or not this ad has a video asset.
        if (vc.hasVideoContent()) {

            vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                @Override
                public void onVideoEnd() {
                    // Publishers should allow native ads to complete video playback before
                    // refreshing or replacing them with another ad in the same UI location.

                    super.onVideoEnd();
                }
            });
        }
    }
}
