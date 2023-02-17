package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.model.modelCharacters.ModelCharacters
import com.example.rickandmorty.data.model.modelCharacters.Result
import com.example.rickandmorty.data.model.modelEpisode.ModelEpisode
import com.example.rickandmorty.data.model.modelLocation.ModelLocation
import com.example.rickandmorty.data.paging.BasePagingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService {
    @GET("character")
    suspend fun getAllMangaCharacters(
@Query("page") page:Int
    ): BasePagingResponse<Result>

    @GET("/episode")
    suspend fun getAllMangaEpisode(
    ): List<ModelEpisode>

    @GET("/location")
    suspend fun getAllMangaLocation(
    ): List<ModelLocation>
}


