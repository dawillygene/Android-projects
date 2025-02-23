package com.example.lesson08_webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_One extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        CheckBox rememberMe = findViewById(R.id.rememberMe);
        Button saveBtn = findViewById(R.id.submitButton);

        sharedPreferences = getSharedPreferences("mySharedPreference", Context.MODE_PRIVATE);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _username = username.getText().toString();
                String _password = password.getText().toString();
                boolean _rememberMe = rememberMe.isChecked();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", _username);
                editor.putString("password", _password);
                editor.putBoolean("rememberMe", _rememberMe);
                editor.apply();
            }
        });
    }
}