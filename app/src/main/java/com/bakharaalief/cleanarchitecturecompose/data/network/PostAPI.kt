package com.bakharaalief.cleanarchitecturecompose.data.network

import com.bakharaalief.cleanarchitecturecompose.data.network.dto.PostDto
import retrofit2.http.GET

interface PostAPI {
    @GET("/posts")
    suspend fun getPost() : List<PostDto>
}