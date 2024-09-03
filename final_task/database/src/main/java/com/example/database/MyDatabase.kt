package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.NoteDao
import com.example.database.entity.NoteEntity

@Database(
    entities = [
        NoteEntity::class,
    ],
    version = MyDatabase.DATABASE_VERSION
)
abstract class MyDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "database"
    }

    abstract fun noteDao(): NoteDao
}