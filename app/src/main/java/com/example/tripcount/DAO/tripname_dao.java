package com.example.tripcount.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.tripcount.Entity.Trip;

import java.util.List;

@Dao
public interface
tripname_dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Trip Trip);

    @Query("DELETE FROM trip_table")
    void deleteAll();

    @Query("SELECT * FROM trip_table ORDER BY trip_name ASC")
    static LiveData<List<Trip>> getAlphabetizedWords() {
        return null;
    }

    @Query("DELETE FROM trip_table where trip_name LIKE :string" )
    void delete_trip(String string);

}
