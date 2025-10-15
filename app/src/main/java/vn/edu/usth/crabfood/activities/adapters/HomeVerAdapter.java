package vn.edu.usth.crabfood.activities.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import vn.edu.usth.crabfood.R;
import vn.edu.usth.crabfood.activities.models.HomeVerModels;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder>{

    Context context;
    List<HomeVerModels> list;

    public HomeVerAdapter(Context context, List<HomeVerModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
        }
    }

}
