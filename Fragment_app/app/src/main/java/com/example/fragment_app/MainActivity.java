package com.example.fragment_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    Button btnArusha, btnMwanza, btnDodoma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new ArushaFragment());


        btnArusha = findViewById(R.id.btnArusha);
        btnDodoma = findViewById(R.id.btnDodoma);
        btnMwanza = findViewById(R.id.btnMwanza);

        btnArusha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 replaceFragment(new ArushaFragment());
            }
        });

        btnMwanza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new MwanzaFragment());
            }
        });

        btnDodoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new DodomaFragment());
            }
        });



    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();


    }


}