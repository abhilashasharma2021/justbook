package com.justbook.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.google.gson.JsonObject;
import com.justbook.R;
import com.justbook.Utils.API;
import com.justbook.Utils.AppConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.media.MediaRecorder.VideoSource.CAMERA;

public class RegisteredActivity extends AppCompatActivity {
    TextView txt_SignIn, txt_SignUp;
    ImageView img_Back, img_date;
    TextView edt_Dob;
    CircleImageView profile_Img;
    Spinner spinner;
    File f;
    private static final String IMAGE_DIRECTORY = "/directory";
    private int GALLERY = 1, CAMERA = 2;
    Calendar c;
    DatePickerDialog datePickerDialog;
    ArrayList<String> citiesIdarray, citiesNamebgarray, citiesNameenarray;

    ProgressBar spin_kit;
    String selectedDate = "";
    String strName = "", strLast = "", strEmail = "", strPhone = "", strPassword = "", strDob = "", cityid = "", citiEnglishname = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        txt_SignIn = findViewById(R.id.txt_SignIn);
        spinner = findViewById(R.id.spinner);
        img_date = findViewById(R.id.img_date);
        edt_Dob = findViewById(R.id.edt_Dob);
        txt_SignUp = findViewById(R.id.txt_SignUp);
        profile_Img = findViewById(R.id.profile_Img);
        spin_kit = findViewById(R.id.spin_kit);

        AppConstants.sharedpreferences = getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
        strName = AppConstants.sharedpreferences.getString(AppConstants.USERNAME, "");
        strLast = AppConstants.sharedpreferences.getString(AppConstants.USERLASTNAME, "");
        strPhone = AppConstants.sharedpreferences.getString(AppConstants.USERPHONE, "");
        strEmail = AppConstants.sharedpreferences.getString(AppConstants.USEREMAIL, "");
        strPassword = AppConstants.sharedpreferences.getString(AppConstants.USERPASSWORD, "");

        Log.e("sdfhdkj", strName);
        Log.e("sdfhdkj", strLast);
        Log.e("sdfhdkj", strPhone);
        Log.e("sdfhdkj", strPassword);
        Log.e("sdfhdkj", strEmail);

        show_City();

