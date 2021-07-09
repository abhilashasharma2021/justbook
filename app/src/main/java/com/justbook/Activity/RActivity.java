package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.justbook.Adapter.BookingAdapter;
import com.justbook.DataList.BookingDataList;
import com.justbook.R;

import java.util.ArrayList;
import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class RActivity extends AppCompatActivity {

    private HorizontalCalendar horizontalCalendar;
    TextView txt_Month;
    RecyclerView recycler_Booking;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<BookingDataList> arrayListbookingDataLists=new ArrayList<>();
    BookingAdapter bookingAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r);
        txt_Month = findViewById(R.id.txt_Month);
        recycler_Booking =findViewById(R.id.recycler_Booking);
        recycler_Booking.setHasFixedSize(true);
        layoutManager=new GridLayoutManager(this,3, LinearLayoutManager.VERTICAL,false);
        recycler_Booking.setLayoutManager(layoutManager);

        bookingAdapter=new BookingAdapter(this,arrayListbookingDataLists);
        recycler_Booking.setAdapter(bookingAdapter);


        show_Booking();


        /* start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 11);

        horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(7)
                .configure()

                .formatMiddleText("dd")
                .formatBottomText("EEE")
                .textSize(12f, 18f, 12f)
                .showTopText(false)
                .showBottomText(true)
                .textColor(Color.BLACK, Color.WHITE)
                .end()
                .build();
///////////////////////
        Calendar calendar = Calendar.getInstance();
        //  Toast.makeText(getContext(), DateFormat.format("EEE, MMM d, yyyy", calendar) + " is selected!", Toast.LENGTH_SHORT).show();

        String currentString = (String) DateFormat.format("EEE, MMMM , yyyy", calendar);
        Log.e("kjhjkh", currentString);
        String[] separated = currentString.split(",");
        String day = separated[0].trim();
        String month = separated[1].trim();
        String year = separated[2].trim();
        Log.e("dsfjuh", day);
        Log.e("dsfjuh", month);
        Log.e("dsfjuh", year);

        txt_Month.setText(month + " " + year);
//////////////////////

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //  Toast.makeText(getContext(), DateFormat.format("EEE, MMM d, yyyy", date) + " is selected!", Toast.LENGTH_SHORT).show();

                String currentString = (String) DateFormat.format("EEE, MMMM , yyyy", date);
                Log.e("kjhjkh", currentString);
                String[] separated = currentString.split(",");
                String day = separated[0].trim();
                String month = separated[1].trim();
                String year = separated[2].trim();
                Log.e("dsfjuh", day);
                Log.e("dsfjuh", month);
                Log.e("dsfjuh", year);

                txt_Month.setText(month + " " + year);

            }

        });


    }

    public void show_Booking(){

        BookingDataList dataList=new BookingDataList("12:00");



        for (int i=0;i<20;i++){

            arrayListbookingDataLists.add(dataList);

        }

    }


    }

