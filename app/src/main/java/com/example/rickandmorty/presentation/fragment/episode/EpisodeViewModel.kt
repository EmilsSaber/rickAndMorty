package com.example.rickandmorty.presentation.fragment.episode


import com.example.rickandmorty.domein.usecase.GetAllEpisodeUseCase
import com.example.rickandmorty.presentation.base.BaseViewModel

class EpisodeViewModel(private val episodeUseCase: GetAllEpisodeUseCase):BaseViewModel() {
    fun getEpisodePaging(name: String = "") = episodeUseCase(name).collectPagingRequest { it }

}