package com.example.together.di

import android.content.Context
import com.example.database.MyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import androidx.room.Room

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): MyDatabase {
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            MyDatabase.DATABASE_NAME
        ).build()
    }
}