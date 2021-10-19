package com.hk.hamzasstore.home.domain

import com.hk.hamzasstore.commons.utilities.ResponseState
import com.hk.hamzasstore.commons.utilities.UseCase
import com.hk.hamzasstore.home.Product
import com.hk.hamzasstore.home.source.ProductsRepository

class GetProductsUseCase :
    UseCase<GetProductsUseCase.RequestValues, ResponseState<ArrayList<Product>>>() {
    class RequestValues : UseCase.RequestValues

    override suspend fun executeUseCase(requestValues: RequestValues?): ResponseState<ArrayList<Product>> {
        val repository = ProductsRepository()
        return repository.getProducts()
    }

}