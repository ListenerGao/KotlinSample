package com.listenergao.base.utils;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Toast;

import com.listenergao.base.BaseApplication;

public class Utils {

    private static final DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();

    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }

    public static void toast(String string) {
        toast(string, Toast.LENGTH_SHORT);
    }

    public static void toast(String string, int duration) {
        Toast.makeText(BaseApplication.currentApplication(), string, duration).show();
    }

}
