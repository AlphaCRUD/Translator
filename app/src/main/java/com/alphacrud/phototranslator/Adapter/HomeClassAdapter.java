package com.alphacrud.phototranslator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.alphacrud.phototranslator.Home;
import com.alphacrud.phototranslator.Model.HomeImageModel;
import com.alphacrud.phototranslator.R;

import java.util.ArrayList;

public class HomeClassAdapter extends RecyclerView.Adapter<HomeClassAdapter.ViewHolder> {
    Context context;
    ArrayList<HomeImageModel> list;
    boolean t;

    public HomeClassAdapter(Context context, ArrayList<HomeImageModel> list, boolean t) {
        this.context = context;
        this.list = list;
        this.t = t;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_layout, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            HomeImageModel model = list.get(position);
            if (model.getLink().equals("camera")) {
                holder.cam.setVisibility(View.VISIBLE);
                holder.img2.setVisibility(View.GONE);
            } else {
                holder.cam.setVisibility(View.GONE);
                holder.img2.setVisibility(View.VISIBLE);

            }
            holder.cam.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Home) context).openActivity();
                }
            });
            holder.img2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((Home) context).PassBitmap(model.getLink());
                }
            });

            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.loader_test)
                    .error(R.drawable.loader_test)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH).placeholder(R.drawable.loader_test)
                    .dontAnimate()
                    .dontTransform();
            Glide
                    .with(context)
                    .load(model.getLink())
                    .centerCrop()
                    .placeholder(R.drawable.loader_test)
                    .into(holder.img2);

            Glide.with(context).load(model.getLink()).placeholder(R.drawable.loader_test).apply(options).into(holder.img2);

        } catch (Exception e) {
            holder.img2.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_baseline_camera_alt_24));
//            Glide.with(context).load(model.getLink()).placeholder(R.drawable.loader_test).apply(options).into(holder.img2);
            e.printStackTrace();
        }
    }


    @Override
    public int getItemCount() {
//        if (t) {
//            return 12;
//        } else {
            return 9;
//        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout cam;
        ImageView img, img2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cam = itemView.findViewById(R.id.cam);
            img = itemView.findViewById(R.id.img);
            img2 = itemView.findViewById(R.id.img2);

        }
    }
}
