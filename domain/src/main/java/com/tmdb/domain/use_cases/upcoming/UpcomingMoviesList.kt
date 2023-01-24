package com.tmdb.domain.use_cases.upcoming

import com.tmdb.domain.TmDbRepository
import com.tmdb.domain.common.NetworkResult
import com.tmdb.domain.model.movies.UpcomingMovieResponse
import javax.inject.Inject

class UpcomingMoviesList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, page: Int) :kotlinx.coroutines.flow.Flow<NetworkResult<UpcomingMovieResponse>> {
        return tmDbRepository.upcomingList(lang, page)
    }
}