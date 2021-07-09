package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.OfferDataListVertical;
import com.justbook.R;

import java.util.List;

public class OfferAdapterVertical extends RecyclerView.Adapter<OfferAdapterVertical.ViewHolder> {

    Context context;
    List<OfferDataListVertical>dataListVerticals;

    public OfferAdapterVertical(Context context,List<OfferDataListVertical>getDataAdapter){
        this.context=context;
        this.dataListVerticals=getDataAdapter;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_offer_vertical_layout,parent,false);

        OfferAdapterVertical.ViewHolder viewHolder=new OfferAdapterVertical.ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     final  OfferDataListVertical dataListVertical=dataListVerticals.get(position);

     holder.profile_food.setImageResource(dataListVertical.getImage_circle());
     holder.img_food.setImageResource(dataListVertical.getImage_food());
     holder.txt_foodName.setText(dataListVertical.getFoodName());
     holder.txt_disPercent.setText(dataListVertical.getDiscountDetails());
     holder.txt_discountPercent.setText(dataListVertical.getDiscountPercentage());
    }

    @Override
    public int getItemCount() {
        return dataListVerticals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile_food,img_food;
        TextView txt_foodName,txt_disPercent,txt_discountPercent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profile_food=itemView.findViewById(R.id.profile_food);
            img_food=itemView.findViewById(R.id.img_food);
            txt_foodName=itemView.findViewById(R.id.txt_foodName);
            txt_disPercent=itemView.findViewById(R.id.txt_disPercent);
            txt_discountPercent=itemView.findViewById(R.id.txt_discountPercent);
        }
    }
}
