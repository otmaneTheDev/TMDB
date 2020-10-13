package com.example.tmdb.di

import android.content.Context
import com.example.tmdb.data.cache.TMDBDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): TMDBDatabase {
        return TMDBDatabase.invoke(context)
    }
}