package com.example.profsoft_2024_final_task.app.di

import com.example.common.data.ApiRepository
import com.example.common.domain.usecase.AuthorizeUserUseCase
import com.example.common.domain.usecase.RegisterUserUseCase
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
    fun provideRegisterUserUseCase(apiRepository: ApiRepository): RegisterUserUseCase {
        return RegisterUserUseCase(apiRepository = apiRepository)
    }

    @Provides
    @Singleton
    fun provideAuthorizeUserUseCase(apiRepository: ApiRepository): AuthorizeUserUseCase {
        return AuthorizeUserUseCase(apiRepository = apiRepository)
    }

}