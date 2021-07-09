package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.BarDataList;
import com.justbook.DataList.FavouritePlaceDataList;
import com.justbook.R;

import java.util.List;

public class BarAdapter  extends RecyclerView.Adapter<BarAdapter.ViewHolder> {
   Context context;
   List<BarDataList>dataLists;
   public BarAdapter(Context context,List<BarDataList>getDataAdapter){
       this.context=context;
       this.dataLists=getDataAdapter;


   }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_bar_layout,parent,false);

        BarAdapter.ViewHolder viewHolder=new BarAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
          final  BarDataList dataList=dataLists.get(position);
          holder.bar_name.setText(dataList.getBarName());


    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView bar_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bar_name=itemView.findViewById(R.id.bar_name);
        }
    }
}
