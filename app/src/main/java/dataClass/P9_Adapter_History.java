package dataClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

//import com.example.armpage.R;

import com.example.temi_app.R;

import java.util.ArrayList;
import java.util.Arrays;


public class P9_Adapter_History extends ArrayAdapter {

    ArrayList<P9_item> orderList = new ArrayList<P9_item>();


    Context context;
    LayoutInflater inflater;


    public P9_Adapter_History(@NonNull Context context, int resource, ArrayList objects) {
        super(context, resource, objects);
        this.context = context;
        orderList = objects;
        System.out.println("==============P9_Adapter_History==============");

        for(int i=0;i<orderList.size() ;i++)
        {
            System.out.format("%s -> %s\n",orderList.get(i).getName(), Arrays.toString(orderList.get(i).getMenu()));
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

        System.out.println("Test History " + position);

    if(inflater == null)
    {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    if(convertView == null)
    {
        convertView = inflater.inflate(R.layout.p9_card_history,null);
    }
        TextView textViewName = convertView.findViewById(R.id.P9_itemName_history);
        textViewName.setText(orderList.get(position).getName());

        TextView textViewDate = (TextView) convertView.findViewById(R.id.P9_itemDate_history);
        textViewDate.setText(orderList.get(position).getDate());

        TextView textViewMenu = (TextView) convertView.findViewById(R.id.P9_itemMenu_history);

        String myMenu = "";

        for (int i=0; i<orderList.get(position).getMenu().length;i++)
        {
            if (myMenu.length() == 0)
            {
                myMenu += orderList.get(position).getSpMenu(i);
            }
            else if (myMenu.length()<20) // fix size of later IF MORE THAN NOT SHOWN
            {
                myMenu += ( ", "  +orderList.get(position).getSpMenu(i) );
            }
            else
            {
                break;
            }
        }


        textViewMenu.setText(myMenu);
        return convertView;
    }
}

