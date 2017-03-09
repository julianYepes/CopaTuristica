package com.julianyepes.copaturistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    TextView tUser,tCorreo;
    String user,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tUser = (TextView)findViewById(R.id.tUser);
        tCorreo = (TextView)findViewById(R.id.tCorreo);

        Bundle extras = getIntent().getExtras();
        user=extras.getString("username");
        email=extras.getString("email");

        tUser.setText(user);
        tCorreo.setText(email);
    }

    //para el manejo de menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menuperfil,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.mInicio:
                Intent intent1 = new Intent(ProfileActivity.this,MainActivity.class);
                intent1.putExtra("username",user);
                intent1.putExtra("email",email);
                startActivity(intent1);
                finish();
                break;
            case R.id.mCerrar:
                Intent intent = new Intent(ProfileActivity.this,LoginActivity.class);
                setResult(RESULT_OK,intent);
                startActivityForResult(intent,3);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
