package com.jotta.movies.framework.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jotta.movies.R
import com.jotta.movies.data.model.MovieModel
import com.jotta.movies.data.model.ResultModel

class MoviesAdapter(private val listener: (ResultModel) -> Unit) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    var movies: List<ResultModel> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.view_movie,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.movieTitle)
        private val cover = view.findViewById<ImageView>(R.id.cover)

        fun bind(movie:ResultModel){
            title.text = movie.title
            Glide.with(cover.context)
                .load("https://image.tmdb.org/t/p/w500/${movie.posterPath}")
                .into(cover)
        }

    }

}