package dataClass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.temi_app.OrderFood_Basket_Page;
import com.example.temi_app.OrderFood_Page;
import com.example.temi_app.R;

import java.util.List;


public class OrderFood_Adapter_Basket extends RecyclerView.Adapter<OrderFood_Adapter_Basket .ViewHolder> {
    //variable
    List<OrderFood_Basket_Data> orderFood_basket_data;
    Context context;


    public OrderFood_Adapter_Basket (List orderFood_basket_data, OrderFood_Basket_Page orderFood_basket_page) {
        this.orderFood_basket_data= orderFood_basket_data; //this class
        this.context = orderFood_basket_page; //class of page have showed

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //idk
        View view = layoutInflater.inflate(R.layout.card_my_order_inbasket,parent,false); //call file xml that separate
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder; //return file xlm to show
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final OrderFood_Basket_Data orderFood_basket_list = orderFood_basket_data.get(position); //keep data each position of orderFood_Card in OrderFood_Page
        holder.textview_name_menu.setText(orderFood_basket_list.getName_menu());

        holder.textview_price_menu.setText(String.valueOf(orderFood_basket_list.getPrice_menu()));
        //holder.imageview_store.setImageResource(orderFood_card_list.getPicture_store()); //for int image

        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Click --> something happen
                Toast.makeText(context,"goto"+ orderFood_basket_list.getName_store(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return orderFood_basket_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textview_name_menu;
        TextView textview_price_menu;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            textview_name_menu = itemView.findViewById(R.id.textview_name);
            textview_price_menu = itemView.findViewById(R.id.textview_price);

        }
    }

}
