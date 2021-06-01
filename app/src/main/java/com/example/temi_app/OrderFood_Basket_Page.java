package com.example.temi_app;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class OrderFood_Basket_Page extends AppCompatActivity  {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderfood_basket_page);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_orderfood_basket); //find tool bar
        setSupportActionBar(toolbar);//show tool bar

        //back button on toolbar have to follow set Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
