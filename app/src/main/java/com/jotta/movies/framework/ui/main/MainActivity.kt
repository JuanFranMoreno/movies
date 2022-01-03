package com.jotta.movies.framework.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import com.jotta.movies.core.observe
import com.jotta.movies.core.startActivity
import com.jotta.movies.data.MovieRepository
import com.jotta.movies.databinding.ActivityMainBinding
import com.jotta.movies.framework.ui.movie_details.MovieDetail
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint //Lo que necesitamos para inyectar dependencias
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //Acceder al ViewModel mediante un delegado
    private val viewModel by viewModels<MainViewModel>()

    @Inject lateinit var movieRepository: MovieRepository //Cuando esto pase por el onCreate me va a inyectar la dependencia del movieRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val moviesAdapter = MoviesAdapter(viewModel::onMovieClicked)
        val recycler = binding.recycler
        recycler.layoutManager = GridLayoutManager(this,3)

        with(viewModel){
            observe(movies) {moviesAdapter.movies = it}
            observe(isLoading) {binding.progressBar.isVisible = it}
            observe(navigateToDetail){
                event -> event.getContentIfNotHandled()?.let { navigateToDetail(it) }
            }

        }

        recycler.adapter = moviesAdapter
        viewModel.onCreate()
    }

    private fun navigateToDetail(id: Int){
        startActivity<MovieDetail>(MovieDetail.EXTRA_ID to id)
    }
}