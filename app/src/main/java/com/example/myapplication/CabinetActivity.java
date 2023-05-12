package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class CabinetActivity extends AppCompatActivity {

    private String name;
    private String password;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cabinet);
        name = getIntent().getStringExtra("login");
        password = getIntent().getStringExtra("password");
        TextView nametext = (TextView) findViewById(R.id.textView);
        nametext.setText("Добро пожаловать, " + name);
        Button button = (Button) findViewById(R.id.button2);
        Intent intent = new Intent(this, SettingActivity.class);
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intent.putExtra("login", name);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            });
        }
    }
}