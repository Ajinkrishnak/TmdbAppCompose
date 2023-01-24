package com.example.tmdbapp.domain

import androidx.paging.PagingData
import com.example.tmdbapp.data.model.cast.MovieCreditsResponse
import com.example.tmdbapp.data.model.details.MovieDetailsResponse
import com.example.tmdbapp.data.model.movies.*
import com.example.tmdbapp.data.model.search_movies.SearchMovieResponse
import com.example.tmdbapp.data.model.videos.GetVideosResponse
import com.example.tmdbapp.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface TmDbRepository {
    //paging
    suspend fun popularPagingPagingList(lang: String): Flow<PagingData<MovieItem>>
    suspend fun nowPlayingPagingList(lang: String): Flow<PagingData<MovieItem>>
    suspend fun upcomingPagingList(lang: String): Flow<PagingData<MovieItem>>
    suspend fun topRatedPagingList(lang: String): Flow<PagingData<MovieItem>>

    //non-paging
    suspend fun popularList(lang: String, page: Int): Flow<NetworkResult<PopularMovieResponse>>
    suspend fun nowPlayingList(
        lang: String,
        page: Int
    ): Flow<NetworkResult<NowPlayingMovieResponse>>

    suspend fun upcomingList(lang: String, page: Int): Flow<NetworkResult<UpcomingMovieResponse>>
    suspend fun topRatedList(lang: String, page: Int): Flow<NetworkResult<TopRatedMovieResponse>>

    suspend fun movieDetails(
        lang: String,
        movieId: String
    ): Flow<NetworkResult<Response<MovieDetailsResponse>>>

    suspend fun movieCredits(
        lang: String,
        movieId: String
    ): Flow<NetworkResult<Response<MovieCreditsResponse>>>

    suspend fun getVideos(
        lang: String,
        movieId: String
    ): Flow<NetworkResult<Response<GetVideosResponse>>>

    suspend fun searchPagingList(query: String, lang: String): Flow<NetworkResult<Response<SearchMovieResponse>>>
}