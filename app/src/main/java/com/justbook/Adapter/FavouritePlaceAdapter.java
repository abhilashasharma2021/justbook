package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.FavouritePlaceDataList;
import com.justbook.R;

import java.util.ArrayList;
import java.util.List;


public class FavouritePlaceAdapter extends RecyclerView.Adapter<FavouritePlaceAdapter.ViewHolder> {
   Context context;
   List<FavouritePlaceDataList>dataListsFavourite;

   public  FavouritePlaceAdapter(Context context, List<FavouritePlaceDataList>getDataAdapter){
       this.context=context;
       this.dataListsFavourite=getDataAdapter;

   }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_favourite_place_layout,parent,false);

       FavouritePlaceAdapter.ViewHolder viewHolder=new FavouritePlaceAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       final FavouritePlaceDataList dataList=dataListsFavourite.get(position);
       holder.image.setImageResource(dataList.getImage());
       holder.txt_name.setText(dataList.getName());
       holder.txt_location.setText(dataList.getLocation());
       holder.txt_time.setText(dataList.getTime());

    }

    @Override
    public int getItemCount() {
        return dataListsFavourite.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       ImageView image;
       TextView txt_name,txt_location,txt_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
            txt_name=itemView.findViewById(R.id.txt_name);
            txt_location=itemView.findViewById(R.id.txt_location);
            txt_time=itemView.findViewById(R.id.txt_time);

        }
    }
}
