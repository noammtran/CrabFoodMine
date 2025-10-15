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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.usth.crabfood.DataHelper;
import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.api.ApiService;
import vn.edu.usth.crabfood.models.Menu;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_welcome);

        ApiService.apiService.GetAll().enqueue(new Callback<Menu>() {

            @Override
            public void onResponse(Call<Menu> call, Response<Menu> response) {
                Log.e("lmao", "thanhcong");
                DataHelper.menu = response.body();
            }

            @Override
            public void onFailure(Call<Menu> call, Throwable t) {
                Log.e("lmao", "ngudan");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


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