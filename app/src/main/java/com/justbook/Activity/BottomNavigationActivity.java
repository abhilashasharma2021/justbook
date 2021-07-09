package com.justbook.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.justbook.Fragment.CurrentBookingFragment;
import com.justbook.Fragment.EventsFragment;
import com.justbook.Fragment.GalleryFragment;
import com.justbook.Fragment.HomeFragment;
import com.justbook.Fragment.NotificationFragment;
import com.justbook.Fragment.ProfileFragment;
import com.justbook.R;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);

        BottomNavigationView bottomNav=findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

                break;

            case R.id.nav_Profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new GalleryFragment()).commit();

                      break;

            case R.id.nav_Notification:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new NotificationFragment()).commit();
                break;


            case R.id.nav_Events:

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new EventsFragment());

                break;

            case R.id.nav_Booking:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CurrentBookingFragment()).commit();
                break;
        }
        return true;
    }

}
