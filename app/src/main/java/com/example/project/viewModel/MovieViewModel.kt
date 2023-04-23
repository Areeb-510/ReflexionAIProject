package com.example.project.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.models.MovieResult
import com.example.project.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    lateinit var movies : LiveData<List<com.example.project.models.Result>>

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getMovies()
        }

        movies = repository.movieLiveData

    }

//    val movies : LiveData<List<com.example.project.models.Result>>
//        get() = repository.movieLiveData


    fun deleteMovie(movie : com.example.project.models.Result) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteMovie(movie)

    }
}