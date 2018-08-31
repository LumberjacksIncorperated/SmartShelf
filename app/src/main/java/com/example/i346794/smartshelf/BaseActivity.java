package com.example.i346794.smartshelf;
//--------------------------------------------------------
//
// DESCRIPTION
// -----------
// This class is designed as the base activity class
// which all other activities should extend
//
// AUTHOR
// ------
// Robert Charlton (i346794)
//
//--------------------------------------------------------

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

//----------------------------------------------------------------------------------------------------------------------
// SCHEMATIC FUNCTIONS
//----------------------------------------------------------------------------------------------------------------------
    protected void initialiseActivity() {
        /*
         *   This method is intended to be overriden by inheriting classes, and should
         *   contain the code required to initialize the activity
         */
    }

    protected void whenUserTouchesScreen() {
        /*
         *   This method is intended to be overriden by inheriting classes, and should
         *   contain the code required for when user touches the screen ever
         */
    }

//----------------------------------------------------------------------------------------------------------------------
// HIDDEN FUNCTIONS
//----------------------------------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initialiseActivity();
    }

    @Override
    public void onUserInteraction() {
        this.whenUserTouchesScreen();
    }

//----------------------------------------------------------------------------------------------------------------------
// EXPORTED FUNCTIONS
//----------------------------------------------------------------------------------------------------------------------
    protected void showMessageToUser(String messageToShowToUser) {
        Context applicationContext = this.getApplicationContext();
        Toast theToastMessageToShowToUser = Toast.makeText(applicationContext, messageToShowToUser, Toast.LENGTH_LONG);
        theToastMessageToShowToUser.show();
    }
}