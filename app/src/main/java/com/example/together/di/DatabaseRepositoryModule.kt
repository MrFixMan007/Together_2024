package com.example.together.di

import com.example.common.data.DatabaseRepository
import com.example.database.MyDatabase
import com.example.database.repository.DatabaseRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseRepositoryModule {

    @Singleton
    @Provides
    fun provideDatabaseRepository(myDatabase: MyDatabase): DatabaseRepository {
        return DatabaseRepositoryImpl(database = myDatabase)
    }
}