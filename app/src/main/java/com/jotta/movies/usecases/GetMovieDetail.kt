package com.jotta.movies.usecases

import com.jotta.movies.data.MovieRepository
import com.jotta.movies.data.model.DetailModel

class GetMovieDetail(private val repository: MovieRepository, private val id: Int) {
    suspend operator fun invoke(): DetailModel? = repository.getMovieDetails(id)
}