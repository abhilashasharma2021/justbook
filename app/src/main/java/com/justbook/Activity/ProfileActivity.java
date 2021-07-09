package com.justbook.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import com.bumptech.glide.Glide;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.justbook.R;
import com.justbook.Utils.API;
import com.justbook.Utils.AppConstants;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {
    ImageView img_back;
    File f;
    private static final String IMAGE_DIRECTORY = "/directory";
    private int GALLERY = 1, CAMERA = 2;
    Button btn_update;
    CircleImageView profile_Img;
    ProgressBar spin_kit;
    TextView txt_userFullName, txt_Name, txt_LastName, txt_Email, txt_cityName, txt_Dob;
    String strUserId = "";
    EditText et_Phone;
    String strName = "", strLast = "", strPhone = "", strDob = "", strEmail = "", strcityId = "", strCityName = "", strImage = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        img_back = findViewById(R.id.img_back);
        txt_userFullName = findViewById(R.id.txt_userFullName);
        txt_Name = findViewById(R.id.txt_Name);
        txt_LastName = findViewById(R.id.txt_LastName);
        txt_Email = findViewById(R.id.txt_Email);
        et_Phone = findViewById(R.id.et_Phone);
        txt_cityName = findViewById(R.id.txt_cityName);
        txt_Dob = findViewById(R.id.txt_Dob);
        btn_update = findViewById(R.id.btn_update);
        profile_Img = findViewById(R.id.profile_Img);


        spin_kit = findViewById(R.id.spin_kit);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        AppConstants.sharedpreferences = getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);

        strUserId = AppConstants.sharedpreferences.getString(AppConstants.USERID, "");
        strName = AppConstants.sharedpreferences.getString(AppConstants.USERNAME, "");
        strLast = AppConstants.sharedpreferences.getString(AppConstants.USERLASTNAME, "");
        strPhone = AppConstants.sharedpreferences.getString(AppConstants.USERPHONE, "");
        strDob = AppConstants.sharedpreferences.getString(AppConstants.USERDOB, "");
        strEmail = AppConstants.sharedpreferences.getString(AppConstants.USEREMAIL, "");
        strcityId = AppConstants.sharedpreferences.getString(AppConstants.PLACEID, "");
        strImage = AppConstants.sharedpreferences.getString(AppConstants.USERIMAGE, "");
        strCityName = AppConstants.sharedpreferences.getString(AppConstants.PLACENAME, "");


        Log.e("dsjhdfsf", strUserId);
        Log.e("dsjhdfsf", strName);
        Log.e("dsjhdfsf", strLast);
        Log.e("dsjhdfsf", strUserId);
        Log.e("dsjhdfsf", strPhone);
        Log.e("dsjhdfsf", strDob);
        Log.e("dsjhdfsf", strEmail);
        Log.e("dsjhdfsf", strImage);
        Log.e("dsjhdfsf", strcityId);


        txt_Name.setText(strName);
        txt_LastName.setText(strLast);
        txt_Email.setText(strEmail);
        et_Phone.setText(strPhone);
        txt_Dob.setText(strDob);
        txt_cityName.setText(strCityName);

        String strFullName = strName + strLast;
        AppConstants.sharedpreferences = getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = AppConstants.sharedpreferences.edit();
        editor.putString(AppConstants.USERFULLNAME, strFullName);
        editor.commit();


        txt_userFullName.setText(strFullName);

        Glide.with(ProfileActivity.this).load(strImage)
                .into(profile_Img);


        // Glide.with(ProfileActivity.this).load(strImage).into(profile_Img);
        // Picasso.with(getApplicationContext()).load(strImage).into(profile_Img);


        profile_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPictureDialog();

            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                strPhone = et_Phone.getText().toString().trim();


                update_profile(strUserId, strPhone);
            }
        });

    }


    /////////*PROFILE IMAGE UPLOAD WORK IN FRAGMENT*//////////
    public void showPictureDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select ACtion");
        String[] pictureDialogItems = {"Choose from Gallery", "Take Photo", "Cancel"};

        builder.setItems(pictureDialogItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                switch (which) {

                    case 0:
                        choosePhotoFromGallery();
                        break;

                    case 1:
                        captureFromCamera();
                        break;
                }

            }
        });

        builder.show();
    }


    public void choosePhotoFromGallery() {

        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(intent, GALLERY);
    }


    public void captureFromCamera() {

        Intent intent_2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent_2, CAMERA);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    String path = saveImage(bitmap);
                    Toast.makeText(getApplicationContext(), "Image Saved!", Toast.LENGTH_SHORT).show();
                    profile_Img.setImageBitmap(bitmap);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
            profile_Img.setImageBitmap(thumbnail);
            saveImage(thumbnail);
            Toast.makeText(getApplicationContext(), "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }

    public String saveImage(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File wallpaperDirectory = new File(
                Environment.getExternalStorageDirectory() + IMAGE_DIRECTORY);

        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            f = new File(wallpaperDirectory, Calendar.getInstance()
                    .getTimeInMillis() + ".jpg");
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(getApplicationContext(),
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();
            Log.d("TAG", "File Saved::---&gt;" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    public void update_profile(String userID, String stPhone) {

        spin_kit.setVisibility(View.VISIBLE);
        Sprite fadingCircle = new FadingCircle();
        spin_kit.setIndeterminateDrawable(fadingCircle);

        Log.e("fgkdgfghg", userID);
        AndroidNetworking.upload(API.BASEURL + API.update_userprofile)
                .addMultipartParameter("id", userID)
                .addMultipartParameter("phone", stPhone)
                .addMultipartFile("avatar", f)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {


                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("jskdhefdjkh", response.toString());


                        try {

                            if (response.getString("status").equals("success")) {


                                JSONObject jsonObject = response.getJSONObject("data");
                                String id = jsonObject.getString("id");
                                String phone = jsonObject.getString("phone");
                                String image = jsonObject.getString("avatar");
                                String reservation = jsonObject.getString("anonymous");

                                Log.e("fjdhgvdkjv", image);
                                Log.e("fjdhgvdkjv", phone);
                                Log.e("fjdhgvdkjv", reservation);

                                AppConstants.sharedpreferences = getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = AppConstants.sharedpreferences.edit();
                                editor.putString(AppConstants.USERPHONE, phone);
                                editor.putString(AppConstants.USERIMAGE, image);
                                editor.commit();

                                et_Phone.setText(phone);

                                Picasso.with(ProfileActivity.this).load(image).into(profile_Img);


                                Toast.makeText(ProfileActivity.this, response.getString("status"), Toast.LENGTH_SHORT).show();


                                startActivity(new Intent(ProfileActivity.this, BottomNavigationActivity.class));
                                spin_kit.setVisibility(View.GONE);

                            } else {

                                Toast.makeText(ProfileActivity.this, response.getString("status"), Toast.LENGTH_SHORT).show();

                                spin_kit.setVisibility(View.GONE);
                            }
                        } catch (JSONException e) {
                            Log.e("sdjfhdjskh", e.getMessage());
                            spin_kit.setVisibility(View.GONE);
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        spin_kit.setVisibility(View.GONE);
                        Log.e("dfsjhfdzgj", anError.getMessage());
                    }
                });


    }


}
