package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.database.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(test: NoteEntity)

    @Query("select * from ${NoteEntity.NOTE_TABLE}")
    fun getNotesFlow(): Flow<List<NoteEntity>>

    @Query("select * from ${NoteEntity.NOTE_TABLE} order by date desc limit 1")
    suspend fun getLastNote(): NoteEntity?
}