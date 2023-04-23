package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.adapters.FavMovieAdapter
import com.example.project.adapters.MovieAdapter
import com.example.project.viewModel.FavViewModel
import com.example.project.viewModel.FavViewModelFactory

class FavouriteFragment : Fragment() {

    private lateinit var favViewModel : FavViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_favourite, container, false)

        val repository2 = (activity?.application as MovieApplication).favouriteRepository

        favViewModel = ViewModelProvider(this, FavViewModelFactory(repository2))[FavViewModel::class.java]


        val recyclerView : RecyclerView = v.findViewById(R.id.fav_recycler)

        recyclerView.layoutManager = LinearLayoutManager(v.context)
        val adapter = FavMovieAdapter(v.context)
        recyclerView.adapter = adapter


        activity?.let {
            favViewModel.movies.observe(it, Observer {

                adapter.updateList(it)

            })
        }


        return v
    }

}