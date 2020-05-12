package com.example.aprendepaises;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Alemania extends Activity  implements View.OnClickListener {   //View.Onlistener implementa la funcion de clikear
    private ImageView iv_alemania;
    private Button belgica, alemania, suiza;
    private TextView reloj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alemania);

        iv_alemania = (ImageView)findViewById(R.id.imageView2_Alemania);
        belgica = (Button)findViewById(R.id.belgica);
        alemania = (Button)findViewById(R.id.alemania);
        suiza = (Button)findViewById(R.id.suiza);
        reloj = (TextView)findViewById(R.id.reloj);

        belgica.setOnClickListener(this);
        alemania.setOnClickListener(this);
        suiza.setOnClickListener(this);

    }

    public void solucion() {  // da color tras haber respondido  la respùesta corecta
        alemania.setBackgroundColor(Color.GREEN);

        alemania.setEnabled(true);
    }

    private void showToast(){ //Este metodo modificaremos la posiciondel Toast
        Toast toast = Toast. makeText(this, "TE HAS EQUIVOCADO", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START,160,0);
        toast.show();
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.belgica:
                cuenta();
                showToast();
                solucion();
                break;
            case R.id.alemania:
                intent();
                solucion();
                break;
            case R.id.suiza:
                cuenta();
                showToast();
                solucion();
                break;

        }

    }
    //creamos el siguiente intent
    public void intent(){
        Intent intent = new Intent(this,Espana.class);
        startActivity(intent);
        finish();
    }
    //Este metodo deshabilita el boton volver atras
    public void onBackPressed(){

    }
 //cuenta regresiva y cambio automatico de intent
    public void cuenta()
    {
        new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                reloj.setText("Siguiente en "+millisUntilFinished/1000);
                reloj.setEnabled(false);
            }

            @Override
            public void onFinish() {

                intent();
            }
        }.start();

    }

}