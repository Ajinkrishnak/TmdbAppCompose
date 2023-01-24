package com.tmdb.domain.use_cases.top_rated

import com.tmdb.domain.TmDbRepository
import com.tmdb.domain.common.NetworkResult
import com.tmdb.domain.model.movies.TopRatedMovieResponse
import javax.inject.Inject

class TopRatedMoviesList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, page: Int) :kotlinx.coroutines.flow.Flow<NetworkResult<TopRatedMovieResponse>> {
        return tmDbRepository.topRatedList(lang, page)
    }
}