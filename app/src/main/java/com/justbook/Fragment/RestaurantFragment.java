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
import com.justbook.Adapter.RestaurantAdapter;
import com.justbook.DataList.ClubDataList;
import com.justbook.DataList.RestaurantDataList;
import com.justbook.R;

import java.util.ArrayList;


public class RestaurantFragment extends Fragment {
RecyclerView recycle_Restro;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<RestaurantDataList> dataListsRestro=new ArrayList<>();

    RestaurantAdapter restaurantAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_restaurant, container, false);

        recycle_Restro=view.findViewById(R.id.recycle_Restro);

        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        recycle_Restro.setLayoutManager(layoutManager);


        restaurantAdapter=new RestaurantAdapter(getContext(),dataListsRestro);
        recycle_Restro.setAdapter(restaurantAdapter);

        show_restro();

       return view;
    }
    public  void show_restro(){

        RestaurantDataList dataList=new RestaurantDataList("Traditional");

        for (int i=0;i<12;i++){

            dataListsRestro.add(dataList);
        }

    }

}
