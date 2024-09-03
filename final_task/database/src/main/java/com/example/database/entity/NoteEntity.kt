package com.example.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date

@Entity(tableName = NoteEntity.NOTE_TABLE)
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "date") val date: String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date()),
    @ColumnInfo(name = "description") val description: String,
) {
    companion object {
        const val NOTE_TABLE = "note"
    }
}