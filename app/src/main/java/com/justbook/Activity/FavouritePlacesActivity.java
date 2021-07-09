package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;

import com.justbook.Adapter.FavouritePlaceAdapter;
import com.justbook.DataList.FavouritePlaceDataList;
import com.justbook.R;

import java.util.ArrayList;

public class FavouritePlacesActivity extends AppCompatActivity {


    RecyclerView recycler_favourite;
    FavouritePlaceAdapter favouritePlaceAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<FavouritePlaceDataList> arrayListFavourite = new ArrayList<>();
    ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite_places);



        img_back=findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recycler_favourite = findViewById(R.id.recycler_favourite);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler_favourite.setLayoutManager(layoutManager);

        favouritePlaceAdapter = new FavouritePlaceAdapter(getApplicationContext(), arrayListFavourite);

        recycler_favourite.setAdapter(favouritePlaceAdapter);


        LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_slide_from_bottom);

        recycler_favourite.setLayoutAnimation(animationController);
        recycler_favourite.scheduleLayoutAnimation();

        LinearSnapHelper snapHelperServices = new LinearSnapHelper();
        snapHelperServices.attachToRecyclerView(recycler_favourite);

        show_places();

    }

    public void show_places() {


        FavouritePlaceDataList dataList = new FavouritePlaceDataList(R.drawable.mic, "KOTO", "6, Tsar Kaloyan str, Sofua", "11:30-22:30");

        for (int i = 0; i < 12; i++) {
            arrayListFavourite.add(dataList);

        }
    }
}
