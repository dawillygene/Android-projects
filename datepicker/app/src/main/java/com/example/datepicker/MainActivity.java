package com.example.datepicker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatePicker dpDob,dpCd;
    Button calculate;
    TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dpDob = findViewById(R.id.dob_picker);
        dpCd = findViewById(R.id.current_date_picker);
        calculate = findViewById(R.id.btn_calculate);
        answer = findViewById(R.id.tv_age_result);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int dobDay = dpDob.getDayOfMonth();
                int dobMonth = dpDob.getMonth();
                int dobYear = dpDob.getYear();

                int cdDay = dpCd.getDayOfMonth();
                int cdMonth = dpCd.getMonth();
                int cdYear = dpCd.getYear();

                int age = cdYear - dobYear;

                if(cdMonth < dobMonth){
                    age--;
                }else if(cdMonth == dobMonth){
                    if(cdDay < dobDay){
                        age--;
                    }
                }

                answer.setText("The Age is: " + age);

            }
        });


    }
}