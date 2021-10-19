package com.hk.hamzasstore.commons.utilities

import androidx.annotation.NonNull

class ResponseState<T> private constructor(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val errType: ErrorType? = null
) {

    enum class Status {
        SUCCESS, ERROR
    }

    enum class ErrorType {
        NO_INTERNET, NO_DATA, CUSTOM_ERR, UNKNOWN_ERR
    }

    fun isSuccessful(): Boolean {
        return status == Status.SUCCESS
    }

    companion object {
        @JvmStatic
        fun <T> success(@NonNull data: T?): ResponseState<T> {
            return ResponseState(status = Status.SUCCESS, data = data)
        }

        @JvmStatic
        fun <T> error(
            msg: String? = "",
            errType: ErrorType?
        ): ResponseState<T> {
            return ResponseState(status = Status.ERROR, message = msg, errType = errType)
        }
    }
}