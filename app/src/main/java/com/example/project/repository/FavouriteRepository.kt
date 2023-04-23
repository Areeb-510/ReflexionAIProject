package com.example.project.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.project.api.MovieService
import com.example.project.database.FavDatabase
import com.example.project.database.MovieDatabase
import com.example.project.models.FavouriteResult
import com.example.project.models.Result

class FavouriteRepository(private var favDatabase: FavDatabase,
                          private val applicationContext: Context
) {

    val favLiveData : LiveData<List<FavouriteResult>>


    init {
        favLiveData = favDatabase.favDao().getMovies()
    }

    suspend fun addFavMovie(movie : FavouriteResult){
        favDatabase.favDao().addMovies(movie)
    }

}