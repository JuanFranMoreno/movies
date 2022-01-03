package com.jotta.movies.framework.ui.movie_details

import androidx.lifecycle.ViewModel
import com.jotta.movies.usecases.GetMovieDetail
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val getDetailsMovie: GetMovieDetail): ViewModel() {
}