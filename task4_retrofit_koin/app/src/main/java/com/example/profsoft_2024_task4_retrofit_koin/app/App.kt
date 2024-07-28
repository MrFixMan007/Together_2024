package com.example.profsoft_2024_task4_retrofit_koin.app

import android.app.Application
import com.example.profsoft_2024_task4_retrofit_koin.data.di.dataModule
import com.example.profsoft_2024_task4_retrofit_koin.domain.di.domainModule
import com.example.profsoft_2024_task4_retrofit_koin.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataModule, domainModule, presentationModule)
        }
    }
}