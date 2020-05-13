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

public class Suiza extends Activity  implements View.OnClickListener {
    private ImageView iv_suiza;
    private Button malta, alemania, suiza;
    private TextView reloj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suiza);

        iv_suiza = (ImageView)findViewById(R.id.imageView2_Suiza);
        malta = (Button)findViewById(R.id.malta);
        alemania = (Button)findViewById(R.id.alemania);
        suiza = (Button)findViewById(R.id.suiza);
        reloj = (TextView)findViewById(R.id.reloj);

        malta.setOnClickListener(this);
        alemania.setOnClickListener(this);
        suiza.setOnClickListener(this);

        reloj.setEnabled(false);
    }
    //Da color verde a la solucion tras clickear
    public void solucion() {
        suiza.setBackgroundColor(Color.GREEN);
        suiza.setEnabled(true);
    }
    //Este metodo modificaremos la posiciondel Toast
    private void showToast(){
        Toast toast = Toast. makeText(this, "TE HAS EQUIVOCADO", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START,160,0);
        toast.show();
    }

    //creamos el siguiente intent
    public void intent(){
        Intent intent = new Intent(this,Rusia.class);
        startActivity(intent);
    }
    //Este metodo deshabilita el boton volver atras
    public void onBackPressed(){

    }
    //cuenta regresiva y cambio automatico de intent tras acabar el tiempo
    public void cuenta()
    {
        new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                reloj.setText("Siguiente en "+millisUntilFinished/1000);
                reloj.setEnabled(true);
                suiza.setEnabled(false);
                alemania.setEnabled(false);
                malta.setEnabled(false);
            }

            @Override
            public void onFinish() {

                intent();
            }
        }.start();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.suiza:
                intent();
                solucion();
                break;
            case R.id.alemania:
                cuenta();
                showToast();
                solucion();
                break;
            case R.id.malta:
                cuenta();
                showToast();
                solucion();
                break;

        }

    }
}
