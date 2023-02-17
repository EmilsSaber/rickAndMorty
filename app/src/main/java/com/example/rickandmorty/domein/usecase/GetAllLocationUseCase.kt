package com.example.rickandmorty.domein.usecase

import com.example.rickandmorty.domein.repository.RickAndMortyRepository

class GetAllLocationUseCase(private val rickAndMortyRepository: RickAndMortyRepository) {

    fun getAllLocation() = rickAndMortyRepository.getAllLocation()

}