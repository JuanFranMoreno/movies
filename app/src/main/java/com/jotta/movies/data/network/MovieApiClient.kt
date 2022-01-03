package com.jotta.movies.data.network

import com.jotta.movies.data.model.DetailModel
import com.jotta.movies.data.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiClient {
    @GET("movie/popular?api_key=c14b7ab9f779002f646e111b7ec0d86e")
    suspend fun getPopularMovies(): Response<MovieModel> //Utilizamos suspend porque vamos a utilizar corrutinas

    @GET("movie/{id}?api_key=c14b7ab9f779002f646e111b7ec0d86e")
    fun getMovieDetails(@Path("id") id: Int): Response<DetailModel>

    //Ejemplo para enviar una petición de edición
    /*@POST("posts/{id}")
    fun editPostById(@Path("id") id:Int, @Body post: Post?): Call<Post>*/
}