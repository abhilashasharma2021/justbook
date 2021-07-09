package com.justbook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.DataList.ClubDataList;
import com.justbook.R;

import java.util.List;

public class ClubAdapter  extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {
   Context context;

   List<ClubDataList>dataListsClub;

   public ClubAdapter(Context context,List<ClubDataList>getDataAdapter){
       this.context=context;
       this.dataListsClub=getDataAdapter;

   }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_club_layout,parent,false);

       ClubAdapter.ViewHolder viewHolder=new ClubAdapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

       final  ClubDataList clubDataList=dataListsClub.get(position);
       holder.club_name.setText(clubDataList.getClubName());


    }

    @Override
    public int getItemCount() {
        return dataListsClub.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView club_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            club_name=itemView.findViewById(R.id.club_name);
        }
    }
}
