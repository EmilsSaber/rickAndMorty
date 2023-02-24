package com.example.rickandmorty.domein.usecase

import com.example.rickandmorty.domein.repository.RickAndMortyRepository


class GetAllEpisodeUseCase(private val rickAndMortyRepository: RickAndMortyRepository) {
    operator fun invoke(name: String?) = rickAndMortyRepository.getAllEpisode(name)
}