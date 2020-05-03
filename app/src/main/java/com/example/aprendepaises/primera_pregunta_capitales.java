package com.example.aprendepaises;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class primera_pregunta_capitales extends Activity implements View.OnClickListener {

    Button a,b,c,d,siguiente;
    int calificaciones=0;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primera_pregunta_capitales);

        i=new Intent(this, segunda_pregunta_capitales.class);


        a=(Button)findViewById(R.id.capitalSevilla);
        b=(Button)findViewById(R.id.capitalMadrid);
        c=(Button)findViewById(R.id.capitalValencia);
        d=(Button)findViewById(R.id.capitalBarcelona);
        siguiente=(Button)findViewById(R.id.siguienteEspaña);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        siguiente.setOnClickListener(this);
        siguiente.setEnabled(false);              //deshabilita siguiente hasta que se escoja una respuesta
    }

    public void deshabilitar(){                     //da color y deshabilita las opciones
        a.setBackgroundColor(Color.RED);
        b.setBackgroundColor(Color.GREEN);
        c.setBackgroundColor(Color.RED);
        d.setBackgroundColor(Color.RED);

        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        siguiente.setEnabled(true); //se puede poner o no
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.capitalSevilla:
                calificaciones=0;
                deshabilitar();
                break;
            case R.id.capitalMadrid: //respuesta correcta
                calificaciones=1;
                deshabilitar();
                break;
            case R.id.capitalValencia:
                calificaciones=0;
                deshabilitar();
                break;
            case R.id.capitalBarcelona:
                calificaciones=0;
                deshabilitar();
                break;
            case R.id.siguienteEspaña:
                deshabilitar();
                Intent i=new Intent(this, segunda_pregunta_capitales.class);
                startActivity(i);
                break;
            default:
                break;
        }

        i.putExtra("calificaciones", calificaciones);
    }




    public void ejecutar_capitales2 (View ejecutar_capitales2){
        Intent i=new Intent(this, segunda_pregunta_capitales.class);
        startActivity(i);
    }
}
