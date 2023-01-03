package com.example.tmdbapp.domain.use_cases.top_rated

import com.example.tmdbapp.data.model.movies.TopRatedMovieResponse
import com.example.tmdbapp.domain.TmDbRepository
import com.example.tmdbapp.utils.NetworkResult
import javax.inject.Inject

class TopRatedMoviesList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, page: Int) :kotlinx.coroutines.flow.Flow<NetworkResult<TopRatedMovieResponse>> {
        return tmDbRepository.topRatedList(lang, page)
    }
}