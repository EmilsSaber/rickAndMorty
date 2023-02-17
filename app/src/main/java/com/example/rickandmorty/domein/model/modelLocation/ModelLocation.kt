package com.example.rickandmorty.domein.model.modelLocation
import com.example.rickandmorty.data.model.modelLocation.Info
import com.example.rickandmorty.data.model.modelLocation.Result

data class DModelLocation(
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
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)