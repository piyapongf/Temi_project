package com.example.temi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dataClass.OrderFood_Adapter_Card_vertical;
import dataClass.OrderFood_Data;

public class OrderFood_More_Page  extends AppCompatActivity {

    //those data have to get from the server
    String[][] OrderFood_Data_TotalStore = {
            {"Store1","Food and Drink","pic1"},
            {"Store2","Drinking","pic2"},
            {"Store3","Food and Drink","pic3"},
            {"Store4","Food","pic4"},
            {"Store5","Food and Drink","pic5"},
            {"Store6","Food","pic6"}};
    String[][] OrderFood_Data_Recommend= {
            {"Store1","Food and Drink","pic1"},
            {"Store3","Food and Drink","pic3"},
            {"Store4","Food","pic4"}};
    String[][] OrderFood_Data_SoHot = {
            {"Store2","Food and Drink","pic2"},
            {"Store5","Drinking","pic5"},
            {"Store6","Food and Drink","pic3"}};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderfood_more_page); //set to show activity order food page

        //get data from order food page
        Intent i = getIntent();
        String zone = i.getStringExtra("zone");

        //retrieve 2D array from Orderfood_page
        Bundle bundleInstance = i.getBundleExtra("store");
        String[][] data = (String[][]) bundleInstance.getSerializable("store"); //keep 2D array in data


        TextView textZone = findViewById(R.id.textview_zone);
        textZone.setText(zone);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_more_orderfood); //find tool bar
        setSupportActionBar(toolbar);//show tool bar

        //back button on toolbar have to follow set Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView_Recommend = findViewById(R.id.recycleview_main); //define variable of RecyclerView and provide = reycleview_Recommend
        recyclerView_Recommend.setHasFixedSize(true);
        recyclerView_Recommend.setLayoutManager(new LinearLayoutManager(this)); // about horizontal

        //OrderFood_card is class that store name,category and image
        List<OrderFood_Data> sss= new ArrayList<>(); //it's list for keeping String[][] data form OrderFood_Page

        for(int j=0; j<data.length;j++){
            //add data into list
            sss.add(new OrderFood_Data(data[j][0],data[j][1],data[j][2]));

        }

        //and size of list sss is 3 if it's data of Recommend
        System.out.println(sss.get(1)); //show : dataClass.OrderFood_Data@d8117e1 if it's data of Recommend
        System.out.println(sss.get(1).getName_store()); //show : store3 if it's data of Recommend

        OrderFood_Adapter_Card_vertical orderFood_adapter_Rcard = new OrderFood_Adapter_Card_vertical(sss,OrderFood_More_Page.this);
        recyclerView_Recommend.setAdapter(orderFood_adapter_Rcard);//set that recyclerView_Recommend(reclycleview_recommend)


    }

    //Search icon menu on toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_more_orderfood_page, menu);
        return true;
    }
}
