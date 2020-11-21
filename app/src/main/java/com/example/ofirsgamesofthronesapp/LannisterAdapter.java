package com.example.ofirsgamesofthronesapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LannisterAdapter extends RecyclerView.Adapter<LannisterAdapter.LannisterViewHolder> {

    private List<String> lannisterListCharacters;

    public LannisterAdapter(List<String> lannisterListCharacters){
        this.lannisterListCharacters = lannisterListCharacters;
    }

    @NonNull
    @Override
    public LannisterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.lannister_list_characters, parent, false);
        return new LannisterViewHolder(textView);
    }

    @Override
    public void onBindViewHolder(@NonNull LannisterViewHolder holder, int position) {
        String lannisterName = lannisterListCharacters.get(position);
        holder.lannisterName.setText(lannisterName);
    }

    @Override
    public int getItemCount() {
        return lannisterListCharacters.size();
    }

    public static class LannisterViewHolder extends RecyclerView.ViewHolder{
        public TextView lannisterName;
        public LannisterViewHolder(@NonNull TextView itemView) {
            super(itemView);
            lannisterName = itemView;
        }
    }
}
