package com.hk.hamzasstore.home.source

import com.hk.hamzasstore.commons.models.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface ProductEndpoints {
    @GET("products")
    fun getProducts(): Call<ArrayList<Product>>

    @GET("products/{productId}")
    fun getProduct(@Path("productId") productId: Int): Call<Product>

}