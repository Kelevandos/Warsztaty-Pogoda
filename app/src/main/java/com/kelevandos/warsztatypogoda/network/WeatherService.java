package com.kelevandos.warsztatypogoda.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kelevandos on 08.10.2017.
 */

public interface WeatherService {

    @GET("data/2.5/weather?APPID=ddd5725c8bcf091187e67a268fc6de1e&units=metric&lang=pl")
    Call<WeatherResponse> getWeather(@Query("q") String city);
}
