package com.example.tmdbapp.domain.use_cases.popular

import androidx.paging.PagingData
import com.example.tmdbapp.data.model.movies.MovieItem
import com.example.tmdbapp.domain.TmDbRepository
import javax.inject.Inject

class PopularMoviesPagingList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String) :kotlinx.coroutines.flow.Flow<PagingData<MovieItem>> {
        return tmDbRepository.popularPagingPagingList(lang)
    }
}