package com.example.rickandmorty.data.paging

import com.example.rickandmorty.data.base.BasePagingSource
import com.example.rickandmorty.data.model.modelEpisode.EpisodeDto
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domain.model.modelEpisode.Episode

class EpisodePagingSource(private val apiService: ApiService,name:String?):
    BasePagingSource<EpisodeDto, Episode>({
    apiService.getAllEpisode(it,name)
})
