package com.example.rickandmorty.di

import com.example.rickandmorty.presentation.fragment.AllViewModel
import com.example.rickandmorty.presentation.fragment.characters.CharactersViewModel
import com.example.rickandmorty.presentation.fragment.episode.EpisodeViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        CharactersViewModel(get())
    }
    viewModel {
        EpisodeViewModel(get())
    }
    viewModel {
        AllViewModel(get(), get(), get())
    }


}