package com.julianyepes.copaturistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String user,email;

    @Override//se pueden generar automaticamente
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();//como no estoy dentro de condicionales puedo utilizar this

        Bundle extras=getIntent().getExtras();
        user=extras.getString("username");
        email=extras.getString("email");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();//como no estoy dentro de condicionales puedo utilizar this
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();//como no estoy dentro de condicionales puedo utilizar this

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();//como no estoy dentro de condicionales puedo utilizar this

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();//como no estoy dentro de condicionales puedo utilizar this

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onRestart",Toast.LENGTH_SHORT).show();//como no estoy dentro de condicionales puedo utilizar this

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();//como no estoy dentro de condicionales puedo utilizar this

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==2 && resultCode == RESULT_OK){
            Toast.makeText(this, "A ingresado a main activity", Toast.LENGTH_SHORT).show();

        }else if (requestCode==12345 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Por error", Toast.LENGTH_SHORT).show();
        }
    }

    //para el manejo de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.mPerfil:
                Intent intent1 = new Intent(MainActivity.this,ProfileActivity.class);
                intent1.putExtra("username",user);
                intent1.putExtra("email",email);
                startActivity(intent1);
                finish();
                break;
            case R.id.mCerrar:
                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                setResult(RESULT_OK,intent);
                startActivityForResult(intent,3);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
