package com.example.aprendepaises;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class primera_pregunta_capitales extends Activity implements View.OnClickListener {

    Button a,b,c,d,siguiente;                     //declaración de botones

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primera_pregunta_capitales);


        a=(Button)findViewById(R.id.capitalSevilla);           //inicialización de botones
        b=(Button)findViewById(R.id.capitalMadrid);
        c=(Button)findViewById(R.id.capitalValencia);
        d=(Button)findViewById(R.id.capitalBarcelona);
        siguiente=(Button)findViewById(R.id.siguienteEspaña);

        a.setOnClickListener(this);                //evento para que funcionen los botones
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        siguiente.setOnClickListener(this);

        siguiente.setEnabled(false);              //deshabilita siguiente hasta que se escoja una respuesta
    }



    @Override                             //Este método se crea al implementar el evento OnClickListener. Gestiona los eventos
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.capitalSevilla:
                deshabilitar();                 //una vez que se contesta se deshabilitan los botones. (Igual para las posteriores)
                break;
            case R.id.capitalMadrid:           //respuesta correcta
                deshabilitar();
                break;
            case R.id.capitalValencia:
                deshabilitar();
                break;
            case R.id.capitalBarcelona:
                deshabilitar();
                break;
            case R.id.siguienteEspaña:
                deshabilitar();
                Intent i=new Intent(this, segunda_pregunta_capitales.class);
                startActivity(i);
                finish(); //finalizala actividad al cambiar de pantalla
                break;
            default:
                break;
        }

    }

    public void deshabilitar(){                     //da color y deshabilita las opciones

        b.setBackgroundColor(Color.GREEN);          //respuesta correcta

        a.setEnabled(false);
        b.setEnabled(false);
        c.setEnabled(false);
        d.setEnabled(false);
        siguiente.setEnabled(true);               //habilita siguiente al pulsar una respuesta
    }
    //Este metodo deshabilita el boton volver atras
    public void onBackPressed(){

    }


}
