package com.example.rickandmorty.data.paging

import com.example.rickandmorty.data.base.BasePagingSource
import com.example.rickandmorty.data.model.modelLocation.LocationDto
import com.example.rickandmorty.data.remote.ApiService
import com.example.rickandmorty.domain.model.modelLocation.Location

class LocationPagingSource(
    private val service: ApiService,
    name:String?
) : BasePagingSource<LocationDto, Location>({
    service.getAllLocation(it,name)
})
