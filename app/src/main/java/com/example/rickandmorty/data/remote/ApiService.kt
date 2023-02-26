package com.example.rickandmorty.data.remote

import com.example.rickandmorty.data.base.BasePagingResponse
import com.example.rickandmorty.data.model.modelCharacters.ResultDto
import com.example.rickandmorty.data.model.modelEpisode.EpisodeDto
import com.example.rickandmorty.data.model.modelLocation.LocationDto
import retrofit2.http.GET
import retrofit2.http.Query

interface  ApiService {
    @GET("character")
    suspend fun getAllMangaCharacters(
        @Query("page") page:Int,
        @Query("name") name:String?,

    ): BasePagingResponse<ResultDto>

    @GET("episode")
    suspend fun getAllEpisode(
        @Query("page") page: Int,
        @Query("name") name:String?
    ): BasePagingResponse<EpisodeDto>

    @GET("location")
    suspend fun getAllLocation(
        @Query("page") page: Int,
        @Query("name") name:String?
    ): BasePagingResponse<LocationDto>

}


