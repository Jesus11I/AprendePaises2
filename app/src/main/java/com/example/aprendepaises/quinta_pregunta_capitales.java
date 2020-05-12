package com.example.aprendepaises;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quinta_pregunta_capitales extends Activity implements View.OnClickListener {

    Button a, b, c, d, siguiente;
    int calificaciones = 0;
    Intent i, r;
    Bundle bb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quinta_pregunta_capitales);

        i = new Intent(this, resultado_capitales.class);


        a = (Button) findViewById(R.id.capitalKiev);
        b = (Button) findViewById(R.id.capitalSanPetesburgo);
        c = (Button) findViewById(R.id.capitalMoscú);
        d = (Button) findViewById(R.id.capitalMinsk);
        siguiente = (Button) findViewById(R.id.siguienteRusia);

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
        siguiente.setEnabled(false);              //deshabilita siguiente hasta que se escoja una respuesta
    }

    public void deshabilitar() {                     //da color y deshabilita las opciones
        a.setBackgroundColor(Color.RED);
        b.setBackgroundColor(Color.RED);
        c.setBackgroundColor(Color.GREEN);
        d.setBackgroundColor(Color.RED);

        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        siguiente.setEnabled(true); //se puede poner o no
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.capitalKiev:
                calificaciones += 0;
                deshabilitar();
                break;
            case R.id.capitalSanPetesburgo: //respuesta correcta
                calificaciones +=0;
                deshabilitar();
                break;
            case R.id.capitalMoscú:
                calificaciones += 1;
                deshabilitar();
                break;
            case R.id.capitalMinsk:
                calificaciones += 0;
                deshabilitar();
                break;
            case R.id.siguienteRusia:
                deshabilitar();
                Intent i = new Intent(this, resultado_capitales.class);
                startActivity(i);
                break;
            default:
                break;
        }

        i.putExtra("calificaciones", calificaciones);
    }


    public void resultado_capitales (View resultado_capitales){
        Intent i=new Intent(this, resultado_capitales.class);
        startActivity(i);
    }
}

