package com.julianyepes.copaturistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    String user,email;

    @Override//se pueden generar automaticamente
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();//como no estoy dentro de condicionales puedo utilizar this

        Bundle extras=getIntent().getExtras();
        user=extras.getString("username");
        email=extras.getString("email");

    }

    //para el manejo de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);

        //cambio el item 0 por hoteles
        //menu.getItem(0).setTitle(getResources().getString(R.string.hoteles));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent intent = new Intent(MainActivity.this,PlacesTabActivity.class);

        switch (id){
            case R.id.mItem0://Hoteles
                intent.putExtra("places","Hotels");
                startActivity(intent);
                break;
            case R.id.mItem1://Bares
                intent.putExtra("places","Bares");
                startActivity(intent);
                break;
            case R.id.mItem2://Sitios Turisticos
                intent.putExtra("places","SiteTour");
                startActivity(intent);
                break;
            case R.id.mItem3://Perfil
                Intent intent3 = new Intent(MainActivity.this,ProfileActivity.class);
                intent3.putExtra("username",user);
                intent3.putExtra("email",email);
                startActivity(intent3);
                break;
            case R.id.mItem4://Salir de la Aplicacion
                Intent intent4 = new Intent(MainActivity.this,LoginActivity.class);
                //setResult(RESULT_OK,intent1);
                //startActivityForResult(intent4,3);
                startActivity(intent4);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
