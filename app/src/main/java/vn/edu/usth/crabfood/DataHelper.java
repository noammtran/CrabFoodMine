package vn.edu.usth.crabfood;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import vn.edu.usth.crabfood.adapters.CartAdapter;
import vn.edu.usth.crabfood.models.CartItem;
import vn.edu.usth.crabfood.models.Menu;

public class DataHelper {
    public static Menu menu = new Menu();
    public static FirebaseFirestore firestore;
    public static String userID;

    FirebaseAuth userId;
    private DataHelper(){

    }

    public static  void saveData()
    {
        firestore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = firestore.collection("user").document(userID);
        Map<String, Object> cartItem = new HashMap<>();
        for (CartItem item:CartAdapter.cartItems) {
            cartItem.put(item.getName(), item);
        }
        documentReference.set(cartItem).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Log.d("yourmamafat", "thanhcongroicacchauoi");
            }
        });
    }

    public static void fetchData()
    {
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        DocumentReference docRef = firestore.collection("user").document(userID);

        docRef.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                DocumentSnapshot document = task.getResult();
                if (document.exists()) {
                    Map<String, Object> data = document.getData();
                    if (data != null) {
                        CartAdapter.cartItems.clear();

                        Gson gson = new Gson();

                        for (Object value : data.values()) {
                            CartItem item = gson.fromJson(new Gson().toJson(value), CartItem.class);
                            CartAdapter.cartItems.add(item);
                        }

                        Log.d("Firestore", "Loaded " + CartAdapter.cartItems.size() + " items");
                    }
                } else {
                    Log.d("Firestore", "No such document");
                }
            } else {
                Log.e("Firestore", "Error getting document", task.getException());
            }
        });
    }
}
