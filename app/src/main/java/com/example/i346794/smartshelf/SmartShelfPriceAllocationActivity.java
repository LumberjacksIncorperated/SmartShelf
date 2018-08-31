package com.example.i346794.smartshelf;

//--------------------------------------------------------
// AUTHOR
// ------
// Robert Charlton (i346794)
//--------------------------------------------------------

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmartShelfPriceAllocationActivity extends BaseActivity {

    private EditText priceInputTextFieldForItem;
    String itemIdentifier;

    private final int SMART_SHELF_PRICE_ALLOCATION_UI_LAYOUT = R.layout.activity_smart_shelf_price_allocation;
    @Override
    protected void initialiseActivity() {
        this.setContentView(SMART_SHELF_PRICE_ALLOCATION_UI_LAYOUT);
        itemIdentifier = getIntent().getStringExtra("ITEM_CHOICE");
        this.setupPriceAllocationInputFields();
        this.initialiseSendNewItemPricesToServerButton();
    }

    private void setupPriceAllocationInputFields() {
        priceInputTextFieldForItem = (EditText) this.findViewById(R.id.ItemEditText);
    }

    private void initialiseSendNewItemPricesToServerButton() {
        Button sendNewItemPriceAllocationToServerButton = (Button)this.findViewById(R.id.sendNewItemPriceAllocationsToServerButton);
        sendNewItemPriceAllocationToServerButton.setOnClickListener(this.whenSendInputTextMessageButtonIsPressedThenSendTheMessageFromTheTextBoxToRemoteServer());
    }

    private View.OnClickListener whenSendInputTextMessageButtonIsPressedThenSendTheMessageFromTheTextBoxToRemoteServer() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmartShelfPriceAllocationActivity.this.sendNewPriceToRemoteSever();
            }
        };
    }

    private void sendNewPriceAllocationToServer(String newPriceAllocationAsString) {
        RemoteServerAPI.sendNewPricesToRemoteServerWithThreeItemPrices(newPriceAllocationAsString, this.itemIdentifier);
        this.showMessageToUser("New Price Sent To Server!");
        this.goBackToItemChoiceActivity();
    }

    private void sendNewPriceToRemoteSever() {
        String newPriceForItemAsString = priceInputTextFieldForItem.getText().toString();
        if(checkPriceIsValid(newPriceForItemAsString)) {
            this.sendNewPriceAllocationToServer(newPriceForItemAsString);
        } else {
            this.showMessageToUser("Invalid Price! Try Again");
        }
    }

    private Boolean checkPriceIsValid(String potentialPrice) {
        try {
            Double.parseDouble(potentialPrice.trim());
            return true;
        }
        catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void goBackToItemChoiceActivity() {
        Context applicationContext = this.getApplicationContext();
        Intent intentToMoveToTheSmartShelfPriceAllocationItemChoiceActivity = new Intent(applicationContext, SmartShelfPriceAllocationItemChoiceActivity.class);
        this.startActivity(intentToMoveToTheSmartShelfPriceAllocationItemChoiceActivity);
    }
}
