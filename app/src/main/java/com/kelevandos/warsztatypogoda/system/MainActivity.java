package com.kelevandos.warsztatypogoda.system;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kelevandos.warsztatypogoda.Pogoda;
import com.kelevandos.warsztatypogoda.R;
import com.kelevandos.warsztatypogoda.network.WeatherListener;
import com.kelevandos.warsztatypogoda.network.WeatherProvider;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements WeatherListener, View.OnClickListener {

    private TextView miasto;
    private TextView temperatura;
    private ImageView ikona;
    private TextView opis;

    private EditText nazwaMiasta;
    private Button pobierz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupView();

        pobierzPogode();
    }

    /**
     * Krok 1: Dodajemy pobieranie danych pogodowych
     */
    private void pobierzPogode() {
        WeatherProvider provider = new WeatherProvider(this);
        provider.getWeather("Zabrze");
    }

    private void setupView() {
        setContentView(R.layout.activity_main);
        miasto = (TextView) findViewById(R.id.miasto);
        temperatura = (TextView) findViewById(R.id.temperatura);
        ikona = (ImageView) findViewById(R.id.ikona);
        opis = (TextView) findViewById(R.id.opis);
        opis.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);

        nazwaMiasta = (EditText) findViewById(R.id.nazwaMiasta);
        pobierz = (Button) findViewById(R.id.pobierz);

        pobierz.setOnClickListener(this);
    }

    @Override
    public void onSuccess(Pogoda pogoda) {
        miasto.setText(pogoda.miasto);
        temperatura.setText(String.valueOf((int) pogoda.temperatura) + " °C");
        opis.setText(pogoda.opis);
        Picasso.with(this).load(getIconUrl(pogoda.ikona)).into(ikona);
    }

    @Override
    public void onFailure(Throwable t) {
        Toast.makeText(this, "Coś poszło nie tak", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {
        WeatherProvider provider = new WeatherProvider(this);
        provider.getWeather(nazwaMiasta.getText().toString());
    }

    private String getIconUrl(String id) {
        return "http://openweathermap.org/img/w/" + id + ".png?size=200";
    }
}
