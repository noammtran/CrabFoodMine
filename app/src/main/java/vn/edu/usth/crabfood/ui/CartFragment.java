package vn.edu.usth.crabfood.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.adapters.CartAdapter;
import vn.edu.usth.crabfood.models.CartItem;

public class CartFragment extends Fragment {

    private RecyclerView cartRecyclerView;
    private CartAdapter cartAdapter;
    private List<CartItem> cartItems;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cartRecyclerView = view.findViewById(R.id.cart_rec);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sample data
        cartItems = new ArrayList<>();
        cartItems.add(new CartItem("Delicious Cake", 25.00, R.drawable.cake));
        cartItems.add(new CartItem("Classic Hamburger", 15.00, R.drawable.hamburger));
        cartItems.add(new CartItem("Sweet Ice Cream", 10.00, R.drawable.ic_icecream));
        cartItems.add(new CartItem("Fresh Eggs", 5.00, R.drawable.eggs));
        cartItems.add(new CartItem("Cool Milkshake", 8.00, R.drawable.milkshake));
        cartItems.add(new CartItem("Hot Ramen", 12.00, R.drawable.ramen));
        cartItems.add(new CartItem("Tasty Sushi", 18.00, R.drawable.sushi));

        cartAdapter = new CartAdapter(cartItems);
        cartRecyclerView.setAdapter(cartAdapter);
    }
}
