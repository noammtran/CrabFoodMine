package vn.edu.usth.crabfood.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.crabfood.ApiHelper;
import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.adapters.DetailedDailyAdapter;
import vn.edu.usth.crabfood.models.Chocolate;
import vn.edu.usth.crabfood.models.Dessert;
import vn.edu.usth.crabfood.models.DetailedDailyModels;
import vn.edu.usth.crabfood.models.Drink;
import vn.edu.usth.crabfood.models.IceCream;

public class DetailedDailyMealActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DetailedDailyModels> detailedDailyModelsList;
    DetailedDailyAdapter dailyAdapter;
    ImageView imageView;


    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_daily_meal);

        String type = getIntent().getStringExtra("type");

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);

        detailedDailyModelsList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(dailyAdapter);


        if (type != null && type.equalsIgnoreCase("Chocolate")){

            for (Chocolate choco: ApiHelper.menu.getChocolates()) {
                //new DetailedDailyModels(R.drawable.fav1,"name1","desc1","rating1","price1","timing1")
                detailedDailyModelsList.add(new DetailedDailyModels(choco.getImg(), choco.getName(), choco.getDsc(), Integer.toString(choco.getRate()), Double.toString(choco.getPrice()), "timimg1"));
            }
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("Dessert")){

            for (Dessert dessert: ApiHelper.menu.getDesserts()) {
                //new DetailedDailyModels(R.drawable.fav1,"name1","desc1","rating1","price1","timing1")
                detailedDailyModelsList.add(new DetailedDailyModels(dessert.getImg(), dessert.getName(), dessert.getDsc(), Integer.toString(dessert.getRate()), Double.toString(dessert.getPrice()), "timimg1"));
            }
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("IceCream")){

            for (IceCream icecream: ApiHelper.menu.getIcecream()) {
                //new DetailedDailyModels(R.drawable.fav1,"name1","desc1","rating1","price1","timing1")
                detailedDailyModelsList.add(new DetailedDailyModels(icecream.getImg(), icecream.getName(), icecream.getDsc(), Integer.toString(icecream.getRate()), Double.toString(icecream.getPrice()), "timimg1"));
            }
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("Drink")){

            for (Drink drink: ApiHelper.menu.getDrinks()) {
                //new DetailedDailyModels(R.drawable.fav1,"name1","desc1","rating1","price1","timing1")
                detailedDailyModelsList.add(new DetailedDailyModels(drink.getImg(), drink.getName(), drink.getDsc(), Integer.toString(drink.getRate()), Double.toString(drink.getPrice()), "timimg1"));
            }
            dailyAdapter.notifyDataSetChanged();

        }

    }
}