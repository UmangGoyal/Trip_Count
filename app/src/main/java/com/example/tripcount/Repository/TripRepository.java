package com.example.tripcount.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tripcount.DAO.tripname_dao;
import com.example.tripcount.Entity.Trip;
import com.example.tripcount.ROOMDATABASE.TripRoomDatabase;

import java.util.List;

public class TripRepository {
    private tripname_dao mdao;
    private LiveData<List<Trip>> mAllWords;

    public TripRepository(Application application) {
        TripRoomDatabase db = TripRoomDatabase.getDatabase(application);
        mdao = db.tripDao();
        mAllWords = tripname_dao.getAlphabetizedWords();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Trip>> getAllWords() {
        return mAllWords;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    public void insert(Trip trip) {
        TripRoomDatabase.databaseWriteExecutor.execute(() -> {
            mdao.insert(trip);
        });
    }
}
