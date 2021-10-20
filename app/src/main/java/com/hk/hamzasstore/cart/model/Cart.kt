package com.hk.hamzasstore.cart.model

data class Cart(
    val id: Int,
    val title: String,
    val price: Double,
    val image: String,
    val quantity: Int,
)
