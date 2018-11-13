package com.example.ideo.mealder.Utils;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ideo.mealder.R;
import com.example.ideo.mealder.models.MealRecipe;
import com.example.ideo.mealder.models.User;

import java.util.List;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.DataObjectHolder> {

    private MyClickListener myClickListener;
    private List<MealRecipe> recipes;
    private List<User> users;
    private int doubleTapPosition;
    private boolean doubleTap = false;

    public RecyclerListAdapter(List<MealRecipe> recipes, List<User> users) {
        this.recipes = recipes;
        this.users = users;
    }

    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        int itemView = R.layout.recycler_item;
        View staticView = LayoutInflater.from(parent.getContext()).inflate(itemView, parent, false);
        return new DataObjectHolder(staticView);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataObjectHolder holder, final int position) {
        holder.mealName.setText(recipes.get(position).getMealName());
        holder.mealDescription.setText(recipes.get(position).getMealDescription());
        holder.mealImage.setImageResource(R.mipmap.ic_launcher);
        holder.background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClickListener.onEventClick(holder.getAdapterPosition());
            }
        });

        holder.mealImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (doubleTap & doubleTapPosition == holder.getAdapterPosition())
                    addToFavourities(holder.getAdapterPosition(), users.get(1));
                else {
                    doubleTapPosition = holder.getAdapterPosition();
                    doubleTap = true;
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            doubleTap = false;
                        }
                    }, 450);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView mealName, mealDescription;
        ImageView mealImage;
        CardView background;

        DataObjectHolder(View itemView) {
            super(itemView);
            mealName = itemView.findViewById(R.id.mealName);
            mealDescription = itemView.findViewById(R.id.mealDescription);
            mealImage = itemView.findViewById(R.id.mealPhoto);
            background = itemView.findViewById(R.id.background);
        }
    }

    public interface MyClickListener {
        void onEventClick(int position);
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    private void addToFavourities(int mealId, User user) {
        user.getFavouriteMeals().add(recipes.get(mealId));
        Log.e("aaaa", "mealID: " + mealId + "; userID: " + user.getUserId());
        Log.e("aaaa", "user's meals: " + user.getFavouriteMeals().toString());
    }
}
