package com.hk.hamzasstore.product_detail.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hk.hamzasstore.commons.models.Product
import com.hk.hamzasstore.commons.utilities.OnCompleteListener
import com.hk.hamzasstore.commons.utilities.ResponseState
import com.hk.hamzasstore.product_detail.domain.GetProductByIdUseCase
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class ProductDetailViewModel : ViewModel() {
    private var mproduct: Product? = null
    fun getProductDetail(productId: Int, onCompleteListener: OnCompleteListener<Product>) {
        mproduct?.let {
            onCompleteListener.onSuccess(it)
            return
        }
        viewModelScope.launch {
            val requestValues = GetProductByIdUseCase.RequestValues(productId)
            val getProductByIdUseCase = GetProductByIdUseCase()
            val response = getProductByIdUseCase.executeUseCase(requestValues)
            if (response.isSuccessful()) {
                response.data?.let {
                    mproduct = it
                    onCompleteListener.onSuccess(mproduct)
                    return@launch
                }
                onCompleteListener.onFailure(
                    ResponseState.ErrorType.UNKNOWN_ERR,
                    "Unknown error occured"
                )
            } else {
                onCompleteListener.onFailure(response.errType, response.message)
            }
        }
    }

    fun cancelCalls(){
        viewModelScope.cancel()
    }
}