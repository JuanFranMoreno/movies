package com.jotta.movies.domain

data class Movie(val page:Int, val totalResults: Int, val totalPages: Int, val results: List<Result>)
data class Result(
    val voteCount: Int,
    val id: Int,
    val video: Boolean,
    val voteAverage: Float,
    val title: String,
    val popularity: Double,
    val posterPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Int>,
    val backdropPath: String,
    val adult: Boolean,
    val overview: String,
    val releaseDate: String

)