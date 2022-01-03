package com.jotta.movies.data.network

import com.jotta.movies.core.RetrofitHelper
import com.jotta.movies.data.model.DetailModel
import com.jotta.movies.data.model.MovieModel
import com.jotta.movies.domain.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MovieService{

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getPopularMovies(): MovieModel {
        return withContext(Dispatchers.IO) {
            val response: Response<MovieModel> =
                retrofit.create(MovieApiClient::class.java).getPopularMovies()
            response.body() ?: MovieModel(0, 0, 0, emptyList())
        }
    }

    suspend fun getMovieDetails(id: Int): DetailModel{
        return withContext(Dispatchers.IO){
            val response: Response<DetailModel> =
                retrofit.create(MovieApiClient::class.java).getMovieDetails(id)
            response.body() ?: DetailModel("","","")
        }
    }
}