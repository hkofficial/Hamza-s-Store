package com.hk.hamzasstore.cart.presentation

import androidx.lifecycle.*
import com.hk.hamzasstore.cart.domain.GetCartListUseCase
import com.hk.hamzasstore.cart.model.Cart
import kotlinx.coroutines.launch

class CartViewModel : ViewModel() {
    private val cartList: MutableLiveData<ArrayList<Cart>> by lazy { MutableLiveData<ArrayList<Cart>>() }

    init {
        viewModelScope.launch {
            val getCartListUseCase = GetCartListUseCase()
            val response = getCartListUseCase.executeUseCase()
           cartList.value = response.asLiveData().value?.toCollection(ArrayList())
        }
    }
    fun getCartList():LiveData<ArrayList<Cart>>{
        return cartList
    }
}