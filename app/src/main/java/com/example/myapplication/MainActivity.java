package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private final Pattern loginPattern = Pattern.compile(new String
            ("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"));
    private final Pattern passwordPattern = Pattern.compile(new String
            ("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = (EditText) findViewById(R.id .editTextText);
        EditText etPas = (EditText) findViewById(R.id .editTextTextPassword);
        Button button = (Button) findViewById(R.id.button);
        @SuppressLint("ShowToast") Toast toastForLogin = Toast.makeText(MainActivity.this, "Введен логин в неверном формате", Toast.LENGTH_LONG);
        @SuppressLint("ShowToast") Toast toastForPassword = Toast.makeText(MainActivity.this, "Введен пароль в неверном формате", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, CabinetActivity.class);{
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    name = (EditText) findViewById(R.id.editTextText);
                    password = (EditText) findViewById(R.id.editTextTextPassword);
                    Matcher LoginMatch = loginPattern.matcher(name.getText().toString());
                    Matcher PasswordMatch = passwordPattern.matcher(password.getText().toString());
                    if (!LoginMatch.matches()) {
                        toastForLogin.show();
                    } else if (!PasswordMatch.matches()) {
                        toastForPassword.show();
                    }
                    else if(LoginMatch.matches() && PasswordMatch.matches())
                    {
                        intent.putExtra("login",name.getText().toString());
                        intent.putExtra("password",password.getText().toString());
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
