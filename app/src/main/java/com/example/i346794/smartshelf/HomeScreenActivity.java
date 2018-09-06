package com.example.i346794.smartshelf;
//--------------------------------------------------------
//
// DESCRIPTION
// -----------
// This screen is used to display the application purpose
// to the use, before moving on to another activity
//
// AUTHOR
// ------
// Robert Charlton (i346794)
//
//--------------------------------------------------------

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends BaseActivity {

    private final int HOME_SCREEN_MAIN_UI_LAYOUT = R.layout.activity_home_screen;
    @Override
    protected void initialiseActivity() {
        this.setContentView(HOME_SCREEN_MAIN_UI_LAYOUT);
        this.initializeButtons();
    }

    private void initializeButtons() {
        Button moveToNoteActivity = (Button)this.findViewById(R.id.moveToNoteActivity);
        moveToNoteActivity.setOnClickListener(this.whenNoteButtonPressedMoveToNoteActivity());
        Button moveToSmartShelfActivity = (Button)this.findViewById(R.id.moveToSmartShelfActivity);
        moveToSmartShelfActivity.setOnClickListener(this.whenShelfButtonPressedMoveToShelfActivity());
    }

    private View.OnClickListener whenNoteButtonPressedMoveToNoteActivity() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToActivity(NoteActivity.class);
            }
        };
    }

    private View.OnClickListener whenShelfButtonPressedMoveToShelfActivity() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToActivity(SmartShelfPriceAllocationItemChoiceActivity.class);
            }
        };
    }

    private void moveToActivity(Class<?> classToMoveToo) {
        Context applicationContext = this.getApplicationContext();
        Intent intentToMoveToActivity = new Intent(applicationContext, classToMoveToo);
        this.startActivity(intentToMoveToActivity);
    }
}
