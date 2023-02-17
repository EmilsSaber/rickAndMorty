package com.example.rickandmorty.data.repository

import androidx.paging.PagingData
import com.example.rickandmorty.data.paging.BaseRepository
import com.example.rickandmorty.data.paging.FooPagingSource
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domein.model.modelCharacters.DModelCharacters
import com.example.rickandmorty.domein.model.modelCharacters.DResult
import com.example.rickandmorty.domein.repository.RickAndMortyRepository
import com.example.rickandmorty.domein.utils.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class RIckAndMortyRepositoryImpl(private val apiService: ApiService): RickAndMortyRepository,BaseRepository() {
    override fun getAllCharacters()  : Flow<PagingData<DResult>>  {
        return doPagingRequest(FooPagingSource(apiService))
    }


    override fun getAllEpisode() {
        return Unit
    }

    override fun getAllLocation() {
        return Unit
    }
}