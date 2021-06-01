package com.example.temi_app;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import dataClass.Product;

public class P7 extends AppCompatActivity {

    private TableLayout tableLayout;

    String[] mydata = {};

    private String[] menu = {"XD"};
    private String[] piece = {"XD"};
    private String[] price= {"XD"};

    private int padding_left =20;
    private int padding_top =10;
    private int padding_right =20;
    private int padding_botton =10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p7);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.P7_Custom_toolbar);
        //myToolbar.setTitle("Receipt");
        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getBaseContext(),"Press Back", Toast.LENGTH_LONG).show();
                finish();
            }
        });


        //getSupportActionBar().setTitle("My title");

        initView();
        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_p7, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.action_trash:
                //System.out.printf(String.valueOf(R.drawable.ic_arrow_back_black_24dp));
                Toast.makeText(getBaseContext(),"Press trash", Toast.LENGTH_LONG).show();
                //super.finish();
                break;
                //return super.onOptionsItemSelected(item);

            //press trash do whattt???????

            default:
                return super.onOptionsItemSelected(item);
                    //break;
        }
        return true;
    }

    private void initView() {
        tableLayout = (TableLayout) findViewById(R.id.tableLayoutProduct);
    }

    private void loadData() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("som Tam...............", 1, 4));
        products.add(new Product("som Tam", 1, 4));
        products.add(new Product("som Tam", 1, 4));
        products.add(new Product("som Tam", 1, 4));
        products.add(new Product("som Tam", 1, 4));
        products.add(new Product("som Tam", 1, 4));
        products.add(new Product("som Tam", 1, 4));
        products.add(new Product("som Tam", 1, 4));
        products.add(new Product("som Tam", 1, 4));



        createColumns();

        fillData(products);

    }

    private void createColumns() {
        TableRow tableRow = new TableRow(this);
        tableRow.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT,
                1.0f));

        // Id Column
        TextView textViewId = new TextView(this);
        textViewId.setText("Menu");
        textViewId.setTextSize(25);
        textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewId.setPadding( padding_left, padding_top, padding_right, padding_botton);
        textViewId.setGravity(Gravity.CENTER);
        tableRow.addView(textViewId);

        // Name Column
        TextView textViewName = new TextView(this);
        textViewName.setText("Piece");
        textViewName.setTextSize(25);
        textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewName.setPadding(padding_left, padding_top, padding_right, padding_botton);

        textViewName.setGravity(Gravity.CENTER);


        tableRow.addView(textViewName);

        // Price Column
        TextView textViewPrice = new TextView(this);
        textViewPrice.setText("Price");
        textViewPrice.setTextSize(25);
        textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        textViewPrice.setPadding(padding_left, padding_top, padding_right, padding_botton);

        textViewPrice.setGravity(Gravity.CENTER);


        tableRow.addView(textViewPrice);


        tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));


    }

    private void fillData(List<Product> products) {
        for (Product product : products) {
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));

            tableRow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TableRow currentRow = (TableRow) view;
                    TextView textViewId = (TextView) currentRow.getChildAt(0);
                    String id = textViewId.getText().toString();
                    Toast.makeText(getApplicationContext(), id, Toast.LENGTH_LONG).show();
                }
            });

            // Menu Column
            TextView textViewId = new TextView(this);
            textViewId.setText(product.getmenu());
            textViewId.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewId.setPadding(padding_left, padding_top, padding_right, padding_botton);
            textViewId.setGravity(Gravity.CENTER);
            tableRow.addView(textViewId);

            // piece Column
            TextView textViewName = new TextView(this);
            textViewName.setText(String.valueOf(product.getpiece()));
            textViewName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewName.setPadding(padding_left, padding_top, padding_right, padding_botton);
            textViewName.setGravity(Gravity.CENTER);
            tableRow.addView(textViewName);

            // Price Column
            TextView textViewPrice = new TextView(this);
            textViewPrice.setText(String.valueOf(product.getPrice()) + " Bath"  );
            textViewPrice.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textViewPrice.setPadding(padding_left, padding_top, padding_right, padding_botton);
            textViewPrice.setGravity(Gravity.CENTER);
            tableRow.addView(textViewPrice);


            tableLayout.addView(tableRow, new TableLayout.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
        }
    }


}