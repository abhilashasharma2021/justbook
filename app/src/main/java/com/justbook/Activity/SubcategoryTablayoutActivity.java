package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.justbook.Adapter.TablayoutAdapterSubcategory;
import com.justbook.R;

public class SubcategoryTablayoutActivity extends AppCompatActivity {
TabLayout tablayout;
ViewPager viewPager;
ImageView  img_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory_tablayout);
        tablayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewPager);
        viewPager=findViewById(R.id.viewPager);



        img_back=findViewById(R.id.img_back);

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


       tablayout.addTab(tablayout.newTab().setText("Bars"));
       tablayout.addTab(tablayout.newTab().setText("Clubs"));
       tablayout.addTab(tablayout.newTab().setText("Restaurants"));

       final TablayoutAdapterSubcategory tablayoutAdapterSubcategory=new TablayoutAdapterSubcategory(this.getSupportFragmentManager(),tablayout.getTabCount());

        viewPager.setAdapter(tablayoutAdapterSubcategory);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
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
