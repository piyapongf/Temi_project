package com.example.temi_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import dataClass.OrderFood_Adapter_Card_horizontal;
import dataClass.OrderFood_Data;
import dataClass.Product;

public class OrderFood_Page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    //sent username to server for get **receipt **order and order history **basket

    //receipt
    String ReceiptExist = "n"; //get this form server by ues username to request

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



    ListAdapter adapter_store;


    //For Recycle view horizontal
    LinearLayoutManager HorizontalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderfood_page); //set to show activity order food page

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar); //find tool bar
        setSupportActionBar(toolbar);//show tool bar

        //icon menu on left
        drawer = findViewById(R.id.drawer_layout_orderfood);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
            //this is code for navigation to anther page
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //For show Recommend
        RecyclerView recyclerView_Recommend = findViewById(R.id.recycleview_recommend); //define variable of RecyclerView and provide = reycleview_Recommend
        recyclerView_Recommend.setHasFixedSize(true);
        recyclerView_Recommend.setLayoutManager(new LinearLayoutManager(this)); // about horizontal

            //OrderFood_card is class that store name,category and image
        List<OrderFood_Data> listRecommend= new ArrayList<>(); //it's list for keeping String[][] data form OrderFood_Page

        for(int j=0; j<OrderFood_Data_Recommend.length;j++){
            //add data into list
            listRecommend.add(new OrderFood_Data(OrderFood_Data_Recommend[j][0],OrderFood_Data_Recommend[j][1],OrderFood_Data_Recommend[j][2]));

        }

        HorizontalLayout = new LinearLayoutManager(OrderFood_Page.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_Recommend.setLayoutManager(HorizontalLayout);

        OrderFood_Adapter_Card_horizontal orderFood_adapter_Rcard = new OrderFood_Adapter_Card_horizontal(listRecommend,OrderFood_Page.this);
        recyclerView_Recommend.setAdapter(orderFood_adapter_Rcard);//set that recyclerView_Recommend(reclycleview_recommend) store data of orderFood_adapter_Rcard(oredrF_Rcard)

            //text click Recommend
        TextView tvr=(TextView)findViewById(R.id.textclick_recommend);
        tvr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(OrderFood_Page.this,OrderFood_More_Page.class);
                Bundle b= new Bundle(); //declare Bundle for send 2D array
                i.putExtra("zone","Recommend");
                //b.putIntegerArrayListExtra(String name, ArrayList<Integer> value);
                //b.putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value);
                //b.putStringArrayListExtra(String name, ArrayList<String> value);
                b.putSerializable("store",OrderFood_Data_Recommend); //put 2D array into b
                //bundleInstance.putSerializable("store", OrderFood_Data_Recommend);
                i.putExtra("store",b);//send b by putExtra of intent
                //have to send something to next page for get data from server
                startActivity(i);
                Toast.makeText(getBaseContext(), "Press go to recommend", Toast.LENGTH_LONG).show();
                //perform your action here
            }
        });


        //For show Sohot
        RecyclerView recyclerView_Sohot = findViewById(R.id.recycleview_sohot);
        recyclerView_Sohot.setHasFixedSize(true);
        recyclerView_Sohot.setLayoutManager(new LinearLayoutManager(this));

        List<OrderFood_Data> listSohot= new ArrayList<>(); //it's list for keeping String[][] data form OrderFood_Page

        for(int c=0; c<OrderFood_Data_SoHot.length;c++){
            //add data into list
            listSohot.add(new OrderFood_Data(OrderFood_Data_SoHot[c][0],OrderFood_Data_SoHot[c][1],OrderFood_Data_SoHot[c][2]));

        }

        HorizontalLayout = new LinearLayoutManager(OrderFood_Page.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_Sohot.setLayoutManager(HorizontalLayout);

        OrderFood_Adapter_Card_horizontal orderFood_adapter_Scard = new OrderFood_Adapter_Card_horizontal(listSohot,OrderFood_Page.this);
        recyclerView_Sohot.setAdapter(orderFood_adapter_Scard);
            //text click Recommend
        TextView tvs=(TextView)findViewById(R.id.textclick_sohot);
        tvs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(OrderFood_Page.this,OrderFood_More_Page.class);
                Bundle b= new Bundle(); //declare Bundle for send 2D array
                //Intent i = new Intent(getApplicationContext(),More_OrderFood_Page.class);
                i.putExtra("zone","So Hot");
                b.putSerializable("store",OrderFood_Data_SoHot); //put 2D array into b
                //i.putExtra("store",OrderFood_Data_Recommend); get from server
                i.putExtra("store",b);//send b by putExtra of intent
                startActivity(i);
                Toast.makeText(getBaseContext(), "Press go to sohot", Toast.LENGTH_LONG).show();
                //perform your action here
            }
        });


        //For show Total store
        RecyclerView recyclerView_Total = findViewById(R.id.recycleview_total);
        recyclerView_Total.setHasFixedSize(true);
        recyclerView_Total.setLayoutManager(new LinearLayoutManager(this));

        List<OrderFood_Data> listTotal= new ArrayList<>(); //it's list for keeping String[][] data form OrderFood_Page

        for(int k=0; k<OrderFood_Data_TotalStore.length;k++){
            //add data into list
            listTotal.add(new OrderFood_Data(OrderFood_Data_TotalStore[k][0],OrderFood_Data_TotalStore[k][1],OrderFood_Data_TotalStore[k][2]));

        }

        HorizontalLayout = new LinearLayoutManager(OrderFood_Page.this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_Total.setLayoutManager(HorizontalLayout);

        OrderFood_Adapter_Card_horizontal orderFood_adapter_Tdata = new OrderFood_Adapter_Card_horizontal(listTotal,OrderFood_Page.this);
        recyclerView_Total.setAdapter(orderFood_adapter_Tdata);

            //text click total
        TextView tvt=(TextView)findViewById(R.id.textclick_total);
        tvt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(OrderFood_Page.this,OrderFood_More_Page.class);
                Bundle b= new Bundle(); //declare Bundle for send 2D array
                //Intent i = new Intent(getApplicationContext(),More_OrderFood_Page.class);
                i.putExtra("zone","Total Store");
                b.putSerializable("store",OrderFood_Data_TotalStore); //put 2D array into b
                //i.putExtra("store",OrderFood_Data_Recommend); get from server
                i.putExtra("store",b);//send b by putExtra of intent
                startActivity(i);
                Toast.makeText(getBaseContext(), "Press go to total", Toast.LENGTH_LONG).show();
                //perform your action here
            }
        });

    }

    //for menu on left
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_order:
                Intent i = new Intent(OrderFood_Page.this,P9.class);
                startActivity(i); //have to send order if have it
                Toast.makeText(getBaseContext(), "Press order", Toast.LENGTH_LONG).show(); //go to basket page
                break;
            case R.id.nav_profile:
                Toast.makeText(getBaseContext(), "Press profile", Toast.LENGTH_LONG).show(); //go to basket page
                break;
            case R.id.nav_payment:
                Toast.makeText(getBaseContext(), "Press payment", Toast.LENGTH_LONG).show(); //go to basket page
                break;
            case R.id.nav_support:
                Toast.makeText(getBaseContext(), "Press support", Toast.LENGTH_LONG).show(); //go to basket page
                break;
            case R.id.nav_logout:
                Toast.makeText(getBaseContext(), "Press logout", Toast.LENGTH_LONG).show(); //go to basket page
                break;

        }
        return true;
    }

    //show menu on top bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_orderfood_header, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            //to receipt page
            case R.id.ic_receipt_white:
                if(ReceiptExist == "y"){
                    Intent i = new Intent(OrderFood_Page.this,P7.class);
                    //and send username
                    startActivity(i);

                }
                else if (ReceiptExist == "n"){
                    Intent i = new Intent(OrderFood_Page.this,P7_No_Receipt.class);
                    //dont send anything
                    startActivity(i);
                }
                //Intent i = new Intent(OrderFood_Page.this,P7.class);
                //startActivity(i); //have to send order if have it
                //System.out.printf(String.valueOf(R.drawable.ic_arrow_back_black_24dp));
                Toast.makeText(getBaseContext(), "Press order", Toast.LENGTH_LONG).show(); //go to order page
                //super.finish();
                break;
            //return super.onOptionsItemSelected(item);

            //press trash do whattt??????? ans: for delete

            case R.id.ic_basket:
                Toast.makeText(getBaseContext(), "Press basket", Toast.LENGTH_LONG).show(); //go to basket page

            default:
                return super.onOptionsItemSelected(item);
            //break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}