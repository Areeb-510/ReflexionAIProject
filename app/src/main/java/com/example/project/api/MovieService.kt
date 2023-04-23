package com.example.project.api

import com.example.project.models.MovieResult
import com.example.project.models.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("/1.json")
    suspend fun getMovies() : MovieResult

}