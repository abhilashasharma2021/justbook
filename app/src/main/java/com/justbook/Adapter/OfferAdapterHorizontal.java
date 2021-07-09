package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.OfferDataListHorizontal;
import com.justbook.R;

import java.util.List;

public class OfferAdapterHorizontal extends RecyclerView.Adapter<OfferAdapterHorizontal.ViewHolder> {
   Context context;
   List<OfferDataListHorizontal> offerDataListHorizontals;

   public OfferAdapterHorizontal(Context context,List<OfferDataListHorizontal>getDataAdapter){

       this.context=context;
       this.offerDataListHorizontals=getDataAdapter;

   }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_offer_layout,parent,false);

       OfferAdapterHorizontal.ViewHolder viewHolder=new OfferAdapterHorizontal.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      final  OfferDataListHorizontal dataListHorizontal=offerDataListHorizontals.get(position);
         holder.img_foodHorizontal.setImageResource(dataListHorizontal.getImage_Food());
         holder.txt_discountDetail.setText(dataListHorizontal.getDiscount_Details());
         holder.txt_discountPercentage.setText(dataListHorizontal.getDiscount_Percentage());
         holder.txt_location.setText(dataListHorizontal.getLocation());

    }

    @Override
    public int getItemCount() {
        return offerDataListHorizontals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       ImageView img_foodHorizontal;
       TextView txt_discountPercentage,txt_discountDetail,txt_location;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_foodHorizontal=itemView.findViewById(R.id.img_foodHorizontal);
            txt_discountPercentage=itemView.findViewById(R.id.txt_discountPercentage);
            txt_discountDetail=itemView.findViewById(R.id.txt_discountDetail);
            txt_location=itemView.findViewById(R.id.txt_location);
        }
    }
}
