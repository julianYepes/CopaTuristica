package com.julianyepes.copaturistica;

import android.content.Intent;
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==33 && resultCode == RESULT_OK){
            username = data.getExtras().getString("username");
            password = data.getExtras().getString("password");
            email = data.getExtras().getString("email");
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

       /* Bundle extras = getIntent().getExtras();//para obtener datos de otra actividad

        username = extras.getString("username");
        password = extras.getString("password");
        email = extras.getString("email");*/

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

                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra("username",username);
                    intent.putExtra("email",email);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.input_error), Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
