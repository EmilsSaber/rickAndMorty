package com.example.rickandmorty.domein.usecase

import com.example.rickandmorty.domein.repository.RickAndMortyRepository

class GetAllLocationUseCase(private val rickAndMortyRepository: RickAndMortyRepository) {

    operator fun invoke(name: String?) = rickAndMortyRepository.getAllLocation(name)

}