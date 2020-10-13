package com.example.tmdb.data.datasource.cache

import com.example.tmdb.data.cache.TMDBDatabase
import com.example.tmdb.data.cache.models.MediaEntity
import com.example.tmdb.data.mappers.MediaMapper
import com.example.tmdb.data.models.MovieDetailResponse
import com.example.tmdb.data.models.TvShowDetailResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CacheTMDBDataSource @Inject constructor(
    private val tmdbDatabase: TMDBDatabase,
    private val mediaMapper: MediaMapper
) : TMDBCacheDataSource {

    override suspend fun saveTvShow(tvShowDetail: TvShowDetailResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            tmdbDatabase.mediaDAO().insertNewMedia(mediaMapper.map(tvShowDetail))
        }
    }

    override suspend fun saveMovie(movieDetail: MovieDetailResponse) {
        CoroutineScope(Dispatchers.IO).launch {
            tmdbDatabase.mediaDAO().insertNewMedia(mediaMapper.map(movieDetail))
        }
    }

    override suspend fun getSavedMedia(): List<MediaEntity> {
        return withContext(Dispatchers.IO) {
            tmdbDatabase.mediaDAO().getAllMedia()
        }
    }

    override suspend fun removeMedia(id: Int) {
        return withContext(Dispatchers.IO) {
            tmdbDatabase.mediaDAO().removeMediaWithId(id)
        }
    }

    override suspend fun checkIfMediaWithId(id: Int): Boolean {
        return withContext(Dispatchers.IO) {
            tmdbDatabase.mediaDAO().checkIfMediaWithId(id)
        }
    }
}