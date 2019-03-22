package com.azkar.azkarelmuslim.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao

public interface AzkarDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAzkarData(AzkarModelDB azkarModelDB);


    @Query("SELECT * FROM AzkarModelDB")
    Flowable<List<AzkarModelDB>> getAllAzkarList();


    @Query("DELETE FROM AzkarModelDB WHERE azkarId= :id")
    void deleteAzkarById(Long id);


}
