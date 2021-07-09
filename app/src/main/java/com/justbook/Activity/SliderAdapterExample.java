package com.justbook.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.justbook.R;
import com.smarteist.autoimageslider.SliderViewAdapter;


import java.util.List;

public class SliderAdapterExample extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

   Context context;
   // List<SliderDataList>dataLists;


    /*public SliderAdapterExample(Context context, List<SliderDataList>getDataAdapter) {
        this.context = context;
       // this.dataLists=getDataAdapter;
    }*/
    public SliderAdapterExample(Context context) {
        this.context = context;
        // this.dataLists=getDataAdapter;
    }
    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_layout, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
       // viewHolder.textViewDescription.setText("This is slider item " + position);

      //  final SliderDataList dataList = dataLists.get(position);
        switch (position) {
            case 0:
                viewHolder.img_background.setBackground(context.getResources().getDrawable(R.drawable.food1));
               /* viewHolder.txt_date.setText(dataList.getDate());
                viewHolder.txt_like.setText(dataList.getLike());
                viewHolder.txt_location.setText(dataList.getLocation());*/

                break;
            case 1:
                viewHolder.img_background.setBackground(context.getResources().getDrawable(R.drawable.food2));
              /*  viewHolder.txt_date.setText(dataList.getDate());
                viewHolder.txt_like.setText(dataList.getLike());
                viewHolder.txt_location.setText(dataList.getLocation());*/

                break;
            case 2:
                viewHolder.img_background.setBackground(context.getResources().getDrawable(R.drawable.food));
             /*   viewHolder.txt_date.setText(dataList.getDate());
                viewHolder.txt_like.setText(dataList.getLike());
                viewHolder.txt_location.setText(dataList.getLocation());*/

                break;
            default:
                viewHolder.img_background.setBackground(context.getResources().getDrawable(R.drawable.food2));
               /* viewHolder.txt_date.setText(dataList.getDate());
                viewHolder.txt_like.setText(dataList.getLike());
                viewHolder.txt_location.setText(dataList.getLocation());*/
                break;

        }

    }

    @Override
    public int getCount() {

        return 5;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView img_background;
        TextView txt_date, txt_location, txt_like;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            img_background = itemView.findViewById(R.id.img_background);
            txt_location = itemView.findViewById(R.id.txt_location);
            txt_like = itemView.findViewById(R.id.txt_like);
            txt_date = itemView.findViewById(R.id.txt_date);
            this.itemView = itemView;
        }
    }
}