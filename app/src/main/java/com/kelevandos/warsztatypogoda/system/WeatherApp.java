package com.kelevandos.warsztatypogoda.system;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherApp extends Application {

    static private WeatherApp instance;

    private Retrofit retrofit;

    public static WeatherApp getInstance() {
        return instance;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
