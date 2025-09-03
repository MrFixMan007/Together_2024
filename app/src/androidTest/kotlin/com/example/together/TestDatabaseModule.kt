package com.example.together

import android.content.Context
import androidx.room.Room
import com.example.database.MyDatabase
import com.example.together.di.DatabaseModule
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DatabaseModule::class]
)
class TestDatabaseModule{
    @Singleton
    @Provides
    fun provideInMemoryDb(
        @ApplicationContext context: Context,
    ): MyDatabase {
        return Room.inMemoryDatabaseBuilder(
            context,
            MyDatabase::class.java
        ).allowMainThreadQueries().build()
    }
}