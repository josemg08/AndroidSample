package com.example.Ejemplo1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

/**
 * User: Jose Gonzalez
 * Date: 11/3/13
 * Time: 2:14 AM
 */

public class Ganador extends Activity {
    TextView ganador;
    SharedPreferences preferencias;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ganador);
        ganador = (TextView) findViewById(R.id.ganador);

        preferencias = getSharedPreferences("preferencias" ,MODE_WORLD_READABLE);

        Bundle extras = getIntent().getExtras();
        if(extras.getString("ganador").equals("circulos")){
            ganador.setText(preferencias.getString("jugador1", "valor por defecto")+" ha ganado!");
        }
        else{
            ganador.setText(preferencias.getString("jugador2", "valor por defecto")+" ha ganado!");
        }
    }

}
