// Generated by view binder compiler. Do not edit!
package com.alphacrud.phototranslator.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.alphacrud.phototranslator.CustomBottomNavigationView1;
import com.alphacrud.phototranslator.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityHomeBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout adView;

  @NonNull
  public final ImageView allow;

  @NonNull
  public final ImageButton btm;

  @NonNull
  public final ImageButton btnBack;

  @NonNull
  public final CustomBottomNavigationView1 customBottomBar;

  @NonNull
  public final FloatingActionButton fab;

  @NonNull
  public final ImageView ivTT;

  @NonNull
  public final LinearLayout linearAdd;

  @NonNull
  public final LinearLayout linearGalery;

  @NonNull
  public final LinearLayout linearPreviousScan;

  @NonNull
  public final LinearLayout linearRecycler;

  @NonNull
  public final RelativeLayout nativeAd;

  @NonNull
  public final RelativeLayout nativeAdRel;

  @NonNull
  public final ProgressBar progress;

  @NonNull
  public final ProgressBar progressed;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final RelativeLayout rlTT;

  @NonNull
  public final RelativeLayout rlTop;

  @NonNull
  public final Toolbar toolbar;

  @NonNull
  public final TextView tvOpenTT;

  @NonNull
  public final TextView tvTT;

  @NonNull
  public final TextView txtTop;

  private ActivityHomeBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout adView,
      @NonNull ImageView allow, @NonNull ImageButton btm, @NonNull ImageButton btnBack,
      @NonNull CustomBottomNavigationView1 customBottomBar, @NonNull FloatingActionButton fab,
      @NonNull ImageView ivTT, @NonNull LinearLayout linearAdd, @NonNull LinearLayout linearGalery,
      @NonNull LinearLayout linearPreviousScan, @NonNull LinearLayout linearRecycler,
      @NonNull RelativeLayout nativeAd, @NonNull RelativeLayout nativeAdRel,
      @NonNull ProgressBar progress, @NonNull ProgressBar progressed,
      @NonNull RecyclerView recyclerView, @NonNull RelativeLayout rlTT,
      @NonNull RelativeLayout rlTop, @NonNull Toolbar toolbar, @NonNull TextView tvOpenTT,
      @NonNull TextView tvTT, @NonNull TextView txtTop) {
    this.rootView = rootView;
    this.adView = adView;
    this.allow = allow;
    this.btm = btm;
    this.btnBack = btnBack;
    this.customBottomBar = customBottomBar;
    this.fab = fab;
    this.ivTT = ivTT;
    this.linearAdd = linearAdd;
    this.linearGalery = linearGalery;
    this.linearPreviousScan = linearPreviousScan;
    this.linearRecycler = linearRecycler;
    this.nativeAd = nativeAd;
    this.nativeAdRel = nativeAdRel;
    this.progress = progress;
    this.progressed = progressed;
    this.recyclerView = recyclerView;
    this.rlTT = rlTT;
    this.rlTop = rlTop;
    this.toolbar = toolbar;
    this.tvOpenTT = tvOpenTT;
    this.tvTT = tvTT;
    this.txtTop = txtTop;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.adView;
      LinearLayout adView = ViewBindings.findChildViewById(rootView, id);
      if (adView == null) {
        break missingId;
      }

      id = R.id.allow;
      ImageView allow = ViewBindings.findChildViewById(rootView, id);
      if (allow == null) {
        break missingId;
      }

      id = R.id.btm;
      ImageButton btm = ViewBindings.findChildViewById(rootView, id);
      if (btm == null) {
        break missingId;
      }

      id = R.id.btnBack;
      ImageButton btnBack = ViewBindings.findChildViewById(rootView, id);
      if (btnBack == null) {
        break missingId;
      }

      id = R.id.customBottomBar;
      CustomBottomNavigationView1 customBottomBar = ViewBindings.findChildViewById(rootView, id);
      if (customBottomBar == null) {
        break missingId;
      }

      id = R.id.fab;
      FloatingActionButton fab = ViewBindings.findChildViewById(rootView, id);
      if (fab == null) {
        break missingId;
      }

      id = R.id.ivTT;
      ImageView ivTT = ViewBindings.findChildViewById(rootView, id);
      if (ivTT == null) {
        break missingId;
      }

      id = R.id.linearAdd;
      LinearLayout linearAdd = ViewBindings.findChildViewById(rootView, id);
      if (linearAdd == null) {
        break missingId;
      }

      id = R.id.linearGalery;
      LinearLayout linearGalery = ViewBindings.findChildViewById(rootView, id);
      if (linearGalery == null) {
        break missingId;
      }

      id = R.id.linearPreviousScan;
      LinearLayout linearPreviousScan = ViewBindings.findChildViewById(rootView, id);
      if (linearPreviousScan == null) {
        break missingId;
      }

      id = R.id.linearRecycler;
      LinearLayout linearRecycler = ViewBindings.findChildViewById(rootView, id);
      if (linearRecycler == null) {
        break missingId;
      }

      id = R.id.nativeAd;
      RelativeLayout nativeAd = ViewBindings.findChildViewById(rootView, id);
      if (nativeAd == null) {
        break missingId;
      }

      id = R.id.nativeAdRel;
      RelativeLayout nativeAdRel = ViewBindings.findChildViewById(rootView, id);
      if (nativeAdRel == null) {
        break missingId;
      }

      id = R.id.progress;
      ProgressBar progress = ViewBindings.findChildViewById(rootView, id);
      if (progress == null) {
        break missingId;
      }

      id = R.id.progressed;
      ProgressBar progressed = ViewBindings.findChildViewById(rootView, id);
      if (progressed == null) {
        break missingId;
      }

      id = R.id.recyclerView;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      id = R.id.rlTT;
      RelativeLayout rlTT = ViewBindings.findChildViewById(rootView, id);
      if (rlTT == null) {
        break missingId;
      }

      id = R.id.rlTop;
      RelativeLayout rlTop = ViewBindings.findChildViewById(rootView, id);
      if (rlTop == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      id = R.id.tvOpenTT;
      TextView tvOpenTT = ViewBindings.findChildViewById(rootView, id);
      if (tvOpenTT == null) {
        break missingId;
      }

      id = R.id.tvTT;
      TextView tvTT = ViewBindings.findChildViewById(rootView, id);
      if (tvTT == null) {
        break missingId;
      }

      id = R.id.txtTop;
      TextView txtTop = ViewBindings.findChildViewById(rootView, id);
      if (txtTop == null) {
        break missingId;
      }

      return new ActivityHomeBinding((RelativeLayout) rootView, adView, allow, btm, btnBack,
          customBottomBar, fab, ivTT, linearAdd, linearGalery, linearPreviousScan, linearRecycler,
          nativeAd, nativeAdRel, progress, progressed, recyclerView, rlTT, rlTop, toolbar, tvOpenTT,
          tvTT, txtTop);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
