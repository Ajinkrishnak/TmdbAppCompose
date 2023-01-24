package com.tmdb.data.di

import com.tmdb.data.api.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.tmdb.data.BuildConfig
import com.tmdb.domain.TmDbRepository
import com.tmdb.domain.common.Constants.CONNECT_TIMEOUT
import com.tmdb.domain.common.Constants.READ_TIMEOUT
import com.tmdb.domain.common.Constants.WRITE_TIMEOUT
import com.tmdb.domain.use_cases.UseCases
import com.tmdb.domain.use_cases.details.GetVideos
import com.tmdb.domain.use_cases.details.MovieCredits
import com.tmdb.domain.use_cases.details.MovieDetails
import com.tmdb.domain.use_cases.now_playing.NowPlayingMoviesList
import com.tmdb.domain.use_cases.now_playing.NowPlayingMoviesPagingList
import com.tmdb.domain.use_cases.popular.PopularMoviesList
import com.tmdb.domain.use_cases.popular.PopularMoviesPagingList
import com.tmdb.domain.use_cases.search_movie.SearchMoviesPagingList
import com.tmdb.domain.use_cases.top_rated.TopRatedMoviesList
import com.tmdb.domain.use_cases.top_rated.TopRatedMoviesPagingList
import com.tmdb.domain.use_cases.upcoming.UpcomingMoviesList
import com.tmdb.domain.use_cases.upcoming.UpcomingMoviesPagingList
import okhttp3.Interceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun providesGson(): Gson = GsonBuilder().setLenient().create()

   @Provides
    @Singleton
    fun clientInterceptor() :Interceptor =
        Interceptor { chain ->
            val request = chain.request()
            val newUrl = request.url.newBuilder()
                .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                .build()

            val newRequest = request.newBuilder()
                .url(newUrl)
                .build()
            chain.proceed(newRequest)
        }


    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(
                OkHttpClient.Builder().also { client ->
                    val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    }
                    client.addInterceptor(httpLoggingInterceptor)
                    client.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    client.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    client.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    client.addNetworkInterceptor(clientInterceptor())
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun useCases(tmDbRepository: TmDbRepository): UseCases = UseCases(
        //paging
        PopularMoviesPagingList(tmDbRepository),
        NowPlayingMoviesPagingList(tmDbRepository),
        UpcomingMoviesPagingList(tmDbRepository),
        TopRatedMoviesPagingList(tmDbRepository),
        //non-paging
        PopularMoviesList(tmDbRepository),
        NowPlayingMoviesList(tmDbRepository),
        UpcomingMoviesList(tmDbRepository),
        TopRatedMoviesList(tmDbRepository),

        MovieDetails(tmDbRepository),
        MovieCredits(tmDbRepository),
        GetVideos(tmDbRepository),
        SearchMoviesPagingList(tmDbRepository),
    )
}