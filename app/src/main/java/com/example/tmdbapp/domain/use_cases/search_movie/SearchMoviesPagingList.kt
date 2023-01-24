package com.example.tmdbapp.domain.use_cases.search_movie

import androidx.paging.PagingData
import com.example.tmdbapp.data.model.movies.MovieItem
import com.example.tmdbapp.data.model.search_movies.SearchMovieResponse
import com.example.tmdbapp.domain.TmDbRepository
import com.example.tmdbapp.utils.NetworkResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class SearchMoviesPagingList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(
        query: String,
        lang: String
    ): Flow<NetworkResult<Response<SearchMovieResponse>>> {
        return tmDbRepository.searchPagingList(query = query, lang = lang)
    }
}