package com.example.rickandmorty.data.model.modelCharacters

import com.example.rickandmorty.data.mapper.DataMapper
import com.example.rickandmorty.domein.model.modelCharacters.*
import com.example.rickandmorty.domein.model.modelCharacters.Location
import com.example.rickandmorty.domein.model.modelCharacters.Origin

data class ModelCharacters(
    val info: Info,
    val results: List<Result>
):DataMapper<DModelCharacters> {
    override fun toDomain()= DModelCharacters (
        info.toDomain(),
        results.map { it.toDomain() }
            )
}

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
):DataMapper<DInfo> {
    override fun toDomain()= DInfo(
        count,
        next, pages, prev
    )
}

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: com.example.rickandmorty.data.model.modelCharacters.Location,
    val name: String,
    val origin: com.example.rickandmorty.data.model.modelCharacters.Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
):DataMapper<DResult> {
    override fun toDomain()= DResult (
        created,
        episode,
        gender,
        id,
        image,
        location.toDomain(),
        name,
        origin.toDomain(),
        species,
        status,
        type,
        url
            )
}

data class Location(
    val name: String,
    val url: String
):DataMapper<Location> {
    override fun toDomain()= Location (
        name,url
            )
}

data class Origin(
    val name: String,
    val url: String
):DataMapper<Origin> {
    override fun toDomain()= Origin(
        name,url
    )
}