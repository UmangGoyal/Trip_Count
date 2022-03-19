package com.example.tripcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class trip_transactions_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_transactions_details);
        Button fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent i = new Intent(trip_transactions_details.this , add_new_transactions_Details.class);
            startActivity(i);
        });

        /*Button result = findViewById(R.id.Result);
        result.setOnClickListener(view -> {
            Intent i = new Intent(trip_transactions_details.this , Result.class);
            startActivity(i);
        });*/
    }
}