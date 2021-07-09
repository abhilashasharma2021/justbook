package com.justbook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.Activity.TablayoutDescriptionActivity;
import com.justbook.DataList.HomeDataList;
import com.justbook.R;
import com.justbook.Utils.AppConstants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    ArrayList<HomeDataList> homeDataLists;

    public HomeAdapter(Context context, ArrayList<HomeDataList> dataLists) {
        this.context = context;
        this.homeDataLists = dataLists;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_home_layout, parent, false);

        HomeAdapter.ViewHolder viewHolder = new HomeAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final HomeDataList homeDataList = homeDataLists.get(position);

        //  holder.img_Category.setImageResource(homeDataList.getImg_items());
        final String image = homeDataList.getImg_items();
        String squareimage = homeDataList.getSquare_image();
        String likes = homeDataList.getLikes();
        String description = homeDataList.getDescription();
        String phone = homeDataList.getPhone();
        String votes = homeDataList.getVotes();
        String worktimestart = homeDataList.getWork_time_start();
        String workendtime = homeDataList.getWork_time_end();
        String workday = homeDataList.getWork_days();
        Log.e("fgjhkjhfkjhgkjfg", worktimestart);


        Picasso.with(context).load(image).into(holder.img_Category);
        holder.txt_Name.setText(homeDataList.getTxt_Name());
        holder.txt_Address.setText(homeDataList.getTxt_Address());

        holder.img_Category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AppConstants.sharedpreferences = context.getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = AppConstants.sharedpreferences.edit();
                editor.putString(AppConstants.PLACEADDRESS, homeDataList.getTxt_Address());
                editor.putString(AppConstants.PLACENAME, homeDataList.getTxt_Name());
                editor.putString(AppConstants.PLACEID, homeDataList.getPlaceId());
                editor.putString(AppConstants.PlaceStartTime, homeDataList.getWork_time_start());
                editor.putString(AppConstants.PlaceEndTime, homeDataList.getWork_time_end());
                editor.putString(AppConstants.WeekDays, homeDataList.getWork_days());
                editor.putString(AppConstants.PlacePhone, homeDataList.getPhone());
                editor.putString(AppConstants.PlaceDescription, homeDataList.getDescription());
                editor.putString(AppConstants.PlaceUrl, homeDataList.getUrl());
                editor.putString(AppConstants.PLACEIMAGE, homeDataList.getImg_items());
                editor.putString(AppConstants.PlaceLikes, homeDataList.getLikes());
                editor.commit();


                context.startActivity(new Intent(context, TablayoutDescriptionActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeDataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_Category;
        TextView txt_Name, txt_Address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_Category = itemView.findViewById(R.id.img_Category);
            txt_Name = itemView.findViewById(R.id.txt_Name);
            txt_Address = itemView.findViewById(R.id.txt_Address);
        }
    }
}
