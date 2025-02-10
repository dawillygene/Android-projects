package com.example.ui_firstone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dawilly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dawilly);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("FIRST_NAME");
        String secondName = intent.getStringExtra("SECOND_NAME");
        String surname = getIntent().getStringExtra("SURNAME");
        String birthDate = getIntent().getStringExtra("BIRTH_DATE");
        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");
        String email = getIntent().getStringExtra("EMAIL");
        String password = getIntent().getStringExtra("PASSWORD");
        String username = getIntent().getStringExtra("USERNAME");
        String gender = getIntent().getStringExtra("GENDER");


        TextView details = findViewById(R.id.textViewDetails);
        details.setText("First Name: " + firstName + "\n" +
                "Second Name: " + secondName + "\n" +
                "Surname: " + surname + "\n" +
                "Birth Date: " + birthDate + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Username: " + username + "\n" +
                "Gender: " + gender + "\n" +
                "Password: " + password);
    }
}
