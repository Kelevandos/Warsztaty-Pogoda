package com.kelevandos.warsztatypogoda.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Kelevandos on 08.10.2017.
 */

public class WeatherResponse {

    @SerializedName("weather")
    List<Weather> weather;

    @SerializedName("main")
    Temperature temperature;

    @SerializedName("name")
    String name;

}
