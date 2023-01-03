package com.example.tmdbapp.domain.use_cases.now_playing

import com.example.tmdbapp.data.model.movies.NowPlayingMovieResponse
import com.example.tmdbapp.domain.TmDbRepository
import com.example.tmdbapp.utils.NetworkResult
import javax.inject.Inject

class NowPlayingMoviesList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, page: Int) :kotlinx.coroutines.flow.Flow<NetworkResult<NowPlayingMovieResponse>> {
        return tmDbRepository.nowPlayingList(lang, page)
    }
}