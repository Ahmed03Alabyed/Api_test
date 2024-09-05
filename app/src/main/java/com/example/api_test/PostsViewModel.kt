package com.example.api_test

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.Provider
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.launch



class PostsViewModel : ViewModel() {

    val client = Provider.client

    var postsList by mutableStateOf(emptyList<TODOItem>())
        private set

    init {
        viewModelScope.launch {
            postsList = client.get("https://jsonplaceholder.typicode.com/todos").body<List<TODOItem>>()
        }
    }

}