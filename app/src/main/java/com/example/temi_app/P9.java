package com.example.temi_app;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

import dataClass.P9_Adapter_CurrentBase;
import dataClass.P9_Adapter_History;
import dataClass.P9_item;
import dataClass.P9_itemCurrent;
import dataClass.expandGrid;

public class P9 extends AppCompatActivity {

    private expandGrid grid_current, grid_history;//GridView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p9);


        // Toolbar

        Toolbar myToolbar = (Toolbar) findViewById(R.id.P9_Custom_toolbar);
        TextView mTitle = (TextView) myToolbar.findViewById(R.id.P9_toolbar_title);

        setSupportActionBar(myToolbar);
        myToolbar.setNavigationIcon(R.drawable.ic_arrow_red);
        mTitle.setText("Order");

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getBaseContext(),"Press Back", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        //grid
        ArrayList orderCurrent = new ArrayList<>();
        ArrayList orderHistory = new ArrayList<>();

        grid_current = (expandGrid) findViewById(R.id.P9_Grid_CurrentOrder);

        orderCurrent.add(new P9_itemCurrent("NameCurrent0","date","Waiting",new String[] { "Name0_Order1", "Aloh55", "Testttt"} ));
        orderCurrent.add(new P9_itemCurrent("NameCurrent0","date","Waiting",new String[] { "Name0_Order1", "Aloh55", "Testttt"} ));
        orderCurrent.add(new P9_itemCurrent("NameCurrent0","date","Waiting",new String[] { "Name0_Order1", "Aloh55", "Testttt"} ));


        P9_Adapter_CurrentBase adapter_current = new P9_Adapter_CurrentBase(this, orderCurrent);//p9_card_waiting

        grid_current.setExpanded(true);

        grid_current.setAdapter(adapter_current);









        grid_history = (expandGrid) findViewById(R.id.P9_Grid_HistoryOrder);

        orderHistory.add(new P9_item("Name0","date",new String[] { "Name0_Order1", "Aloh", "Testttt"} ));
        orderHistory.add(new P9_item("Name1","date",new String[] { "Name1_Order1"} ));
        orderHistory.add(new P9_item("Name2","date",new String[] { "Name2_Order1"} ));
        orderHistory.add(new P9_item("Name2","date",new String[] { "Name2_Order1"} ));

        P9_Adapter_History adapter_history = new P9_Adapter_History(this, R.layout.p9_card_history, orderHistory);


        grid_history.setExpanded(true);

        grid_history.setAdapter(adapter_history);


    }
}