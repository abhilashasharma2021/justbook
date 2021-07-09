package com.justbook.Adapter;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.justbook.Fragment.AboutFragment;
import com.justbook.Fragment.BookingFragment;
import com.justbook.Fragment.GalleryFragment;
import com.justbook.Fragment.ReviewsFragment;

public class TablayoytAdapterDescription extends FragmentStatePagerAdapter {
    TablayoytAdapterDescription  adapterTablayout;
    int mNumOfTabs;




    public TablayoytAdapterDescription(@NonNull FragmentManager fm, int NumOfTabs) {
        super( fm );
        this.mNumOfTabs = NumOfTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                Log.e("fgdfgdfgdg","One");
                BookingFragment bookingFragment=new BookingFragment();
                return bookingFragment;

            case 1:
                Log.e("fgdfgdfgdg","Two");
                AboutFragment aboutFragment=new AboutFragment();

                return aboutFragment;
            case 2:
                Log.e("fgdfgdfgdg","Two");
                GalleryFragment galleryFragment=new GalleryFragment();

                return galleryFragment;
            case 3:
                Log.e("fgdfgdfgdg","Two");
                ReviewsFragment reviewsFragment=new ReviewsFragment();

                return reviewsFragment;



        }
        return null;

    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
