package com.example.project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [com.example.project.models.Result::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao

    companion object{
        @Volatile
        private var INSTANCE: MovieDatabase? = null

        fun getDatabase(context: Context): MovieDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        MovieDatabase::class.java,
                        "movieDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}