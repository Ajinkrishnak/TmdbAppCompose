package com.tmdb.domain.use_cases.now_playing

import com.tmdb.domain.TmDbRepository
import com.tmdb.domain.common.NetworkResult
import com.tmdb.domain.model.movies.NowPlayingMovieResponse
import javax.inject.Inject

class NowPlayingMoviesList @Inject constructor(private val tmDbRepository: TmDbRepository) {
    suspend operator fun invoke(lang: String, page: Int) :kotlinx.coroutines.flow.Flow<NetworkResult<NowPlayingMovieResponse>> {
        return tmDbRepository.nowPlayingList(lang, page)
    }
}