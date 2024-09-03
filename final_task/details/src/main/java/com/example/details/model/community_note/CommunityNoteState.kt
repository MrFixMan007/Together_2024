package com.example.details.model.community_note

import com.example.common.domain.model.authenticated.Author
import com.example.common.domain.model.authenticated.CommunityNote

data class CommunityNoteState(
    val communityNote: CommunityNote = CommunityNote(
        id = "",
        title = "",
        date = "",
        author = Author(
            id = "",
            name = "",
            surname = "",
            avatarUrl = "",
        ),
        text = listOf(),
        comments = listOf()
    )
)