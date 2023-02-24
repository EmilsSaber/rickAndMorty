package com.example.rickandmorty.presentation.fragment.characters


import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.rickandmorty.data.repository.RIckAndMortyRepositoryImpl
import com.example.rickandmorty.domein.model.modelCharacters.Result
import com.example.rickandmorty.domein.usecase.GetAllCharactersUseCase
import com.example.rickandmorty.domein.utils.UiState
import com.example.rickandmorty.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow

import kotlinx.coroutines.flow.asStateFlow


class CharactersViewModel(private val charactersUseCase: GetAllCharactersUseCase):BaseViewModel() {


fun getCharacterPaging(name: String = "") = charactersUseCase(name).collectPagingRequest { it }

}