package com.example.project.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project.models.FavouriteResult
import com.example.project.models.Result
import com.example.project.repository.FavouriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavViewModel(private val repository: FavouriteRepository) : ViewModel(){

    var movies : LiveData<List<FavouriteResult>>

    init {
        movies = repository.favLiveData
    }

    fun addMovie(movie : FavouriteResult) = viewModelScope.launch(Dispatchers.IO){
        repository.addFavMovie(movie)

    }


}