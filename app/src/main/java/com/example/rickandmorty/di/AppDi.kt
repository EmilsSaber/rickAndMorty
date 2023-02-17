package com.example.rickandmorty.di

import com.example.rickandmorty.presentation.fragment.characters.CharactersViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        CharactersViewModel(get())
    }
}