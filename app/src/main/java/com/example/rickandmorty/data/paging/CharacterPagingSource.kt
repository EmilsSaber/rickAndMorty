package com.example.rickandmorty.data.paging

import com.example.rickandmorty.data.base.BasePagingSource
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domein.model.modelCharacters.Result
import com.example.rickandmorty.data.model.modelCharacters.ResultDto

class CharacterPagingSource(
    private val service: ApiService,
    name:String?
) : BasePagingSource<ResultDto, Result>(
    {
        service.getAllMangaCharacters(it,name)
    }
)
