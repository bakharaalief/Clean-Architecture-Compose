package com.bakharaalief.cleanarchitecturecompose.domain.use_case.get_post

import com.bakharaalief.cleanarchitecturecompose.core.util.Resource
import com.bakharaalief.cleanarchitecturecompose.domain.model.Post
import com.bakharaalief.cleanarchitecturecompose.domain.repository.PostRepository
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPostUseCase
    @Inject constructor(private val postRepository: PostRepository) {

    operator fun invoke() = flow {
        try {
            emit(Resource.Loading<List<Post>>())
            val post = postRepository.listPost().map { it.toPost() }
            emit(Resource.Success<List<Post>>(post))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Post>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Post>>("Couldn't reach server. Check your internet connection."))
        }
    }
}