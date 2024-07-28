package com.example.profsoft_2024_task4_retrofit_koin.presentation.di

import com.example.profsoft_2024_task4_retrofit_koin.presentation.viewmodel.NetworkViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val presentationModule = module {
    single<NetworkViewModel> {
        NetworkViewModel(get(), get(named("CITY_ID")))
    }
}