// Generated by view binder compiler. Do not edit!
package com.alphacrud.phototranslator.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.alphacrud.phototranslator.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPrivacyPolicyBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView Headingone;

  @NonNull
  public final TextView Headingtwo;

  @NonNull
  public final TextView c1;

  @NonNull
  public final TextView c2;

  private ActivityPrivacyPolicyBinding(@NonNull RelativeLayout rootView,
      @NonNull TextView Headingone, @NonNull TextView Headingtwo, @NonNull TextView c1,
      @NonNull TextView c2) {
    this.rootView = rootView;
    this.Headingone = Headingone;
    this.Headingtwo = Headingtwo;
    this.c1 = c1;
    this.c2 = c2;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPrivacyPolicyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPrivacyPolicyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_privacy_policy, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPrivacyPolicyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Headingone;
      TextView Headingone = ViewBindings.findChildViewById(rootView, id);
      if (Headingone == null) {
        break missingId;
      }

      id = R.id.Headingtwo;
      TextView Headingtwo = ViewBindings.findChildViewById(rootView, id);
      if (Headingtwo == null) {
        break missingId;
      }

      id = R.id.c1;
      TextView c1 = ViewBindings.findChildViewById(rootView, id);
      if (c1 == null) {
        break missingId;
      }

      id = R.id.c2;
      TextView c2 = ViewBindings.findChildViewById(rootView, id);
      if (c2 == null) {
        break missingId;
      }

      return new ActivityPrivacyPolicyBinding((RelativeLayout) rootView, Headingone, Headingtwo, c1,
          c2);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
