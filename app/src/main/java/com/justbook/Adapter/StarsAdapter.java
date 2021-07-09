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

import com.justbook.DataList.StarDataList;
import com.justbook.R;

import java.util.ArrayList;
import java.util.List;

public class StarsAdapter extends RecyclerView.Adapter<StarsAdapter.ViewHolder> {

    Context context;
    List<StarDataList> dataListList;

  public  StarsAdapter(Context context, ArrayList<StarDataList>getDataAdapter){

      this.context=context;
      this.dataListList=getDataAdapter;

  }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_stars_layout,parent,false);

        StarsAdapter.ViewHolder viewHolder=new StarsAdapter.ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       final  StarDataList starDataList=dataListList.get(position);

       holder.img_singerImage.setImageResource(starDataList.getSingerImage());
       holder.txt_like.setText(starDataList.getLike());
       holder.txt_singerName.setText(starDataList.getSingerName());
    }

    @Override
    public int getItemCount() {
        return dataListList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

      ImageView img_singerImage;
      TextView txt_singerName,txt_like;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_like=itemView.findViewById(R.id.txt_like);
            txt_singerName=itemView.findViewById(R.id.txt_singerName);
            img_singerImage=itemView.findViewById(R.id.img_singerImage);
        }
    }
}
