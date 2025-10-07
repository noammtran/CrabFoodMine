package vn.edu.usth.crabfood.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.crabfood.ApiHelper;
import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.api.ApiService;
import vn.edu.usth.crabfood.models.Bbq;
import vn.edu.usth.crabfood.models.Burger;
import vn.edu.usth.crabfood.models.Drink;
import vn.edu.usth.crabfood.models.HomeHorModels;
import vn.edu.usth.crabfood.models.HomeVerModels;
import vn.edu.usth.crabfood.models.IceCream;
import vn.edu.usth.crabfood.models.Menu;
import vn.edu.usth.crabfood.models.Pizza;
import vn.edu.usth.crabfood.models.Sandwich;
import vn.edu.usth.crabfood.models.Sausage;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder>{

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorModels> list;


    boolean check = true;
    boolean select = true;
    int row_index = 0;
    ArrayList<Bbq> bbq;

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


        //Picasso.get().load(bbq.get(randomNum).getImg()).into(imageView);
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView);
        //holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());


        if (check) {
            ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
            for (Pizza pizza: ApiHelper.menu.getPizzas())
            {
                homeVerModels.add(new HomeVerModels(pizza.getImg(), pizza.getName(), "10:00-23:00", Integer.toString(pizza.getRate()), Double.toString(pizza.getPrice()), pizza.getDsc()));
            }
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

                       for (Pizza pizza: ApiHelper.menu.getPizzas())
                       {
                           homeVerModels.add(new HomeVerModels(pizza.getImg(), pizza.getName(), pizza.getDsc(), Integer.toString(pizza.getRate()), Double.toString(pizza.getPrice()), pizza.getDsc()));
                       }

                       updateVerticalRec.callBack(position, homeVerModels);
                   } else if (position == 1) {

                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
                       for (Burger burger: ApiHelper.menu.getBurgers())
                       {
                           homeVerModels.add(new HomeVerModels(burger.getImg(), burger.getName(), burger.getDsc(), Integer.toString(burger.getRate()), Double.toString(burger.getPrice()), burger.getDsc()));
                       }

                       updateVerticalRec.callBack(position, homeVerModels);
                   } else if (position == 2) {
                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
                       //fries
                       for (Sausage sausage: ApiHelper.menu.getSausages())
                       {
                           homeVerModels.add(new HomeVerModels(sausage.getImg(), sausage.getName(), sausage.getDsc(), Integer.toString(sausage.getRate()), Double.toString(sausage.getPrice()), sausage.getDsc()));
                       }

                       updateVerticalRec.callBack(position, homeVerModels);
                   } else if (position == 3) {
                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
                       for (IceCream iceCream: ApiHelper.menu.getIcecream())
                       {
                           homeVerModels.add(new HomeVerModels(iceCream.getImg(), iceCream.getName(), iceCream.getDsc(), Integer.toString(iceCream.getRate()), Double.toString(iceCream.getPrice()), iceCream.getDsc()));
                       }

                        updateVerticalRec.callBack(position, homeVerModels);
                   } else if (position == 4) {
                       ArrayList<HomeVerModels> homeVerModels = new ArrayList<>();
                       for (Sandwich sandwich: ApiHelper.menu.getSandwiches())
                       {
                           homeVerModels.add(new HomeVerModels(sandwich.getImg(), sandwich.getName(), sandwich.getDsc(), Integer.toString(sandwich.getRate()), Double.toString(sandwich.getPrice()), sandwich.getDsc()));
                       }

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


