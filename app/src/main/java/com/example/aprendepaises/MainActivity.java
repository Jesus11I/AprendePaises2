package com.example.aprendepaises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button boton_jugar_banderas, boton_jugar_capitales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton_jugar_banderas = (Button)findViewById(R.id.boton_jugar_banderas);
        boton_jugar_banderas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirBandera();

            }
        });

        boton_jugar_capitales = (Button)findViewById(R.id.boton_jugar_capitales);
    }
    //Mostraremos dos formas para habilitar los botones
    //Habilitamos la relacion con el layout
    public void abrirBandera(){
        Intent intent = new Intent(this,Alemania.class);
        startActivity(intent);
    }
    //Habilitamos el boton con esta otra forma de relacion
    public void ejecutar_capitales1 (View ejecutar_capitales1){
        Intent i = new Intent(this, primera_pregunta_capitales.class);
        startActivity(i);
    }
    //Habilitamos el boton con esta otra forma de relacion
    public void ejecutar_sobreLaApp (View vista_sobreLaApp){
        Intent i=new Intent(this, sobreLaApp.class);
        startActivity(i);
    }
    //Habilitamos el boton con esta otra forma de relacion
    public void ejecutar_sobreLosCreadores (View vista_sobreLosCreadores){
        Intent i=new Intent(this, sobreLosCreadores.class);
        startActivity(i);
    }
    //Metodo para mostrar y ocultar el menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_informacion, menu);
        return true;
    }
    //Metodo para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();

        if (id==R.id.item1){
            ejecutar_sobreLaApp(null);
        }else if(id==R.id.item2){
            ejecutar_sobreLosCreadores(null);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
