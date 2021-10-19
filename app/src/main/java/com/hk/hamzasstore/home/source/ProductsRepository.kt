package com.hk.hamzasstore.home.source

import com.hk.hamzasstore.commons.models.Product
import com.hk.hamzasstore.commons.source.RetrofitBuilder
import com.hk.hamzasstore.commons.utilities.ResponseState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductsRepository {
    suspend fun getProducts(): ResponseState<ArrayList<Product>> {
        val retrofit = RetrofitBuilder.getInstance()
        val apiService: ProductEndpoints = retrofit.create(ProductEndpoints::class.java)
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getProducts().execute()
                if (response.isSuccessful)
                    ResponseState.success(response.body())
                else
                    ResponseState.error(response.message(), ResponseState.ErrorType.CUSTOM_ERR)
            } catch (e: Exception) {
                ResponseState.error(
                    "Unknown Error Occurred",
                    ResponseState.ErrorType.UNKNOWN_ERR
                )
            }
        }
    }

    suspend fun getProductById(id: Int): ResponseState<Product> {
        val retrofit = RetrofitBuilder.getInstance()
        val apiService: ProductEndpoints = retrofit.create(ProductEndpoints::class.java)
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.getProduct(id).execute()
                if (response.isSuccessful)
                    ResponseState.success(response.body())
                else
                    ResponseState.error(response.message(), ResponseState.ErrorType.CUSTOM_ERR)
            } catch (e: Exception) {
                ResponseState.error(
                    "Unknown Error Occurred",
                    ResponseState.ErrorType.UNKNOWN_ERR
                )
            }
        }
    }
}