package com.example.ofirsgamesofthronesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class activity_sparks_chars extends AppCompatActivity {

    int images[] = {R.drawable.rickard_stark, R.drawable.lyarra_stark, R.drawable.catelyn_stark, R.drawable.ned_stark, R.drawable.brandon_stark, R.drawable.benjen_stark, R.drawable.lyanna_stark, R.drawable.rhaegar_targaryen, R.drawable.jon_snow, R.drawable.robb_stark, R.drawable.sansa_stark, R.drawable.arya_stark, R.drawable.rickon_stark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sparks_chars);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.sparks_chars_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true); // For improved performance - saw in a video tutorial.

        List<String> starksListCharacters = Arrays.asList(getResources().getStringArray(R.array.stark_characters_names));
        StarksAdapter adapter = new StarksAdapter(starksListCharacters, images);
        recyclerView.setAdapter(adapter);
    }
}