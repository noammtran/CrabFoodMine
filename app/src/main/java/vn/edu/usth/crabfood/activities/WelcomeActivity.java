package vn.edu.usth.crabfood.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.crabfood.ApiHelper;
import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.api.ApiService;
import vn.edu.usth.crabfood.models.Menu;
import vn.edu.usth.crabfood.utils.MenuSanitizer;

public class WelcomeActivity extends AppCompatActivity {

    private static final String TAG = "WelcomeActivity";
    private static final String IMAGE_VALIDATION_TAG = "MenuImageValidation";

    private final ExecutorService imageValidationExecutor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        ApiService.apiService.GetAll().enqueue(new Callback<Menu>() {

            @Override
            public void onResponse(Call<Menu> call, Response<Menu> response) {
                if (!response.isSuccessful() || response.body() == null) {
                    Log.w(TAG, "Menu request completed without usable data.");
                    return;
                }

                Menu menu = response.body();
                imageValidationExecutor.execute(() -> {
                    MenuSanitizer.SanitizationResult result = MenuSanitizer.sanitize(menu);
                    ApiHelper.menu = result.getMenu();

                    List<String> invalidUrls = result.getInvalidImageUrls();
                    ApiHelper.invalidImageUrls.clear();
                    ApiHelper.invalidImageUrls.addAll(invalidUrls);

                    if (!invalidUrls.isEmpty()) {
                        Log.w(IMAGE_VALIDATION_TAG, "Removed " + invalidUrls.size() +
                                " menu items with unreachable image URLs.");
                        for (String invalidUrl : invalidUrls) {
                            Log.w(IMAGE_VALIDATION_TAG, "Unreachable image URL: " + invalidUrl);
                        }
                    } else {
                        Log.i(IMAGE_VALIDATION_TAG, "All image URLs returned successful responses.");
                    }
                });
            }

            @Override
            public void onFailure(Call<Menu> call, Throwable t) {
                Log.e(TAG, "Failed to fetch menu from API.", t);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    @Override
    protected void onDestroy() {
        imageValidationExecutor.shutdownNow();
        super.onDestroy();
    }

    public void Login(View view)
    {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }

    public void Registry(View view)
    {
        startActivity(new Intent(WelcomeActivity.this, RegistryActivity.class));
    }
}
