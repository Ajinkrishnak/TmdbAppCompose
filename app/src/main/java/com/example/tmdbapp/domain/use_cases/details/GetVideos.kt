package com.example.tmdbapp.domain.use_cases.details

import com.example.tmdbapp.data.model.cast.MovieCreditsResponse
import com.example.tmdbapp.data.model.details.MovieDetailsResponse
import com.example.tmdbapp.data.model.movies.NowPlayingMovieResponse
import com.example.tmdbapp.data.model.videos.GetVideosResponse
import com.example.tmdbapp.domain.TmDbRepository
import com.example.tmdbapp.utils.NetworkResult
import retrofit2.Response
import javax.inject.Inject

class GetVideos @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, movieId: String) :kotlinx.coroutines.flow.Flow<NetworkResult<Response<GetVideosResponse>>> {
        return tmDbRepository.getVideos(lang, movieId)
    }
}