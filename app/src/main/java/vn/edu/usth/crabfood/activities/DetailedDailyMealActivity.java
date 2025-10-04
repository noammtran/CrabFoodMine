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

import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.adapters.DetailedDailyAdapter;
import vn.edu.usth.crabfood.models.DetailedDailyModels;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(dailyAdapter);
        detailedDailyModelsList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelsList);

        if (type != null && type.equalsIgnoreCase("breakfast")){
            detailedDailyModelsList.add(new DetailedDailyModels(R.drawable.fav1,"name1","desc1","rating1","price1","timing1"));
            detailedDailyModelsList.add(new DetailedDailyModels(R.drawable.fav2,"name2","desc2","rating2","price2","timing2"));
            detailedDailyModelsList.add(new DetailedDailyModels(R.drawable.fav3,"name3","desc3","rating3","price3","timing3"));
            dailyAdapter.notifyDataSetChanged();

        }

        if (type != null && type.equalsIgnoreCase("sweets")){
            detailedDailyModelsList.add(new DetailedDailyModels(R.drawable.s1,"name1","desc1","rating1","price1","timing1"));
            detailedDailyModelsList.add(new DetailedDailyModels(R.drawable.s2,"name2","desc2","rating2","price2","timing2"));
            detailedDailyModelsList.add(new DetailedDailyModels(R.drawable.s3,"name3","desc3","rating3","price3","timing3"));
            dailyAdapter.notifyDataSetChanged();

        }

        recyclerView = findViewById(R.id.detailed_rec);
        imageView = findViewById(R.id.detailed_img);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailedDailyModelsList = new ArrayList<>();
        dailyAdapter = new DetailedDailyAdapter(detailedDailyModelsList);
        recyclerView.setAdapter(dailyAdapter);

    }
}