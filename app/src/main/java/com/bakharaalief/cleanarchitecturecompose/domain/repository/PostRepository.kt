package com.bakharaalief.cleanarchitecturecompose.domain.repository

import com.bakharaalief.cleanarchitecturecompose.data.network.dto.PostDto

interface PostRepository {
    suspend fun listPost(): List<PostDto>
}