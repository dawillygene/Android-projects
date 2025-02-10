package com.example.studentmanagementsystem;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    private ArrayList<Student> userArray;
    private RecyclerView recyclerView;
    private StudentAdapter adapter;
    private DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        db = new DatabaseHelper(this);
        userArray = db.readAllUsers();

        recyclerView = findViewById(R.id.view_Recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(true);
        adapter = new StudentAdapter(this,userArray);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);







    }
}