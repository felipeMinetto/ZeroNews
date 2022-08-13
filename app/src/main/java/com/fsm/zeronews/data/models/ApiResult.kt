package com.fsm.zeronews.data.models

sealed class ApiResult<out T> {
    data class Success<out R>(val result: R) : ApiResult<R>()
    data class Error(val exception: Exception) : ApiResult<Nothing>()
}
