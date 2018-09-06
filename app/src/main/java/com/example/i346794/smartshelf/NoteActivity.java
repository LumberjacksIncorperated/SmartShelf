package com.example.i346794.smartshelf;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends BaseActivity {

    private List<Note> notesList = new ArrayList<>();
    private EditText noteEditText;
    private TextView noteTextView;
    private DatabaseHelper db;
    private int IDcounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        db = new DatabaseHelper(this);
        notesList.addAll(db.getAllNotes());
        noteEditText = this.findViewById(R.id.noteEditText);
        noteTextView = this.findViewById(R.id.noteTextView);
        Button addNote = (Button)this.findViewById(R.id.moveToSmartShelfActivity);
        addNote.setOnClickListener(this.whenButtonPressedAddNote());
    }

    private View.OnClickListener whenButtonPressedAddNote() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = noteEditText.getText().toString();
                long id = db.insertNote(text);
                Note n = db.getNote(id);
                String text2 = n.getNote();
                noteTextView.setText(text2);
            }
        };
    }
}
