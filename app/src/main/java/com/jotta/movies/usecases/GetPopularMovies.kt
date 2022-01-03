package com.jotta.movies.usecases

import com.jotta.movies.data.MovieRepository
import com.jotta.movies.data.model.MovieModel

class GetPopularMovies(private val repository: MovieRepository){
    suspend operator fun invoke(): MovieModel? = repository.getPopularMovies()
}