package com.example.catmemegenerator

sealed class Resource<out T: Any> {
    data class Success<out T : Any>(val data : T) : Resource<T>()
    data class Error(val error : Exception?, val errorMsg : String) : Resource<Nothing>()
    object Loading : Resource<Nothing>()
}