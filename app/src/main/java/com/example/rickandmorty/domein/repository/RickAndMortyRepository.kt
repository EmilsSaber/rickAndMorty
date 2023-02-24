package com.example.rickandmorty.domein.repository

import androidx.paging.PagingData
import com.example.rickandmorty.domain.model.modelEpisode.Episode
import com.example.rickandmorty.domain.model.modelLocation.Location


import com.example.rickandmorty.domein.model.modelCharacters.Result

import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    fun getAllCharacters(name: String?): Flow<PagingData<Result>>
    fun getAllEpisode(name: String?): Flow<PagingData<Episode>>
    fun getAllLocation(name: String?): Flow<PagingData<Location>>

}