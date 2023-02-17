package com.example.rickandmorty.presentation.fragment.characters

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmorty.domein.model.modelCharacters.DResult
import com.example.rickandmorty.domein.usecase.GetAllCharactersUseCase
import com.example.rickandmorty.domein.utils.UiState
import com.example.rickandmorty.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class CharactersViewModel(private val charactersUseCase: GetAllCharactersUseCase):BaseViewModel() {
    private val _getAllCharacters = MutableStateFlow<UiState<List<DResult>>>(UiState.Empty())
    val getAllCharacters = _getAllCharacters.asStateFlow()

        fun fetchFoo() = charactersUseCase.getAllCharacters().stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())
            .cachedIn(viewModelScope)


}