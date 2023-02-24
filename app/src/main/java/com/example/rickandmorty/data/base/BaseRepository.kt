package com.example.rickandmorty.data.base

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.rickandmorty.data.mapper.DataMapper

import com.example.rickandmorty.domein.utils.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository() {
    protected  fun <T>  doReguest(reguest:suspend () -> T) = flow{
        emit(Resourse.Loading())
        try {
            val data =  reguest()
            emit(Resourse.Success(data))
        }catch (ioExaption: IOException){
            emit(Resourse.Error(ioExaption.localizedMessage ?: "hj"))
        }

    }.flowOn(Dispatchers.IO)
    internal fun <ValueDto : DataMapper<Value>, Value : Any> doPagingRequest(
        pagingSource: BasePagingSource<ValueDto, Value>,
        pageSize: Int = 10,
        prefetchDistance: Int = pageSize,
        enablePlaceholders: Boolean = true,
        initialLoadSize: Int = pageSize * 3,
        maxSize: Int = Int.MAX_VALUE,
        jumpThreshold: Int = Int.MIN_VALUE
    ) = Pager(
        config = PagingConfig(
            pageSize,
            prefetchDistance,
            enablePlaceholders,
            initialLoadSize,
            maxSize,
            jumpThreshold
        ),
        pagingSourceFactory = {
            pagingSource
        }
    ).flow
}

