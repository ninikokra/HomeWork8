package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    EditText mobET,passET;
    Button signUpBtn,signInBtn;

    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobET = findViewById(R.id.mobileET);
        passET = findViewById(R.id.passwordET);
        signInBtn = findViewById(R.id.signInBtn);
        signUpBtn = findViewById(R.id.signUpBtn);

        dataBase = new DataBase(this);


        signUpBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        });

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String pass = dataBase.getData(mobET.getText().toString());

               if (passET.getText().toString().equals(pass)) {
                    Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra("name",mobET.getText().toString());
                    startActivity(intent);
                }else{
                   Toast.makeText(MainActivity.this, "Mobile or Password Does not Match", Toast.LENGTH_SHORT).show();
               }





            }
        });



    }
}