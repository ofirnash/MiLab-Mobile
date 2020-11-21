package com.example.ofirsgamesofthronesapp;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LannisterAdapter extends RecyclerView.Adapter<LannisterAdapter.LannisterViewHolder> {

    private List<String> lannisterListCharacters;
    private int images[];

    public LannisterAdapter(List<String> lannisterListCharacters, int img[]){
        this.lannisterListCharacters = lannisterListCharacters;
        this.images = img;
    }

    @NonNull
    @Override
    public LannisterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lannister_list_characters, parent, false);
        return new LannisterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LannisterViewHolder holder, int position) {
        String lannisterName = lannisterListCharacters.get(position);
        holder.lannisterName.setText(lannisterName);
        holder.lannisterImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return lannisterListCharacters.size();
    }

    public static class LannisterViewHolder extends RecyclerView.ViewHolder{
        public TextView lannisterName;
        ImageView lannisterImage;
        public LannisterViewHolder(@NonNull View itemView) {
            super(itemView);
            lannisterName = itemView.findViewById(R.id.character_name);
            lannisterImage = itemView.findViewById(R.id.character_image);
        }
    }
}
