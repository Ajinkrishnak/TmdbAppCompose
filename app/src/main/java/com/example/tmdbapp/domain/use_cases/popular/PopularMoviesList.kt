package com.example.tmdbapp.domain.use_cases.popular

import com.example.tmdbapp.data.model.movies.PopularMovieResponse
import com.example.tmdbapp.domain.TmDbRepository
import com.example.tmdbapp.utils.NetworkResult
import javax.inject.Inject

class PopularMoviesList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, page: Int) :kotlinx.coroutines.flow.Flow<NetworkResult<PopularMovieResponse>> {
        return tmDbRepository.popularList(lang, page)
    }
}