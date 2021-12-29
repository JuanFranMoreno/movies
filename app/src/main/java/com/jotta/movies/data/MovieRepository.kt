package com.jotta.movies.data

import com.jotta.movies.data.model.MovieModel
import com.jotta.movies.data.network.MovieService

class MovieRepository {
    private val api = MovieService()
    suspend fun getPopularMovies():MovieModel{
        val response: MovieModel = api.getPopularMovies()
        return response
    }

}