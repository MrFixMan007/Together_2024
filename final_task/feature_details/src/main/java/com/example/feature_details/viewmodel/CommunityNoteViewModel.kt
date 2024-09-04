package com.example.feature_details.viewmodel

import androidx.lifecycle.ViewModel
import com.example.common.domain.usecase.authenticated.GetCommunityNoteByIdUseCase
import com.example.feature_details.model.community_note.CommunityNoteAction
import com.example.feature_details.model.community_note.CommunityNoteSideNavigate
import com.example.feature_details.model.community_note.CommunityNoteState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class CommunityNoteViewModel @Inject constructor(
    private val getCommunityNoteByIdUseCase: GetCommunityNoteByIdUseCase
) : ContainerHost<CommunityNoteState, CommunityNoteSideNavigate>, ViewModel() {

    override val container = container<CommunityNoteState, CommunityNoteSideNavigate>(
        CommunityNoteState()
    )

    fun onAction(action: CommunityNoteAction) = intent {
        when (action) {
            is CommunityNoteAction.GetInfo -> {
                val response = getCommunityNoteByIdUseCase.execute(action.id)
                if (response != null) {
                    reduce {
                        state.copy(communityNote = response)
                    }
                }
            }
        }
    }

}