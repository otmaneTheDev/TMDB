package com.example.tmdb.data.datasource.remote

import com.example.tmdb.data.models.*

interface TMDBRemoteDataSource {
    suspend fun getPopularMovies(): PopularMoviesResponse
    suspend fun getPopularTvShows(): PopularTvShowsResponse
    suspend fun getTrendingMedia(type: String, time: String): TrendingMediaResponse
    suspend fun getTvShowDetailById(id: Int): TvShowDetailResponse
    suspend fun getMovieDetailById(id: Int): MovieDetailResponse
    suspend fun getTvShowSeasonEpisodes(tvShowId: Int, seasonNum: Int): TvShowSeasonEpisodesResponse

    suspend fun getDiscoverTvShows(page: Int, genres: String, networks: String): DiscoverTvShowResponse
    suspend fun getDiscoverMovies(page: Int, genres: String, networks: String): DiscoverMovieResponse
}