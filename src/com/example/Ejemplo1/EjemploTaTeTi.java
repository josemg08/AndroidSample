package com.example.Ejemplo1;

/**
 * User: Jose Gonzalez
 * Date: 11/3/13
 * Time: 2:10 AM
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class EjemploTaTeTi extends Activity {
    EditText edit1, edit2;
    TextView text1, text2;

    SharedPreferences preferencias;
    SharedPreferences.Editor editor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        edit1 = (EditText) findViewById(R.id.edit1);
        text1 = (TextView) findViewById(R.id.texto1);
        edit2 = (EditText) findViewById(R.id.edit2);
        text2 = (TextView) findViewById(R.id.texto2);

        preferencias = getSharedPreferences("preferencias", MODE_WORLD_READABLE);
        editor = preferencias.edit();
    }

    public void changeText1(View view){
        text1.setText(edit1.getText());
        editor.putString("jugador1", ""+edit1.getText());
        editor.commit();
    }

    public void changeText2(View view){
        text2.setText(edit2.getText());
        editor.putString("jugador2", ""+edit2.getText());
        editor.commit();
    }

    public void goToEjemplo(View view) {
        Intent intent = new Intent(this, Juego.class);
        startActivity(intent);
    }

}
