package com.example.project

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.adapters.MovieAdapter
import com.example.project.models.FavouriteResult
import com.example.project.models.Result
import com.example.project.viewModel.FavViewModel
import com.example.project.viewModel.FavViewModelFactory
import com.example.project.viewModel.MovieViewModel
import com.example.project.viewModel.MovieViewModelFactory
import com.google.android.material.snackbar.Snackbar
import de.hdodenhof.circleimageview.CircleImageView

class FirstFragment : Fragment(),MovieAdapter.IMoviesRVApadter {


    lateinit var movieViewModel: MovieViewModel

    lateinit var favViewModel : FavViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

        val repository = (activity?.application as MovieApplication).movieRepository

        val repository2 = (activity?.application as MovieApplication).favouriteRepository

        movieViewModel = ViewModelProvider(this, MovieViewModelFactory(repository))[MovieViewModel::class.java]

        favViewModel = ViewModelProvider(this, FavViewModelFactory(repository2))[FavViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v =  inflater.inflate(R.layout.fragment_first, container, false)


        val proflile = v.findViewById<CircleImageView>(R.id.profileoption)


        proflile.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToProfileFragment()
            findNavController().navigate(action)
        }

//
        val recyclerView : RecyclerView = v.findViewById(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(v.context)
        val adapter = MovieAdapter(v.context,this)
        recyclerView.adapter = adapter
//
//
        activity?.let {
            movieViewModel.movies.observe(it, Observer {

                adapter.updateList(it)

            })
        }

//        val retrofit = Retrofit.Builder()
//            .baseUrl("http://task.auditflo.in/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//
//        val service = retrofit.create(MovieService::class.java)
//
//        val call = service.getMovies()
//
//        call.enqueue(object : Callback<MovieResult> {
//            override fun onResponse(call: Call<MovieResult>, response: Response<MovieResult>) {
//                val items = response.body()
//
//                // Now you can iterate over the list of items and retrieve the fields you need
//                if (items != null) {
//                    for (item in items.movies) {
//                        Toast.makeText(activity,"${item.title}",Toast.LENGTH_LONG).show()
//                    }
//
//                }else{
//                    Toast.makeText(activity,"id",Toast.LENGTH_LONG).show()
//                }
//            }
//
//            override fun onFailure(call: Call<MovieResult>, t: Throwable) {
//                Toast.makeText(activity,"$t",Toast.LENGTH_LONG).show()
//            }
//        })
        return v
    }

    override fun onItemClicked(movie: Result) {

//        Toast.makeText(activity,movie.title,Toast.LENGTH_LONG).show()

        movieViewModel.deleteMovie(movie)

        val snackbar = view?.let {
            Snackbar.make(
                it, "Deleted an entry",
                Snackbar.LENGTH_LONG).setAction("Action", null)
        }
        if (snackbar != null) {
            snackbar.setActionTextColor(resources.getColor(R.color.bluedark))
        }
        val snackbarView = snackbar?.view
        val textView =
            snackbarView?.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        textView.textSize = 14f

        if (snackbarView != null) {
            snackbarView.setBackgroundColor(resources.getColor(R.color.bluedark))
        }
        if (snackbar != null) {
            snackbar.show()
        }

    }

    override fun onFavButtonClicked(movie: Result) {

        val newItem = FavouriteResult(
            title = movie.title,
            year = movie.year,
            summary = movie.summary,
            short_summary = movie.short_summary,
            genres = movie.genres,
            imdb_id = movie.imdb_id,
            runtime = movie.runtime,
            youtube_trailer = movie.youtube_trailer,
            rating = movie.rating,
            poster = movie.poster,
            director = movie.director,
            writers = movie.writers,
            cast = movie.cast
        )

        favViewModel.addMovie(newItem)

        val snackbar = view?.let {
            Snackbar.make(
                it, "Added to favourites",
                Snackbar.LENGTH_LONG).setAction("Action", null)
        }
        if (snackbar != null) {
            snackbar.setActionTextColor(resources.getColor(R.color.bluedark))
        }
        val snackbarView = snackbar?.view
        val textView =
            snackbarView?.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.WHITE)
        textView.textSize = 14f

        if (snackbarView != null) {
            snackbarView.setBackgroundColor(resources.getColor(R.color.bluedark))
        }
        if (snackbar != null) {
            snackbar.show()
        }
    }

}