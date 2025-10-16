package vn.edu.usth.crabfood.ui.favourite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.usth.crabfood.R;


import androidx.annotation.NonNull;


import vn.edu.usth.crabfood.fragments.FirstFragment;



public class FavouriteFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_favourite, container, false);

        if(savedInstanceState == null) {getChildFragmentManager().beginTransaction().replace(R.id.favourite_content,new FirstFragment()).commit();}
        return root;
    }
}