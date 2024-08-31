package com.example.feature_home_screen.di

import com.example.common.domain.usecase.authenticated.GetAllCoursesUseCase
import com.example.common.domain.usecase.authenticated.GetLastCommunityNoteUseCase
import com.example.feature_home_screen.screen.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HomeScreenModule {

    @Provides
    @Singleton
    fun provideMainViewModel(
        getAllCourses: GetAllCoursesUseCase,
        getLastCommunityNote: GetLastCommunityNoteUseCase
    ): HomeViewModel {
        return HomeViewModel(
            getAllCourses = getAllCourses,
            getLastCommunityNote = getLastCommunityNote
        )
    }

}