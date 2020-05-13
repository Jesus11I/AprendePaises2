package com.example.aprendepaises;

import androidx.appcompat.app.AppCompatActivity;

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

public class Rusia extends Activity  implements View.OnClickListener {
    private ImageView iv_rusia;
    private Button italia, rusia, rumania;
    private TextView reloj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rusia);

        iv_rusia = (ImageView)findViewById(R.id.imageView2_Alemania);
        italia = (Button)findViewById(R.id.italia);
        rusia = (Button)findViewById(R.id.rusia);
        rumania = (Button)findViewById(R.id.rumania);
        reloj = (TextView)findViewById(R.id.reloj);

        italia.setOnClickListener(this);
        rusia.setOnClickListener(this);
        rumania.setOnClickListener(this);

        reloj.setEnabled(false);
    }
    //Da color verde a la solucion tras clickear
    public void solucion() {
        rusia.setBackgroundColor(Color.GREEN);
        rusia.setEnabled(true);
    }
    //Este metodo modificaremos la posiciondel Toast
    private void showToast(){
        Toast toast = Toast. makeText(this, "TE HAS EQUIVOCADO", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START,160,0);
        toast.show();
    }
    //creamos el siguiente intent
    public void intent(){
        Intent intent = new Intent(this, resultado_capitales.class);
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
                italia.setEnabled(false);
                rumania.setEnabled(false);
                rusia.setEnabled(false);
            }

            @Override
            public void onFinish() {

                intent();
            }
        }.start();

    }
    //Metodo de View.OnClickListener
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.italia:
                cuenta();
                showToast();
                solucion();
                break;
            case R.id.rusia:
                intent();
                solucion();
                break;
            case R.id.rumania:
                cuenta();
                showToast();
                solucion();
                break;

        }
    }
}
