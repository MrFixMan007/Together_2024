package com.example.profsoft_2024_task4_retrofit_hilt.domain.di

import com.example.profsoft_2024_task4_retrofit_hilt.data.repository.IWeatherRepository
import com.example.profsoft_2024_task4_retrofit_hilt.domain.usecase.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Provides
    @Singleton
    fun provideGetWeatherUseCase(weatherRepository: IWeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(weatherRepository = weatherRepository)
    }

}