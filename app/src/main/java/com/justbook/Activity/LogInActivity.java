package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.justbook.R;
import com.justbook.Utils.API;
import com.justbook.Utils.AppConstants;

import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends AppCompatActivity {
    TextView txt_SignIn, txt_SignUp, txt_Forgot;
    ImageView img_Back;
    ProgressBar spin_kit;
    EditText edt_Email, edt_Password;
    String strEmail = "", strPassword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        spin_kit = findViewById(R.id.spin_kit);
        txt_Forgot = findViewById(R.id.txt_Forgot);
        edt_Email = findViewById(R.id.edt_Email);

        edt_Password = findViewById(R.id.edt_Password);
        txt_SignIn = findViewById(R.id.txt_SignIn);
        txt_SignUp = findViewById(R.id.txt_SignUp);

        txt_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });


        txt_Forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
            }
        });

        img_Back = findViewById(R.id.img_Back);
        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        txt_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strEmail = edt_Email.getText().toString().trim();
                strPassword = edt_Password.getText().toString().trim();


                if (strEmail.equals("")) {

                    Toast.makeText(LogInActivity.this, "Please Enter Email Id", Toast.LENGTH_SHORT).show();
                } else if (strPassword.equals("")) {

                    Toast.makeText(LogInActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else {

                    login();
                }
            }
        });


    }


    public void login() {
        spin_kit.setVisibility(View.VISIBLE);
        Sprite fadingCircle = new FadingCircle();
        spin_kit.setIndeterminateDrawable(fadingCircle);

        Log.e("drfgfsjfi", strEmail);
        Log.e("drfgfsjfi", strPassword);
        AndroidNetworking.post(API.BASEURL+API.loginUser)
                .addBodyParameter("email", strEmail)
                .addBodyParameter("password", strPassword)
                .setPriority(Priority.HIGH)
                .setTag("Please wait")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("djfdsjfi", response.toString());
                        try {

                            if (response.getString("status").equals("success")) {
                                JSONObject jsonObject=response.getJSONObject("data");
                                String email=jsonObject.getString("email");
                                String phone=jsonObject.getString("phone");
                                String name=jsonObject.getString("name");
                                String last_name=jsonObject.getString("last_name");
                                String city_id=jsonObject.getString("city_id");
                                String id=jsonObject.getString("id");
                                String image=jsonObject.getString("avatar");
                                String birthdate=jsonObject.getString("birthdate");
                                String reservedresevation=jsonObject.getString("anonymous");


                                AppConstants.sharedpreferences=getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor=AppConstants.sharedpreferences.edit();
                                editor.putString(AppConstants.USEREMAIL,email);
                                editor.putString(AppConstants.USERNAME,name);
                                editor.putString(AppConstants.USERLASTNAME,last_name);
                                editor.putString(AppConstants.USERPHONE,phone);
                                editor.putString(AppConstants.USERIMAGE,image);
                                editor.putString(AppConstants.USERDOB,birthdate);
                                editor.putString(AppConstants.PLACEID,city_id);
                                editor.putString(AppConstants.USERID,id);
                                editor.putString(AppConstants.USERRESERVEDRESERVATION,reservedresevation);
                                editor.commit();


                                // Toast.makeText(LogInActivity.this, response.getString("status"), Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LogInActivity.this, BottomNavigationActivity.class));
                                spin_kit.setVisibility(View.GONE);
                            }

                            else{

                                Toast.makeText(LogInActivity.this, "Something went wrong, Please try again", Toast.LENGTH_SHORT).show();

                            }



                        }


                        catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("fdkjvlvj", e.getMessage());
                            spin_kit.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        spin_kit.setVisibility(View.GONE);
                        Log.e("fdsfdvj", anError.getMessage());
                    }
                });

    }

}
