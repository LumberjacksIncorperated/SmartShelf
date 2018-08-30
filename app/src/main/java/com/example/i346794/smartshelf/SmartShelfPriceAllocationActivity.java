package com.example.i346794.smartshelf;

//--------------------------------------------------------
// AUTHOR
// ------
// Robert Charlton (i346794)
//--------------------------------------------------------

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SmartShelfPriceAllocationActivity extends BaseActivity {

    private EditText priceInputTextFieldForItemOne;
    private EditText priceInputTextFieldForItemTwo;
    private EditText priceInputTextFieldForItemThree;

    private final int SMART_SHELF_PRICE_ALLOCATION_UI_LAYOUT = R.layout.activity_smart_shelf_price_allocation;
    @Override
    protected void initialiseActivity() {
        this.setContentView(SMART_SHELF_PRICE_ALLOCATION_UI_LAYOUT);
        this.setupPriceAllocationInputFields();
        this.initialiseSendNewItemPriceAllocationsToServerButton();
    }

    private void setupPriceAllocationInputFields() {
        priceInputTextFieldForItemOne = (EditText) this.findViewById(R.id.ItemOneEditText);
        priceInputTextFieldForItemTwo = (EditText) this.findViewById(R.id.ItemTwoEditText);
        priceInputTextFieldForItemThree = (EditText) this.findViewById(R.id.ItemThreeEditText);
    }

    private void initialiseSendNewItemPriceAllocationsToServerButton() {
        Button sendNewItemPriceAllocationsToServerButton = (Button)this.findViewById(R.id.sendNewItemPriceAllocationsToServerButton);
        sendNewItemPriceAllocationsToServerButton.setOnClickListener(this.whenSendInputTextMessageButtonIsPressedThenSendTheMessageFromTheTextBoxToRemoteServer());
    }

    private View.OnClickListener whenSendInputTextMessageButtonIsPressedThenSendTheMessageFromTheTextBoxToRemoteServer() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmartShelfPriceAllocationActivity.this.sendTheMessageFromTheTextBoxToRemoteServer();
            }
        };
    }

    private void sendTheMessageFromTheTextBoxToRemoteServer() {
        String newPriceForItemOneAsString = priceInputTextFieldForItemOne.getText().toString();
        String newPriceForItemTwoAsString = priceInputTextFieldForItemTwo.getText().toString();
        String newPriceForItemThreeAsString = priceInputTextFieldForItemThree.getText().toString();
        RemoteServerAPI.sendNewPricesToRemoteServerWithThreeItemPrices(newPriceForItemOneAsString, newPriceForItemTwoAsString, newPriceForItemThreeAsString);
    }
}
