package com.example.tripcount.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.tripcount.Entity.Trip;
import com.example.tripcount.Repository.TripRepository;

import java.util.List;

public class TripViewModel extends AndroidViewModel {

    private TripRepository mRepository;
    private final LiveData<List<Trip>> mAllTrips;
    public TripViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TripRepository(application);
        mAllTrips = mRepository.getAllWords();
    }
    public LiveData<List<Trip>> getAllTrips() { return mAllTrips; }
    public void insert(Trip t) { mRepository.insert(t); }
}
