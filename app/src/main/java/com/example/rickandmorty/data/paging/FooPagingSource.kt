package com.example.rickandmorty.data.paging

import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domein.model.modelCharacters.DResult

class FooPagingSource(
    private val service: ApiService
) : BasePagingSource<com.example.rickandmorty.data.model.modelCharacters.Result, DResult>(
    {
        service.getAllMangaCharacters(it)
    }
)