package com.example.rickandmorty.di

import com.example.rickandmorty.data.repository.RIckAndMortyRepositoryImpl
import com.example.rickandmorty.domein.repository.RickAndMortyRepository
import org.koin.dsl.module

val dataModule = module {

    single <RickAndMortyRepository>{
        RIckAndMortyRepositoryImpl(get())
    }

}