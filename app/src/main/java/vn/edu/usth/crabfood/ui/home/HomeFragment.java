package vn.edu.usth.crabfood.ui.home;

import static android.app.PendingIntent.getActivity;

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
import vn.edu.usth.crabfood.activities.adapters.HomeHorAdapter;
import vn.edu.usth.crabfood.activities.models.HomeHorModels;

public class HomeFragment extends Fragment {
    RecyclerView homeHorizontalRec;
    List<HomeHorModels> homeHorModelList;
    HomeHorAdapter homeHorAdapter;

    public View OncreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);

        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModels(R.drawable.pizza,"Pizza"));
        homeHorModelList.add(new HomeHorModels(R.drawable.burger,"Burger"));
        homeHorModelList.add(new HomeHorModels(R.drawable.french_fries,"Fried Potatoes"));
        homeHorModelList.add(new HomeHorModels(R.drawable.ice_cream, "Ice Cream"));
        homeHorModelList.add(new HomeHorModels(R.drawable.sandwich,"Sandwich"));

        homeHorAdapter = new HomeHorAdapter(homeHorModelList, getActivity());
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);
        return root;
    }

}
