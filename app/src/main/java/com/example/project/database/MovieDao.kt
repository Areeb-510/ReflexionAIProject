package com.example.project.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.project.models.MovieResult

@Dao
interface MovieDao {

    @Insert
    suspend fun addMovies(movies: com.example.project.models.Result)

    @Delete
    suspend fun deleteMovie(movies: com.example.project.models.Result)

    @Query("SELECT * FROM movie_table")
    fun getMovies() : LiveData<List<com.example.project.models.Result>>

}