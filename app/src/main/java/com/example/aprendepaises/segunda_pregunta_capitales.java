package com.example.aprendepaises;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class segunda_pregunta_capitales extends Activity implements View.OnClickListener{

    Button a,b,c,d,siguiente;
    int calificaciones=0;
    Intent i, r;
    Bundle bb;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_pregunta_capitales);

        i=new Intent(segunda_pregunta_capitales.this, tercera_pregunta_capitales.class);

        a=(Button)findViewById(R.id.capitalBerlín);
        b=(Button)findViewById(R.id.capitalMúnich);
        c=(Button)findViewById(R.id.capitalBruselas);
        d=(Button)findViewById(R.id.capitalHamburgo);
        siguiente=(Button)findViewById(R.id.siguienteAlemania);

        /*try{
            r=getIntent();
            bb=r.getExtras();
            calificaciones=bb.getInt("calificaciones");
        } catch (Exception e){
            Toast.makeText(this, "Error al recibir datos", Toast.LENGTH_SHORT).show();
        }*/

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        siguiente.setOnClickListener(this);
        siguiente.setEnabled(false);
    }

    public void deshabilitar(){
        a.setBackgroundColor(Color.GREEN);
        b.setBackgroundColor(Color.RED);
        c.setBackgroundColor(Color.RED);
        d.setBackgroundColor(Color.RED);

        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        siguiente.setEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.capitalBerlín: //respuesta correcta
                calificaciones+=1;
                deshabilitar();
                break;
            case R.id.capitalMúnich:
                calificaciones+=0;
                deshabilitar();
                break;
            case R.id.capitalBruselas:
                calificaciones+=0;
                deshabilitar();
                break;
            case R.id.capitalHamburgo:
                calificaciones+=0;
                deshabilitar();
                break;
            case R.id.siguienteAlemania:
                deshabilitar();
                Intent i=new Intent(this, tercera_pregunta_capitales.class);
                startActivity(i);
                break;
            default:
                break;
        }
        i.putExtra("calificacion", calificaciones);
    }






    public void ejecutar_capitales3 (View ejecutar_capitales3) {
        Intent i = new Intent(this, tercera_pregunta_capitales.class);
        startActivity(i);
    }
}

