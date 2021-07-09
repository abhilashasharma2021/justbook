package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.RestaurantDataList;
import com.justbook.R;

import java.util.List;

public class RestaurantAdapter  extends  RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {
    Context context;
    List<RestaurantDataList> dataLists;

    public RestaurantAdapter(Context context, List<RestaurantDataList> getDataAdapter) {
        this.context = context;
        this.dataLists = getDataAdapter;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_restaurant_layout, parent, false);

        RestaurantAdapter.ViewHolder viewHolder = new RestaurantAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final RestaurantDataList dataList = dataLists.get(position);
        holder.restro_name.setText(dataList.getRestoName());


    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView restro_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            restro_name = itemView.findViewById(R.id.restro_name);
        }
    }
}

