package com.justbook.Fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.JsonObject;
import com.justbook.Activity.LogInActivity;
import com.justbook.Activity.PickerDialog;
import com.justbook.Activity.RegisteredActivity;
import com.justbook.Adapter.HomeAdapter;
import com.justbook.DataList.HomeDataList;
import com.justbook.R;
import com.justbook.Utils.API;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recycler_Home;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<HomeDataList> arrayListHome = new ArrayList<>();
    HomeAdapter homeAdapter;
    LinearLayout ll_headtool, ll_head;
    Spinner spinner, spinner_placetype, spinner_guestNum;
    String[] item = {"BG", "EN"};
    TextView txt_selectdate, txt_selecttime;
    String strpickedDate, strTimeselect;
    ImageView location, img_date;
    Button btn_search;
    Toolbar toolbar_collapsing;
    ProgressBar spin_kit;
    String strSelectedLanguage = "";
    ImageView img_time;
    RelativeLayout rl_bar, rl_Restro, rl_Club;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterGuests;
    ArrayAdapter<String> adapterPlace;
    ArrayList<String> arrayListGuestNum;
    String strCategory = "", strGuestPosition = "";

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        AppBarLayout appBarLayout = view.findViewById(R.id.app_bar);
        ll_headtool = view.findViewById(R.id.ll_headtool);
        ll_head = view.findViewById(R.id.ll_head);
        spinner = view.findViewById(R.id.spinner);
        location = view.findViewById(R.id.location);
        btn_search = view.findViewById(R.id.btn_search);
        toolbar_collapsing = view.findViewById(R.id.toolbar_collapsing);
        txt_selectdate = view.findViewById(R.id.txt_selectdate);
        img_date = view.findViewById(R.id.img_date);
        img_time = view.findViewById(R.id.img_time);
        rl_bar = view.findViewById(R.id.rl_bar);
        rl_Club = view.findViewById(R.id.rl_Club);
        rl_Restro = view.findViewById(R.id.rl_Restro);


        txt_selecttime = view.findViewById(R.id.txt_selecttime);

        spin_kit = view.findViewById(R.id.spin_kit);
        spinner_placetype = view.findViewById(R.id.spinner_placetype);
        spinner_guestNum = view.findViewById(R.id.spinner_guestNum);


        recycler_Home = view.findViewById(R.id.recycler_Home);
        recycler_Home.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        recycler_Home.setLayoutManager(layoutManager);


        LinearSnapHelper snapHelperServices = new LinearSnapHelper();
        snapHelperServices.attachToRecyclerView(recycler_Home);

        home_Data_All();
        guestList();

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "check it now", Toast.LENGTH_SHORT).show();
            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search_place();
                // Toast.makeText(getActivity(), "checked", Toast.LENGTH_SHORT).show();
            }
        });

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        rl_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                strCategory = "1";

                home_Data_catvise();


                // Toast.makeText(getActivity(), "cat bar", Toast.LENGTH_SHORT).show();
            }
        });


        rl_Club.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strCategory = "2";
                home_Data_catvise();

                //  Toast.makeText(getActivity(), "cat club", Toast.LENGTH_SHORT).show();
            }
        });


        rl_Restro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strCategory = "3";
                home_Data_catvise();
                //  Toast.makeText(getActivity(), "cat rest", Toast.LENGTH_SHORT).show();
            }
        });


        //////////////////////////////////////*Date/ Calandre picker in android---past date hide*///////////////////////////////////////////////////////


        img_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar c = Calendar.getInstance();
                DatePickerDialog dialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String _year = String.valueOf(year);
                        String _month = (month + 1) < 10 ? "0" + (month + 1) : String.valueOf(month + 1);
                        String _date = dayOfMonth < 10 ? "0" + dayOfMonth : String.valueOf(dayOfMonth);
                        strpickedDate = year + "-" + month + "-" + _date;
                        Log.e("strpickedDate: ", "Date: " + _year + "-" + _month + "-" + _date); //2019-02-12
                        txt_selectdate.setText(_date + "-" + _month + "-" + _year);


                    }
                },
                        c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.MONTH));
                dialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                dialog.show();


            }
        });
