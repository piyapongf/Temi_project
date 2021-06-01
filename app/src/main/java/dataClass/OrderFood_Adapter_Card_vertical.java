package dataClass;

import android.content.Context; //send data during class
import android.view.LayoutInflater; //for variable keep layout
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.temi_app.OrderFood_More_Page;
import com.example.temi_app.R;

import java.util.List;

public class OrderFood_Adapter_Card_vertical extends RecyclerView.Adapter<OrderFood_Adapter_Card_vertical.ViewHolder> {
    List<OrderFood_Data> orderFood_data; //keep data in list form
    Context context;
    public OrderFood_Adapter_Card_vertical(List orderFood_data, OrderFood_More_Page more_orderFood_page) {
        this.orderFood_data = orderFood_data;
        this.context = more_orderFood_page;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_new_vertical_orderfood,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final OrderFood_Data orderFood_card_list = orderFood_data.get(position); //get for list form
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
