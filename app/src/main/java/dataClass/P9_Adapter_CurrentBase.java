package dataClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.temi_app.R;

import java.util.ArrayList;


public class P9_Adapter_CurrentBase extends BaseAdapter {

    ArrayList<P9_itemCurrent> orderList = new ArrayList<P9_itemCurrent>();


    Context context;
    LayoutInflater inflater;


    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.p9_card_waiting, parent, false );

            TextView textViewNameCurrent = convertView.findViewById(R.id.P9_itemName);
            textViewNameCurrent.setText(orderList.get(position).getName());




        }



        return convertView;
    }

    public P9_Adapter_CurrentBase(Context con, ArrayList objects)
    {
        this.context = con;
        this.orderList = objects;

    }

}
