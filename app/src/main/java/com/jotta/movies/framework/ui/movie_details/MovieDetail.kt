package com.jotta.movies.framework.ui.movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.jotta.movies.R
import com.jotta.movies.data.MovieRepository
import com.jotta.movies.databinding.ActivityMainBinding
import javax.inject.Inject

class MovieDetail : AppCompatActivity() {
    companion object {
        const val EXTRA_ID = "DetailActivity:extraId"
    }

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<DetailViewModel>()

    @Inject
    lateinit var movieRepository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
    }
}