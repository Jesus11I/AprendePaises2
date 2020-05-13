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

public class Espana extends Activity  implements View.OnClickListener{

    private ImageView iv_espana;
    private Button espana, eslovaquia, moldavia;
    private TextView reloj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.espana);

        iv_espana = (ImageView)findViewById(R.id.imageView2_espana);
        espana = (Button)findViewById(R.id.espana);
        eslovaquia = (Button)findViewById(R.id.eslovaquia);
        moldavia = (Button)findViewById(R.id.moldavia);
        reloj = (TextView)findViewById(R.id.reloj);

        espana.setOnClickListener(this);
        eslovaquia.setOnClickListener(this);
        moldavia.setOnClickListener(this);

        reloj.setEnabled(false);
    }
    //Da color tras haber respondido  la respùesta corecta
    public void solucion() {
        espana.setBackgroundColor(Color.GREEN);
        espana.setEnabled(true);
    }
    //Este metodo modificaremos la posiciondel Toast
    private void showToast(){
        Toast toast = Toast. makeText(this, "TE HAS EQUIVOCADO", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START,160,0);
        toast.show();
    }
    //creamos el metodo paracambiar de intent
    public void intent(){
        Intent intent = new Intent(this,Francia.class);
        startActivity(intent);
        finish();
    }
    //Este metodo deshabilita el boton volver atras
    public void onBackPressed(){

    }
    //Creamos un metodo de cuenta regresiva y a su vez
    //cambio automatico de intent
    public void cuenta()
    {
        new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                reloj.setText("Siguiente en "+millisUntilFinished/1000);
                reloj.setEnabled(false);
                espana.setEnabled(false);
                eslovaquia.setEnabled(false);
                moldavia.setEnabled(false);
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
            case R.id.espana:
                intent();
                solucion();
                break;
            case R.id.eslovaquia:
                cuenta();
                showToast();
                solucion();
                break;
            case R.id.moldavia:
                cuenta();
                showToast();
                solucion();
                break;

        }

    }
}
