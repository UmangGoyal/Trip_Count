package com.example.tripcount.Entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "trip_table")
public class Trip {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "trip_name")
    private static String Trip_Name;

    @ColumnInfo(name = "count_of_people")
    private static int no_of_people;


    public Trip(@NonNull String trip_Name, int no_of_people) {
        Trip_Name = trip_Name;
        Trip.no_of_people = no_of_people;
    }


    public static String getTrip_Name() {
        return Trip_Name;
    }

    public static int getNo_of_people() {
        return no_of_people;
    }

    public void setTrip_Name(@NonNull String trip_Name) {
        Trip_Name = trip_Name;
    }

    public void setNo_of_people(int no_of_people) {
        this.no_of_people = no_of_people;
    }
}
