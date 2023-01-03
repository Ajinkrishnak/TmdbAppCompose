package com.example.tmdbapp.presentation.dashboard

sealed class MoviesType(val value: String) {
    object POPULAR : MoviesType("Popular")
    object NOW_PLAYING : MoviesType("Now Playing")
    object UPCOMING : MoviesType("Upcoming")
    object TOP_RATED : MoviesType("Top Rated")
}