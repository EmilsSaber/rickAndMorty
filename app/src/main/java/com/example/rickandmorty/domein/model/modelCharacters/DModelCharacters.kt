package com.example.rickandmorty.domein.model.modelCharacters

import com.example.rickandmorty.data.mapper.DataMapper
import com.example.rickandmorty.data.model.modelCharacters.Info
import com.example.rickandmorty.data.model.modelCharacters.ModelCharacters
import com.example.rickandmorty.data.model.modelCharacters.Result

data class DModelCharacters(
    val info: DInfo,
    val results: List<DResult>
):DataMapper<ModelCharacters> {
    override fun toDomain()=ModelCharacters (
        info.toDomain(),
        results.map { it.toDomain() }

        )
}

data class DInfo(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
):DataMapper<Info> {
    override fun toDomain() =Info(
        count, next, pages, prev
    )
}

data class DResult(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
):DataMapper<com.example.rickandmorty.data.model.modelCharacters.Result> {
    override fun toDomain()= Result(
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
):DataMapper<com.example.rickandmorty.data.model.modelCharacters.Location> {
    override fun toDomain()= com.example.rickandmorty.data.model.modelCharacters.Location (
        name, url
            )
}

data class Origin(
    val name: String,
    val url: String
):DataMapper<com.example.rickandmorty.data.model.modelCharacters.Origin> {
    override fun toDomain()= com.example.rickandmorty.data.model.modelCharacters.Origin(
        name, url
    )
}