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

public class HomeScreenActivity extends BaseActivity {

    private final int HOME_SCREEN_MAIN_UI_LAYOUT = R.layout.activity_home_screen;
    @Override
    protected void initialiseActivity() {
        this.setContentView(HOME_SCREEN_MAIN_UI_LAYOUT);
    }

    @Override
    protected void whenUserTouchesScreen() {
        HomeScreenActivity.this.moveToSmartShelfPriceAllocationItemChoiceActivity();
    }

    private void moveToSmartShelfPriceAllocationItemChoiceActivity() {
        Context applicationContext = this.getApplicationContext();
        Intent intentToMoveToTheSmartShelfPriceAllocationItemChoiceActivity = new Intent(applicationContext, SmartShelfPriceAllocationItemChoiceActivity.class);
        this.startActivity(intentToMoveToTheSmartShelfPriceAllocationItemChoiceActivity);
    }
}
