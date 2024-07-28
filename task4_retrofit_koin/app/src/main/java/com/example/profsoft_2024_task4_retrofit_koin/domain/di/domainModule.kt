package com.example.profsoft_2024_task4_retrofit_koin.domain.di

import com.example.profsoft_2024_task4_retrofit_koin.domain.usecase.GetWeatherUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val domainModule = module {

    single((named("CITY_ID"))) {
        498677
    }

    single<GetWeatherUseCase> {
        GetWeatherUseCase(get())
    }
}