package com.example.studentmanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private Button save,read;
    private EditText name;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        save = findViewById(R.id.save);
        read = findViewById(R.id.read);
        name = findViewById(R.id.name);
        password = findViewById(R.id.password);

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(i);


            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameText = name.getText().toString();
                String passwordText = password.getText().toString();
                SaveData(nameText,passwordText);


            }
        });
    }

    private void SaveData(String name,String password){
        DatabaseHelper db = new DatabaseHelper(this);
        boolean status = db.insertUser(name,password);
        if (status)
            Toast.makeText(this, "The data saved successfully", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "The data not saved", Toast.LENGTH_LONG).show();
    }
}