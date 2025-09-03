package com.example.feature_login.di

import com.example.common.domain.usecase.unauthenticated.AuthorizeUserUseCase
import com.example.common.domain.usecase.unauthenticated.RegisterUserUseCase
import com.example.feature_login.screens.authorization_screen.viewmodel.AuthorizationViewModel
import com.example.feature_login.screens.registration_screen.viewmodel.RegistrationViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoginModule {
    @Provides
    @Singleton
    fun provideRegistrationViewModel(registerUserUseCase: RegisterUserUseCase): RegistrationViewModel {
        return RegistrationViewModel(registerUseCase = registerUserUseCase)
    }

    @Provides
    @Singleton
    fun provideAuthorizationViewModel(authorizeUserUseCase: AuthorizeUserUseCase): AuthorizationViewModel {
        return AuthorizationViewModel(authorizeUserUseCase = authorizeUserUseCase)
    }
}