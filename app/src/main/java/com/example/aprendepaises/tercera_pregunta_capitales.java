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
    Intent i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tercera_pregunta_capitales);

        i=new Intent(this, cuarta_pregunta_capitales.class);


        a=(Button)findViewById(R.id.capitalMónaco);
        b=(Button)findViewById(R.id.capitalBasilea);
        c=(Button)findViewById(R.id.capitalEstocolmo);
        d=(Button)findViewById(R.id.capitalBerna);
        siguiente=(Button)findViewById(R.id.siguienteSuiza);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        siguiente.setOnClickListener(this);
        siguiente.setEnabled(false);              //deshabilita siguiente hasta que se escoja una respuesta
    }

    public void deshabilitar(){                     //da color y deshabilita las opciones
        d.setBackgroundColor(Color.GREEN);

        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        siguiente.setEnabled(true); //se puede poner o no
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.capitalMónaco:
                deshabilitar();
                break;
            case R.id.capitalBasilea:
                deshabilitar();
                break;
            case R.id.capitalEstocolmo:
                deshabilitar();
                break;
            case R.id.capitalBerna:   //respuesta correcta
                deshabilitar();
                break;
            case R.id.siguienteSuiza:
                deshabilitar();
                Intent i = new Intent(this, cuarta_pregunta_capitales.class);
                startActivity(i);
                break;
            default:
                break;
        }

    }

}
