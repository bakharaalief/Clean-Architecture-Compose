package com.bakharaalief.cleanarchitecturecompose.presentation

import com.bakharaalief.cleanarchitecturecompose.domain.model.Post

data class PostState(
    val isLoading: Boolean = false,
    val post: List<Post> = emptyList(),
    val error: String = ""
)
