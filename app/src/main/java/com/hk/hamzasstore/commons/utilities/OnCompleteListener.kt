package com.hk.hamzasstore.commons.utilities

interface OnCompleteListener<T> {
    fun onSuccess(response: T?)
    fun onFailure(errorType: ResponseState.ErrorType?, errorMessage: String?)
}