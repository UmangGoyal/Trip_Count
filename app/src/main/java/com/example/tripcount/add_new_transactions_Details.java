package com.example.tripcount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Button;

public class add_new_transactions_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_transactions_details);
        Button done = findViewById(R.id.button_Done);
        done.setOnClickListener(view -> {
            Intent i = new Intent(add_new_transactions_Details.this , trip_transactions_details.class);
            startActivity(i);
        });


    }
}