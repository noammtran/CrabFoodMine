package vn.edu.usth.crabfood.ui.dailymeal;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.adapters.DailyMealAdapter;
import vn.edu.usth.crabfood.models.DailyMealModels;

public class DailyMealFragment extends Fragment{

    RecyclerView recyclerView;
    List<DailyMealModels> dailyMealModels;
    DailyMealAdapter dailyMealAdapter;

    @SuppressLint("NotifyDataSetChanged")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.daily_meal_fragment, container, false);

        recyclerView = root.findViewById(R.id.daily_meal_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dailyMealModels = new ArrayList<>();

        dailyMealModels.add(new DailyMealModels(R.drawable.ic_breakfast,"Chocolate","29% OFF","Description","Chocolate"));
        dailyMealModels.add(new DailyMealModels(R.drawable.ic_lunch,"Dessert","29% OFF","Description","Dessert"));
        dailyMealModels.add(new DailyMealModels(R.drawable.ic_dinner,"IceCream","29% OFF","Description","IceCream"));
        dailyMealModels.add(new DailyMealModels(R.drawable.ic_sweet,"Drink","29% OFF","Description","Drink"));

        dailyMealAdapter = new DailyMealAdapter(getContext(),dailyMealModels);
        recyclerView.setAdapter(dailyMealAdapter);
        dailyMealAdapter.notifyDataSetChanged();
        return root;
    }
}
