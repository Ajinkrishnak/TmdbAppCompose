package com.example.tmdbapp.domain.use_cases

import com.example.tmdbapp.domain.use_cases.details.GetVideos
import com.example.tmdbapp.domain.use_cases.details.MovieCredits
import com.example.tmdbapp.domain.use_cases.details.MovieDetails
import com.example.tmdbapp.domain.use_cases.now_playing.NowPlayingMoviesList
import com.example.tmdbapp.domain.use_cases.now_playing.NowPlayingMoviesPagingList
import com.example.tmdbapp.domain.use_cases.popular.PopularMoviesList
import com.example.tmdbapp.domain.use_cases.popular.PopularMoviesPagingList
import com.example.tmdbapp.domain.use_cases.search_movie.SearchMoviesPagingList
import com.example.tmdbapp.domain.use_cases.top_rated.TopRatedMoviesList
import com.example.tmdbapp.domain.use_cases.top_rated.TopRatedMoviesPagingList
import com.example.tmdbapp.domain.use_cases.upcoming.UpcomingMoviesList
import com.example.tmdbapp.domain.use_cases.upcoming.UpcomingMoviesPagingList

data class UseCases(
    //paging
    val popularMoviesPagingList: PopularMoviesPagingList,
    val nowPlayingMoviesPagingList: NowPlayingMoviesPagingList,
    val upcomingMoviesPagingList: UpcomingMoviesPagingList,
    val topRatedMoviesPagingList: TopRatedMoviesPagingList,
    //non-paging
    val popularMoviesList: PopularMoviesList,
    val nowPlayingMoviesList: NowPlayingMoviesList,
    val upcomingMoviesList: UpcomingMoviesList,
    val topRatedMoviesList: TopRatedMoviesList,
    val movieDetails: MovieDetails,
    val movieCredits: MovieCredits,
    val getVideos: GetVideos,
    val searchMoviesPagingList: SearchMoviesPagingList,
    )