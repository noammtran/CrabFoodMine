package vn.edu.usth.crabfood.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.crabfood.DataHelper;
import vn.edu.usth.crabfood.adapters.FeaturedAdapter;
import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.adapters.FeaturedVerAdapter;
import vn.edu.usth.crabfood.models.FeaturedModel;
import vn.edu.usth.crabfood.models.FeaturedVerModel;

public class FirstFragment extends Fragment {

    /// HORIZONTAL
    FeaturedAdapter featuredAdapter;
    RecyclerView recyclerView;
    List<FeaturedModel> featuredModelsList;

    ///  VERTICAL
    List<FeaturedVerModel> featuredVerModelList;
    RecyclerView recyclerView2;
    FeaturedVerAdapter featuredVerAdapter;



    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = view.findViewById(R.id.featured_hor_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        featuredModelsList = new ArrayList<>();
        for(int i = 2; i< 5;i++)
        {
            featuredModelsList.add(new FeaturedModel(DataHelper.menu.bestFood.get(i).getImg(),
                    DataHelper.menu.bestFood.get(i).getName(),
                    Integer.toString(DataHelper.menu.bestFood.get(i).getRate())));
        }

        featuredAdapter = new FeaturedAdapter(featuredModelsList);
        recyclerView.setAdapter(featuredAdapter);

        recyclerView2 = view.findViewById(R.id.featured_ver_rec);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        featuredVerModelList = new ArrayList<>();
        for (int i = 5; i < DataHelper.menu.bestFood.size(); i++) {
            featuredVerModelList.add(new FeaturedVerModel(DataHelper.menu.bestFood.get(i).getImg(),
                    DataHelper.menu.bestFood.get(i).getName(),
                    DataHelper.menu.bestFood.get(i).getDsc(),
                    Integer.toString(DataHelper.menu.bestFood.get(i).getRate()),
                    Double.toString(DataHelper.menu.bestFood.get(i).getPrice())));
        }

        featuredVerAdapter = new FeaturedVerAdapter(featuredVerModelList);
        recyclerView2.setAdapter(featuredVerAdapter);
        return view;
    }
}