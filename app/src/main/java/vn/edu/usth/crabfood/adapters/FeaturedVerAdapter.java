package vn.edu.usth.crabfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import vn.edu.usth.crabfood.DataHelper;
import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.models.CartItem;
import vn.edu.usth.crabfood.models.FeaturedVerModel;
import java.util.List;

public class FeaturedVerAdapter extends RecyclerView.Adapter<FeaturedVerAdapter.ViewHolder> {
    List<FeaturedVerModel> list;
    public FeaturedVerAdapter(List<FeaturedVerModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_ver_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picasso.get().load(list.get(position).getImage()).error(R.drawable.nodata).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.rating.setText(list.get(position).getRating());
        holder.timing.setText(list.get(position).getTiming());
        String imgLink = list.get(position).getImage();
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartItem selectItem = new CartItem(holder.name.getText().toString(), Double.parseDouble(holder.timing.getText().toString()),
                        imgLink, Float.parseFloat(holder.rating.getText().toString()));

                boolean isContain = false;
                for (CartItem item : CartAdapter.cartItems)
                {
                    if (item.getName().equals(selectItem.getName()))
                    {
                        item.setQuantity(item.getQuantity() + 1);
                        isContain = true;
                        break;
                    }
                }

                if (!isContain) CartAdapter.cartItems.add(selectItem);
                DataHelper.saveData();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,description,rating,timing;
        Button button;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            description = itemView.findViewById(R.id.detailed_des);
            rating = itemView.findViewById(R.id.detailed_rating);
            timing = itemView.findViewById(R.id.detailed_timing);
            button = itemView.findViewById(R.id.addBtn);
        }
    }
}
