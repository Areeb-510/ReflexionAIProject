package com.example.project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project.models.FavouriteResult

@Database(entities = [FavouriteResult::class], version = 1)
abstract class FavDatabase : RoomDatabase() {

    abstract fun favDao() : FavDao

    companion object{
        @Volatile
        private var INSTANCE: FavDatabase? = null

        fun getDatabase(context: Context): FavDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        FavDatabase::class.java,
                        "favDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}