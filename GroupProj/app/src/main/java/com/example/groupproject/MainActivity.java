package com.example.groupproject;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.security.Permission;
import java.util.ArrayList;

import Model.Customer;
import Model.CustomerDB;
import Model.FileData;

import static Model.FileData.*;

public class MainActivity extends AppCompatActivity implements  CustomerRecyclerView.ItemClickListener {
    CustomerRecyclerView adapter;
    CustomerDB custDBObj = new CustomerDB();

    //Create and run the recyclerview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //CHRIS- Make these two lines work
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
        }

        custDBObj.addCustomer(new Customer("Bill","email@gmail.com","512-123-4232"));
        custDBObj.addCustomer(new Customer("Mike","email@gmail.com","512-123-4232"));



        for(Customer hold : custDBObj.getAll())                     //Loads all of objects into specified file
        {

            Toast.makeText(this,hold.getName(), Toast.LENGTH_SHORT).show();

        }

      // Toast.makeText(this,custDBObj.get(0).getName(), Toast.LENGTH_SHORT).show();
        //Load in the customer DB file into the obj

        try {
            FileData.LoadData(custDBObj,this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileData.SaveData(custDBObj,this);
        } catch (IOException e) {
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
