package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.GalleryDataList;
import com.justbook.R;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {
    Context context;
    List<GalleryDataList>galleryDataLists;

    public GalleryAdapter(Context context,List<GalleryDataList>getDataAdapter){

        this.context=context;
        this.galleryDataLists=getDataAdapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_gallery_layout,parent,false);

         GalleryAdapter.ViewHolder viewHolder=new GalleryAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         final GalleryDataList dataList=galleryDataLists.get(position);

         holder.image.setImageResource(dataList.getImage());
    }

    @Override
    public int getItemCount() {
        return galleryDataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image);
        }
    }
}
