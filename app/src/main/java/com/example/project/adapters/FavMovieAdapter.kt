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
import com.example.project.models.FavouriteResult
import com.google.android.material.button.MaterialButton

class FavMovieAdapter(val context: Context) :
    RecyclerView.Adapter<FavMovieAdapter.FavMovieViewHolder>() {

    val allMovies = ArrayList<FavouriteResult>()


    inner class FavMovieViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val movie_poster = itemView.findViewById<ImageView>(R.id.movie_poster1)
        val title = itemView.findViewById<TextView>(R.id.title_movie1)
        val genre = itemView.findViewById<TextView>(R.id.genre1)
        val year = itemView.findViewById<TextView>(R.id.year1)
        val imdb = itemView.findViewById<TextView>(R.id.imdb1)
        val runtime = itemView.findViewById<TextView>(R.id.runtime1)
        val director = itemView.findViewById<TextView>(R.id.director1)
        val writers = itemView.findViewById<TextView>(R.id.writers1)
        val cast = itemView.findViewById<TextView>(R.id.cast1)
        val rating = itemView.findViewById<TextView>(R.id.rating1)

        val summary = itemView.findViewById<TextView>(R.id.summary1)
//        val delete_btn = itemView.findViewById<MaterialButton>(R.id.delete_button)
//        val fav_btn = itemView.findViewById<MaterialButton>(R.id.fav_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavMovieViewHolder {
        val view = FavMovieViewHolder(
            LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie2, parent, false))

        return view
    }

    override fun getItemCount(): Int {
        return allMovies.size
    }

    fun updateList(newList : List<FavouriteResult>){
        allMovies.clear()
        allMovies.addAll(newList)

        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: FavMovieViewHolder, position: Int) {
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
}