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

import vn.edu.usth.crabfood.DataHelper;
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

        CartAdapter cartAdapter = new CartAdapter(this);
        cartRecyclerView.setAdapter(cartAdapter);

        updateTotalPrice();
    }

    @Override
    public void onQuantityChanged() {
        DataHelper.saveData();
        updateTotalPrice();
    }

    @Override
    public void onItemRemoved(CartItem item) {
        DataHelper.saveData();
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        double total = 0;
        for (CartItem item : CartAdapter.cartItems) {
            total += item.getPrice() * item.getQuantity();
        }

        NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
        String formattedPrice = format.format(total) + " usd";

        totalPriceTextView.setText(formattedPrice);
    }
}
