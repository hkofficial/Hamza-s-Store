package com.hk.hamzasstore.cart.domain

import com.hk.hamzasstore.cart.model.Cart
import com.hk.hamzasstore.cart.source.CartLocalDataSource
import com.hk.hamzasstore.commons.utilities.UseCase
import kotlinx.coroutines.flow.Flow

class GetCartListUseCase : UseCase<GetCartListUseCase.RequestValues, Flow<List<Cart>>>() {
    class RequestValues : UseCase.RequestValues

    override suspend fun executeUseCase(requestValues: RequestValues?): Flow<List<Cart>> {
        val cartDataSource = CartLocalDataSource()
        return cartDataSource.getCartItems()
    }

}