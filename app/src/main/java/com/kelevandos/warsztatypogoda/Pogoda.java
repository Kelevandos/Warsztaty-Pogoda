package com.kelevandos.warsztatypogoda;

/**
 * Created by Kelevandos on 08.10.2017.
 */

public class Pogoda {

    public String miasto;
    public double temperatura;
    public String ikona;
    public String opis;

    public Pogoda(String miasto, double temperatura, String ikona, String opis) {
        this.miasto = miasto;
        this.temperatura = temperatura;
        this.ikona = ikona;
        this.opis = opis;
    }
}
