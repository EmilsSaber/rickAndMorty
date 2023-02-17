package com.example.rickandmorty.domein.model.modelEpisode

import com.example.rickandmorty.data.model.modelEpisode.Info
import com.example.rickandmorty.data.model.modelEpisode.Result

data class DModelEpisode(
    val info: Info,
    val results: List<Result>
)

data class DInfo(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class DResult(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)