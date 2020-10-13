package com.example.tmdb.ui.views.tvshowdetail.seasonsepisodes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdb.domain.interactors.TvShowDetailInteractor
import com.example.tmdb.ui.models.UIEpisode
import com.example.tmdb.ui.utils.LiveDataStatus
import kotlinx.coroutines.launch

class TvShowSeasonEpisodesViewModel @ViewModelInject constructor(private val tvShowDetailInteractor: TvShowDetailInteractor) : ViewModel() {
    val seasonEpisodes: LiveDataStatus<List<UIEpisode>> = tvShowDetailInteractor.seasonEpisodes

    fun getTvShowSeasonEpisodes(tvShowId: Int, seasonNum: Int) {
        viewModelScope.launch {
            tvShowDetailInteractor.retrieveSeasonEpisodes(tvShowId, seasonNum)
        }
    }
}