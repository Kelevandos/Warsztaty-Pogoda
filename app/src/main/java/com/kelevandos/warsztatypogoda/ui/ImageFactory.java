package com.kelevandos.warsztatypogoda.ui;

import android.support.annotation.DrawableRes;

import com.kelevandos.warsztatypogoda.R;

/**
 * Created by Kelevandos on 08.10.2017.
 */

public class ImageFactory {

    @DrawableRes
    public static int getLocalIdForResponseImage(String responseId) {
        switch (responseId) {
            case "01d":
                return R.drawable.one_day;
            case "01n":
                return R.drawable.one_night;
            case "02d":
                return R.drawable.two_day;
            case "02n":
                return R.drawable.two_night;
            case "03d":
                return R.drawable.three_day;
            case "03n":
                return R.drawable.three_night;
            case "04d":
                return R.drawable.four_day;
            case "04n":
                return R.drawable.four_night;
            case "09d":
                return R.drawable.nine_day;
            case "09n":
                return R.drawable.nine_night;
            case "10d":
                return R.drawable.ten_day;
            case "10n":
                return R.drawable.ten_night;
            case "11d":
                return R.drawable.eleven_day;
            case "11n":
                return R.drawable.eleven_night;
            case "13d":
                return R.drawable.thirteen_day;
            case "13n":
                return R.drawable.thirteen_night;
            case "20d":
            case "20n":
                return R.drawable.twenty;
            case "50d":
            case "50n":
                return R.drawable.fifty;
        }
        return -1;
    }
}
