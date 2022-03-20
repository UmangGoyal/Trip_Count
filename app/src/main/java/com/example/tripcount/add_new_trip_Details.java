package com.example.tripcount;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_new_trip_Details extends AppCompatActivity {

    public static final String WORD = "com.example.android.wordlistsql.REPLY";
    public static final String COUNT = "0";
    private  EditText trip_name;
    private  EditText no_of_people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_trip_details);
        trip_name = findViewById(R.id.trip_name);
        no_of_people = findViewById(R.id.no_of_people);


        final Button button = findViewById(R.id.next_button);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(trip_name.getText()) || TextUtils.isEmpty(no_of_people.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String word = trip_name.getText().toString();
                replyIntent.putExtra(WORD, word);
                replyIntent.putExtra(COUNT, no_of_people.getText().toString());
                setResult(RESULT_OK, replyIntent);

            }
            finish();
        });
    }
}