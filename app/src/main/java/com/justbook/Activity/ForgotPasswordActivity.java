package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.github.ybq.android.spinkit.sprite.CircleSprite;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.google.android.material.textfield.TextInputEditText;
import com.justbook.R;
import com.justbook.Utils.AppConstants;

import org.json.JSONException;
import org.json.JSONObject;

public class ForgotPasswordActivity extends AppCompatActivity {
ImageView img_Back;
TextInputEditText edt_Email;
String strEmail="";
TextView txt_forgot;
ProgressBar spin_kit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        img_Back=findViewById(R.id.img_Back);
        edt_Email=findViewById(R.id.edt_Email);
        spin_kit=findViewById(R.id.spin_kit);
        txt_forgot=findViewById(R.id.txt_forgot);
        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LogInActivity.class));
            }
        });


        txt_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              strEmail=edt_Email.getText().toString().trim();

              if (strEmail.equals("")){
                  Toast.makeText(ForgotPasswordActivity.this,"Please Enter Valid Email Id",Toast.LENGTH_SHORT).show();

              }
              else{

                 forgot();
              }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


        AppConstants.sharedpreferences=this.getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
       strEmail=AppConstants.sharedpreferences.getString(AppConstants.USEREMAIL,"");
       Log.e("fkjvlkcxkv",strEmail);

    }

    public void forgot() {
       spin_kit.setVisibility(View.VISIBLE);
       Sprite circleSprite=new CircleSprite();
       spin_kit.setIndeterminateDrawable(circleSprite);

       Log.e("cvchjcj",strEmail);
       AndroidNetworking.post("http://jb.clubisteria.com/api/forgot_password")
               .addBodyParameter("email",strEmail)
               .setPriority(Priority.HIGH)
               .build()
               .getAsJSONObject(new JSONObjectRequestListener() {
                   @Override
                   public void onResponse(JSONObject response) {
                       Log.e("kdljfvdk",response.toString());

                       try {
                           if (response.getString("status").equals("success")){


                               //Toast.makeText(ForgotPasswordActivity.this,response.getString("status"),Toast.LENGTH_SHORT).show();
                               startActivity(new Intent(ForgotPasswordActivity.this,LogInActivity.class));
                                 spin_kit.setVisibility(View.GONE);
                           }


                           else {

                               Toast.makeText(ForgotPasswordActivity.this,"Something went wrong",Toast.LENGTH_SHORT).show();
                               spin_kit.setVisibility(View.GONE);
                           }
                       } catch (JSONException e) {
                           spin_kit.setVisibility(View.GONE);
                           Log.e("dfjskfhjdk",e.getMessage());
                       }


                   }

                   @Override
                   public void onError(ANError anError) {
                       Log.e("bdfhgdkj",anError.getMessage());
                       spin_kit.setVisibility(View.GONE);
                   }
               });

   }



}
