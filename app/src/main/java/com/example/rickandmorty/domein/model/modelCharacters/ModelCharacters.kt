package com.example.rickandmorty.domein.model.modelCharacters

import com.example.rickandmorty.data.mapper.DataMapper
import com.example.rickandmorty.data.model.modelCharacters.InfoDto
import com.example.rickandmorty.data.model.modelCharacters.ModelCharactersDto
import com.example.rickandmorty.data.model.modelCharacters.ResultDto
import com.example.rickandmorty.data.model.modelCharacters.LocationDto
import com.example.rickandmorty.data.model.modelCharacters.OriginDto

data class ModelCharacters(
    val info: Info,
    val results: List<Result>
) : DataMapper<ModelCharactersDto> {
    override fun toDomain() = ModelCharactersDto(
        info.toDomain(),
        results.map { it.toDomain() }

    )
}

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
) : DataMapper<InfoDto> {
    override fun toDomain() = InfoDto(
        count, next, pages, prev
    )
}

data class Result(
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
) : DataMapper<ResultDto> {

    override fun toDomain() = ResultDto(
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
) : DataMapper<LocationDto> {
    override fun toDomain() = LocationDto(
        name, url
    )
}

data class Origin(
    val name: String,
    val url: String
) : DataMapper<OriginDto> {
    override fun toDomain() = OriginDto(
        name, url
    )
}