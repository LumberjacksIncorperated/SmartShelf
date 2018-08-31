package com.example.i346794.smartshelf;
//--------------------------------------------------------
//
// DESCRIPTION
// -----------
// This controls the screen where you choose the item
// for which you wish to change the price of
//
// AUTHOR
// ------
// Robert Charlton (i346794)
//
//--------------------------------------------------------

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SmartShelfPriceAllocationItemChoiceActivity extends BaseActivity {

    private Spinner itemChoiceDropDownMenu;
    private static final String[] itemChoiceNamesList = {"Choose Item","item one", "item two", "item three", "item four", "item five", "item six", "item seven", "item eight"};

    private final int SMART_SHELF_PRICE_ALLOCATION_ITEM_CHOICE_UI_LAYOUT = R.layout.activity_smart_shelf_price_allocation_item_choice;
    @Override
    protected void initialiseActivity() {
        this.setContentView(SMART_SHELF_PRICE_ALLOCATION_ITEM_CHOICE_UI_LAYOUT);
        this.setupItemChoiceDropDownMenuOnScreen();
    }

    private void setupItemChoiceDropDownMenuOnScreen() {
        itemChoiceDropDownMenu = findViewById(R.id.itemChoiceDropDownMenu);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SmartShelfPriceAllocationItemChoiceActivity.this, android.R.layout.simple_spinner_item,itemChoiceNamesList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemChoiceDropDownMenu.setAdapter(adapter);
        itemChoiceDropDownMenu.setOnItemSelectedListener(this.whenItemIsChosenFromDropDownListGoToPriceAllocationScreen());
    }

    private AdapterView.OnItemSelectedListener whenItemIsChosenFromDropDownListGoToPriceAllocationScreen() {
        return new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SmartShelfPriceAllocationItemChoiceActivity.this.itemHasBeenSelected(position);
            }
            public void onNothingSelected(AdapterView<?> parent) {
                return;
            }
        };
    }

    private final int NO_ITEM_CHOSEN = 0;
    public void itemHasBeenSelected(int possibleItemChoice) {
        if(possibleItemChoice == NO_ITEM_CHOSEN) {
            return;
        } else {
            this.sendItemToAndStartPriceAllocationActivity(possibleItemChoice);
        }
    }

    private void sendItemToAndStartPriceAllocationActivity(int itemChoice) {
        Intent intent = new Intent(getBaseContext(), SmartShelfPriceAllocationActivity.class);
        String itemChoiceAsString = new Integer(itemChoice).toString();
        intent.putExtra("ITEM_CHOICE", itemChoiceAsString);
        startActivity(intent);
    }
}