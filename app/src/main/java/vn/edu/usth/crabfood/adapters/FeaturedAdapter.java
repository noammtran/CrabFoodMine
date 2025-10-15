package vn.edu.usth.crabfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import vn.edu.usth.crabfood.R;

import vn.edu.usth.crabfood.models.FeaturedModel;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.ViewHolder> {

    List<FeaturedModel> list;

    public FeaturedAdapter(List<FeaturedModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_hor_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Picasso.get().load(list.get(position).getImage()).error(R.drawable.nodata).into(holder.image);
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, desc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.featured_img);
            name = itemView.findViewById(R.id.featured_name);
            desc = itemView.findViewById(R.id.featured_des);
        }
    }
}