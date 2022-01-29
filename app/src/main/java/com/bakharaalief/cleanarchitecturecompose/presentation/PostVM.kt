package com.bakharaalief.cleanarchitecturecompose.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bakharaalief.cleanarchitecturecompose.core.util.Resource
import com.bakharaalief.cleanarchitecturecompose.domain.use_case.get_post.GetPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PostVM
    @Inject constructor(private val getPostUseCase: GetPostUseCase): ViewModel() {

    private val _state = mutableStateOf(PostState())
    val state : State<PostState> = _state

    init {
        getData()
    }

    private fun getData(){

        getPostUseCase().onEach {
            when(it){
                is Resource.Success -> _state.value = PostState(post = it.data ?: emptyList())
                is Resource.Error -> _state.value = PostState(error = it.message ?: "Error")
                is Resource.Loading ->  _state.value = PostState(isLoading = true)
                else -> Unit
            }
        }.launchIn(viewModelScope)
    }
}