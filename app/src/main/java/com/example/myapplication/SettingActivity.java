package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SettingActivity extends AppCompatActivity {
    private String name;
    private EditText newname;
    private String password;
    private EditText newpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        EditText etlogin = (EditText) findViewById(R.id.editTextText2);
        EditText etpassword = (EditText) findViewById(R.id.editTextText3);
        name = getIntent().getStringExtra("login");
        password = getIntent().getStringExtra("password");
        etlogin.setText(name);
        etpassword.setText(password);
        Button button = (Button) findViewById(R.id.button3);
        Intent intent = new Intent(this, CabinetActivity.class);
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newname = (EditText) findViewById(R.id.editTextText2);
                    newpassword = (EditText) findViewById(R.id.editTextText3);
                    intent.putExtra("login", name);
                    intent.putExtra("password", password);
                    startActivity(intent);
                }
            });
        }
    }
}