package com.justbook.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.justbook.Adapter.GalleryAdapter;
import com.justbook.DataList.GalleryDataList;
import com.justbook.R;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
  RecyclerView recycler_gallery;
    StaggeredGridLayoutManager staggeredGridLayoutManager;
  ArrayList<GalleryDataList>arrayListGallery=new ArrayList<>();
  GalleryAdapter galleryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//        getActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
  //     getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);



        recycler_gallery=view.findViewById(R.id.recycler_gallery);
        staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recycler_gallery.setLayoutManager(staggeredGridLayoutManager);

        galleryAdapter=new GalleryAdapter(getContext(),arrayListGallery);

        recycler_gallery.setAdapter(galleryAdapter);


        LayoutAnimationController animationController= AnimationUtils.loadLayoutAnimation(getContext(),R.anim.layout_animation_fall_down);
        recycler_gallery.setLayoutAnimation(animationController);
        recycler_gallery.scheduleLayoutAnimation();

        show_Gallery();

        return view;


    }

public  void show_Gallery(){
        GalleryDataList dataList =new GalleryDataList(R.drawable.kitch);
        arrayListGallery.add(dataList);



    dataList =new GalleryDataList(R.drawable.images);
    arrayListGallery.add(dataList);

    dataList =new GalleryDataList(R.drawable.kitch);
    arrayListGallery.add(dataList);
    dataList =new GalleryDataList(R.drawable.ki);
    arrayListGallery.add(dataList);
    dataList =new GalleryDataList(R.drawable.images);
    arrayListGallery.add(dataList);
    dataList =new GalleryDataList(R.drawable.kitche);
    arrayListGallery.add(dataList);
    dataList =new GalleryDataList(R.drawable.images);
    arrayListGallery.add(dataList);
    dataList =new GalleryDataList(R.drawable.kitche);
    arrayListGallery.add(dataList);
    dataList =new GalleryDataList(R.drawable.ki);
    arrayListGallery.add(dataList);
    dataList =new GalleryDataList(R.drawable.images);
    arrayListGallery.add(dataList);

    dataList =new GalleryDataList(R.drawable.kitche);
    arrayListGallery.add(dataList);
    dataList =new GalleryDataList(R.drawable.ki);
    arrayListGallery.add(dataList);
}
}
