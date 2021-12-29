package com.jotta.movies.usecases

import com.jotta.movies.data.MovieRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {
/*
    //Este movieRepository lo va a proveer el inyector de dependencias
    fun getPopularMovies(repository: MovieRepository): GetPopularMovies{
        return GetPopularMovies(repository)
    }*/
}