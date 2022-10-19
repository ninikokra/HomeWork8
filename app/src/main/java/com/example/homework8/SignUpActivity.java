package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText signUpMobET,signUpPassET,repeatPassET;
    Button signUpButton;

    DataBase dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUpMobET = findViewById(R.id.mobSignUpET);
        signUpPassET = findViewById(R.id.passSignUpET);
        repeatPassET = findViewById(R.id.passRepeatET);
        signUpButton = findViewById(R.id.signUpActivityButton);

        dbHelper = new DataBase(this);



        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentV = new ContentValues();
                contentV.put("Mobile",signUpMobET.getText().toString());
                contentV.put("Password",signUpPassET.getText().toString());

                dbHelper.saveData(contentV);
                if (repeatPassET.getText().toString().equals(signUpPassET.getText().toString())){
                    Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(SignUpActivity.this, "Password Does not Match", Toast.LENGTH_SHORT).show();
                }




            }
        });
    }
}