package com.example.tripcount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.Toast;

import com.example.tripcount.Adapters.mainactivity_adapter;
import com.example.tripcount.Entity.Trip;
import com.example.tripcount.ViewModel.TripViewModel;

public class MainActivity extends AppCompatActivity implements mainactivity_adapter.onClickListener {

    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private TripViewModel mTripViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , add_new_trip_Details.class);
                startActivity(i);
            }
        });

//        mTripViewModel.getAllTrips().observe(this, words -> {
//            // Update the cached copy of the words in the adapter.
//            mainactivity_adapter.submitList(words);
//        });

        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final mainactivity_adapter adapter = new mainactivity_adapter();
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {

            Trip trip = new Trip(data.getStringExtra(add_new_trip_Details.WORD) ,Integer.parseInt(data.getStringExtra(add_new_trip_Details.COUNT)));
            mTripViewModel.insert(trip);
        } else {
            Toast.makeText(getApplicationContext(),"Word not saved because it is empty",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(int position) {
        Intent i =new Intent(this,trip_transactions_details.class);
        // pos = data.getposition;
        //i.putExtra(data[pos].name , .count);
        startActivity(i);
    }
}