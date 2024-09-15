package com.alphacrud.phototranslator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.alphacrud.phototranslator.Model.PreviousDataModel;
import com.alphacrud.phototranslator.PreviousData;
import com.alphacrud.phototranslator.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PreviousScanAdapter extends RecyclerView.Adapter<PreviousScanAdapter.ViewHolder> {
    Context context;
    ArrayList<PreviousDataModel> list;

    public PreviousScanAdapter(Context context, ArrayList<PreviousDataModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public PreviousScanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.previous_scan_layout, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PreviousScanAdapter.ViewHolder holder, int position) {
        try {
            PreviousDataModel model = list.get(position);
            RequestOptions options = new RequestOptions()
                    .centerCrop()
                    .placeholder(R.drawable.loader_test)
                    .error(R.drawable.loader_test)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH)
                    .dontAnimate()
                    .dontTransform();
            Glide
                    .with(context)
                    .load(model.getImgUrl())
                    .centerCrop()
                    .placeholder(R.drawable.loader_test)
                    .into(holder.cImg);

            Glide.with(context).load(model.getImgUrl()).apply(options).into(holder.cImg);
            holder.t1.setText(model.getTxt());
            holder.tDate.setText(model.getDate());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ((PreviousData) context).Intenta(model.getTxt());

                }
            });
            holder.more.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ((PreviousData) context).showmenu(holder.more, model.getId());
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        if (list.size() > 14) {
            return 15;
        } else {
            return list.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView cImg;
        TextView t1, tDate;
        ImageView more;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cImg = itemView.findViewById(R.id.cImg);
            t1 = itemView.findViewById(R.id.t1);
            tDate = itemView.findViewById(R.id.tDate);
            more = itemView.findViewById(R.id.more);

        }
    }
}
