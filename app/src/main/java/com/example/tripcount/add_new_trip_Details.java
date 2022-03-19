package com.example.tripcount;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_new_trip_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_trip_details);
        EditText trip_name = findViewById(R.id.trip_name);
        @SuppressLint("WrongViewCast") EditText no_of_people = findViewById(R.id.no_of_people);
        Button next = findViewById(R.id.next_button);
        /*next.setOnClickListener(view -> {
            Intent i = new Intent(add_new_trip_Details.this , name_of_friends.class);
            startActivity(i);
        });*/
    }
}