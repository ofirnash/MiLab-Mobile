package com.example.ofirsgamesofthronesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class activity_lannister_chars extends AppCompatActivity {

    int images[] = {R.drawable.tytos_lannister, R.drawable.tywin_lannister, R.drawable.joanna_lannister, R.drawable.kevan_lannister, R.drawable.cersei_lannister, R.drawable.jaime_lannister, R.drawable.tyrion_lannister, R.drawable.lancel_lannister, R.drawable.willem_lannister, R.drawable.martyn_lannister, R.drawable.joffrey_lannister, R.drawable.myrcella_lannister, R.drawable.tommen_lannister};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lannister_chars);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.lannister_chars_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true); // For improved performance - saw in a video tutorial.

        List<String> lannisterListCharacters = Arrays.asList(getResources().getStringArray(R.array.lannister_characters_names));
        LannisterAdapter adapter = new LannisterAdapter(lannisterListCharacters, images);
        recyclerView.setAdapter(adapter);
    }
}