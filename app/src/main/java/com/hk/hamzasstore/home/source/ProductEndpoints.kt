package com.hk.hamzasstore.home.source

import com.hk.hamzasstore.home.Product
import retrofit2.Call
import retrofit2.http.GET


interface ProductEndpoints {
    @GET("products")
    fun getProducts(): Call<ArrayList<Product>>

}