package com.example.rickandmorty.presentation.utils

import android.app.Application
import com.example.rickandmorty.di.appModule
import com.example.rickandmorty.di.dataModule
import com.example.rickandmorty.di.domainModule
import com.example.rickandmorty.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule, networkModule))
        }
    }
}