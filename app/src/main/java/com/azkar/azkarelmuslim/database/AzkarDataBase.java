package com.azkar.azkarelmuslim.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {AzkarModelDB.class}, version = 1,exportSchema = false)
public abstract class AzkarDataBase extends RoomDatabase {
    public abstract AzkarDao azkarDao();
}
