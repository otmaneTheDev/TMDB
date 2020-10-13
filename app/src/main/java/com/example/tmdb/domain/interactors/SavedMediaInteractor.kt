package com.example.tmdb.domain.interactors

import com.example.tmdb.data.repository.TMDBRepositoryImpl
import com.example.tmdb.domain.mappers.UIMediaMapper
import com.example.tmdb.ui.models.UIMedia
import javax.inject.Inject

class SavedMediaInteractor @Inject constructor(private val repository: TMDBRepositoryImpl, private val uIMediaMapper: UIMediaMapper) {

    suspend operator fun invoke(): List<UIMedia> {
        return repository.getSavedMedia().map { uIMediaMapper.map(it) }
    }

}
