package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.florent37.shapeofview.shapes.CircleView;
import com.justbook.DataList.BookingDataList;
import com.justbook.DataList.ReviewDataList;
import com.justbook.R;

import java.util.ArrayList;
import java.util.List;

public class ReviewAdapetr   extends RecyclerView.Adapter<ReviewAdapetr.ViewHolder> {
    Context context;
    ArrayList<ReviewDataList>dataListsReview;

    public ReviewAdapetr(Context context, ArrayList<ReviewDataList>getDataAdapter){
        this.context=context;
        this.dataListsReview=getDataAdapter;

    }


    @NonNull
    @Override
    public ReviewAdapetr.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_review_layout,parent,false);

        ReviewAdapetr.ViewHolder viewHolder=new ReviewAdapetr.ViewHolder(view);


        return viewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull ReviewAdapetr.ViewHolder holder, int position) {

        final ReviewDataList reviewDataList=dataListsReview.get(position);

        holder.img_Profile.setDrawable(reviewDataList.getImage());

        holder.txt_Name.setText(reviewDataList.getTxt_name());
        holder.txt_Day.setText(reviewDataList.getTxt_day());
        holder.txt_Time.setText(reviewDataList.getTxt_time());
        holder.txt_Like.setText(reviewDataList.getTxt_like());

    }


    @Override
    public int getItemCount() {
        return dataListsReview.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       CircleView img_Profile;
        TextView txt_Name,txt_Time,txt_Day,txt_Like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Profile=itemView.findViewById(R.id.img_Profile);
            txt_Name=itemView.findViewById(R.id.txt_Name);
            txt_Day=itemView.findViewById(R.id.txt_Day);
            txt_Like=itemView.findViewById(R.id.txt_Like);
            txt_Time=itemView.findViewById(R.id.txt_Time);

        }
    }
}
