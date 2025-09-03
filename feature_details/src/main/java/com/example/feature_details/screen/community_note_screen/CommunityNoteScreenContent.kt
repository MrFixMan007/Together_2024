package com.example.feature_details.screen.community_note_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.common.domain.model.authenticated.Text
import com.example.feature_details.model.community_note.CommunityNoteAction
import com.example.feature_details.model.community_note.CommunityNoteState

@Composable
fun CommunityNoteScreenContent(
    state: CommunityNoteState,
    stack: State<NavBackStackEntry?>,
    id: String,
    onAction: (CommunityNoteAction) -> Unit
) {

    LaunchedEffect(stack.value?.destination?.route) {
        if (id.isNotEmpty()) {
            onAction(CommunityNoteAction.GetInfo(id))
        }
    }

    LazyColumn {
        itemsIndexed(items = state.communityNote.text) { _, item ->
            ListItemView(item = item)
        }
    }
}

@Composable
fun ListItemView(item: Text) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 28.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = item.text ?: "", color = Color.Black, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp)
        )

        if (item.imageUrl != null) {
            Image(
                painter = rememberAsyncImagePainter(model = item.imageUrl),
                modifier = Modifier
                    .size(200.dp),
                contentDescription = "Picture",
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
@Preview
private fun Preview() {
    val fakeOnAction: (CommunityNoteAction) -> Unit = {}
    val state = CommunityNoteState()
    CommunityNoteScreenContent(
        state = state.copy(
            communityNote = state.communityNote.copy(
                text = listOf(
                    Text("test", ""),
                    Text("and test", ""),
                    Text("and more test", ""),
                ),
            )
        ), stack = rememberNavController().currentBackStackEntryAsState(),
        onAction = fakeOnAction,
        id = ""
    )
}