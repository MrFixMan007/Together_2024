package com.example.feature_details.model.community_note

sealed class CommunityNoteAction {
    data class GetInfo(val id: String) : CommunityNoteAction()
}