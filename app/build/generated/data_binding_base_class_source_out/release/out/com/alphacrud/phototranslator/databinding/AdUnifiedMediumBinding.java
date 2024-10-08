// Generated by view binder compiler. Do not edit!
package com.alphacrud.phototranslator.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.alphacrud.phototranslator.R;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAdView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AdUnifiedMediumBinding implements ViewBinding {
  @NonNull
  private final NativeAdView rootView;

  @NonNull
  public final LinearLayout CTAButton;

  @NonNull
  public final TextView adAdvertiser;

  @NonNull
  public final ImageView adAppIcon;

  @NonNull
  public final TextView adBody;

  @NonNull
  public final Button adCallToAction;

  @NonNull
  public final TextView adHeadline;

  @NonNull
  public final MediaView adMedia;

  @NonNull
  public final TextView adPrice;

  @NonNull
  public final RatingBar adStars;

  @NonNull
  public final TextView adStore;

  @NonNull
  public final TextView tv;

  private AdUnifiedMediumBinding(@NonNull NativeAdView rootView, @NonNull LinearLayout CTAButton,
      @NonNull TextView adAdvertiser, @NonNull ImageView adAppIcon, @NonNull TextView adBody,
      @NonNull Button adCallToAction, @NonNull TextView adHeadline, @NonNull MediaView adMedia,
      @NonNull TextView adPrice, @NonNull RatingBar adStars, @NonNull TextView adStore,
      @NonNull TextView tv) {
    this.rootView = rootView;
    this.CTAButton = CTAButton;
    this.adAdvertiser = adAdvertiser;
    this.adAppIcon = adAppIcon;
    this.adBody = adBody;
    this.adCallToAction = adCallToAction;
    this.adHeadline = adHeadline;
    this.adMedia = adMedia;
    this.adPrice = adPrice;
    this.adStars = adStars;
    this.adStore = adStore;
    this.tv = tv;
  }

  @Override
  @NonNull
  public NativeAdView getRoot() {
    return rootView;
  }

  @NonNull
  public static AdUnifiedMediumBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AdUnifiedMediumBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.ad_unified_medium, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AdUnifiedMediumBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.CTAButton;
      LinearLayout CTAButton = ViewBindings.findChildViewById(rootView, id);
      if (CTAButton == null) {
        break missingId;
      }

      id = R.id.ad_advertiser;
      TextView adAdvertiser = ViewBindings.findChildViewById(rootView, id);
      if (adAdvertiser == null) {
        break missingId;
      }

      id = R.id.ad_app_icon;
      ImageView adAppIcon = ViewBindings.findChildViewById(rootView, id);
      if (adAppIcon == null) {
        break missingId;
      }

      id = R.id.ad_body;
      TextView adBody = ViewBindings.findChildViewById(rootView, id);
      if (adBody == null) {
        break missingId;
      }

      id = R.id.ad_call_to_action;
      Button adCallToAction = ViewBindings.findChildViewById(rootView, id);
      if (adCallToAction == null) {
        break missingId;
      }

      id = R.id.ad_headline;
      TextView adHeadline = ViewBindings.findChildViewById(rootView, id);
      if (adHeadline == null) {
        break missingId;
      }

      id = R.id.ad_media;
      MediaView adMedia = ViewBindings.findChildViewById(rootView, id);
      if (adMedia == null) {
        break missingId;
      }

      id = R.id.ad_price;
      TextView adPrice = ViewBindings.findChildViewById(rootView, id);
      if (adPrice == null) {
        break missingId;
      }

      id = R.id.ad_stars;
      RatingBar adStars = ViewBindings.findChildViewById(rootView, id);
      if (adStars == null) {
        break missingId;
      }

      id = R.id.ad_store;
      TextView adStore = ViewBindings.findChildViewById(rootView, id);
      if (adStore == null) {
        break missingId;
      }

      id = R.id.tv;
      TextView tv = ViewBindings.findChildViewById(rootView, id);
      if (tv == null) {
        break missingId;
      }

      return new AdUnifiedMediumBinding((NativeAdView) rootView, CTAButton, adAdvertiser, adAppIcon,
          adBody, adCallToAction, adHeadline, adMedia, adPrice, adStars, adStore, tv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
