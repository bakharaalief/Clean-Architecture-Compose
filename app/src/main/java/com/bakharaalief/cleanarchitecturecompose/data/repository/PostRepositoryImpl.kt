package com.bakharaalief.cleanarchitecturecompose.data.repository

import com.bakharaalief.cleanarchitecturecompose.data.network.dto.PostDto
import com.bakharaalief.cleanarchitecturecompose.data.network.PostAPI
import com.bakharaalief.cleanarchitecturecompose.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl
    @Inject constructor(private val api : PostAPI) : PostRepository {

    override suspend fun listPost(): List<PostDto> {
        return api.getPost()
    }
}