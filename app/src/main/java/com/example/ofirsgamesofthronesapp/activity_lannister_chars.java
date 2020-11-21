package com.example.ofirsgamesofthronesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class activity_lannister_chars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lannister_chars);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.lannister_chars_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true); // For improved performance - saw in a video tutorial.

        List<String> lannisterListCharacters = Arrays.asList(getResources().getStringArray(R.array.lannister_characters_names));
        LannisterAdapter adapter = new LannisterAdapter(lannisterListCharacters);
        recyclerView.setAdapter(adapter);
    }
}