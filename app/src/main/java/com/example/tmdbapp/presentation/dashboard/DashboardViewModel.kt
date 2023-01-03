package com.example.tmdbapp.presentation.dashboard

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateMapOf
import com.example.tmdbapp.data.model.movies.MovieItem
import com.example.tmdbapp.domain.use_cases.UseCases
import com.example.tmdbapp.utils.Constants
import com.example.tmdbapp.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay

@HiltViewModel
class DashboardViewModel @Inject constructor(useCases: UseCases) : ViewModel() {


    private var _popularMovieList = mutableStateListOf<MovieItem>()
    val popularMovieList: List<MovieItem> = _popularMovieList

    private var _nowPlayingMovieList = mutableStateListOf<MovieItem>()
    val nowPlayingMovieList: List<MovieItem> = _nowPlayingMovieList

    private var _upcomingMovieList = mutableStateListOf<MovieItem>()
    val upcomingMovieList: List<MovieItem> = _upcomingMovieList

    private var _topRatedMovieList = mutableStateListOf<MovieItem>()
    val topRatedMovieList: List<MovieItem> = _topRatedMovieList

    private val _apiError = mutableStateOf(false)
    val apiError: State<Boolean> = _apiError

    private var _isLoading = mutableStateMapOf<Int, Boolean>()
    val isLoading: Map<Int, Boolean> = _isLoading

    init {
        viewModelScope.launch {
            useCases.popularMoviesList.invoke(Constants.LANG, 1).collect {
                when (it) {

                    is NetworkResult.Success -> {

                        _popularMovieList.clear()
                        it.value.results?.forEach { result ->
                            _popularMovieList.add(result)
                        }
                        _isLoading[0] = false

                    }
                    is NetworkResult.Failure -> {
                        _apiError.value = true
                        _isLoading[0] = false
                    }

                    is NetworkResult.Loading -> {
                        _isLoading[0] = true
                    }
                }

            }

            useCases.nowPlayingMoviesList.invoke(Constants.LANG, 1).collect {
                when (it) {

                    is NetworkResult.Success -> {

                        _nowPlayingMovieList.clear()
                        it.value.results?.forEach { result ->
                            _nowPlayingMovieList.add(result)
                        }
                        delay(1000)
                        _isLoading[1] = false


                    }
                    is NetworkResult.Failure -> {
                        _apiError.value = true
                        _isLoading[1] = false
                    }

                    is NetworkResult.Loading -> {
                        _isLoading[1] = true
                    }
                }

            }

            useCases.upcomingMoviesList.invoke(Constants.LANG, 1).collect {
                when (it) {

                    is NetworkResult.Success -> {

                        _upcomingMovieList.clear()
                        it.value.results?.forEach { result ->
                            _upcomingMovieList.add(result)
                        }
                        delay(1000)
                        _isLoading[2] = false


                    }
                    is NetworkResult.Failure -> {
                        _apiError.value = true
                        _isLoading[2] = false
                    }

                    is NetworkResult.Loading -> {
                        _isLoading[2] = true
                    }
                }

            }

            useCases.topRatedMoviesList.invoke(Constants.LANG, 1).collect {
                when (it) {

                    is NetworkResult.Success -> {

                        _topRatedMovieList.clear()
                        it.value.results?.forEach { result ->
                            _topRatedMovieList.add(result)
                        }
                        delay(1000)
                        _isLoading[3] = false


                    }
                    is NetworkResult.Failure -> {
                        _apiError.value = true
                        _isLoading[3] = false
                    }

                    is NetworkResult.Loading -> {
                        _isLoading[3] = true
                    }
                }

            }
        }
    }


}