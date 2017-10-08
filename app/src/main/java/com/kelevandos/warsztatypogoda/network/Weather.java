package com.kelevandos.warsztatypogoda.network;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kelevandos on 08.10.2017.
 */

class Weather {

    public static final Weather EMPTY = new Weather(0, "", "Coś poszło nie tak", "");

    @SerializedName("id")
    long id;

    @SerializedName("main")
    String type;

    @SerializedName("description")
    String description;

    @SerializedName("icon")
    String icon;

    private Weather(long id, String type, String desc, String ic){
        this.id = id;
        this.type = type;
        this.description = desc;
        this.icon = ic;
    }
}
