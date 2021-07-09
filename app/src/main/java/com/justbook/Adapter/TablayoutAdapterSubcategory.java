package com.justbook.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.justbook.Fragment.BarsFragment;
import com.justbook.Fragment.ClubFragment;
import com.justbook.Fragment.RestaurantFragment;

public class TablayoutAdapterSubcategory extends FragmentStatePagerAdapter {
    int mNumOfTabs;



    public TablayoutAdapterSubcategory(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs=NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){

            case 0:

                BarsFragment barsFragment=new BarsFragment();
                return  barsFragment;

            case 1:
                ClubFragment clubFragment=new ClubFragment();
                return  clubFragment;

            case 2:
                RestaurantFragment restaurantFragment=new RestaurantFragment();
                return restaurantFragment;

        }


        return null;
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
