package com.example.rickandmorty.data.repository

import androidx.paging.PagingData
import com.example.rickandmorty.data.base.BaseRepository
import com.example.rickandmorty.data.paging.CharacterPagingSource
import com.example.rickandmorty.data.paging.EpisodePagingSource
import com.example.rickandmorty.data.paging.LocationPagingSource
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domain.model.modelEpisode.Episode
import com.example.rickandmorty.domain.model.modelLocation.Location
import com.example.rickandmorty.domein.model.modelCharacters.Result
import com.example.rickandmorty.domein.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow

class RIckAndMortyRepositoryImpl(private val apiService: ApiService): RickAndMortyRepository,
    BaseRepository() {
    override fun getAllCharacters(name: String?): Flow<PagingData<Result>> {
        return doPagingRequest(CharacterPagingSource(apiService, name))
    }

    override fun getAllEpisode(name: String?): Flow<PagingData<Episode>> {
        return doPagingRequest(EpisodePagingSource(apiService,name))
    }

    override fun getAllLocation(name: String?): Flow<PagingData<Location>> {
        return doPagingRequest(LocationPagingSource(apiService,name))
    }


}