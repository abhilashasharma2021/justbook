package com.justbook.Adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.SliderDataList;
import com.justbook.R;


import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {

    Context context;
    ArrayList<SliderDataList> sliderDatalist;


    public SliderAdapter(Context context, ArrayList<SliderDataList> getDataAdapter) {

        this.context = context;
        this.sliderDatalist = getDataAdapter;
        // this.URLS = URLS;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, parent,false);

         SliderAdapter.ViewHolder viewHolder=new SliderAdapter.ViewHolder(inflate);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SliderDataList dataList = sliderDatalist.get(position);

       /* holder.img_Background.setImageResource(dataList.getImageBack());
        holder.txt_location.setText(dataList.getLocation());
        holder.txt_date.setText(dataList.getDate());
        holder.txt_like.setText(dataList.getLike());*/
        // notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return sliderDatalist.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_Background;
        View itemView;
        TextView txt_date, txt_location, txt_like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


          /*  img_Background = itemView.findViewById(R.id.img_Background);
            txt_location = itemView.findViewById(R.id.txt_location);
            txt_like = itemView.findViewById(R.id.txt_like);
            txt_date = itemView.findViewById(R.id.txt_date);*/
            this.itemView = itemView;
        }
    }
}