/////////////////// ///////*Time Picker in android*//////////////////////////////////////////////////////////////

        img_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        txt_selecttime.setText(selectedHour + ":" + selectedMinute);

                        strTimeselect = selectedHour + ":" + selectedMinute;

                        Log.e("jvhcxjvkhc", strTimeselect);

                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });

//////////////////////////////////*PLACE TYPE SET SPINNER*////////////////////////////////////////////


        List<String> list = new ArrayList<String>();
        list.add("Place Type");
        list.add("Bar");
        list.add("Club");
        list.add("Resturant");


        adapterPlace = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        adapterPlace.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_placetype.setAdapter(adapterPlace);

        spinner_placetype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                String strPlaceSelect = adapterPlace.getItem(i);

                if (strPlaceSelect.equals("Place Type")) {
                    strCategory = "0";

                } else if (strPlaceSelect.equals("Bar")) {

                    strCategory = "1";
                    place_type();
                    home_Data_catvise();
                } else if (strPlaceSelect.equals("Club")) {
                    strCategory = "2";
                    home_Data_catvise();
                    place_type();

                } else {

                    strCategory = "3";
                    home_Data_catvise();
                    place_type();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
///////////////////////////////////////////////////////////////////////////////////////////////////////////

        /*SPinner work to show guest list*/


        spinner_guestNum.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                strGuestPosition = arrayListGuestNum.get(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ///////////////////////*Static data set  LANGUAGE on spinner*/////////////////////////////////////////////

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String strMyLangSelect = adapter.getItem(i);

                Log.e("djfnjvn", strMyLangSelect);

                if (strMyLangSelect.equals("EN")) {

                    strSelectedLanguage = "2";
                    home_Data_All();

                    Toast.makeText(getActivity(), strMyLangSelect, Toast.LENGTH_SHORT).show();


                } else if (strMyLangSelect.equals("BG")) {
                    Toast.makeText(getActivity(), strMyLangSelect, Toast.LENGTH_SHORT).show();

                    strSelectedLanguage = "1";
                    home_Data_All();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

///////////////////////////////*  collapsing toolbar*////////////////////////////////////////////////////////////////
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

                if (Math.abs(verticalOffset) - appBarLayout.getTotalScrollRange() == 0) {

                    //  Collapsed
                    Log.e("fgkfhgfg", "Collapsed");
                    toolbar_collapsing.setVisibility(View.VISIBLE);
                } else {
                    //Expanded
                    Log.e("fgkfhgfg", "Expanded");
                    toolbar_collapsing.setVisibility(View.GONE);
                }
            }
        });


