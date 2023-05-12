package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = (EditText) findViewById(R.id .editTextText);
        EditText etPas = (EditText) findViewById(R.id .editTextTextPassword);
        Button button = (Button) findViewById(R.id.button);
        Intent intent = new Intent(this, CabinetActivity.class);{
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name = (EditText) findViewById(R.id.editTextText);
                    password = (EditText) findViewById(R.id.editTextTextPassword) ;
                    intent.putExtra("login",name.getText().toString());
                    intent.putExtra("password",password.getText().toString());
                    startActivity(intent);
                }
            });
        }
    }
}