package com.justbook.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.justbook.DataList.CustomizeSpinnerDataList;

public class CustomizeSpinnerAdapter  extends ArrayAdapter<CustomizeSpinnerDataList> {





    public CustomizeSpinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
