package com.example.rickandmorty.domein.repository

import androidx.paging.PagingData
import com.example.rickandmorty.domein.model.modelCharacters.DModelCharacters
import com.example.rickandmorty.domein.model.modelCharacters.DResult
import com.example.rickandmorty.domein.utils.Resourse
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {

   fun getAllCharacters(): Flow<PagingData<DResult>>
   fun getAllEpisode()
   fun getAllLocation()

}