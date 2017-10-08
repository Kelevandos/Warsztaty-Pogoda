package com.kelevandos.warsztatypogoda.network;

import com.kelevandos.warsztatypogoda.Pogoda;

/**
 * Created by Kelevandos on 08.10.2017.
 */

public interface WeatherListener {

    void onSuccess(Pogoda pogoda);

    void onFailure(Throwable t);
}
