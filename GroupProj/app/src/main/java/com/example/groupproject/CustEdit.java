package com.example.groupproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import Model.Customer;

public class CustEdit extends AppCompatActivity {

    private Customer aCustomer;
    private EditText mtvName, mtvNum, mtvEmail;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_edit);

        aCustomer = (Customer) getIntent().getSerializableExtra("aCust");
        mtvName = findViewById(R.id.tvEditName);
        mtvNum = findViewById(R.id.tvEditNumber);
        mtvEmail = findViewById(R.id.tvEditEmail);
        mButton = findViewById(R.id.butEditGoBack);

        mtvName.setText(aCustomer.getName());
        mtvNum.setText(aCustomer.getNumber());
        mtvEmail.setText(aCustomer.getMail());

        //Handles saving and passing data back to the main
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the current text from the fields
                aCustomer.setName(mtvName.getText().toString());
                aCustomer.setPhoneNumber(mtvNum.getText().toString());
                aCustomer.setMail(mtvEmail.getText().toString());
                setSaveResult(aCustomer);
                finish();
            }
        });
    }

    private void setSaveResult(Customer tCust) {
        //Make the intent
        Intent intent = new Intent();
        intent.putExtra("editCust", aCustomer);
        //Send off the result and close activity
        setResult(RESULT_OK, intent);
    }

}
