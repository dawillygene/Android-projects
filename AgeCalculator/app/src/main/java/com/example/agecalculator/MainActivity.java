package com.example.agecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DatePicker birthdatePicker;
    private DatePicker currentDatePicker;
    private TextView answerTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        birthdatePicker = findViewById(R.id.birthdate);
        currentDatePicker = findViewById(R.id.currentState);
        answerTextView = findViewById(R.id.answer);
        calculateButton = findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int currentYear = currentDatePicker.getYear();
                int currentMonth = currentDatePicker.getMonth();
                int currentDay = currentDatePicker.getDayOfMonth();


                int birthYear = birthdatePicker.getYear();
                int birthMonth = birthdatePicker.getMonth();
                int birthDay = birthdatePicker.getDayOfMonth();


                int age = currentYear - birthYear;


                if (currentMonth < birthMonth || (currentMonth == birthMonth && currentDay < birthDay)) {
                    age--;
                }


                answerTextView.setText(String.valueOf(age));
            }
        });
    }
}
