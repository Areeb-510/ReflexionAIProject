package com.example.project

import android.app.Application
import com.example.project.api.MovieService
import com.example.project.api.RetrofitHelper
import com.example.project.database.FavDatabase
import com.example.project.database.MovieDatabase
import com.example.project.repository.FavouriteRepository
import com.example.project.repository.MovieRepository

class MovieApplication : Application() {

    lateinit var movieRepository: MovieRepository
    lateinit var favouriteRepository: FavouriteRepository

    override fun onCreate() {
        super.onCreate()
        initialize()
    }

    private fun initialize() {
        val movieService = RetrofitHelper.getInstance().create(MovieService::class.java)
        val database = MovieDatabase.getDatabase(applicationContext)
        val database2 = FavDatabase.getDatabase(applicationContext)
        movieRepository = MovieRepository(movieService, database, applicationContext)

        favouriteRepository = FavouriteRepository(database2, applicationContext)
    }
}