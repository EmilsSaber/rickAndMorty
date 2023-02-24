package com.example.rickandmorty.data.model.modelLocation

import com.example.rickandmorty.data.mapper.DataMapper
import com.example.rickandmorty.domain.model.modelLocation.Location

data class ModelLocation(
    val info: Info,
    val results: List<LocationDto>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)


data class LocationDto(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
):DataMapper<Location> {
    override fun toDomain()=  Location(
        created, dimension, id, name, residents, type, url
    )
}