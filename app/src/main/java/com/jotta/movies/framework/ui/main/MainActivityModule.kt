package com.jotta.movies.framework.ui.main

import com.jotta.movies.data.MovieRepository
import com.jotta.movies.usecases.GetPopularMovies
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class) //Para que solo esté durante el periodo de vida de una activity
class MainActivityModule {

    //Este movieRepository lo va a proveer el inyector de dependencias
    @Provides
    fun getPopularMovies(repository: MovieRepository): GetPopularMovies {
        return GetPopularMovies(repository)
    }
}