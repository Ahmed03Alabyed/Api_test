package com.example.api_test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen


class ScreenOne() : Screen {

    @Composable
    override fun Content() {
        ScreenOneContent()
    }

}

@Composable
fun ScreenOneContent() {
    val postsViewModel: PostsViewModel = viewModel()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            if (postsViewModel.postsList.isEmpty()) {
                CircularProgressIndicator()
            }
        }
        items(postsViewModel.postsList) { post ->
            PostItem(
                modifier = Modifier.fillMaxWidth(),
                completed =post.completed,
                id = post.id,
                title = post.title,
                userId = post.userId
            )
        }
    }
}

@Composable
fun PostItem(modifier: Modifier = Modifier,completed: Boolean, id: Int, title: String, userId: Int) {
    Card(modifier = Modifier) {
        Column(modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(completed.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(id.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(userId.toString(), fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
private fun PostItemPreview() {
    PostItem(completed = true ,title = "title", id = 0 , userId = 0)
}