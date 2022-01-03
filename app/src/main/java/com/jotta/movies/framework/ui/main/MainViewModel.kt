package com.jotta.movies.framework.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jotta.movies.data.model.ResultModel
import com.jotta.movies.domain.Movie
import com.jotta.movies.framework.ui.Event
import com.jotta.movies.usecases.GetPopularMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getPopularMovies: GetPopularMovies) : ViewModel(){

    val movie = MutableLiveData<Movie>()
    val isLoading = MutableLiveData<Boolean>()

    //Hacer llamada a nuestro caso de uso
    private val _movies = MutableLiveData<List<ResultModel>>()
    val movies: LiveData<List<ResultModel>> get() = _movies

    private val _showMessage = MutableLiveData<String>()
    val showMessage: LiveData<String> get() = _showMessage

    private val _navigateToDetail = MutableLiveData<Event<Int>>()
    val navigateToDetail: LiveData<Event<Int>> get() = _navigateToDetail

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getPopularMovies()
            if(!result?.results.isNullOrEmpty()){
                _movies.postValue(result!!.results)
            }
        }
    }

    fun onMovieClicked(movie: ResultModel) {
        _navigateToDetail.value = Event(movie.id)
    }
}