package com.example.android.sunshine.data.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

@Database(entities = {WeatherEntry.class}, version = 1)
@TypeConverters(DateConverter.class)
abstract class SunshineDatabase extends RoomDatabase {
    abstract WeatherDao weatherDao();

    private static final String DB_NAME = "weather";
    private static final Object LOCK = new Object();
    private static volatile SunshineDatabase sInstance;

    static SunshineDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(), SunshineDatabase.class, DB_NAME).build();
                }
            }
        }
        return sInstance;
    }
}