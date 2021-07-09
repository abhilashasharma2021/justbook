package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.justbook.R;
import com.justbook.Utils.AppConstants;

import de.hdodenhof.circleimageview.CircleImageView;

public class SignUpActivity extends AppCompatActivity {
    TextView txt_SignIn,txt_next;
    ImageView img_Back;

    EditText edt_Name,edt_LastName,edt_Email,edt_Phone,edt_Password,edt_ConfrmPwd;

    String strName="",strLast="",strEmail="",strPhone="",strConfirm="",strPassword="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edt_Name=findViewById(R.id.edt_Name);
        edt_LastName=findViewById(R.id.edt_LastName);
        edt_Email=findViewById(R.id.edt_Email);
        edt_Phone=findViewById(R.id.edt_Phone);
        edt_Password=findViewById(R.id.edt_Password);
        edt_ConfrmPwd=findViewById(R.id.edt_ConfrmPwd);


        txt_next=findViewById(R.id.txt_next);
        txt_SignIn=findViewById(R.id.txt_SignIn);

        txt_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LogInActivity.class));
            }
        });
        img_Back=findViewById(R.id.img_Back);
        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),LogInActivity.class));
            }
        });



        txt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strName=edt_Name.getText().toString().trim();
                strLast=edt_LastName.getText().toString().trim();
                strEmail=edt_Email.getText().toString().trim();
                strPhone=edt_Phone.getText().toString().trim();
                strPassword=edt_Password.getText().toString().trim();
                strConfirm=edt_ConfrmPwd.getText().toString().trim();

                AppConstants.sharedpreferences=getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);

                SharedPreferences.Editor editor=AppConstants.sharedpreferences.edit();
                editor.putString(AppConstants.USERNAME,strName);
                editor.putString(AppConstants.USERLASTNAME,strLast);
                editor.putString(AppConstants.USERPHONE,strPhone);
                editor.putString(AppConstants.USERPASSWORD,strPassword);
                editor.putString(AppConstants.USEREMAIL,strEmail);
                 editor.commit();


                if (strName.equals("")){

                    Toast.makeText(SignUpActivity.this,"Please Enter Full Name",Toast.LENGTH_LONG).show();

                }
                else if (strLast.equals("")){

                    Toast.makeText(SignUpActivity.this,"Please Enter Last Name",Toast.LENGTH_LONG).show();

                }

                else if (strPhone.equals("")){

                    Toast.makeText(SignUpActivity.this,"Please Enter Phone Number",Toast.LENGTH_LONG).show();

                }

                else if (strPassword.equals("")){

                    Toast.makeText(SignUpActivity.this,"Please Enter Password",Toast.LENGTH_LONG).show();

                }

                else if (!strPassword.equals(strConfirm)){

                    Toast.makeText(SignUpActivity.this,"Password and Confirm Password Not Matched,Please Enter Correct Password",Toast.LENGTH_LONG).show();

                }

                else {

                    startActivity(new Intent(SignUpActivity.this,RegisteredActivity.class));
                }


            }
        });

    }
}
