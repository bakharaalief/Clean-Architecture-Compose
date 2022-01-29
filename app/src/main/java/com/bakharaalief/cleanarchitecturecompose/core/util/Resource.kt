package com.bakharaalief.cleanarchitecturecompose.core.util

sealed class Resource<T>(val message : String?, val data: T?){
    class Success<T>(data: T) : Resource<T>(null, data)
    class Error<T>(message: String) : Resource<T>(message, null)
    class Loading<T>() : Resource<T>(null, null)
}
