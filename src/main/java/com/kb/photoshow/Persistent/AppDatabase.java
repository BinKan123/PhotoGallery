package com.kb.photoshow.Persistent;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.kb.photoshow.Model.PhotoModel;

/**
 * Created by kanbi on 22/05/2018.
 */
@Database(entities = {PhotoModel.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PhotoDao photoDao();
}
