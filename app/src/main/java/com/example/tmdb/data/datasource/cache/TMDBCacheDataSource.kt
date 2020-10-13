package com.example.tmdb.data.datasource.cache

import com.example.tmdb.data.cache.models.MediaEntity
import com.example.tmdb.data.models.MovieDetailResponse
import com.example.tmdb.data.models.TvShowDetailResponse

interface TMDBCacheDataSource {
    suspend fun saveTvShow(tvShowDetail: TvShowDetailResponse)
    suspend fun saveMovie(movieDetailResponse: MovieDetailResponse)
    suspend fun getSavedMedia(): List<MediaEntity>
    suspend fun checkIfMediaWithId(id: Int): Boolean
    suspend fun removeMedia(id: Int)
}