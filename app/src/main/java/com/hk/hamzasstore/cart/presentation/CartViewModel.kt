package com.hk.hamzasstore.cart.presentation

import android.util.Log
import androidx.lifecycle.*
import com.hk.hamzasstore.cart.domain.GetCartListUseCase
import com.hk.hamzasstore.cart.model.Cart
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val cartList: MutableLiveData<ArrayList<Cart>> by lazy { MutableLiveData<ArrayList<Cart>>() }

    init {
        viewModelScope.launch {
            val getCartListUseCase = GetCartListUseCase()
            val response = getCartListUseCase.executeUseCase()
            response.collect {
                cartList.value = it.toCollection(ArrayList())
            }
        }
    }
    fun getCartList():LiveData<ArrayList<Cart>>{
        return cartList
    }
}