        profile_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPictureDialog();
            }
        });

        txt_SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
            }
        });

        img_Back = findViewById(R.id.img_Back);
        img_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });


        //  img_date.setOnClickListener(this);


        img_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowCalendar();
            }
        });


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                citiEnglishname = citiesNameenarray.get(position);
                cityid = citiesIdarray.get(position);


             /*   if (position==0){

                  //  ( (TextView)parent.getChildAt(0)).setTextColor(getColor(R.color.black_color));
                   // ( (TextView)parent.getChildAt(0)).setText("Select City");
                }else {
                    citiEnglishname=citiesNameenarray.get(position);
                    cityid=citiesIdarray.get(position);

                    AppConstants.sharedpreferences=getSharedPreferences(AppConstants.MyPREFERENCES,Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=AppConstants.sharedpreferences.edit();
                    editor.putString(AppConstants.PLACEID,cityid);
                    editor.putString(AppConstants.CITYNAMEENGLISH,citiEnglishname);
                    editor.commit();


                    Toast.makeText(RegisteredActivity.this,citiEnglishname, Toast.LENGTH_SHORT).show();
                }

*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        txt_SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                strDob = edt_Dob.getText().toString().trim();


                if (citiEnglishname.equals("")) {

                    Toast.makeText(RegisteredActivity.this, "Please Enter City ", Toast.LENGTH_LONG).show();

                } else if (strDob.equals("")) {

                    Toast.makeText(RegisteredActivity.this, "Please Enter Date Of Birth", Toast.LENGTH_SHORT).show();

                } else {

                    register();

                }


                //startActivity(new Intent(getApplicationContext(),RegisteredActivity.class));
            }
        });

    }


    public void ShowCalendar() {
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
        // date picker dialog
        datePickerDialog = new DatePickerDialog(RegisteredActivity.this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        edt_Dob.setText(dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year);

                        selectedDate = dayOfMonth + "-"
                                + (monthOfYear + 1) + "-" + year;


                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }


    public void showPictureDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select ACtion");
        String[] pictureDialogItems = {"Select photo from gallery", "Capture image from camera"};

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
            Log.d("fvbcbv", "File Saved::---&gt;" + f.getAbsolutePath());

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }


    public void register() {
        spin_kit.setVisibility(View.VISIBLE);
        Sprite fadingCircle = new FadingCircle();
        spin_kit.setIndeterminateDrawable(fadingCircle);
        Log.e("fdfgjfdlk", strName);
        Log.e("fdfgjfdlk", strLast);
        Log.e("fdfgjfdlk", strEmail);
        Log.e("fdfgjfdlk", strPhone);
        Log.e("fdfgjfdlk", strPassword);
        Log.e("fdfgjfdlk", cityid);
        Log.e("fdfgjfdlk", selectedDate);
        Log.e("fdfgjfdlk", String.valueOf(f));

        AndroidNetworking.upload(API.BASEURL+API.register)
                .addMultipartParameter("name", strName)
                .addMultipartParameter("last_name", strLast)
                .addMultipartParameter("email", strEmail)
                .addMultipartParameter("phone", strPhone)
                .addMultipartParameter("password", strPassword)
                .addMultipartParameter("city_id", cityid)
                .addMultipartParameter("birthdate", selectedDate)
                .addMultipartFile("avatar", f)
                .setPriority(Priority.HIGH)
                .setTag("Please Wait..")
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.e("jdfsldkjgf", response.toString());

                        try {
                            if (response.getString("status").equals("success")) {

                                JSONObject jsonObject = response.getJSONObject("data");


                                String email = jsonObject.getString("email");
                                String birthdate = jsonObject.getString("birthdate");
                                String phone = jsonObject.getString("phone");
                                String name = jsonObject.getString("name");
                                String last_name = jsonObject.getString("last_name");
                                String userId = jsonObject.getString("id");
                                String image = jsonObject.getString("avatar");
                                String city_id = jsonObject.getString("city_id");


                                AppConstants.sharedpreferences = getSharedPreferences(AppConstants.MyPREFERENCES, Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = AppConstants.sharedpreferences.edit();
                                editor.putString(AppConstants.USEREMAIL, email);
                                editor.putString(AppConstants.USERNAME, name);
                                editor.putString(AppConstants.USERLASTNAME, last_name);
                                editor.putString(AppConstants.USERPHONE, phone);
                                editor.putString(AppConstants.USERIMAGE, image);
                                editor.putString(AppConstants.USERDOB, birthdate);
                                editor.putString(AppConstants.PLACEID, city_id);
                                editor.putString(AppConstants.USERID, userId);
                                editor.commit();


                                Log.e("fvjdgvhfjd", email);
                                Log.e("fvjdgvhfjd", birthdate);
                                Log.e("fvjdgvhfjd", phone);
                                Log.e("fvjdgvhfjd", name);
                                Log.e("fvjdgvhfjd", last_name);
                                Log.e("fvjdgvhfjd", userId);
                                Log.e("fvjdgvhfjd", image);
                                Log.e("fvjdgvhfjd", city_id);






                                startActivity(new Intent(RegisteredActivity.this, LogInActivity.class));
                                Toast.makeText(getApplicationContext(), response.getString("status"), Toast.LENGTH_LONG).show();
                                spin_kit.setVisibility(View.GONE);

                            }

                        } catch (JSONException e) {
                            Log.e("gffghghg", e.getMessage());
                            e.printStackTrace();
                            spin_kit.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("dsdsfgdfhds", anError.getMessage());
                        spin_kit.setVisibility(View.GONE);

                    }
                });


    }


    public void show_City() {
        AndroidNetworking.post("http://jb.clubisteria.com/api/getCityList")
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("dfhjvgfbl", response.toString());
                        citiesIdarray = new ArrayList<>();
                        citiesNameenarray = new ArrayList<>();
                        citiesNamebgarray = new ArrayList<>();
                        citiesNameenarray.add("Select City");
                        citiesNamebgarray.add("Select City");


                        try {
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject jsonObject = response.getJSONObject(i);

                                String cityId = jsonObject.getString("id");
                                String cityNameBg = jsonObject.getString("name_bg");
                                String cityNameen = jsonObject.getString("name_en");
                                String cityNamers = jsonObject.getString("name_ro");
                                String cityNameuk = jsonObject.getString("name_ua");

                                citiesIdarray.add(cityId);
                                citiesNamebgarray.add(cityNameBg);
                                citiesNameenarray.add(cityNameen);

                                /* data set on spinner*/

                                ArrayAdapter<String> adapter = new ArrayAdapter<>(RegisteredActivity.this, android.R.layout.simple_list_item_1, citiesNameenarray);
                                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                                spinner.setAdapter(adapter);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("fdvgfdfbl", e.getMessage());
                        }


                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("dfvgdffbl", anError.getMessage());
                    }
                });

    }

   /* @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        int currentMonth = month + 1;

        edt_Dob.setText(dayOfMonth + "/" + currentMonth + "/" + year);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.img_date:


                PickerDialog dialog = new PickerDialog();
                dialog.show(getSupportFragmentManager(), "Date Picker");

                break;
        }*/


}
