package com.tmdb.domain.use_cases.details


import com.tmdb.domain.TmDbRepository
import com.tmdb.domain.common.NetworkResult
import com.tmdb.domain.model.cast.MovieCreditsResponse
import retrofit2.Response
import javax.inject.Inject

class MovieCredits @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, movieId: String) :kotlinx.coroutines.flow.Flow<NetworkResult<Response<MovieCreditsResponse>>> {
        return tmDbRepository.movieCredits(lang, movieId)
    }
}