///////////////////////////////////////////////////////////////////////////////////////////////////////
        return view;
    }

    public void home_Data_All() {
        spin_kit.setVisibility(View.VISIBLE);
        Sprite circle = new Circle();
        spin_kit.setIndeterminateDrawable(circle);


        AndroidNetworking.post("http://jb.clubisteria.com/api/getHomePageListing")

                .addBodyParameter("locale", strSelectedLanguage)
                .setTag("Please Wait")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("dfcjkdjv", response.toString());

                        arrayListHome = new ArrayList<>();

                        try {
                            if (response.getString("status").equals("success")) {


                                JSONObject jsonObject = response.getJSONObject("data");
                                String places = jsonObject.getString("places");


                                JSONArray jsonArray = new JSONArray(places);

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String id = jsonObject1.getString("id");
                                    String likes = jsonObject1.getString("likes");
                                    String name = jsonObject1.getString("name");
                                    String desc = jsonObject1.getString("desc");
                                    String address = jsonObject1.getString("address");
                                    String square_image = jsonObject1.getString("square_image");
                                    String profile_image = jsonObject1.getString("profile_image");
                                    String votes = jsonObject1.getString("votes");
                                    String phone = jsonObject1.getString("phone");
                                    String work_time_start = jsonObject1.getString("work_time_start");
                                    String work_time_end = jsonObject1.getString("work_time_end");
                                    String work_days = jsonObject1.getString("work_days");
                                    String url = jsonObject1.getString("url");


                                    HomeDataList homeDataList = new HomeDataList();
                                    homeDataList.setImg_items(jsonObject1.getString("profile_image"));
                                    homeDataList.setSquare_image(jsonObject1.getString("square_image"));
                                    homeDataList.setTxt_Name(jsonObject1.getString("name"));
                                    homeDataList.setTxt_Address(jsonObject1.getString("address"));
                                    homeDataList.setLikes(jsonObject1.getString("likes"));
                                    homeDataList.setDescription(jsonObject1.getString("desc"));
                                    homeDataList.setPhone(jsonObject1.getString("phone"));
                                    homeDataList.setVotes(jsonObject1.getString("votes"));
                                    homeDataList.setWork_time_start(jsonObject1.getString("work_time_start"));
                                    homeDataList.setWork_time_end(jsonObject1.getString("work_time_end"));
                                    homeDataList.setWork_days(jsonObject1.getString("work_days"));


                                    arrayListHome.add(homeDataList);

                                }


                            }

                            homeAdapter = new HomeAdapter(getContext(), arrayListHome);
                            recycler_Home.setAdapter(homeAdapter);

                            LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_fall_down);
                            recycler_Home.setLayoutAnimation(animationController);
                            recycler_Home.scheduleLayoutAnimation();

                            spin_kit.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("dsfndlkjv", e.getMessage());
                            spin_kit.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        spin_kit.setVisibility(View.GONE);
                        Log.e("dffffdkjv", anError.getMessage());
                    }
                });

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public void home_Data_catvise() {
        spin_kit.setVisibility(View.VISIBLE);
        Sprite circle = new Circle();
        spin_kit.setIndeterminateDrawable(circle);


        // AndroidNetworking.post("http://jb.clubisteria.com/api/getHomePageListing")
        AndroidNetworking.post(API.BASEURL + API.getHomePageListing)
                .addBodyParameter("cats", strCategory)
                .addBodyParameter("locale", strSelectedLanguage)
                .setTag("Please Wait")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("dfcjkdjv", response.toString());

                        arrayListHome = new ArrayList<>();

                        try {
                            if (response.getString("status").equals("success")) {


                                JSONObject jsonObject = response.getJSONObject("data");
                                String places = jsonObject.getString("places");


                                JSONArray jsonArray = new JSONArray(places);

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                                    String id = jsonObject1.getString("id");
                                    String likes = jsonObject1.getString("likes");
                                    String name = jsonObject1.getString("name");
                                    String desc = jsonObject1.getString("desc");
                                    String address = jsonObject1.getString("address");
                                    String square_image = jsonObject1.getString("square_image");
                                    String profile_image = jsonObject1.getString("profile_image");
                                    String votes = jsonObject1.getString("votes");
                                    String phone = jsonObject1.getString("phone");
                                    String work_time_start = jsonObject1.getString("work_time_start");
                                    String work_time_end = jsonObject1.getString("work_time_end");
                                    String work_days = jsonObject1.getString("work_days");
                                    String url = jsonObject1.getString("url");


                                    HomeDataList homeDataList = new HomeDataList();
                                    homeDataList.setImg_items(jsonObject1.getString("profile_image"));
                                    homeDataList.setSquare_image(jsonObject1.getString("square_image"));
                                    homeDataList.setTxt_Name(jsonObject1.getString("name"));
                                    homeDataList.setTxt_Address(jsonObject1.getString("address"));
                                    homeDataList.setLikes(jsonObject1.getString("likes"));
                                    homeDataList.setDescription(jsonObject1.getString("desc"));
                                    homeDataList.setPhone(jsonObject1.getString("phone"));
                                    homeDataList.setVotes(jsonObject1.getString("votes"));
                                    homeDataList.setWork_time_start(jsonObject1.getString("work_time_start"));
                                    homeDataList.setWork_time_end(jsonObject1.getString("work_time_end"));
                                    homeDataList.setWork_days(jsonObject1.getString("work_days"));


                                    arrayListHome.add(homeDataList);

                                }


                            }

                            homeAdapter = new HomeAdapter(getContext(), arrayListHome);
                            recycler_Home.setAdapter(homeAdapter);

                            LayoutAnimationController animationController = AnimationUtils.loadLayoutAnimation(getContext(), R.anim.layout_animation_fall_down);
                            recycler_Home.setLayoutAnimation(animationController);
                            recycler_Home.scheduleLayoutAnimation();

                            spin_kit.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("dsfndlkjv", e.getMessage());
                            spin_kit.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        spin_kit.setVisibility(View.GONE);
                        Log.e("dffffdkjv", anError.getMessage());
                    }
                });

    }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void place_type() {

        spin_kit.setVisibility(View.VISIBLE);
        Sprite circle = new Circle();
        spin_kit.setIndeterminateDrawable(circle);

        Log.e("vcbcjxkvncjk", strCategory);
        Log.e("vcbcjxkvncjk", strSelectedLanguage);

        //   AndroidNetworking.post("http://jb.clubisteria.com/api/get_category_product")
        AndroidNetworking.post(API.BASEURL + API.get_category_product)
                .addBodyParameter("cats", strCategory)
                .addBodyParameter("locale", strSelectedLanguage)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("kcxjvckvj", response.toString());

                        try {
                            if (response.getString("status").equals("success")) {

                                JSONObject jsonObject = response.getJSONObject("data");
                                String places = jsonObject.getString("places");

                                JSONArray jsonArray = jsonObject.getJSONArray(places);

                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);


                                    String id = jsonObject1.getString("id");

                                    Toast.makeText(getActivity(), response.getString("status"), Toast.LENGTH_SHORT).show();

                                    spin_kit.setVisibility(View.GONE);


                                }


                            }
                        } catch (JSONException e) {
                            Log.e("hdgcxhjg", e.getMessage());
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("gfhgjgh", anError.getMessage());
                        spin_kit.setVisibility(View.GONE);
                    }
                });


    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void search_place() {

        spin_kit.setVisibility(View.VISIBLE);
        Sprite circle = new Circle();
        spin_kit.setIndeterminateDrawable(circle);

        Log.e("retryryk", strCategory);
        Log.e("retryryk", strSelectedLanguage);
        Log.e("retryryk", strpickedDate);
        Log.e("retryryk", strTimeselect);


        //  AndroidNetworking.post("http://jb.clubisteria.com/api/get_category_product")
        AndroidNetworking.post(API.BASEURL + API.get_category_product)
                .addBodyParameter("cats", strCategory)
                .addBodyParameter("locale", strSelectedLanguage)
                .addBodyParameter("date", strpickedDate)
                .addBodyParameter("time", strTimeselect)

                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.e("jfdjvgldvij", response.toString());

                        try {
                            if (response.getString("status").equals("success")) ;

                            Toast.makeText(getActivity(), response.getString("status"), Toast.LENGTH_SHORT).show();
                            spin_kit.setVisibility(View.GONE);
                        } catch (JSONException e) {
                            spin_kit.setVisibility(View.GONE);
                            Log.e("dfhjdgv", e.getMessage());
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        spin_kit.setVisibility(View.GONE);
                        Log.e("dfdsfcv", anError.getMessage());
                    }
                });


    }


    public void guestList() {


       // AndroidNetworking.post("http://jb.clubisteria.com/api/guest_noList")
        AndroidNetworking.post(API.BASEURL+API.guest_noList)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.e("dckcjkxc", response.toString());


                        arrayListGuestNum = new ArrayList<>();
                        arrayListGuestNum.add("Select Guest");


                        try {
                            if (response.getString("status").equals("success")) {

                                String data = response.getString("data");

                                Log.e("chjhjdhc",data);

                                JSONArray jsonArray = new JSONArray(data);

                                for (int i = 0; i < jsonArray.length(); i++) {

                                    JSONObject jsonObject=jsonArray.getJSONObject(i);

                                    String list= jsonObject.getString("list");

                                    Log.e("dkjfkdj",list);

                                    arrayListGuestNum.add(list);


                                    adapterGuests = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayListGuestNum);
                                    adapterGuests.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                    spinner_guestNum.setAdapter(adapterGuests);

                                }


                            }


                        } catch (Exception e) {

                            e.printStackTrace();
                            Log.e("fdvgfdfbl", e.getMessage());


                        }


                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });


    }


}
