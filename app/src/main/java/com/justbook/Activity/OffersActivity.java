package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.justbook.Adapter.OfferAdapterHorizontal;
import com.justbook.Adapter.OfferAdapterVertical;
import com.justbook.DataList.OfferDataListHorizontal;
import com.justbook.DataList.OfferDataListVertical;
import com.justbook.R;

import java.util.ArrayList;

public class OffersActivity extends AppCompatActivity {
  RecyclerView recycler_offer_hori,recycle_offer_vertical;
  RecyclerView.LayoutManager layoutManagerHori,layoutManagerVerti;
  OfferAdapterHorizontal offerAdapterHorizontal;
  OfferAdapterVertical offerAdapterVertical;
  ArrayList<OfferDataListHorizontal>arrayListOfferHori=new ArrayList<>();
  ArrayList<OfferDataListVertical>arrayListOfferVeri=new ArrayList<>();
  ImageView img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers);
        recycler_offer_hori=findViewById(R.id.recycler_offer_hori);
        recycle_offer_vertical=findViewById(R.id.recycle_offer_vertical);
        img_back=findViewById(R.id.img_back);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        layoutManagerHori=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recycler_offer_hori.setLayoutManager(layoutManagerHori);

        offerAdapterHorizontal=new OfferAdapterHorizontal(this,arrayListOfferHori);
        recycler_offer_hori.setAdapter(offerAdapterHorizontal);

        layoutManagerVerti=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recycle_offer_vertical.setLayoutManager(layoutManagerVerti);

         offerAdapterVertical=new OfferAdapterVertical(this,arrayListOfferVeri);
         recycle_offer_vertical.setAdapter(offerAdapterVertical);

        LinearSnapHelper snapHelperServices  = new LinearSnapHelper();
        snapHelperServices.attachToRecyclerView(recycler_offer_hori);
        show_HorizontalDetails();
        LinearSnapHelper snapHelperServices1  = new LinearSnapHelper();
        snapHelperServices1.attachToRecyclerView(recycle_offer_vertical);
        show_VerticalDetails();



    }

    public void show_HorizontalDetails(){
        OfferDataListHorizontal dataListHorizontal=new OfferDataListHorizontal(R.drawable.food,"-15%","15% discount from final bill","Bacon Bar &amp;Dinners");


        for (int i=0;i<15;i++){
            arrayListOfferHori.add(dataListHorizontal);

        }


    }



    public void show_VerticalDetails(){
        OfferDataListVertical dataListVertical=new OfferDataListVertical(R.drawable.circle_dish,R.drawable.food,"Planet Sofia","20% discount from final bill between 17:00 to 21:00","-20%");


        for (int i=0;i<15;i++){
            arrayListOfferVeri.add(dataListVertical);

        }


    }
}
