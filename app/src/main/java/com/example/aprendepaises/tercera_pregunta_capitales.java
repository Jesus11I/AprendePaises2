package com.example.aprendepaises;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class tercera_pregunta_capitales extends Activity implements View.OnClickListener {

    Button a,b,c,d,siguiente;
    int calificaciones=0;
    Intent i, r;
    Bundle bb;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tercera_pregunta_capitales);

        i=new Intent(this, cuarta_pregunta_capitales.class);


        a=(Button)findViewById(R.id.capitalMónaco);
        b=(Button)findViewById(R.id.capitalBasilea);
        c=(Button)findViewById(R.id.capitalEstocolmo);
        d=(Button)findViewById(R.id.capitalBerna);
        siguiente=(Button)findViewById(R.id.siguienteSuiza);

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

    public void deshabilitar(){                     //da color y deshabilita las opciones
        a.setBackgroundColor(Color.RED);
        b.setBackgroundColor(Color.RED);
        c.setBackgroundColor(Color.RED);
        d.setBackgroundColor(Color.GREEN);

        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        siguiente.setEnabled(true); //se puede poner o no
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.capitalMónaco:
                calificaciones+=0;
                deshabilitar();
                break;
            case R.id.capitalBasilea: //respuesta correcta
                calificaciones+=0;
                deshabilitar();
                break;
            case R.id.capitalEstocolmo:
                calificaciones+=0;
                deshabilitar();
                break;
            case R.id.capitalBerna:
                calificaciones+=1;
                deshabilitar();
                break;
            case R.id.siguienteSuiza:
                deshabilitar();
                Intent i=new Intent(this, cuarta_pregunta_capitales.class);
                startActivity(i);
                break;
            default:
                break;
        }

        i.putExtra("calificaciones", calificaciones);
    }







    public void ejecutar_capitales4 (View ejecutar_capitales4){
        Intent i=new Intent(this, cuarta_pregunta_capitales.class);
        startActivity(i);
    }
}
