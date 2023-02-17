package com.example.rickandmorty.domein.usecase

import com.example.rickandmorty.domein.repository.RickAndMortyRepository

class GetAllEpisodeUseCase(private val rickAndMortyRepository: RickAndMortyRepository) {
    fun getAllEpisode() = rickAndMortyRepository.getAllEpisode()
}