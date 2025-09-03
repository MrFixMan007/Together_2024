package com.example.network.api

import com.example.network.dto.authenticated.note.NoteResponse
import com.example.network.dto.authenticated.note.NotesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface NoteApiService {

    @GET("/api/community_notes/{noteId}")
    suspend fun getNoteById(@Path("noteId") noteId: String): NoteResponse?

    @GET("/api/community_notes")
    suspend fun getNotes(): NotesResponse?

}