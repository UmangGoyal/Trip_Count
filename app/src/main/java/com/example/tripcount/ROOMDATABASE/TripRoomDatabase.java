package com.example.tripcount.ROOMDATABASE;

import android.content.Context;


import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.tripcount.DAO.tripname_dao;
import com.example.tripcount.Entity.Trip;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Trip.class}, version = 1, exportSchema = false)
public abstract class TripRoomDatabase extends RoomDatabase {

    public abstract tripname_dao tripDao();

    private static volatile TripRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);


    public static TripRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TripRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            TripRoomDatabase.class, "trip_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                tripname_dao dao = INSTANCE.tripDao();
                dao.deleteAll();

                Trip Trip = new Trip("Hello" , 56);
                dao.insert(Trip);
                Trip = new Trip("World" , 4);
                dao.insert(Trip);
            });
        }
    };
}
