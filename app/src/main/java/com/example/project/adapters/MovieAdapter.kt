package com.example.project.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.google.android.material.button.MaterialButton

class MovieAdapter(val context : Context,val listner : IMoviesRVApadter) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    val allMovies = ArrayList<com.example.project.models.Result>()

    inner class MovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val movie_poster = itemView.findViewById<ImageView>(R.id.movie_poster)
        val title = itemView.findViewById<TextView>(R.id.title_movie)
        val genre = itemView.findViewById<TextView>(R.id.genre)
        val year = itemView.findViewById<TextView>(R.id.year)
        val imdb = itemView.findViewById<TextView>(R.id.imdb)
        val runtime = itemView.findViewById<TextView>(R.id.runtime)
        val director = itemView.findViewById<TextView>(R.id.director)
        val writers = itemView.findViewById<TextView>(R.id.writers)
        val cast = itemView.findViewById<TextView>(R.id.cast)
        val rating = itemView.findViewById<TextView>(R.id.rating)

        val summary = itemView.findViewById<TextView>(R.id.summary)
        val delete_btn = itemView.findViewById<MaterialButton>(R.id.delete_button)
        val fav_btn = itemView.findViewById<MaterialButton>(R.id.fav_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = MovieViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false))


        view.delete_btn.setOnClickListener {
            listner.onItemClicked(allMovies[view.adapterPosition])
        }

        view.fav_btn.setOnClickListener {
            listner.onFavButtonClicked(allMovies[view.adapterPosition])
        }

        return view
    }

    override fun getItemCount(): Int {
        return allMovies.size
    }

    fun updateList(newList : List<com.example.project.models.Result>){
        allMovies.clear()
        allMovies.addAll(newList)

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = allMovies[position]
        holder.title.text = currentMovie.title.toString()
        holder.genre.text = currentMovie.genres.toString()
        holder.year.text = currentMovie.year.toString()
        holder.imdb.text = currentMovie.imdb_id.toString()
        holder.runtime.text = currentMovie.runtime.toString()
        holder.rating.text = currentMovie.rating.toString()
        holder.director.text = currentMovie.director.toString()
        holder.writers.text = currentMovie.writers.toString()
        holder.cast.text = currentMovie.cast.toString()


        holder.summary.text = currentMovie.summary.toString()

        Glide.with(holder.itemView.context).load(currentMovie.poster).into(holder.movie_poster)
    }


    interface IMoviesRVApadter{
        fun onItemClicked(movie : com.example.project.models.Result)

        fun onFavButtonClicked(movie : com.example.project.models.Result)
    }

}