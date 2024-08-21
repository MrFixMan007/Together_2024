package com.example.profsoft_2024_final_task.presentation.di

import com.example.profsoft_2024_final_task.domain.usecase.AuthorizeUserUseCase
import com.example.profsoft_2024_final_task.domain.usecase.RegisterUserUseCase
import com.example.profsoft_2024_final_task.presentation.authorization_screen.viewmodel.AuthorizationViewModel
import com.example.profsoft_2024_final_task.presentation.registration_screen.viewmodel.RegistrationViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    @Singleton
    fun provideRegistrationViewModel(registerUserUseCase: RegisterUserUseCase): RegistrationViewModel{
        return RegistrationViewModel(registerUseCase = registerUserUseCase)
    }

    @Provides
    @Singleton
    fun provideAuthorizationViewModel(authorizeUserUseCase: AuthorizeUserUseCase): AuthorizationViewModel{
        return AuthorizationViewModel(authorizeUserUseCase = authorizeUserUseCase)
    }

}