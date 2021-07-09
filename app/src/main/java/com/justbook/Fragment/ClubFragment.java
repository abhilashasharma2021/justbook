package com.justbook.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.justbook.Adapter.ClubAdapter;
import com.justbook.DataList.ClubDataList;
import com.justbook.R;

import java.util.ArrayList;


public class ClubFragment extends Fragment {

    RecyclerView recycle_club;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ClubDataList>dataListsClub=new ArrayList<>();

    ClubAdapter clubAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_club, container, false);

        recycle_club=view.findViewById(R.id.recycle_club);

        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recycle_club.setLayoutManager(layoutManager);


        clubAdapter=new ClubAdapter(getContext(),dataListsClub);
        recycle_club.setAdapter(clubAdapter);

        show_club();
        return  view;
    }
public  void show_club(){

        ClubDataList dataList=new ClubDataList("Rock Club");

        for (int i=0;i<12;i++){

            dataListsClub.add(dataList);
        }

}

}
