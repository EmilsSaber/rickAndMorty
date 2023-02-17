package com.example.rickandmorty.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.rickandmorty.domein.utils.Resourse
import com.example.rickandmorty.domein.utils.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

abstract class BaseViewModel:ViewModel() {
    protected fun <T> Flow<Resourse<T>>.collectFlow(_state:MutableStateFlow<UiState<T>>){
        viewModelScope.launch(Dispatchers.IO) {
            this@collectFlow.collect{result->
                when(result){
                    is Resourse.Loading -> {
                        _state.value = UiState.Loading()
                    }
                    is Resourse.Success -> {
                        if (result.data != null) {
                            _state.value = UiState.Success(result.data)
                        }
                    }
                    is Resourse.Error -> {
                        _state.value = UiState.Error(result.message!!)
                    }
                }
                }
            }
    }
    protected fun <T : Any, S : Any> Flow<PagingData<T>>.collectPagingRequest(
        mappedData: (T) -> S
    ) = map { it.map { data -> mappedData(data) } }.cachedIn(viewModelScope)
}