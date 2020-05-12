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

public class Francia extends Activity implements View.OnClickListener{
    private ImageView iv_francia;
    private Button holanda, croacia, francia;
    private TextView reloj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.francia);

        iv_francia = (ImageView)findViewById(R.id.imageView2_francia);
        holanda = (Button)findViewById(R.id.holanda);
        croacia = (Button)findViewById(R.id.croacia);
        francia = (Button)findViewById(R.id.francia);
        reloj = (TextView)findViewById(R.id.reloj);

        holanda.setOnClickListener(this);
        croacia.setOnClickListener(this);
        francia.setOnClickListener(this);
    }
    //Dara color tras haber respondido  la respùesta corecta
    public void solucion() {
        francia.setBackgroundColor(Color.GREEN);
        francia.setEnabled(true);
    }
    //Este metodo modificaremos la posiciondel Toast
    private void showToast() {
        Toast toast = Toast.makeText(this, "TE HAS EQUIVOCADO", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START, 160, 0);
        toast.show();
    }
    //Con este metodo creamos el intent para cambiar de layout
    public void intent(){
        Intent intent = new Intent(this,Suiza.class);
        startActivity(intent);
        finish();
    }
    //Este metodo deshabilita el boton volver atras
    public void onBackPressed(){

    }
    //Creamos el metodo cuenta con una cuenta regresiva y
    // cambio automatico de intent
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

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.holanda:
                    cuenta();
                    showToast();
                    solucion();
                    break;
                case R.id.croacia:
                    cuenta();
                    showToast();
                    solucion();
                    break;
                case R.id.francia:
                    intent();
                    solucion();
                    break;

            }

    }
}
