package com.example.notebook;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText noteEditText;
    private Button saveButton;
    private TextView notesTextView;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "NotebookPrefs";
    // private static final String NOTES_KEY = "notes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteEditText = findViewById(R.id.noteEditText);
        saveButton = findViewById(R.id.saveButton);
        notesTextView = findViewById(R.id.notesTextView);

        sharedPreferences = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);
        String savedNotes = sharedPreferences.getString("notes","");
        notesTextView.setText("Notes are : " + "\n\n" + savedNotes);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String note  = noteEditText.getText().toString();
                if(!note.isEmpty()){

                    String savedNotes = sharedPreferences.getString("notes","");
                    savedNotes += note + "\n\n";
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("notes",savedNotes);
                    editor.apply();
                    notesTextView.setText("Notes are : \n\n" + savedNotes);
                    noteEditText.setText("");
                    
                }
        
            }
        });
    }
}