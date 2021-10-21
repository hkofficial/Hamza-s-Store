package com.hk.hamzasstore.cart.source

import com.hk.hamzasstore.App
import com.hk.hamzasstore.cart.model.Cart
import com.hk.hamzasstore.commons.source.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class CartLocalDataSource {
    fun getCartItems(): Flow<List<Cart>> {
        val db = AppDatabase.getDatabase(App.instance.applicationContext)
        return db.cartDao().getAllCartItems()
    }

    suspend fun insertCartItem(cart: Cart) {
        withContext(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(App.instance.applicationContext)
            db.cartDao().insertItemToCart(cart)
        }
    }

    suspend fun getCartById(id: Int): Cart?{
        return withContext(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(App.instance.applicationContext)
            return@withContext db.cartDao().getCartItemById(id)
        }
    }

}