package com.julianyepes.copaturistica;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText eUsername, ePassword;
    Button bLogin;
    TextView tRegister;
    String username, password, email;

    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==33 && resultCode == RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            email = data.getExtras().getString("email");

            editor.putString("username",username);
            editor.putString("password",password);
            editor.putString("email",email);
            editor.commit();

            Log.d("username",username);
            Log.d("password",password);
            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();

        }else if (requestCode==33 && resultCode == RESULT_CANCELED){
            Toast.makeText(this, "Registro Cancelado", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        prefs = getSharedPreferences("MisPreferencias",MODE_PRIVATE);
        editor = prefs.edit();

        username = prefs.getString("username","noname");
        password = prefs.getString("password","nopass");
        email = prefs.getString("email","noemail");


        if ( prefs.getInt("login",-1) == 1) { // 1 hay alguien loggeado -1 no hay
            Intent i = new Intent(LoginActivity.this, MainNavigationDrawerActivity.class);
            i.putExtra("username",username);
            i.putExtra("email",email);
            i.putExtra("fragment","listView");
            startActivity(i);
            finish();
        }

        eUsername = (EditText)findViewById(R.id.eUsername);
        ePassword = (EditText)findViewById(R.id.ePassword);
        bLogin = (Button)findViewById(R.id.bLogin);
        tRegister = (TextView)findViewById(R.id.tRegister);

        tRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivityForResult(intent,33);
            }
        });

        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eUsername.getText().toString().equals(username)
                        && ePassword.getText().toString().equals(password)){

                    editor.putInt("login",1);
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this,MainNavigationDrawerActivity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("email",email);
                    intent.putExtra("fragment","listView");
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.input_error), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
