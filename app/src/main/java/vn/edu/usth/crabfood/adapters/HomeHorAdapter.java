package vn.edu.usth.crabfood.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.models.HomeHorModels;
import vn.edu.usth.crabfood.models.HomeVerModels;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder>{

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModels> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, ArrayList<HomeHorModels> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());

        if (check) {
            ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModels(R.drawable.ic_pizza1, "Pizza 1", "10:00-23:00", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModels(R.drawable.ic_pizza2, "Pizza 2", "10:00-23:00", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModels(R.drawable.ic_pizza3, "Pizza 3", "10:00-23:00", "4.9", "Min - $35"));
            homeVerModels.add(new HomeVerModels(R.drawable.ic_pizza4, "Pizza 4", "10:00-23:00", "4.9", "Min - $35"));

            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener(){
               @SuppressLint("NotifyDataSetChanged")
               @Override
                public  void onClick(View v){
                   row_index = position;
                   notifyDataSetChanged();

                   if (position == 0){
                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();

                       homeVerModels.add(new HomeVerModels(R.drawable.ic_pizza1,"Pizza 1","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_pizza2,"Pizza 2","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_pizza3,"Pizza 3","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_pizza4,"Pizza 4","10:00-23:00","4.9","Min - $35"));

                       updateVerticalRec.callBack(position, homeVerModels);
                   } else if (position == 1) {

                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_burger1,"Burger 1","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_burger2,"Burger 2","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_burger3,"Burger 3","10:00-23:00","4.9","Min - $35"));


                       updateVerticalRec.callBack(position, homeVerModels);
                   } else if (position == 2) {
                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_french_fries1,"French fries 1","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_french_fries2,"French fries 2","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_french_fries3,"French fries 3","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_french_fries4,"French fries 4","10:00-23:00","4.9","Min - $35"));


                       updateVerticalRec.callBack(position, homeVerModels);
                   } else if (position == 3) {
                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_ice_cream1,"Ice cream 1","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_ice_cream2,"Ice cream 2","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_ice_cream3,"Ice cream 3","10:00-23:00","4.9","Min - $35"));


                        updateVerticalRec.callBack(position, homeVerModels);
                   } else if (position == 4) {
                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_sandwich1,"Sandwich 1","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_sandwich2,"Sandwich 2","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_sandwich3,"Sandwich 3","10:00-23:00","4.9","Min - $35"));
                       homeVerModels.add(new HomeVerModels(R.drawable.ic_sandwich4,"Sandwich 4","10:00-23:00","4.9","Min - $35"));


                       updateVerticalRec.callBack(position, homeVerModels);

                   }
               }
            });
            if (select){
                if(position == 0){
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                    select = false;
                }
            }
            else {
                if (row_index == position) {
                    holder.cardView.setBackgroundResource(R.drawable.change_bg);
                }else {
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);
                }
            }

        }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}


