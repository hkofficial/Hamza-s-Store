package com.hk.hamzasstore.cart.domain

import com.hk.hamzasstore.cart.model.Cart
import com.hk.hamzasstore.cart.source.CartLocalDataSource
import com.hk.hamzasstore.commons.models.Product
import com.hk.hamzasstore.commons.utilities.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddProductToCartUseCase : UseCase<AddProductToCartUseCase.RequestValues, Unit>() {
    class RequestValues(val product: Product) : UseCase.RequestValues

    override suspend fun executeUseCase(requestValues: RequestValues?) {
        requestValues?.product?.let {
            withContext(Dispatchers.IO) {
                val cartDataSource = CartLocalDataSource()
                var qty = 1
                val cartItem = cartDataSource.getCartById(it.id)
                cartItem?.let {
                    qty += it.quantity
                }
                val cart = Cart(it.id, it.title, it.price, it.image, qty)
                cartDataSource.insertCartItem(cart)
            }
        }

    }

}