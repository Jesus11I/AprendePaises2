package com.example.aprendepaises;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class resultado_capitales extends Activity {
    private Button reg;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado_capitales);

        reg=(Button)findViewById(R.id.Inicio);
       texto=(TextView)findViewById(R.id.FIN);
    }
    public void inicio(View inicio){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish(); //finalizala actividad al cambiar de pantalla
    }

    //Desactivamos el botton de volver con el metodo siguiente
    public  void  onBackPressed(){

    }

}
