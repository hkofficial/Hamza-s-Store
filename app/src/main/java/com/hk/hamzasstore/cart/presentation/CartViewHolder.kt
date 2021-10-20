package com.hk.hamzasstore.cart.presentation

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hk.hamzasstore.cart.model.Cart
import com.hk.hamzasstore.databinding.CartItemBinding

class CartViewHolder(
    private val binding: CartItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(cart: Cart) {

        binding.cartItem = cart

        Glide.with(binding.root.context).load(cart.image).into(binding.productImage)

    }
}