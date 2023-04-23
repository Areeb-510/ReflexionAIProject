package com.example.project.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.project.models.FavouriteResult
import com.example.project.models.MovieResult

@Dao
interface FavDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addMovies(movies: FavouriteResult)

    @Query("SELECT * FROM fav_table")
    fun getMovies() : LiveData<List<FavouriteResult>>

}