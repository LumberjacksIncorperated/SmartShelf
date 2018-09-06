package com.example.i346794.smartshelf;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NoteActivity extends BaseActivity {

    private EditText noteEditText;
    private TextView noteTextView;
    private DatabaseHelper db;

    @Override
    protected void initialiseActivity() {
        setContentView(R.layout.activity_note);
        this.initalizeDatabaseHelper();
        this.initializeButtons();
        this.initializeTextViews();
    }

    private void initalizeDatabaseHelper(){
        db = new DatabaseHelper(this);
    }

    private void initializeTextViews() {
        noteEditText = this.findViewById(R.id.noteEditText);
        noteTextView = this.findViewById(R.id.noteTextView);
    }

    private void initializeButtons() {
        Button addNote = this.findViewById(R.id.addNoteButton);
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
