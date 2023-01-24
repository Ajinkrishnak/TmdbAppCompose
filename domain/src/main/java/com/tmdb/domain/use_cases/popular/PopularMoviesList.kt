package com.tmdb.domain.use_cases.popular

import com.tmdb.domain.TmDbRepository
import com.tmdb.domain.common.NetworkResult
import com.tmdb.domain.model.movies.PopularMovieResponse
import javax.inject.Inject

class PopularMoviesList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, page: Int) :kotlinx.coroutines.flow.Flow<NetworkResult<PopularMovieResponse>> {
        return tmDbRepository.popularList(lang, page)
    }
}