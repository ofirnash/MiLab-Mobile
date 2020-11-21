package com.example.ofirsgamesofthronesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button starksCharsButton = (Button)findViewById(R.id.starks_button);
        starksCharsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), activity_sparks_chars.class);
                startActivity(intent);
            }
        });

        Button lannisterCharsButton = (Button)findViewById(R.id.lannister_button);
        lannisterCharsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(v.getContext(), activity_lannister_chars.class);
                startActivity(intent);
            }
        });
    }
}