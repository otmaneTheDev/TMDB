package com.example.tmdb.di

import com.example.tmdb.data.datasource.remote.RemoteTMDBRemoteDataSource
import com.example.tmdb.data.datasource.remote.TMDBRemoteDataSource
import com.example.tmdb.data.repository.TMDBRepository
import com.example.tmdb.data.repository.TMDBRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesRemoteDataSource(remoteDataSource: RemoteTMDBRemoteDataSource): TMDBRemoteDataSource = remoteDataSource

    @Provides
    @Singleton
    fun provideRepository(repository: TMDBRepositoryImpl): TMDBRepository = repository

}