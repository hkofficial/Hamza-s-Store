package com.hk.hamzasstore.home.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hk.hamzasstore.commons.utilities.OnCompleteListener
import com.hk.hamzasstore.home.Product
import com.hk.hamzasstore.home.domain.GetProductsUseCase
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {
    var products: ArrayList<Product> = ArrayList()

    fun getProducts(onCompleteListener: OnCompleteListener<ArrayList<Product>>) {
        val getProductsUseCase = GetProductsUseCase()
        viewModelScope.launch {
            val response = getProductsUseCase.executeUseCase()
            if (response.isSuccessful()) {
                response.data?.let {
                    products.clear()
                    products.addAll(it)
                    onCompleteListener.onSuccess(response.data)
                }
            } else
                onCompleteListener.onFailure(response.errType, response.message)
        }
    }
}