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
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.justbook.Adapter.ReviewAdapetr;
import com.justbook.DataList.ReviewDataList;
import com.justbook.R;

import java.util.ArrayList;

public class ReviewsFragment extends Fragment {
    RecyclerView recycler_Review;


    LinearLayoutManager layoutManager;
    ArrayList<ReviewDataList> arrayListReview=new ArrayList<>();
    ReviewAdapetr reviewAdapetr;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_reviews, container, false);

        recycler_Review= view.findViewById(R.id.recycler_Review);
        recycler_Review.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recycler_Review.setLayoutManager(layoutManager);






        reviewAdapetr = new ReviewAdapetr(getContext(),arrayListReview);
        recycler_Review.setAdapter(reviewAdapetr);

        LinearSnapHelper snapHelperServices = new LinearSnapHelper();
        snapHelperServices.attachToRecyclerView(recycler_Review);
        show_Review();


        return  view;
    }

    public  void show_Review(){

        ReviewDataList dataList=new ReviewDataList(R.drawable.images,"Suhana Sharma","17:00","80.02.2020","2");


        for (int i=0;i<15;i++) {
            arrayListReview.add(dataList);

        }
    }
}
