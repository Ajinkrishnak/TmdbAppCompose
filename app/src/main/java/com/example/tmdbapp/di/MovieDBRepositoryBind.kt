package com.example.tmdbapp.di

import com.example.tmdbapp.data.repository.TmDbRepositoryImpl
import com.example.tmdbapp.domain.TmDbRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class TmDbRepositoryBind {

    @Binds
    @Singleton
    abstract fun bindRepository(tmDbRepositoryImpl: TmDbRepositoryImpl): TmDbRepository

}