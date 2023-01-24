package com.example.tmdbapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.tmdbapp.data.ApiService
import com.example.tmdbapp.data.model.cast.MovieCreditsResponse
import com.example.tmdbapp.data.model.details.MovieDetailsResponse
import com.example.tmdbapp.data.model.movies.*
import com.example.tmdbapp.data.model.search_movies.SearchMovieResponse
import com.example.tmdbapp.data.model.videos.GetVideosResponse
import com.example.tmdbapp.data.paging.*
import com.example.tmdbapp.domain.TmDbRepository
import com.example.tmdbapp.utils.Constants
import com.example.tmdbapp.utils.NetworkResult
import com.example.tmdbapp.utils.ResponseCodeManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class TmDbRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    TmDbRepository {
    //paging
    override suspend fun popularPagingPagingList(lang: String): Flow<PagingData<MovieItem>> = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = { PopularPagingSource(apiService, lang) }
    ).flow

    override suspend fun nowPlayingPagingList(
        lang: String
    ): Flow<PagingData<MovieItem>> = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = { NowPlayingPagingSource(apiService, lang) }
    ).flow

    override suspend fun upcomingPagingList(lang: String): Flow<PagingData<MovieItem>> = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = { UpcomingPagingSource(apiService, lang) }
    ).flow

    override suspend fun topRatedPagingList(lang: String): Flow<PagingData<MovieItem>> = Pager(
        config = PagingConfig(
            pageSize = 10,
        ),
        pagingSourceFactory = { TopRatedPagingSource(apiService, lang) }
    ).flow


    //non-paging
    override suspend fun popularList(
        lang: String,
        page: Int
    ): Flow<NetworkResult<PopularMovieResponse>> {
        return flow {
            emit(NetworkResult.Loading)
            try {
                val response = apiService.getPopular(
                    page = page, language = lang
                )
                emit(
                    NetworkResult.Success(response)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            NetworkResult.Failure(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()
                                    ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                        }
                        is IOException -> {
                            NetworkResult.Failure(true, null, null, Constants.STS_DEFAULT)
                        }
                        else -> {
                            NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override suspend fun nowPlayingList(
        lang: String,
        page: Int
    ): Flow<NetworkResult<NowPlayingMovieResponse>> {
        return flow {
            emit(NetworkResult.Loading)
            try {
                val response = apiService.getNowPlaying(
                    page = page, language = lang
                )
                emit(
                    NetworkResult.Success(response)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            NetworkResult.Failure(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()
                                    ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                        }
                        is IOException -> {
                            NetworkResult.Failure(true, null, null, Constants.STS_DEFAULT)
                        }
                        else -> {
                            NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override suspend fun upcomingList(
        lang: String,
        page: Int
    ): Flow<NetworkResult<UpcomingMovieResponse>> {
        return flow {
            emit(NetworkResult.Loading)
            try {
                val response = apiService.getUpcoming(
                    page = page, language = lang
                )
                emit(
                    NetworkResult.Success(response)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            NetworkResult.Failure(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()
                                    ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                        }
                        is IOException -> {
                            NetworkResult.Failure(true, null, null, Constants.STS_DEFAULT)
                        }
                        else -> {
                            NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override suspend fun topRatedList(
        lang: String,
        page: Int
    ): Flow<NetworkResult<TopRatedMovieResponse>> {
        return flow {
            emit(NetworkResult.Loading)
            try {
                val response = apiService.getTopRated(
                    page = page, language = lang
                )
                emit(
                    NetworkResult.Success(response)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            NetworkResult.Failure(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()
                                    ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                        }
                        is IOException -> {
                            NetworkResult.Failure(true, null, null, Constants.STS_DEFAULT)
                        }
                        else -> {
                            NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)

    }


    override suspend fun movieDetails(
        lang: String,
        movieId: String
    ): Flow<NetworkResult<Response<MovieDetailsResponse>>> {
        return flow {
            emit(NetworkResult.Loading)
            try {
                val response = apiService.getMovieDetails(
                    movieId = movieId, language = lang
                )
                emit(
                    if (response.isSuccessful) NetworkResult.Success(response) else
                        NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            NetworkResult.Failure(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()
                                    ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                        }
                        is IOException -> {
                            NetworkResult.Failure(true, null, null, Constants.STS_DEFAULT)
                        }
                        else -> {
                            NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override suspend fun movieCredits(
        lang: String,
        movieId: String
    ): Flow<NetworkResult<Response<MovieCreditsResponse>>> {
        return flow {
            emit(NetworkResult.Loading)
            try {
                val response = apiService.getMovieCredits(
                    movieId = movieId, language = lang
                )
                emit(
                    if (response.isSuccessful) NetworkResult.Success(response) else
                        NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            NetworkResult.Failure(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()
                                    ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                        }
                        is IOException -> {
                            NetworkResult.Failure(true, null, null, Constants.STS_DEFAULT)
                        }
                        else -> {
                            NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override suspend fun getVideos(
        lang: String,
        movieId: String
    ): Flow<NetworkResult<Response<GetVideosResponse>>> {
        return flow {
            emit(NetworkResult.Loading)
            try {
                val response = apiService.getVideos(
                    movieId = movieId, language = lang
                )
                emit(
                    if (response.isSuccessful) NetworkResult.Success(response) else
                        NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            NetworkResult.Failure(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()
                                    ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                        }
                        is IOException -> {
                            NetworkResult.Failure(true, null, null, Constants.STS_DEFAULT)
                        }
                        else -> {
                            NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)

    }

    override suspend fun searchPagingList(
        query: String,
        lang: String
    ): Flow<NetworkResult<Response<SearchMovieResponse>>> {
        return flow {
            emit(NetworkResult.Loading)
            try {
                val response = apiService.searchMovie(query = query, language = lang, page = 1)
                emit(
                    if (response.isSuccessful) NetworkResult.Success(response) else
                        NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                )
            } catch (throwable: Throwable) {
                emit(
                    when (throwable) {
                        is HttpException -> {
                            NetworkResult.Failure(
                                false,
                                throwable.code(),
                                throwable.response()?.errorBody(),
                                throwable.response()
                                    ?.let { ResponseCodeManager.checkRetrofitApiResponse(it) })
                        }
                        is IOException -> {
                            NetworkResult.Failure(true, null, null, Constants.STS_DEFAULT)
                        }
                        else -> {
                            NetworkResult.Failure(false, null, null, Constants.CONVERSION_FAILURE)
                        }
                    }
                )
            }
        }.flowOn(Dispatchers.IO)

    }


}
