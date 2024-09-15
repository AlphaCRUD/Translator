package com.alphacrud.phototranslator.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alphacrud.phototranslator.Model.LanguageModel;
import com.alphacrud.phototranslator.R;
import com.alphacrud.phototranslator.TextTranslator;

import java.util.ArrayList;

public class LanguageAdapterText extends RecyclerView.Adapter<LanguageAdapterText.ViewHolder> implements Filterable {
    ArrayList<LanguageModel> list, _search;
    Context context;

    public LanguageAdapterText(ArrayList<LanguageModel> list, Context context) {
        this.list = list;
        this.context = context;
        this._search = list;
    }

    @NonNull
    @Override
    public LanguageAdapterText.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_language, parent, false));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LanguageAdapterText.ViewHolder holder, int position) {
        try {

            LanguageModel languageModel = list.get(position);
            holder.filterText.setText(languageModel.getText());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (((TextTranslator) context).isOnline()) {


                        if (!TextTranslator.isCurrentClick){
                            TextTranslator.position = position;
                        }

                        ((TextTranslator) context).AvailOffer(languageModel.getText(), languageModel.getShortCode());
                    } else {
                        Toast.makeText(context, "Please Connect Internet", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String str = charSequence.toString().toLowerCase().trim();
                if (str.isEmpty()) {
                    list = _search;
                } else {
                    ArrayList<LanguageModel> filterUser = new ArrayList<>();
                    for (LanguageModel user : _search) {
                        if (user.getText().toLowerCase().contains(str) ) {
                            filterUser.add(user);
                        }
                    }
                    list = filterUser;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                list = (ArrayList<LanguageModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView filterText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            filterText = itemView.findViewById(R.id.filterText);
        }
    }
}
