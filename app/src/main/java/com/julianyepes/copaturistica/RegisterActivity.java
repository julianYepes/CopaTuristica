package com.julianyepes.copaturistica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText eRUsername, eRPassword, eRPasswordVerify, eREmail;
    Button bRRegister, bRCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        eRUsername = (EditText)findViewById(R.id.eRUsername);
        eRPassword = (EditText)findViewById(R.id.eRPassword);
        eRPasswordVerify = (EditText)findViewById(R.id.eRPasswordVerify);
        eREmail = (EditText)findViewById(R.id.eREmail);

        bRRegister = (Button)findViewById(R.id.bRRegister);
        bRCancel = (Button)findViewById(R.id.bRCancel);

        bRCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                Intent intent = new Intent();
                setResult(RESULT_CANCELED,intent);
                finish();//cierra las actividades y no se puede volver a ella dando click en el boton atras de android
            }
        });

        bRRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                if (eRUsername.getText().toString().isEmpty() || eRPassword.getText().toString().isEmpty()
                        || eREmail.getText().toString().isEmpty() || eRPasswordVerify.getText().toString().isEmpty() ){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.input_data),Toast.LENGTH_SHORT).show();
                }
                else if (!eRPasswordVerify.getText().toString().equals(eRPassword.getText().toString())){
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.input_pass),Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent();
                    intent.putExtra("username",eRUsername.getText().toString());
                    intent.putExtra( "password",eRPassword.getText().toString() );
                    intent.putExtra("email",eREmail.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                }


            }
        });
    }
}