package com.justbook.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.justbook.Activity.FavouritePlacesActivity;
import com.justbook.Activity.MainActivity;
import com.justbook.Activity.MessageActivity;
import com.justbook.Activity.OffersActivity;
import com.justbook.Activity.ProfileActivity;
import com.justbook.Activity.StarActivity;
import com.justbook.Activity.SubcategoryTablayoutActivity;
import com.justbook.R;
import com.justbook.Utils.AppConstants;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

RelativeLayout rl_star,rl_Message,rl_Subcategories,rl_Favroite,rl_offer,rl_logout;
CircleImageView profile_Img;
String strUserImage="",strFullName="",strLastName="";
TextView txt_userFullName;


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        rl_star=v.findViewById(R.id.rl_star);
        rl_Message=v.findViewById(R.id.rl_Message);
        rl_Subcategories=v.findViewById(R.id.rl_Subcategories);
        rl_Favroite=v.findViewById(R.id.rl_Favroite);
        rl_offer=v.findViewById(R.id.rl_offer);
        profile_Img=v.findViewById(R.id.profile_Img);
        rl_logout=v.findViewById(R.id.rl_logout);
        txt_userFullName=v.findViewById(R.id.txt_userFullName);



        profile_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ProfileActivity.class);
                startActivity(intent);
            }
        });


        rl_star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StarActivity.class);
                startActivity(intent);
            }
        });
        rl_offer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), OffersActivity.class);
                startActivity(intent);
            }
        });

        rl_Message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MessageActivity.class);
                startActivity(intent);
            }
        });


        rl_Subcategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SubcategoryTablayoutActivity.class);
                startActivity(intent);
            }
        });


        rl_Subcategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SubcategoryTablayoutActivity.class);
                startActivity(intent);
            }
        });

        rl_Favroite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), FavouritePlacesActivity.class);
                startActivity(intent);
            }
        });

        rl_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder alertDialog=new AlertDialog.Builder(getContext(),R.style.MyDialogTheme);
                alertDialog.setTitle("Logout ?");
                alertDialog.setMessage("Are you sure you want to logout ?");
                // Setting Icon to PopDialog
                alertDialog.setIcon(R.drawable.logout_90);
                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // sharedpreference-Data save in this activity
                        AppConstants.sharedpreferences = getContext().getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = AppConstants.sharedpreferences.edit();
                        //editor.putString(AppConstants.DRIVEREMAIL, "");
                        editor.commit();

                        Intent intent6 = new Intent(getContext(), MainActivity.class);
                        startActivity(intent6);

                    }
                });
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = alertDialog.create();

                // Finally, display the alert dialog
                dialog.show();

                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button negativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                positiveButton.setTextColor( Color.parseColor("#000000"));
                negativeButton.setTextColor(Color.parseColor("#000000"));





            }
        });














        return  v;
    }

    @Override
    public void onResume() {
        super.onResume();


        AppConstants.sharedpreferences=getActivity().getSharedPreferences(AppConstants.MyPREFERENCES,Context.MODE_PRIVATE);
        strUserImage=AppConstants.sharedpreferences.getString(AppConstants.USERIMAGE,"");
        strFullName=AppConstants.sharedpreferences.getString(AppConstants.USERFULLNAME,"");


        Log.e("dsajfhgdzuj",strUserImage);
        Log.e("dsajfhgdzuj",strFullName);
        txt_userFullName.setText(strFullName);

        Picasso.with(getActivity()).load(strUserImage).into(profile_Img);

    }
}

