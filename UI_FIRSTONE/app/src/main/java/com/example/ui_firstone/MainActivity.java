package com.example.ui_firstone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText firstName, secondName, surname, birthDate, phoneNumber, email, password, username;
    private RadioButton male, female;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      
        firstName = findViewById(R.id.etFirstName);
        secondName = findViewById(R.id.etLastName);
        surname = findViewById(R.id.etSurname);
        birthDate = findViewById(R.id.etBirthDate);
        phoneNumber = findViewById(R.id.etPhone);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        username = findViewById(R.id.etUsername);
        male = findViewById(R.id.rbMale);
        female = findViewById(R.id.rbFemale);

        Button button = findViewById(R.id.btnSubmit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               
                String firstNameValue = firstName.getText().toString();
                String secondNameValue = secondName.getText().toString();
                String surnameValue = surname.getText().toString();
                String birthDateValue = birthDate.getText().toString();
                String phoneNumberValue = phoneNumber.getText().toString();
                String emailValue = email.getText().toString();
                String passwordValue = password.getText().toString();
                String usernameValue = username.getText().toString();
                String genderValue = male.isChecked() ? "Male" : (female.isChecked() ? "Female" : "Not Specified");

             
                Intent intent = new Intent(MainActivity.this, dawilly.class);
                intent.putExtra("FIRST_NAME", firstNameValue);
                intent.putExtra("SECOND_NAME", secondNameValue);
                intent.putExtra("SURNAME", surnameValue);
                intent.putExtra("BIRTH_DATE", birthDateValue);
                intent.putExtra("PHONE_NUMBER", phoneNumberValue);
                intent.putExtra("EMAIL", emailValue);
                intent.putExtra("PASSWORD", passwordValue);
                intent.putExtra("USERNAME", usernameValue);
                intent.putExtra("GENDER", genderValue);

                startActivity(intent);
            }
        });
    }
}
