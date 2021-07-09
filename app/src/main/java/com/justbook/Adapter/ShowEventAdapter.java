package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.EventDataList;
import com.justbook.DataList.FavouritePlaceDataList;
import com.justbook.R;

import java.util.ArrayList;

public class ShowEventAdapter extends RecyclerView.Adapter<ShowEventAdapter.ViewHolder> {
    Context context;
    ArrayList<EventDataList>eventDataLists;

    public ShowEventAdapter(Context context,ArrayList<EventDataList>getAdapter){
        this.context=context;
        this.eventDataLists=getAdapter;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_event_layout,parent,false);

         ShowEventAdapter.ViewHolder viewHolder=new ShowEventAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final EventDataList dataList=eventDataLists.get(position);
        holder.img_background.setImageResource(dataList.getImgBack());
        holder.txt_time.setText(dataList.getTime());
        holder.txt_location.setText(dataList.getLocation());
        holder.txt_like.setText(dataList.getLike());
    }

    @Override
    public int getItemCount() {
        return eventDataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img_background;
        TextView txt_time,txt_location,txt_like;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            img_background=itemView.findViewById(R.id.img_background);
            txt_like=itemView.findViewById(R.id.txt_like);
            txt_location=itemView.findViewById(R.id.txt_location);
            txt_time=itemView.findViewById(R.id.txt_time);

        }
    }
}
