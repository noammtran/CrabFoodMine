package vn.edu.usth.crabfood.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import vn.edu.usth.crabfood.models.Menu;

public interface ApiService {
    Gson gson = new GsonBuilder().create();
    //https://apilayer.net/api/live?access_key=843d4d34ae72b3882e3db642c51e28e6&currencies=VND&source=USD&format=1
    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://free-food-menus-api-two.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @GET("all")
    Call<Menu> GetAll();

}
