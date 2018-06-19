package com.avast.re.reauth;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.widget.TextView;

public class DataBindingUtils {
    @BindingAdapter("android:text")
    public static void setInt(TextView view, int value) {
        view.setText(String.valueOf(value));
    }

    @InverseBindingAdapter(attribute = "android:text")
    public static float getInt(TextView view) {
        return Integer.parseInt(view.getText().toString());
    }
}