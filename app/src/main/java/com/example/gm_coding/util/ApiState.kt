package com.example.gm_coding.util

sealed class ApiState<out R> {
    data class Success<out R>(val tracks: R) : ApiState<R>()
    data class Error(val msg: String) : ApiState<Nothing>()
    object Loading : ApiState<Nothing>()
    object Completed : ApiState<Nothing>()
}
