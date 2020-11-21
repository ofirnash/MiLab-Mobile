package com.example.ofirsgamesofthronesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class activity_sparks_chars extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sparks_chars);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.sparks_chars_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true); // For improved performance - saw in a video tutorial.

        List<String> starksListCharacters = Arrays.asList(getResources().getStringArray(R.array.stark_characters_names));
        StarksAdapter adapter = new StarksAdapter(starksListCharacters);
        recyclerView.setAdapter(adapter);
    }
}