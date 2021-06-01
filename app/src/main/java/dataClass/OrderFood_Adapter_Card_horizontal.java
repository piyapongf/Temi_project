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

import com.example.temi_app.OrderFood_Page;
import com.example.temi_app.R;

import java.util.List;


public class OrderFood_Adapter_Card_horizontal extends RecyclerView.Adapter<OrderFood_Adapter_Card_horizontal.ViewHolder> {
    //variable
    List<OrderFood_Data> orderFood_data;
    Context context;


    public OrderFood_Adapter_Card_horizontal(List orderFood_data, OrderFood_Page orderFood_page) {
        this.orderFood_data = orderFood_data; //this class
        this.context = orderFood_page; //class of page have showed

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //idk
        View view = layoutInflater.inflate(R.layout.card_new_horizontal_orderfood,parent,false); //call file xml that separate
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder; //return file xlm to show
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final OrderFood_Data orderFood_card_list = orderFood_data.get(position); //keep data each position of orderFood_Card in OrderFood_Page
        holder.textview_name_store.setText(orderFood_card_list.getName_store());
        holder.textview_category_store.setText(orderFood_card_list.getCategory_store());
        holder.imageview_store.setTag(orderFood_card_list.getPicture_store()); //for image
        //holder.imageview_store.setImageResource(orderFood_card_list.getPicture_store()); //for int image

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Click --> something happen
                Toast.makeText(context,"goto"+ orderFood_card_list.getName_store(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderFood_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageview_store;
        TextView textview_name_store;
        TextView textview_category_store;

        public ViewHolder(@NonNull  View itemView) {
            super(itemView);
            imageview_store = itemView.findViewById(R.id.imageview_store); //id of ImageView in card_horizontal_orederfood layout
            textview_name_store = itemView.findViewById(R.id.name_store);
            textview_category_store = itemView.findViewById(R.id.category_store);

        }
    }

}
