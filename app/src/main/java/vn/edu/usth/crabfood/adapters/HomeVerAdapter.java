package vn.edu.usth.crabfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vn.edu.usth.crabfood.DataHelper;
import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.models.CartItem;
import vn.edu.usth.crabfood.models.HomeVerModels;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder>{
    private BottomSheetDialog bottomSheetDialog;
    Context context;
    ArrayList<HomeVerModels> list;

    public HomeVerAdapter(ArrayList<HomeVerModels> list, Context context) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override


    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String mName = list.get(position).getName();
        final String mTiming = list.get(position).getTiming();
        final String mRating = list.get(position).getRating();
        final String mPrice = list.get(position).getPrice();
        final String mDesc = list.get(position).getDesc();
        final String mImage = list.get(position).getImage();

        Picasso.get().load(list.get(position).getImage()).error(R.drawable.nodata).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.timing.setText(list.get(position).getTiming());
        holder.rating.setText(list.get(position).getRating());
        holder.price.setText(list.get(position).getPrice());
        String imgLink = list.get(position).getImage();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout, null, false);
                sheetView.findViewById(R.id.add_to_cart).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CartItem selectItem = new CartItem(holder.name.getText().toString(), Double.parseDouble(holder.price.getText().toString()),
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

                        Toast.makeText(context, "Added to a Cart", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
                TextView bottomName = sheetView.findViewById(R.id.bottom_name);
                TextView bottomPrice = sheetView.findViewById(R.id.bottom_price);
                TextView bottomRating = sheetView.findViewById(R.id.bottom_rating);
                TextView bottomTiming = sheetView.findViewById(R.id.bottom_timing);
                TextView bottomDesc = sheetView.findViewById(R.id.detailed_des);

                bottomName.setText(mName);
                bottomPrice.setText(mPrice);
                bottomRating.setText(mRating);
                Picasso.get().load(list.get(position).getImage()).error(R.drawable.nodata).into(bottomImg);
                bottomDesc.setText(mDesc);
                bottomTiming.setText(mTiming);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name,timing,rating,price;
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.name);
            timing = itemView.findViewById(R.id.timing);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.price);
        }
    }

}
