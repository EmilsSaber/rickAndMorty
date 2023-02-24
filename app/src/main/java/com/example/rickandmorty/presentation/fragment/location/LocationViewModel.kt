package com.example.rickandmorty.presentation.fragment.location

import com.example.rickandmorty.domein.usecase.GetAllLocationUseCase
import com.example.rickandmorty.presentation.base.BaseViewModel

class LocationViewModel(private val locationUseCase: GetAllLocationUseCase):BaseViewModel() {
    fun getLocationPaging(name:String= "") = locationUseCase(name).collectPagingRequest { it }

}