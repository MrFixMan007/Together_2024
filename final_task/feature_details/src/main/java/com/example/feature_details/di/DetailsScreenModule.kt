package com.example.feature_details.di

import com.example.common.domain.usecase.authenticated.GetCommunityNoteByIdUseCase
import com.example.feature_details.viewmodel.CommunityNoteViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DetailsScreenModule {

    @Provides
    @Singleton
    fun provideCommunityNoteViewModel(
        getCommunityNoteByIdUseCase: GetCommunityNoteByIdUseCase
    ): CommunityNoteViewModel {
        return CommunityNoteViewModel(
            getCommunityNoteByIdUseCase = getCommunityNoteByIdUseCase
        )
    }

}