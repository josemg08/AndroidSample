package com.example.Ejemplo1;

/**
 * User: Jose Gonzalez
 * Date: 11/3/13
 * Time: 2:05 AM
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Juego extends Activity {
    boolean turnoCirculo = true;
    int[] casillas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuadrilla);
        casillas = new int[9];
        for(int i=0; i<casillas.length; i++){
            casillas[i] = 2;
        }
    }

    public void clickBoton(View view) {
        int recuadro;
        switch(view.getId()){
            case R.id.boton1:
                recuadro = 0;
                break;
            case R.id.boton2:
                recuadro = 1;
                break;
            case R.id.boton3:
                recuadro = 2;
                break;
            case R.id.boton4:
                recuadro = 3;
                break;
            case R.id.boton5:
                recuadro = 4;
                break;
            case R.id.boton6:
                recuadro = 5;
                break;
            case R.id.boton7:
                recuadro = 6;
                break;
            case R.id.boton8:
                recuadro = 7;
                break;
            default:
                recuadro = 8;
        }

        if(turnoCirculo){
            view.setBackgroundResource(R.drawable.circulo);
            turnoCirculo = false;
            casillas[recuadro] = 0;
            verificarLineas();
        }
        else{
            view.setBackgroundResource(R.drawable.cruz);
            turnoCirculo = true;
            casillas[recuadro] = 1;
            verificarLineas();
        }
    }

    public void verificarLineas(){
        int circulos = 0, cruces = 0;

        //Para verificar las lineas horizontales
        for(int i=0; i<casillas.length; i+=3){
           for(int j=i; j<i+3; j++){
               if(casillas[j]==0){
                   circulos++;
               }
               else if(casillas[j]==1){
                   cruces++;
               }
           }
           if(circulos==3){
               goToGanador("circulos");
           }
           else if(cruces==3){
               goToGanador("cruces");
           }
           else{
               circulos = 0;
               cruces = 0;
           }
        }

        //para verificar las lineas verticales
        for(int i=0; i<3; i++){
            for(int j=i; j<casillas.length; j+=3){
                if(casillas[j]==0){
                    circulos++;
                }
                else if(casillas[j]==1){
                    cruces++;
                }
            }
            if(circulos==3){
                goToGanador("circulos");
            }
            else if(cruces==3){
                goToGanador("cruces");
            }
            else{
                circulos = 0;
                cruces = 0;
            }
        }

        //Para verificar las diagonales
        int caso = 2;
        if(casillas[0] == casillas[4] && casillas[8] == casillas[0] && (casillas[0]==0 || casillas[0]==1)){
            caso = casillas[0];
        }
        if(casillas[2] == casillas[4] && casillas[6] == casillas[2] && (casillas[2]==0 || casillas[2]==1)){
            caso = casillas[2];
        }

        if(caso==0){
            goToGanador("circulos");
        }
        else if(caso==1){
            goToGanador("cruces");
        }

    }

    void goToGanador(String ganador){
        Intent intent = new Intent(this, Ganador.class);
        intent.putExtra("ganador", ganador);
        startActivity(intent);
    }

}
