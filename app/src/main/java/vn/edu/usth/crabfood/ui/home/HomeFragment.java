package vn.edu.usth.crabfood.ui.home;

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

import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.adapters.HomeHorAdapter;
import vn.edu.usth.crabfood.adapters.HomeVerAdapter;
import vn.edu.usth.crabfood.adapters.UpdateVerticalRec;
import vn.edu.usth.crabfood.models.HomeHorModels;
import vn.edu.usth.crabfood.models.HomeVerModels;

public class HomeFragment extends Fragment implements UpdateVerticalRec {
    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorModels> homeHorModelList;
    HomeHorAdapter homeHorAdapter;
    /////////////Vertical
    ArrayList<HomeVerModels> homeVerModelList;
    HomeVerAdapter homeVerAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        //////////////////////////Horizontal RecyclerView
        homeHorModelList = new ArrayList<>();

        homeHorModelList.add(new HomeHorModels(R.drawable.ic_pizza,"Pizza"));
        homeHorModelList.add(new HomeHorModels(R.drawable.ic_burger,"Burger"));
        homeHorModelList.add(new HomeHorModels(R.drawable.ic_french_fries,"Fried Potatoes"));
        homeHorModelList.add(new HomeHorModels(R.drawable.ic_ice_cream, "Ice Cream"));
        homeHorModelList.add(new HomeHorModels(R.drawable.ic_sandwich,"Sandwich"));

        homeHorAdapter = new HomeHorAdapter(this,getActivity(),homeHorModelList);
        homeHorizontalRec.setAdapter(homeHorAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);

        ////////////////////////Vertical RecyclerView
        homeVerModelList = new ArrayList<>();


        homeVerAdapter = new HomeVerAdapter(homeVerModelList, getActivity());
        homeVerticalRec.setAdapter(homeVerAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        return root;
    }

    @Override
    public View OncreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public View OnCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void callBack(int position, ArrayList<HomeVerModels> list) {
        homeVerAdapter = new HomeVerAdapter(list, getContext());
        homeVerAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerAdapter);


    }
}
