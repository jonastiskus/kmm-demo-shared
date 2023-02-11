package com.jonas.tiskus.kmm.demo.shared.data

sealed class NetworkResult<out T> {
    object Loading: NetworkResult<Nothing>()
    data class Success<T>(val data: T): NetworkResult<T>()
    data class Error(val throwable: Throwable?) : NetworkResult<Nothing>()
}
