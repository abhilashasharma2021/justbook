package com.justbook.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.justbook.Adapter.BarAdapter;
import com.justbook.DataList.BarDataList;
import com.justbook.R;

import java.util.ArrayList;

public class BarsFragment extends Fragment {

    RecyclerView recycle_bar;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<BarDataList> arrayListBar = new ArrayList<>();
    BarAdapter barAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bars, container, false);

        recycle_bar = view.findViewById(R.id.recycle_bar);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycle_bar.setLayoutManager(layoutManager);


        barAdapter = new BarAdapter(getContext(), arrayListBar);
        recycle_bar.setAdapter(barAdapter);



        show_bar();
        return view;
    }
    public void show_bar(){

        BarDataList dataList=new BarDataList("Beach Bar");

        for (int i=0;i<10;i++){

            arrayListBar.add(dataList);
        }
    }


}
