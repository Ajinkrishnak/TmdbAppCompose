package com.tmdb.domain.use_cases.upcoming

import androidx.paging.PagingData
import com.tmdb.domain.TmDbRepository
import com.tmdb.domain.model.movies.MovieItem
import javax.inject.Inject

class UpcomingMoviesPagingList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String) :kotlinx.coroutines.flow.Flow<PagingData<MovieItem>> {
        return tmDbRepository.upcomingPagingList(lang)
    }
}