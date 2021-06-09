package com.example.temi_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dataClass.OrderFood_Adapter_Basket;
import dataClass.OrderFood_Adapter_Card_vertical;
import dataClass.OrderFood_Basket_Data;


public class OrderFood_Basket_Page extends AppCompatActivity  {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderfood_basket_page);

        //keep username from OrderFood page and send it to server for get data
        //data from server is String name of store and array of menu(name menu and price)
        //this is simulator data
        String Name_Store = "Store Food";
        String[][] Data = {{"Menu1","10"},{"Menu2","10"},{"Menu3","10"},{"Menu4","10"},{"Menu5","10"}};

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_orderfood_basket); //find tool bar
        setSupportActionBar(toolbar);//show tool bar

        //back button on toolbar have to follow set Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //set name store
        TextView nameStore = findViewById(R.id.name_store);
        nameStore.setText(Name_Store);

        //add data from server to OrderFood_Basket_Data
        RecyclerView recyclerView_Basket = findViewById(R.id.recycleview_menu); //define variable of RecyclerView and provide = reycleview_Recommend
        recyclerView_Basket.setHasFixedSize(true);
        recyclerView_Basket.setLayoutManager(new LinearLayoutManager(this)); // about horizontal

        List<OrderFood_Basket_Data> data_for_basket = new ArrayList<>();

        for(int j=0; j<Data.length;j++){
            //change string to int
            int price = Integer.parseInt(Data[j][1]);
            //add data into list
            data_for_basket.add(new OrderFood_Basket_Data(Data[j][0],price));

        }

        //and size of list sss is 3 if it's data of Recommend
        System.out.println(data_for_basket.get(1)); //show : dataClass.OrderFood_Data@d8117e1 if it's data of Recommend
        System.out.println(data_for_basket.get(1).getName_menu()); //show : store3 if it's data of Recommend

        OrderFood_Adapter_Basket orderFood_adapter_basket = new OrderFood_Adapter_Basket(data_for_basket,OrderFood_Basket_Page.this);
        recyclerView_Basket.setAdapter(orderFood_adapter_basket);//set that recyclerView_Recommend(reclycleview_recommend)






    }
}
