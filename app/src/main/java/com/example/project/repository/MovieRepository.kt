package com.example.project.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.project.api.MovieService
import com.example.project.database.MovieDatabase
import com.example.project.models.MovieResult

class MovieRepository(private val movieService: MovieService, private var movieDatabase: MovieDatabase,
                      private val applicationContext: Context
) {

    val movieLiveData : LiveData<List<com.example.project.models.Result>>


    init {
        movieLiveData = movieDatabase.movieDao().getMovies()
    }

    suspend fun getMovies(){
        val result = movieService.getMovies()
        Log.d("Check", result.toString())
//        result.body()?.results?.get(0)?.let { Log.d("Test", it.title) }
        if(movieDatabase.movieDao().getMovies().value?.size!=0){
            for (item in result.movies){
                movieDatabase.movieDao().addMovies(item)
            }
        }


//        movieLiveData.postValue(result.movies)
    }

    suspend fun deleteMovie(movie : com.example.project.models.Result){

//        Toast.makeText(applicationContext,movie.title,Toast.LENGTH_LONG).show()
        movieDatabase.movieDao().deleteMovie(movie)

    }


}