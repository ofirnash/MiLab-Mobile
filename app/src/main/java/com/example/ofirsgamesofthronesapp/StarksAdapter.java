package com.example.ofirsgamesofthronesapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StarksAdapter extends RecyclerView.Adapter<StarksAdapter.StarksViewHolder> {

    private List<String> starksListCharacters;

    public StarksAdapter(List<String> starksListCharacters){
        this.starksListCharacters = starksListCharacters;
    }

    @NonNull
    @Override
    public StarksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = (TextView)LayoutInflater.from(parent.getContext()).inflate(R.layout.sparks_list_characters, parent, false);
        return new StarksViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull StarksViewHolder holder, int position) {
        String starksName = starksListCharacters.get(position);
        holder.starksName.setText(starksName);
    }

    @Override
    public int getItemCount() {
        return starksListCharacters.size();
    }

    public static class StarksViewHolder extends RecyclerView.ViewHolder{
        public TextView starksName;
        public StarksViewHolder(@NonNull TextView itemView) {
            super(itemView);
            starksName = itemView;
        }
    }
}
