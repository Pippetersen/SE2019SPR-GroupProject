package com.example.groupproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;

import Model.Customer;
import Model.CustomerDB;
import Model.FileData;

import static Model.FileData.*;

public class MainActivity extends AppCompatActivity implements  CustomerRecyclerView.ItemClickListener {
    private CustomerRecyclerView adapter;
    //Create and run the recyclerview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CHRIS- Make these two lines work
        FileData fdObj = new FileData();
        CustomerDB custDBObj = new CustomerDB();
        custDBObj.addCustomer(new Customer("Bill","email@gmail.com","512-123-4232"));
        //Load in the customer DB file into the obj
        ArrayList<Customer> client = new ArrayList<>();
        try {
            LoadData(client,getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
        //Toast.makeText("This is the test toast", Toast.LENGTH_SHORT).show();
    }
}
