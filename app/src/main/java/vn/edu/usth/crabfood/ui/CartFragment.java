package vn.edu.usth.crabfood.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.adapters.CartAdapter;
import vn.edu.usth.crabfood.models.CartItem;

public class CartFragment extends Fragment implements CartAdapter.CartItemListener {

    private List<CartItem> cartItems;
    private TextView totalPriceTextView;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView cartRecyclerView = view.findViewById(R.id.cart_rec);
        totalPriceTextView = view.findViewById(R.id.total_price_textview);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        cartItems = new ArrayList<>();
        // Add items with ratings
        cartItems.add(new CartItem("Delicious Cake", 25000d, R.drawable.cake, 4.5f));
        cartItems.add(new CartItem("Classic Hamburger", 25000d, R.drawable.hamburger, 4.0f));
        cartItems.add(new CartItem("Sweet Ice Cream", 10000d, R.drawable.icecream, 5.0f));
        cartItems.add(new CartItem("Fresh Eggs", 10000d, R.drawable.egg, 3.5f));
        cartItems.add(new CartItem("Cool Milkshake", 20000d, R.drawable.milkshake, 4.2f));
        cartItems.add(new CartItem("Hot Ramen", 50000d, R.drawable.ramen, 4.8f));
        cartItems.add(new CartItem("Tasty Sushi", 25000d, R.drawable.sushi, 4.9f));

        CartAdapter cartAdapter = new CartAdapter(cartItems, this);
        cartRecyclerView.setAdapter(cartAdapter);

        updateTotalPrice();
    }

    @Override
    public void onQuantityChanged() {
        updateTotalPrice();
    }

    @Override
    public void onItemRemoved(CartItem item) {
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getPrice() * item.getQuantity();
        }

        NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
        String formattedPrice = format.format(total) + " vnd";

        totalPriceTextView.setText(formattedPrice);
    }
}
