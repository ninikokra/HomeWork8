package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTV;
    Animation animation;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        animation = AnimationUtils.loadAnimation(this,R.anim.fade_anim);
        resultTV = findViewById(R.id.resultTV);

        resultTV.setText("Mobile Number is  " + getIntent().getStringExtra("name"));
        resultTV.startAnimation(animation);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void signOut(MenuItem item) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}