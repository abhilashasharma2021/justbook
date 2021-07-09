package com.justbook.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.justbook.Activity.SliderAdapterExample;
import com.justbook.Adapter.ShowEventAdapter;
import com.justbook.DataList.EventDataList;
import com.justbook.DataList.SliderDataList;
import com.justbook.R;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import devs.mulham.horizontalcalendar.adapter.EventsAdapter;


public class EventsFragment extends Fragment {

    RecyclerView recycler_event;
    RecyclerView.LayoutManager layoutManager;
    ShowEventAdapter eventsAdapter;
    ArrayList<EventDataList> arrayListEvent = new ArrayList<>();
   //ArrayList<SliderDataList> arrayListSlider = new ArrayList<>();
    SliderView sliderView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events, container, false);

        recycler_event = view.findViewById(R.id.recycler_event);

        SliderView sliderView =view. findViewById(R.id.imageSlider);

      //  SliderAdapterExample adapter = new SliderAdapterExample(getActivity());

       // sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();


        layoutManager = new GridLayoutManager(getActivity(), 2, RecyclerView.VERTICAL, false);
        recycler_event.setLayoutManager(layoutManager);

        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(getActivity(), R.anim.layout_slide_from_bottom);
        recycler_event.setLayoutAnimation(animationController);
        recycler_event.scheduleLayoutAnimation();


        eventsAdapter = new ShowEventAdapter(getActivity(), arrayListEvent);
        recycler_event.setAdapter(eventsAdapter);

        LinearSnapHelper snapHelperServices = new LinearSnapHelper();
        snapHelperServices.attachToRecyclerView(recycler_event);


        show_events();

        //show_slider();

        return view;
    }

    public void show_events() {

        EventDataList eventDataList = new EventDataList(R.drawable.concert1, "23:00", "Planeta Payner Club Plovdiv", "0");

        // arrayListEvent.add(eventDataList);
        for (int i = 0; i < 12; i++) {

            arrayListEvent.add(eventDataList);

        }
    }

   /* public void show_slider() {

        SliderDataList sliderDataList = new SliderDataList(R.drawable.concert1, "23:00", "Planeta Payner Club Plovdiv", "0");

        // arrayListEvent.add(eventDataList);
        for (int i = 0; i < 12; i++) {

            arrayListSlider.add(sliderDataList);
*/
        }



