package com.example.feature_main_screen.di

import com.example.common.domain.usecase.authenticated.GetAllCoursesUseCase
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
    fun provideMainViewModel(getAllCourses: GetAllCoursesUseCase): MainViewModel {
        return MainViewModel(getAllCourses = getAllCourses)
    }

}