package com.example.tripcount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;

import com.example.tripcount.Adapters.mainactivity_adapter;

public class MainActivity extends AppCompatActivity implements mainactivity_adapter.onClickListener {

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


        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        //isme data pass hoa
        // rv.setAdapter(new mainactivity_adapter());
    }

    @Override
    public void onClick(int position) {
        Intent i =new Intent(this,trip_transactions_details.class);
        // pos = data.getposition;
        //i.putExtra(data[pos].name , .count);
        startActivity(i);
    }
}