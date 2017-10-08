package com.kelevandos.warsztatypogoda.network;

import com.kelevandos.warsztatypogoda.Pogoda;
import com.kelevandos.warsztatypogoda.system.WeatherApp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WeatherProvider {

    private WeatherListener listener;

    public WeatherProvider(WeatherListener listener) {
        this.listener = listener;
    }

    public void getWeather(String city) {
        Retrofit retrofit = WeatherApp.getInstance().getRetrofit();

        retrofit.create(WeatherService.class).getWeather(city).enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                try {
                    WeatherResponse data = response.body();
                    Weather weatherData = data.weather.size() > 0 ? data.weather.get(0) : Weather.EMPTY;
                    listener.onSuccess(new Pogoda(data.name, data.temperature.temperature, weatherData.icon, weatherData.description));
                } catch (Exception e) {
                    listener.onFailure(e);
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable throwable) {
                listener.onFailure(throwable);
            }
        });
    }
}
