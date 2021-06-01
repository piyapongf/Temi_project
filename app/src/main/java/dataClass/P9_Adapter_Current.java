package dataClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.temi_app.R;

import java.util.ArrayList;
import java.util.Arrays;

public class P9_Adapter_Current extends ArrayAdapter {

    ArrayList<P9_itemCurrent> orderList = new ArrayList<P9_itemCurrent>();


    Context context;
    LayoutInflater inflater;

    public P9_Adapter_Current(@NonNull Context context, int resource, ArrayList objects) {
        super(context, resource);

        this.context = context;
        orderList = objects;

        System.out.println("==============P9_Adapter_Current==============");

        for(int i=0;i<orderList.size() ;i++)
        {
            System.out.format("[    Current ]%s -> %s\n",orderList.get(i).getName(), Arrays.toString(orderList.get(i).getMenu()));
            //System.out.println("164");
        }
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        System.out.println("Test Cu 00");

        if(inflater == null)
        {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.p9_card_waiting,null);
        }

        TextView textViewName = convertView.findViewById(R.id.P9_itemName);
        textViewName.setText(orderList.get(position).getName());

        return convertView;//super.getView(position, convertView, parent);



    }
}
