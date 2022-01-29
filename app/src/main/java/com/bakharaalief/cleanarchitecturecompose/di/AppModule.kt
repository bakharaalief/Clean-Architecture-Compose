package com.bakharaalief.cleanarchitecturecompose.di

import com.bakharaalief.cleanarchitecturecompose.data.network.PostAPI
import com.bakharaalief.cleanarchitecturecompose.domain.repository.PostRepository
import com.bakharaalief.cleanarchitecturecompose.data.repository.PostRepositoryImpl
import com.bakharaalief.cleanarchitecturecompose.domain.use_case.get_post.GetPostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://jsonplaceholder.typicode.com"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApi(): PostAPI = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PostAPI::class.java)

    @Singleton
    @Provides
    fun provideMainRepository(api: PostAPI) : PostRepository =
        PostRepositoryImpl(api)

    @Singleton
    @Provides
    fun provideUseCase(postRepository: PostRepository) : GetPostUseCase =
        GetPostUseCase(postRepository)
}