package com.example.rickandmorty.di

import com.example.rickandmorty.domein.usecase.GetAllCharactersUseCase
import com.example.rickandmorty.domein.usecase.GetAllEpisodeUseCase
import com.example.rickandmorty.domein.usecase.GetAllLocationUseCase
import org.koin.dsl.module

val domainModule = module {
    factory {
        GetAllCharactersUseCase(rickAndMortyRepository = get())
    }
    factory {
        GetAllEpisodeUseCase(rickAndMortyRepository = get())
    }

    factory {
        GetAllLocationUseCase(get())
    }
    /*factory {
        val postRepository: MangaRepository =
            MangaRepositoryImpl(get())
        postRepository
    }*/
}