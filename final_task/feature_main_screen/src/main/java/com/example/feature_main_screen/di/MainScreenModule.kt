package com.example.feature_main_screen.di

import com.example.common.domain.usecase.authenticated.GetCourseByIdUseCase
import com.example.feature_main_screen.screen.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainScreenModule {

    @Provides
    @Singleton
    fun provideMainViewModel(getCourseByIdUseCase: GetCourseByIdUseCase): MainViewModel {
        return MainViewModel(getCourseByIdUseCase = getCourseByIdUseCase)
    }

}