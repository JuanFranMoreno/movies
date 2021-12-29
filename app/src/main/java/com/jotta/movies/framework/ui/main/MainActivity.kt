package com.jotta.movies.framework.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jotta.movies.R
import com.jotta.movies.data.MovieRepository
import com.jotta.movies.databinding.ActivityMainBinding
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
        val recycler = findViewById<RecyclerView>(R.id.recycler)
        recycler.layoutManager = GridLayoutManager(this,3)

        viewModel.movies.observe(this){
            moviesAdapter.movies = it
        }

        recycler.adapter = moviesAdapter

        viewModel.onCreate()

        viewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })


    }
}