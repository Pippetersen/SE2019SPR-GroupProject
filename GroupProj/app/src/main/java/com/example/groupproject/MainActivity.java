package com.example.groupproject;


import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.IOException;

import Model.Customer;
import Model.CustomerDB;
import Model.FileData;

public class MainActivity extends AppCompatActivity implements CustomerRecyclerView.ItemClickListener {
    private CustomerRecyclerView adapter;
    private int mLastClickedPos;
    private static final int REQUEST_EDIT_CODE = 0;
    private CustomerDB custDBObj;

    //Create and run the recyclerview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custDBObj = new CustomerDB();
        //Ask for permission to edit data in device
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
        }
        //Load in the customer DB file into the obj
        try {
            FileData.LoadData(custDBObj,this);
        } catch (IOException e) {
            e.printStackTrace();
            //Testing to add customer to DB
            custDBObj.addCustomer(new Customer("Bill","email@gmail.com","512-123-4232"));
            custDBObj.addCustomer(new Customer("Mike","email@gmail.com","512-123-4232"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            //Testing to add customer to DB
            custDBObj.addCustomer(new Customer("Bill", "email@gmail.com", "512-123-4232"));
            custDBObj.addCustomer(new Customer("Mike", "email@gmail.com", "512-123-4232"));
        }

        RecyclerView recyclerView = findViewById(R.id.rvCustomers);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomerRecyclerView(this, custDBObj);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    //This is the on click for the expand customer
    @Override
    public void onItemClick(View view, int position) {
        //This is story 2
        mLastClickedPos = position;
        Intent intent = new Intent(this, CustEdit.class);
        intent.putExtra("aCust", adapter.getMData().get(position));
        startActivityForResult(intent, REQUEST_EDIT_CODE);
    }
    //This is the data disassembler for receiving edited customers
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode != Activity.RESULT_OK) {
            return;
        }
        if(requestCode == REQUEST_EDIT_CODE) {
            if(data != null) {
                Customer tempCust = (Customer) data.getSerializableExtra("editCust");
                adapter.getMData().get(mLastClickedPos).setName(tempCust.getName());
                adapter.getMData().get(mLastClickedPos).setPhoneNumber(tempCust.getNumber());
                adapter.getMData().get(mLastClickedPos).setMail(tempCust.getMail());
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //Save to a file
        try {
            FileData.SaveData(custDBObj,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
