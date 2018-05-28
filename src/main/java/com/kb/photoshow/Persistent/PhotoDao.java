package com.kb.photoshow.Persistent;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.kb.photoshow.Model.PhotoModel;

import java.util.List;

/**
 * Created by kanbi on 22/05/2018.
 */
@Dao
public interface PhotoDao {
    @Query("SELECT * FROM Photos")
    List<PhotoModel> getAllPhotos();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<PhotoModel> photos);
}
