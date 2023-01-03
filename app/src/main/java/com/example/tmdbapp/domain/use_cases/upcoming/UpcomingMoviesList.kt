package com.example.tmdbapp.domain.use_cases.upcoming

import com.example.tmdbapp.data.model.movies.UpcomingMovieResponse
import com.example.tmdbapp.domain.TmDbRepository
import com.example.tmdbapp.utils.NetworkResult
import javax.inject.Inject

class UpcomingMoviesList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, page: Int) :kotlinx.coroutines.flow.Flow<NetworkResult<UpcomingMovieResponse>> {
        return tmDbRepository.upcomingList(lang, page)
    }
}