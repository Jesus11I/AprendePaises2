package com.example.aprendepaises;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button boton_jugar_banderas, boton_jugar_capitales;
    private long Salir;
    private Toast mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton_jugar_banderas = (Button)findViewById(R.id.boton_jugar_banderas);
        boton_jugar_capitales = (Button)findViewById(R.id.boton_jugar_capitales);
    }
    //Mostraremos dos formas para habilitar los botones
    //Habilitamos la relacion con el layout
    public void abrirBandera(View abrirBandera){
        Intent intent = new Intent(this,Alemania.class);
        startActivity(intent);
        finish();
    }
    //Habilitamos el boton con esta otra forma de relacion
    public void ejecutar_capitales1 (View ejecutar_capitales1){
        Intent i = new Intent(this, primera_pregunta_capitales.class);
        startActivity(i);
        finish();
     }
    //Habilitamos el boton con esta otra forma de relacion
    public void ejecutar_sobreLaApp (View vista_sobreLaApp){
        Intent i=new Intent(this, sobreLaApp.class);
        startActivity(i);
        finish();
    }
    //Habilitamos el boton con esta otra forma de relacion
    public void ejecutar_sobreLosCreadores (View vista_sobreLosCreadores){
        Intent i=new Intent(this, sobreLosCreadores.class);
        startActivity(i);
        finish();
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
    /*Este metodo hara que el al presionar dos veces el boton de volver nos cierre la app y
   al presionar una vez nos devolvera en pantalla un mensaje.*/
    @Override
    public void onBackPressed(){

        if (Salir + 2000 > System.currentTimeMillis()){
            mensaje.cancel();
            super.onBackPressed();
            finish();
            return;
        }else{
            mensaje = Toast.makeText(getBaseContext(),"Presiona otra vez para salir",Toast.LENGTH_SHORT);
            mensaje.show();
        }
        Salir = System.currentTimeMillis();

    }

}
