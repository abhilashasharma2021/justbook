package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.justbook.Adapter.TablayoytAdapterDescription;
import com.justbook.R;
import com.justbook.Utils.AppConstants;
import com.squareup.picasso.Picasso;

public class TablayoutDescriptionActivity extends AppCompatActivity {
TabLayout tabLayout,tabLayout1;
ViewPager viewPager;
TextView txt_Name,txt_StratTime,txt_EndTime,txt_Mobile,txt_Location,txt_Address;
ImageView img_Category;
RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_description);

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout1 = findViewById(R.id.tabLayout1);
        viewPager = findViewById(R.id.viewPager);
        txt_Name = findViewById(R.id.txt_Name);
        img_Category = findViewById(R.id.img_Category);
        txt_StratTime = findViewById(R.id.txt_StratTime);
        txt_EndTime = findViewById(R.id.txt_EndTime);
        txt_Mobile = findViewById(R.id.txt_Mobile);
        txt_Location = findViewById(R.id.txt_Location);
        txt_Address = findViewById(R.id.txt_Address);
        rating = findViewById(R.id.rating);


        AppConstants.sharedpreferences = getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
        String strStartTime = AppConstants.sharedpreferences.getString(AppConstants.PlaceStartTime, "");
        String strPlaceEndTime = AppConstants.sharedpreferences.getString(AppConstants.PlaceEndTime, "");
        String strPlaceName = AppConstants.sharedpreferences.getString(AppConstants.PLACENAME, "");
        String strPlaceAddress = AppConstants.sharedpreferences.getString(AppConstants.PLACEADDRESS, "");
        String strPlacePhone = AppConstants.sharedpreferences.getString(AppConstants.PlacePhone, "");
        String strPlaceImage = AppConstants.sharedpreferences.getString(AppConstants.PLACEIMAGE, "");
        String strPlaceLikes = AppConstants.sharedpreferences.getString(AppConstants.PlaceLikes, "");



        Log.e("jvhckvjclk",strStartTime);
        Log.e("jvhckvjclk",strPlaceEndTime);
        Log.e("jvhckvjclk",strPlaceName);
        Log.e("jvhckvjclk",strPlaceAddress);
        Log.e("jvhckvjclk",strPlacePhone);
        Log.e("jvhckvjclk",strPlaceImage);
        Log.e("jvhckvjclk",strPlaceLikes);

        Picasso.with(TablayoutDescriptionActivity.this).load(strPlaceImage).into(img_Category);
        txt_Name.setText(strPlaceName);
        txt_Address.setText(strPlaceAddress);
        txt_Location.setText(strPlaceAddress);
        txt_Mobile.setText(strPlacePhone);
        txt_StratTime.setText(strStartTime);
        txt_EndTime.setText(strPlaceEndTime);
        rating.setRating(Float.parseFloat(strPlaceLikes));








/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /*COLLAPSING TOOL BAR*/
        AppBarLayout appBarLayout = findViewById(R.id.app_bar);


        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
                {

                    //  Collapsed
                    Log.e("fgkfhgfg","Collapsed");
                    tabLayout1.setVisibility(View.VISIBLE);
                }
                else
                {
                    //Expanded
                    Log.e("fgkfhgfg","Expanded");
                    tabLayout1.setVisibility(View.GONE);
                }
            }
        });

////////////////////////////////////////////////////////////////////////////////////////
        tabLayout.addTab(tabLayout.newTab().setText("Booking"));
        tabLayout.addTab(tabLayout.newTab().setText("About"));
        tabLayout.addTab(tabLayout.newTab().setText("Gallery"));
        tabLayout.addTab(tabLayout.newTab().setText("Reviews"));

        tabLayout1.addTab(tabLayout1.newTab().setText(""));
        tabLayout1.addTab(tabLayout1.newTab().setText(""));
        tabLayout1.addTab(tabLayout1.newTab().setText(""));
        tabLayout1.addTab(tabLayout1.newTab().setText(""));




        final TablayoytAdapterDescription adapterTablayout = new TablayoytAdapterDescription(this.getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapterTablayout);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                Log.e("rtgfdgsd", tab.getPosition() + "");

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                Log.e("jkdshsd", tab.getPosition() + "");

                if (tab.getPosition() == 0) {


                } else {


                    //txt_Library.setVisibility(View.VISIBLE);
                   // TablayoutFragment.txt_Title.setVisibility(View.GONE);*/
                }



            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
