package com.jotta.movies.data

import com.jotta.movies.data.model.DetailModel
import com.jotta.movies.data.model.MovieModel
import com.jotta.movies.data.network.MovieService

class MovieRepository{
    private val api = MovieService()
    suspend fun getPopularMovies():MovieModel{
        val response: MovieModel = api.getPopularMovies()
        return response
    }

    suspend fun getMovieDetails(id:Int):DetailModel{
        val response: DetailModel = api.getMovieDetails(id)
        return response
    }

}