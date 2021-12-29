package com.jotta.movies.framework.ui

import android.app.Application
import com.jotta.movies.data.network.MovieService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FrameworkModule {

    @Provides
    fun movieServiceProvider(app: Application) : MovieService{
        return MovieService()
    }
}