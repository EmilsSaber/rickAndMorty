package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.model.modelCharacters.ModelCharacters
import com.example.rickandmorty.data.model.modelEpisode.ModelEpisode
import com.example.rickandmorty.data.model.modelLocation.ModelLocation
import retrofit2.http.GET

interface  ApiService {
    @GET("/character")
    suspend fun getAllMangaCharacters(
    ): List<ModelCharacters>

    @GET("/episode")
    suspend fun getAllMangaEpisode(
    ): List<ModelEpisode>

    @GET("/location")
    suspend fun getAllMangaLocation(
    ): List<ModelLocation>
}


