
package vn.edu.usth.crabfood.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.models.CartItem;
import vn.edu.usth.crabfood.models.DetailedDailyModels;

public class DetailedDailyAdapter extends RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder> {

    List<DetailedDailyModels> list;



    public DetailedDailyAdapter(List<DetailedDailyModels> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.detailed_daily_meal_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Model for this ís DetailDailyModels, img change from id to link
        //for this we need to make some modify at DetailDailyMealActivity
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView);// Set image for detailed_daily_meal_item
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());
        holder.timing.setText(list.get(position).getTiming());
        String imgLink = list.get(position).getImage();
        holder.button.setOnClickListener(new View.OnClickListener() { // set onClick event to add the item to cart list
            @Override
            public void onClick(View v) {
                CartAdapter.cartItems.add(new CartItem(holder.name.getText().toString(), Double.parseDouble(holder.price.getText().toString()),
                        imgLink, Float.parseFloat(holder.rating.getText().toString())));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name,description,rating,price,timing;

        Button button; // add button
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.detailed_img);
            name = itemView.findViewById(R.id.detailed_name);
            description = itemView.findViewById(R.id.detailed_des);
            rating = itemView.findViewById(R.id.detailed_rating);
            price = itemView.findViewById(R.id.detailed_price);
            timing = itemView.findViewById(R.id.detailed_timing);
            button = itemView.findViewById(R.id.addBtn);
        }
    }
}