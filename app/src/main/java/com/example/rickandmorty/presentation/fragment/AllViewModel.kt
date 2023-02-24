package com.example.rickandmorty.presentation.fragment

import com.example.rickandmorty.domein.usecase.GetAllCharactersUseCase
import com.example.rickandmorty.domein.usecase.GetAllEpisodeUseCase
import com.example.rickandmorty.domein.usecase.GetAllLocationUseCase
import com.example.rickandmorty.presentation.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AllViewModel(private val episodeUseCase: GetAllEpisodeUseCase, private val charactersUseCase: GetAllCharactersUseCase, private val locationUseCase: GetAllLocationUseCase): BaseViewModel() {

    private val _getSearch = MutableStateFlow<String?>(null)
    private val _getSearch2 = MutableStateFlow<String?>(null)
    private val _getSearch3 = MutableStateFlow<String?>(null)
    val getSearch = _getSearch.asStateFlow()
    val getSearch2 = _getSearch2.asStateFlow()
    val getSearch3 = _getSearch3.asStateFlow()

     fun getCharactersPaging() = charactersUseCase(_getSearch.value).collectPagingRequest { it }
    fun getEpisodePAging() = episodeUseCase(_getSearch.value).collectPagingRequest { it }
    fun getLocationPAging() = locationUseCase(_getSearch.value).collectPagingRequest { it }



    fun searchResults(name: String = "", name2: String, name3: String){
        _getSearch.value  = name
        _getSearch2.value  = name2
        _getSearch3.value  = name3

    }

}