package com.bakharaalief.cleanarchitecturecompose.data.network.dto

import com.bakharaalief.cleanarchitecturecompose.domain.model.Post
import com.google.gson.annotations.SerializedName

data class PostDto(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
){
	fun toPost() : Post {
		return Post(
			id = id,
			title = title,
			body = body,
			userId = userId
		)
	}
}

