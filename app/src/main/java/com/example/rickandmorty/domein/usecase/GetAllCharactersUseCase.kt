package com.example.rickandmorty.domein.usecase

import com.example.rickandmorty.domein.repository.RickAndMortyRepository

class GetAllCharactersUseCase(private val rickAndMortyRepository: RickAndMortyRepository) {
    fun getAllCharacters() = rickAndMortyRepository.getAllCharacters()
}