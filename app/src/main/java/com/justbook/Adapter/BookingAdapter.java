package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.BookingDataList;
import com.justbook.R;

import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    Context context;
    List<BookingDataList>dataLists;
    public  BookingAdapter(Context context,List<BookingDataList>getDataAdapter){
        this.context=context;
        this.dataLists=getDataAdapter;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_booking_layout,parent,false);

         BookingAdapter.ViewHolder viewHolder=new BookingAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
      final  BookingDataList bookingDataList=dataLists.get(position);
      holder.txt_TimeSlot.setText(bookingDataList.getTxt_timeSlot());
    }

    @Override
    public int getItemCount() {
        return dataLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt_TimeSlot;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_TimeSlot=itemView.findViewById(R.id.txt_TimeSlot);
        }
    }
}
