package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingActivity extends AppCompatActivity {
    private EditText newname;
    private EditText newpassword;
    private final Pattern loginPattern = Pattern.compile(new String
            ("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"));
    private final Pattern passwordPattern = Pattern.compile(new String
            ("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        EditText etlogin = (EditText) findViewById(R.id.editTextText2);
        EditText etpassword = (EditText) findViewById(R.id.editTextText3);
        String name = getIntent().getStringExtra("login");
        String password = getIntent().getStringExtra("password");
        etlogin.setText(name);
        etpassword.setText(password);
        Button button = (Button) findViewById(R.id.button3);
        @SuppressLint("ShowToast") Toast toastForLogin = Toast.makeText(this, "Введен логин в неверном формате", Toast.LENGTH_LONG);
        @SuppressLint("ShowToast") Toast toastForPassword = Toast.makeText(this, "Введен пароль в неверном формате", Toast.LENGTH_LONG);
        Intent intent = new Intent(this, CabinetActivity.class);
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newname = (EditText) findViewById(R.id.editTextText2);
                    newpassword = (EditText) findViewById(R.id.editTextText3);
                    Matcher LoginMatch = loginPattern.matcher(newname.getText().toString());
                    Matcher PasswordMatch = passwordPattern.matcher(newpassword.getText().toString());
                    if (!LoginMatch.matches()) {
                        toastForLogin.show();
                    } else if (!PasswordMatch.matches()) {
                        toastForPassword.show();
                    }
                    else if(LoginMatch.matches() && PasswordMatch.matches())
                    {
                        intent.putExtra("login",newname.getText().toString());
                        intent.putExtra("password",newpassword.getText().toString());
                        startActivity(intent);
                    }
                }
            });
        }
    }
}