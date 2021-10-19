package com.hk.hamzasstore.product_detail.domain

import com.hk.hamzasstore.commons.models.Product
import com.hk.hamzasstore.commons.utilities.ResponseState
import com.hk.hamzasstore.commons.utilities.UseCase
import com.hk.hamzasstore.home.source.ProductsRepository

class GetProductByIdUseCase :
    UseCase<GetProductByIdUseCase.RequestValues, ResponseState<Product>>() {
    class RequestValues(val productId: Int) : UseCase.RequestValues

    override suspend fun executeUseCase(requestValues: RequestValues?): ResponseState<Product> {
        requestValues?.let {
            val repository = ProductsRepository()
            return repository.getProductById(it.productId)
        }
        return ResponseState.error("Unknown error occurred", ResponseState.ErrorType.UNKNOWN_ERR)
    }

}