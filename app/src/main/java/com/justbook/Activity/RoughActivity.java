package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.justbook.Adapter.GalleryAdapter;
import com.justbook.Adapter.HomeAdapter;
import com.justbook.Adapter.ReviewAdapetr;
import com.justbook.Adapter.ShowEventAdapter;

import com.justbook.Adapter.SliderAdapter;
import com.justbook.DataList.EventDataList;
import com.justbook.DataList.GalleryDataList;
import com.justbook.DataList.HomeDataList;
import com.justbook.DataList.ReviewDataList;
import com.justbook.DataList.SliderDataList;
import com.justbook.R;

import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;


import java.util.ArrayList;



public class RoughActivity extends AppCompatActivity {
    RecyclerView recycler_event;
    RecyclerView.LayoutManager layoutManager,layoutMangerSlider;
    ShowEventAdapter eventsAdapter;
    ArrayList<EventDataList> arrayListEvent =new ArrayList<>();
    ArrayList<SliderDataList> arrayListSlider=new ArrayList<>();
    SliderAdapterExample sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rough);

        recycler_event=findViewById(R.id.recycler_event);


        SliderView sliderView = findViewById(R.id.imageSlider);

        sliderAdapter = new SliderAdapterExample(this);
        sliderView.setSliderAdapter(sliderAdapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();




        layoutManager=new GridLayoutManager(getApplicationContext(),2,RecyclerView.VERTICAL,false);
        recycler_event.setLayoutManager(layoutManager);

        LayoutAnimationController animationController=AnimationUtils.loadLayoutAnimation(this, R.anim.layout_slide_from_bottom);
        recycler_event.setLayoutAnimation(animationController);
        recycler_event.scheduleLayoutAnimation();


        eventsAdapter=new ShowEventAdapter(getApplicationContext(),arrayListEvent);
        recycler_event.setAdapter(eventsAdapter);

        LinearSnapHelper snapHelperServices = new LinearSnapHelper();
        snapHelperServices.attachToRecyclerView(recycler_event);


        show_slider();


        show_events();



    }


    public  void show_events(){

        EventDataList eventDataList=new EventDataList(R.drawable.concert1,"23:00","Planeta Payner Club Plovdiv","0");

       // arrayListEvent.add(eventDataList);
        for (int i=0;i<12;i++){

            arrayListEvent.add(eventDataList);

        }


   }

    public  void show_slider(){
   // SliderAdapterExample sliderAdapterExample=new SliderAdapterExample(Context,arrayListSlider);


        }


    }

