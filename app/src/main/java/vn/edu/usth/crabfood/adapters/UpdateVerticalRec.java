package vn.edu.usth.crabfood.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import java.util.ArrayList;

import vn.edu.usth.crabfood.models.HomeVerModels;

public interface UpdateVerticalRec {
    View OncreateView(@NonNull LayoutInflater inflater,
                      ViewGroup container, Bundle savedInstanceState);

    View OnCreateView(@NonNull LayoutInflater inflater,
                      ViewGroup container, Bundle savedInstanceState);

    public default void callBack(int position, ArrayList<HomeVerModels> list){

    }
}
