package vn.edu.usth.crabfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import vn.edu.usth.crabfood.models.CartItem;
import vn.edu.usth.crabfood.R;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private final List<CartItem> cartItems;
    private final CartItemListener listener;

    public interface CartItemListener {
        void onQuantityChanged();
        void onItemRemoved(CartItem item);
    }

    public CartAdapter(List<CartItem> cartItems, CartItemListener listener) {
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CartItem cartItem = cartItems.get(position);

        holder.itemName.setText(cartItem.getName());
        holder.itemImage.setImageResource(cartItem.getImageResourceId());
        holder.itemQuantity.setText(String.valueOf(cartItem.getQuantity()));
        holder.ratingBar.setRating(cartItem.getRating()); // Set the rating

        NumberFormat format = NumberFormat.getInstance(new Locale("vi", "VN"));
        String formattedPrice = format.format(cartItem.getPrice()) + " vnd";
        holder.itemPrice.setText(formattedPrice);

        holder.plusButton.setOnClickListener(v -> {
            int currentQuantity = cartItem.getQuantity();
            cartItem.setQuantity(currentQuantity + 1);
            notifyItemChanged(position);
            if (listener != null) {
                listener.onQuantityChanged();
            }
        });

        holder.minusButton.setOnClickListener(v -> {
            int currentQuantity = cartItem.getQuantity();
            if (currentQuantity > 1) {
                cartItem.setQuantity(currentQuantity - 1);
                notifyItemChanged(position);
                if (listener != null) {
                    listener.onQuantityChanged();
                }
            }
        });

        holder.removeItemButton.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            if (currentPosition != RecyclerView.NO_POSITION) {
                CartItem removedItem = cartItems.remove(currentPosition);
                notifyItemRemoved(currentPosition);
                notifyItemRangeChanged(currentPosition, cartItems.size());
                if (listener != null) {
                    listener.onItemRemoved(removedItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImage;
        TextView itemName;
        TextView itemPrice;
        TextView itemQuantity;
        Button plusButton;
        Button minusButton;
        TextView removeItemButton;
        RatingBar ratingBar; // New field

        ViewHolder(View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemQuantity = itemView.findViewById(R.id.item_quantity);
            plusButton = itemView.findViewById(R.id.plus_button);
            minusButton = itemView.findViewById(R.id.minus_button);
            removeItemButton = itemView.findViewById(R.id.remove_item_button);
            ratingBar = itemView.findViewById(R.id.rating_bar); // Find the rating bar
        }
    }
}
