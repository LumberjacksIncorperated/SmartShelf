package com.example.i346794.smartshelf;

//--------------------------------------------------------
// AUTHOR
// ------
// Robert Charlton (i346794)
//--------------------------------------------------------

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends BaseActivity {

    private final int HOME_SCREEN_MAIN_UI_LAYOUT = R.layout.activity_home_screen;
    @Override
    protected void initialiseActivity() {
        this.setContentView(HOME_SCREEN_MAIN_UI_LAYOUT);
    }

    @Override
    protected void whenUserTouchesScreen()
    {
        HomeScreenActivity.this.moveToSmartShelfPriceAllocationActivity();
    }

    private void moveToSmartShelfPriceAllocationActivity() {
        Context applicationContext = this.getApplicationContext();
        Intent intentToMoveToTheSmartShelfPriceAllocationActivity = new Intent(applicationContext, SmartShelfPriceAllocationActivity.class);
        this.startActivity(intentToMoveToTheSmartShelfPriceAllocationActivity);
    }
}
