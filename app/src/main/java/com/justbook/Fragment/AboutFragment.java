package com.justbook.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.justbook.R;
import com.justbook.Utils.AppConstants;

import java.util.ArrayList;


public class AboutFragment extends Fragment {

    ArrayList<String> arrayList;
    ArrayList<String> tofromList;

    TextView txt_workdayName, txt_typeName, txt_catName, txt_contact, txt_address, txt_web, txt_Description;
    String uyu = "";

    String newDays = "", finalDays = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        txt_workdayName = view.findViewById(R.id.txt_workdayName);
        txt_typeName = view.findViewById(R.id.txt_typeName);
        txt_catName = view.findViewById(R.id.txt_catName);
        txt_contact = view.findViewById(R.id.txt_contact);
        txt_address = view.findViewById(R.id.txt_address);
        txt_Description = view.findViewById(R.id.txt_Description);
        txt_web = view.findViewById(R.id.txt_web);
        AppConstants.sharedpreferences = getActivity().getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
        String strStartTime = AppConstants.sharedpreferences.getString(AppConstants.PlaceStartTime, "");
        String strPlaceEndTime = AppConstants.sharedpreferences.getString(AppConstants.PlaceEndTime, "");
        String strWeekDays = AppConstants.sharedpreferences.getString(AppConstants.WeekDays, "");
        String strPlaceName = AppConstants.sharedpreferences.getString(AppConstants.PLACENAME, "");
        String strPlaceAddress = AppConstants.sharedpreferences.getString(AppConstants.PLACEADDRESS, "");
        String strPlaceUrl = AppConstants.sharedpreferences.getString(AppConstants.PlaceUrl, "");
        String strPlacePhone = AppConstants.sharedpreferences.getString(AppConstants.PlacePhone, "");
        String strPlaceDescription = AppConstants.sharedpreferences.getString(AppConstants.PlaceDescription, "");

        txt_contact.setText(strPlacePhone);
        txt_web.setText(strPlaceUrl);
        txt_address.setText(strPlaceAddress);
        txt_Description.setError(strPlaceDescription);


        tofromList = new ArrayList<>();
        arrayList = new ArrayList<>();
        arrayList.add("hutt");
        arrayList.add("Mon");
        arrayList.add("Tues");
        arrayList.add("Wed");
        arrayList.add("Thurs");
        arrayList.add("Fri");
        arrayList.add("Sat");
        arrayList.add("Sun");

        Log.e("dfgdgf", arrayList.size() + "");

        Log.e("ewwerwsdfsd", strStartTime);
        Log.e("ewwerwsdfsd", strPlaceEndTime);
        Log.e("asdasdad", strWeekDays);


        if (strStartTime.equals("") || !strStartTime.equals(null)) {

            try {
                String[] strStartT = strStartTime.split(":");

                Log.e("hjbhjbhkj", strStartT.length + "");

                String strStartT1 = strStartT[0];
                String strStartT2 = strStartT[1];
                String strSplittedStartTime = strStartT1 + ":" + strStartT2;
                Log.e("asdasdad", strSplittedStartTime);
            } catch (Exception e) {
                e.printStackTrace();
            }

            /*Ek to ho gya*/
        }

        if (!strWeekDays.equals("") || !strWeekDays.equals(null)) {

            String[] strStartT = strWeekDays.split(",");


            for (int i = 0; i < strStartT.length; i++) {

                try {
                    tofromList.add(arrayList.get(Integer.parseInt(strStartT[i])));
                    uyu = arrayList.get(Integer.parseInt(strStartT[i]));

                    Log.e("dhjshgdhjs", uyu + ",");
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                txt_workdayName.setText(uyu + "," + arrayList.get(i));

            }


            for (String m : tofromList) {

                if ("".equals(newDays)) {

                    newDays = m;
                } else {

                    newDays = "," + m;

                }
                finalDays = finalDays + newDays;

            }

            Log.e("kjcjdsjc",finalDays);

            txt_workdayName.setText(finalDays);

            Log.e("asdasdad", strStartT.length + "");

            /*Ek to ho gya*/
        }


        if (tofromList.size() != 0) {

            String strTo = tofromList.get(0);
            String strFrom = tofromList.get(tofromList.size() - 1);

            Log.e("dfgjdhgdgf", strTo + " " + "To" + " " + strFrom);


            /*DONE= Enjoy the code :)))))*/

        }


        return view;
    }


}
