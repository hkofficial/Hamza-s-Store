package com.hk.hamzasstore.cart.source

import androidx.room.Dao
import androidx.room.Query
import com.hk.hamzasstore.cart.model.Cart
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {
    @Query("SELECT * FROM cart")
    fun getAllCartItems(): Flow<List<Cart>>

}