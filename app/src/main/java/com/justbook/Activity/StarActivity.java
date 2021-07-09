package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

import com.justbook.Adapter.StarsAdapter;
import com.justbook.DataList.StarDataList;
import com.justbook.R;

import java.util.ArrayList;

public class StarActivity extends AppCompatActivity {

    RecyclerView recycler_star;
    RecyclerView.LayoutManager layoutManager;
    StarsAdapter starsAdapter;
    ArrayList<StarDataList>arrayListstar=new ArrayList<>();
   ImageView img_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star);

        recycler_star=findViewById(R.id.recycler_star);
        img_back=findViewById(R.id.img_back);
        layoutManager=new GridLayoutManager(getApplicationContext(),2,RecyclerView.VERTICAL,false);
        recycler_star.setLayoutManager(layoutManager);

        starsAdapter=new StarsAdapter(getApplicationContext(),arrayListstar);
        recycler_star.setAdapter(starsAdapter);

        LayoutAnimationController layoutAnimationController= AnimationUtils.loadLayoutAnimation(getApplicationContext(),R.anim.layout_animation_fall_down);
        recycler_star.setLayoutAnimation(layoutAnimationController);
        recycler_star.scheduleLayoutAnimation();

        LinearSnapHelper snapHelperServices = new LinearSnapHelper();
        snapHelperServices.attachToRecyclerView(recycler_star);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        show_Star();


    }

    public void show_Star(){

        StarDataList starDataList=new StarDataList("555","Shurti singer",R.drawable.mic);

        for (int i=0;i<15;i++){

            arrayListstar.add(starDataList);

        }

    }
}
