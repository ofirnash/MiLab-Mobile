package com.example.ofirsgamesofthronesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StarksAdapter extends RecyclerView.Adapter<StarksAdapter.StarksViewHolder> {

    private List<String> starksListCharacters;
    private int images[];

    public StarksAdapter(List<String> starksListCharacters, int img[]){
        this.starksListCharacters = starksListCharacters;
        this.images = img;
    }

    @NonNull
    @Override
    public StarksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.starks_list_characters, parent, false);
        return new StarksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StarksViewHolder holder, int position) {
        String starksName = starksListCharacters.get(position);
        holder.starksName.setText(starksName);
        holder.starksImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return starksListCharacters.size();
    }

    public static class StarksViewHolder extends RecyclerView.ViewHolder{
        public TextView starksName;
        ImageView starksImage;
        public StarksViewHolder(@NonNull View itemView) {
            super(itemView);
            starksName = itemView.findViewById(R.id.character_name);
            starksImage = itemView.findViewById(R.id.character_image);
        }
    }
}
